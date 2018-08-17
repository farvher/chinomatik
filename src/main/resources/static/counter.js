/**
 * 
 */
function isRecording() {

	$.ajax({
		url : "/recording/",
		method : "get",
		contentType : 'application/json',
		success : function(data) {
			$("#activar").removeClass("active");
			$("#activar").addClass(data ? "active" : "");
			$("#activar").text(data ? "Activo" : "Activar F10");
		},
		error : function(er) {
			console.log("error: " + er);

		}
	})
}
function getCount() {

	$.ajax({
		url : "/count",
		method : "get",
		contentType : 'application/json',
		success : function(data) {
			$("#count").html(data);
		},
		error : function(er) {
			console.log("error: " + er);

		}
	})
}

function currentExecution() {

	$.ajax({
		url : "/current-execution",
		method : "post",
		success : function(data) {
			$(".ex-current ").removeClass("btn-success");
			$(".ex-current [value='"+data+"']").addClass("btn-success");

		},
		error : function(er) {
			console.log("error: " + er);
		}
	})
}

$(document).ready(function() {
	isRecording();
	getCount();
	window.setInterval(function() {
		getCount();
		currentExecution();
		isRecording();
	}, 1000);
})