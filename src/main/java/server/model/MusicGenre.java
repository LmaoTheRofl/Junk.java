package server.model;


/**
 * The enum Music genre.
 */
public enum MusicGenre {
    /**
     * Progressive rock music genre.
     */
    PROGRESSIVE_ROCK(3),
    /**
     * Hip hop music genre.
     */
    HIP_HOP(2),
    /**
     * Soul music genre.
     */
    SOUL(1);
    private int value;

    MusicGenre(int value) {
        this.value = value;
    }

    /**
     * Gets value.
     *
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets value.
     *
     * @param value the value
     */
    public void setValue(int value) {
        this.value = value;
    }
}