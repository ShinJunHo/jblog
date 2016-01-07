package com.hanains.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.PostVo;
@Repository
public class PostDao {
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
	public List<PostVo> getList(String id){
		List<PostVo> list =new ArrayList<PostVo>() ;
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		PostVo vo = null;
		try{
			//1.get Connection
			conn = getConnection();
			
			String sql = "select a.no, a.title, a.content, a.reg_date as regDate "+
						 "from post a "+ 
						 "where a.category_no in ( "+ 
											 		"select b.no "+ 
											 		"from category b "+ 
											 		"where b.blog_id = '"+id+"' ) "+ 
						 "order by a.no desc";
			System.out.println("::"+sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			System.out.println("rs: "+rs.next());
			while(rs.next()){
				Long no = rs.getLong(1);
				System.out.println("no:"+no);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String regDate = rs.getString(4);
				
				vo = new PostVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setDate(regDate);

				list.add(vo);
			}
			
		}catch(SQLException ex){
			System.out.println("SQL Error : "+ ex);
		}finally{
			try{
				if(pstmt != null){
					pstmt.close();
				}
				if(conn != null ){
					conn.close();
				}
			}catch(SQLException ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
	public void insert(PostVo vo){
		Connection conn =null ;
		PreparedStatement pstmt = null;
		//일단 주석처리 글을 적어낼때. 유저를 check 해야한다.
		//UserVo authUser = (UserVo)session.getAttribute("authUser");
		try{
			//1.DB connection
			conn = getConnection();
			
			//2.prepare statement
			String sql = "insert into post values(POST_SEQ.nextval,?,?,sysdate,1)";
			
			//3.statement 준비
			pstmt = conn.prepareStatement(sql);
			
			//4.binding
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			//5.SQL 실행
			pstmt.executeUpdate();
		}catch(SQLException ex){
			System.out.println("SQL ERROR : "+ex);
			ex.printStackTrace();
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
	}
}
