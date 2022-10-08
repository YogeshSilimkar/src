package com.project.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.db.model.Customer;
import com.project.db.model.Location;
import com.project.db.util.Dbconnect;

public class Customerdao {
Connection con = Dbconnect.connect();
	
	public List<Customer> getAllRecods(){
		List<Customer> customers = new ArrayList<Customer>();
		
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from customer");
			while(rs.next()) {
			     Customer c = new Customer();
			     c.setId(rs.getInt("id"));
			     c.setFname(rs.getString("fname"));
			     c.setLname(rs.getString("lname"));
			     c.setPhoneno(rs.getInt("phoneno"));
			     c.setLocation(rs.getString("location"));
			     
			     customers.add(c);
			     
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return customers;
	}
	
	public Customer loginbyid(int id) {
		Customer c = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from customer where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			c = new Customer();
			rs.next();
			c.setId(rs.getInt("id"));
		    c.setFname(rs.getString("fname"));
		    c.setLname(rs.getString("lname"));
		    c.setPhoneno(rs.getInt("phoneno"));
		    c.setLocation(rs.getString("location"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public boolean insertRecord(int id,String fname,String lname,int phoneno,String location)
	{
		String sql = "insert into customer values(?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, fname);
			ps.setString(3, lname);
			ps.setInt(4, phoneno);
			ps.setString(5, location);
			int i = ps.executeUpdate();
			if (i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean updateRecord(Customer cust) {
		String sql = "update customer set fname=?, lname=?, phoneno=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, cust.getFname());
			ps.setString(2, cust.getLname());
			ps.setInt(5, cust.getPhoneno());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return false;
	}

}
