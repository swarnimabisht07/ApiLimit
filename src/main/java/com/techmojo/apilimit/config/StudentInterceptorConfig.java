package com.techmojo.apilimit.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.techmojo.apilimit.interceptor.StudentInterceptor;


@Component
public class StudentInterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private StudentInterceptor studentInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(studentInterceptor).addPathPatterns("/apilimit/student/getstudent");
	}

}
