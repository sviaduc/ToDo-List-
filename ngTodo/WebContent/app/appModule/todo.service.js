angular.module('appModule')
.factory('todoService', function($http, $filter, authService, $location, $rootScope) {
  var service = {};

  var BASE_URL = 'http://localhost:8080/ngTodo/rest';
 
  
  var checkLogin = function(){
	  return authService.getToken().id;
  }
  
  
  
          // Use the $rootScope to $broadcast the event and send information

  
  
  
  
  service.index = function() {
	  var uid = checkLogin();
	  if(uid){
		  return $http({
		      method : 'GET',
		      url : `${BASE_URL}/user/${uid}/todo`
		    })
	  }
	  $location.path("/login");
	  
		 
	  };
  
  service.show = function(id) {
	  var uid = checkLogin();
	  if(uid){
	  	return $http({
		  method : 'GET',
		  url : `${BASE_URL}/user/${uid}/todo/` + id
	  })
	  }
	  
  };
	  
  service.update = function(todos){
	  var uid = checkLogin();
	  if(uid){
	  return $http({
	      method : 'PUT',
	      url : `${BASE_URL}/user/${uid}/todo/` + todos.id, 
	      headers : {
	        'Content-Type' : 'application/json'
	      },
	      data : todos
	    })
	  }
	  };
    		 
    	 
  
  
  service.destroy = function(tid){
	  var uid = checkLogin();
	  if(uid){
	  return $http({
	      method : 'DELETE',
	      url : `${BASE_URL}/user/${uid}/todo/${tid}`
	    })
	  }
		
  };
  

  service.create = function(newTask) { 
	  var uid = checkLogin();
	  if(uid){
	  return $http({
	      method : 'POST',
	      url : `${BASE_URL}/user/${uid}/todo`,
	      headers : {
	        'Content-Type' : 'application/json'
	      },
	      data : newTask
	    })
	    .then(function(res){
	    	$rootScope.$broadcast('todoCreated', {
	    		todo : res.data
	    	});
  	    })
	    
	  }
  };
  
  
  

  return service;
})