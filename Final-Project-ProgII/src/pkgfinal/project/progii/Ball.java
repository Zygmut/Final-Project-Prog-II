/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project.progii;

import java.awt.Color;

import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author Zygmut
 */
public class Ball extends JPanel {

    public double x;
    public double y;
    public Integer dim;
    public Color col;
    public double xvel = 0;
    public double yvel = 0;
    public double xac = 0;
    public double yac = 0.01;

    public Ball(Integer x, Integer y, Integer dim) {
        this.x = x;
        this.y = y;
        this.dim = dim;
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

}
