package server.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.JsonAdapter;
import server.services.GsonLocalDateTime;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;

/**
 * The type Music band.
 */
public class MusicBand implements Comparable<MusicBand> {
    @Expose(serialize = false)
    private long id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    @Expose(serialize = true)
    private String name; //Поле не может быть null, Строка не может быть пустой
    @Expose(serialize = true)
    private Coordinates coordinates; //Поле не может быть null
    @Expose(serialize = true)
    @JsonAdapter(GsonLocalDateTime.class)
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    @Expose(serialize = true)
    private long numberOfParticipants; //Значение поля должно быть больше 0
    @Expose(serialize = true)
    private java.util.Date establishmentDate; //Поле может быть null
    @Expose(serialize = true)
    private MusicGenre genre; //Поле не может быть null
    @Expose(serialize = true)
    private Person frontMan; //Поле может быть null

    /**
     * Instantiates a new Music band.
     *
     * @param id                   the id
     * @param name                 the name
     * @param coordinates          the coordinates
     * @param numberOfParticipants the number of participants
     * @param establishmentDate    the establishment date
     * @param genre                the genre
     * @param frontMan             the front man
     */
    public MusicBand(long id, String name, Coordinates coordinates, long numberOfParticipants,LocalDateTime creationDate, Date establishmentDate, MusicGenre genre, Person frontMan) {
        this.id = id;
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = creationDate;
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.frontMan = frontMan;
    }
    public MusicBand(){

    }
    /**
     * Instantiates a new Music band.
     *
     * @param name                 the name
     * @param coordinates          the coordinates
     * @param numberOfParticipants the number of participants
     * @param establishmentDate    the establishment date
     * @param genre                the genre
     * @param frontMan             the front man
     */
    /**
    public MusicBand(String name, Coordinates coordinates, long numberOfParticipants, Date establishmentDate, MusicGenre genre, Person frontMan) {
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDateTime.now();
        this.numberOfParticipants = numberOfParticipants;
        this.establishmentDate = establishmentDate;
        this.genre = genre;
        this.frontMan = frontMan;
    }
*/
    /**
     * Instantiates a new Music band.
     */
    /**
    public MusicBand() {
        this.creationDate = LocalDateTime.now();
    }
*/
    /**
     * Update music band.
     *
     * @param band the band
     * @return the music band
     */
    public MusicBand update(MusicBand band) {
        setName(band.getName());
        setCoordinates(band.getCoordinates());
        setNumberOfParticipants(band.getNumberOfParticipants());
        setEstablishmentDate(band.getEstablishmentDate());
        setGenre(band.getGenre());
        setFrontMan(band.getFrontMan());
        return this;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(long id) {
        this.id = id;
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
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    /**
     * Sets creation date.
     *
     * @param creationDate the creation date
     */
    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * Gets number of participants.
     *
     * @return the number of participants
     */
    public long getNumberOfParticipants() {
        return numberOfParticipants;
    }

    /**
     * Sets number of participants.
     *
     * @param numberOfParticipants the number of participants
     */
    public void setNumberOfParticipants(long numberOfParticipants) {
        this.numberOfParticipants = numberOfParticipants;
    }

    /**
     * Gets establishment date.
     *
     * @return the establishment date
     */
    public Date getEstablishmentDate() {
        return establishmentDate;
    }

    /**
     * Sets establishment date.
     *
     * @param establishmentDate the establishment date
     */
    public void setEstablishmentDate(Date establishmentDate) {
        this.establishmentDate = establishmentDate;
    }

    /**
     * Gets genre.
     *
     * @return the genre
     */
    public MusicGenre getGenre() {
        return genre;
    }

    /**
     * Sets genre.
     *
     * @param genre the genre
     */
    public void setGenre(MusicGenre genre) {
        this.genre = genre;
    }

    /**
     * Gets front man.
     *
     * @return the front man
     */
    public Person getFrontMan() {
        return frontMan;
    }

    /**
     * Sets front man.
     *
     * @param frontMan the front man
     */
    public void setFrontMan(Person frontMan) {
        this.frontMan = frontMan;
    }

    @Override
    public String toString() {
        return "MusicBand (id = " + id + "){"  + "\n" +
                "   name = " + name + "\n" +
                "   coordinates = " + coordinates + "\n" +
                "   creationDate = " + creationDate + "\n" +
                "   numberOfParticipants = " + numberOfParticipants + "\n" +
                "   establishmentDate = " + establishmentDate + "\n" +
                "   genre = " + genre + "\n" +
                "   frontMan = " + frontMan + "\n" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MusicBand musicBand = (MusicBand) o;

        if (id != musicBand.id) return false;
        if (numberOfParticipants != musicBand.numberOfParticipants) return false;
        if (!Objects.equals(name, musicBand.name)) return false;
        if (!Objects.equals(coordinates, musicBand.coordinates))
            return false;
        if (!Objects.equals(creationDate, musicBand.creationDate))
            return false;
        if (!Objects.equals(establishmentDate, musicBand.establishmentDate))
            return false;
        if (genre != musicBand.genre) return false;
        return Objects.equals(frontMan, musicBand.frontMan);
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (coordinates != null ? coordinates.hashCode() : 0);
        result = 31 * result + (creationDate != null ? creationDate.hashCode() : 0);
        result = 31 * result + (int) (numberOfParticipants ^ (numberOfParticipants >>> 32));
        result = 31 * result + (establishmentDate != null ? establishmentDate.hashCode() : 0);
        result = 31 * result + (genre != null ? genre.hashCode() : 0);
        result = 31 * result + (frontMan != null ? frontMan.hashCode() : 0);
        return result;
    }

    @Override
    public int compareTo(MusicBand o) {
        return (int) (numberOfParticipants - o.numberOfParticipants);
    }
}