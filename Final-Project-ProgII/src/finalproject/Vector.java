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

    /**
     * void constructor
     *
     * @param dim
     */
    public Vector(Integer dim) {
        this.vector = new Double[dim];
    }
    /**
     * "2d" Vector
     * @param x
     * @param y 
     */
    public Vector(Double x, Double y) {
        this.vector = new Double[2];
        this.vector[0] = x;
        this.vector[1] = y;
    }
    /**
     * "3d" Vector
     * @param x
     * @param y
     * @param z 
     */
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
     * Version estatica de module
     *
     * @param Vx
     * @return
     */
    public static Double module(Vector Vx) {
        Double sum = 0.00;
        for (int i = 0; i < Vx.getDim(); i++) {
            sum += Vx.vector[i] * Vx.vector[i];
        }
        return Math.sqrt(sum);
    }

    /**
     * Permite sumar dos vectores
     *
     * @param Vx
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public void AddVector(Vector Vx) throws DiferentDimensionException {
        if (!(this.vector.length == Vx.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] += Vx.vector[i];
        }
    }

    /**
     * Version estatica de AddVector
     *
     * @param Vx
     * @param Vy
     * @return z
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public static Vector Add(Vector Vx, Vector Vy) throws DiferentDimensionException {
        Vector z;
        if (!(Vx.getDim() == Vy.getDim())) {
            throw new DiferentDimensionException();
        }
        z = new Vector(Vx.getDim());
        for (int i = 0; i < Vx.getDim(); i++) {
            z.vector[i] = Vx.vector[i] + Vy.vector[i];
        }
        return z;
    }

    /**
     * Permite restar dos vectores
     *
     * @param Vx
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public void SubVector(Vector Vx) throws DiferentDimensionException {

        if (!(this.vector.length == Vx.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < vector.length; i++) {
            vector[i] -= Vx.vector[i];
        }
    }

    /**
     * Version estatica de SubVector
     *
     * @param Vx
     * @param Vy
     * @return z
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public static Vector Sub(Vector Vx, Vector Vy) throws DiferentDimensionException {
        Vector z;
        if (!(Vx.getDim() == Vy.getDim())) {
            throw new DiferentDimensionException();
        }
        z = new Vector(Vx.getDim());
        for (int i = 0; i < Vx.getDim(); i++) {
            z.vector[i] = Vx.vector[i] - Vy.vector[i];
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
     * Version estatica de EMultVector
     *
     * @param Vx
     * @param y
     * @return z
     */
    public static Vector EMult(Vector Vx, Double y) {
        Vector z = new Vector(Vx.getDim());
        for (int i = 0; i < Vx.getDim(); i++) {
            z.vector[i] = Vx.vector[i] * y;
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
     * Version estatica de EDivVector
     *
     * @param Vx
     * @param y
     * @return z
     */
    public static Vector EDiv(Vector Vx, Double y) {
        Vector z = new Vector(Vx.getDim());
        for (int i = 0; i < Vx.getDim(); i++) {
            z.vector[i] = Vx.vector[i] / y;
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
     * Version estatica de Uni
     *
     * @param Vx
     * @return z
     */
    public static Vector Uni(Vector Vx) {
        Vector z = new Vector(Vx.getDim());
        Double mod = Vector.module(Vx);
        for (int i = 0; i < Vx.getDim(); i++) {
            z.vector[i] = Vx.vector[i] / mod;
        }
        return z;
    }

    /**
     * Devuelve el producto escalar entre el vector x y un vector pasado por
     * parametro
     *
     * @param Vx
     * @return sum
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public Double EscVector(Vector Vx) throws DiferentDimensionException {
        Double sum = 0.00;
        if (!(vector.length == Vx.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < vector.length; i++) {
            sum += vector[i] * Vx.vector[i];
        }
        return sum;
    }

    /**
     * Version estatica de EscVector
     *
     * @param Vx
     * @param Vy
     * @return sum
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public static Double EscVector(Vector Vx, Vector Vy) throws DiferentDimensionException {
        Double sum = 0.00;
        if (!(Vx.getDim() == Vy.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < Vx.getDim(); i++) {
            sum += Vx.vector[i] * Vy.vector[i];
        }
        return sum;
    }

    /**
     * Si la magnitud es mayor que un valor máximo, normalizar el vector y hacer
     * la multiplicación escalar por el máximo
     *
     * @param max
     */
    public void limit(Double max) {
        if (module() > max) {
            Uni();
            EMultVector(max);
        }
    }

    /**
     * Version estatica de limit
     *
     * @param Vx
     * @param max
     */
    static void limit(Vector Vx, Double max) {
        if (Vx.module() > max) {
            Vx.Uni();
            Vx.EMultVector(max);
        }
    }
}
