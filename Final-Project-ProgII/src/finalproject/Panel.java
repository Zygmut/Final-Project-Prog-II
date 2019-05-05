/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

/**
 *
 * @author Zygmut
 */
public class Panel extends JPanel {

    Ball ball = new Ball((double) Main.Width / 2, 0.00, 150);
    Vector G = new Vector(0.00, 0.00005); //0.00005 es tipo luna 
    Vector Terminal = new Vector(0.50, 0.50);
    Boolean mode = false;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(ball.pos.vector[0], ball.pos.vector[1], ball.dim, ball.dim);
        g2d.setStroke(new BasicStroke(ball.dim / 5));
        g2d.draw(circle);
        g2d.setColor(ball.col);

        g2d.fill(circle);

        update(g);
    }

    @Override
    public void update(Graphics g) {

        /**
         * Gravedad y movimiento
         */
        try {
            if (mode) {
                ball.ac.AddVector(G);
            } else {
                PointerInfo a = MouseInfo.getPointerInfo();
                Point b = a.getLocation();
                Double x = (double) b.getX();
                Double y = (double) b.getY();
                Vector Mouse = new Vector(x, y);
                Vector unim = Mouse.Uni();

                System.out.println(unim);
                ball.vel.AddVector(G);
            }

        } catch (UserExceptions.DiferentDimensionException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        ball.pos.vector[0] += ball.vel.vector[0] + ball.ac.vector[0];
        ball.pos.vector[1] += ball.vel.vector[1] + ball.ac.vector[1];

        /**
         * TP horizontal
         */
        if (ball.pos.vector[0] < -ball.dim) { //Limite izquierdo de la pantalla
            ball.pos.vector[0] = (double) Main.Width;
            System.out.println("TP x izquierda");
        } else if ((ball.pos.vector[0] > Main.Width)) { //Limite derecho de la pantalla
            ball.pos.vector[0] = (double) -ball.dim;
            System.out.println("TP X derecha");
        }
        /**
         * TP vertical
         */
//        if (ball.pos.vector[1] < -ball.dim) { //Limite superior de la pantalla
//            ball.pos.vector[1] = (double) Main.Height + 20;
//            System.out.println("TP y arriba");
//        } else if (ball.pos.vector[1] > (Main.Height + 20)) {
//            ball.pos.vector[1] = (double) -ball.dim;//Limite inferior de la pantalla
//            System.out.println("TP y Abajo");
//        }
        /**
         * Rebote horizontal
         */
//        if ((ball.pos.vector[0] < 0) || (ball.pos.vector[0] > (Main.Width - ball.dim))) { //Limites de la pantalla
//            ball.vel.vector[0] *= -1; //Cambio del signo de la componente x - rebote
//            System.out.println("Reboto x");
//        }
        /**
         * Rebote vertical
         */
        if ((ball.pos.vector[1] < 0) || (ball.pos.vector[1] > Main.Height - 20 - ball.dim)) { //Limites de la pantalla
            ball.vel.vector[1] *= -1; //Cambio del signo de la componente y - rebote
            System.out.println("Reboto y");
        }
        if (ball.vel.vector[0] > Terminal.vector[0]) {
            ball.vel.vector[0] = Terminal.vector[0];
        } else if (ball.vel.vector[1] > Terminal.vector[1]) {
            ball.vel.vector[1] = Terminal.vector[1];
        }

        repaint();
    }

}
