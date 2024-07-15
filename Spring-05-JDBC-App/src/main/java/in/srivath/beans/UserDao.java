package in.srivath.beans;

import javax.sql.DataSource;

import in.srivath.models.User;

public interface UserDao {
	boolean save(User user);
}
