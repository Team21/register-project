package impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.IAdminDao;
import entity.Admin;
import utils.BaseDao;
import utils.JdbcUtil;

public class AdminDao  extends BaseDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	public AdminDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public void save(Admin admin)  {
		
		try {
			String sql = "INSERT INTO admin(id,userName,pwd) VALUES(?,?,?);";
			Object[] paramsValue={admin.getId(),admin.getUsername(),admin.getPassword()};
			super.update(sql, paramsValue);	
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
		
	}


	public Admin findByNameAndPwd(Admin admin) {
		// TODO Auto-generated method stub
		

		try {
			
			String sql = "select * from admin where userName=? and pwd=?;";
			Object[] paramsValue={admin.getUsername(),admin.getPassword()};
			List<Admin> query = super.query(sql, paramsValue, Admin.class);
			return query.get(0);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
	
		
	}


	public boolean userExists(String name) {
		// TODO Auto-generated method stub
		


	try {
			
		String sql = "select * from admin where userName=? ;";
			Object[] paramsValue={name};
			List<Admin> query = super.query(sql, paramsValue, Admin.class);
			return query!=null;
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			JdbcUtil.closeAll(con, pstmt, null);
		}
		
		
}
}
