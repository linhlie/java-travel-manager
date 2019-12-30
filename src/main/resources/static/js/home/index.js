(function () {
    var html ="";
    var htmlPlaces ="";
    var htmlNews ="";
    $(function () {
        loadListTours();
        loadListNews();
        var accountText = document.getElementById("account")
        if(accountText!=null){
            var account = accountText.textContent;
            console.log(account)
            sessionStorage.setItem("login",account);
        }
        else {
            sessionStorage.removeItem("login");
        }
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
        checkCart();

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
        $(".test_cart").html(htmlCart);
    }


    function loadListTours() {

        function onSuccess(response) {
            if(response && response.status){
                console.log(response)
                var h =1;
                var list =[];//tours
                var images =[];//images tours
                list = response.tours;
                images=response.imagesTours;
                    for (var i =0;i<list.length;i++){
                     var _html= '<div class="col-lg-4 intro_col mb-4">'+
                        '<div class="intro_item">'+
                        '<div class="intro_item_overlay"></div>'+
                        '<div class="intro_item_background" style="background-image:url('+images[h].imageUrl+')"></div>'+
                        '<div class="intro_item_content d-flex flex-column align-items-center justify-content-center">'+
                        '<div class="intro_date " >'+list[i].departureDate+'</div>'+
                        '<div class="button intro_button"><div class="button_bcg"></div><div class="test" id="testid" data-id="'+list[i].tourId+'"><a href="/details.html" >Xem chi tiết<span></span></a></div></div>'+
                        '<div class="intro_center text-center">'+
                        '<h3 class="claimedRight" maxlength="20" style="font-weight:bold">'+list[i].tourName+'</h3>'+
                        '<div class="intro_price">$'+ list[i].price+'</div>'+
                        '<div class="rating rating_4">'+
                        '<is class="fa fa-star"></is>'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '</div></div></div></div></div>';
                     html += _html;
                     h+=3;
                }
                $(".intro_items").html(html);


                var places =[]; //places
                var imagesPl=[];
                var j =1;
                places = response.places;
                imagesPl =response.imagesPlaces;
                for (var i =0;i<places.length;i++){
                    var htmlPl = '<div class="col-lg-6 offers_col">'+
                        '<div class="offers_item">'+
                        '<div class="row">'+
                        '<div class="col-lg-6">'+
                        '<div class="offers_image_container">'+
                        '<div class="offers_image_background" style="background-image:url('+imagesPl[j].imageUrl+');width: 260px"></div>'+
                        '<div class="offer_name places_id" data-id="'+places[i].placeId+'"><a href="/place-detail.html">'+places[i].placeName+'</a></div>'+
                    '</div></div>'+
                    '<div class="col-lg-6">'+
                        '<div class="offers_content">'+
                    '<div class="rating_r rating_r_4 offers_rating">'+
                        '</div>'+
                        '<p class="offers_text" style="height: 200px;width: 255; overflow: hidden;text-overflow: ellipsis;">'+places[i].placeSummary+'</p>'+
                    '<div class="offers_icons">'+
                        '<ul class="offers_icons_list">'+
                        '<li class="offers_icons_item"><img src="images/post.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/compass.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/bicycle.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/sailboat.png" alt=""></li>'+
                        '</ul></div>'+
                        '<div class="offers_link places_id "data-id="'+places[i].placeId+' " style="margin-top: 30px!important;"><a href="/place-detail.html">read more <i class="fa fa-angle-double-right"></i></a></div>'+
                    '</div></div></div></div></div>';
                    htmlPlaces+=htmlPl;
                    j+=3;
                }
                $(".offers_items").html(htmlPlaces);

            }
        }
        function onError(error) {
            console.error("load data fail!");
        }

        getListTours(onSuccess, onError);
    }

    $(document).on("click",".test", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("dataId",dataId)
    });

    $(document).on("click",".places_id", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("placeId",dataId)
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
                for (var i =0;i<3;i++){
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var html = '<div class="footer_blog_item clearfix">'+
                        '<div class="footer_blog_image"><img src="'+image[j].image_url+'" alt="https://unsplash.com/@avidenov"></div>'+
                        '<div class="footer_blog_content">'+
                        '<div class="footer_blog_title detail_news" data-id="'+news[i].news_id+'"><a href="news-detail">'+news[i].name+'</a></div>'+
                        '<div class="footer_blog_date">'+res+'</div>'+
                        '</div>'+
                        '</div>';

                    htmlNews+=html;
                    j+=3;
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

})(jQuery);
