package com.ushrd.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.ushrd.dto.MemberDTO;

public class MemberDAO {
	private DataSource dataSource;
	public MemberDAO(){
		try{
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	//select
	public ArrayList<MemberDTO> memberSelect(){
		ArrayList<MemberDTO> list=null;
		String sql="select * from member_commandControl";
		Connection con=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			rs=pstmt.executeQuery();
			list=new ArrayList<MemberDTO>();
			
			while(rs.next()){
				String name=rs.getString("name");
				String id=rs.getString("id");
				String pw=rs.getString("pw");
				String phone=rs.getString("phone");
				
				MemberDTO dto=new MemberDTO(name,id,pw,phone);
				list.add(dto);
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
				if(rs!=null){rs.close();}
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		return list;
	}
	//insert
	public boolean memberInsert(MemberDTO dto){
		boolean check=false;
		String sql="insert into member_commandControl values(?,?,?,?)";
		Connection con=null;
		PreparedStatement pstmt=null;
		try{
				con=dataSource.getConnection();
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPw());
				pstmt.setString(3, dto.getName());
				pstmt.setString(4, dto.getPhone());
				
				int count=pstmt.executeUpdate();
				if(count>0){
					check=true;
				}
				
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try{
		
				if(pstmt!=null){pstmt.close();}
				if(con!=null){con.close();}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	
		
		return check;
	}
	//update
	public boolean memberUpdate(String id1,String id2){
		boolean check = false;
		String sql ="update member_commandControl set id=? where id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id1);
			pstmt.setString(2, id2);
			
			int rs=pstmt.executeUpdate();
			if(rs>0){
				check=true;
			}
	
		}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		return check;
	}
	
	public boolean memberDelete(String id){
		boolean check = false;
		String sql ="delete from member_commandControl where id=?";
		Connection con=null;
		PreparedStatement pstmt=null;
		
		try{
			con=dataSource.getConnection();
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, id);
						
			int rs=pstmt.executeUpdate();
			if(rs>0){
				check=true;
			}
	
		}catch(Exception e){
				e.printStackTrace();
			}finally{
				try{
					if(pstmt!=null){pstmt.close();}
					if(con!=null){con.close();}
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		return check;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
