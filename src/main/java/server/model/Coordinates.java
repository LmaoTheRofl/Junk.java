package server.model;

import com.google.gson.annotations.Expose;

/**
 * The type Coordinates.
 */
public class Coordinates {
    @Expose(serialize = true)
    private long x;
    @Expose(serialize = true)
    private long y; //Максимальное значение поля: 655, Поле не может быть null

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x
     * @param y the y
     */
    public Coordinates(long x, long y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Instantiates a new Coordinates.
     */
    public Coordinates() {
    }

    /**
     * Gets x.
     *
     * @return the x
     */
    public long getX() {
        return x;
    }

    /**
     * Sets x.
     *
     * @param x the x
     */
    public void setX(long x) {
        this.x = x;
    }

    /**
     * Gets y.
     *
     * @return the y
     */
    public long getY() {
        return y;
    }

    /**
     * Sets y.
     *
     * @param y the y
     */
    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}