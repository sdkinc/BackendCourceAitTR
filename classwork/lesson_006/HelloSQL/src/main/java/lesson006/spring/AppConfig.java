package lesson006.spring;

import javax.sql.DataSource;
import lesson006.UserDAO;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
@Bean
  public DataSource dataSource(){
  PGSimpleDataSource pgds = new PGSimpleDataSource();
  pgds.setServerName("localhost");
  pgds.setDatabaseName("cohort26");
  pgds.setUser("postgres");
  pgds.setPassword("root");
  return pgds;
}
@Bean
  public UserDAO userDAO(){
  return new UserDAO(dataSource());
}
}
