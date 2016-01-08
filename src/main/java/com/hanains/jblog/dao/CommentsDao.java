package com.hanains.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.CommentsVo;

@Repository
public class CommentsDao {
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try{
			//1.드라이버 로딩.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.커넥션 만들기.
			String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dbURL,"webdb","webdb");
		}catch(ClassNotFoundException ex){
			
		}
		return conn;
	}
	
	public List<CommentsVo> getList(){
		List<CommentsVo> list = new ArrayList<CommentsVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CommentsVo vo = null;
		
		try{
			//1.get Connection
			conn = getConnection();
			//2.prepare statement
			String sql = "select content, post_no as postNo ,member_id as memberId, reg_date as regDate from comments";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				String content = rs.getString(1);
				Long postNo = rs.getLong(2);
				String memberId = rs.getString(3);
				String regDate = rs.getString(4);
				
				vo = new CommentsVo();
				vo.setContent(content);
				vo.setPostNo(postNo);
				vo.setMemberId(memberId);
				vo.setRegDate(regDate);
				
				list.add(vo);
			}
		}catch(SQLException ex){
			System.out.println("SQL Error : "+ ex);
		}finally{
			try{
				if(conn != null){
					conn.close();
				}
				if( pstmt != null){
					pstmt.close();
				}
				if(rs != null){
					rs.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
	public List<CommentsVo> getCommentsByNo(Long voNo){
		List<CommentsVo> list = new ArrayList<CommentsVo>();
		CommentsVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			conn = getConnection();
			
			//3.statement 준비
			String sql ="select content, member_id as memberId, reg_date as regDate "+
						"from comments where post_no = ?";
			pstmt = conn.prepareStatement(sql);
			
			//4.binding
			pstmt.setLong(1, voNo);
			
			//5.SQL 실행
			rs = pstmt.executeQuery();
			while(rs.next()){
				String content = rs.getString(1);
				String memberId = rs.getString(2);
				String regDate = rs.getString(3);
				
				vo = new CommentsVo();
				vo.setContent(content);
				vo.setMemberId(memberId);
				vo.setRegDate(regDate);
				list.add(vo);
			}
					
		}catch(SQLException ex){
			System.out.println("SQL Error :: "+ex);
		}finally{
			try{
				if(conn != null){
					conn.close();
				}
				if(pstmt != null){
					pstmt.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
	
}
