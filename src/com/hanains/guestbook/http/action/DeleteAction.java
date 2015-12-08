package com.hanains.guestbook.http.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.guestbook.dao.GuestBookDAO;
import com.hanains.guestbook.vo.GuestBookVo;
import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class DeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		request.setCharacterEncoding("UTF-8");
		
		//Get parameter
		String noTemp = request.getParameter("no");
		long no = Long.parseLong(noTemp);	
		String password = request.getParameter("password");

		// Define
		GuestBookVo vo = new GuestBookVo();
		GuestBookDAO dao = new GuestBookDAO();
		
		//Setter
		vo.setNo(no);
		vo.setPassword(password);
		
		//delete VO
		dao.delete(vo);
		
		//Redirect
		HttpUtil.redirect(response, "/guestbook2/gs");
		
	}
	
}
