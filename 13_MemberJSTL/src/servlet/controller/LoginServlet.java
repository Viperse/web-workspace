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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// 상태를 유지해야 하는 정보가 있을 때는 세션에 바인딩해 줘야 한다. ex) 로그인 정보, 장바구니 정보
		
		MemberDTO dto = new MemberDTO();
		
		try {
			dto = MemberDAO.getInstance().login(request.getParameter("id"), request.getParameter("password"));
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
