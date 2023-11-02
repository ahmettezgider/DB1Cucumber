package jdbc;

import org.testng.annotations.Test;

import java.sql.SQLException;

public class _06GetTable extends BaseConnection{

    @Test
    public void testGetTable() throws SQLException {
        //String sql = "SELECT * FROM actor WHERE actor_id<10";
        //String sql = "SELECT * FROM personel WHERE id<10";
        String sql = "SELECT * FROM personel WHERE id=1";
        System.out.println(getTable(sql));
    }

    @Test
    public void testGetColumn() throws SQLException {
        String sql = "SELECT * FROM actor WHERE actor_id<10";
        System.out.println(getColumn(sql, "last_name"));
        System.out.println(getColumn(sql, 3));
    }
}
