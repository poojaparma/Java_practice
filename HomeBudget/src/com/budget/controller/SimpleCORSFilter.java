/*package com.budget.controller;


import java.io.IOException;

import javax.servlet.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

//import com.thetransactioncompany.cors.CORSFilter;
public class SimpleCORSFilter extends OncePerRequestFilter {
	private static final Log LOG = LogFactory.getLog(SimpleCORSFilter.class);
 
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		LOG.error("do filter hit");
		System.out.println("hit syso");
		if (request.getHeader("Access-Control-Request-Method") != null &&  !request.equals("") "OPTIONS".equals(request.getMethod())) {
		//	LOG.error("Sending Header....");
			System.out.println("sending");
			// CORS "pre-flight" request
			response.addHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
			response.addHeader("Access-Control-Allow-Headers", "Authorization");
            response.addHeader("Access-Control-Allow-Headers", "Content-Type");
			response.addHeader("Access-Control-Max-Age", "1");
		}
		
		filterChain.doFilter(request, response);
	}
 
}
@Component
public class SimpleCORSFilter implements Filter {
 
    @Override
    public void init(FilterConfig arg0) throws ServletException {}
 
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp,
            FilterChain chain) throws IOException, ServletException {
        // TODO Auto-generated method stub
        HttpServletResponse response=(HttpServletResponse) resp;
 
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");
 
        chain.doFilter(req, resp);
    }
 
    @Override
    public void destroy() {}
 
}*/