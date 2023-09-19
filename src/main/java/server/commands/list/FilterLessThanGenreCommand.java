package server.commands.list;

import server.commands.Command;
import server.controller.MusicController;
import server.exceptions.ArgumentException;
import server.model.MusicGenre;

import static server.utils.Parser.fromStringToMusicGenre;

/**
 * The type Filter less than genre command.
 */
public class FilterLessThanGenreCommand implements Command {
    private final MusicController controller;

    /**
     * Instantiates a new Filter less than genre command.
     *
     * @param controller the controller
     */
    public FilterLessThanGenreCommand(MusicController controller) {
        this.controller = controller;
    }

    @Override
    public void execute(String[] args) {
        if (args.length != 2) {
            throw new ArgumentException("Команда содержит 1 аргумент - genre.");
        }
        MusicGenre genre = fromStringToMusicGenre(args[1]);
        System.out.println(controller.filterLessThanGenre(genre));
    }

    @Override
    public String description() {
        return "вывести элементы, значение поля genre которых меньше заданного.";
    }
}
