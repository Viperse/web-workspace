package controller;

import java.util.ArrayList;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemDAO;

public class ItemListController implements Controller{

	@Override
	public ModelAndView handle(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ArrayList<Item> list = ItemDAO.getInstance().getAllItem();
		request.setAttribute("list", list);
		
		ArrayList<String> fruits = new ArrayList<>();
		// 쿠키 정보 받아오는 로직
		Cookie[] cList = request.getCookies();
		if(cList!=null) {
			for(Cookie c : cList) {
				if(c.getName().startsWith("fruit-")) {
					fruits.add(c.getValue());
				}
			}
		}
		request.setAttribute("fruits", fruits);
		
		return new ModelAndView("itemList.jsp");
	}

}
