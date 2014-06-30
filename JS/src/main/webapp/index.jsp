<html ng-app="store">
<head>
    <link rel="stylesheet" type="text/css" href="/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" type="text/css" href="/resources/css/app.css"/>
    <script type="text/javascript" src="/resources/js/angular.min.js"></script>
    <script type="text/javascript" src="/resources/js/app.js"></script>
    <script type="text/javascript" src="/resources/js/products.js"></script>
    <style type="text/css">
    </style>
</head>
<body>
<div ng-controller="StoreController as store">

    <div ng-controller="hello" class="left">
        <h6>
            <p>{{greeting.id}}: {{greeting.content}}</p>
            <p ng-show="hello.saved">Greeting successfully saved </p>
        </h6>
    </div>

    <!--  Store Header  -->
    <header>
        <h1 class="text-center">Flatlander Crafted Gems</h1>
        <h2 class="text-center">- an Angular store -</h2>
    </header>

    <!--  Products Container  -->
    <div class="list-group">
        <!--  Product Container  -->
        <div class="list-group-item" ng-repeat="product in store.products">
            <h3>{{product.name}} <em class="pull-right">{{product.price | currency}}</em></h3>
            <!-- Image Gallery  -->
            <product-gallery></product-gallery>
            <!-- Product Tabs  -->
            <product-tabs></product-tabs>
        </div>
    </div>
</div>
</body>
</html>
