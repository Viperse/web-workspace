package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDAO;

public class ItemViewController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int num = Integer.parseInt(request.getParameter("itemId"));
		ItemDAO.getInstance().updateRecordCount(num);
		Item item = ItemDAO.getInstance().getItem(num);
		
		request.setAttribute("item", item);
		
		return new ModelAndView("itemView.jsp");
	}

}
