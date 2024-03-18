package pratice;
import java.io.*;
import java.util.Properties;
public class PropertiesDemo {
    public static void main (String[] args) throws IOException {

        FileInputStream fis = new FileInputStream("c://Users//Aximsoft//Desktop//text.properties");
        Properties prop = new Properties();
        prop.load(fis);
        System.out.println(prop);

        prop.setProperty("10","RDX");
        FileOutputStream fos = new FileOutputStream("c://Users//Aximsoft//Desktop//text.properties");
        prop.store(fos,"Updateed!!...");
    }
}