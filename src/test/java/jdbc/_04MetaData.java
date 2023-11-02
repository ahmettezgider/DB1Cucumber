package jdbc;

import org.testng.annotations.Test;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;

public class _04MetaData extends BaseConnection{

    ResultSetMetaData rsmd;

    @Test
    public void resultSetMetaData() throws SQLException {

        String sql = "SELECT id, first_name, last_name, email, gender, country, age FROM personel;";
        rs = stmt.executeQuery(sql);

        rsmd = rs.getMetaData();
        System.out.println("rsmd.getColumnCount() = " + rsmd.getColumnCount());
        System.out.println("rsmd.getColumnName(1) = " + rsmd.getColumnName(1));

        int cols = rsmd.getColumnCount();

        for (int i = 1; i < cols; i++) {
            System.out.println(rsmd.getColumnName(i) + "\t" + rsmd.getColumnDisplaySize(i));
        }

    }


    @Test
    public void resultSetMetaData2() throws SQLException {

        String sql = "SELECT id, first_name AS Name, last_name AS LastName, email, gender, country, age AS Yas" +
                " FROM personel" +
                " WHERE id<10";
        rs = stmt.executeQuery(sql);

        rsmd = rs.getMetaData();

        int cols = rsmd.getColumnCount();

        for (int i = 1; i <= cols; i++) {
            //System.out.print(rsmd.getColumnName(i) + "\t");
            System.out.print(rsmd.getColumnLabel(i) + "\t");
        }
        System.out.println();
        while (rs.next()){
            for (int i = 1; i <=cols ; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println();
        }

    }



    @Test
    public void resultSetMetaData3() throws SQLException {

        //String sql = "SELECT id, first_name AS Name, last_name AS LastName, email, gender, country, age AS Yas" +
        //        " FROM personel" +
        //        " WHERE id<10";
        String sql = "SELECT * FROM actor WHERE actor_id<20";
        rs = stmt.executeQuery(sql);

        rsmd = rs.getMetaData();

        int cols = rsmd.getColumnCount();

        String format = "";
        String[] header = new String[cols];
        for (int i = 1; i <= cols; i++) {
            format += "%-" + rsmd.getColumnDisplaySize(i) + "s";
            header[i-1] = rsmd.getColumnLabel(i);
        }
        format += "\n";
        System.out.printf(format, header);

        String[] data = new String[cols];
        while (rs.next()){
            for (int i = 1; i <= cols ; i++) {
                data[i-1] = rs.getString(i);
            }
            System.out.printf(format, data);
        }
    }


    @Test
    public void formatWrite(){

        String format = "%-20s%-5d%.2f\n";
        Object[] arr = {"Ali",10, 1.3};
        System.out.printf("%-20s%-5d%.2f\n", "Ali",10, 1.3);
    }

}
