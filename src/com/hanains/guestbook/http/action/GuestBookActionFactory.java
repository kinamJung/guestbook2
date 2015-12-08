package com.hanains.guestbook.http.action;

import com.hanains.http.action.Action;
import com.hanains.http.action.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	private static final String ADD_ACTION = "add";
	private static final String DELETE_ACTION = "delete";
	private static final String DELETE_FORM_ACTION = "deleteForm";
	
	@Override
	public Action getAction(String actionName) {		
		Action action = null;
		
		// a 파라미터도 없는 경우 null로 들어온다. (null을 equal할 시 Exception 발생)
		if (actionName == null) {
			action = new IndexAction();
		} else if (actionName.equals(ADD_ACTION)) {
			action = new AddAction();
		} else if (actionName.equals(DELETE_ACTION)) {
			action = new DeleteAction();
		} else if (actionName.equals(DELETE_FORM_ACTION)) {
			action = new DeleteFormAction();
		} else {
			action = new IndexAction();
		}

		return action;
	}
}
