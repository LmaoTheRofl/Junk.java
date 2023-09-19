package client;

import server.commands.Invoker;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Objects;

/**
 * The type Console ui.
 */
public class ConsoleUI {
    private final Invoker invoker;

    /**
     * Instantiates a new Console ui.
     *
     * @param invoker the invoker
     */
    public ConsoleUI(Invoker invoker) {
        this.invoker = invoker;
    }

    /**
     * Start.
     */
    public void start() {
        String command;
        BufferedReader reader = invoker.getReader();

        try (reader) {
            System.out.println("Напишите help чтобы увидеть все команды.");
            while (!Objects.equals(command = reader.readLine(), "exit") && !Objects.equals(command, null)) {
                invoker.execute(command);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
