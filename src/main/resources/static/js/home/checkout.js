(function () {
    var _login;
    var array  = [];
    var cate=[];
    var idUser;
    $(function () {
        sessionLogin();
        checkCart();
    });

    function sessionLogin() {
        var login = sessionStorage.getItem("login");
        _login =login;
        if(login!=null){
            loadUser(login);
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
        var orders = localStorage.getItem("orders");
        console.log(orders)
        if (string==null||string==""){
            $(".test_cart").remove();
            htmlCart="";
            loadDataCart(orders)
        }

        else {
            array = string.split(",");
            if (array.length > 0) {
                loadDataCart(orders)
                var htmlCart = '<a href="/cart"><i class="fa fa-shopping-cart" style="font-size: 25px;"></i><span class="shop-cart"> <span class="secondary">' + array.length + '</span></span></a>'
            }
        }
        $(".test_cart").html(htmlCart);
    }
    function loadUser(login) {
        var email = login;
        function onSuccess(response) {
            if (response && response.status){
                console.log(response)
                var userText = response.jsonUser;
                var user  = [];
                user = userText.split(",");
                $("#id").val(user[0]);
                $("#email").val(user[1]);
                $("#phone").val(user[2]);
                $("#fullName").val(user[3]);
                $("#birthday").val(user[4]);
            }
        }
        function onError(error) {
            console.error("load data fail!");
        }


        getUser(email, onSuccess, onError);
    }
    function loadDataCart(data) {
        var _htmlCart="";
        console.log(data)
        function onSuccess(response) {
            if (response&&response.status){
                console.log(response)
                var toursCart =[];
                toursCart =response.toursCart;
                var money=0;
                var bill ="";
                var cus =[];
                if (localStorage.getItem("cus")!=null&&localStorage.getItem("cus")!=undefined){
                    cus = localStorage.getItem("cus").split(",");
                }
                for (var i=0;i<toursCart.length;i++) {
                    var discount = toursCart[i].discount*100;
                    if (cus[i]==null||cus[i]==undefined){
                        cus[i]=1;
                    }
                    var pay = (toursCart[i].price - toursCart[i].price*toursCart[i].discount)*cus[i];
                    money+=pay;
                    bill+=toursCart[i].tourId+'-'+cus[i]+',';

                    var html = '<tr>' +
                        '<th scope="row" class="border-0">' +
                        '<h5 class="mb-0 test" id="testid" data-id="'+toursCart[i].tourId+'"><a href="/details.html" >'+toursCart[i].tourName+'<span></span></a></h5>' +
                        '</div> </div></th>' +
                        '<td class="border-0 align-middle"><strong>' + toursCart[i].price + '$</strong></td>' +
                        '<td class="border-0 align-middle"><strong>' + discount + '%</strong></td>' +
                        '<td class="border-0 align-middle"><strong>'+cus[i]+'</strong></td>' +
                        '<td class="border-0 align-middle"><strong>'+pay+'$</strong></td>' +
                        '</tr>';
                    _htmlCart += html;

                }
                $("#bill").val(bill);
                var _html='<tr>' +
                '<td class="border-0 align-middle"><strong>Tổng tiền</strong></td>' +
                '<td class="border-0 align-middle"><strong>$'+money+'</strong></td>' +
                '</tr>';
                _htmlCart+=_html;
                $(".table-order").html(_htmlCart);
            }
        }
        function onError() {
            console.log("load data cart fail!")
        }
        getCart(data,onSuccess,onError);
    }
    $(document).on("click",".test", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("dataId",dataId)
    });

    $(document).on("click",".delete-trash", function () {
        var dataId = $(this).attr("data-id");
        var string = localStorage.getItem(_login);
        var data=[];
        data = string.split(",");
        data = jQuery.grep(data, function(value) {
            return value != dataId;
        });
        localStorage.setItem(_login,data);
        location.reload();
    });

})(jQuery);