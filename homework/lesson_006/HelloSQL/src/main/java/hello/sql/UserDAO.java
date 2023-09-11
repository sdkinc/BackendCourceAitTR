package hello.sql;

import java.util.ArrayList;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/*

Создание таблицы

CREATE TABLE users (
  id      	SERIAL PRIMARY KEY,
  name    	TEXT NOT NULL,
  password  TEXT NOT NULL
);

Добавление записей

INSERT INTO users (name, password) VALUES ('Aleksey', '*****'), ('Viktors', '***'), ('Vadim', '*');

Просмотр всех записей

SELECT * FROM users;

 */
public class UserDAO {
  private DataSource dataSource;

  public UserDAO(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  public User findById(Integer id){
    // connect and get data
    User user = null;
    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps = connection.prepareStatement("SELECT * FROM users WHERE id = ?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()) {
        user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return user;
  }

  public List<User> findAll() {
    // SELECT * FROM users;
    List<User> users = new ArrayList<>();
    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps = connection.prepareStatement("SELECT * FROM users");
      ResultSet rs = ps.executeQuery();
      while (rs.next()) {
        User user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
        users.add(user);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return users;
  }

  public User add(User user) {
    try (Connection connection = dataSource.getConnection()) {
      PreparedStatement ps = connection.prepareStatement("INSERT INTO users (name, password) VALUES (?, ?) RETURNING id");
      ps.setString(1, user.getName());
      ps.setString(2, user.getPassword());
      ResultSet rs = ps.executeQuery();
      if (rs.next()){
        return findById(rs.getInt(1));
      }else{
        return null;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }

  public User update(User user) {
    // UPDATE users SET name = 'newName', password = 'newPasswd' WHERE id = ?
    try (Connection connection = dataSource.getConnection()) {
      Integer id = user.getId();
      PreparedStatement ps = connection.prepareStatement("UPDATE users SET name = ?, password = ? WHERE id = ?");
      ps.setString(1, user.getName());
      ps.setString(2, user.getPassword());
      ps.setInt(3, id);
      int rs = ps.executeUpdate();
      if (rs > 0) {
        user = findById(id);
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
    return null;
  }

  public User delete(Integer id) {
    // DELETE FROM user WHERE id = ?
    try (Connection connection = dataSource.getConnection()) {
      User userBeforeDelete = findById(id);
      PreparedStatement ps = connection.prepareStatement("DELETE FROM users WHERE id = ?");
      ps.setInt(1, id);
      int result = ps.executeUpdate();
      if (result==1) {
        return userBeforeDelete;
      } else{
        return null;
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
