package serviceCRUD;

import lombok.Data;

import java.sql.*;

@Data
public class DBWorker {

    private final String HOST = "jdbc:mysql://localhost:3306/mydbtest";
    private final String USERNAME = "root";
    private final String PASSWORD = "root";

    private Connection connection;

    public DBWorker() {

        try {
            Driver driver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);

        } catch (SQLException e) {
            System.out.println("Error " + e.getErrorCode());
        }

    }
}
