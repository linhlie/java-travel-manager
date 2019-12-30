(function () {
    var _login;
    $(function () {
        var dataCart = sessionStorage.getItem("dataCart");
        var cartUser = sessionStorage.getItem("idUser");
        console.log(dataCart);
        console.log(cartUser);
        sessionLogin();
        checkCart();
    });

    function sessionLogin() {
        var login = sessionStorage.getItem("login");
        _login =login;
        if(login!=null){
            var html='<a href="/profile">'+login+'</a>';
            $("#login-form").attr("style", "display: none;");
            $("#sign-up").attr("style", "display: none;");
            $("#account").text(login);
            $('#account').removeClass("hidden");
            $('#logout').removeClass("hidden");
            $(".profile").html(html);
            return true;
        }
        else {
            $("#logout").attr("style", "display: none;");
            $("#account").attr("style", "display: none;");
            return false;
        }

    }
    function checkCart() {
        var login = sessionStorage.getItem("login");
        var string = localStorage.getItem(login);
        var array  = [];
        array = string.split(",");
        console.log(array.length)
        if (array.length>0){
            var htmlCart= '<a href="/cart"><i class="fa fa-shopping-cart" style="font-size: 25px;"></i><span class="shop-cart"> <span class="secondary">'+array.length+'</span></span></a>'
        }
        console.log(htmlCart)
        $(".test_cart").html(htmlCart);
    }
})(jQuery);