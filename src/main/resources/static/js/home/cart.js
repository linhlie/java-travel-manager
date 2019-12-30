(function () {
    var _login;
    var array  = [];
    var cate=[];
    $(function () {
        sessionLogin();
        checkCart();
        loadDataOrder();
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
        if (string==null||string==""){
            $(".test_cart").remove();
            htmlCart="";
        }

        else {
            array = string.split(",");
            if (array.length > 0) {
                loadDataCart(string)
                var htmlCart = '<a href="/cart"><i class="fa fa-shopping-cart" style="font-size: 25px;"></i><span class="shop-cart"> <span class="secondary">' + array.length + '</span></span></a>'
            }
        }
        $(".test_cart").html(htmlCart);
    }
    function loadDataCart(data) {
        var _htmlCart="";
        console.log(data)
        function onSuccess(response) {
            if (response&&response.status){
                console.log(response)
                var toursCart =[];
                toursCart =response.toursCart;
                for (var i=0;i<toursCart.length;i++) {
                    var discount = toursCart[i].discount*100;
                    var html = '<tr>' +
                        '<th scope="row" class="border-0">' +
                        '<div class="p-2">' +
                        '<img src="images/icon/airplane.png" alt="" width="70" class="img-fluid rounded shadow-sm" style="height: 40px;width: 40px;">' +
                        '<div class="ml-3 d-inline-block align-middle">' +
                        '<h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">' + toursCart[i].tourName + '</a></h5>' +
                        '</div> </div></th>' +
                        '<td class="border-0 align-middle"><strong>' + toursCart[i].price + '$</strong></td>' +
                        '<td class="border-0 align-middle"><strong>' + discount + '%</strong></td>' +
                        '<td class="border-0 align-middle"><strong>' + toursCart[i].departureDate + '</strong></td>' +
                        '<td class="border-0 align-middle"><strong>' + toursCart[i].totalDays + '</strong></td>' +
                        '<td class="border-0 align-middle"><a href="#" class="text-dark"><i class="fa fa-trash"></i></a></td>' +
                        '</tr>';
                    _htmlCart += html;

                }
                var _html='<tr>' +
                    '<th scope="row" class="border-0">' +
                    '<div class="p-2">' +
                    '<img src="" alt="" width="70" class="img-fluid rounded shadow-sm" style="height: 40px;width: 40px;">' +
                    '<div class="ml-3 d-inline-block align-middle">' +
                    '<h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle"></a></h5>' +
                    '</div> </div></th>' +
                    '<td class="border-0 align-middle"><strong></strong></td>' +
                    '<td class="border-0 align-middle"><strong></strong></td>' +
                    '<td class="border-0 align-middle"><strong></strong></td>' +
                    '<td><button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal">Đặt ngay</button></td>'+
                    '<td><button type="button" class="btn btn-success removeAll" data-toggle="modal" data-target="#myModal">Xóa hết</button></td>'+
                    '</tr>';
                _htmlCart+=_html;
                $(".table-cart").html(_htmlCart);
            }
        }
        function onError() {
            console.log("load data cart fail!")
        }
        getCart(data,onSuccess,onError);
    }

    $(document).on("click",".removeAll", function () {
        localStorage.clear(_login);
        checkCart();
        var html="";
        $(".table-cart").html(html);
    });
    $(document).on("click",".paid", function () {

        var String = "15101998,123456,12578";
        loadPaid(String)
        function loadPaid() {
            // function onSuccess(res) {
            //     if (res&&res.status){
            //         alert("OK")
            //     }
            // }
            // function onError(error) {
            //     console.log(error)
            // }
            $.ajax({
                type: "GET",
                contentType: "application/json",
                url: "http://localhost:9999/bank/users/"+String,
                crossDomain : true,
                cache: false,
                timeout: 600000,
                success : function(data) {
                    alert("OK")
                },
                error : function(e) {
                    alert(e);
                }
            });

        }
    });
    function loadDataOrder() {
        var _htmlOrder="";
        var orders =[];
        function onSuccess(response) {
            if (response&&response.status){
                console.log(response)
                orders=response.orders;
                if (orders.length>0){
                    for (var i =0;i<orders.length;i++){
                        var id = orders[i].tourId;
                        loadTour(id);
                        function loadTour(id) {
                            function onSuccess(res) {
                                if (res&&res.status){
                                    var tour = res.tour;
                                    var  discount = tour.discount*100;
                                    var html1= '<tr>' +
                                        '<th scope="row" class="border-0">' +
                                        '<div class="p-2">' +
                                        '<img src="images/icon/airplane.png" alt="" width="70" class="img-fluid rounded shadow-sm" style="height: 40px;width: 40px;">' +
                                        '<div class="ml-3 d-inline-block align-middle">' +
                                        '<h5 class="mb-0"> <a href="#" class="text-dark d-inline-block align-middle">' + tour.tourName + '</a></h5>' +
                                        '</div> </div></th>' +
                                        '<td class="border-0 align-middle"><strong>' + tour.price + '$</strong></td>' +
                                        '<td class="border-0 align-middle"><strong>' + discount + '%</strong></td>' +
                                        '<td class="border-0 align-middle"><strong>' + tour.departureDate + '</strong></td>' +
                                        '<td class="border-0 align-middle"><strong>' + tour.totalDays + '</strong></td>' +
                                        '<td class="border-0 align-middle"><a href="#" class="text-dark"><i class="fa fa-trash"></i></a></td>' +
                                        '</tr>';
                                }
                                _htmlOrder+=html1;
                                $(".table-cart-order").html(_htmlOrder);
                            }
                            function onError(error) {

                            }
                            getTourDetails(id, onSuccess, onError)

                        }
                    }

                    var html2= '<button type="button" class="btn btn-success" data-toggle="modal" data-target="#myModal" style="margin-right: 60px;">Đặt ngay</button>'+
                        '<button type="button" class="btn btn-success removeAll" data-toggle="modal" data-target="#myModal">Xóa hết</button>';
                    // $(".table-cart-footer").html(html2);

                }

            }

        }
        function onError(error) {
            console.log(error);
        }
        getOrdersByEmail(_login,onSuccess,onError);

    }

})(jQuery);