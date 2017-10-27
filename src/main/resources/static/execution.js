/**
 * 
 */

$(function() {
	
	var counterRecord = 0;
	$(".record-add").click(function(){
		var id = $(this).attr("data");
		var input ="<input type='text' class='btn btn-success col-xs-2' readonly='readonly' value='"+id+"' name='idRecord'/>" 
		$("#recordsAdded").append(input);
		$(".createExecution").prop("disabled", false)
		counterRecord++;
		
	});
	
	$("#execute").click(function(){
		
		var url = "/execute";
		var process =  $(this).attr("");
		
	});
	
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
