/**
 * 
 */
const rmCheck = document.getElementById("rememberMe"),
    emailInput = document.getElementById("email");
  passwordInput = document.getElementById("pass");

if (localStorage.checkbox && localStorage.checkbox !== "") {
  rmCheck.setAttribute("checked", "checked");
  emailInput.value = localStorage.username;
 passwordInput.value= localStorage.password;
} else {
  rmCheck.removeAttribute("checked");
  emailInput.value = "";
 passwordInput.value="";
}

function lsRememberMe() {
  if (rmCheck.checked && emailInput.value !== "") {
    localStorage.username = emailInput.value;
   localStorage.password=passwordInput.value;
    localStorage.checkbox = rmCheck.value;
  } else {
    localStorage.username = "";
    localStorage.password ="";
    localStorage.checkbox = "";
  }
}