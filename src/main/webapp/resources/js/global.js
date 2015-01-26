$(document).ready(function(){
	$('.moretxtBtn').click(function(){
		//get collapse content selector
		var collapse_content_selector = $(this).attr('href');					
		
		//make the collapse content to be shown or hide
		var toggle_switch = $(this);
		$(collapse_content_selector).toggle(function(){
			if($(this).css('display')=='none'){
				toggle_switch.html('More');//change the button label to be 'Show'
			}else{
				toggle_switch.html('Less');//change the button label to be 'Hide'
			}
		});
	});
	
   //slideshow start
    $("#slider1").responsiveSlides({
        maxwidth: 1920,
        speed: 2000
      });
	
	//accordion
	
$( "#accordion" ).accordion({
      collapsible: true,
      active: false
});
$( "#foo-accordion" ).accordion({
      collapsible: true,
      active: false
});
	
	//search droplist
	var availableTags = [
"Alabama",
"Alaska",
"Bangalore",
"Birmingham",
"Bristol",
"Cambridge",
"Durham",
"Florida",
"Georgia",
"Glasgow",
"Hawaii",
"Indiana",
"Kolkata",
"Londan",
"Manchester",
"Mumbai",
"New Delhi",
"New Mexico",
"New Hampshire",
"New Jersey",
"New York",
"Ohio",
"San Francisco",
"Texas",
"Washington"
];
$( "#cityfrom" ).autocomplete({
source: availableTags
});
$( "#cityto" ).autocomplete({
source: availableTags
});
$( "#childfor" ).autocomplete({
source: availableTags
});
	  
var months = ["January", "February", "March", "April", "May", "June",
                  "July", "August", "September", "October", "November", "December"];
var uDatepicker = $.datepicker._updateDatepicker;
$.datepicker._updateDatepicker = function() {
    var ret = uDatepicker.apply(this, arguments);
    var $sel = this.dpDiv.find('select');
    $sel.find('option').each(function(i) {
        $(this).text(months[i]);
    });
    return ret;
};

$(function() {
    $("#idfrom").datepicker({
        changeMonth: true,
        dateFormat: 'MM dd, yy'
    });
	$("#idto").datepicker({
        changeMonth: true,
        dateFormat: 'MM dd, yy'
    });
});
	
});

 