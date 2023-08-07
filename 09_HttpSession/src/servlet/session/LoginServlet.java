package servlet.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.MemberVO;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 세션을 하나 받아온다... requset.getSession();
		// 쿠키는 객체로 저장 불가능, 세션은 가능하고 보안상으로도 good (로그인 정보는 객체기 때문에 객체로 저장해야 하는 세션이 좋음)
		HttpSession session = request.getSession();
		
		// 2. 폼에 입력된 값을 가지고 객체 생성... MemberVO (DAO 생략)
		MemberVO vo = new MemberVO(request.getParameter("id"), request.getParameter("password"), "김도경", "서울");
		
		// 3. 세션에 바인딩
		session.setAttribute("vo", vo);
		
		// 4. 네비게이션
		PrintWriter out = response.getWriter();
		out.println("<a href=ProductServlet>ProductServlet...</a>");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
