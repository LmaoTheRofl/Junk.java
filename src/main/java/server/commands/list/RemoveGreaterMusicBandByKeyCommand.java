package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;
import server.exceptions.ValidationException;

/**
 * The type Remove greater music band by key command.
 */
public class RemoveGreaterMusicBandByKeyCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Remove greater music band by key command.
     *
     * @param controller the controller
     */
    public RemoveGreaterMusicBandByKeyCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит один аргумент - id.");
        }
        try {
            long id = Long.parseLong(args[1]);
            if (id <= 0) {
                throw new ValidationException("Id больше нуля");
            }
            int before = controller.getAllMusicBand().size();
            controller.removeMusicBandByKey(id);
            int after = controller.getAllMusicBand().size();
            System.out.println("Было удалено " + (before - after) + " элементов.");

        } catch (NumberFormatException e) {
            System.out.println("Id представляет числовое значение. Попробуйте еще раз.");
        }
    }

    @Override
    public String description() {
        return "удалить из коллекции все элементы, ключ которых превышает заданный.";
    }
}
