package com.ushrd;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO2 {
//	private String url = "jdbc:oracle:thin:@localhost:1521:orcl1";
//	private String driver = "oracle.jdbc.driver.OracleDriver";
//	private String uid = "hwi";
//	private String upw = "hwi";
	
	private DataSource dataSource;
	
	
	
	public MemberDAO2(){
//		try {
//			Class.forName(driver);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		
		try {
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<MemberDTO> memberSelect(){
		ArrayList<MemberDTO> dtos=new ArrayList<MemberDTO>();
		
		Connection con=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		try {
//			con=DriverManager.getConnection(url, uid, upw);
			con=dataSource.getConnection();
			
//			stmt=con.createStatement();
			stmt=con.createStatement();
			
//			rs=stmt.executeQuery("select * from member");
			rs=stmt.executeQuery("select * from member");
			
			while(rs.next()){
				String id=rs.getString("id");
				String pw=rs.getString("pw");
				String name=rs.getString("name");
				Timestamp rDate=rs.getTimestamp("rDate");
				String address=rs.getString("address");
				
//				MemberDTO(String id, String pw, String name, Timestamp rDate, String address)
				
				MemberDTO dto =new MemberDTO(id,pw,name,rDate,address);
				
				dtos.add(dto);
				
			}
			
		} catch (Exception e) {
			
		} finally{
			try {
				if(stmt!=null)stmt.close();
				if(con!=null)con.close();
				if(rs!=null)rs.close();
			} catch (Exception e) {
				
			} 
		}
		
		
		return dtos;
		
	}
	
}
