package hello.sql;

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

  public String getName() {
    return name;
  }

  public Integer getId() {
    return id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getPassword() {
    return password;
  }

  public User(Integer id, String name, String password) {
    this.id = id;
    this.name = name;
    this.password = password;
  }
}
