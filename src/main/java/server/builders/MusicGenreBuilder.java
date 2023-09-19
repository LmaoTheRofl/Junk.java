package server.builders;

import server.model.MusicGenre;

import java.util.Scanner;

import static server.utils.Parser.fromStringToMusicGenre;

/**
 * Метод
 */
public class MusicGenreBuilder {
    /**
     * Build music genre.
     *
     * @return the music genre
     */
    public static MusicGenre build() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите жанр музыки: (1 - PROGRESSIVE_ROCK, 2 - HIP_HOP, 3 - SOUL, DEFAULT - SOUL)");
        return fromStringToMusicGenre(sc.nextLine());
    }
}
