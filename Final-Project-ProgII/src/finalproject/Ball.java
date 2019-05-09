/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

import java.awt.Color;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Zygmut
 */
public class Ball extends JPanel {

    public Vector pos;
    public Vector vel;
    public Vector ac;
    public static Integer rad = 45; //45
    public Color col;

    public Ball(Double x, Double y) {
        pos = new Vector(x, y);
        vel = new Vector(0.00, 0.00);
        ac = new Vector(0.00, 0.00);
        col = rndColor();
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

    public void rebound(Integer comp) {
        vel.vector[comp] *= -1; //Cambio del signo de la componente x - rebound
        ac.vector[comp] *= -1;
    }

    public void tp() {

    }

    public void move() {
        try {
            vel.AddVector(ac);
            pos.AddVector(vel);
        } catch (UserExceptions.DiferentDimensionException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
//        pos.vector[0] += vel.vector[0];
//        pos.vector[1] += vel.vector[1];
    }
}
