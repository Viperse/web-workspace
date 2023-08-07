package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberDTO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();
		
		try {
			dto = dao.login(request.getParameter("id"), request.getParameter("password"));
			session.setAttribute("dto", dto);
		} catch (SQLException e) {
		}
		
		if(dto!=null) {
			request.getRequestDispatcher("views/login_result.jsp").forward(request, response);
		} else {
			response.sendRedirect("index.jsp");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
