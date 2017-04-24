package com.movie_prj;

import java.io.IOException;
import java.sql.*;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MovieInsert
 */
@WebServlet("/MovieInsert")
public class MovieInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Connection connection;
//	private Statement statement;
	private ResultSet resultset;
			
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
	private String uid = "hwi";
	private String upw = "hwi";
	
	private String title, price, director, actor, poster, synopsis;
	
	private Integer code;
	
	

    
	HttpSession httpSession;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		actionFile(request, response);
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		actionFile(request, response);
		actionDo(request, response);
	}
	
	private void actionFile(HttpServletRequest request, HttpServletResponse response){
		String path = "C:\\EclipseJSP\\workspace\\movie_prj\\WebContent\\images";
		System.out.println(path);
		
		int size=1024*1024*10; //10M
		String file="";
		String oriFile="";
		
		try{
			MultipartRequest multi=new MultipartRequest(
					request,path,size,"utf-8",new DefaultFileRenamePolicy());
			Enumeration files=multi.getFileNames();
			String str=(String)files.nextElement();
			poster=str;
			file=multi.getFilesystemName(str);
			oriFile=multi.getOriginalFileName(str);
			
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		ResultSetMetaData rsmd =null;
		httpSession = request.getSession();
		
		String query="insert into movie values(?,'?',?,'?','?','?','?')";
		
		System.out.println(query);
		try {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			connection = DriverManager.getConnection(url, uid, upw);
			
			rsmd=resultset.getMetaData();
			int rowCnt=rsmd.getColumnCount();
			
			code=rowCnt;
			title=request.getParameter("title");
			price=request.getParameter("price");
			director=request.getParameter("director");
			actor=request.getParameter("actor");
			synopsis=request.getParameter("synopsis");
			
			System.out.println(query);
			
			PreparedStatement pstmt = connection.prepareStatement(query);
			pstmt.setString(1, "code");
			pstmt.setString(1, "title");
			pstmt.setString(1, "price");
			pstmt.setString(1, "director");
			pstmt.setString(1, "actor");
			pstmt.setString(1, "poster");
			pstmt.setString(1, "synopsis");
			
			pstmt.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}

}
