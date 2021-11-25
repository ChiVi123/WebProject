function Reset(options) {
	var formElement = document.querySelector(options.form);
	var resetElement = document.querySelector(options.resetButton);

	if (resetElement) {

		resetElement.onclick = function() {
			console.log("click reset button");
			if (formElement) {

				formElement.onsubmit = function(e) {

					e.preventDefault();
					window.location.reload();
				}
			}
		}
	}
}