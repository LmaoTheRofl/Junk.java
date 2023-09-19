package server.builders;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * The type Local date time builder.
 */
public class LocalDateTimeBuilder {
    /**
     * Build local date time.
     *
     * @return the local date time
     */
    public static LocalDateTime build() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Введите дату в формате yyyy-MM-dd HH:mm:ss: ");
            String inputDate = scanner.nextLine();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            return LocalDateTime.parse(inputDate, formatter);
        } catch (DateTimeParseException e) {
            System.out.println("Вы ввели дату в неверном формате.");
            return build();
        }
    }
}

