package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {
    private String edit;
    private int cursor;
    private int size;
    
    public SimpleStringBuffer() {
        edit = "";
        cursor = 0;
        size = 0;
    }
    
    public void insert(char ch) {
        edit = edit.substring(0, cursor) + ch + edit.substring(cursor);
        cursor++;
        size++;
    }

    public void delete() {
        if (!(edit.length() == 0 || cursor == 0)) {
            edit = edit.substring(0, cursor - 1) + edit.substring(cursor);
            cursor--;
            size--;
        }
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if (!(cursor == 0)) {
            cursor--;
        }
    }

    public void moveRight() {
        if (!(cursor == size)) {
            cursor++;
        }
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        if (i < size && i >= 0) {
            return edit.charAt(i);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public String toString() {
        return edit;
    }
}
