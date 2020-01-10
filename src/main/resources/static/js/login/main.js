
(function ($) {
    $(document).on("click",".confirm-code", function () {
        var content = $("#confirm").val();
        $("#wrong").attr("style", "display: none;");
        confirmUser(content)
        console.log(content)
        function confirmUser(content) {
            function onSuccess(res) {
                if (res&&res.status){
                    window.location.replace("http://localhost:8888/order/success");
                }
                else {
                    $("#wrong").removeAttr("style", "display: none;");
                    $("#wrong").attr("style", "    text-align: center;\n" +
                        "    color: black;\n" +
                        "    font-size: 20px;\n" +
                        "    font-weight: bold;");

                }

            }
            function onError(e) {
                console.log(e)
            }
            getConfirm(content,onSuccess,onError)

        }
    });

    "use strict";

    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;
        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });

    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    
    

})(jQuery);