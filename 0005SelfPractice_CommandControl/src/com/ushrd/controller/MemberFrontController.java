package com.ushrd.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.command.MCommand;
import com.ushrd.command.MDeleteCommand;
import com.ushrd.dao.MemberDAO;
import com.ushrd.dto.MemberDTO;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class MemberFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MemberFrontController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		actionDo(request,response);
	}
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String viewPage=null;
		MemberDAO dao=new MemberDAO();
		MCommand mc=null;
		
		String uri=request.getRequestURI();
		System.out.println("uri"+uri);
		String conPath=request.getContextPath();
		System.out.println("conPath"+conPath);
		String command=uri.substring(conPath.length());
		System.out.println("command"+command);
		
		if(command.equals("/insert.do")){
			viewPage="insert.jsp";
		}else if(command.equals("/update.do")){
			viewPage="update.jsp";
		}else if(command.equals("/select.do")){
			viewPage="selectCommend.do";
		}else if(command.equals("/delete.do")){
			
			/*ArrayList<MemberDTO> list=dao.memberSelect();
			request.setAttribute("list", list);*/
			mc=new MDeleteCommand();
			mc.execute(request, response);
						
			viewPage="delete.jsp";
		}else if(command.equals("/insertCommend.do")){
			MemberDTO dto=new MemberDTO(request.getParameter("name"),
					request.getParameter("id"),
					request.getParameter("pw"),
					request.getParameter("phone")
					);
			dao.memberInsert(dto);
			viewPage="select.do";
		}else if(command.equals("/updateCommend.do")){
			
			dao.memberUpdate(request.getParameter("id1"), request.getParameter("id2"));
			viewPage="select.do";
			//viewPage="selectCommend.do";
			
		}else if(command.equals("/selectCommend.do")){
			
			ArrayList<MemberDTO> list=dao.memberSelect();
			request.setAttribute("list", list);
			//System.out.println("a"+list);
			viewPage="select.jsp";			
			
		}else if(command.equals("/deleteCommend.do")){
			String[]values=request.getParameterValues("info");

			for(int i=0;i<values.length;i++){
				dao.memberDelete(values[i]);
			}
			viewPage="select.do";			
		}
		
		System.out.println(viewPage);
		RequestDispatcher dispatcher=request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);	
	}

}
