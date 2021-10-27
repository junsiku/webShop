package com.kosta.controller5;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kosta.model.MemberService;
import com.kosta.model.MemberVO;

/**
 * Servlet implementation class MemberServlet
 */
@WebServlet("/pro09/memberlogin")
public class MemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("login3.html").forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
MemberService service = new MemberService();

MemberVO member =  service.loginChk(Integer.parseInt(user_id), user_pwd);
if(member == null) {
	response.sendRedirect("memberlogin");
	
}else {
	HttpSession session = request.getSession();
	session.setAttribute("member", member);
	response.sendRedirect("../emp/emplist");
	
	
}
	
	
	
	
	
	}

}
