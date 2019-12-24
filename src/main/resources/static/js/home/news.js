(function () {
    var _login;
    $(function () {
        loadListNews();
        loadCateTours();
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

    function loadListNews() {
        var htmlNews="";
        var _htmlNews="";
        var htmlNewsContent="";

        function onSuccess(response) {
            if (response && response.status) {
                console.log(response)
                var news =[];
                news = response.news;
                var image =[];
                image = response._imagesNews;
                var users=[];
                users=response.listUsers;

                var j =0;
                for (var i =0;i<news.length;i++){
                    var created ="";
                    for (var j=0;j<users.length;j++){
                        if (news[i].createByl==users[j].id){
                            created = users[j].name;
                        }
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
                        '<div class="latest_post_author trans_200"><a href="#">'+created+'</a></div>'+
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


                var k=0;
                for (var i=0;i<3;i++){
                    var created ="";
                    for (var j=0;j<users.length;j++){
                        if (news[i].createByl==users[j].id){
                            created = users[j].name;
                        }
                    }
                    var str = news[i].createAt;
                    var res = str.split(" ", 1);
                    var html='<div class="blog_post" style="margin-bottom: 10px;">'+
                        '<div class="blog_post_image">'+
                        '<img src="'+image[k].image_url+'" alt="https://unsplash.com/@anniespratt">'+
                    '</div>'+
                    '</div>'+
                    '<div class="blog_post_meta">'+
                        '<ul>'+
                        '<li class="blog_post_meta_item"><a href="">'+created+'</a></li>'+
                    '<li class="blog_post_meta_item">'+res+'</li>'+
                    '<li class="blog_post_meta_item"><a href="">3 Comments</a></li>'+
                    '</ul>'+
                    '</div>'+
                    '<div class="blog_post_title detail_news" data-id="'+news[i].news_id+'"><a href="news-detail">'+news[i].name+'</a></div>'+
                    '<div class="blog_post_text">'+
                        '<p>'+news[i].newsSummary+'</p>'+
                    '</div>'+
                    '<div class="blog_post_link detail_news" data-id="'+news[i].news_id+'" style="margin-top: 23px;margin-bottom: 30px"><a href="news-detail">read more</a></div>'+
                    '</div>'+
                    '<hr>';
                    htmlNewsContent+=html;
                    k+=3;
                }
                $(".blog_post_container").html(htmlNewsContent);
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

    function loadCateTours() {
        var cateHtml="";

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