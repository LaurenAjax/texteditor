package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

import java.util.Random;

public class SimpleStringBufferTests {
    SimpleStringBuffer buffer = new SimpleStringBuffer();     /* the buffer used throughout the tests */
    
    /**
     * Asserts that the initial buffer is indeed empty
     * 
     */
    @Test
    public void testEmpty() {
        assertEquals("", buffer.toString());
        assertEquals(0, buffer.getCursorPosition());
        assertEquals(0, buffer.getSize());
    }
    
    /**
     * Writes in the buffer for easy access to something to edit
     * 
     */
    public void addTypeWord() {
        buffer.insert('M');
        buffer.insert('y');
        buffer.insert(' ');
        buffer.insert('N');
        buffer.insert('a');
        buffer.insert('m');
        buffer.insert('e');
        buffer.insert(' ');
        buffer.insert('I');
        buffer.insert('s');
    }
    
    /**
     * Moves the cursor left the specified number of times
     * 
     * @param n the number of times the cursor is moved left
     */
    public void multiMoveLeft(int n) {
        for (int i = 0; i < n; i++) {
            buffer.moveLeft();
        }
    }
    
    /**
     * Moves the cursor right the specified number of times
     * 
     * @param n the number of times the cursor is moved right
     */
    public void multiMoveRight(int n) {
        for (int i = 0; i < n; i++) {
            buffer.moveRight();
        }
    }
    
    /**
     * Deletes the specified number of characters
     * 
     * @param n the number of characters deleted
     */
    public void multiDelete(int n) {
        for (int i = 0; i < n; i++) {
            buffer.delete();
        }
    }
    
    /**
     * Tests that a string is successfully written by the buffer
     * 
     */
    @Test
    public void testTypeWord() {
        addTypeWord();
        assertEquals("My Name Is", buffer.toString());
    }
    
    /**
     * Tests that moveRight and moveLeft move the cursor accurately and without
     * exceeding their bounds
     * 
     */
    @Test
    public void testMoveCursor() {
        addTypeWord();
        assertEquals(10, buffer.getCursorPosition());
        multiMoveLeft(5);
        assertEquals(5, buffer.getCursorPosition());
        multiMoveLeft(10);
        assertEquals(0, buffer.getCursorPosition());
        multiMoveRight(15);
        assertEquals(10, buffer.getCursorPosition());
        multiMoveLeft(3);
        assertEquals(7, buffer.getCursorPosition());
    }
    
    /**
     * Deletes and adds characters to various locations in the string, making
     * sure that the edits are accurate
     * 
     */
    @Test
    public void testEditWord() {
        addTypeWord();
        multiDelete(3);
        assertEquals("My Name Is", buffer.toString());
        buffer.moveLeft();
        multiDelete(3);
        assertEquals("My Name", buffer.toString());
        multiMoveLeft(4);
        multiDelete(3);
        assertEquals("Name", buffer.toString());
        multiMoveRight(3);
        multiDelete(5);
        assertEquals("", buffer.toString());
        addTypeWord();
        multiMoveLeft(4);
        multiDelete(4);
        buffer.moveRight();
        buffer.insert('N');
        buffer.insert('u');
        buffer.insert('m');
        buffer.insert('b');
        buffer.insert('e');
        buffer.insert('r');
        assertEquals("My Number Is", buffer.toString());
    }
    
    /**
     * Tests that getChar returns the correct character
     * 
     */
    @Test
    public void testGetChar() {
        addTypeWord();
        assertEquals('M', buffer.getChar(0));
        assertEquals('m', buffer.getChar(5));
        assertEquals(' ', buffer.getChar(7));
        assertEquals('s', buffer.getChar(9));
    }

    /**
     * Generates a buffer consisting of one letter of a random size, extracts a 
     * character of a random index within that buffer to verify if it's accurate
     * 
     * @param sz the random size of the buffer
     * @return whether or not the character at the random index was accurate
     */
    @Property
    public boolean testOneLetterWord(
            @ForAll @IntRange(min = 1, max = 100) int sz) {
        for (int i = 0; i < sz; i++) {
            buffer.insert('a');
        }
        int k = new Random().nextInt(sz);
        return buffer.getChar(k) == 'a';
    }
}
