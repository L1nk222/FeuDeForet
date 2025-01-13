import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foret {
    private int rows;
    private int cols;
    private Arbre[][] arbres;

    public Foret(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.arbres = new Arbre[rows][cols];
        initForet(Arrays.asList(new Point(4, 9), new Point(17, 6), new Point(13, 9)));
    }

    public void initForet(List<Point> feuDepart) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (feuDepart != null && feuDepart.contains(new Point(i, j))) {
                    arbres[i][j] = new Arbre(Color.RED, new Point(i,j));
                } else {
                    arbres[i][j] = new Arbre(Color.GREEN, new Point(i,j));
                }
            }
        }
    }

    public List<Arbre> getAllArbres() {
        List<Arbre> listeDesArbres = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                listeDesArbres.add(arbres[i][j]);
            }
        }
        return listeDesArbres;
    }

    public Arbre getArbre(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < cols) {
            return arbres[row][col];
        }
        return null;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
