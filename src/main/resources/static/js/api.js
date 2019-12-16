
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
        contentType: "application/json",
        url: url,
        data: JSON.stringify(data),
        dataType: 'json',
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

function getListNews(onSuccess, onError) {
    var url = "/news/list";
    _get(url, onSuccess, onError);
}

function getTourDetails(id, onSuccess, onError) {
    var url = "/tours/"+id;
    _get(url, onSuccess, onError);
}
