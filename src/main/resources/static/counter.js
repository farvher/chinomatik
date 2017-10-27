/**
 * 
 */
function isRecording() {

				$.ajax({
					url : "/recording/",
					method : "get",
					contentType : 'application/json',
					success : function(data) {
						$("#activar").addClass(data ? "active" : "");
						$("#activar").text(data ? "Activo" : "Activar");
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

			$(document).ready(function() {
				isRecording();
				getCount();
				window.setInterval(function() {
					getCount()
				}, 1000);
			})