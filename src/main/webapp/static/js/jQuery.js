$(function(){
	
	$.each($(".table tr:not(:first)"), function (i, el) {
        $(this).find("td:first").text(i + 1);
	});

});