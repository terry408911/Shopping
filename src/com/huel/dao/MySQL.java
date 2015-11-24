package com.huel.dao;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import com.huel.model.Goods;

import java.sql.Connection;

public class MySQL {
	public static final String url = "jdbc:mysql://localhost/shopping";
	public static final String name = "com.mysql.jdbc.Driver";
	public static final String user = "root";
	public static final String password = "root";
	
	public Connection connection = null;
	public PreparedStatement pst = null;
	
	public MySQL(){
		try {
			Class.forName(name);
			connection =  DriverManager.getConnection(url,user,password);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void close(){
		try{
			this.connection.close();
			this.pst.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ResultSet queryByIndex(int i){
		String sql = "select * from books limit "+ (i-1)*5+","+(i*5);
		ResultSet rs = null;
		try {
			pst = connection.prepareStatement(sql);
			rs = this.pst.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return rs;
	}
	
	public Goods queryById(String id){
		String sql = "select * from books where id="+id;
		Goods good = null;
		try {
			pst = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			good =  (Goods) this.pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return good;
	}
	
	public ResultSet queryAll(){
		ResultSet goods = null;
		String sql = "select * from books";
		try {
			pst = connection.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			goods =  this.pst.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return goods;
	}

}
