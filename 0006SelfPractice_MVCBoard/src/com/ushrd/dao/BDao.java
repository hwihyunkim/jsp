package com.ushrd.dao;

import java.sql.*;
import java.util.ArrayList;

import javax.naming.*;//context,initialContext
import javax.sql.DataSource;
import com.ushrd.dto.BDto;

public class BDao {
	DataSource dataSource;
	public BDao(){
		try {
			Context context=new InitialContext();
			dataSource=(DataSource)context.lookup("java:comp/env/jdbc/Oracle11g");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BDto> list(){
		ArrayList<BDto> dtos=new ArrayList<BDto>();
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try {
			connection=dataSource.getConnection();
			String query="select * from mvc_voard order by bGroup desc, bStep asc";
			preparedStatement=connection.prepareStatement(query);
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bId=resultSet.getInt("bId");
				
				String bName=resultSet.getString("bName");
				String bTitle=resultSet.getString("bTitle");
				String bContent=resultSet.getString("bContent");
				Timestamp bDate=resultSet.getTimestamp("bDate");
				
				int bHit=resultSet.getInt("bHit");
				int bGroup=resultSet.getInt("bGroup");
				int pStep=resultSet.getInt("bStep");
				int bIndent=resultSet.getInt("bIndent");
				
				BDto dto=new BDto(bId,bName,bTitle,bContent,bDate
						,bHit,bGroup,pStep,bIndent);
				dtos.add(dto);			
				
			}
									
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}
		return dtos;
	}
	public BDto contentView(String bId) {
		upHit(bId);
		
		BDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{
			connection=dataSource.getConnection();
			String query="select * from mvc_board where bId=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next()){
				int bId2=resultSet.getInt("bId");
				
				String bName=resultSet.getString("bName");
				String bTitle=resultSet.getString("bTitle");
				String bContent=resultSet.getString("bContent");
				Timestamp bDate=resultSet.getTimestamp("bDate");
				
				int bHit=resultSet.getInt("bHit");
				int bGroup=resultSet.getInt("bGroup");
				int pStep=resultSet.getInt("bStep");
				int bIndent=resultSet.getInt("bIndent");
				
				dto=new BDto(bId2,bName,bTitle,bContent,bDate
						,bHit,bGroup,pStep,bIndent);			
			}
			
			
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}
		

		return dto;
	}
	private void upHit(String bId) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=dataSource.getConnection();
			String sql="update mvc_board set bHit=bHit+1 where bId=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bId);
			
			int rn = preparedStatement.executeUpdate();
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{

				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}

		
	}
	
	public void write(String bName,String bTitle,String bContent){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=dataSource.getConnection();
			String sql="insert into mvc_board(bId,bName,bTitle,bContent,bHit,bGroup,bStep,bIndent)"+
			" values (mvc_board_seq.nextval,?,?,?,0,mvc_board_seq.currval,0,0)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			
			int rn = preparedStatement.executeUpdate();
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{

				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}

	}
	public void modify(String bId, String bName, String bTitle, String bContent) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=dataSource.getConnection();
			String sql="update mvc_board set bName=?,bTitle=?,bContent=?  where bId=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setString(4, bId);
			
			int rn = preparedStatement.executeUpdate();
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{

				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}
		
	}
	public void delete(String bId) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=dataSource.getConnection();
			String sql="delete mvc_board where bId=?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bId);
			
			int rn = preparedStatement.executeUpdate();
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{

				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}

		
	}
	public BDto reply_view(String bId) {
		BDto dto=null;
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		try{
			connection=dataSource.getConnection();
			String query="select * from mvc_board where bId=?";
			preparedStatement=connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next()){
				
				
				String bName=resultSet.getString("bName");
				String bTitle=resultSet.getString("bTitle");
				String bContent=resultSet.getString("bContent");
				Timestamp bDate=resultSet.getTimestamp("bDate");
				
				int bHit=resultSet.getInt("bHit");
				int bGroup=resultSet.getInt("bGroup");
				int pStep=resultSet.getInt("bStep");
				int bIndent=resultSet.getInt("bIndent");
				
				dto=new BDto(Integer.parseInt(bId),bName,bTitle,bContent,bDate,bHit,bGroup,pStep,bIndent);
							
				
			}
			
			
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				if(resultSet != null)resultSet.close();
				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}
		
		return dto;
	}
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep,
			String bIndent) {
		
		replyShape(bGroup,bStep);
		
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=dataSource.getConnection();
			String sql="insert into mvc_board(bId,bName,bTitle,bContent,bGroup,bStep,bIndent) "+
			"values(mvc_board_seq.nextval,?,?,?,?,?,?)";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep)+1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent)+1);
			
			int rn = preparedStatement.executeUpdate();
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{

				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}
		
	}
	
	private void replyShape(String strGroup,String strStep){
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		try{
			connection=dataSource.getConnection();
			String sql="update mvc_board set bStep=bStep+1 where bGroup=? and bStep>?";
			preparedStatement=connection.prepareStatement(sql);
			preparedStatement.setInt(1, Integer.parseInt(strGroup));
			preparedStatement.setInt(2, Integer.parseInt(strStep));
			
			int rn = preparedStatement.executeUpdate();
						
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{

				if(preparedStatement != null)preparedStatement.close();
				if(connection != null)connection.close();
				
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
			
		}

	}
	
	
}
