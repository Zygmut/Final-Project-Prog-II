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
     * Devuelve el modulo del vector pasado por parametro
     *
     * @param y
     * @return
     */
    public static Double mod(Vector y) {
        Double sum = 0.00;
        for (int i = 0; i < y.getDim(); i++) {
            sum += y.getValue(i) * y.getValue(i);
        }
        return Math.sqrt(sum);
    }

    /**
     * Asigna el valor val a la posicion pos
     *
     * @param pos
     * @param val
     */
    public void setValue(Integer pos, Double val) {
        this.x[pos] = val;
    }

    /**
     * Permite conocer el valor de un vector sabiendo su posicion
     *
     * @param pos
     * @return Valor
     */
    public Double getValue(Integer pos) {
        return x[pos];
    }

    /**
     * Permite sumar dos vectores
     *
     * @param y
     * @return z
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public Vector AddVector(Vector y) throws DiferentDimensionException {
        Vector z;
        if (!(this.x.length == y.getDim())) {
            throw new DiferentDimensionException();
        }
        z = new Vector(x.length);
        for (int i = 0; i < x.length; i++) {
            z.setValue(i, (x[i] + y.getValue(i)));
        }
        return z;
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
            z.setValue(i, (x.getValue(i) + y.getValue(i)));
        }
        return z;
    }

    /**
     * Permite restar dos vectores
     *
     * @param y
     * @return z
     * @throws finalproject.UserExceptions.DiferentDimensionException
     */
    public Vector SubVector(Vector y) throws DiferentDimensionException {
        Vector z;
        if (!(this.x.length == y.getDim())) {
            throw new DiferentDimensionException();
        }
        z = new Vector(x.length);
        for (int i = 0; i < x.length; i++) {
            z.setValue(i, (x[i] - y.getValue(i)));
        }
        return z;
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
            z.setValue(i, (x.getValue(i) - y.getValue(i)));
        }
        return z;
    }

    /**
     * Permite multiplicar un vector por un valor
     *
     * @param y
     * @return z
     */
    public Vector EMultVector(Double y) {
        Vector z = new Vector(x.length);
        for (int i = 0; i < x.length; i++) {
            z.setValue(i, (y * x[i]));
        }
        return z;
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
            z.setValue(i, (y * x.getValue(i)));
        }
        return z;
    }

    /**
     * Permite dividir un vector por un valor
     *
     * @param y
     * @return z
     */
    public Vector EDivVector(Double y) {
        Vector z = new Vector(x.length);
        for (int i = 0; i < x.length; i++) {
            z.setValue(i, (y / x[i]));
        }
        return z;
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
            z.setValue(i, (y / x.getValue(i)));
        }
        return z;
    }

    /**
     * Permite saber el vector unitario
     *
     * @return z
     */
    public Vector Uni() {
        Vector z = new Vector(x.length);
        Double mod = mod();
        for (int i = 0; i < 10; i++) {
            z.setValue(i, (x[i] / mod));
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
        Double mod = Vector.mod(y);
        for (int i = 0; i < 10; i++) {
            z.setValue(i, (y.getValue(i) / mod));
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
        if (!(x.length == y.getDim())) {
            throw new DiferentDimensionException();
        }
        for (int i = 0; i < x.length; i++) {
            sum += x[i] * y.getValue(i);
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
            sum += x.getValue(i) * y.getValue(i);
        }
        return sum;
    }

    /**
     * Devuevle la componente x de un vector
     *
     * @return x
     */
    public Double getX() {
        return x[0];
    }

    /**
     * Devuevle la componente y del vector
     *
     * @return y
     */
    public Double getY() {
        return x[1];
    }

    /**
     * Devuelve la componente z del vector
     *
     * @return z
     * @throws finalproject.UserExceptions.SingleDiferentDimensionException
     */
    public Double getZ() throws SingleDiferentDimensionException {
        if (!(x.length == 3)) {
            throw new SingleDiferentDimensionException();
        }
        return x[2];
    }

    /**
     * Devuevle la componente x de un vector pasado por parametro
     *
     * @param x
     * @return x
     */
    public Double getX(Vector x) {
        return x.getValue(0);
    }

    /**
     * Devuevle la componente y del vector pasado por parametro
     *
     * @param x
     * @return y
     */
    public static Double getY(Vector x) {
        return x.getValue(1);
    }

    /**
     * Devuelve la componente z del vector pasado por parametro,
     *
     * @param x
     * @return z
     * @throws finalproject.UserExceptions.SingleDiferentDimensionException
     */
    public static Double getZ(Vector x) throws SingleDiferentDimensionException {
        if (!(x.getDim() == 3)) {
            throw new SingleDiferentDimensionException();
        }
        return x.getValue(2);
    }
}
