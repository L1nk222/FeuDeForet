import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class Feu {

    private static final double probaFeu = Configuration.getProbaFeu();

    public static void bruler(Foret foret) {
        System.out.println("Le feu se avance");

        List<Arbre> arbresABruler = new ArrayList<>();
        List<Arbre> arbres = foret.getAllArbres();
        Random random = new Random();

        for (Arbre arbre : arbres) {
            if (arbre.getColor() == Color.RED) {
                System.out.println("Un arbre est en feu à: " + arbre.getPosition());

                int x = arbre.getPosition().x;
                int y = arbre.getPosition().y;

                if (x + 1 < foret.getRows() && random.nextDouble() < probaFeu) {
                    Arbre voisin = foret.getArbre(x + 1, y);
                    if (voisin != null && voisin.getColor() == Color.GREEN) {
                        arbresABruler.add(voisin);
                    }
                }

                if (x - 1 >= 0 && random.nextDouble() < probaFeu) {
                    Arbre voisin = foret.getArbre(x - 1, y);
                    if (voisin != null && voisin.getColor() == Color.GREEN) {
                        arbresABruler.add(voisin);
                    }
                }

                if (y + 1 < foret.getCols() && random.nextDouble() < probaFeu) {
                    Arbre voisin = foret.getArbre(x, y + 1);
                    if (voisin != null && voisin.getColor() == Color.GREEN) {
                        arbresABruler.add(voisin);
                    }
                }

                if (y - 1 >= 0 && random.nextDouble() < probaFeu) {
                    Arbre voisin = foret.getArbre(x, y - 1);
                    if (voisin != null && voisin.getColor() == Color.GREEN) {

                        arbresABruler.add(voisin);
                    }
                }

                arbre.setColor(Color.GRAY);
            }
        }

        for (Arbre arbre : arbresABruler) {
            arbre.setColor(Color.RED);
            System.out.println("L'arbre " + arbre.getPosition() + " est en feu.");
        }
    }
}
