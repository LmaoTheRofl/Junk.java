package server.builders;

import server.model.MusicBand;

import java.time.LocalDateTime;
import java.util.Scanner;

import static server.utils.Parser.fromLocalDateTimeToDate;

/**
 * Метод создает и возвращает объект класса MusicBand
 */
public class MusicBandBuilder {
    /**
     * Build music band.
     *
     * @return the music band
     */
    public static MusicBand build() {
        MusicBand response = new MusicBand();
        response.setName(StringBuilder.build("Введите название группы:"));
        response.setCreationDate(LocalDateTime.now());
        response.setCoordinates(CoordinatesBuilder.build());
        response.setNumberOfParticipants(longBuild());
        response.setEstablishmentDate(fromLocalDateTimeToDate(LocalDateTimeBuilder.build()));
        response.setGenre(MusicGenreBuilder.build());
        response.setFrontMan(PersonBuilder.build());
        return response;
    }

    private static Long longBuild() {
        try {
            System.out.println("Введитен число numberOfParticipants: ");
            Scanner sc = new Scanner(System.in);
            long value = Long.parseLong(sc.nextLine());
            if (value <= 0) {
                System.out.println("Значение должно быть больше нуля.");
                return longBuild();
            }
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Это поле принимает числовое значение.");
            return longBuild();
        }
    }
}
