package jdbc;

import org.testng.annotations.Test;

import java.sql.*;

public class _01Connection {

    /*
        JDBC
            Connection  : baglanti icin,    yol
            Statement   : statement,        firma
            ResultSet   : kayit kümesi      arac

     */

    @Test
    public void test_Connection1() throws SQLException {

        String url = "jdbc:mysql://localhost:3306/guidersoft?useSSL=false&serverTimezone=UTC";
        String username = "jdbc";
        String password = "jdbc123456";

        // veritabanina connection oluturulur
        Connection conn = DriverManager.getConnection(url, username, password);

        // statement olusturulur
        Statement stmt = conn.createStatement();

        // tablodaki datalar SQL ile ResultSet e aliyoruz
        ResultSet rs = stmt.executeQuery("SELECT id, first_name, last_name, country, age FROM personel WHERE id<30");
        /*
            stmt.executeQuery();    return ResultSet  : SELECT
            stmt.execute();         return boolean    : CREATE, ALTER
            stmt.executeUpdate();   return int        : UPDATE, DELETE , kac kayit etkilendi
         */

        while (rs.next()){

            int id = rs.getInt(1);
            String first_name = rs.getString(2);
            String last_name = rs.getString("last_name");
            String country = rs.getString(4);
            String age = rs.getString("age");

            System.out.printf("%-5d%-15s%-15s%-15s%-3s\n", id, first_name, last_name, country, age);

        }

        stmt.close();
        conn.close();


    }


}
