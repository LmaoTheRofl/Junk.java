package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;
import server.exceptions.ValidationException;
import server.model.MusicBand;

/**
 * The type Update command.
 */
public class UpdateCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Update command.
     *
     * @param controller the controller
     */
    public UpdateCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - id.");
        }
        long id;
        try {
            id = Integer.parseInt(args[1]);
            if (id <= 0) {
                throw new ValidationException("Id больше нуля");
            }
            if (controller.getAllMusicBand().stream().map(MusicBand::getId).toList().contains(id)) {
                controller.updateMusicBand(MusicBandBuilder.build(), id);
                System.out.println("MusicBand обновлен.");
            } else {
                System.out.println("MusicBand с таким id не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Id принимает целочисленное значение.");
        }
    }

    @Override
    public String description() {
        return "обновить существующий объект по id.";
    }
}
