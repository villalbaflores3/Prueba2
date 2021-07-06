$(document).ready(function(){




urls();

    function urls() {
        var URLactual = jQuery(location).attr('href');
        var url =  URLactual.substr(-13) ;

        if (url == "empleado/f") {

            $("#password-user").removeAttr("disabled");
            
        } else {
            
        }
    
    }




    $( "#btn-password").click(function() {

            var numeroAlatorio = random(10,50);
            $("#password-user").val("apply" + numeroAlatorio);
     
        })





    function random(min, max) {
        return Math.floor((Math.random() * (max - min + 1)) + min);
    }

});