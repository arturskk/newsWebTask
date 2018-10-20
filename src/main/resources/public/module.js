angular.module('newsApp', [])
    .controller('newsController', function ($scope, $http) {
        $scope.country = 'pl';
        $scope.countryVariable = 'pl';
        $scope.category = 'technology';
        $scope.categoryTechnology = 'technology';
        $scope.categorySports = 'sports';
        $scope.categoryBusiness = 'business';
        $scope.categoryEntertainment = 'entertainment';
        $scope.categoryHealth = 'health';
        $scope.categoryScience = 'science';
        $scope.search = '';
        $scope.searchActive = 0;
        $scope.page = 1;

        $scope.button = function (country, category1, page) {
            if (page > 4) {
                page = 1
            }
            if (page < 1) {
                page = 1
            }

            $scope.searchActive = 0;
            $scope.category = angular.copy(category1);
            $scope.countryVariable = angular.copy(category1);
            $http.get('/news/' + country + '/' + category1 + '/', {
                params: {
                    page: page
                }
            }).then(function (response) {
                $scope.news = response.data;
            });
        };

        $scope.searchNews = function (search) {
            $scope.search = angular.copy(search);
            $scope.searchActive = 1;
            $http.get('/news/' + search + '/', {
                params: {
                    page: $scope.page
                }
            }).then(function (response) {
                $scope.news = response.data;
            });
        };

        $scope.firstPage = function () {
            $scope.page = 1;
            if ($scope.searchActive <= 0) {
                $scope.button($scope.countryVariable, $scope.category, $scope.page)
            } else {
                $scope.searchNews($scope.search)
            }
        };

        $scope.nextPage = function () {
            $scope.page += 1;
            if ($scope.page >= 4 && $scope.searchActive <= 0) {
                $scope.page = 4
            }
            if ($scope.searchActive <= 0) {
                $scope.button($scope.country, $scope.category, $scope.page);
            } else {
                $scope.searchNews($scope.search)
            }

        };

        $scope.previousPage = function () {
            $scope.page -= 1;
            if ($scope.page <= 0) {
                $scope.page = 1
            }
            if ($scope.searchActive <= 0) {
                $scope.button($scope.country, $scope.category, $scope.page)
            } else {
                $scope.searchNews($scope.search)
            }
        };
    });