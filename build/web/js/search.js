$(document).ready(function () {
	
	$("#search").keyup(function () {
		var searchValue=$("#search").val();
		
		
		searchEmploye(searchValue);
	});
	
});



function searchEmploye(searchValue){
	$.post("search",{"txtsearch":searchValue}
	,function (data,status) {
		$("#costumers").html(data);
		
	});
};