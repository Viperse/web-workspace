package member.controller.component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class RegisterController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		MemberVO vo = new MemberVO(id, password, name, address);
		new MemberService().registerMember(vo);
		
		// 데이터 바인딩 - request, session, context
		// setAttribute
		// request <-- 범위가 가장 좁아요
		// session <-- 로그인하는 순간부터 로그아웃까지
		// context <-- 범위가 가장 넓음~~ 거의 사용 X
		String path = "index.jsp";
		
		return new ModelAndView(path, true);
	}

}
