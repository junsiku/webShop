package com.kosta.controller4;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet�� ����� ��� web.xml�� �������� �����غ��� 
public class InitParamServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InitParamServlet3() {
		System.out.println("InitParamServlet3������");
	}
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
           
           String tel = getInitParameter("tel");
           String address = getInitParameter("address");
           System.out.println(tel);
           System.out.println(address);
         
	}

	 

}
