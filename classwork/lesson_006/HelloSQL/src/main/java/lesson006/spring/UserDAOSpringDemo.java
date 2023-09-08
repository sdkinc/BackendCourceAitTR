package lesson006.spring;

import lesson006.User;
import lesson006.UserDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UserDAOSpringDemo {

  public static void main(String[] args) {
    ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    UserDAO userDAO = context.getBean(UserDAO.class);
    User user = userDAO.findById(1);
    System.out.println(user);
  }
}
