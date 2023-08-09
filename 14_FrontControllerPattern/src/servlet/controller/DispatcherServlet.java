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
import model.vo.MemberVO;


@WebServlet(urlPatterns="/front.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 요청이 어디에서 들어오는 요청인지... command 값 받는다.
		String command = request.getParameter("command");
		String path = "index.jsp";
		
		try {
			if(command.equals("register")) {
			path = register(request, response);
			} else if(command.equals("login")) {
				path = login(request, response);
			} else if(command.equals("AllMember")) {
				path = allMember(request, response);
			} else if(command.equals("FindMember")) {
				path = findMember(request, response);
			} else if(command.equals("Update")) {
				path = update(request, response);
			} else if(command.equals("logout")) {
				path = logout(request, response);
			}
  		} catch (SQLException e) {}
		
		// 네비게이션
		request.getRequestDispatcher(path).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected String register(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
		
		MemberVO vo = new MemberVO(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("addr"));
		
		MemberDAO.getInstance().registerMember(vo);
		return "index.jsp";
	}
	
	protected String login(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException, SQLException {
		HttpSession session = request.getSession();
		// 상태를 유지해야 하는 정보가 있을 때는 세션에 바인딩해 줘야 한다. ex) 로그인 정보, 장바구니 정보
		
		MemberVO vo = new MemberVO();
		
		vo = MemberDAO.getInstance().login(request.getParameter("id"), request.getParameter("password"));
		session.setAttribute("vo", vo);
		
		return "views/login_result.jsp";
	}
	
	protected String allMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		ArrayList<MemberVO> list = new ArrayList<>();
		
		list = MemberDAO.getInstance().showAllMember();
		request.setAttribute("list", list);
		
		return "views/allshow.jsp";
	}
	
	protected String findMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		MemberVO vo = new MemberVO();
		
		vo = MemberDAO.getInstance().findByIdName(request.getParameter("id"));
		
		if(vo!=null) {
			request.setAttribute("vo", vo);
			return "views/find_ok.jsp";
		} else {
			return "views/find_fail.jsp";
		}
	}
	
	protected String update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		MemberVO vo = new MemberVO(request.getParameter("id"), request.getParameter("password"),
				request.getParameter("name"), request.getParameter("address"));
		
		MemberDAO.getInstance().updateMember(vo);
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.setAttribute("vo", vo);
		}		
		
		return "views/update_result.jsp";
	}
	
	protected String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		
		HttpSession session = request.getSession();
		if(session.getAttribute("vo")!=null) {
			session.invalidate();
			return "views/logout.jsp";
		}
		
		return "index.jsp";
	}

}
