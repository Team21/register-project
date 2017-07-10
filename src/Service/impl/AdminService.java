package Service.impl;

import Exception.UserExistsException;

import Service.IAdminService;
import dao.IAdminDao;
import entity.Admin;
import impl.AdminDao;

public class AdminService implements IAdminService {

private AdminDao adminDao = new AdminDao();
	
	@Override
	public Admin login(Admin admin) {
		try {
			return adminDao.findByNameAndPwd(admin);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void register(Admin admin) throws UserExistsException  {
		
		try {
			// 1. 先根据用户名查询用户是否存在
			boolean flag = adminDao.userExists(admin.getUsername());
			System.out.println("该用户是否存在"+flag); 
			// 2. 如果用户存在，不允许注册
			if (flag){
				// 不允许注册, 给调用者提示
				throw new UserExistsException("用户名已经存在，注册失败！");
			}
			
			// 3. 用户不存在，才可以注册
			adminDao.save(admin);
		
		} catch (UserExistsException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}