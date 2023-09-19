package server.dao;

import server.database.DataBaseProvider;
import server.model.MusicBand;
import server.model.MusicGenre;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * The type Music dao.
 */
public class MusicDAOImpl implements MusicDAO {
    private final DataBaseProvider source;

    /**
     * Instantiates a new Music dao.
     *
     * @param fileName the file name
     */
    public MusicDAOImpl(String fileName) {
        this.source = new DataBaseProvider(fileName);
    }

    @Override
    public String info() {
        String answer = ("Данные о базе данных: \n");
        answer += "Тип: " + source.getDataBase().getClass().getTypeName().split("\\.")[2] + "\n";
        answer += "Время создания: " + source.getDateTime().toString() + "\n";
        answer += "Элементов внутри: " + (source.getDataBase().size()) + "\n";
        return answer;
    }

    @Override
    public MusicBand getMusicBandById(long id) {
        return source.getDataBase().get(id);
    }

    @Override
    public List<MusicBand> getAllMusicBand() {
        return source.getList();
    }

    @Override
    public Long addMusicBand(MusicBand band) {
        return source.addMusicBandToDatabase(band);
    }

    @Override
    public MusicBand updateMusicBand(MusicBand band, long id) {
        return source.getDataBase().get(id).update(band);
    }

    @Override
    public void removeMusicBandByKey(long id) {
        source.getDataBase().remove(id);
    }

    @Override
    public void clear() {
        source.getDataBase().clear();
    }

    @Override
    public void save() {
        source.save();
    }

    @Override
    public void removeGreaterMusicBandByObject(MusicBand band) {
        source.getDataBase().values().removeIf(value -> value.getNumberOfParticipants() > band.getNumberOfParticipants());
    }

    @Override
    public void removeGreaterMusicBandByKey(long id) {
        source.getDataBase().values().removeIf(value -> value.getId() > id);
    }

    @Override
    public List<MusicBand> filterLessThanGenre(MusicGenre genre) {
        return source.getList().stream().filter(p -> p.getGenre().getValue() < genre.getValue()).toList();
    }

    @Override
    public List<Date> printUniqueEstablishmentDate() {
        List<Date> response = new ArrayList<>();
        for (MusicBand band : source.getList()) {
            if (!response.contains(band.getEstablishmentDate())) {
                response.add(band.getEstablishmentDate());
            }
        }
        return response;
    }

    @Override
    public List<MusicGenre> printFielDescendingGenre() {
        List<MusicGenre> list = new ArrayList<>(source.getList().stream().map(MusicBand::getGenre).toList());
        list.sort(Comparator.comparingInt(MusicGenre::getValue));
        return list;
    }
}
