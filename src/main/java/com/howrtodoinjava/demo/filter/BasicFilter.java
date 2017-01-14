package com.howrtodoinjava.demo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class BasicFilter implements Filter {

	public void destroy() {
		// ...
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	public void doFilter(ServletRequest request,
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		try {
			System.out.println("Ganapa");
			chain.doFilter(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
                               .forward(request, response);
		}

	}

}