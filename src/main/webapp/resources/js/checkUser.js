


$(document).ready(function() {  

	
 $('#cusname').blur(function(){

            
       var username = $('#cusname').val();  
  
     
        $.get("check",{username:username},function(result){
            if(result=="1"){
            	 $("#sgupsmt").attr("disabled", true);
            	 $('#cusname').css('border-color', 'red');
            	 	$("#check").html("Username exists");
            	 	}
            else{
            	$("#check").html("Username Accepted"); 
            	$('#cusname').css('border-color', '');
            	$("#sgupsmt").removeAttr("disabled");
            
            }
            });
        }); });
          
  