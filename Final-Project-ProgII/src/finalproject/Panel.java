/*
 * Ruben Palmer Perez
 * Gestion y definicion del panel en el que se enuentra la simulacion
 */
package finalproject;

import java.awt.Graphics;
import java.awt.HeadlessException;
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

    public static final Integer Height = 759; //Jpanel Heigth
    public static final Integer Width = 1036; //Jpanel Width
    private static final Vector G = new Vector(0.00, 0.012);
    private ArrayList<Ball> balls;
    private Integer arrayLength;
    private Boolean mouseMode;
    private Boolean wallMode;

    public Panel() {
        arrayLength = 2;
        mouseMode = false;
        wallMode = true;
        balls = new ArrayList<>();
        populate();
    }

    /**
     * Permite popular un Arraylist con X cantidad de objetos "Ball". Esta
     * cantidad X esta determinada por la variable arrayLength que es la que se
     * comunica con el JFrame
     */
    public void populate() {
        balls.clear();
        Double xpos, ypos;
        for (int i = 0; i < arrayLength; i++) {
            xpos = (double) Math.random() * (Width - Ball.radius);
            ypos = (double) Math.random() * (Height - Ball.radius);
            Ball aux = new Ball(xpos, ypos);
            balls.add(aux);
        }
    }

    public void start() {
        try {
            while (true) {
                update();
                Thread.sleep(5
                );
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
            balls.get(i).paintComponent(g);
        }
    }

    public void update() {
        for (int i = 0; i < balls.size(); i++) {
            try {
                //GRAVEDAD RESPECTO AL SUELO O AL RATON
                if (mouseMode) {
                    balls.get(i).setAcceleration(MouseVector(i));
                } else {
                    balls.get(i).setAcceleration(G);
                }
            } catch (HeadlessException e) {
                System.out.println("ERROR: " + e.getMessage());
            }

            balls.get(i).move();
            //INTERACCIÓN DE REBOTAR O ATRAVESAR
            if (wallMode) {
                balls.get(i).rebound();
            } else {
                balls.get(i).tp();
            }
        }
    }

    public Vector MouseVector(int i) {
        Point b = MouseInfo.getPointerInfo().getLocation();
        SwingUtilities.convertPointFromScreen(b, this); //PUNTO B RESPECTIVO A LA VENTANA Y NO A LA PANTALLA
        Double mouseX = (double) b.getX() - (Ball.radius / 2);
        Double mouseY = (double) b.getY() - (Ball.radius / 2);
        Vector Mouse = new Vector(mouseX, mouseY);
        Vector uniMouse = (Vector.Sub(Mouse, balls.get(i).getPosition()).Uni());
        uniMouse.EMultVector(G.module());
        return uniMouse;
    }

    public void setArrayLength(Integer arrayLength) {
        this.arrayLength = arrayLength;
    }

    public void setMouseMode(Boolean mouseMode) {
        this.mouseMode = mouseMode;
    }

    public void setWallMode(Boolean wallMode) {
        this.wallMode = wallMode;
    }

}
