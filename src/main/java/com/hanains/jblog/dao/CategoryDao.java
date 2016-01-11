package com.hanains.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.CategoryVo;

@Repository
public class CategoryDao {

	private Connection getConnection()throws SQLException{
		Connection conn= null;
		try{
			//1.드라이버 로딩.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//2.커넥션 만들기.
			String dbURL="jdbc:oracle:thin:@localhost:1521:xe";
			
			conn = DriverManager.getConnection(dbURL,"webdb","webdb");
		}catch(ClassNotFoundException ex){
			System.out.println("드라이버 로딩 실패:"+ex);
		}
		return conn;
	}
	public List<CategoryVo> getList(String id){
		List<CategoryVo> list = new ArrayList<CategoryVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		CategoryVo vo = null;
		try{
			//1.get Connection
			conn = getConnection();
			
			//2. prepare statement 
			String sql ="select no,name, description, reg_date as regDate, blog_id as blogId from category where blog_id = '"+id+"'";
			System.out.println("::"+sql);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String desc = rs.getString(3);
				String regDate = rs.getString(4);
				String blogId = rs.getString(5);
				
				vo = new CategoryVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setDescription(desc);
				vo.setRegDate(regDate);
				vo.setBlogId(blogId);
				System.out.println("vo"+vo);
				list.add(vo);
			}
		}catch(SQLException ex){
			System.out.println("SQL Error : "+ex);
		}finally{
			try{
				if(rs != null){
					rs.close();
				}
				if(pstmt != null ){
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
	public void addCategory(String id,CategoryVo vo){
		Connection conn =null;
		PreparedStatement pstmt = null;
		
		try{
			//1.DB connection
			conn = getConnection();
			
			//2.prepare statement
			String sql="insert into category values(CATEGORY_SEQ.nextval,?,?,sysdate,?)";
			//3.statement 준비
			pstmt = conn.prepareStatement(sql);
			
			//4.binding
			pstmt.setString(1,vo.getName());
			pstmt.setString(2, vo.getDescription());
			pstmt.setString(3, id);
			
			//5.SQL실행
			pstmt.executeUpdate();
			
		}catch(SQLException ex){
			System.out.println("SQL Error: "+ex);
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
	}
	public List<CategoryVo> getCategoryById(String id){
		List<CategoryVo> list = new ArrayList<CategoryVo>();	
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CategoryVo vo = null;
		try{
			conn = getConnection();
			
			String sql ="select no, name, description, reg_date as regDate from category where blog_id = ?";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,id);
			
			rs = pstmt.executeQuery();
			while(rs.next()){
				Long no = rs.getLong(1);
				String name = rs.getString(2);
				String desc = rs.getString(3);
				String regDate = rs.getString(4);
				
				vo = new CategoryVo();
				vo.setNo(no);
				vo.setName(name);
				vo.setDescription(desc);
				vo.setRegDate(regDate);
				
				list.add(vo);
			}
		}catch(SQLException ex){
			System.out.println("SQL Error :"+ex);
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
	public void updateCategory(String id ,CategoryVo vo){
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		try{
			conn = getConnection();
			
			String sql = "update category set name=?, description=? where no = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getName());
			pstmt.setString(2,vo.getDescription());
			pstmt.setLong(3, vo.getNo());
			
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("SQL ERROR ::"+ex);
		}finally{
			try{
				if( conn != null){
					conn.close();
				}
				if( pstmt != null ){
					pstmt.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
	public void deleteCategory(Long no){
		Connection conn =null;
		PreparedStatement pstmt =null;
		try{
			conn = getConnection();
			
			String sql = "delete from category where no = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, no);
			pstmt.executeUpdate();
			
		}catch(SQLException ex){
			System.out.println("SQL ERROR ::"+ex);
		}finally{
			try{
				if( conn != null){
					conn.close();
				}
				if( pstmt != null ){
					pstmt.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
	}
}
