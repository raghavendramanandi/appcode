package com.howtodoinjava.demo.filterconfig;

import javax.servlet.Filter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.howrtodoinjava.demo.filter.BasicFilter;

public class MyWebInitializer extends
		AbstractAnnotationConfigDispatcherServletInitializer {

	//...

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[]{new BasicFilter()};
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return null;
	}
}