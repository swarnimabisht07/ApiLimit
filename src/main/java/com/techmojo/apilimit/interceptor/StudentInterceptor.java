package com.techmojo.apilimit.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.techmojo.apilimit.beans.APILimitResponse;
import com.techmojo.apilimit.util.UtilServices;

@Component
public class StudentInterceptor implements HandlerInterceptor {

	@Autowired
	private UtilServices utilServices;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		int studentId = Integer.parseInt(request.getParameter("studentId"));
		APILimitResponse APILimitResponse = utilServices.checkAPILimit(studentId);
		boolean status=APILimitResponse.isStatus();
		if (status)
			return true;
		else {
			response.getWriter().write("API LIMIT REACHED "+ String.format("%.02f", 60-APILimitResponse.getTime()) + " Minutes Remaning");
			return false;
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception exception) throws Exception {
	}
}
