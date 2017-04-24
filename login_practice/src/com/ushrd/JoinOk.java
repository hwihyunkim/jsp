package com.ushrd;

import java.io.IOException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class JoinOk
 */
@WebServlet("/JoinOk")
public class JoinOk extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private Connection connection;
	private Statement statement;
	
	private String name, id, pw, phone1, phone2, phone3, gender;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinOk() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		name=request.getParameter("name");
		id=request.getParameter("id");
		pw=request.getParameter("pw");
		phone1=request.getParameter("phone1");
		phone2=request.getParameter("phone2");
		phone3=request.getParameter("phone3");
		gender=request.getParameter("gender");
		
		String query="insert into memberA values('"+name+"', '"+id+"', '"+pw+"', '"+phone1+"', '"+phone2+"', '"+phone3+"', '"+gender+"')";
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl1", "hwi", "hwi");
			statement=connection.createStatement();
			int i = statement.executeUpdate(query);
			if(i==1){
				System.out.println("가입성공");
				response.sendRedirect("05login/joinREsult.jsp");
				
			}else{
				System.out.println("가입실패");
				response.sendRedirect("05login/join.html");
				
			}
		}catch(Exception e){
			response.sendRedirect("05login/join.html");
			e.printStackTrace();
		}finally{
			try {
				if(statement!=null){
					statement.close();
				}
				if(connection!=null){
					connection.close();
				}
			} catch (Exception e2) {
 
			}
		}
	}

}
