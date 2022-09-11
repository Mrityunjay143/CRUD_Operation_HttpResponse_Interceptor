package com.Employee.crudoperation.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class EmployeeInterceptor implements HandlerInterceptor {

//	@Value("${user.password}")
//	public String SystemValue;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println(request.getHeader("Authorization"));

		if (request.getHeader("Authorization") == null) {
			System.out.println("Authorization not sent.");
			System.out.println("Validation NOK.");
			return false;
		} else if (request.getHeader("Authorization").equals("Success")) {
			System.out.println("Validation OK.");
			return true;
		} else {
			System.out.println("Validation NOK.");
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

		System.out.println("Post Handle method is Calling");
		
		

	}
	

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {

		System.out.println("Request and Response is completed");
	}
}
