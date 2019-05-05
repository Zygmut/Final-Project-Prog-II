/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package finalproject;

/**
 *
 * @author Zygmut
 */
public class UserExceptions extends Exception {

    /**
     * Exception que salta cuando intentas sumar o restar dos vectores cuyas 
     * dimesniones no son iguales
     */
    static class DiferentDimensionException extends Exception {

        public DiferentDimensionException() {
            super("The vectors selected don't have the same dimension");
        }
    }

    /**
     * Exception que salta cuando intentas saber un valor de un vector que no
     * tiene dicha componente
     */
    static class SingleDiferentDimensionException extends Exception {

        public SingleDiferentDimensionException() {
            super("The vector does not has a different dimension");
        }
    }

}
