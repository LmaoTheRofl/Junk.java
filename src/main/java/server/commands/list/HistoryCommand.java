package server.commands.list;

import server.commands.Command;
import server.exceptions.ArgumentException;
import server.services.HistoryManager;

/**
 * The type History command.
 */
public class HistoryCommand implements Command {
    private final HistoryManager history;

    /**
     * Instantiates a new History command.
     *
     * @param history the history
     */
    public HistoryCommand(HistoryManager history) {
        this.history = history;
    }

    @Override
    public void execute(String[] args) {
        if (args.length > 1) {
            throw new ArgumentException("Команда не требует аргументов.");
        }
        history.getHistoryListOfCommands().forEach(p -> System.out.print(p + ";"));
    }

    @Override
    public String description() {
        return "выводит последние " + history.getHistorySizeLimit() + " команд.";
    }
}
