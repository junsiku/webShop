package com.kosta.controller.pro12;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmployeeVO;

/**
 * Servlet implementation class SessionTest
 */
@WebServlet("/pro12/sess")
public class SessionTest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw = response.getWriter();
		//세션이 없으면 세션을 생성하거나 있으면 열기
        //브라우저처음 열기:세션을 생성
		//브라우저강 열려있어서 다른요청하고있었음:있으면 열기
		HttpSession session = request.getSession();
		session.setAttribute("name", "이순신");
		session.setAttribute("age", 100);
		 EmployeeVO emp = new EmployeeVO();
		 emp.setFirst_name("준식");
		 session.setAttribute("emp", emp);
		
		pw.println("<html><body>");
		pw.println("<h1>세션에 이름을 바인딩합니다.</h1>");
		pw.println("<a href='test01/session1.jsp'>첫번째 페이지로 이동하기 </a>");
		pw.println("</body></html>"); 
		
	}

}
