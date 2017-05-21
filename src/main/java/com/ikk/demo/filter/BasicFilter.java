package com.ikk.demo.filter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import com.ikk.demo.service.ClickService;

public class BasicFilter implements Filter {

	@Autowired
	ClickService clickService;
	
	public void destroy() {
		// ...
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		//
	}

	public void doFilter(ServletRequest request,
               ServletResponse response, FilterChain chain)
		throws IOException, ServletException {

		/*StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = null;*/
		
		try {
			System.out.println("Ganapa");
			/*InputStream inputStream = request.getInputStream();
			if (inputStream != null) {
			       bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
			       char[] charBuffer = new char[128];
			       int bytesRead = -1;
			       while ((bytesRead = bufferedReader.read(charBuffer)) > 0) {
			         stringBuilder.append(charBuffer, 0, bytesRead);
			       }
			     } else {
			       stringBuilder.append("");
			     }
			String [] messages =  stringBuilder.toString().split("\"*\"");
			clickService.Varify(,messages[3]);*/
			chain.doFilter(request, response);
		} catch (Exception ex) {
			ex.printStackTrace();
			request.setAttribute("errorMessage", ex);
			request.getRequestDispatcher("/WEB-INF/views/jsp/error.jsp")
                               .forward(request, response);
		}

	}

}