package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Print unique establishment date command.
 */
public class PrintUniqueEstablishmentDateCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Print unique establishment date command.
     *
     * @param controller the controller
     */
    public PrintUniqueEstablishmentDateCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.printUniqueEstablishmentDate().forEach(p -> System.out.print(p + ";"));
        System.out.println();
    }

    @Override
    public String description() {
        return "вывести уникальные значения поля establishmentDate всех элементов в коллекции.";
    }
}
