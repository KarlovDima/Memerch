package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private final String URL = "jdbc:h2:~/memerch";
    private final String USERNAME = "Daria";
    private final String PASSWORD = "";

    private static DatabaseConnection instance;
    private Connection connection;

    private DatabaseConnection() {
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static synchronized DatabaseConnection getInstance() throws SQLException {
        if (instance == null || instance.getConnection().isClosed())
            instance = new DatabaseConnection();
        return instance;
    }
}
