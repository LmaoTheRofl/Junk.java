import client.ConsoleUI;
import server.commands.Invoker;
import server.exceptions.FileException;

import java.io.BufferedReader;

/**
 * The type App.
 */
public class App {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            String args0 = "database.json";
Invoker procast = new Invoker(args0);

            ConsoleUI session = new ConsoleUI(procast);
            session.start();
        } catch (FileException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Необходимо ввести название файла базы данных при запуске программы.");
        }
    }
}
