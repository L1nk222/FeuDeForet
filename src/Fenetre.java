import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Fenetre {
    private Foret foret;
    private JPanel[][] arbrePanels;
    private JFrame frame;

    public Fenetre(Foret foret) {
        this.foret = foret;
        this.frame = new JFrame("Forêt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 550);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel gridPanel = new JPanel(new GridLayout(foret.getRows(), foret.getCols(), 5, 5));
        gridPanel.setBackground(Color.BLACK);

        arbrePanels = new JPanel[foret.getRows()][foret.getCols()];
        for (int i = 0; i < foret.getRows(); i++) {
            for (int j = 0; j < foret.getCols(); j++) {
                JPanel arbrePanel = new JPanel();
                arbrePanel.setBackground(foret.getArbre(i, j).getColor());
                arbrePanel.setOpaque(true);
                arbrePanels[i][j] = arbrePanel;
                gridPanel.add(arbrePanel);
            }
        }

        mainPanel.add(gridPanel, BorderLayout.CENTER);

        JButton forwadTimeButton = new JButton("Passage du temps");
        forwadTimeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Feu.bruler(foret);
                rafraichirGrille();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(forwadTimeButton);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    private void rafraichirGrille() {
        for (int i = 0; i < foret.getRows(); i++) {
            for (int j = 0; j < foret.getCols(); j++) {
                arbrePanels[i][j].setBackground(foret.getArbre(i, j).getColor());
            }
        }
    }
}
