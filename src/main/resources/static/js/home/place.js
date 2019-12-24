(function () {
    var _login;
    $(function (){
        loadDataPlaces();
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
    function loadDataPlaces() {
        $("#places").removeAttr("style", "");
        var _htmlPlaces="";
        function onSuccess(response) {
            if(response && response.status){
                console.log(response);
                var places =[];
                places =response.places;
                var images = [];

                images=response.imagesPlaces;
                var j=0;
                for (var i=0;i<places.length;i++){
                    var html= '<div class="offers_item rating_3">'+
                        '<div class="row">'+
                        '<div class="col-lg-1 temp_col"></div>'+
                        '<div class="col-lg-3 col-1680-4">'+
                        '<div class="offers_image_container">'+
                        '<div class="offers_image_background" style="background-image:url('+images[j].imageUrl+')"></div>'+
                        '<div class="offer_name places_id "data-id="'+places[i].placeId+'"><a href="/place-detail.html">Xem chi tiết</a></div>'+
                        '</div></div>'+
                        '<div class="col-lg-8">'+
                        '<div class="offers_content">'+
                        '<div class="offers_price" style="font-size: 20px;font-weight: bold"><div class="places_id"  data-id="'+places[i].placeId+'"><a href="/place-detail.html" >'+places[i].placeName+'<span></span></a></div></div>'+
                        '<div class="rating_r rating_r_3 offers_rating" data-rating="3">'+
                        '<i></i><i></i><i></i><i></i><i></i></div>'+
                        '<p class="offers_text">'+places[i].placeSummary+'</p>'+
                        '<div class="offers_icons">'+
                        '<ul class="offers_icons_list" style="margin-bottom: 20px">'+
                        '<li class="offers_icons_item"><img src="images/post.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/compass.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/bicycle.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/sailboat.png" alt=""></li>'+
                        '</ul></div>'+
                        '<div class="offer_reviews">'+
                        '<div class="offer_reviews_content">'+
                        '<div class="offer_reviews_title">very good</div>'+
                        '<div class="offer_reviews_subtitle">100 reviews</div>'+
                        '</div>'+
                        '<div class="offer_reviews_rating text-center">8.1</div>'+
                        '</div> </div></div></div></div>';
                    _htmlPlaces+=html;
                    j+=3;

                }
                $(".offers_grid").html(_htmlPlaces);
            }
        }
        function onError(error) {
            console.error("load data fail!");
        }

        getDataPlaces(onSuccess, onError);

    }

    $(document).on("click",".places_id", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("placeId",dataId)
    });
    $(document).on("click",".detail_news", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("newsId",dataId)
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