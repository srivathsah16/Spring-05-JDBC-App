package in.srivath.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import in.srivath.models.User;

@Component
public class UserService {
	private UserDao dao;
	
	@Autowired
	public UserService(UserDao dao) {
		System.out.println("UserService:: constructor");
		this.dao=dao;
	}

	public void saveUser(User user) {
		boolean res = dao.save(user);
		if (res) {
			System.out.println("User with id="+user.getId()+" saved in db.");
		} else {
			System.out.println("User with id="+user.getId()+" failed to save in db.");
		}
	}
}
