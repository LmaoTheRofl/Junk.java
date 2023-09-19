package server.database;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import server.model.MusicBand;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

import static server.validation.Validation.*;

/**
 * The type Data base provider.
 */
public class DataBaseProvider {
    private final Map<Long, MusicBand> dataBase;
    private final LocalDateTime dateTime;
    private final String fileName;

    /**
     * Instantiates a new Data base provider.
     *
     * @param filename the filename
     */
    public DataBaseProvider(String filename) {
        validateFile(filename);
        this.fileName = filename;
        this.dataBase = loadDataBase(filename);
        this.dateTime = LocalDateTime.now();
    }

    private static List<MusicBand> validatedList(List<MusicBand> data) {
        try {
            List<MusicBand> copy = new ArrayList<>(data);
            for (MusicBand musicBand : copy) {
                if (!validateMusicBand(musicBand)) {
                    data.remove(musicBand);
                }
            }
            return data;
        } catch (NullPointerException e) {
            return new ArrayList<>();
        }
    }

    private  Map<Long, MusicBand> loadDataBase(String fileName) {
        Map<Long, MusicBand> resultMap = new HashMap<>();
        InputStreamReader inputStreamReader = null;
        try {
            inputStreamReader = new InputStreamReader(new FileInputStream(fileName));
            String json = new BufferedReader(inputStreamReader).lines().collect(Collectors.joining());
            Gson gson = new Gson();
            MusicBand[] bands = gson.fromJson(json, MusicBand[].class);
             // System.out.println(Arrays.toString(bands));

            for (MusicBand band : bands) {
              //  band.setId(generateNextId());
                band.setCreationDate(LocalDateTime.now());
                resultMap.put(band.getId(), band);
            }
            for (Map.Entry<Long, MusicBand> entry : resultMap.entrySet()) {
              System.out.println(entry.getKey() + " : " + entry.getValue());}

            return resultMap;
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return resultMap;
    }


    /**
     * Save.
     */
    public void save() {
        validateFile(fileName);
        try (Writer writer = new FileWriter(fileName)) {
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
            gson.toJson(dataBase.values(), writer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private long generateNextId() {
        long id = dataBase.values().stream()
                .map(MusicBand::getId)
                .max(Comparator.comparing(Long::longValue))
                .orElse(0L);
        return ++id;
    }

    /**
     * Add music band to database long.
     *
     * @param model the model
     * @return the long
     */
    public Long addMusicBandToDatabase(MusicBand model) {
        Long id = generateNextId();
        model.setId(id);
        dataBase.put(id, model);
        return id;
    }

    /**
     * Remove music band from data base boolean.
     *
     * @param id the id
     * @return the boolean
     */
    public boolean removeMusicBandFromDataBase(Long id) {
        dataBase.remove(id);
        return true;
    }


    /**
     * Gets data base.
     *
     * @return the data base
     */
    public Map<Long, MusicBand> getDataBase() {
        return dataBase;
    }

    /**
     * Gets list.
     *
     * @return the list
     */
    public List<MusicBand> getList() {
        return new ArrayList<>(dataBase.values());
    }

    /**
     * Gets date time.
     *
     * @return the date time
     */
    public LocalDateTime getDateTime() {
        return dateTime;
    }
}
