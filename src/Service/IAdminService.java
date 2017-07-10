package Service;

import entity.Admin;
import Exception.UserExistsException;
public interface IAdminService {

	
	Admin login(Admin admin);
	void register(Admin admin) throws UserExistsException;
	
	
}
