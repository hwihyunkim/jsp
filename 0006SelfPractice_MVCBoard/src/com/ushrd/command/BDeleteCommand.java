package com.ushrd.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.dao.BDao;

public class BDeleteCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) {
		String bId=request.getParameter("bId");
		BDao dao=new BDao();
		dao.delete(bId);
		// TODO Auto-generated method stub

	}

}
