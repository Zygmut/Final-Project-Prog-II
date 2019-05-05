/*
 * Clase principal del programa
 */
package finalproject;

import javax.swing.JFrame;

/**
 *
 * @author Zygmut
 */
public class Main extends JFrame {

    Panel panel;
    public static Integer Width = 600;
    public static Integer Height = 400;

    public Main() {

        this.setTitle("Final Project");
        this.setSize(Width, Height);
        this.setResizable(false);
        this.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);

        panel = new Panel();
        this.getContentPane().add(panel);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}
