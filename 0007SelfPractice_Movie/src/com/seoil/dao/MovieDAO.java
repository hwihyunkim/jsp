package com.seoil.dao;

import java.sql.*;
import java.util.ArrayList;

import com.seoil.dto.MovieVO;

import util.DBManager;

public class MovieDAO {
	private MovieDAO(){
		super();
	}
	
	public static void SetInstance(MovieDAO instance){
		MovieDAO.instance = instance;
	}
	
	private static MovieDAO instance=new MovieDAO();
	
	public static MovieDAO getInstance(){
		return instance;
	}
	
	public ArrayList<MovieVO> selectAllMovie(){
		String sql="select * from movie order by code desc";
		ArrayList<MovieVO> productList=new ArrayList<MovieVO>();
		
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBManager.getConnection();
			psmt=conn.prepareStatement(sql);
			rs=psmt.executeQuery();
			
			while(rs.next()){
				MovieVO mvo=new MovieVO();
				mvo.setCode(rs.getInt("code"));
				mvo.setTitle(rs.getString("title"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setDirector(rs.getString("director"));
				mvo.setActor(rs.getString("actor"));
				mvo.setPoster(rs.getString("poster"));
				mvo.setSynopsis(rs.getString("synopsis"));
				productList.add(mvo);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}finally{
			util.DBManager.close(rs, psmt, conn);
		}
		
		
		return productList;
	}
	
	public void insertMovie(MovieVO mVO){

		String sql="insert into movie values(movie_seq.nextval, ?,?,?,?,?,?)";
		Connection conn=null;
		PreparedStatement psmt=null;
		
		try {
			conn=DBManager.getConnection();
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, mVO.getTitle());
			psmt.setInt(2, mVO.getPrice());
			psmt.setString(3, mVO.getDirector());
			psmt.setString(4, mVO.getActor());
			psmt.setString(5, mVO.getPoster());
			psmt.setString(6, mVO.getSynopsis());
			psmt.executeQuery();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			util.DBManager.close(psmt, conn);
		}
		
		
	}
	
	public MovieVO selectProductByCode(int code){
		MovieVO mvo=null;
		String sql="select * from movie where code=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		
		try {
			conn = DBManager.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, code);
			rs=psmt.executeQuery();
			
			if(rs.next()){
				mvo = new MovieVO();
				mvo.setCode(rs.getInt("code"));
				mvo.setTitle(rs.getString("title"));
				mvo.setPrice(rs.getInt("price"));
				mvo.setDirector(rs.getString("director"));
				mvo.setActor(rs.getString("acto"));
				mvo.setPoster(rs.getString("poster"));
				mvo.setSynopsis(rs.getString("synopsis"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			util.DBManager.close(rs, psmt, conn);
		}
		return mvo;
		
	}
	
	public void deleteMovie(int code){
		String sql="deleteFrom movie where code=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			conn=DBManager.getConnection();
			psmt=conn.prepareStatement(sql);
			psmt.setInt(1, code);
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			util.DBManager.close(psmt, conn);
		}
	}
	
	public void updateProduct(MovieVO mVO){
		String sql="update movie set title=?,price=?,director=?,actor=?,poster=?,synopsis=? WHERE code=?";
		Connection conn=null;
		PreparedStatement psmt=null;
		try {
			conn = DBManager.getConnection();
			psmt=conn.prepareStatement(sql);
			
			psmt.setString(1, mVO.getTitle());
			psmt.setInt(2, mVO.getPrice());
			psmt.setString(3, mVO.getDirector());
			psmt.setString(4, mVO.getActor());
			psmt.setString(5, mVO.getPoster());
			psmt.setString(6, mVO.getSynopsis());
			psmt.setInt(7, mVO.getCode());
			psmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			util.DBManager.close(psmt , conn);
		}
		
	}
}
