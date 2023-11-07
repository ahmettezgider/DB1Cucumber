package jdbc;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        conn = DriverManager.getConnection(url, username, password);
        stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
    }


    @AfterTest
    public void tearDown() throws SQLException {
        stmt.close();
        conn.close();
    }



    public List<List<String>> getTable(String sql) throws SQLException {
        List<List<String>> table = new ArrayList<>();
        rs = stmt.executeQuery(sql);
        int cols = rs.getMetaData().getColumnCount();
        while (rs.next()){
            List<String> row = new ArrayList<>();
            for (int i = 1; i <= cols ; i++) {
                row.add(rs.getString(i));
            }
            table.add(row);
        }
        return table;
    }


    public List<String> getColumn(String sql, String header) throws SQLException {
        List<String> col = new ArrayList<>();
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            col.add(rs.getString(header));
        }
        return col;
    }

    public List<String> getColumn(String sql, int index) throws SQLException {
        List<String> col = new ArrayList<>();
        rs = stmt.executeQuery(sql);
        while (rs.next()){
            col.add(rs.getString(index));
        }
        return col;
    }

}
