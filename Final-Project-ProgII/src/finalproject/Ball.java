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

    private static final Vector Terminal = new Vector(2.0, 2.0);
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
     * Devuelve un nuevo color RGB aleatorio
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
     * Permite cambiar el sentido de la componente velocidad para obtener el
     * efecto de rebote tanto en el eje X como en el eje Y
     */
    public void rebound() {
        //REBOTE HORIZONTAL
        if ((position.vector[0] < 0) || (position.vector[0] > (Panel.Width - Ball.radius))) {
            velocity.vector[0] *= -1;
        }
        //REBOTE VERTICAL
        if ((position.vector[1] < 0) || (position.vector[1] > (Panel.Height - Ball.radius))) {
            velocity.vector[1] *= -1;
        }
    }

    /**
     * Permite cambiar el vector posicion para obtener el efecto de transpasar
     * paredes y aparecer en el lado contrario
     */
    public void tp() {
        //TP HORIZONTAL
        if (position.vector[0] < -Ball.radius) {
            position.vector[0] = (double) Panel.Width;
        } else if ((position.vector[0] > Panel.Width)) {
            position.vector[0] = (double) -Ball.radius;
        }
        //TP VETRICAL
        if (position.vector[1] < -Ball.radius) {
            position.vector[1] = (double) Panel.Height;
        } else if (position.vector[1] > Panel.Height + 20) {
            position.vector[1] = (double) -Ball.radius;
        }
    }

    /**
     * Renderiza el objeto bola mediante los parametros de esta misma. Un
     * ejemplo de estos parametros son el radio o su color
     *
     * @param g
     */
    public void paintComponent(Graphics g) {
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
     * Actualiza el vector velocidad y posicion para obtener un movimiento
     * natural. Ademas de esto comprueba, y en caso de superarla actualizarla,
     * si supera su velocidad terminal.
     *
     */
    public void move() {
        velocity.AddVector(acceleration);
        if (Math.abs(velocity.vector[0]) > Terminal.vector[0]) {
            velocity.vector[0] = Terminal.vector[0] * Math.signum(velocity.vector[0]);
        }
        if (Math.abs(velocity.vector[1]) > Terminal.vector[1]) {
            velocity.vector[1] = Terminal.vector[1] * Math.signum(velocity.vector[1]);
        }
        position.AddVector(velocity);
    }

    public Vector getPosition() {
        return position;
    }

    public void setAcceleration(Vector acceleration) {
        this.acceleration = acceleration;
    }

}
