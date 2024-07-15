package in.srivath.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import in.srivath.AppConfig;
import in.srivath.beans.UserService;
import in.srivath.models.User;

public class TestApp {
	public static void main(String[] args) {
//		User user = new User(1, "Poornima", 42);
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		UserService service = context.getBean(UserService.class);
		service.saveUser(context.getBean(User.class));
		service.saveUser(context.getBean(User.class));
		service.saveUser(context.getBean(User.class));
	}
}
