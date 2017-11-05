angular.module('appModule',['ngRoute', 'ngCookies', 'authModule'])
.config(function($routeProvider){
	
	$routeProvider
    .when('/', {
      template : `<home></home>`
    })
    .when('/todos/:id', {
    	template : `<todo-list></todo-list>`
    })
    .when('/todos', {
      template : `<todo-list></todo-list>`
    })
    .when('/about', {
    	template : `<about></about>`
    })
    .when('/contact', {
    	template : `<contact></contact>`
    })
    .when('/register', {
    	template : `<register></register>`
    })
    .when('/login', {
    	template : `<login></login>`
    })
    .when('/_404', {
    	template : `<not-found></not-found>`
    })
    .otherwise({
      template : `<not-found></not-found>`
    })
});