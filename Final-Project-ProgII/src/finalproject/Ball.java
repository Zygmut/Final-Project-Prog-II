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
import java.awt.geom.Ellipse2D;
import java.util.Random;

/**
 *
 * @author Zygmut
 */
public class Ball {

    public Vector position;
    public Vector velocity;
    public Vector acceleration;
    public static Integer radius = 45;
    public Color color;

    public Ball(Double x, Double y) {
        position = new Vector(x, y);
        velocity = new Vector(0.00, 0.00);
        acceleration = new Vector(0.00, 0.00);
        color = rndColor();
    }

    /**
     * Crea un color aleatorio para la bola
     *
     * @return
     */
    public static Color rndColor() {
        Random rnd = new Random();
        Integer R = rnd.nextInt(255 + 1);
        Integer G = rnd.nextInt(255 + 1);
        Integer B = rnd.nextInt(255 + 1);
        return new Color(R, G, B);
    }

    /**
     * Rebotar en las paredes
     *
     * @param comp
     */
    public void rebound() {
        /**
         * Rebote horizontal
         */

        if ((position.vector[0] < 0) || (position.vector[0] > (Main.Width - Ball.radius))) { //Limites de la pantalla
            velocity.vector[0] *= -1;
        }
        /**
         * Rebote vertical
         */
        if ((position.vector[1] < 0) || (position.vector[1] > (Main.Height - Ball.radius))) { //Limites de la pantalla
            velocity.vector[1] *= -1;
        }

    }

    public void tp() {
        if (position.vector[0] < -Ball.radius) { //Limite izquierdo de la pantalla
            position.vector[0] = (double) Main.Width;

        } else if ((position.vector[0] > Main.Width + 20)) { //Limite derecho de la pantalla
            position.vector[0] = (double) -Ball.radius;
        }
        /**
         * TP vertical
         */
        if (position.vector[1] < -Ball.radius) { //Limite superior de la pantalla
            position.vector[1] = (double) Main.Height;
        } else if (position.vector[1] > Main.Height) {
            position.vector[1] = (double) -Ball.radius;//Limite inferior de la pantalla
        }

    }

    /**
     * Pinta la bola
     *
     * @param g
     */
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(position.vector[0], position.vector[1], Ball.radius, Ball.radius);
        g2d.setColor(new Color(50, 50, 50));
        g2d.setStroke(new BasicStroke(Ball.radius / 7));
        g2d.draw(circle);
        g2d.setColor(color);
        g2d.fill(circle);
    }

    /**
     * Calculo de la nueva posicion de la bola
     *
     */
    public void move() {
        try {
            velocity.AddVector(acceleration);
            position.AddVector(velocity);
        } catch (UserExceptions.DiferentDimensionException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
