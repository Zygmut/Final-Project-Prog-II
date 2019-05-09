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

    static Vector G = new Vector(0.00, 0.0002); //0.00005 es tipo luna 0.00198 tierra se puede modificar
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
        Graphics2D g2d = (Graphics2D) g;
        Double xpos, ypos;
        if (balls.size() < length) {
            for (int i = 0; i < length; i++) {
                xpos = (double) Math.random() * (Main.Width - (Ball.rad) - 1); //45 = Ball.rad
                ypos = (double) Math.random() * (Main.Height - (Ball.rad) - 1); //-20 top margin 
                Ball aux = new Ball(xpos, ypos);
                balls.add(aux);
            }
        }
        for (int i = 0; i < balls.size(); i++) { //creacion del array de bolas
            Ellipse2D circle = new Ellipse2D.Double(balls.get(i).pos.vector[0], balls.get(i).pos.vector[1], Ball.rad, Ball.rad);
            g2d.setColor(new Color(50, 50, 50));
            g2d.setStroke(new BasicStroke(Ball.rad / 7));
            g2d.draw(circle);
            g2d.setColor(balls.get(i).col);

            g2d.fill(circle);
        }
        System.out.println(this.getSize());
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
                    Double x = (double) b.getX() - (Ball.rad / 2);
                    Double y = (double) b.getY() - (Ball.rad / 2);

                    Vector Mouse = new Vector(x, y); //vector del raton
                    Vector uniMouse = (Vector.Sub(Mouse, balls.get(i).pos)).Uni();
                    uniMouse.EMultVector(G.module()); // se multiplica por el modulo de la graved que en este caso sera su componente y
                    balls.get(i).ac = uniMouse;

                } else {
                    balls.get(i).ac = G;
                }
            } catch (UserExceptions.DiferentDimensionException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            balls.get(i).move();

            /**
             * rebotes/
             */
            if (wallMode) {
                /**
                 * Rebote horizontal
                 */

                if ((balls.get(i).pos.vector[0] < 0) || (balls.get(i).pos.vector[0] > (Main.Width - Ball.rad))) { //Limites de la pantalla
                    balls.get(i).rebound(0);

                }
                /**
                 * Rebote vertical
                 */
                if ((balls.get(i).pos.vector[1] < 0) || (balls.get(i).pos.vector[1] > (Main.Height - Ball.rad))) { //Limites de la pantalla
                    balls.get(i).rebound(1);
                }
            } else {

                /**
                 * TP horizontal
                 */
                if (balls.get(i).pos.vector[0] < -Ball.rad) { //Limite izquierdo de la pantalla
                    balls.get(i).pos.vector[0] = (double) Main.Width;

                } else if ((balls.get(i).pos.vector[0] > Main.Width + 20)) { //Limite derecho de la pantalla
                    balls.get(i).pos.vector[0] = (double) -Ball.rad;
                }
                /**
                 * TP vertical
                 */
                if (balls.get(i).pos.vector[1] < -Ball.rad) { //Limite superior de la pantalla
                    balls.get(i).pos.vector[1] = (double) Main.Height;
                } else if (balls.get(i).pos.vector[1] > Main.Height) {
                    balls.get(i).pos.vector[1] = (double) -Ball.rad;//Limite inferior de la pantalla
                }
            }
            /**
             * Velocidad terminal
             */
            if ((balls.get(i).vel.vector[0] > Terminal.vector[0]) || (balls.get(i).vel.vector[0] < -Terminal.vector[0])) {
                balls.get(i).vel.vector[0] = Terminal.vector[0] * Math.signum(balls.get(i).vel.vector[0]);
            }
            if ((balls.get(i).vel.vector[1] > Terminal.vector[1]) || (balls.get(i).vel.vector[1] < -Terminal.vector[1])) {
                balls.get(i).vel.vector[1] = Terminal.vector[1] * Math.signum(balls.get(i).vel.vector[1]);
            }
        }
        repaint();
    }

}
