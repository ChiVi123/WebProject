/**
 * 
 */
function Loading(options, settime) {
	var loadElement = document.getElementById(options.load);
	var formElement = document.getElementById(options.form);
	console.log(loadElement);
	console.log(formElement);

	setTimeout(function() {
		loadElement.style.display = "none";
		formElement.style.display = "block";
	}, settime);
}