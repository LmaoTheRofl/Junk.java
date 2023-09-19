package server.commands;

/**
 * Интерейс команд
 */
public interface Command {
    /**
     * Execute.
     *
     * @param args the args
     */
    void execute(String[] args);

    /**
     * Description string.
     *
     * @return the string
     */
    String description();
}
