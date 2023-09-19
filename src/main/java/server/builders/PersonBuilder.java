package server.builders;

import server.model.Person;

import java.util.Scanner;

/**
 * Метод создает и возвращает объект класса person
 */
public class PersonBuilder {
    /**
     * Build person.
     *
     * @return the person
     */
    public static Person build() {
        Person person = new Person();
        try {
            person.setName(StringBuilder.build("Введите имя фронтмена:"));
            person.setBirthday(LocalDateTimeBuilder.build());
            person.setHeight(buildHeigh());
            person.setPassportID(buildPassportId());
            person.setHairColor(ColorBuilder.build());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return person;
    }

    private static int buildHeigh() {
        try {
            System.out.println("Введите рост фронтмена:");
            Scanner sc = new Scanner(System.in);
            int height = Integer.parseInt(sc.nextLine());
            if (height <= 0) {
                System.out.println("Рост не может быть меньше 0.");
                return buildHeigh();
            }
            return height;
        } catch (NumberFormatException e) {
            System.out.println("Рост должен иметь целочисленное значение.");
            return buildHeigh();
        }
    }

    private static String buildPassportId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите PassportID: (если его нет, то введите пустую строку или null)");
        String passportId = sc.nextLine();
        if (passportId.trim().equals("") || passportId == null) {
            return null;
        }
        return passportId;
    }
}
