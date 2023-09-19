package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Print field descending genre command.
 */
public class PrintFieldDescendingGenreCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Print field descending genre command.
     *
     * @param controller the controller
     */
    public PrintFieldDescendingGenreCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.printFielDescendingGenre().forEach(p -> System.out.print(p + ";"));
        System.out.println();
    }

    @Override
    public String description() {
        return "вывести значения поля genre всех элементов в порядке убывания";
    }
}
