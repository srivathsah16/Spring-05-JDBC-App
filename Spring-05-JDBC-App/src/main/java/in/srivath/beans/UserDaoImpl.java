package in.srivath.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import in.srivath.models.User;

@Component
public class UserDaoImpl implements UserDao {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public UserDaoImpl(DataSource dataSource, JdbcTemplate jdbcTemplate) {
		System.out.println("UserDaoImpl :: constructor, ds=" + dataSource + "jdbcTemplate=" + jdbcTemplate);
		this.dataSource = dataSource;
		this.jdbcTemplate = jdbcTemplate;
	}

	public boolean save(User user) {
		boolean value = false;

		//************  Using Java JDBC:  **************
		try {
			String query = "INSERT INTO user VALUES(?,?,?);";
			Connection con = dataSource.getConnection();
			PreparedStatement pStmt = con.prepareStatement(query);
			pStmt.setInt(1, user.getId());
			pStmt.setString(2, user.getName());
			pStmt.setInt(3, user.getAge());
			int res = pStmt.executeUpdate();
			if (res != 0) {
				value = true;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		//**************     Using SpringJDBC:    ***********
//		try {
//			String query = "INSERT INTO user VALUES(?,?,?)";
//			Object[] args = { user.getId(), user.getName(), user.getAge() };
//			int res = jdbcTemplate.update(query, args);
//			if (res != 0) {
//				value = true;
//			}
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
		return value;
	}
}
