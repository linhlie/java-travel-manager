(function () {
    var html ="";
    var htmlPlaces ="";
    var htmlNews ="";
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
                        '<i class="fa fa-star"></i>'+
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
                        '<div class="offer_name"><a href="/placedetails.html">'+places[i].placeName+'</a></div>'+
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
                        '<div class="offers_link"><a href="/placedetails.html">read more</a></div>'+
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
        console.log($("#testid").val())
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("dataId",dataId)
    });

    // function loadListNews() {
    //
    //     function onSuccess(response) {
    //         if (response && response.status) {
    //             console.log(response)
    //             var news =[];
    //             var imagesNews =[];//images news
    //             news = response.news;
    //             console.log(news[1].name)
    //             imagesNews = response._imagesNews;
    //             for(var i=0;i<news.length;i++){
    //                 var h = 0;
    //                 var hmtlnew = '<div class="owl-item">'+
    //                     '<div class="test_item">'+
    //                     '<div class="test_image"><img src="'+imagesNews[h].image_url+'" alt="https://unsplash.com/@anniegray"></div>'+
    //                     '<div class="test_icon"><img src="images/backpack.png" alt=""></div>'+
    //                     '<div class="test_content_container">'+
    //                     '<div class="test_content">'+
    //                     '<div class="test_item_info">'+
    //                     '<div class="test_name">'+news[i].name+'</div>'+
    //                 '<div class="test_date">'+news[i].createAt+'</div>'+
    //                 '</div>'+
    //                 '<div class="test_quote_title">'+news[i].name+'</div>'+
    //                     '<p class="test_quote_text">'+news[i].newsSummary+'</p>'+
    //                 '</div></div></div></div>';
    //                 htmlNews +=hmtlnew;
    //                 h+=3;
    //             }
    //             $(".test_slider").html(hmtlnew);
    //         }
    //
    //     }
    //
    //     function onError(error) {
    //         console.error("load data fail!");
    //     }
    //
    //     getListNews(onSuccess, onError);
    // }


})(jQuery);
