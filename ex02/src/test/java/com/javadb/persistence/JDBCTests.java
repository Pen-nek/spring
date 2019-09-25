package com.javadb.persistence;

import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JDBCTests {

	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch(Exception e) {
			e.printStackTrace();	// 오류 발생 시 스택트레이스를 프린트할 것 
		}// end of catch
	}// end of static
	
	@Test	// Test는 JUnit Test로 실행
	public void testConnection() {
		
		try(Connection con = 
				DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:1521:xe", 
						"madang", 
						"madang")) {
			log.info(con);
		} catch (Exception e) {
			fail(e.getMessage());
		}// end of catch
	}// end of testConnection()
}
