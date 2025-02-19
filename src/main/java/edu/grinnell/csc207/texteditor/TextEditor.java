package edu.grinnell.csc207.texteditor;

import java.io.IOException;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TerminalPosition;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * The driver for the TextEditor Application.
 */
public class TextEditor {

    /**
     * Draws the updated word on the back buffer then moves it to the front
     *
     * @param buf the GapBuffer that has been edited
     * @param screen the Screen the test is edited in
     * @throws IOException throws the error produced by an invalid screen
     * refresh
     */
    public static void drawBuffer(GapBuffer buf, Screen screen) throws IOException {
        screen.clear();
        for (int i = 0; i < buf.getSize(); i++) {
            screen.setCharacter(i, 0, TextCharacter.fromCharacter(buf.getChar(i))[0]);
        }
        TerminalPosition pos = new TerminalPosition(buf.getCursorPosition(), 0);
        screen.setCursorPosition(pos);
        screen.refresh();
    }

    /**
     * Reads the key input and determines the appropriate action accordingly
     *
     * @param buf the GapBuffer that is edited by the key input
     * @param screen the screen that needs to be stopped if program is exited
     * @param file the file the program writes to when closed
     * @throws IOException throws the error produced by an invalid key stroke
     */
    public static void sort(GapBuffer buf, Screen screen, Path file) throws IOException {
        KeyStroke stroke = screen.readInput();
        KeyType type = stroke.getKeyType();
        if (type == KeyType.Character) {
            buf.insert(stroke.getCharacter());
        } else if (type == KeyType.ArrowLeft) {
            buf.moveLeft();
        } else if (type == KeyType.ArrowRight) {
            buf.moveRight();
        } else if (type == KeyType.Backspace) {
            buf.delete();
        } else if (type == KeyType.Escape) {
            Files.writeString(file, buf.toString());
            screen.stopScreen();
            System.exit(0);
        }
    }

    /**
     * Preps the necessary tools to write text and runs the text editor
     *
     * @param file the file the program reads from and writes to
     * @throws IOException throws the errors produced by several methods
     */
    public static void run(Path file) throws IOException {
        Screen screen = new DefaultTerminalFactory().createScreen();
        GapBuffer buf = new GapBuffer();
        if (Files.exists(file) || Files.isRegularFile(file)) {
            String fileGiven = Files.readString(file);
            for (int i = 0; i < fileGiven.length(); i++) {
                buf.insert(fileGiven.charAt(i));
            }
        }
        screen.startScreen();
        boolean isRunning = true;
        while (isRunning) {
            drawBuffer(buf, screen);
            sort(buf, screen, file);
        }
    }

    /**
     * The main entry point for the TextEditor application.
     *
     * @param args command-line arguments.
     * @throws IOException throws the error produced by invalid executions of
     * run
     */
    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            System.err.println("Usage: java TextEditor <filename>");
            System.exit(1);
        }
        String path = args[0];
        System.out.println(args[0]);
        Path file = Paths.get(path);
        System.out.format("Loading %s...\n", path);
        run(file);
    }
}
