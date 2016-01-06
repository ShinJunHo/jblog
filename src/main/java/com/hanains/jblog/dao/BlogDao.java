package com.hanains.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.BlogVo;

@Repository
public class BlogDao {

		private Connection getConnection()throws SQLException{
			Connection conn = null;
			try{
				//1.드라이버 로딩.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				//2.커넥션 만들기.
				String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
				conn = DriverManager.getConnection(dbURL,"webdb","webdb");
			}catch(ClassNotFoundException ex){
				System.out.println("드라이버 로딩 실패:"+ex);
			}
			return conn;
		}
		
		public List<BlogVo> getBlogList(String keyword,String searchCondition){
			List<BlogVo> list = new ArrayList<BlogVo>();
			Connection conn =null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BlogVo vo = null;
			try{
				conn = getConnection();
				System.out.println(keyword);
				// keyword 처리를 해줘야겠다.
				// Condition 처리도.
				//keyword="";
				String sql ="select id, title from blog where title LIKE '%"+keyword+"%'";
				pstmt = conn.prepareStatement(sql);
				//pstmt.setString(1, keyword);
				rs = pstmt.executeQuery();
				while(rs.next()){
					String id = rs.getString(1);
					String title = rs.getString(2);
					System.out.println("id: "+id+"title"+title);
					vo = new BlogVo();
					vo.setId(id);
					vo.setTitle(title);
					list.add(vo);
				}
			}catch(SQLException ex){
				System.out.println("SQL Error : "+ex);
			}finally{
				try{
					if(pstmt != null){
						pstmt.close();
					}
					if(conn != null){
						conn.close();
					}
				}catch(SQLException ex){
					ex.printStackTrace();
				}
			}
			return list;
		}
		public BlogVo getView(String voId){
			BlogVo vo = null;
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try{
				conn = getConnection();
				String sql="select id, title, status from blog where id = ?";
				pstmt= conn.prepareStatement(sql);
				pstmt.setString(1, voId);
				rs = pstmt.executeQuery();
				if(rs.next()){
					String id = rs.getString(1);
					String title = rs.getString(2);
					String status = rs.getString(3);
					
					vo = new BlogVo();
					vo.setId(id);
					vo.setTitle(title);
					vo.setStatus(status);
					
				}
			}catch(SQLException ex){
				System.out.println("SQL ERROR "+ ex);
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
			
			return vo;
			
		}
}
