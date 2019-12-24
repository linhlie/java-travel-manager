(function () {
    var _login;
    var htmlNews ="";
    var _htmlNews ="";
    var htmlComment="";
    var userId;
    var _comments =[];
    var imageTours=[];
    var tours=[];
    $(function () {
        var id = sessionStorage.getItem("placeId");
        console.log(id);

        loadPlaceDetails(id);
        loadListNews();
        loadCateTours();
        loadInfoComments();
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
    function loadPlaceDetails(id) {
        var htmlPlace="";
        var tourTitle="";
        function onSuccess(response) {
            if(response && response.status){
                console.log(response)
                var place =response.place;
                var images =[];
                images=response.imagesPlace;
                _comments = response.comments;
                imageTours = response.imagesTours;
                tours = response.listTourPlace;
                console.log(tours.length)

                var html= '<div class="blog_post_image">'+
                    '<div id="demo" class="carousel slide" data-ride="carousel">'+
                    '<ul class="carousel-indicators">'+
                    '<li data-target="#demo" data-slide-to="0" class="active"></li>'+
                    '<li data-target="#demo" data-slide-to="1"></li>'+
                    '<li data-target="#demo" data-slide-to="2"></li>'+
                    '</ul>'+
                    '<div class="carousel-inner">'+
                    '<div class="carousel-item active">'+
                    '<img src="'+images[0].imageUrl+'" alt="images_1">'+
                    '</div>'+
                    '<div class="carousel-item">'+
                    '<img src="'+images[1].imageUrl+'" alt="images_2">'+
                    '</div>'+
                    '<div class="carousel-item">'+
                    '<img src="'+images[2].imageUrl+'" alt="images_3">'+
                    '</div></div>'+
                    '<a class="carousel-control-prev" href="#demo" data-slide="prev">'+
                    '<span class="carousel-control-prev-icon"></span>'+
                    '</a><a class="carousel-control-next" href="#demo" data-slide="next">'+
                    '<span class="carousel-control-next-icon"></span>'+
                    '</a></div></div>'+
                    '<div class="blog_post_title"><a href="#">'+place.placeName+'</a></div>'+
                    '<div class="blog_post_text">'+
                    '<p>'+place.placeSummary+'</p>'+
                    '</div>'+
                    '<div>'+place.placeContent+'</div>';
                htmlPlace =html;

                var _html='<h2 class="">Khám phá những điểm du lịch tại '+place.placeName+'</h2>';
                tourTitle=_html;
            }
            $(".blog_post").html(htmlPlace);
            $(".title-tour").html(tourTitle);

            var _htmlTour="";
            var j=0;
            for (var i=0;i<tours.length;i++){
                var html='<div class="row mb-5">'+
                    '<div class="col-lg-3 col-1680-4">'+
                    '<div class="offers_image_container">'+
                    '<div class="offers_image_background" style="background-image:url('+imageTours[j].imageUrl+')"></div>'+
                    '<div class="offer_name test"  data-id="'+tours[i].tourId+'"><a href="/details.html">Xem chi tiết</a></div>'+
                    '</div></div>'+
                    '<div class="col-lg-8">'+
                    '<div class="offers_content">'+
                    '<div style="font-size: 20px;font-weight: bold" class=""><div class="test"  data-id="'+tours[i].tourId+'"><a href="/details.html" >'+tours[i].tourName+'<span></span></a></div></div>'+
                    '<div class="rating_r rating_r_5 offers_rating" data-rating="5">'+
                    '<i></i><i></i><i></i><i></i><i></i></div>'+
                    '<p class="offers_text">'+tours[i].tourSummary+'</p>'+
                    '<div class="offers_icons">'+
                    '<ul class="offers_icons_list" style="margin-bottom: 20px">'+
                    '<li class="offers_icons_item"><img src="images/post.png" alt=""></li>'+
                    '<li class="offers_icons_item"><img src="images/compass.png" alt=""></li>'+
                    '<li class="offers_icons_item"><img src="images/bicycle.png" alt=""></li>'+
                    '<li class="offers_icons_item"><img src="images/sailboat.png" alt=""></li>'+
                    '</ul></div>'+
                    '<div class="cart"><button data-id="'+tours[i].tourId+'" class="add_cart" style="border: #c80000"><span style="margin-top: 10px">' +
                    '<img style="width: 30px;height: 30px" src="images/icon/cart.png">Thêm giỏ hàng</span></button></div>'+
                    '</div></div></div>';
                _htmlTour +=html;
                j+=3;
            }
            $(".tour-list").html(_htmlTour);

        }

        function onError(error) {
            console.error(" fail");
        }

        getPlaceDetails(id, onSuccess, onError);
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
            if (id_check!=dataId){
                tourIds.push(dataId);
                console.log(tourIds);
                id_check=dataId;
            }
            else {
                alert("Bạn đã thêm tour này vào giỏ hàng trước đó!")
            }
            localStorage.setItem(_login,tourIds);

        }
    });

    function loadListNews() {

        function onSuccess(response) {
            if (response && response.status) {
                console.log(response)
                var news =[];
                news = response.news;
                var image =[];
                image = response._imagesNews;
                var j =0;
                for (var i =0;i<news.length;i++){
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var html ='<li class="latest_post clearfix">'+
                        '<div class="latest_post_image">'+
                        '<a href="#"><img style="height: 73px;width: 73px" src="'+image[j].image_url+'" alt=""></a>'+
                        '</div>'+
                        '<div class="latest_post_content">'+
                        '<div class="latest_post_title trans_200"><a href="#">'+news[i].name+'</a></div>'+
                        '<div class="latest_post_meta">'+
                        '<div class="latest_post_author trans_200"><a href="#">'+news[i].createByl+'</a></div>'+
                        '<div class="latest_post_date trans_200"><a href="#">'+res+'</a></div>'+
                        '</div> </div> </li> ';

                    htmlNews+=html;
                    j+=3;
                }
                $(".list-news").html(htmlNews);

                var h =0;
                for (var i =0;i<3;i++){
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var _html = '<div class="footer_blog_item clearfix">'+
                        '<div class="footer_blog_image"><img src="'+image[h].image_url+'" alt="https://unsplash.com/@avidenov"></div>'+
                        '<div class="footer_blog_content">'+
                        '<div class="footer_blog_title detail_news" data-id="'+news[i].news_id+'"><a href="news-detail">'+news[i].name+'</a></div>'+
                        '<div class="footer_blog_date">'+res+'</div>'+
                        '</div>'+
                        '</div>';

                    _htmlNews+=_html;
                    h+=3;
                }

                $(".footer_blog").html(_htmlNews);
            }

        }

        function onError(error) {
            console.error("load data fail!");
        }

        getListNews(onSuccess, onError);
    }
    function loadInfoComments() {

        function onSuccess(response) {
            if (response && response.status) {
                console.log(response)
                var users =[];
                users=response.listUsers;
                var images =[];
                images =response.imagesUserComments;

                for (var i=0;i<_comments.length;i++){
                    var html1="";
                    for (var j=0;j<users.length;j++){
                        if (_comments[i].userId==users[j].id){
                            html1= '<div class="media mb-4">'+
                                '<img style="width: 50px;height: 50px;" class="d-flex mr-3 rounded-circle" src="'+images[j].imageUrl+'" alt="">'+
                                '<div class="media-body">'+
                                '<h5 class="mt-0">'+users[j].name+'</h5>'+
                                '<div>'+_comments[i].content+'</div>'+
                                '</div></div>';
                        }
                    }

                    htmlComment+=html1;
                }
                $(".comment").html(htmlComment);
            }

        }

        function onError(error) {
            console.error("load data fail!");
        }

        getListUser(onSuccess, onError);
    }
    var cateHtml="";

    function loadCateTours() {

        function onSuccess(response) {
            if (response && response.status) {
                console.log(response.categoryTours)
                var cate_tours =[];
                cate_tours = response.categoryTours;
                for (var i=0;i<cate_tours.length;i++){
                    var html = '<li><a href="'+cate_tours[i].category_tour_url+'">'+cate_tours[i].category_tour_name+'</a></li>';
                    cateHtml+=html;
                }
                $(".cate-tour").html(cateHtml);
            }
        }

        function onError(error) {
            console.error("load data fail!");
        }

        getCateTours(onSuccess, onError);

    }
    $(document).on("click",".detail_news", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("newsId",dataId)
    });
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