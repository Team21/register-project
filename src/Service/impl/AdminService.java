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
			// 1. �ȸ����û�����ѯ�û��Ƿ����
			boolean flag = adminDao.userExists(admin.getUsername());
			System.out.println("���û��Ƿ����"+flag); 
			// 2. ����û����ڣ�������ע��
			if (flag){
				// ������ע��, ����������ʾ
				throw new UserExistsException("�û����Ѿ����ڣ�ע��ʧ�ܣ�");
			}
			
			// 3. �û������ڣ��ſ���ע��
			adminDao.save(admin);
		
		} catch (UserExistsException e) {
			throw e;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}