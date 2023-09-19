package server.controller;

import server.model.MusicBand;
import server.model.MusicGenre;

import java.util.Date;
import java.util.List;

/**
 * The interface Music controller.
 */
public interface MusicController {
    /**
     * Info string.
     *
     * @return the string
     */
    String info();

    /**
     * Gets music band by id.
     *
     * @param id the id
     * @return the music band by id
     */
    MusicBand getMusicBandById(long id);

    /**
     * Gets all music band.
     *
     * @return the all music band
     */
    List<MusicBand> getAllMusicBand();

    /**
     * Add music band long.
     *
     * @param band the band
     * @return the long
     */
    Long addMusicBand(MusicBand band);

    /**
     * Update music band music band.
     *
     * @param band the band
     * @param id   the id
     * @return the music band
     */
    MusicBand updateMusicBand(MusicBand band, long id);

    /**
     * Remove music band by key.
     *
     * @param id the id
     */
    void removeMusicBandByKey(long id);

    /**
     * Clear.
     */
    void clear();

    /**
     * Save.
     */
    void save();

    /**
     * Remove greater music band by object.
     *
     * @param band the band
     */
    void removeGreaterMusicBandByObject(MusicBand band);

    /**
     * Remove greater music band by key.
     *
     * @param id the id
     */
    void removeGreaterMusicBandByKey(long id);

    /**
     * Filter less than genre list.
     *
     * @param genre the genre
     * @return the list
     */
    List<MusicBand> filterLessThanGenre(MusicGenre genre);

    /**
     * Print unique establishment date list.
     *
     * @return the list
     */
    List<Date> printUniqueEstablishmentDate();

    /**
     * Print fiel descending genre list.
     *
     * @return the list
     */
    List<MusicGenre> printFielDescendingGenre();
}
