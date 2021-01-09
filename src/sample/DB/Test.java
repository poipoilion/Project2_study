package sample.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {
   public void main(){
        String url = "jdbc:mysql://localhost:3306/studydb";
        String username = "root";
        String password = "12345";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
