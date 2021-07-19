/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.io.IOException;

public class TextFormat$ParseException
extends IOException {
    private static final long serialVersionUID = 3196188060225107702L;
    private final int column;
    private final int line;

    public TextFormat$ParseException(int n10, int n11, String string2) {
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = Integer.toString(n10);
        stringBuilder.append(string3);
        stringBuilder.append(":");
        stringBuilder.append(n11);
        stringBuilder.append(": ");
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        super(string2);
        this.line = n10;
        this.column = n11;
    }

    public TextFormat$ParseException(String string2) {
        int n10 = -1;
        this(n10, n10, string2);
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }
}

