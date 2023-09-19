package server.builders;

import server.exceptions.ValidationException;
import server.model.Coordinates;

import java.util.Scanner;

/**
 * The type Coordinates builder.
 */
public class CoordinatesBuilder {
    /**
     * Build coordinates.
     *
     * @return the coordinates
     */
    public static Coordinates build() {
        long x;
        long y;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите координату x");
            x = Long.parseLong(sc.nextLine());
            System.out.println("Введите координату y");
            y = Long.parseLong(sc.nextLine());
            if (y >= 655) {
                throw new ValidationException("Значение y должно быть меньше 655");
            }
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            return build();
        } catch (NumberFormatException e) {
            System.out.println(("Координаты принимают числовые значения"));
            return build();
        }
        return new Coordinates(x, y);
    }
}
