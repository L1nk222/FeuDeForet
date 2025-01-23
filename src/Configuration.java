import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.List;


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
        return Double.parseDouble(properties.getProperty("probaFeu", "1"));
    }

    public static List<Point> getPointDeparts() {
        String feuxString = properties.getProperty("pointDeparts");
        List<Point> pointDeparts = new ArrayList<>();

        if (!feuxString.isEmpty()) {
            String[] points = feuxString.split(";"); // Séparer les points par ";"
            for (String point : points) {
                String[] coords = point.split(","); // Séparer x et y par ","
                if (coords.length == 2) {
                    try {
                        int x = Integer.parseInt(coords[0]);
                        int y = Integer.parseInt(coords[1]);
                        pointDeparts.add(new Point(x, y));
                    } catch (NumberFormatException e) {
                        System.err.println("Erreur coordonnée point de depart : " + point);
                    }
                }
            }
        }

        return pointDeparts;
    }
}

