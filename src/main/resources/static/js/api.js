
function _get(url, onSuccess, onError) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: url,
        cache: false,
        timeout: 600000,
        success: onSuccess,
        error: onError
    });
}
function _post(url, data, onSuccess, onError) {
    $.ajax({
        type: "POST",
        // contentType: "application/json",
        url: url,
        // data: JSON.stringify(data),
        data: data,
        // dataType: 'json',
        cache: false,
        timeout: 600000,
        success: onSuccess,
        error: onError
    });
}

function _delete(url, onSuccess, onError) {
    $.ajax({
        type: "DELETE",
        url: url,
        success: onSuccess,
        error: onError
    });
}

function getListTours(onSuccess, onError) {
    var url = "/index/tours";
    _get(url, onSuccess, onError);
}

function getListToursPlaces(id,onSuccess, onError) {
    var url = "/place/tours/"+id;
    _get(url, onSuccess, onError);
}

function getListNews(onSuccess, onError) {
    var url = "/news/list";
    _get(url, onSuccess, onError);
}

function getTourDetails(id, onSuccess, onError) {
    var url = "/tours/"+id;
    _get(url, onSuccess, onError);
}

function deleteOrderTour(id, onSuccess, onError) {
    var url = "/order/deleted/"+id;
    _get(url, onSuccess, onError);
}
function getData(year, onSuccess, onError) {
    var url = "/order/revenue/"+year;
    _get(url, onSuccess, onError);
}

function getPlaceDetails(id, onSuccess, onError) {
    var url = "/place/"+id;
    _get(url, onSuccess, onError);
}
function getImage(id, onSuccess, onError) {
    var url = "/image/"+id;
    _get(url, onSuccess, onError);
}

function getNews(id, onSuccess, onError) {
    var url = "/news/"+id;
    _get(url, onSuccess, onError);
}

function getListUser( onSuccess, onError) {
    var url = "/users/tourDetails";
    _get(url, onSuccess, onError);
}

function getUser(email, onSuccess, onError) {
    var url = "/index/users";
    _get(url, onSuccess, onError);
}

function getCateTours( onSuccess, onError) {
    var url = "/tours/cate";
    _get(url, onSuccess, onError);
}

function getListToursVN( onSuccess, onError) {
    var url = "/tours/vi";
    _get(url, onSuccess, onError);
}

function getListToursNA( onSuccess, onError) {
    var url = "/tours/na";
    _get(url, onSuccess, onError);
}

function getDataPlaces( onSuccess, onError) {
    var url = "/places";
    _get(url, onSuccess, onError);
}

function updateUser(data, onSuccess, onError) {
    console.log("test")
    var url ="/user/update";
    _post(url, data, onSuccess, onError);
}
function addOrder(data, onSuccess, onError) {
    var url ="/order/tour/"+data;
    _get(url, onSuccess, onError);
}
function getConfirm(confirm, onSuccess, onError) {
    var url ="/order/confirm/"+confirm;
    _get(url, onSuccess, onError);
}

function getCart(data, onSuccess, onError) {
    var url ="/tour/cart/"+data;
    _get(url, onSuccess, onError);
}

function getOrdersByEmail(email, onSuccess, onError) {
    var url ="/tour/order/"+email;
    _get(url, onSuccess, onError);
}

function postComment(comment, onSuccess, onError) {
    var url ="/tour/comment/"+comment;
    _get(url, onSuccess, onError);
}

function getPaid(string, onSuccess, onError) {
    var url ="http://localhost:9999/bank/users/"+string;
    _get(url, onSuccess, onError);
}

function getOrder(id, onSuccess, onError) {
    var url ="/order/getOne/"+id;
    _get(url, onSuccess, onError);
}

function getUserByID(id, onSuccess, onError) {
    var url ="/order/user/"+id;
    _get(url, onSuccess, onError);
}
function getOrderTourById(id, onSuccess, onError) {
    var url ="/order/tours/"+id;
    _get(url, onSuccess, onError);
}
