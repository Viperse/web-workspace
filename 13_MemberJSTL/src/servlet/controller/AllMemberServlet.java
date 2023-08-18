package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.MemberDAO;
import model.service.MemberService;
import model.vo.MemberDTO;

@WebServlet("/member/all")
public class AllMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<MemberDTO> list = new ArrayList<>();
//		MemberDAO dao = new MemberDAO();
		try {
			list = new MemberService().showAllMember();
			request.setAttribute("list", list);
			request.getRequestDispatcher("/views/allshow.jsp").forward(request, response);
		} catch (SQLException e) {
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
