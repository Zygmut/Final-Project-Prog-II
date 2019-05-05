package finalproject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import finalproject.UserExceptions.*;

/**
 *
 * @author Zygmut
 */
public class Vector {

    public Double[] vector;

    public Vector(Integer dim) {
        this.vector = new Double[dim];
    }

    public Vector(Double x, Double y) {
        this.vector = new Double[2];
        this.vector[0] = x;
        this.vector[1] = y;
    }

    public Vector(Double x, Double y, Double z) {
        this.vector = new Double[3];
        this.vector[0] = x;
        this.vector[1] = y;
        this.vector[2] = z;
    }

    /**
     * Devuelve la dimension del vector
     *
     * @return Dimension
     */
    public Integer getDim() {
        return vector.length;
    }

    @Override
    public String toString() {
        String s = "(";
        for (int i = 0; i < vector.length; i++) {
            s += vector[i] + " ";
        }
        return s + ")";
    }

    /**
     * Devuelve el modulo del vector
     *
     * @return Modulo
     */
    public Double module() {
        Double sum = 0.00;
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i] * vector[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Devuelve el modulo del vector pasado por parametro
     *
     * @param y
     * @return
     */
    public static Double module(Vector y) {
        Double sum = 0.00;
        for (int i = 0; i < y.getDim(); i++) {
            sum += y.vector[i] * y.vector[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Permite sumar dos vectores
     *
     * @param y
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public void AddVector(Vector y) throws DiferentDimensionException {
        if (!(this.vector.length == y.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] += y.vector[i];
        }
    }

    /**
     * Permite sumar dos vectores pasados como parametros
     *
     * @param x
     * @param y
     * @return z
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public static Vector Add(Vector x, Vector y) throws DiferentDimensionException {
        Vector z;
        if (!(x.getDim() == y.getDim())) {
            throw new DiferentDimensionException();
        }
        z = new Vector(x.getDim());
        for (int i = 0; i < x.getDim(); i++) {
            z.vector[i] = x.vector[i] + y.vector[i];
        }
        return z;
    }

    /**
     * Permite restar dos vectores
     *
     * @param y
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public void SubVector(Vector y) throws DiferentDimensionException {

        if (!(this.vector.length == y.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] -= y.vector[i];
        }
    }

    /**
     * Permite restar dos vectores pasados como parametros
     *
     * @param x
     * @param y
     * @return z
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public static Vector Sub(Vector x, Vector y) throws DiferentDimensionException {
        Vector z;
        if (!(x.getDim() == y.getDim())) {
            throw new DiferentDimensionException();
        }
        z = new Vector(x.getDim());
        for (int i = 0; i < x.getDim(); i++) {
            z.vector[i] = x.vector[i] - y.vector[i];
        }
        return z;
    }

    /**
     * Permite multiplicar un vector por un valor
     *
     * @param y
     */
    public void EMultVector(Double y) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] *= y;
        }
    }

    /**
     * Permite multiplicar un vector por un valor ambos pasados como parametro
     *
     * @param x
     * @param y
     * @return z
     */
    public static Vector EMult(Vector x, Double y) {
        Vector z = new Vector(x.getDim());
        for (int i = 0; i < 10; i++) {
            z.vector[i] = x.vector[i] * y;
        }
        return z;
    }

    /**
     * Permite dividir un vector por un valor
     *
     * @param y
     */
    public void EDivVector(Double y) {
        for (int i = 0; i < vector.length; i++) {
            vector[i] /= y;
        }
    }

    /**
     * Permite dividir un vector por un valor ambos pasados como parametro
     *
     * @param x
     * @param y
     * @return z
     */
    public static Vector EDiv(Vector x, Double y) {
        Vector z = new Vector(x.getDim());
        for (int i = 0; i < 10; i++) {
            z.vector[i] = x.vector[i] / y;
        }
        return z;
    }

    /**
     * Permite saber el vector unitario
     *
     * @return z
     */
    public Vector Uni() {
        Vector z = new Vector(vector.length);
        Double mod = module();
        for (int i = 0; i < vector.length; i++) {
            z.vector[i] = vector[i] / mod;
        }
        return z;
    }

    /**
     * Permite saber el vector unitario de un vector pasado por parametro
     *
     * @param y
     * @return z
     */
    public static Vector Uni(Vector y) {
        Vector z = new Vector(y.getDim());
        Double mod = Vector.module(y);
        for (int i = 0; i < 10; i++) {
            z.vector[i] = y.vector[i] / mod;
        }
        return z;
    }

    /**
     * Devuelve el producto escalar entre el vector x y un vector pasado por
     * parametro
     *
     * @param y
     * @return sum
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public Double EscVector(Vector y) throws DiferentDimensionException {
        Double sum = 0.00;
        if (!(vector.length == y.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i] * y.vector[i];
        }
        return sum;
    }

    /**
     * Devuelve el producto escalar de dos vectores pasados por parametro
     *
     * @param x
     * @param y
     * @return sum
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public static Double EscVector(Vector x, Vector y) throws DiferentDimensionException {
        Double sum = 0.00;
        if (!(x.getDim() == y.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < x.getDim(); i++) {
            sum += x.vector[i] * y.vector[i];
        }
        return sum;
    }
}
