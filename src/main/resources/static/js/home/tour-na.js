(function () {
    var htmlTour="";
    var _login;
    $(function () {
        loadListToursNA();
        loadListNews();
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

    function loadListToursNA() {
        $("#toursNA").removeAttr("style", "");

        function onSuccess(response) {
            if(response && response.status){
                var tours=[];
                tours =response.tours;
                var imagesTours=[];
                imagesTours=response.imagesTours;
                var j=0;
                for (var i=0;i<tours.length;i++){
                    var hmtl= '<div class="offers_item rating_4">'+
                        '<div class="row">'+
                        '<div class="col-lg-1 temp_col"></div>'+
                        '<div class="col-lg-3 col-1680-4">'+
                        '<div class="offers_image_container">'+
                        '<div class="offers_image_background" style="background-image:url('+imagesTours[j].imageUrl+')"></div>'+
                        '<div class="offer_name test "data-id="'+tours[i].tourId+'"><a href="/details.html">Xem chi tiết</a></div>'+
                        '</div>'+
                        '</div>'+
                        '<div class="col-lg-8">'+
                        '<div class="offers_content">'+
                        '<div class="offers_price" style="font-size: 20px;font-weight: bold"><div class="test" id="testid" data-id="'+tours[i].tourId+'"><a href="/details.html" >'+tours[i].tourName+'<span></span></a></div></div>'+
                        '<div class="rating_r rating_r_4 offers_rating" data-rating="4">'+
                        '<i></i> <i></i><i></i><i></i><i></i>'+
                        '</div>'+
                        '<p class="offers_text">'+tours[i].tourSummary+'</p>'+
                        '<div class="offers_icons">'+
                        '<ul class="offers_icons_list" style="margin-bottom: 20px">'+
                        '<li class="offers_icons_item"><img src="images/post.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/compass.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/bicycle.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/sailboat.png" alt=""></li>'+
                        '</ul>'+
                        '</div>'+
                        '<div class="cart"><button data-id="'+tours[i].tourId+'" class="add_cart" style="border: #c80000"><span style="margin-top: 10px">' +
                        '<img style="width: 30px;height: 30px" src="images/icon/cart.png"> Thêm giỏ hàng</span></button></div>'+
                        '<div class="offer_reviews">'+
                        '<div class="offer_reviews_content">'+
                        '<div class="offer_reviews_title">very good</div>'+
                        '<div class="offer_reviews_subtitle">100 reviews</div>'+
                        '</div>'+
                        '<div class="offer_reviews_rating text-center">8.1</div>'+
                        '</div></div></div></div></div>';

                    htmlTour+=hmtl;
                    j+=3;
                }
                console.log(response);
                $(".offers_grid").html(htmlTour);
            }
        }
        function onError(error) {
            console.error("load data fail!");
        }

        getListToursNA(onSuccess, onError);
    }

    $(document).on("click",".test", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("dataId",dataId)
    });

    var tourIds =[];
    var id_check;

    $(document).on("click",".add_cart", function () {
        if (sessionLogin()){
            var dataId = $(this).attr("data-id");
            if(tourIds.length==0){
                tourIds.push(dataId);
                localStorage.setItem(_login,tourIds);
                checkCart();
            }
            else {
                if (tourIds.indexOf(dataId)==-1){
                    tourIds.push(dataId);
                    localStorage.setItem(_login,tourIds);
                    checkCart();
                }
                else {
                    alert("Bạn đã thêm tour này vào giỏ hàng trước đó!")
                }
            }

        }
        else {
            alert("Bạn cần phải đăng nhập");
            window.location.replace("http://localhost:8888/login");

        }
    });
    function loadListNews() {

        var htmlNews="";
        function onSuccess(response) {
            if (response && response.status) {
                console.log(response)
                var news=[];
                var images=[];
                images=response._imagesNews;
                news=response.news;

                var j =0;
                for (var i=0;i<3;i++){
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var html = '<div class="footer_blog_item clearfix">'+
                        '<div class="footer_blog_image"><img src="'+images[j].image_url+'" alt="https://unsplash.com/@avidenov"></div>'+
                        '<div class="footer_blog_content">'+
                        '<div class="footer_blog_title detail_news" data-id="'+news[i].news_id+'"><a href="news-detail">'+news[i].name+'</a></div>'+
                        '<div class="footer_blog_date">'+res+'</div>'+
                        '</div>'+
                        '</div>';

                    j+=3;
                    htmlNews+=html;
                }
                $(".footer_blog").html(htmlNews);
            }

        }

        function onError(error) {
            console.error("load data fail!");
        }

        getListNews(onSuccess, onError);
    }
    $(document).on("click",".detail_news", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("newsId",dataId)
    });
    function checkCart() {
        var login = sessionStorage.getItem("login");
        var string = localStorage.getItem(login);
        var array = string.split(",");
        tourIds=array;
        console.log(array.length)
        if (array.length>0){
            var htmlCart= '<a href="/cart"><i class="fa fa-shopping-cart" style="font-size: 25px;"></i><span class="shop-cart"> <span class="secondary">'+array.length+'</span></span></a>'
        }
        $(".test_cart").html(htmlCart);
    }

})(jQuery);