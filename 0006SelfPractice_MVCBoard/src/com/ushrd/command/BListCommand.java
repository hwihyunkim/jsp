package com.ushrd.command;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.dao.BDao;
import com.ushrd.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse respons) {
		// TODO Auto-generated method stub
		BDao dao=new BDao();
		ArrayList<BDto> dtos=dao.list();
		request.setAttribute("list", dtos);
		for(int i=0;i<dtos.size();i++){
			System.out.println(dtos.get(i).getbIndent());
		}
	}

}
