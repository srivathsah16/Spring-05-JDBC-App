package in.srivath;

import java.io.File;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import in.srivath.models.User;

@Configuration
@ComponentScan
public class AppConfig {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/advjavadb";
	private static final String DB_UNAME = "root";
	private static final String DB_PWD = "Sri@1608";

	private int uid = 0;
	private String uName = "";
	private int uage = 0;
	private String[] names = { "Emma", "Liam", "Olivia", "Noah", "Ava", "William", "Sophia", "James", "Isabella",
			"Oliver", "Mia", "Benjamin", "Charlotte", "Elijah", "Amelia", "Lucas", "Harper", "Alexander", "Evelyn",
			"Henry", "Aiden", "Aria", "Michael", "Emily", "Ethan", "Abigail", "Daniel", "Sofia", "Logan", "Grace",
			"Madison" };

	@Bean
	@Scope("prototype")
	public User getUser() {
		System.out.println("AppConfig::getUser method called..");
		Random random = new Random();
		do {
			uid = random.nextInt(1000);
		} while (uid == 0);

		uName = names[random.nextInt(30)];

		do {
			uage = random.nextInt(100);
		} while (uage == 0);

		return new User(uid, uName, uage);
	}

	@Bean
	public DataSource getDataSource() {
		System.out.println("AppConfig::getDataSource method.");
		return new DriverManagerDataSource(DB_URL, DB_UNAME, DB_PWD);
	}

	@Bean
	public JdbcTemplate getJdbcTemplate(DataSource dataSource) {
		System.out.println("AppConfig::getJdbcTemplate method, ds=" + dataSource);
		return new JdbcTemplate(dataSource);
	}

}
