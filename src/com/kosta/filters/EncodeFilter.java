package com.kosta.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.catalina.filters.SetCharacterEncodingFilter;

/**
 * Servlet Filter implementation class EncodeFilter
 */
@WebFilter("/*")
public class EncodeFilter implements Filter {

   
    public EncodeFilter() {
    
    	
    	System.out.println(" EncodeFilter ������");
    	
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		System.out.println(" EncodeFilter �Ҹ���");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// ��û������
		long start = System.currentTimeMillis();
        System.out.println("��û������");
     request.setCharacterEncoding("utf-8");
		
		// pass the request along the filter chain
		chain.doFilter(request, response);
		
		//�����ϱ���
		System.out.println("�����ϱ���");
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
