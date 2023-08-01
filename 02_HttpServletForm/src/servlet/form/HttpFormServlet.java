package servlet.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HttpFormServlet
 */
public class HttpFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*
		 * 한글처리... 양방향!
		 * 
		 * */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		String[] menuList = request.getParameterValues("menu");
		String gender = request.getParameter("gender");
		char ch = gender.charAt(0);
		
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<p>" + "아이디 : " + userId +"</p>");
		out.println("<p>" + "비번 : " + userPwd +"</p>");
//		당신의 성별은 --> form.html 라디오 사용!
		out.print("<p> 좋아하는 음식은 : </p>");
		out.println("<ul>");
		
		for(int i=0; i<menuList.length; i++) {		
			out.print("<li>" + menuList[i] + "</li>");
		}
		out.println("</ul>");
		
		out.print("<p>성별 : ");
		out.println( ch == 'M' ? "남" : "여");
		out.println("</p>");
		
		out.println("</body></html>");
		
		out.close();
	}

}
