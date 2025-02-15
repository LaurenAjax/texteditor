package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class SimpleStringBufferTests {
    SimpleStringBuffer buffer = new SimpleStringBuffer();
    
    @Test
    public void testEmpty() {
        assertEquals(buffer.toString(), "");
        assertEquals(buffer.getCursorPosition(), 0);
        assertEquals(buffer.getSize(), 0);
    }
    
    @Test
    public void testTypeWord() {
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
        assertEquals(buffer.toString(), "My Name Is");
    }
    
    @Test
    public void testMoveCursor() {
        assertEquals(buffer.getCursorPosition(), 10);
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        assertEquals(buffer.getCursorPosition(), 5);
        buffer.moveRight();
        buffer.moveRight();
        assertEquals(buffer.getCursorPosition(), 7);
    }
    
    @Test
    public void testEditWord() {
        buffer.delete();
        buffer.delete();
        buffer.delete();
        buffer.delete();
        assertEquals(buffer.toString(), "My  Is");
        buffer.insert('N');
        buffer.insert('u');
        buffer.insert('m');
        buffer.insert('b');
        buffer.insert('e');
        buffer.insert('r');
        assertEquals(buffer.toString(), "My Number Is");
    }
    
    @Test
    public void testGetChar() {
        assertEquals(buffer.getChar(0), 'M');
        assertEquals(buffer.getChar(6), 'b');
        assertEquals(buffer.getChar(9), ' ');
        assertEquals(buffer.getChar(11), 's');
    }

    @Property
    public boolean testOneLetterWord(
            @ForAll @IntRange(min = 1, max = 100) int sz,
            @ForAll int k) {
        for (int i = 0; i < sz; i++) {
            buffer.insert('a');
        }
        return buffer.getChar(k) == 'a';
    }
}
