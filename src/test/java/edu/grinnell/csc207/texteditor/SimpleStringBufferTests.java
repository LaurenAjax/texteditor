package edu.grinnell.csc207.texteditor;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import net.jqwik.api.*;
import net.jqwik.api.constraints.*;

public class SimpleStringBufferTests {
    SimpleStringBuffer buffer = new SimpleStringBuffer();
    
    @Test
    public void testEmpty() {
        assertEquals("", buffer.toString());
        assertEquals(0, buffer.getCursorPosition());
        assertEquals(0, buffer.getSize());
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
        assertEquals("My Name Is", buffer.toString());
    }
    
    @Test
    public void testMoveCursor() {
        assertEquals(10, buffer.getCursorPosition());
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        buffer.moveLeft();
        assertEquals(5, buffer.getCursorPosition());
        buffer.moveRight();
        buffer.moveRight();
        assertEquals(7, buffer.getCursorPosition());
    }
    
    @Test
    public void testEditWord() {
        buffer.delete();
        buffer.delete();
        buffer.delete();
        buffer.delete();
        assertEquals("My  Is", buffer.toString());
        buffer.insert('N');
        buffer.insert('u');
        buffer.insert('m');
        buffer.insert('b');
        buffer.insert('e');
        buffer.insert('r');
        assertEquals("My Number Is", buffer.toString());
    }
    
    @Test
    public void testGetChar() {
        assertEquals('M', buffer.getChar(0));
        assertEquals('b', buffer.getChar(6));
        assertEquals(' ', buffer.getChar(9));
        assertEquals('s', buffer.getChar(11));
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
