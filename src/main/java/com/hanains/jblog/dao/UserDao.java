package com.hanains.jblog.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hanains.jblog.vo.UserVo;

import oracle.jdbc.pool.OracleDataSource;

@Repository
public class UserDao {
	
	//AbstractApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationCTX.xml");
	//= ctx.getBean("oracleDatasource", OracleDataSource.class);
	
	@Autowired
	private OracleDataSource oracleDatasource;
	@Autowired
	private SqlSession sqlSession;
	//= ctx.getBean("sqlSession", SqlSessionTemplate.class);

	/*
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. 드라이버 로딩 /.
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2.커넥션 만들기.
			String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		} catch (ClassNotFoundException ex) {
			System.out.println("드라이버 로딩 실패: " + ex);
		}
		return conn;
	}
*/
	
	public UserVo getVoByidAndPassword(UserVo userVo){
		UserVo vo = sqlSession.selectOne("user.getVoByidAndPassword",userVo);
		return vo;
	}
	
	/*
	public UserVo getVoByidAndPassword(UserVo userVo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo vo = null;

		try {
			// 1.get connection
			//conn = getConnection();
			conn = oracleDatasource.getConnection();

			String sql = "select id,password,name,role from member where id = ? and password = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, userVo.getId());
			pstmt.setString(2, userVo.getPassword());

			rs = pstmt.executeQuery();
			if (rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String role = rs.getString(4);

				vo = new UserVo();
				vo.setId(id);
				vo.setPassword(password);
				vo.setName(name);
				vo.setRole(role);
			}
		} catch (SQLException ex) {
			System.out.println("SQL Error : " + ex);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException ex) {
				System.out.println("SQL Error : " + ex);
			}
		}
		System.out.println("In DAO :" + vo);
		return vo;
	}
*/
	public void register(UserVo vo){
		sqlSession.insert("user.register",vo);
		
	}
	/*
	public void register(UserVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {

			//conn = getConnection();
			conn = oracleDatasource.getConnection();

			String sql = "insert into member(id,password,name,role,reg_date) values(?,?,?,'USER',sysdate)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}

			} catch (SQLException ex) {
				ex.printStackTrace();
			}

		}

	}*/
	
	public List<UserVo> getList(){
		List<UserVo> list = sqlSession.selectList("user.getList");
		
		return list;
	}
	
/*
	public List<UserVo> getList() {
		List<UserVo> list = new ArrayList<UserVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVo vo = null;
		try {
			//conn = getConnection();
			conn = oracleDatasource.getConnection();

			String sql = "select id,password,name,role,reg_date as regDate from member";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				String id = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				String role = rs.getString(4);
				String regDate = rs.getString(5);

				vo = new UserVo();
				vo.setId(id);
				vo.setPassword(password);
				vo.setName(name);
				vo.setRole(role);
				vo.setRegDate(regDate);

				list.add(vo);
			}
		} catch (SQLException ex) {
			System.out.println("Sql Error : " + ex);
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return list;
	}
*/
	
	public void empty(){
		
	}
}
