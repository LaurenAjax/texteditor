package edu.grinnell.csc207.texteditor;

/**
 * A naive implementation of a text buffer using a <code>String</code>.
 */
public class SimpleStringBuffer {

    private String edit;
    /* the string that is edited in the text editor */
    private int cursor;
    /* the location where the text can be edited */
    private int size;

    /* the length of the text */

    /**
     * Initializes the string buffer
     *
     */
    public SimpleStringBuffer() {
        edit = "";
        cursor = 0;
        size = 0;
    }

    /**
     * Inserts the given character into the string at the location of the cursor
     *
     * @param ch the character that is inserted in the string
     */
    public void insert(char ch) {
        edit = edit.substring(0, cursor) + ch + edit.substring(cursor);
        cursor += 1;
        size += 1;
    }

    /**
     * Removes the character at the index of the cursor from the string
     *
     */
    public void delete() {
        if (!(edit.length() == 0 || cursor == 0)) {
            cursor -= 1;
            edit = edit.substring(0, cursor) + edit.substring(cursor + 1);
            size -= 1;
        }
    }

    /**
     * Returns the location of the cursor
     *
     * @return the integer that describes the index of the cursor
     */
    public int getCursorPosition() {
        return cursor;
    }

    /**
     * Moves the cursor left one position if able
     *
     */
    public void moveLeft() {
        if (!(cursor == 0)) {
            cursor -= 1;
        }
    }

    /**
     * Moves the cursor right one position if able
     *
     */
    public void moveRight() {
        if (!(cursor == size)) {
            cursor += 1;
        }
    }

    /**
     * Returns the length of the string
     *
     * @return the integer that describes the size of the string
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the character at the given index in the string or else throws an
     * error
     *
     * @param i the index of the requested character
     * @return the character at index 'i'
     */
    public char getChar(int i) {
        if (i < size && i >= 0) {
            return edit.charAt(i);
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns a string of the edited text
     *
     * @return the string of the buffer
     */
    @Override
    public String toString() {
        return edit;
    }
}
