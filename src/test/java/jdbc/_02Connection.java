package jdbc;

import com.guidersoft.config.TestConfig;
import com.guidersoft.config.TestConfigReader;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _02Connection {

    /*
        @BeforeTest -> connection ve statement definition

        @Test       -> personel tablosunda ulke nüfuslarini listeleyin
                       tablo sonuna da genel toplami yazdirin

        @AfterTest  -> statement connection close
     */

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

    @Test
    public void getCountryPopulation() throws SQLException {
        String sql = "SELECT country, COUNT(*) AS nufus FROM personel GROUP BY country";
        sql += " UNION";
        sql += " SELECT 'Toplam', COUNT(*) FROM personel";

        System.out.println(sql);

        rs = stmt.executeQuery(sql);

        while (rs.next()){
            System.out.printf("%-40s%d\n", rs.getString(1), rs.getInt(2));
        }

    }


    @AfterTest
    public void tearDown() throws SQLException {
        stmt.close();
        conn.close();
    }
}
