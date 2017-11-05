package controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.TodoDAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Todo;

@RestController 
public class TodoController {
	
	@Autowired
	private TodoDAO todoDao;
	
		@RequestMapping(path="ping", method = RequestMethod.GET)
		public String ping() {
			return "pong";
		}
	
//	    GET /user/{uid}/todo
		@RequestMapping(path="/user/{uid}/todo", method= RequestMethod.GET)
	    public Collection<Todo> index(HttpServletRequest req, HttpServletResponse res, @PathVariable int uid){
			return todoDao.index(uid);
	    	
	    }

//	    GET /user/{uid}/todo/{tid}
		@RequestMapping(path="/user/{uid}/todo/{tid}", method=RequestMethod.GET)
	    public Todo show(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int tid) {
		 return todoDao.show(uid, tid);
		 
	    	
	    }

//	    POST /user/{uid}/todo
		@RequestMapping(path="/user/{uid}/todo", method=RequestMethod.POST)
	    public Todo create(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@RequestBody String todoJson) {
			res.setStatus(201);
			return todoDao.create(uid, todoJson) ;
	    }

//	    PUT /user/{uid}/todo/{tid}
		@RequestMapping(path="/user/{uid}/todo/{tid}", method=RequestMethod.PUT)
	    public Todo update(HttpServletRequest req, HttpServletResponse res,@PathVariable int uid,@PathVariable int tid,@RequestBody String todoJson) {
			return todoDao.update(uid, tid, todoJson);
	    	
	    }

//	    DELETE /user/{uid}/todo/{tid}
	    @RequestMapping(path="/user/{uid}/todo/{tid}", method=RequestMethod.DELETE)
	    public Boolean destroy(HttpServletRequest req, HttpServletResponse res,@PathVariable  int uid,@PathVariable  int tid) {
			return todoDao.destroy(uid, tid);
	    	
	    }

	
}
