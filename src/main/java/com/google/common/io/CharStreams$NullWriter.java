/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Writer;

public final class CharStreams$NullWriter
extends Writer {
    private static final CharStreams$NullWriter INSTANCE;

    static {
        CharStreams$NullWriter charStreams$NullWriter;
        INSTANCE = charStreams$NullWriter = new CharStreams$NullWriter();
    }

    private CharStreams$NullWriter() {
    }

    public static /* synthetic */ CharStreams$NullWriter access$000() {
        return INSTANCE;
    }

    public Writer append(char c10) {
        return this;
    }

    public Writer append(CharSequence charSequence) {
        Preconditions.checkNotNull(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int n10, int n11) {
        int n12 = charSequence.length();
        Preconditions.checkPositionIndexes(n10, n11, n12);
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return "CharStreams.nullWriter()";
    }

    public void write(int n10) {
    }

    public void write(String string2) {
        Preconditions.checkNotNull(string2);
    }

    public void write(String string2, int n10, int n11) {
        int n12 = string2.length();
        Preconditions.checkPositionIndexes(n10, n11 += n10, n12);
    }

    public void write(char[] cArray) {
        Preconditions.checkNotNull(cArray);
    }

    public void write(char[] cArray, int n10, int n11) {
        int n12 = cArray.length;
        Preconditions.checkPositionIndexes(n10, n11 += n10, n12);
    }
}

