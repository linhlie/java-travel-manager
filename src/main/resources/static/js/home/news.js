(function () {
    $(function () {
        loadListNews();
    });
    function loadListNews() {

        function onSuccess(response) {
            if (response && response.status) {
                console.log(response)
            }

        }

        function onError(error) {
            console.error("load data fail!");
        }

        getListNews(onSuccess, onError);
    }

})(jQuery);