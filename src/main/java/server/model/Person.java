package server.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import server.services.GsonLocalDateTime;

import java.time.LocalDateTime;

/**
 * The type Person.
 */
public class Person {
    @Expose(serialize = true)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Expose(serialize = true)
    @JsonAdapter(GsonLocalDateTime.class)
    private java.time.LocalDateTime birthday; //Поле может быть null
    @Expose(serialize = true)
    private int height; //Значение поля должно быть больше 0
    @Expose(serialize = true)
    private String passportID; //Поле может быть null
    @Expose(serialize = true)
    private Color hairColor; //Поле может быть null

    /**
     * Instantiates a new Person.
     *
     * @param name       the name
     * @param birthday   the birthday
     * @param height     the height
     * @param passportID the passport id
     * @param hairColor  the hair color
     */
    public Person(String name, LocalDateTime birthday, int height, String passportID, Color hairColor) {
        this.name = name;
        this.birthday = birthday;
        this.height = height;
        this.passportID = passportID;
        this.hairColor = hairColor;
    }

    /**
     * Instantiates a new Person.
     */
    public Person() {
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets birthday.
     *
     * @return the birthday
     */
    public LocalDateTime getBirthday() {
        return birthday;
    }

    /**
     * Sets birthday.
     *
     * @param birthday the birthday
     */
    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
    }

    /**
     * Gets passport id.
     *
     * @return the passport id
     */
    public String getPassportID() {
        return passportID;
    }

    /**
     * Sets passport id.
     *
     * @param passportID the passport id
     */
    public void setPassportID(String passportID) {
        this.passportID = passportID;
    }

    /**
     * Gets hair color.
     *
     * @return the hair color
     */
    public Color getHairColor() {
        return hairColor;
    }

    /**
     * Sets hair color.
     *
     * @param hairColor the hair color
     */
    public void setHairColor(Color hairColor) {
        this.hairColor = hairColor;
    }

    @Override
    public String toString() {
        return "Person{\n" +
                "       name = " + name + '\n' +
                "       birthday = " + birthday + "\n" +
                "       height = " + height + "\n" +
                "       passportID = '" + passportID + "\n" +
                "       hairColor = " + hairColor + "\n" +
                "   }";
    }
}