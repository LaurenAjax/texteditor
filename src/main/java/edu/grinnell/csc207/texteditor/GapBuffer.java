package edu.grinnell.csc207.texteditor;

/**
 * A gap buffer-based implementation of a text buffer.
 */
public class GapBuffer {
    private static char[] edit;
    private static int cursor;
    private static int size;
    
    public GapBuffer () {
        GapBuffer.edit = new char[10];
        GapBuffer.cursor = 0;
        GapBuffer.size = 0;
    }
    
    public void insert(char ch) {
        if (GapBuffer.size == GapBuffer.edit.length) {
            char[] arr = new char[2 * GapBuffer.edit.length];
            for (int i = 0; i < GapBuffer.cursor; i++) {
                arr[i] = GapBuffer.edit[i];
            }
            for (int j = GapBuffer.cursor; j < arr.length; j++) {
                arr[j] = GapBuffer.edit[j - GapBuffer.edit.length];
            }
            GapBuffer.edit = arr;
        }
        GapBuffer.edit[GapBuffer.cursor] = ch;
        GapBuffer.cursor++;
        GapBuffer.size++;
        if (!(GapBuffer.edit[GapBuffer.cursor] == '\0') && !(GapBuffer.size == GapBuffer.edit.length)) {
            int k;
            for (k = GapBuffer.cursor; k < GapBuffer.edit.length - 1; k++) {
                GapBuffer.edit[k + 1] = GapBuffer.edit[k];
            }
            GapBuffer.edit[k] = '\0';
        }
    }

    public void delete() {
        if (!(GapBuffer.cursor == 0)) {
            GapBuffer.cursor--;
            GapBuffer.edit[GapBuffer.cursor] = '\0';
        }
    }

    public int getCursorPosition() {
        return GapBuffer.cursor;
    }

    public void moveLeft() {
        if (!(GapBuffer.cursor == 0)) {
            GapBuffer.cursor--;
            GapBuffer.edit[GapBuffer.cursor + 1] = GapBuffer.edit[GapBuffer.cursor];
            GapBuffer.edit[GapBuffer.cursor] = '\0';
        }
    }

    public void moveRight() {
        if(!(GapBuffer.cursor == GapBuffer.edit.length)) {
            GapBuffer.cursor++;
            GapBuffer.edit[GapBuffer.cursor - 1] = GapBuffer.edit[GapBuffer.cursor];
            GapBuffer.edit[GapBuffer.cursor] = '\0';
        }
    }

    public int getSize() {
        return GapBuffer.size;
    }

    public char getChar(int i) {
        if (i >= GapBuffer.size && i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int index = 0;
        for (int iter = 0; iter < GapBuffer.edit.length; iter++) {
            if (GapBuffer.edit[index] == '\0') {
                index--;
            } else if (index == i) {
                return GapBuffer.edit[iter];
            }
            index++;
        }
        return '0';
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < GapBuffer.edit.length; i++) {
            if (!(GapBuffer.edit[i] == '\0')) {
                str = str + GapBuffer.edit[i];
            }
        }
        return str;
    }
}
