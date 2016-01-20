package com.hanains.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.PostVo;

import oracle.jdbc.pool.OracleDataSource;
@Repository
public class PostDao {
	@Autowired
	private OracleDataSource oracleDatasource;
	@Autowired
	private SqlSession sqlSession;

	//AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
	//private OracleDataSource oracleDatasource = ctx.getBean("oracleDatasource", OracleDataSource.class);
	//private SqlSession sqlSession = ctx.getBean("sqlSession", SqlSessionTemplate.class);
	/*
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
	}*/
	public List<PostVo> getList(String id){
		List<PostVo> list =sqlSession.selectList("post.getList",id); 
		return list;
	}
	/*
	public List<PostVo> getList(String id){
		List<PostVo> list =new ArrayList<PostVo>() ;
		Connection conn =null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		PostVo vo = null;
		try{
			//1.get Connection
			//conn = getConnection();
			//mybatis 1단계 getConnection을 없애고 oracle polling datasource
			conn = oracleDatasource.getConnection();

			String sql = "select a.no, a.title, a.content, a.reg_date as regDate, a.category_no categoryNo "+
						 "from post a "+ 
						 "where a.category_no in ( "+ 
											 		"select b.no "+ 
											 		"from category b "+ 
											 		"where b.blog_id = '"+id+"' ) "+ 
						 "order by a.no desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()){
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String regDate = rs.getString(4);
				Long categoryNo = rs.getLong(5);
				
				vo = new PostVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setDate(regDate);
				vo.setCategoryNo(categoryNo);
				
				list.add(vo);
			}
			System.out.println("POST LIST : "+list);
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
	}*/
	public void insert(PostVo vo){
		sqlSession.insert("post.insert",vo);
	}
	/*
	public void insert(PostVo vo){
		Connection conn =null ;
		PreparedStatement pstmt = null;
		//일단 주석처리 글을 적어낼때. 유저를 check 해야한다.
		//UserVo authUser = (UserVo)session.getAttribute("authUser");
		try{
			//1.DB connection
			//conn = getConnection();
			conn = oracleDatasource.getConnection();

			//2.prepare statement
			String sql = "insert into post values(POST_SEQ.nextval,?,?,sysdate,?)";
			
			//3.statement 준비
			pstmt = conn.prepareStatement(sql);
			
			//4.binding
			pstmt.setString(1,vo.getTitle());
			pstmt.setString(2,vo.getContent());
			pstmt.setLong(3, vo.getCategoryNo());
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
	}*/
	public PostVo getPostByNo(Long voNo){
		PostVo vo = sqlSession.selectOne("post.getPostByNo",voNo);
		return vo;
	}
	/*
	public PostVo getPostByNo(Long voNo){
		PostVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			//conn = getConnection();
			conn = oracleDatasource.getConnection();

			//3.statement 준비
			String sql ="select no, title, content, reg_date as regDate from post where no = ?";
			pstmt = conn.prepareStatement(sql);
			
			//4.binding
			pstmt.setLong(1, voNo);
			
			//5.SQL 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String content = rs.getString(3);
				String regDate = rs.getString(4);
				
				vo = new PostVo();
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setDate(regDate);
				
			}
		}catch(SQLException ex){
			System.out.println("SQL Error ::"+ex );
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
		
		return vo;
	}*/
	public void empty(){
		
	}
}
