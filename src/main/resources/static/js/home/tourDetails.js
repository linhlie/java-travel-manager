(function () {
    $(function () {
       var id = sessionStorage.getItem("dataId");
       console.log(id);
        loadTourDetails(id);

    });
    function loadTourDetails(id) {

        function onSuccess(response) {
            if(response && response.status){
                console.log(response)
            }
        }

        function onError(error) {
            console.error(" fail");
        }

        getTourDetails(id, onSuccess, onError);
    }
})(jQuery);