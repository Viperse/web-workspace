package member.controller.component;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.controller.Controller;
import member.controller.ModelAndView;
import member.model.dao.MemberDAO;
import member.model.service.MemberService;
import member.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String addr = request.getParameter("address");
		
		String[] idList = request.getParameterValues("checkId");
		MemberVO vo = new MemberVO();
		if(id!="") vo.setId(id);
		if(addr!="") vo.setAddress(addr);
		
		String path = "views/find_fail.jsp";
		
		List<MemberVO> list = new MemberService().findByIdMember(idList);
		
		if(list!=null) {
			request.setAttribute("list", list);
			path = "views/allshow.jsp";
		}
		
		return new ModelAndView(path);
	}

}
