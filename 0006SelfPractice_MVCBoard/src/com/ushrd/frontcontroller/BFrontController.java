package com.ushrd.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ushrd.command.BCommand;
import com.ushrd.command.BContentCommand;
import com.ushrd.command.BDeleteCommand;
import com.ushrd.command.BListCommand;
import com.ushrd.command.BModifyCommand;
import com.ushrd.command.BReplyCommand;
import com.ushrd.command.BReplyViewCommand;
import com.ushrd.command.BWriteCommand;

/**
 * Servlet implementation class BFrontController
 */
@WebServlet("*.do")
public class BFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BFrontController() {
        super();
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
		System.out.println("actionDo");
		
		request.setCharacterEncoding("utf-8");
		
		String viewPage=null;
		BCommand command=null;
		
		String uri=request.getRequestURI();
		String conPath=request.getContextPath();
		String com=uri.substring(conPath.length());
		
		if(com.equalsIgnoreCase("/list.do")){
			command=new BListCommand();
			command.execute(request, response);
			viewPage="list.jsp";
		}else if(com.equals("/write_view.do")){
			viewPage="write_view.jsp";
		}else if(com.equals("/write.do")){
			command =new BWriteCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/content_view.do")){
			System.out.println("content_view"+request.getParameter("bId"));
			command=new BContentCommand();
			command.execute(request, response);
			viewPage="content_view.jsp";
		}else if(com.equals("/modify.do")){
			command =new BModifyCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/delete.do")){
			command = new BDeleteCommand();
			command.execute(request, response);
			viewPage="list.do";
		}else if(com.equals("/reply_view.do")){
			command =new BReplyViewCommand();
			command.execute(request, response);
			viewPage="reply_view.jsp";
		}else if(com.equals("/reply.do")){
			command=new BReplyCommand();
			command.execute(request, response);
			viewPage="list.do";
		}
		
		RequestDispatcher dispatcher= request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}


}
