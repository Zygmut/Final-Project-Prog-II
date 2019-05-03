/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgfinal.project.progii;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;


/**
 *
 * @author Zygmut
 */
public class Panel extends JPanel {

    Ball ball = new Ball(0, 0, 50);

    ;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        Ellipse2D circle = new Ellipse2D.Double(ball.x, ball.y, ball.dim, ball.dim);
        g2d.setColor(ball.col);
        g2d.fill(circle);
        update(g);
    }

    @Override
    public void update(Graphics g) {
        ball.x += ball.xvel;
        if ((ball.x < 0) || (ball.x > 550)) {
            ball.xvel = ball.xvel * -1;
        }
        ball.y += ball.yvel;
        ball.yvel += ball.yac;
        if ((ball.y < 0) || (ball.y > 330)) {
            ball.yvel = ball.yvel * -1;
        }
        repaint();
    }

}
