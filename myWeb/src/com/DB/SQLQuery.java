package com.DB;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class SQLQuery {
	
	private static SQLQuery query=null;
	private static Connection  conn=null;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/openroom?user=root&password=123456");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private SQLQuery(){
		
	}
	public static SQLQuery getInstance(){
		if(query==null){
			query=new SQLQuery();
		}
		return query;
	}
	public List<String> query(String str){
		List<String> list=new ArrayList<String>();
		Statement state=null;
		try {
			state = (Statement) conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			ResultSet rs=(ResultSet) state.executeQuery(str);
			while(rs.next()){
				String name=rs.getString("name");
				System.out.println(name);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
