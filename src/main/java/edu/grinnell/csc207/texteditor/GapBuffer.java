package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {

    private char[] edit;
    /* the array of characters the text is contained in */
    private int startCursor;
    /* the start of the gap space */
    private int endCursor;
    /* the start of the text after the cursor */
    private int size;

    /* the count of non-null characters in the array */

    /**
     * Initializes the array buffer
     *
     */
    public GapBuffer() {
        edit = new char[10];
        startCursor = 0;
        endCursor = edit.length;
        size = 0;
    }

    /**
     * Inserts the character at the start of the cursor and expands the buffer
     * if it is full
     *
     * @param ch the character that is inserted into the text
     */
    public void insert(char ch) {
        if (size == edit.length) {
            char[] arr = new char[2 * edit.length];
            for (int i = 0; i < startCursor; i++) {
                arr[i] = edit[i];
            }
            endCursor = endCursor + edit.length;
            for (int j = endCursor; j < arr.length; j++) {
                arr[j] = edit[j - edit.length];
            }
            edit = arr;
        }
        edit[startCursor] = ch;
        startCursor += 1;
        size += 1;
    }

    /**
     * Removes the element before the start of the cursor if able
     *
     */
    public void delete() {
        if (!(startCursor == 0)) {
            startCursor--;
            edit[startCursor] = '\0';
            size -= 1;
        }
    }

    /**
     * Returns the location of the start of the cursor
     *
     * @return the index of the cursor
     */
    public int getCursorPosition() {
        return startCursor;
    }

    /**
     * Moves the start and end of the cursor to the left if able and moves the
     * character at the end of the text before the cursor to the beginning of
     * the text after the cursor
     *
     */
    public void moveLeft() {
        if (!(startCursor == 0)) {
            startCursor -= 1;
            endCursor -= 1;
            if (!(size == edit.length)) {
                edit[endCursor] = edit[startCursor];
                edit[startCursor] = '\0';
            }
        }
    }

    /**
     * Move the start and end of the cursor to the right if able and moves the
     * character at the start of the text after the cursor to the end of the
     * text before the cursor
     *
     */
    public void moveRight() {
        if (!(endCursor == edit.length)) {
            if (!(size == edit.length)) {
                edit[startCursor] = edit[endCursor];
                edit[endCursor] = '\0';
            }
            startCursor += 1;
            endCursor += 1;
        }
    }

    /**
     * Returns the number of character in the array
     *
     * @return the integer depicting the size of the text
     */
    public int getSize() {
        return size;
    }

    /**
     * Returns the character at the given index in the array, disregarding the
     * gap space
     *
     * @param i the index of the requested character
     * @return the character found at the given index
     */
    public char getChar(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException();
        } else if (i < startCursor) {
            return edit[i];
        } else {
            return edit[(i - startCursor) + endCursor];
        }
    }

    /**
     * Produces a string made up of the characters in the array
     *
     * @return the string as it has been made in the text editor
     */
    public String toString() {
        String str = "";
        for (int i = 0; i < startCursor; i++) {
            str = str + edit[i];
        }
        for (int j = endCursor; j < edit.length; j++) {
            str = str + edit[j];
        }
        return str;
    }
}
