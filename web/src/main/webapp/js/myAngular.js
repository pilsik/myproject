var app = angular.module('MyApp', []);

app.controller('MyCtrl', ['$scope', '$http', function ($scope, $http) {

    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");

    let req = {
        url: 'http://localhost:8080/restProduct/products/id/31',
        method: 'DELETE',
        headers: {
            [header]: token
        }
    }

    $http.get('http://localhost:8080/restProduct/products').then(successCallback);

    $http(req).then(successCallback);

    function successCallback(response) {
        console.log(response.data)
        $scope.products = response.data;

    }

}]);

$(function () {
    let token = $("meta[name='_csrf']").attr("content");
    let header = $("meta[name='_csrf_header']").attr("content");
    let product = {
        "name": "jsonjsonjson",
        "description": "test3",
        "producer": "test4",
        "price": 11.0,
        "type": "test4"
    };
    $(document).ajaxSend(function (e, xhr, options) {
        xhr.setRequestHeader(header, token);
    });
    $.ajax({
        type: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/restProduct",
        data: JSON.stringify(product),
        success: function (data) {
            console.log("SUCCESS: ", data);
        },
        error: function (data) {
            console.log("ERROR: ", e);
        }
    });
});



