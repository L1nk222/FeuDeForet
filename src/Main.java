import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        SwingUtilities.invokeLater(() -> {
            Foret foret = new Foret( Configuration.getRows(), Configuration.getCols(), Configuration.getPointDeparts());
            new Fenetre(foret);
        });
    }
}
