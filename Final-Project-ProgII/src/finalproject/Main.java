/*
 * Clase principal del programa
 */
package finalproject;

import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Zygmut
 */
public class Main extends JFrame {

    Panel panel;
    private javax.swing.JCheckBox setWalls;
    private javax.swing.JCheckBox followMouse;
    private javax.swing.JTextField ballNumber;
    private javax.swing.JLabel ballLabel;
    public static Integer Width = 1024;
    public static Integer Height = 768;

    public Main() {
        this.setTitle("Final Project");
        this.setDefaultCloseOperation(Main.EXIT_ON_CLOSE);
        initcomponents();
    }

    private void initcomponents() {
        panel = new Panel();
        setWalls = new JCheckBox("With walls", true);
        followMouse = new JCheckBox("Follow mouse", false);
        ballNumber = new JTextField();
        ballLabel = new JLabel("# Balls");

        ballNumber.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        ballNumber.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        ballNumber.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ballNumberActionPerformed(evt);
            }

            private void ballNumberActionPerformed(java.awt.event.ActionEvent evt) {
                String text = ballNumber.getText();
                Integer num = 0;
                boolean numeric = true;
                try {
                    num = Integer.parseInt(text);
                } catch (NumberFormatException e) {
                    System.out.println("Not a number"); //Exception
                    numeric = false;
                }
                if (numeric) {
                    panel.balls.clear();
                    panel.length = num;
                }
            }

        });

        setWalls.setFont(new java.awt.Font("Dialog", 0, 16)); // NOI18N
        setWalls.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setWallsActionPerformed(evt);
            }

            private void setWallsActionPerformed(java.awt.event.ActionEvent evt) {
                panel.wallMode = setWalls.isSelected();

            }
        });

        followMouse.setFont(new java.awt.Font("Dialog", 0, 16)); 
        followMouse.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                followMouseActionPerformed(evt);
            }

            private void followMouseActionPerformed(java.awt.event.ActionEvent evt) {
                panel.mouseMode = followMouse.isSelected();
            }
        });

        panel.setForeground(new java.awt.Color(102, 102, 102));
        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 1036, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
                panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 765, Short.MAX_VALUE)
        );

        ballLabel.setFont(new java.awt.Font("Dialog", 0, 18));
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(followMouse)
                                                                        .addComponent(setWalls, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGap(0, 0, Short.MAX_VALUE)
                                                                .addComponent(ballNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(46, 46, 46))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addComponent(ballLabel)
                                                .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(246, 246, 246)
                                .addComponent(ballLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ballNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(setWalls, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(followMouse, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(null); //centrado
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new Main().setVisible(true);
    }

}
