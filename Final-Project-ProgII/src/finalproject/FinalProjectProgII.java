/*
 * Clase principal del programa
 */
package finalproject;

import javax.swing.JFrame;

/**
 *
 * @author Zygmut
 */
public class FinalProjectProgII extends JFrame {

    Panel panel;
    public Integer Width = 600;
    public Integer Height = 400;

    public FinalProjectProgII() {

        this.setTitle("Final Project");
        this.setSize(Width, Height);
        this.setResizable(false);
        this.setDefaultCloseOperation(FinalProjectProgII.EXIT_ON_CLOSE);

        panel = new Panel();
        this.getContentPane().add(panel);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new FinalProjectProgII().setVisible(true);
    }

}
