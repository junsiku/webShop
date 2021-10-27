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
 * ���ε� : �������ð�ü�� �����͸� ����
 * application(�����α׷���).....ServletContext ��ü....������ ����ִµ��� ��ȿ�ϴ�. 
 * session(Browser��)..........HttpSession��ü....Browser�� ����ִµ��� ��ȿ�ϴ�.  
 * request(��û����) ......HttpServletRequest....request�� ����ִµ��� ��ȿ�ϴ�. 
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
		//2.��û������...�ٸ���û���� �ٲ��. 
		//�����Ĵٽ���ȸ, �����Ĵٽ���ȸ,�Է��� �ٽú����ֱ� 
		//response.sendRedirect("emp/emplist");
		
		//1.��û����...view�� �����ϱ� 
		//��ȸ�� �����ֱ�, �Է�â�����ֱ�, �󼼺��⺸���ֱ� 
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
