package com.ushrd.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.dao.BDao;
import com.ushrd.dto.BDto;

public class BContentCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) {
	
		String bId=request.getParameter("bId");
		BDao dao=new BDao();
		BDto dto=dao.contentView(bId);
		request.setAttribute("content_view", dto);

	}

}
