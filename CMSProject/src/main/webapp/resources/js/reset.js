function Reset(options) {
	var formElement = document.querySelector(options.form);
	var buttonElement = document.querySelector(options.resetButton);

	if (buttonElement) {
		
		buttonElement.onclick = function() {
			console.log("true");
			if (formElement) {
				
				formElement.onsubmit = function(e) {
					
					e.preventDefault();
					window.location.reload();
				}
			}
		}

	}

}