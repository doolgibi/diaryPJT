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
		//�����Ǵ� �ٲ��ּ���
		dburl = "jdbc:oracle:thin:@123.123.123.123:1521:ORCL";
		//�����̸� ����
		dbuser = "User_Id";
		//�н����� ����
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