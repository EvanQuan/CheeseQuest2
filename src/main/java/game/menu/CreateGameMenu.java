package game.menu;

import game.system.save.InvalidSaveNameException;
import game.system.save.Save;
import game.system.save.SaveManager;

/**
 * Gets user receiveInput for creating game save name
 */
public class CreateGameMenu extends Menu {

    private static CreateGameMenu instance;
    private SaveManager saver;
    private String gameName;

    private CreateGameMenu() {
        saver = SaveManager.getInstance();
    }

    public static CreateGameMenu getInstance() {
        if (instance == null) {
            instance = new CreateGameMenu();
        }
        return instance;
    }

    public void printMainPrompt() {
//        println("Enter the name of your new game.");
    }

    /**
     * Prints a message signifying that the user can inputted invalid input.
     */
    @Override
    protected void printInvalidInput() {

    }

    @Override
    public void processInput() {
//        String name = getInputString();
//        print("Game \"");
//        printItem(toTitleCase(name));
//        print("\" ");
//        if (LoadMenu.getInstance().getSaveNames().contains(toTitleCase(name))) { // Does not create a new game
//            println("already exists.");
//        } else {
//            boolean created = createGame(name);
//            if (created) {
//                println(" has been created.");
//            }
//        }
        changeToPreviousMenu();
    }

    /**
     * Create new game
     *
     * @param gameName of the world to create
     */
    public boolean createGame(String gameName) {
        try {
            Save save = new Save(gameName); // New default world
            saver.setCurrentSave(gameName);
            saver.save(save);
            return true;
        } catch (InvalidSaveNameException e) {
            outputInvalidSaveName();
            return false;
        } catch (Exception e) { // Just in case
            e.printStackTrace();
            return false;
        }
        // GameMenu gameMenu = GameMenu.getInstance();
        // gameMenu.setWorld(world);
    }

    /**
     * NOTE: Assumes SaveManager.INVALID_CHARACTERS is not empty
     */
    public void outputInvalidSaveName() {
//        print(" cannot contain the special characters ");
//        for (int i = 0; i < SaveManager.INVALID_CHARACTERS.length - 1; i++) {
//            printPlayer(SaveManager.INVALID_CHARACTERS[i]);
//            print(", ");
//        }
//        if (SaveManager.INVALID_CHARACTERS.length > 1) {
//            print("or ");
//        }
//        printPlayer(SaveManager.INVALID_CHARACTERS[SaveManager.INVALID_CHARACTERS.length - 1]);
//        println(".");
    }

    @Override
    public void initializeCommands() {
        // TODO
    }

    /**
     * Input has already been validated. Do stuff before processing valid
     * input.
     */
    @Override
    protected void preProcessInput() {

    }

    /**
     * Retrieves information about the playerCommand after it has been process.
     * This may influence how future commands are processed. This is only ran if
     * isValidInput() is successful.
     */
    @Override
    protected void postProcessInput() {

    }

}
