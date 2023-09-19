package server.commands.list;

import server.builders.MusicBandBuilder;
import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;

/**
 * The type Remove greater music band by object command.
 */
public class RemoveGreaterMusicBandByObjectCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Remove greater music band by object command.
     *
     * @param controller the controller
     */
    public RemoveGreaterMusicBandByObjectCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 1) {
            throw new ArgumentException("Команда не должна содержать аргументов.");
        }
        int before = controller.getAllMusicBand().size();
        controller.removeGreaterMusicBandByObject(MusicBandBuilder.build());
        int after = controller.getAllMusicBand().size();
        System.out.println("Было удалено " + (before - after) + " элементов.");
    }

    @Override
    public String description() {
        return "удалить из коллекции все элементы, превышающие заданный.";
    }
}
