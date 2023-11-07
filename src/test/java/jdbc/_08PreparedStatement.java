package jdbc;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class _08PreparedStatement {

    Connection conn;
    Statement stmt;
    PreparedStatement pstmt;
    ResultSet rs;


    @BeforeTest
    public void beforeTest() throws SQLException {

        conn = DriverManager.getConnection("jdbc:mysql://jdbc:jdbc123456@localhost:3306/guidersoft");
        stmt = conn.createStatement();

    }


    @AfterTest
    public void afterTest() throws SQLException {
        stmt.close();
        conn.close();
    }

    @Test
    public void test1() throws SQLException {

        String sql = "SELECT * FROM table1 WHERE id<10";
        writeToConsole(sql);

    }

    @Test
    public void test2() throws SQLException {
        // table1 tablosuna (first_name, last_name, gender, age) yeni bir kayit giriniz.

        String sql = "INSERT INTO table1(first_name, last_name, gender, age) VALUES('Ali', 'Veli', 'Male', 23)";

        int num = stmt.executeUpdate(sql);
        System.out.println(num);

    }

    @Test
    public void test3() throws SQLException {
        // table1 tablosuna (first_name, last_name, gender, age) yeni bir kayit giriniz.

        String sql = "INSERT INTO table1(first_name, last_name, gender, age) VALUES(?, ?, ?, ?)";
        pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, "Hasan");
        pstmt.setString(2, "Soyad");
        pstmt.setString(3, "Bay");
        pstmt.setInt(4, 33);


        int num = pstmt.executeUpdate();

        System.out.println(num);

    }



    @Test
    public void test4() throws SQLException {

        String sqlInsert = "INSERT INTO table1(first_name, last_name, gender, age) VALUES(?, ?, ?, ?)";
        String sqlUpdate = "UPDATE table1 SET age = ? WHERE id = ?";

        pstmt = conn.prepareStatement(sqlInsert);

        pstmt.setString(1, "Ayse");
        pstmt.setString(2, "Deniz");
        pstmt.setString(3, "Bayan");
        pstmt.setInt(4, 23);

        int eklenenKayitSayisi = pstmt.executeUpdate();
        if (eklenenKayitSayisi==0)
            throw new RuntimeException("Kayit yapilamadi");

        String sqlId = "SELECT last_insert_id()";
        rs = stmt.executeQuery(sqlId);
        rs.next();
        int id = rs.getInt(1);

        System.out.println("After INSERT");
        writeToConsole("SELECT * FROM table1 WHERE id=" + id);

        pstmt = conn.prepareStatement(sqlUpdate);
        pstmt.setInt(1, 27);
        pstmt.setInt(2, id);

        pstmt.executeUpdate();

        System.out.println("After UPDATE");
        writeToConsole("SELECT * FROM table1 WHERE id=" + id);

        String sqlDelete = "DELETE FROM table1 WHERE id = ?";

        pstmt = conn.prepareStatement(sqlDelete);

        pstmt.setInt(1, id);

        int silinenKayitSayisi = pstmt.executeUpdate();
        System.out.println("Silinen kayit sayisi : " + silinenKayitSayisi);

    }


    public void writeToConsole(String sql) throws SQLException {
        rs = stmt.executeQuery(sql);
        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();
        while (rs.next()){
            String line = "";

            for (int i = 1; i <=cols ; i++) {
                line += rs.getString(i);
                if (i!=cols) line+="\t";
            }
            System.out.println(line);
        }

    }
}
