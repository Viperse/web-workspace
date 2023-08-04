package servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.model.MemberDAO;
import servlet.model.MemberVO;


public class ViewMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. DAO 리턴 받기
		// 2. 바인딩
		// 3. 네비게이션 --> ViewMember.jsp
		ArrayList<MemberVO> list = new ArrayList<>();
		MemberDAO dao =  new MemberDAO();
				
		try {
			list = dao.showAllMember();
			request.setAttribute("list", list);
			
		} catch (SQLException e) {
		}
		
		request.getRequestDispatcher("ViewMember.jsp").forward(request, response);
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
