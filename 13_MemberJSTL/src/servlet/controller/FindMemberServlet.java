package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.vo.MemberDTO;

@WebServlet("/FindMemberServlet")
public class FindMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MemberDTO dto = new MemberDTO();
		try {
			dto = MemberDAO.getInstance().findByIdName(request.getParameter("id"));
			
		} catch (SQLException e) {	
		}
		
		if(dto!=null) {
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("views/find_ok.jsp").forward(request, response);
		} else {
			response.sendRedirect("views/find_fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
