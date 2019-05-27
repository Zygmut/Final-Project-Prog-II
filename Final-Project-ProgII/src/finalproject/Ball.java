/*
 * Ruben Palmer Perez
 * Gestion y definicion de bola
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

    private static final Vector Terminal = new Vector(2.0, 2.0); //velocidad terminal
    private Vector position;
    private Vector velocity;
    private Vector acceleration;
    public final static Integer radius = 45;
    private final Color color;
    private Ellipse2D shape;

    public Ball(Double x, Double y) {
        position = new Vector(x, y);
        velocity = new Vector(0.00, 0.00);
        acceleration = new Vector(0.00, 0.00);
        color = rndColor();
    }

    /**
     * Crea un color aleatorio para la bola
     *
     * @return Color
     */
    public static Color rndColor() {
        Random rnd = new Random();
        Integer R = rnd.nextInt(255 + 1);
        Integer G = rnd.nextInt(255 + 1);
        Integer B = rnd.nextInt(255 + 1);
        return new Color(R, G, B);
    }

    /**
     * Rebote en las paredes
     */
    public void rebound() {
        //Rebote horizontal
        if ((position.vector[0] < 0) || (position.vector[0] > (Panel.Width - Ball.radius))) {
            velocity.vector[0] *= -1;
        }
        //Rebote vertical
        if ((position.vector[1] < 0) || (position.vector[1] > (Panel.Height - Ball.radius))) {
            velocity.vector[1] *= -1;
        }
    }

    /**
     * Teletransporte
     */
    public void tp() {
        //TP horizontal
        if (position.vector[0] < -Ball.radius) { //Limite izquierdo de la pantalla
            position.vector[0] = (double) Panel.Width;
        } else if ((position.vector[0] > Panel.Width + 20)) { //Limite derecho de la pantalla
            position.vector[0] = (double) -Ball.radius;
        }
        //TP vertical
        if (position.vector[1] < -Ball.radius) { //Limite superior de la pantalla
            position.vector[1] = (double) Panel.Height;
        } else if (position.vector[1] > Panel.Height) {
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
        shape = new Ellipse2D.Double(position.vector[0], position.vector[1], Ball.radius, Ball.radius);
        //Borde de la bola 
        g2d.setColor(new Color(50, 50, 50));
        g2d.setStroke(new BasicStroke(Ball.radius / 7));
        g2d.draw(shape);
        //Interior de la bola
        g2d.setColor(color);
        g2d.fill(shape);
    }

    /**
     * Calculo de la posicion de la bola y limitador de velocidad
     *
     */
    public void move() {
        try {
            velocity.AddVector(acceleration);
            position.AddVector(velocity);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        //Velocidad terminal
        if (Math.abs(velocity.vector[0]) > Terminal.vector[0]) {
            velocity.vector[0] = Terminal.vector[0] * Math.signum(velocity.vector[0]);
        }
        if (Math.abs(velocity.vector[1]) > Terminal.vector[1]) {
            velocity.vector[1] = Terminal.vector[1] * Math.signum(velocity.vector[1]);
        }
    }

    public Vector getPosition() {
        return position;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

}
