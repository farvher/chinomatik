/**
 * 
 */

$(function() {
	
	var counterRecord = 0;
	$(".record-add").click(function(){
		var id = $(this).attr("data");
		var input ="<input type='button'  value='"+id+"' class='btn btn-success' readonly='readonly'/>"
		var inputHidden = "<input type='hidden'  value='"+id+"' name='idRecord'/>"
		$("#recordsAdded").append(input);
		$("#recordsAdded").append(inputHidden);
		$(".createExecution").prop("disabled", false)
		counterRecord++;
		
	});
	
	$(".single-record").click(function(){
		var id = $(this).attr("data")
		sendAjax("/execute-record", {id:id}, "post", function(){console.log("executing ...")});
	});
	
	$(".ex-execute").click(function(){
		var id = $(this).attr("data")
		sendAjax("/execute-execution", {id:id}, "post", function(){console.log("executing ...")});
	})
	
	$.fn.executeRobot = function(){
		sendAjax(url, data, "post", function(){console.log("executing ...")});
	};
	

	function sendAjax(url, data, method, func) {
		$.ajax({
			url : url,
			data : data,
			type : method,
			success : func,
			error : function(e) {
				console.log(e)
			}
		});

	}

})
