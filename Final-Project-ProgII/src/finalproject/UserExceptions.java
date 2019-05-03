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

    static class DiferentDimensionException extends Exception {

        public DiferentDimensionException() {
            super("The vectors selected don't have the same dimension");
        }
    }
    
}
