package servlet.controller.component;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servlet.controller.Controller;
import servlet.model.dao.MemberDAO;
import servlet.model.vo.MemberVO;

public class FindController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		
		String id = request.getParameter("id");
		MemberVO vo = new MemberVO();
		
		vo = MemberDAO.getInstance().findByIdName(id);
		
		if(vo!=null) {
			request.setAttribute("vo", vo);	
			return "find_ok.jsp";
		} else {
			return "find_fail.jsp";
		}
	}

}
