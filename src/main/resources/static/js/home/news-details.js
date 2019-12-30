(function () {
    var _login;
    var htmlComment="";
    var _comments =[];
    var id;
    $(function () {
         id = sessionStorage.getItem("newsId");
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

        loadCateTours();
        sessionLogin();
        loadListNews();
        loadNews();
        checkCart();

    });
    function sessionLogin() {
        var login = sessionStorage.getItem("login");
        _login =login;
        if(login!=null){
            $("#login-form").attr("style", "display: none;");
            $("#sign-up").attr("style", "display: none;");
            $("#account").text(login);
            $('#account').removeClass("hidden")
            $('#logout').removeClass("hidden")
            return true;
        }
        else {
            $("#logout").attr("style", "display: none;");
            $("#account").attr("style", "display: none;");
            return false;
        }


    }
    function loadNews() {
        function onSuccess(response) {
            var htmlNews="";
            if (response&&response.status)
                console.log(response)
            var images=[];
            var news=response.news;
            images=response.imagesNews;

            _comments =response.comments;
            if(_comments.length!=0){
                loadInfoComments();
            }

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
                    '<div class="blog_post_title"><a href="#">'+news.name+'</a></div>'+
                    '<div class="blog_post_text">'+
                    '<p>'+news.newsSummary+'</p>'+
                    '</div>'+
                    '<div>'+news.newsContent+'</div>';
                htmlNews =html;
            $(".blog_post").html(htmlNews);

        }
        function onError(error) {
            console.error("load data fail!");
        }
        getNews(id,onSuccess, onError);

    }
    function loadListNews() {
        var htmlNews="";
        var _htmlNews="";

        function onSuccess(response) {
            if (response && response.status) {
                var newsDetail;
                console.log(response)
                var news =[];
                news = response.news;
                var image =[];
                image = response._imagesNews;

                var j =0;
                for (var i =0;i<news.length;i++){
                    if (news[i].news_id == id){
                        newsDetail=news[i];
                    }
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var html ='<li class="latest_post clearfix">'+
                        '<div class="latest_post_image">'+
                        '<a href="#"><img style="height: 73px;width: 73px" src="'+image[j].image_url+'" alt=""></a>'+
                        '</div>'+
                        '<div class="latest_post_content">'+
                        '<div class="latest_post_title trans_200 detail_news" data-id="'+news[i].news_id+'"><a href="news-detail">'+news[i].name+'</a></div>'+
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