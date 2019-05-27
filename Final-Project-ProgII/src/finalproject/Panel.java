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
    private static final Vector G = new Vector(0.00, 0.012); //Vector gravedad
    private ArrayList<Ball> balls; //Arraylist que contiene las bolas
    private Integer arrayLength = 2; //Equivalente a balls.size
    private Boolean mouseMode = false;
    private Boolean wallMode = true;

    public Panel() {
        balls = new ArrayList<>();
        populate();
    }

    /**
     * popula el array de bolas
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
            try {
                //Gravedad respectiva al raton o al "suelo"
                if (mouseMode) {
                    Point b = MouseInfo.getPointerInfo().getLocation();
                    SwingUtilities.convertPointFromScreen(b, this); //sistema de posicion respectivo al panel
                    Double mouseX = (double) b.getX() - (Ball.radius / 2);
                    Double mouseY = (double) b.getY() - (Ball.radius / 2);
                    Vector Mouse = new Vector(mouseX, mouseY); //vector del raton
                    Vector uniMouse = (Vector.Sub(Mouse, balls.get(i).getPosition()).Uni());
                    uniMouse.EMultVector(G.module());
                    balls.get(i).setAcceleration(uniMouse);
                } else {
                    balls.get(i).setAcceleration(G);
                }
            } catch (HeadlessException e) {
                System.out.println("ERROR: " + e.getMessage());
            }
            balls.get(i).move();
            //Rebote o TP
            if (wallMode) {
                balls.get(i).rebound();
            } else {
                balls.get(i).tp();
            }
        }
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
