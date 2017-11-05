package security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import entities.User;

public class DataSecurityInterceptor implements HandlerInterceptor {

	 @Override
	 public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
	      throws Exception {
		 Object objUser = request.getSession().getAttribute("user");
			 System.out.println("*********************************");
			 System.out.println("User: " + objUser);
			 System.out.println("*********************************");
	    // 1
	    if (objUser != null) {
	    		User user = (User) objUser;
	    		 System.out.println("*********************************");
	   		 System.out.println("Actual User: " + user.getId());
	   		 System.out.println("*********************************");
	   		 
	   		 System.out.println("*********************************");
	   		 System.out.println("URI: " + request.getRequestURI().split("/")[4]);
	   		 System.out.println("*********************************");
	   		 
	   		 int id = Integer.parseInt(request.getRequestURI().split("/")[4]);
	   		 if( id == user.getId()) {
	   			return true; 
	   		 }
	    		
	    		
	    }
	    // 2
	    response.sendRedirect("/ngTodo/rest/auth/unauthorized");
	    return false;
	  }

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}
	}
