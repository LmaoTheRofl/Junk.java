package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Save command.
 */
public class SaveCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Save command.
     *
     * @param controller the controller
     */
    public SaveCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.save();
        System.out.println("Успешно сохранено!");
    }

    @Override
    public String description() {
        return "сохранить коллекцию в файл";
    }
}
