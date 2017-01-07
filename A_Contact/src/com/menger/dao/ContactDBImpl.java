package com.menger.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.menger.entity.Contact;
import com.menger.util.JdbcUtil;

public class ContactDBImpl implements ContactDao {

	@Override
	public void addContact(Contact contact) {
		String sql = "insert into contact(id,name,gender,age,jiguan,qq,email) values(?,?,?,?,?,?,?)";
		String id = UUID.randomUUID().toString();
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, contact.getName());
			ps.setString(3, contact.getGender());
			ps.setInt(4, contact.getAge());
			ps.setString(5, contact.getJiguan());
			ps.setString(6, contact.getQq());
			ps.setString(7, contact.getEmail());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps);
		}
	}

	@Override
	public void updateContact(Contact contact) {
		String sql = "update contact set name=?,gender=?,age=?,jiguan=?,qq=?,email=? where id=?";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, contact.getName());
			ps.setString(2, contact.getGender());
			ps.setInt(3, contact.getAge());
			ps.setString(4, contact.getJiguan());
			ps.setString(5, contact.getQq());
			ps.setString(6, contact.getEmail());
			ps.setString(7, contact.getId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps);
		}
	}

	@Override
	public void deleteContact(String id) {
		String sql = "delete from contact where id=?";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps);
		}
	}

	@Override
	public List<Contact> findAll() {
		String sql = "select * from contact";
		List<Contact> contacts = new ArrayList<>();
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				Contact contact = new Contact();
				contact.setId(rs.getString("id"));
				contact.setName(rs.getString("name"));
				contact.setAge(rs.getInt("age"));
				contact.setEmail(rs.getString("email"));
				contact.setGender(rs.getString("gender"));
				contact.setJiguan(rs.getString("jiguan"));
				contact.setQq(rs.getString("qq"));
				contact.setPhoto(rs.getBlob("photo"));
				contacts.add(contact);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		return contacts;
	}

	@Override
	public Contact findById(String id) {
		String sql = "select * from contact where id=?";
		Connection conn = JdbcUtil.getConnection();
		Contact contact = new Contact();
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				contact.setId(rs.getString("id"));
				contact.setName(rs.getString("name"));
				contact.setGender(rs.getString("gender"));
				contact.setAge(rs.getInt("age"));
				contact.setEmail(rs.getString("email"));
				contact.setJiguan(rs.getString("jiguan"));
				contact.setQq(rs.getString("qq"));
				contact.setPhoto(rs.getBlob("photo"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn, ps, rs);
		}
		return contact;
	}

	@Override
	public boolean checkIfExist(String name) {
		String sql = "select * from contact where name=?";
		Connection conn = JdbcUtil.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean isExist = false;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if (rs.next()) {
				isExist = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return isExist;
	}

}
