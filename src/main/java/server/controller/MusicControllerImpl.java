package server.controller;

import server.dao.MusicDAO;
import server.dao.MusicDAOImpl;
import server.model.MusicBand;
import server.model.MusicGenre;

import java.util.Date;
import java.util.List;

/**
 * The type Music controller.
 */
public class MusicControllerImpl implements MusicController {
    private MusicDAO musicDAO;

    /**
     * Instantiates a new Music controller.
     *
     * @param fileName the file name
     */
    public MusicControllerImpl(String fileName) {
        this.musicDAO = new MusicDAOImpl(fileName);
    }

    @Override
    public String info() {
        return musicDAO.info();
    }

    @Override
    public MusicBand getMusicBandById(long id) {
        return musicDAO.getMusicBandById(id);
    }

    @Override
    public List<MusicBand> getAllMusicBand() {
        return musicDAO.getAllMusicBand();
    }

    @Override
    public Long addMusicBand(MusicBand band) {
        return musicDAO.addMusicBand(band);
    }

    @Override
    public MusicBand updateMusicBand(MusicBand band, long id) {
        return musicDAO.updateMusicBand(band, id);
    }

    @Override
    public void removeMusicBandByKey(long id) {
        musicDAO.removeMusicBandByKey(id);
    }

    @Override
    public void clear() {
        musicDAO.clear();
    }

    @Override
    public void save() {
        musicDAO.save();
    }

    @Override
    public void removeGreaterMusicBandByObject(MusicBand band) {
        musicDAO.removeGreaterMusicBandByObject(band);
    }

    @Override
    public void removeGreaterMusicBandByKey(long id) {
        musicDAO.removeGreaterMusicBandByKey(id);
    }

    @Override
    public List<MusicBand> filterLessThanGenre(MusicGenre genre) {
        return musicDAO.filterLessThanGenre(genre);
    }

    @Override
    public List<Date> printUniqueEstablishmentDate() {
        return musicDAO.printUniqueEstablishmentDate();
    }

    @Override
    public List<MusicGenre> printFielDescendingGenre() {
        return musicDAO.printFielDescendingGenre();
    }


    /**
     * Gets music band dao.
     *
     * @return the music band dao
     */
    public MusicDAO getMusicBandDAO() {
        return musicDAO;
    }

    /**
     * Sets music band dao.
     *
     * @param musicDAO the music dao
     */
    public void setMusicBandDAO(MusicDAO musicDAO) {
        this.musicDAO = musicDAO;
    }
}
