/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Zygmut
 */
public class Panel extends JPanel {

    Random Rx = new Random(Main.Width/2);
    
    Ball ball = new Ball(Rx.nextDouble(), 0.00, 50);
    Vector G = new Vector(0.00, 9.8);

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(ball.pos.getX(), ball.pos.getY(), ball.dim, ball.dim);
        g2d.setStroke(new BasicStroke(5));
        g2d.draw(circle);
        g2d.setColor(ball.col);

        g2d.fill(circle);

        update(g);
    }

    @Override
    public void update(Graphics g) {
        /**
         * TP horizontal
         */
//        ball.pos.setValue(0, (ball.pos.getX() + ball.vel.getX()));
//        if (ball.pos.getX() < -ball.dim) { //Limite izquierdo de la pantalla
//            ball.pos.setValue(0, (double) Main.Width);
//            System.out.println("TP x izquierda");
//        } else if ((ball.pos.getX() > Main.Width)) { //Limite derecho de la pantalla
//            ball.pos.setValue(0, (double) -ball.dim);
//            System.out.println("TP X derecha");
//        }

        /**
         * TP vertical
         */
//        ball.pos.setValue(1, (ball.pos.getY() + ball.vel.getY()));
//        if (ball.pos.getY() < -ball.dim) { //Limite superior de la pantalla
//            ball.pos.setValue(1, (double) (Main.Height + 20));
//            System.out.println("TP y arriba");
//        } else if (ball.pos.getY() > Main.Height + 20) {
//            ball.pos.setValue(1, (double) (-ball.dim)); //Limite inferior de la pantalla
//            System.out.println("TP y Abajo");
//        }
        /**
         * Rebote horizontal
         */
        ball.pos.setValue(0, (ball.pos.getX() + ball.vel.getX()));
        if ((ball.pos.getX() < 0) || (ball.pos.getX() > Main.Width - ball.dim)) { //Limites de la pantalla
            ball.vel.setValue(0, (ball.vel.getX() * -1)); //Cambio del signo de la componente x - rebote
            System.out.println("Reboto x");
        }
        /**
         * Rebote vertical
         */
        ball.pos.setValue(1, (ball.pos.getY() + ball.vel.getY()));
        if ((ball.pos.getY() < 0) || (ball.pos.getY() > Main.Height - 20 - ball.dim)) { //Limites de la pantalla
            ball.vel.setValue(1, (ball.vel.getY() * -1)); //Cambio del signo de la componente y - rebote
            System.out.println("Reboto y");
        }
        repaint();
    }

}
