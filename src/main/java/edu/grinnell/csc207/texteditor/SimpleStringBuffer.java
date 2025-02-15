package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    private static String edit;
    private static int cursor;
    private static int size;
    
    public SimpleStringBuffer() {
        SimpleStringBuffer.edit = "";
        SimpleStringBuffer.cursor = 0;
        SimpleStringBuffer.size = 0;
    }
    
    public void insert(char ch) {
        SimpleStringBuffer.edit = SimpleStringBuffer.edit.substring(0, SimpleStringBuffer.cursor) + ch + SimpleStringBuffer.edit.substring(SimpleStringBuffer.cursor);
        SimpleStringBuffer.cursor += 1;
        SimpleStringBuffer.size += 1;
    }

    public void delete() {
        if (!(SimpleStringBuffer.edit.length() == 0 || SimpleStringBuffer.cursor == 0)) {
            SimpleStringBuffer.edit = SimpleStringBuffer.edit.substring(0, SimpleStringBuffer.cursor) + SimpleStringBuffer.edit.substring(SimpleStringBuffer.cursor + 1);
            SimpleStringBuffer.cursor -= 1;
            SimpleStringBuffer.size -= 1;
        }
    }

    public int getCursorPosition() {
        return SimpleStringBuffer.cursor;
    }

    public void moveLeft() {
        if (!(SimpleStringBuffer.cursor == 0)) {
            SimpleStringBuffer.cursor -= 1;
        }
    }

    public void moveRight() {
        if (!(SimpleStringBuffer.cursor == size)) {
            SimpleStringBuffer.cursor += 1;
        }
    }

    public int getSize() {
        return SimpleStringBuffer.size;
    }

    public char getChar(int i) {
        if (i < SimpleStringBuffer.size && i >= 0) {
            return SimpleStringBuffer.edit.charAt(i);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return SimpleStringBuffer.edit;
    }
}
