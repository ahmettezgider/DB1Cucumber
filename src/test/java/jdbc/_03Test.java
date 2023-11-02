package jdbc;

import org.testng.annotations.Test;

import java.sql.SQLException;

public class _03Test extends BaseConnection{

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
}
