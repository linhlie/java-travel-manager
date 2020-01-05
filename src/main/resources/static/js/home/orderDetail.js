(function () {
    var  user;
    $(function () {
        var url  = window.location.href;
        var id = url.substring(url.lastIndexOf('/') + 1);
        loadOrder(id);
        console.log(id);
    });
    function loadOrder(id) {
        function onSuccess(response) {
            if (response&&response.status){
                console.log(response)
                var ordersDate = response.order.ordersDate.split('T',1);
                $('#ordersDate').text(ordersDate)
                loadTours(response.order.ordersId)
                loadUser(response.order.userId)
            }

        }
        function onError(e) {
            console.log(e)
        }
        getOrder(id,onSuccess,onError)

    }



    function loadUser(id) {
        function onSuccess(response) {
            if (response && response.status) {
                console.log(response)
                user = response.userDto;
                $('#fullName').text(user.fullName)
                $('#email').text(user.email)
                $('#phone').text(user.phone)
            }

        }

        function onError(e) {
            console.log(e)
        }

        getUserByID(id, onSuccess, onError)

    }
    function loadTours(id) {
        function onSuccess(response) {
            if (response&&response.status){
                console.log(response)
                var ordersDetail =[];
                ordersDetail = response.ordersDetails;
                var htmlOrder="";
                var totalMoney=0;
                for (var i=0;i<ordersDetail.length;i++){
                    var id = ordersDetail[i].tour_id;
                    var money = Math.ceil(((ordersDetail[i].total_price -ordersDetail[i].total_price*ordersDetail[i].discount)*ordersDetail[i].total_user));
                    totalMoney+=money;
                    var html = '<tr>'+
                        '<td class="thick-line">'+ordersDetail[i].nameTour+'</td>'+
                        '<td class="thick-line">'+ordersDetail[i].total_price+'</td>'+
                        '<td class="thick-line" >'+ordersDetail[i].total_user+'</td>'+
                        '<td class="thick-line">'+ordersDetail[i].discount+'</td>'+
                        '<td class="thick-line">'+ordersDetail[i].date+'</td>'+
                        '<td class="thick-line text-center"><strong>'+money+'</strong></td>'+
                        '</tr>';
                    htmlOrder+=html;
                }
                var html ='<tr>'+
                    '<td class="thick-line"></td>'+
                    '<td class="thick-line"></td>'+
                    '<td class="thick-line"></td>'+
                    '<td class="thick-line"></td>'+
                    '<td class="thick-line text-center"><strong>Tổng tiền:</strong></td>'+
                    '<td class="thick-line text-right">'+totalMoney+'</td>'+
                    '</tr>';
                htmlOrder+=html;
            }
            $(".orderDetails").html(htmlOrder);

        }
        function onError(e) {
            console.log(e)
        }
        getOrderTourById(id,onSuccess,onError)

    }
})(jQuery);
