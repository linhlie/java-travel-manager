(function () {
    var result;
    var userId=0;
    $(function () {
        loadListTours();
        var accountText = document.getElementById("account")
        var account = accountText.textContent;
        console.log(account)
        if (account!=null){
            $('#login-form').addClass("hidden");
            $('#sign-up').addClass("hidden")
            $('#logout').removeClass("hidden")
        }
        else {
            $('#login-form').removeClass("hidden");
            $('#sign-up').removeClass("hidden")
            $('#logout').addClass("hidden")
        }
    });
    function loadListTours() {

        function onSuccess(response) {
            if(response && response.status){
            }
        }
        function onError(error) {
            console.error("loadEmailSender fail");
        }

        getListTours(onSuccess, onError);
    }


})(jQuery);