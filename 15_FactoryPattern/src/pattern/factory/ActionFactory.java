package pattern.factory;

import pattern.action.Action;
import pattern.action.AddAction;
import pattern.action.DeleteAction;

/*
 * Action들을 만들어내는 공장...
 * Dispatcher에서 보내 주는 command 값에 따라서 생성하는 Action이 달라진다.
 * 여러 개의 Action들을 만들어내지만 Factory는 단 하나면 충분하기 때문에 싱글톤 패턴으로 작성된다.
 * */

public class ActionFactory {
	
	private static ActionFactory factory = new ActionFactory();
	private ActionFactory() {
		System.out.println("ActionFactory Creating...");
	}
	
	public static ActionFactory getInstance() {
		return factory;
	}
	
	public Action createAction(String command) {
		Action action = null;
		
		if(command.equals("INSERT")) {
			action = new AddAction();
		} else if(command.equals("DELETE")) {
			action = new DeleteAction();
		}
		return action;
	}
}
