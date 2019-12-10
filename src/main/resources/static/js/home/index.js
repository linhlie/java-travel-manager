(function () {
    var html ="";
    var htmlPlaces ="";
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
                var list =[];//tours
                var images =[];//images tours
                list = response.list;
                images=response.imagesTours;
                    for (var i =0;i<list.length;i++){
                     var _html= '<div class="col-lg-4 intro_col mb-4">'+
                        '<div class="intro_item">'+
                        '<div class="intro_item_overlay"></div>'+
                        '<div class="intro_item_background" style="background-image:url('+images[i].imageUrl+')"></div>'+
                        '<div class="intro_item_content d-flex flex-column align-items-center justify-content-center">'+
                        '<div class="intro_date">'+list[i].tour_name+'</div>'+
                        '<div class="button intro_button"><div class="button_bcg"></div><a href="tourdetails.html">see more<span></span></a></div>'+
                        '<div class="intro_center text-center">'+
                        '<h1>'+list[i].tour_name+'</h1>'+
                        '<div class="intro_price">'+ list[i].price+'</div>'+
                        '<div class="rating rating_4">'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '<i class="fa fa-star"></i>'+
                        '</div></div></div></div></div>';
                     html += _html;
                }
                $(".intro_items").html(html);

                var places =[]; //places
                var imagesPl=[];
                places = response.places;
                imagesPl =response.imagesPlaces;
                for (var i =0;i<places.length;i++){
                    var htmlPl = '<div class="col-lg-6 offers_col">'+
                        '<div class="offers_item">'+
                        '<div class="row">'+
                        '<div class="col-lg-6">'+
                        '<div class="offers_image_container">'+
                        '<div class="offers_image_background" style="background-image:url('+imagesPl[i].imageUrl+')"></div>'+
                        '<div class="offer_name"><a href="#">grand castle</a></div>'+
                    '</div></div>'+
                    '<div class="col-lg-6">'+
                        '<div class="offers_content">'+
                        '<div class="offers_price">$70<span>per night</span></div>'+
                    '<div class="rating_r rating_r_4 offers_rating">'+
                        '</div>'+
                        '<p class="offers_text">Suspendisse potenti. In faucibus massa. Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam eu convallis tortor.</p>'+
                    '<div class="offers_icons">'+
                        '<ul class="offers_icons_list">'+
                        '<li class="offers_icons_item"><img src="images/post.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/compass.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/bicycle.png" alt=""></li>'+
                        '<li class="offers_icons_item"><img src="images/sailboat.png" alt=""></li>'+
                        '</ul></div>'+
                        '<div class="offers_link"><a href="offers.html">read more</a></div>'+
                    '</div></div></div></div></div>';
                    htmlPlaces+=htmlPl;
                }
                $(".offers_items").html(htmlPlaces);

            }
        }
        function onError(error) {
            console.error("load data fail!");
        }

        getListTours(onSuccess, onError);
    }


})(jQuery);