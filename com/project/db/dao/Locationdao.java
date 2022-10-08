package com.project.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.project.db.model.Location;
import com.project.db.util.Dbconnect;

public class Locationdao {
	Connection con = Dbconnect.connect();
	
	public List<Location> getAllRecods(){
		List<Location> location = new ArrayList<Location>();
		
		Statement stat;
		try {
			stat = con.createStatement();
			ResultSet rs = stat.executeQuery("select * from location");
			while(rs.next()) {
			     Location c = new Location();
			     c.setId(rs.getInt("id"));
			     c.setPicklocation(rs.getString("picklocation"));
			     c.setDroplocation(rs.getString("droplocation"));
			     c.setDate(rs.getString("date"));
			     c.setTime(rs.getString("time"));
			     c.setCustid(rs.getInt("custid"));
			     location.add(c);
			     
			  }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return location;
	}
	
	
	public boolean insertRecord(int id,String picklocation,String droplocation,String date,String time, int custid)
	{
		String sql = "insert into location values(?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, picklocation);
			ps.setString(3, droplocation);
			ps.setString(4, date);
			ps.setString(5, time);
			ps.setInt(6, custid);
			int i = ps.executeUpdate();
			if (i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean deleteRecord(int id) {
		String sql = "delete from location where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	
	public boolean updateRecord(Location loc) {
		String sql = "update location set picklocation=?, droplocation=?, date=?, time=? where id=?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, loc.getPicklocation());
			ps.setString(2, loc.getDroplocation());
			ps.setString(3, loc.getDate());
			ps.setString(4, loc.getTime());
			ps.setInt(5, loc.getId());
			int i = ps.executeUpdate();
			if(i>0)
				return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return false;
	}
	
	
	public Location searchbyid(int id) {
		Location location = null;
		try {
			PreparedStatement ps = con.prepareStatement("select * from location where id = ?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			location = new Location();
			rs.next();
			location.setId(rs.getInt("id"));
			location.setPicklocation(rs.getString("picklocation"));
			location.setDroplocation(rs.getString("droplocation"));
			location.setDate(rs.getString("date"));
			location.setTime(rs.getString("time"));
		} catch (Exception e) {
			
		}
		return location;
	}

}
