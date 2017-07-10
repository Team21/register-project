package test;

import org.junit.Test;

import Service.impl.AdminService;
import entity.Admin;

public class testIAdminDao {

	public testIAdminDao() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@Test
	public void test2() throws Exception{
		 AdminService adminDao=new AdminService();
		 Admin admin=new Admin(3, "ɫħ", "123");
		 try { adminDao.register(admin);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 Admin admin2=adminDao.login(admin);
		 System.out.println(admin2.getUsername());
		}


}
