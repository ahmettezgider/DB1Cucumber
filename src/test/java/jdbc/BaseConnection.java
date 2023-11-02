package jdbc;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;

public class BaseConnection {
    Connection conn;
    Statement stmt;
    ResultSet rs;


    @BeforeTest
    public void setup() throws SQLException {

        //TestConfig config = TestConfigReader.instance().getConfig();
        //config.getDatabase().getUrl();

        String url = "jdbc:mysql://127.0.0.1:3306/guidersoft";
        String username = "jdbc";
        String password = "jdbc123456";

        conn = DriverManager.getConnection(url, username, password );
        stmt = conn.createStatement();
    }


    @AfterTest
    public void tearDown() throws SQLException {
        stmt.close();
        conn.close();
    }
}
