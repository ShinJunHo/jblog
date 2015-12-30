package com.hanains.jblog.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

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
		
		
}
