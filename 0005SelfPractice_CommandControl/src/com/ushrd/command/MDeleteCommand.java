package com.ushrd.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.dao.MemberDAO;
import com.ushrd.dto.MemberDTO;

public class MDeleteCommand implements MCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		MemberDAO dao=new MemberDAO();
		ArrayList<MemberDTO> list=dao.memberSelect();
		request.setAttribute("list", list);
	}
	

}
