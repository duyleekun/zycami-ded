/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.TextFormat$ParseException;

public class TextFormat$UnknownFieldParseException
extends TextFormat$ParseException {
    private final String unknownField;

    public TextFormat$UnknownFieldParseException(int n10, int n11, String string2, String string3) {
        super(n10, n11, string3);
        this.unknownField = string2;
    }

    public TextFormat$UnknownFieldParseException(String string2) {
        int n10 = -1;
        this(n10, n10, "", string2);
    }

    public String getUnknownField() {
        return this.unknownField;
    }
}

