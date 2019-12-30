(function () {
    var _login;
    var idUser;
    $(function () {
        sessionLogin();
        loadListNews();
        checkCart();

    });

    function sessionLogin() {
        var login = sessionStorage.getItem("login");
        _login =login;
        loadUser(login);
        if(login!=null){
            var html='<a href="/profile">'+login+'</a>';
            $("#login-form").attr("style", "display: none;");
            $("#sign-up").attr("style", "display: none;");
            $("#account").text(login);
            $(".profile").html(html);

            return true;
        }
        else {
            $("#logout").attr("style", "display: none;");
            $("#account").attr("style", "display: none;");
            return false;
        }

    }
    function loadUser(login) {
        var email = login;
        console.log(email)
        function onSuccess(response) {
            if (response && response.status){
                console.log(response)
                var userText = response.jsonUser;
                var user  = [];
                user = userText.split(",");
                console.log(user)
                idUser = user[0];
                loadImage(user[5])
                function loadImage(id) {
                    function onSuccess(res) {
                        if (res && res.status){
                            console.log(res)
                            var html = '<div class="text-center">'+
                                '<img src="'+res.image.imageUrl+'" class="avatar img-circle img-thumbnail" alt="avatar">'+
                                '<br> <br>'+
                                '<h4>'+user[3]+'</h4>'+
                                '<div class="file btn btn-lg btn-primary" style="position: relative;overflow: hidden;">Thay ảnh đại diện'+
                                '<input type="file" name="file" style=" position: absolute;font-size: 50px;opacity: 0;right: 0;top: 0;"/>'+
                                '</div></div>';
                        }
                        $(".profile-image").html(html);

                    }
                    function onError(error) {
                        console.error("load data fail!");
                    }
                    getImage(id,onSuccess,onError);

                }
                $("#id").val(user[0]);
                $("#email").val(user[1]);
                $("#phone").val(user[2]);
                $("#fullName").val(user[3]);
                $("#birthday").val(user[4]);
            }
        }
        function onError(error) {
            console.error("load data fail!");
        }


        getUser(email, onSuccess, onError);
    }
    function loadListNews() {
        var _htmlNews="";

        function onSuccess(response) {
            if (response && response.status) {
                var newsDetail;
                console.log(response)
                var news =[];
                news = response.news;
                var image =[];
                image = response._imagesNews;

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
    $(document).on("click",".detail_news", function () {
        var dataId = $(this).attr("data-id");
        sessionStorage.setItem("newsId",dataId)
    });
    function checkCart() {
        var login = sessionStorage.getItem("login");
        var string = localStorage.getItem(login);
        console.log(string)
        var array  = [];
        array = string.split(",");
        if (array.length>0){
            var htmlCart= '<a href="/cart"><i class="fa fa-shopping-cart" style="font-size: 25px;"></i><span class="shop-cart"> <span class="secondary">'+array.length+'</span></span></a>'
        }
        $(".test_cart").html(htmlCart);
    }

})(jQuery);