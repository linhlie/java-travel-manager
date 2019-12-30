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

function getTours(onSuccess, onError) {
    var url = "/admin/tours";
    _get(url, onSuccess, onError);
}