package jdbc;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.platform.commons.util.StringUtils;
import org.testng.annotations.Test;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Random;

public class _07Queries extends BaseConnection {


    @Test
    public void createDeleteUpdate() throws SQLException {

        String sqlDrop = "DROP TABLE IF EXISTS personel1;";

        stmt.execute(sqlDrop);

        String sqlCreate = "CREATE TABLE personel1" +
                " SELECT id, first_name, last_name, gender, country, city, countrycode, age, length FROM personel;";

        stmt.execute(sqlCreate);


        String sqlGetData = "SELECT * FROM personel1 WHERE id<10";
        System.out.println(getTable(sqlGetData));

        String sqlUpdate = "UPDATE personel1 SET age=0;";

        int effectedRows = stmt.executeUpdate(sqlUpdate);

        System.out.println(effectedRows);
        System.out.println(getTable(sqlGetData));

        String sqlDelete = "DELETE FROM personel1 WHERE id%2=0";

        effectedRows = stmt.executeUpdate(sqlDelete);
        System.out.println(effectedRows);
        System.out.println(getTable(sqlGetData));
    }

    @Test
    public void createDeleteUpdate2() throws SQLException {
        /*
            1. mytable adinda, id INT, adi VHARCHAR(30), soyadi VARCHAR(30), yas INT olan bir tablo create edin
            2. Tabloya 5 adet veri girin
            3. tablodaki yaslari 2 ile carpin ve güncelleyin
            4. tablodaki yasi 30 dan kücük olanlari silin
         */


        String sqlCreate = "CREATE TABLE mytable (\n" +
                "  id INT NOT NULL AUTO_INCREMENT,\n" +
                "  first_name VARCHAR(30) ,\n" +
                "  last_name VARCHAR(30) ,\n" +
                "  age INT ,\n" +
                "  PRIMARY KEY (id)\n" +
                ");";

        stmt.execute(sqlCreate);
        System.out.println(getTable("SELECT * FROM mytable"));

        System.out.println("Start : " + LocalDateTime.now());
        for (int i = 0; i <10; i++) {

            String firstName = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5, 15).toLowerCase();
            String lastName = RandomStringUtils.randomAlphabetic(7, 15).toUpperCase();
            int age = 10 + new Random().nextInt(40);

            String sqlInsert= "INSERT INTO mytable (first_name, last_name, age) VALUES ('" + firstName + "', '" + lastName + "', "+ age +")";
            stmt.executeUpdate(sqlInsert);
        }
        System.out.println("End : " + LocalDateTime.now());

        System.out.println(getTable("SELECT * FROM mytable"));



    }

    @Test
    public void createDeleteUpdate3() throws SQLException {
        /*
            1. mytable adinda, id INT, adi VHARCHAR(30), soyadi VARCHAR(30), yas INT olan bir tablo create edin
            2. Tabloya 5 adet veri girin
            3. tablodaki yaslari 2 ile carpin ve güncelleyin
            4. tablodaki yasi 30 dan kücük olanlari silin
         */


        String sqlCreate = "CREATE TABLE mytable (\n" +
                "  id INT NOT NULL AUTO_INCREMENT,\n" +
                "  first_name VARCHAR(30) ,\n" +
                "  last_name VARCHAR(30) ,\n" +
                "  age INT ,\n" +
                "  PRIMARY KEY (id)\n" +
                ");";

        stmt.execute(sqlCreate);
        System.out.println(getTable("SELECT * FROM mytable"));



        String sqlInsert= "INSERT INTO mytable (first_name, last_name, age) VALUES ";
        for (int i = 0; i <10000; i++) {

            String firstName = RandomStringUtils.randomAlphabetic(1).toUpperCase() + RandomStringUtils.randomAlphabetic(5, 10).toLowerCase();
            String lastName = RandomStringUtils.randomAlphabetic(7, 15).toUpperCase();
            int age = 10 + new Random().nextInt(40);

             sqlInsert += "('" + firstName + "', '" + lastName + "', "+ age +")";
             if (i!=9999){
                 sqlInsert +=",";
             }

        }

        System.out.println(sqlInsert);
        System.out.println("Start : " + LocalDateTime.now());
        stmt.executeUpdate(sqlInsert);
        System.out.println("End : " + LocalDateTime.now());

        System.out.println(getTable("SELECT * FROM mytable"));



    }
}
