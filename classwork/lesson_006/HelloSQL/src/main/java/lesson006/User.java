package lesson006;

public class User {
  private Integer id;
  private String name;
  private String password;

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", password='" + password + '\'' +
        '}';
  }

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }
}
