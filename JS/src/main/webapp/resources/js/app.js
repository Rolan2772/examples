(function () {
    var app = angular.module('store', ['store-products']);

    app.controller('StoreController', ['$http', function ($http) {
        var store = this;
        store.products = [];

        $http.get('/resources/json/products.json')
            .success(function (data) {
                store.products = data;
                alert(data);
            })
            .error(function () {
                alert('Can\'t load products');
            });
    }]);

    app.controller('ReviewController', function () {
        this.review = {};

        this.addReview = function (product) {
            product.reviews.push(this.review);
            this.review = {};
        };
    });

    app.controller('hello', function ($scope, $http) {

        this.hello = function ($scope, $http) {
            $http.get('/greeting').
                success(function (data) {
                    $scope.greeting = data;
                }).
                error(function (data, status, headers, config) {
                    alert("WTF? " + data);
                });
        };

        this.hello($scope, $http);

    });

})();