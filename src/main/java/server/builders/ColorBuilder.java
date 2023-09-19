package server.builders;

import server.model.Color;

import java.util.Scanner;

import static server.utils.Parser.fromStringToColor;

/**
 * The type Color builder.
 */
public class ColorBuilder {
    /**
     * Build color.
     *
     * @return the color
     */
    public static Color build() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите цвет: (1 - BLACK, 2 - BROWN, 3 - WHITE, DEFAULT - WHITE)");
        return fromStringToColor(sc.nextLine());
    }
}
