package finalproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import serExceptions.*;
/**
 *
 * @author Zygmut
 */
public class Vector {

    private Double[] x;

    public Vector(Integer dim) {
        this.x = new Double[dim];
    }

    public Vector(Double x, Double y) {
        this.x = new Double[2];
        this.x[0] = x;
        this.x[1] = y;
    }

    public Vector(Double x, Double y, Double z) {
        this.x = new Double[3];
        this.x[0] = x;
        this.x[1] = y;
        this.x[2] = z;
    }

    /**
     * Devuelve la dimension del vector
     *
     * @return Dimension
     */
    public Integer getDim() {
        return x.length;
    }

    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < x.length; i++) {
            s += x[i] + " ";
        }
        return s + ")";
    }

    /**
     * Devuelve el modulo del vector
     *
     * @return Modulo
     */
    public Double mod() {
        Double sum = 0.00;
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * x[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Asigna el valor val a la posicion pos
     *
     * @param pos
     * @param val
     */
    public void setValor(Integer pos, Double val) {
        this.x[pos] = val;
    }
    
    public Vector AddVector(Vector x){
        Vector z;
        if (!(this.x.length == x.getDim())) {
            throw new 
        }
        for (int i = 0; i < 10; i++) {
            
        }
        return z;
    }
}
