package controllers;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.AuthDAO;
import entities.User;

@RestController
@RequestMapping("/auth") //adds /auth before all other mappings.
public class AuthController {
  
  @Autowired
  private AuthDAO authDAO;

  @RequestMapping(path = "/register", method = RequestMethod.POST)
  public User register(HttpSession session, @RequestBody User user, HttpServletResponse res) {
	   User u = authDAO.register(user);
	   if(u != null) {
		   session.setAttribute("user", u); 
		   res.setStatus(201);
		   return u;
	   }
	   res.setStatus(422);
	   	return null;
    
  }
  
  @RequestMapping(path = "/login", method = RequestMethod.POST)
  public User login(HttpSession session, @RequestBody User user, HttpServletResponse res) {
	  User u = authDAO.login(user);
		if(u != null) {
			  session.setAttribute("user", u);
			  return u;
		}
		res.setStatus(401);
		return null;
  }
  
  @RequestMapping(path = "/logout", method = RequestMethod.POST)
  public Boolean logout(HttpSession session, HttpServletResponse response) {
	  session.removeAttribute("user");
	   if(session.getAttribute("user") == null) {
	    return true;
	   }
	  return false;
	   
  }
  
  @RequestMapping(path = "/unauthorized")
  public String unauth(HttpServletResponse response) {
    response.setStatus(401);
    return "unauthorized";
  }
}
