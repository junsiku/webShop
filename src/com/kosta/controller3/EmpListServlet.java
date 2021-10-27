package com.kosta.controller3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.EmpService;
import com.kosta.model.MemberVO;

/**
 * Servlet implementation class EmpListServlet
 */
@WebServlet("/emp/emplist")
public class EmpListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
   		//1.request
   		String data1 = (String)request.getAttribute("data1");
   		//2.session
   		HttpSession session = request.getSession();
   		String data2 = (String)session.getAttribute("data2");
   		//3.application
   		ServletContext application = getServletContext();
   		String data3 = (String)application.getAttribute("data3");
   		
   		System.out.println("request:" + data1);
   		System.out.println("session:" + data2);
   		System.out.println("application:" + data3);
   		//////////////////////////////////////////////////////////////////
   		String user_id = (String) session.getAttribute("user_id");
		String user_pw = (String) session.getAttribute("user_pw");
		String phone = (String) session.getAttribute("phone");
		String address = (String) session.getAttribute("address");
		String email = (String) session.getAttribute("email");
		System.out.println("user_id:" + user_id);
		System.out.println("user_pw:" + user_pw);
		System.out.println("phone:" + phone);
		System.out.println("address:" + address);
		System.out.println("email:" + email);
	 
   		///////////////////////////////////////////
		//���ǿ� ����� ����� ���ٸ� �α��ξ��Ѱ�
		//�α��ξ��� ������������ �Ұ�. 
	    Object obj = session.getAttribute("member");
	   	if(obj == null) {
	 		System.out.println("���ǿ� ����� ����� ���ٸ� �α��ξ��Ѱ� .�α��ξ��� ������������ �Ұ�");
		    response.sendRedirect("../pro09/memberlogin");
		    return;
		}
   		///////////////////////////////////////////
   		EmpService service = new EmpService();
		request.setAttribute("emplist", service.selectAll());
		RequestDispatcher rd = request.getRequestDispatcher("emplist.jsp");
		rd.forward(request, response);
   	}

	/*
	 * ���ε� : �������ð�ü�� �����͸� ����
	 * application(�����α׷���).....ServletContext ��ü....������ ����ִµ��� ��ȿ�ϴ�. 
	 * session(Browser��)..........HttpSession��ü....Browser�� ����ִµ��� ��ȿ�ϴ�.  
	 * request(��û����) ......HttpServletRequest....request�� ����ִµ��� ��ȿ�ϴ�. 
	 */

}
