package lesson006;

public class UserDAODemo {

  public static void main(String[] args) {
    UserDAO userDAO = new UserDAO(MyDataSource.getDataSource());
    User user = userDAO.findById(1);
    System.out.println(user);
  }
}
