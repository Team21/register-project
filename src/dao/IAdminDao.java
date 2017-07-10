package dao;

import entity.Admin;

public interface IAdminDao {

	void save(Admin admin);
	
	Admin findByNameAndPwd(Admin admin);
	
	boolean userExists(String name);
	
	
}
