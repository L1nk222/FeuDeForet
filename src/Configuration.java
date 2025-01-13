import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("resources/param.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Impossible de charger le fichier de configuration.");
        }
    }

    public static int getRows() {
        return Integer.parseInt(properties.getProperty("rows", "20"));
    }

    public static int getCols() {
        return Integer.parseInt(properties.getProperty("cols", "20"));
    }

    public static double getProbaFeu() {
        return Double.parseDouble(properties.getProperty("probaFeu", "0.5"));
    }

}