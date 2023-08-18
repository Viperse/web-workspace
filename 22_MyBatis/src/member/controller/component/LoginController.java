package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class LoginController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = "views/login.html";
		
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		MemberVO m = new MemberVO();
		m.setId(id);
		m.setPassword(password);
		MemberVO vo = new MemberService().login(m);
		
		System.out.println(vo);
		
		if(vo!=null) {
			session.setAttribute("vo", vo);
			path = "views/login_result.jsp";
		}
		
		return new ModelAndView(path, true);
	}
	

}
