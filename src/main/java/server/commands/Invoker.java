package server.commands;

import server.commands.list.*;
import server.controller.MusicController;
import server.controller.MusicControllerImpl;
import server.exceptions.ArgumentException;
import server.exceptions.FileException;
import server.exceptions.ValidationException;
import server.services.HistoryManager;
import server.services.ScriptManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static server.utils.Parser.tildaResolver;

/**
 * The type Invoker.
 */
public class Invoker {
    private static Map<String, Command> commandMap = new HashMap<>();
    private final HistoryManager history;
    private final MusicController controller;
    private final ScriptManager scriptManager;
    private final String fileName;
    private BufferedReader reader;

    /**
     * Instantiates a new Invoker.
     *
     * @param filename the filename
     */
    public Invoker(String filename) {
        this.fileName = tildaResolver(filename);
        this.history = new HistoryManager(15); // limit history size
        controller = new MusicControllerImpl(fileName);
        scriptManager = new ScriptManager(null);
        init();
    }

    /**
     * Gets command map.
     *
     * @return the command map
     */
    public static Map<String, Command> getCommandMap() {
        return commandMap;
    }

    /**
     * Sets command map.
     *
     * @param commandMap the command map
     */
    public static void setCommandMap(Map<String, Command> commandMap) {
        Invoker.commandMap = commandMap;
    }

    /**
     * Init.
     */
    public void init() {
        addCommandToMap("help", new HelpCommand());
        addCommandToMap("exit", new ExitCommand());
        addCommandToMap("info", new InfoCommand(controller));
        addCommandToMap("clear", new ClearCommand(controller));
        addCommandToMap("show", new ShowCommand(controller));
        addCommandToMap("add", new AddCommand(controller));
        addCommandToMap("update", new UpdateCommand(controller));
        addCommandToMap("remove_by_id", new RemoveByIdCommand(controller));
        addCommandToMap("save", new SaveCommand(controller));
        addCommandToMap("execute_script", new ExecuteScriptCommand(this, scriptManager));
        addCommandToMap("history", new HistoryCommand(history));
        addCommandToMap("remove_greater", new RemoveGreaterMusicBandByObjectCommand(controller));
        addCommandToMap("filter_less_than_genre", new FilterLessThanGenreCommand(controller));
        addCommandToMap("print_unique_establishment_date", new PrintUniqueEstablishmentDateCommand(controller));
        addCommandToMap("print_field_descending_genre", new PrintFieldDescendingGenreCommand(controller));
    }

    /**
     * Execute.
     *
     * @param input the input
     */
    public void execute(String input) {
        try {
            input = input.trim();
            String[] commandArray = input.split(" ");
            String command = commandArray[0];
            for (Map.Entry<String, Command> pair : Invoker.getCommandMap().entrySet()) {
                if (pair.getKey().equals(command)) {
                    pair.getValue().execute(commandArray);
                    history.addCommandToHistory(command);
                }
            }
            if (!Invoker.getCommandMap().containsKey(command)) {
                System.out.println("Команда не найдена.");
            }
        } catch (ArgumentException | ValidationException | FileException e) {
            System.out.println(e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Нет аргумента.");
        } catch (NoSuchElementException e) {
            System.out.println("Завешение программы...");
            System.exit(1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Gets reader.
     *
     * @return the reader
     */
    public BufferedReader getReader() {
        return reader;
    }

    /**
     * Sets reader.
     *
     * @param reader the reader
     */
    public void setReader(BufferedReader reader) {
        this.reader = reader;
    }

    /**
     * Add command to map.
     *
     * @param commandName the command name
     * @param command     the command
     */
    public void addCommandToMap(String commandName, Command command) {
        commandMap.put(commandName, command);
    }
}