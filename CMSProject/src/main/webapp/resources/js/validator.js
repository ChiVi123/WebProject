/**
 * 
 */
//
//options la doi tuong bao gom form va rules
function Validator(options) {
  //the con duoc chua trong the cha theo CSS selector
  function getParent(element, selector) {
    while (element.parentElement) {
      if (element.parentElement.matches(selector)) {
        return element.parentElement;
      }

      element = element.parentElement;
    }
  }

  //luu tat ca cac rule
  var selectorRules = {};
  //xu ly xoa message
  //xu ly xac nhan cac truong co hop le hay khong
  function validate(inputElement, rule) {
    var errorMessage;
    var errorElement =
		getParent(inputElement, options.formGroup).querySelector(options.errorSelector);
    //lay cac rule cua selector
    var rules = selectorRules[rule.selector];
    //lap ra tung rule va kiem tra
    for (var i = 0; i < rules.length; i++) {      
      errorMessage = rules[i](inputElement.value);

      if (errorMessage) {
        break;
      }
    }

    if (errorMessage) {
      errorElement.innerText = errorMessage;
      getParent(inputElement, options.formGroup).classList.add("invalid");
    } else {
      errorElement.innerText = "";
      getParent(inputElement, options.formGroup).classList.remove("invalid");
    }

    return !errorMessage;
  }

  //lay element can validate
  var formElement = document.querySelector(options.form);

  if (formElement) {
    formElement.onsubmit = function (e) {
      e.preventDefault();

      var isFormValid = true;
      options.rules.forEach(function (rule) {
        //validate tung rule
        var inputElement = formElement.querySelector(rule.selector);
        var isValid = validate(inputElement, rule);

        if (!isValid) isFormValid = false;
      });

      if (isFormValid) {
        if (typeof options.onSubmit === "function") {
          //trường hợp submit dùng javascript
          //disabled không cho tương tác với input [name]:not([disabled])
          var enableInput = formElement.querySelectorAll("[name]");
          var formValues = Array.from(enableInput).reduce(function (values, input) {            
            values[input.name] = input.value;
            return values;
          }, {});

          options.onSubmit(formValues);
        }
        //submit mặc định
        else {
          formElement.submit();
        }
      }
    };

    //lap qua tung rule va xử lý sau khi lắng nghe sự kiện
    options.rules.forEach(function (rule) {
      //luu cac rule moi input
      if (Array.isArray(selectorRules[rule.selector])) {
        selectorRules[rule.selector].push(rule.test);
      } else {
        selectorRules[rule.selector] = [rule.test];
      }
      //rule la mot doi tuong
      var inputElement = formElement.querySelector(rule.selector);

      if (inputElement) {
        //xu ly khi dau nhay roi khoi input
        inputElement.onblur = function () {
          validate(inputElement, rule);
        };

        //xu ly khi dang nhap vao input
        inputElement.oninput = function () {
          var errorElement = 
			getParent(inputElement, options.formGroup).querySelector(options.errorSelector);
          errorElement.innerText = "";
          getParent(inputElement, options.formGroup).classList.remove("invalid");
        };
      }
    });
    //console.log(selectorRules);
  }
}

//rules
//khong hop le tra ve thong bao
//hop le thi khong tra ve gi (undefined)
Validator.isRequired = function (selector, message) {
  return {
    selector: selector,
    test: function (value) {
      return value ? undefined : message || "Vui long nhap truong nay";
      /* return value.trim() ? undefined : message || "Vui long nhap truong nay"; */
    },
  };
};

Validator.isEmail = function (selector, message) {
  return {
    selector: selector,
    test: function (value) {
      var regex = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
      return regex.test(value) ? undefined : message || "Truong nay la email";
    },
  };
};

Validator.checkLength = function (selector, min, max, message) {
  return {
    selector: selector,
    test: function (value) {
	var range = !!(value.length >= min && value.length <= max);
	console.log(value.length);
	console.log(range);
    return range ? undefined : message || `Nhap lon hon ${min} ky tu va nho hon ${max} ky tu`;
    },
  };
};

Validator.isComfirmed = function (selector, getComfirm, message) {
  return {
    selector: selector,
    test: function (value) {
      return value === getComfirm() ? undefined : message || "Gia tri nhap khong chinh xac!!!";
    },
  };
};
