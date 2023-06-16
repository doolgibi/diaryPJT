package MyBeans;

import java.io.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public class DBConnect {
	Connection dbconn = null;

	String dburl = new String();
	String dbuser = new String();
	String dbpass = new String();


	public DBConnect() {
		//아이피는 바꿔주세요
		dburl = "jdbc:oracle:thin:@123.123.123.123:1521:ORCL";
		//유저이름 수정
		dbuser = "User_Id";
		//패스워드 수정
		dbpass = "User_Pw";
	}


	public Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
		}

		try {
			dbconn = DriverManager.getConnection(dburl, dbuser, dbpass);
		} catch (SQLException e) {
		}

		return dbconn;
	}


	public void close() {
		try {
			if(!dbconn.isClosed()) {
				dbconn.close();
			}
		} catch (SQLException e) {
		}
	}

}