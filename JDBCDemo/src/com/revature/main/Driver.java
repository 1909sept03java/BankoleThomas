package com.revature.main;

import java.sql.Connection;

import com.revature.beans.Cave;
import com.revature.dao.CaveDAO;
import com.revature.dao.CaveDAOImpl;
import com.revature.util.ConnectionUtil;

public class Driver {

	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionUtil.getConnection("src\\main\\java\\connection.properties");
			System.out.println(conn);
			System.out.println(conn.getMetaData().getDatabaseMajorVersion());
		} catch(Exception e) {
			e.printStackTrace();
		}
		CaveDAO cd =new CaveDAOImpl();
		//cd.createCave(new Cave(0,"Howe Caverns",5));
		for (Cave c : cd.getCaves()){
		  System.out.println(c);
		 
		 
	//System.out.println(cd.getCaveById(1));
	}
	}
}
