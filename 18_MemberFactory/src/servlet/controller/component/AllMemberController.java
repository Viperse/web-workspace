package servlet.controller.component;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.controller.ModelAndView;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class AllMemberController implements Controller {

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<MemberVO> list = new ArrayList<>();
		list = MemberDAO.getInstance().showAllMember();
		String path = "index.jsp";
		
		if(list!=null) {
			request.setAttribute("list", list);
			path = "views/allshow.jsp";
		}
		
		return new ModelAndView(path);
	}

}
