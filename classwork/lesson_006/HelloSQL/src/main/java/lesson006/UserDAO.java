package lesson006;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserDAO {
  private DataSource dataSource;

  public UserDAO(DataSource dataSource){
    this.dataSource = dataSource;
  }

  public User findById(Integer id){
    //prepare connect to database
    //connect & get data from database
    User user = null;
    try (Connection connection = dataSource.getConnection();){
      PreparedStatement ps = connection.prepareStatement("select * from users where id=?");
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();
      if (rs.next()){
        user = new User(rs.getInt(1), rs.getString(2), rs.getString(3));
      }
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }

    return user;
  }

}
