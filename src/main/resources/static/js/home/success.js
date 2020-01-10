(function () {
    $(function () {
        sessionLogin()
    });
    function sessionLogin() {
        var login = sessionStorage.getItem("login");
        localStorage.clear("cus")
        localStorage.clear("orders")
        localStorage.clear(login);

    }
})(jQuery);