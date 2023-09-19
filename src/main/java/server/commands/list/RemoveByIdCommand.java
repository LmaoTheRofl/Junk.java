package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;
import server.exceptions.ValidationException;
import server.model.MusicBand;

/**
 * The type Remove by id command.
 */
public class RemoveByIdCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Remove by id command.
     *
     * @param controller the controller
     */
    public RemoveByIdCommand(MusicController controller) {
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
                controller.removeMusicBandByKey(id);
                System.out.println("MusicBand удален.");
            } else {
                System.out.println("MusicBand с таким id не найден.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Id принимает целочисленное значение.");
        }
    }

    @Override
    public String description() {
        return "удаляет элемент по id.";
    }
}
