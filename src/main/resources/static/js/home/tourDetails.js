(function () {
    var htmlNews ="";
    var _htmlNews ="";
    var htmlComment="";
    var userId;
    var _comments =[];
    $(function () {
        var id = sessionStorage.getItem("dataId");
        console.log(id);

        var login = sessionStorage.getItem("login");
        console.log(login);

        if (login  != null){
            var html='<a href="/profile">'+login+'</a>';
            $("#login-form").attr("style", "display: none;");
            $("#sign-up").attr("style", "display: none;");
            $("#account").text(login);
            $('#account').removeClass("hidden");
            $('#logout').removeClass("hidden");
            $(".profile").html(html);

        }
        else {
            $("#logout").attr("style", "display: none;");
            $("#account").attr("style", "display: none;");
        }

        loadTourDetails(id);
        loadListNews();
        loadCateTours();
        checkCart();

    });
    function loadTourDetails(id) {
        function onSuccess(response) {
            if(response && response.status){
                var tour = response.tour;
                var imagesTours = [];
                imagesTours = response.imagesTours;
                var discount = tour.discount*100;
                console.log(response)
                _comments =response.comments;
                if(_comments.length!=0){
                    loadInfoComments();
                }
                var html = '<div class="blog_post_image">'+
                    '<div id="demo" class="carousel slide" data-ride="carousel">'+
                    '<ul class="carousel-indicators">'+
                    '<li data-target="#demo" data-slide-to="0" class="active"></li>'+
                    '<li data-target="#demo" data-slide-to="1"></li>'+
                    '<li data-target="#demo" data-slide-to="2"></li>'+
                    '</ul><div class="carousel-inner">'+
                    '<div class="carousel-item active">'+
                    '<img src="'+imagesTours[0].imageUrl+'" alt="images_1">'+
                    '</div><div class="carousel-item">'+
                    '<img src="'+imagesTours[1].imageUrl+'" alt="images_2">'+
                    '</div><div class="carousel-item">'+
                    '<img src="'+imagesTours[2].imageUrl+'" alt="images_3">'+
                    '</div></div><a class="carousel-control-prev" href="#demo" data-slide="prev">'+
                    '<span class="carousel-control-prev-icon"></span>'+
                    '</a><a class="carousel-control-next" href="#demo" data-slide="next">'+
                    '<span class="carousel-control-next-icon"></span>'+
                    '</a></div>'+
                    '</div></div>' +
                    '<br><div class="row">'+
                    '<div class="col-lg-2">'+
                    '<div class="stats_last order-md-1 order-3">'+
                    '<div class="stats_last_icon d-flex flex-column align-items-center justify-content-end">'+
                    '<img src="images/stats_1.png" alt="">'+
                    '<div class="stats_last_content">'+
                    '<div class="stats_type">Số người</div>'+
                    '<div class="stats_type">'+tour.totalMember+'</div></div></div></div></div>'+
                    '<div class="col-lg-2">'+
                    '<div class="stats_last order-md-1 order-3">'+
                    '<div class="stats_last_icon d-flex flex-column align-items-center justify-content-end">'+
                    '<img src="images/stats_2.png" alt="">'+
                    '<div class="stats_last_content">'+
                    '<div class="stats_type">Địa điểm</div>'+
                    '<div class="stats_type">'+tour.placeId+'</div>'+
                    '</div></div></div></div>' +
                    '<div class="col-lg-2">'+
                    '<div class="stats_last order-md-1 order-3">'+
                    '<div class="stats_last_icon d-flex flex-column align-items-center justify-content-end">'+
                    '<img style="height: 30px;width: 30px" src="images/icon/calendar.png" alt="">'+
                    '<div class="stats_last_content">'+
                    '<div class="stats_type">Ngày đi</div>'+
                    '<div class="stats_type">'+tour.departureDate+'</div></div></div></div>'+
                    '</div>' +
                    '<div class="col-lg-2">'+
                    '<div class="stats_last order-md-1 order-3">'+
                    '<div class="stats_last_icon d-flex flex-column align-items-center justify-content-end">'+
                    '<img style="height: 30px;width: 30px" src="images/icon/totaldays.png" alt="">'+
                    '<div class="stats_last_content">'+
                    '<div class="stats_type">Số ngày đi</div>'+
                    '<div class="stats_type">'+tour.totalDays+'</div></div></div></div>'+
                    '</div>' +
                    '<div class="col-lg-2">'+
                    '<div class="stats_last order-md-1 order-3">'+
                    '<div class="stats_last_icon d-flex flex-column align-items-center justify-content-end">'+
                    '<img style="height: 30px;width: 30px" src="images/icon/discount.png" alt="">'+
                    '<div class="stats_last_content">'+
                    '<div class="stats_type">Giảm giá</div>'+
                    '<div class="stats_type">'+discount+'%</div></div></div></div>'+
                    '</div>' +
                    '<div class="col-lg-2">'+
                    '<div class="stats_last order-md-1 order-3">'+
                    '<div class="stats_last_icon d-flex flex-column align-items-center justify-content-end">'+
                    '<img style="height: 30px;width: 30px" src="images/icon/money-bag.png" alt="">'+
                    '<div class="stats_last_content">'+
                    '<div class="stats_type">Chi phí</div>'+
                    '<div class="stats_type">$'+tour.price+'</div>'+
                    '</div></div></div></div></div><br>'+
                    '<div class="row">'+
                    '<div class="col-lg-2">'+
                    '<button type="button" class="btn btn-success"  data-toggle="modal" data-target="#myModal">Book now</button>'+
                    '<div class="modal" id="myModal">'+
                    '<div class="modal-dialog">'+
                    '<div class="modal-content">'+
                    '<div class="modal-header">'+
                    '<h4 class="modal-title">Modal Heading</h4>'+
                    '<button type="button" class="close" data-dismiss="modal">&times;</button>'+
                    '</div>'+
                    '<div class="modal-body">'+
                    '<ul><li>item 1</li>'+
                    '<li>item 2</li> <li>item 3</li><li>item 4</li><li>item 5</li></ul></div>'+
                    '<div class="modal-footer">'+
                    '<button type="button" class="btn btn-danger" data-dismiss="modal">Close</button>'+
                    '</div></div></div> </div>'+
                    '</div>' +
                    '<div class="col-lg-2">'+
                    '<button type="button" class="btn btn-success">Add Cart</button>'+
                    '</div>'+
                    '</div>'+
                    '<div class="blog_post_title"><a href="#">Tour Details</a></div>'+
                    '<div class="blog_post_text">'+
                    '<p>'+tour.tourName+'</p>'+
                '</div>'+
                '<div>'+tour.tourContent+'</div>';

            }
            $(".blog_post").html(html);
        }

        function onError(error) {
            console.error(" fail");
        }

        getTourDetails(id, onSuccess, onError);
    }
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
                $(".list_news_ul").html(htmlNews);

                var h =0;
                for (var i =0;i<3;i++){
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var _html = '<div class="footer_blog_item clearfix">'+
                        '<div class="footer_blog_image"><img src="'+image[h].image_url+'" alt="https://unsplash.com/@avidenov"></div>'+
                        '<div class="footer_blog_content">'+
                        '<div class="footer_blog_title"><a href="home/news.html">'+news[i].name+'</a></div>'+
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
    $(document).on("click",".test", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("dataId",dataId)
    });
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
                $(".cate_tours").html(cateHtml);
            }
        }

        function onError(error) {
            console.error("load data fail!");
        }

        getCateTours(onSuccess, onError);

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