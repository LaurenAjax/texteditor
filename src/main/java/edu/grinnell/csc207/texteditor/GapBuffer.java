package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    private char[] edit;
    private int cursor;
    private int size;
    
    public GapBuffer () {
        edit = new char[10];
        cursor = 0;
        size = 0;
    }
    
    public void insert(char ch) {
        if (size == edit.length) {
            char[] arr = new char[2 * edit.length];
            for (int i = 0; i < cursor; i++) {
                arr[i] = edit[i];
            }
            for (int j = cursor; j < arr.length; j++) {
                arr[j] = edit[j - edit.length];
            }
            edit = arr;
        }
        edit[cursor] = ch;
        cursor++;
        size++;
        if (!(edit[cursor] == '\0') && !(size == edit.length)) {
            int k;
            for (k = cursor; k < edit.length - 1; k++) {
                edit[k + 1] = edit[k];
            }
            edit[k] = '\0';
        }
    }

    public void delete() {
        if (!(cursor == 0)) {
            cursor--;
            edit[cursor] = '\0';
        }
    }

    public int getCursorPosition() {
        return cursor;
    }

    public void moveLeft() {
        if (!(cursor == 0)) {
            cursor--;
            edit[cursor + 1] = edit[cursor];
            edit[cursor] = '\0';
        }
    }

    public void moveRight() {
        if(!(cursor == edit.length)) {
            cursor++;
            edit[cursor - 1] = edit[cursor];
            edit[cursor] = '\0';
        }
    }

    public int getSize() {
        return size;
    }

    public char getChar(int i) {
        if (i < size && i >= 0) {
            int index = 0;
            for (int iter = 0; iter < edit.length; iter++) {
                if (edit[index] == '\0') {
                    index--;
                } else if (index == i) {
                    return edit[iter];
                }
                index++;
            }
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < edit.length, i++) {
            if (!(edit[i] == '\0')) {
                str = str + edit[i];
            }
        }
        return str;
    }
}
