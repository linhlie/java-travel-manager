(function () {
    $(function () {
        loadTours();
    })
    function loadTours() {
        function onSuccess(response) {
            if(response&&response.status){
                console.log(response)
            }

        }
        function onError(error) {
            console.log(error)

        }
        getTours(onSuccess,onError)
    }
})(jQuery);