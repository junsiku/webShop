package com.kosta.controller4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/*
 * 바인딩 : 서블릿관련객체에 데이터를 저장
 * application(웹프로그램당).....ServletContext 객체....서버가 살아있는동안 유효하다. 
 * session(Browser당)..........HttpSession객체....Browser가 살아있는동안 유효하다.  
 * request(요청문서) ......HttpServletRequest....request가 살아있는동안 유효하다. 
 */


@WebServlet("/bind")
public class BindingTestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		ServletContext application = getServletContext();
		
		request.setAttribute("data1", "JUNrequest");
		session.setAttribute("data2", "JUNsession");
		application.setAttribute("data3", "JUNapplication");
		//2.요청미전달...다른요청으로 바뀐다. 
		//수정후다시조회, 삭제후다시조회,입력후 다시보여주기 
		//response.sendRedirect("emp/emplist");
		
		//1.요청전달...view와 연결하기 
		//조회후 보여주기, 입력창보여주기, 상세보기보여주기 
		RequestDispatcher rd = request.getRequestDispatcher("jsp/bindtest.jsp");
		rd.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
