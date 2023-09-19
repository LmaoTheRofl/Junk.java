package server.utils;

import server.model.Color;
import server.model.MusicGenre;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


/**
 * The type Parser.
 */
public class Parser {
    /**
     * Tilda resolver string.
     *
     * @param file the file
     * @return the string
     */
    public static String tildaResolver(String file) {
        if (file.startsWith("~")) {
            file = file.replaceFirst("^~", System.getProperty("user.home"));
        }
        return file;
    }

    /**
     * From local date time to date date.
     *
     * @param localDate the local date
     * @return the date
     */
    public static Date fromLocalDateTimeToDate(LocalDateTime localDate) {
        return Date.from(localDate.atZone(ZoneId.systemDefault()).toInstant());
    }

    /**
     * From string to color color.
     *
     * @param line the line
     * @return the color
     */
    public static Color fromStringToColor(String line) {
        switch (line.toUpperCase()) {
            case "1", "BLACK" -> {
                return Color.BLACK;
            }
            case "2", "BROWN" -> {
                return Color.BROWN;
            }
            case "3", "WHITE" -> {
                return Color.WHITE;
            }
            default -> {
                return Color.WHITE;
            }
        }
    }

    /**
     * From string to music genre music genre.
     *
     * @param line the line
     * @return the music genre
     */
    public static MusicGenre fromStringToMusicGenre(String line) {
        switch (line.toUpperCase()) {
            case "1", "PROGRESSIVE_ROCK" -> {
                return MusicGenre.PROGRESSIVE_ROCK;
            }
            case "2", "HIP_HOP" -> {
                return MusicGenre.HIP_HOP;
            }
            case "3", "SOUL" -> {
                return MusicGenre.SOUL;
            }
            default -> {
                return MusicGenre.SOUL;
            }
        }
    }
}
