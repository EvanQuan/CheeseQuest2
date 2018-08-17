package test;

import game.system.input.PlayerCommand;
import game.system.input.PlayerInputParser;
import game.system.output.IPrintBuffer;
import org.junit.Test;

import java.util.Scanner;

import static org.junit.Assert.assertTrue;

/**
 * Checks that JUnit 4 is working
 *
 * @author Evan Quan
 */
public class TestTest {

    @Test
    public void testPass() {
        assertTrue(true);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input;
        PlayerCommand command;
        do {
            System.out.print(IPrintBuffer.INPUT_MARKER);
            input = in.nextLine();
            command = PlayerInputParser.parse(input);

            System.out.println(command);
        } while (!input.isEmpty());
    }
}
