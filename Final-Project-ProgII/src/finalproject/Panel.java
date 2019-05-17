/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author Zygmut
 */
public class Panel extends JPanel {

    static Vector G = new Vector(0.00, 0.0001); //0.00005 es tipo luna 0.00198 tierra se puede modificar
    static Vector Terminal = new Vector(0.22, 0.22);
    ArrayList<Ball> balls;
    Integer length = 2;
    Boolean mouseMode = false;
    Boolean wallMode = true;

    public Panel() {
        balls = new ArrayList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Double xpos, ypos;
        if (balls.size() < length) {
            for (int i = 0; i < length; i++) {
                xpos = (double) Math.random() * (Main.Width - (Ball.radius) - 1); //45 = Ball.radius
                ypos = (double) Math.random() * (Main.Height - (Ball.radius) - 1); //-20 top margin 
                Ball aux = new Ball(xpos, ypos);
                balls.add(aux);
            }
        }
        for (int i = 0; i < balls.size(); i++) { //creacion del array de bolas
            balls.get(i).paint(g);
        }
        update(g);
    }

    @Override
    public void update(Graphics g) {

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
                    Vector uniMouse = (Vector.Sub(Mouse, balls.get(i).position)).Uni();
                    uniMouse.EMultVector(G.vector[1]); // se multiplica por el modulo de la graved que en este caso sera su componente y
                    balls.get(i).acceleration = uniMouse;

                } else {
                    balls.get(i).acceleration = G;
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
            if ((balls.get(i).velocity.vector[0] > Terminal.vector[0]) || (balls.get(i).velocity.vector[0] < -Terminal.vector[0])) {
                balls.get(i).velocity.vector[0] = Terminal.vector[0] * Math.signum(balls.get(i).velocity.vector[0]);
            }
            if ((balls.get(i).velocity.vector[1] > Terminal.vector[1]) || (balls.get(i).velocity.vector[1] < -Terminal.vector[1])) {
                balls.get(i).velocity.vector[1] = Terminal.vector[1] * Math.signum(balls.get(i).velocity.vector[1]);
            }
        }
        repaint();
    }

}
