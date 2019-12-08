
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

function getListTours(onSuccess, onError) {
    var url = "/index/tours";
    _get(url, onSuccess, onError);
}
// function getAccountLogin(onSuccess, onError) {
//     var url = "/index/users";
//     _get(url, onSuccess, onError);
// }
