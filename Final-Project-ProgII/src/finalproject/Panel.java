/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zygmut
 */
public class Panel extends JPanel {

    static Vector G = new Vector(0.00, 0.012); //Vector gravedad
    static Vector Terminal = new Vector(1., 1.); //Vector velocidad 2x2
    ArrayList<Ball> balls; //array que contiene las bolas
    Integer arrayLength = 2; //equivalente a 
    Boolean mouseMode = false;
    Boolean wallMode = true;

    public Panel() {
        balls = new ArrayList<>();
        populate();
    }

    /**
     * popula el array de bolas
     */
    public void populate() {
        Double xpos, ypos;
        for (int i = 0; i < arrayLength; i++) {
            xpos = (double) Math.random() * (Main.Width - (Ball.radius) - 1);
            ypos = (double) Math.random() * (Main.Height - (Ball.radius) - 1);
            Ball aux = new Ball(xpos, ypos);
            balls.add(aux);
        }

    }

    public void start() {
        try {
            while (true) {
                update();
                Thread.sleep(10);
                repaint();
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < balls.size(); i++) {
            balls.get(i).paint(g);
        }
    }

    public void update() {

        for (int i = 0; i < balls.size(); i++) {
            /**
             * Gravedad y movimiento
             */
            try {
                if (mouseMode) {
                    Point b = MouseInfo.getPointerInfo().getLocation();
                    SwingUtilities.convertPointFromScreen(b, this); //sistema de posicion respectivo al panel
                    Double x = (double) b.getX() - (Ball.radius / 2);
                    Double y = (double) b.getY() - (Ball.radius / 2);

                    Vector Mouse = new Vector(x, y); //vector del raton
                    Vector uniMouse = (Vector.Sub(Mouse, balls.get(i).getPosition())).Uni();
                    uniMouse.EMultVector(G.vector[1]); // se multiplica por el modulo de la graved que en este caso sera su componente y
                    balls.get(i).setAcceleration(uniMouse);

                } else {
                    balls.get(i).setAcceleration(G);
                }
            } catch (UserExceptions.DiferentDimensionException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            balls.get(i).move();

            /**
             * rebotes/
             */
            if (wallMode) {
                balls.get(i).rebound();
            } else {
                balls.get(i).tp();
            }
            /**
             * Velocidad terminal
             */
            if ((balls.get(i).getVelocity().vector[0] > Terminal.vector[0]) || (balls.get(i).getVelocity().vector[0] < -Terminal.vector[0])) {
                double terminal = Terminal.vector[0] * Math.signum(balls.get(i).getVelocity().vector[0]);
                balls.get(i).setVelocity(new Vector(terminal, balls.get(i).getVelocity().vector[1]));
            }
            if ((balls.get(i).getVelocity().vector[1] > Terminal.vector[1]) || (balls.get(i).getVelocity().vector[1] < -Terminal.vector[1])) {
                double terminal = Terminal.vector[1] * Math.signum(balls.get(i).getVelocity().vector[1]);
                balls.get(i).setVelocity(new Vector(balls.get(i).getVelocity().vector[0], terminal));
            }
        }

    }

}
