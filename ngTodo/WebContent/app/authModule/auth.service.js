angular.module('authModule')
  .factory('authService', function($http, $cookies) {
    var service = {};
    
    
    var saveToken = function(user) {
	    	$cookies.put('userId', user.id);
	    	$cookies.put('email', user.email);
      // TODO : Store the user's id and email in cookies
    }

    service.getToken = function() {
   		var user = {};
   		user.id = $cookies.get('userId');
   		user.email = $cookies.get('email');
   		return user;
      // TODO : Return an object with id and email properties,
      // the values are the values of the cookies
    }

    var removeToken = function() {
    		$cookies.remove('userId');
    		$cookies.remove('email');
      // TODO : Remove both the id and email cookies
    }

    service.login = function(user) {
    	return $http({
  	      method : 'POST',
  	      url : `rest/auth/login`,
  	      headers : {
  	        'Content-Type' : 'application/json'
  	      },
  	      data : user
  	    })
  	     
      // TODO : Use the auth/login route to authenticate the user
      // On success, use saveToken to store the users id/email
    }

    service.register = function(user) {
    	return $http({
  	      method : 'POST',
  	      url : `rest/auth/register`,
  	      headers : {
  	        'Content-Type' : 'application/json'
  	      },
  	      data : user
  	    })
  	    .then(function(res){
  	    		saveToken(res.data);
  	    		return res;
  	    })
      // TODO : Use the auth/register route to create and authenticate the user
      // On success, use saveToken to store the users id/email
    }

    service.logout = function() {
    	 return $http({
   	      method : 'POST',
   	      url : `rest/auth/logout`,
   	      headers : {
   	        'Content-Type' : 'application/json'
   	      },
   	      
   	    })
   	    .then(function(res){
  	    		removeToken(res.data);
  	    		return res;
   	    })
      // TODO : Use the auth/logout route to remove the users session
      // On success, use removeToken to remove the id and email cookies
    }

    return service;
  })