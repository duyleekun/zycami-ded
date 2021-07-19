/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.util.Arrays;

public final class TextFormatParseLocation {
    public static final TextFormatParseLocation EMPTY;
    private final int column;
    private final int line;

    static {
        TextFormatParseLocation textFormatParseLocation;
        int n10 = -1;
        EMPTY = textFormatParseLocation = new TextFormatParseLocation(n10, n10);
    }

    private TextFormatParseLocation(int n10, int n11) {
        this.line = n10;
        this.column = n11;
    }

    public static TextFormatParseLocation create(int n10, int n11) {
        Object object;
        int n12 = -1;
        if (n10 == n12 && n11 == n12) {
            return EMPTY;
        }
        if (n10 >= 0 && n11 >= 0) {
            TextFormatParseLocation textFormatParseLocation = new TextFormatParseLocation(n10, n11);
            return textFormatParseLocation;
        }
        Object[] objectArray = new Object[2];
        objectArray[0] = object = Integer.valueOf(n10);
        Integer n13 = n11;
        objectArray[1] = n13;
        object = String.format("line and column values must be >= 0: line %d, column: %d", objectArray);
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        int n11 = object instanceof TextFormatParseLocation;
        if (n11 == 0) {
            return false;
        }
        n11 = this.line;
        int n12 = ((TextFormatParseLocation)(object = (TextFormatParseLocation)object)).getLine();
        if (n11 != n12 || (n11 = this.column) != (n10 = ((TextFormatParseLocation)object).getColumn())) {
            bl2 = false;
        }
        return bl2;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        int n10 = this.line;
        n10 = this.column;
        int[] nArray = new int[]{n10, n10};
        return Arrays.hashCode(nArray);
    }

    public String toString() {
        Object[] objectArray = new Object[2];
        Integer n10 = this.line;
        objectArray[0] = n10;
        n10 = this.column;
        objectArray[1] = n10;
        return String.format("ParseLocation{line=%d, column=%d}", objectArray);
    }
}

