package com.ushrd.dto;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

public class MemberDao {
	public static final int MEMBER_NOEXISTENT=0;
	public static final int MEMBER_EXISTENT=1;
	
	public static final int MEMBER_JOIN_FAIL=0;
	public static final int MEMBER_JOIN_SUCCESS=1;
	
	public static final int MEMBER_LOGIN_PW_NO_GOOD=0;
	public static final int MEMBER_LOGIN_SUCCESS=1;
	public static final int MEMBER_LOGIN_IS_NOT=-1;
	
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance(){
		return instance;
	}
	
	private Connection getConnection(){
		Context context=null;
		DataSource dataSource=null;
		Connection connection=null;
		try {
			context = new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
			connection = dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public int insertMember(MemberDto dto){
		int ri=MemberDao.MEMBER_NOEXISTENT;
		Connection connection=null;
		PreparedStatement pstmt=null;
		String query = "inserty into memeber values(?,?,?,?,?,?)";
		try{
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1, dto.getId());
			pstmt.setString(2, dto.getPw());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getMail());
			pstmt.setTimestamp(5, dto.getrDate());
			pstmt.setString(6, dto.getAddress());
			pstmt.executeLargeUpdate();
			
			ri=MemberDao.MEMBER_JOIN_SUCCESS;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return ri;
		
		
		
	}
	
	public int userCheck(String id, String pw){
		int ri=0;
		String dbPw;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		String query="select pw from member where id=?";
		try {
			connection = getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1, id);
			set=pstmt.executeQuery();
			
			if(set.next()){
				dbPw=set.getString("pw");
				if(dbPw.equals(pw)){
					ri=MemberDao.MEMBER_LOGIN_SUCCESS;
				}else{
					ri=MemberDao.MEMBER_LOGIN_PW_NO_GOOD;
				}
			}else{
				ri=MemberDao.MEMBER_LOGIN_IS_NOT;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return ri;
	}
	
	public MemberDto getMember(String id){
		Connection connection = null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		String query="select * from member where id=?";
		MemberDto dto=null;
		try {
			connection=getConnection();
			pstmt=connection.prepareStatement(query);
			//System.out.println(query);
			pstmt.setString(1, id);
			System.out.println(id);
			set=pstmt.executeQuery();
			if(set.next()){
				dto=new MemberDto();
				dto.setId(set.getString("id"));
				dto.setPw(set.getString("pw"));
				dto.setName(set.getString("name"));
				dto.setMail(set.getString("mail"));
				dto.setrDate(set.getTimestamp("date1"));
				dto.setAddress(set.getString("address"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				if(pstmt!=null)pstmt.close();
				if(connection!=null)connection.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return dto;
	}
	
	public int updateMember(MemberDto dto){
		int ri=0;
		Connection connection=null;
		PreparedStatement pstmt=null;
		String query="update member set pw=?, mail=?, address=? where id=?";
		try {
			connection =getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1,  dto.getPw());
			pstmt.setString(2,  dto.getMail());
			pstmt.setString(3,  dto.getAddress());
			pstmt.setString(4,  dto.getId());
			
			ri=pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return ri;
	}
	
	public int confirmId(String id){
		int ri=0;
		
		Connection connection=null;
		PreparedStatement pstmt=null;
		ResultSet set=null;
		String query="select id from member where id=?";
		try {
			connection = getConnection();
			pstmt=connection.prepareStatement(query);
			pstmt.setString(1, id);
			set=pstmt.executeQuery();
			if(set.next()){
				ri=MemberDao.MEMBER_EXISTENT;
				
			}else{
				ri=MemberDao.MEMBER_NOEXISTENT;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try{
				pstmt.close();
				connection.close();
			}catch(Exception e2){
				e2.printStackTrace();
			}
		}
		
		return ri;
	}

}
