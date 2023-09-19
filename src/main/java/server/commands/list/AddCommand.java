package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Add command.
 */
public class AddCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Add command.
     *
     * @param controller the controller
     */
    public AddCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        controller.addMusicBand(MusicBandBuilder.build());
        System.out.println("Успешно добавлен!");
    }

    @Override
    public String description() {
        return "добавить новый элемент в коллекцию.";
    }
}
