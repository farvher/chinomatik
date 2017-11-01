/**
 * 
 */

$(function() {
	
	var counterRecord = 0;
	/**
	 * Add records to the executions box
	 * */
	$(".record-add").click(function(){
		var id = $(this).attr("data");
		var input ="<input type='button'  value='"+id+"' class='btn btn-success' readonly='readonly'/>"
		var inputHidden = "<input type='hidden'  value='"+id+"' name='idRecord'/>"
		$("#recordsAdded").append(input);
		$("#recordsAdded").append(inputHidden);
		$(".createExecution").prop("disabled", false)
		counterRecord++;
		
	});
	
	/**
	 * Execute a single record
	 * */
	$(".single-record").click(function(){
		var id = $(this).attr("data");
		sendAjax("/execute-record", {id:id}, "post", function(){console.log("executing ...")});
	});
	
	/**
	 * Execute a execution
	 * */
	$(".ex-execute").click(function(){
		var id = $(this).attr("data");
		sendAjax("/execute-execution", {id:id}, "post", function(){console.log("executing ...")});
	})
	
	/**
	 * delete a execution*/
	$(".ex-delete").click(function(){
		var id = $(this).attr("data");
		var fn = function(){
			location.reload();
		}
		sendAjax("/delete-execution", {id:id}, "post", fn);
		
	})
	
	/**
	 * Delete a single record
	 * */
	$(".rec-delete").click(function(){
		var id = $(this).attr("data");
		var fn = function(){
			location.reload();
		}
		sendAjax("/delete-record", {id:id}, "post", fn);
		
	})
	/**
	 * Delete all records 
	 * */
	$(".rec-delete-all").click(function(){
		var fn = function(){
			location.reload();
		}
		sendAjax("/delete-all", {}, "post", fn);
	})
	
	/**
	 * activate listener with ajax
	 * */
	$(".activate-robot").click(function(){
		var fn = function(){
			window.location.href="/";
		}
		sendAjax("/activar",{},"get",fn);
	})


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
