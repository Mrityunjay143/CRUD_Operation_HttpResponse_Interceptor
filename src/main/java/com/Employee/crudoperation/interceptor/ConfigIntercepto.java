package com.Employee.crudoperation.interceptor;

//import org.aopalliance.intercept.Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class ConfigIntercepto extends WebMvcConfigurerAdapter  {
	
	@Autowired
	EmployeeInterceptor employeeInterceptor;

//    private final EmployeeInterceptor employeeInterceptor = new EmployeeInterceptor();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(employeeInterceptor);
    }

}
