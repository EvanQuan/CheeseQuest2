package game.menu;

import game.system.*;
import game.object.room.*;
import game.object.item.collectable.Collectable;

/**
 * Manages all in game actions
 */
public class GameMenu extends Menu {

    private static GameMenu instance;
    private Room room;
    private Player player;
    private int turnCount;

    private GameMenu() {
    }

    @Override
    public void outputPrompt() {
        outputLook();
    }
    public static GameMenu getInstance() {
        if (instance == null) {
            instance  = new GameMenu();
        }
        return instance;
    }
    public void setWorld(World world) {
        room = world.getRoom();
        player = world.getPlayer();
        turnCount = world.getTurnCount();
    }
    public World getWorld() {
        World world = new World(room,player,turnCount);
        return world;
    }
    public void quit() {
        changeToLoadMenu();
    }

    /**
     * Look at room surroundings
     * People present
     * Items
     * Adjacent rooms
     */
    public void outputLook() {
        room.outputDescription();
        // outputItems();

    }

    /**
     * Output information about all items present in room
     */
    // public void outputItems() {
    //     Inventory<Collectable> inv = room.getInventory();
    //     if (!inv.isEmpty()) {
    //         output("There is ");
    //         for (Collectable item : inv.getItemSet()) {
    //             int count = inv.getCount(item);
    //             if (count == 1) {
    //
    //             }
    //             if (startsWithVowel(item.getSingleName())) {
    //
    //             }
    //         }
    //     }
    // }
    public boolean startsWithVowel(String string) {
        switch(Character.toLowerCase(string.charAt(0))) {
            case 'a':
            case 'e':
            case 'i':
            case 'o':
            case 'u':
                return true;
                break;
            default:
                return false;
        }
    }
    // The Northmen say the world will come to an end. The sun will grow black. The earth will sink into the sea. The stars will disappear. Fire and water will meet. Flames will play against the sky. The heavens and earth and all the world will be burned. All the gods will be dead, and the warriors of Valhalla, and people everywhere. Senua, prepare yourself for Ragnarok, for it is nigh.
    // The Northmen say the world will come to an end. The sun will grow black. The earth will sink into the sea. The stars will disappear. Fire and water will meet. Flames will play against the sky. The heavens and earth and all the world will be burned. All the gods will be dead, the warriors of Valhalla, and people everywhere. Prepare yourself for Ragnarok, for it is nigh.
}
