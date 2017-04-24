package com.ushrd.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.dao.BDao;
import com.ushrd.dto.BDto;

public class BReplyViewCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) {
		// TODO Auto-generated method stub
		String bId=request.getParameter("bId");
		BDao dao=new BDao();
		BDto dto=dao.reply_view(bId);
		request.setAttribute("reply_view", dto);

	}

}
