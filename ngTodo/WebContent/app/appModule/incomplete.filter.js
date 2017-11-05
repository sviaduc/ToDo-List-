angular.module('appModule')
.filter('incomplete', function(){
  return function(todos, onOff) {
	 var results =[];
	 
//	 if(onOff) return todos;
	 	
	 	todos.forEach(function(todo){
			if (todo.completed === false){
				results.push(todo);
			}
		})
		
	 	 
	 	
	 	if(onOff === true){
	 	todos.forEach(function(todo){
	 		if (todo.completed === true){
					results.push(todo);
				}
			})
	 	}
			return results;	
	 	}
	 	
	 
	 
	 
  
});