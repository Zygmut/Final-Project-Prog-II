/*
 * Ruben Palmer Perez
 * Clase principal del programa
 */
package finalproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Zygmut
 */
public class Main extends JFrame {

    static Panel panel;
    private JCheckBox setWalls;
    private JCheckBox followMouse;
    private JTextField ballNumber;
    private JLabel ballLabel;

    public Main() {
        this.setTitle("Flying Balls");
        this.setSize(1230, 759);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.lightGray);
        initcomponents();
    }

    private void initcomponents() {
        panel = new Panel();
        setWalls = new JCheckBox("With walls", true);
        followMouse = new JCheckBox("Follow mouse", false);
        ballNumber = new JTextField("2");
        ballLabel = new JLabel("# Balls");

        panel.setBounds(0, 0, 1036, 759);

        ballNumber.setBounds(1054, 276, 124, 53);
        ballNumber.setFont(new Font("Dialog", 0, 24));
        ballNumber.setHorizontalAlignment(JTextField.RIGHT);
        ballNumber.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                ballNumberActionPerformed(evt);
            }

            /**
             * Controlador del la caja de texto que define la cantidad de bolas
             * que hay en la simulacion
             *
             * @param evt
             */
            private void ballNumberActionPerformed(ActionEvent evt) {
                String text = ballNumber.getText();
                Integer num = 0;
                boolean numeric = true;
                try {
                    num = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    numeric = false;
                }
                if (numeric) {
                    panel.setArrayLength(num);
                    panel.populate();
                }
            }

        });

        setWalls.setBounds(1054, 347, 111, 42);
        setWalls.setBackground(Color.lightGray);
        setWalls.setFont(new Font("Dialog", 0, 16));
        setWalls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                setWallsActionPerformed(evt);
            }

            /**
             * Controlador de la checkbox "With walls"
             *
             * @param evt
             */
            private void setWallsActionPerformed(ActionEvent evt) {
                panel.setWallMode(setWalls.isSelected());

            }
        });

        followMouse.setBounds(1054, 389, 124, 50);
        followMouse.setBackground(Color.lightGray);
        followMouse.setFont(new Font("Dialog", 0, 16));
        followMouse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                followMouseActionPerformed(evt);
            }

            /**
             * Controlador de la checkbox "Follow mouse"
             *
             * @param evt
             */
            private void followMouseActionPerformed(ActionEvent evt) {
                panel.setMouseMode(followMouse.isSelected());
            }
        });

        ballLabel.setBounds(1075, 246, 54, 24);
        ballLabel.setFont(new Font("Dialog", 0, 18));

        this.getContentPane().add(panel);
        this.getContentPane().add(ballLabel);
        this.getContentPane().add(ballNumber);
        this.getContentPane().add(followMouse);
        this.getContentPane().add(setWalls);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().setVisible(true);
        panel.start();
    }

}
