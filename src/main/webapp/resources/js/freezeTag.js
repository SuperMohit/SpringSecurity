$("a.rflag").click(function(){
		
    $("a.rflag").filter(".active").removeClass("active");
	$("ul").filter("#re").removeClass("f32");
	$("li").filter("#si").removeClass();
	$("li").filter("#up").removeClass();
	$("li").filter(".rflag").css({'opacity':'.3'});
	$(this).addClass("active");
	$(this).parent().css({'opacity':'1'});
	$("ul").filter("#re").addClass("f32");
	$("li").filter("#si").addClass($(this).parent().attr("class"));
	$("li").filter("#up").addClass($(this).parent().attr("class"));
});
$("a.oflag").click(function(){
		
		
    $("a.oflag").filter(".active").removeClass("active");
	$("ul").filter("#re").removeClass("f32");
	$("li").filter("#dwn").removeClass();
	$("li").filter("#or").removeClass();
	$("li").filter(".oflag").css({'opacity':'.3'});
	$(this).addClass("active");
	$(this).parent().css({'opacity':'1'});
	$("ul").filter("#re").addClass("f32");
	$("li").filter("#or").addClass($(this).parent().attr("class"));
	$("li").filter("#dwn").addClass($(this).parent().attr("class"));
});
$("a.lflag").click(function(){
		
    $("a.lflag").filter(".active").removeClass("active");
	
	$("li").filter(".language").css({'opacity':'.3'});
	$(this).addClass("active");
	$(this).parent().css({'opacity':'1'});
	$("ul").filter("#re").addClass("f32");
	$("span").filter("#lang").empty().append($(this).html());
});
$("a.cflag").click(function(){
		$("ul").filter("#re").removeClass("f32");
	$("li").filter("#cur").removeClass();
    $("a.cflag").filter(".active").removeClass("active");
	$("li").filter(".cflag").css({'opacity':'.3'});
	$(this).addClass("active");
	$(this).parent().css({'opacity':'1'});
	$("ul").filter("#re").addClass("f32");
	$("li").filter("#cur").addClass($(this).parent().attr("class"));
});