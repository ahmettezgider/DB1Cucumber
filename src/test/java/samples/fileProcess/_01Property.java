package samples.fileProcess;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class _01Property {

    public static void main(String[] args) throws IOException {
        // property tanimlaniyor
        Properties properties = new Properties();

        // hangi property file okunacak
        String file = "src/test/java/fileProcess/_01PropertyFile.properties";
        //String file1 = "c:/myFiles/_01PropertyFile.properties";

        // FileReader kullanarak okunur
        FileReader fileReader = new FileReader(file);

        properties.load(fileReader);

        System.out.println("properties.getProperty(\"url\") = " + properties.getProperty("url"));
        System.out.println("properties.getOrDefault(\"url1\", \"yok\") = " + properties.getOrDefault("url1", "yok"));

        fileReader.close();
    }
}
