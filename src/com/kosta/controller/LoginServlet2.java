package com.kosta.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet2
 */
@WebServlet("/login5")
public class LoginServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
 
	protected void doPost(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		 request.setCharacterEncoding("utf-8"); 
		 String id = request.getParameter("user_id");
		 String user_pw = request.getParameter("user_pw");
		 String user_address = request.getParameter("user_address");
		 System.out.println(id);
		 System.out.println(user_pw);
		 System.out.println(user_address);
		 request.setAttribute("major", "컴공");
		 request.setAttribute("phone", "010-1234-5678");

		 /*
		 PrintWriter out = response.getWriter();
		 out.print("<h1>aaaaa</h1>");
		 */
		 
		
		 //요청재지정...주소창은 바뀌지않고 전달받은 요청과 응답정보를 다른곳으로 위임한다.
		 RequestDispatcher rd =  
				 request.getRequestDispatcher("jsp/result.jsp");
		 rd.forward(request, response); 
	}

}





