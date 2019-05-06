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

    static Vector G = new Vector(0.00, 0.002); //0.00005 es tipo luna 0.00198 tierra se puede modificar
    Vector Terminal = new Vector(0.9, 0.9);
    Integer length = 250;
    ArrayList<Ball> balls = new ArrayList<>();
    Boolean mouseMode = false;
    Boolean wallMode = false;

    @Override
    protected void paintComponent(Graphics g) {
        Double xpos, ypos;
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        if (balls.size() < length) {
            for (int i = 0; i < length; i++) {
                xpos = (double) Math.random() * (Main.Width - (2 * Ball.rad) - 1); //45 = Ball.rad
                ypos = (double) Math.random() * (Main.Height - (2 * Ball.rad) - 21); //-20 top margin 
                Ball aux = new Ball(xpos, ypos);
                balls.add(aux);
            }
        }
        for (int i = 0; i < balls.size(); i++) {
            Ellipse2D circle = new Ellipse2D.Double(balls.get(i).pos.vector[0], balls.get(i).pos.vector[1], Ball.rad, Ball.rad);
            g2d.setColor(new Color(50, 50, 50)); //sin stroke
            g2d.setStroke(new BasicStroke(Ball.rad / 7));
            g2d.draw(circle);
            g2d.setColor(balls.get(i).col);

            g2d.fill(circle);
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
                        balls.get(i).vel.AddVector(G);
                    } else { //El puntero va por debajo del raton!!!
                        Point b = MouseInfo.getPointerInfo().getLocation();
                        SwingUtilities.convertPointFromScreen(b, this); //
                        Double x = (double) b.getX() - (Ball.rad / 2);
                        Double y = (double) b.getY() - (Ball.rad / 2);
                        Vector Mouse = new Vector(x, y); //vector del raton
                        Vector newpos = Vector.Sub(Mouse, balls.get(i).pos);
                        Vector unim = newpos.Uni();
                        unim.EMultVector(G.vector[1]);
                        balls.get(i).vel.AddVector(unim);
                    }

                } catch (UserExceptions.DiferentDimensionException e) {
                    System.out.println("ERROR: " + e.getMessage());
                }
                balls.get(i).pos.vector[0] += balls.get(i).vel.vector[0];

                balls.get(i).pos.vector[1] += balls.get(i).vel.vector[1];

                if (wallMode) {
                    /**
                     * TP horizontal
                     */
                    if (balls.get(i).pos.vector[0] < -Ball.rad) { //Limite izquierdo de la pantalla
                        balls.get(i).pos.vector[0] = (double) Main.Width;

                    } else if ((balls.get(i).pos.vector[0] > Main.Width)) { //Limite derecho de la pantalla
                        balls.get(i).pos.vector[0] = (double) -Ball.rad;
                    }
                    /**
                     * TP vertical
                     */
                    if (balls.get(i).pos.vector[1] < -Ball.rad) { //Limite superior de la pantalla
                        balls.get(i).pos.vector[1] = (double) Main.Height + 20;
                    } else if (balls.get(i).pos.vector[1] > (Main.Height + 20)) {
                        balls.get(i).pos.vector[1] = (double) -Ball.rad;//Limite inferior de la pantalla
                    }
                } else {
                    /**
                     * Rebote horizontal
                     */
                    if ((balls.get(i).pos.vector[0] < 0) || (balls.get(i).pos.vector[0] > (Main.Width - Ball.rad))) { //Limites de la pantalla
                        balls.get(i).vel.vector[0] *= -1; //Cambio del signo de la componente x - rebote
                        balls.get(i).ac.vector[0] *= -1;

                    }
                    /**
                     * Rebote vertical
                     */
                    if ((balls.get(i).pos.vector[1] < 0) || (balls.get(i).pos.vector[1] > (Main.Height - 20 - Ball.rad))) { //Limites de la pantalla
                        //           balls.get(i).vel.vector[1] =  -0.001;
                        balls.get(i).vel.vector[1] *= -1; //Cambio del signo de la componente y - rebote
                        balls.get(i).ac.vector[1] *= -1;

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
