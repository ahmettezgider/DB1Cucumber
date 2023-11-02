package jdbc;


import org.testng.annotations.Test;

import java.sql.SQLException;

public class _05Cursor extends BaseConnection{


    @Test
    public void test1() throws SQLException {
        String sql = "SELECT * FROM actor WHERE actor_id<50";

        rs = stmt.executeQuery(sql);

        //  .next() sonraki kayda gider
        rs.next();
        System.out.println(rs.getString(2));
        rs.next();
        System.out.println(rs.getString(2));

        // .previous();     önceki kayda gider
        // .first();        ilk kayda gider
        // .last();         son kayda gider
        // .relative(10);   bulundugu yerden sonraki 10. kayda gider, oldugun yerden 10 kayit ileri git
        // .relative(-2);   bulundugu yerden önceki 2. kayda gider, oldugun yerden 2 kayit geri git
        // .absolute(10);   direkt 10. kayda git demektir

        rs.previous();
        System.out.println(rs.getString(2));



    }



}
