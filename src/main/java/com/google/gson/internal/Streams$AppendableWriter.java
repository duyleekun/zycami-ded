/*
 * Decompiled with CFR 0.151.
 */
package com.google.gson.internal;

import com.google.gson.internal.Streams$AppendableWriter$CurrentWrite;
import java.io.Writer;

public final class Streams$AppendableWriter
extends Writer {
    private final Appendable appendable;
    private final Streams$AppendableWriter$CurrentWrite currentWrite;

    public Streams$AppendableWriter(Appendable appendable) {
        Streams$AppendableWriter$CurrentWrite streams$AppendableWriter$CurrentWrite;
        this.currentWrite = streams$AppendableWriter$CurrentWrite = new Streams$AppendableWriter$CurrentWrite();
        this.appendable = appendable;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int n10) {
        Appendable appendable = this.appendable;
        n10 = (char)n10;
        appendable.append((char)n10);
    }

    public void write(char[] object, int n10, int n11) {
        Streams$AppendableWriter$CurrentWrite streams$AppendableWriter$CurrentWrite = this.currentWrite;
        streams$AppendableWriter$CurrentWrite.chars = object;
        object = this.appendable;
        object.append(streams$AppendableWriter$CurrentWrite, n10, n11 += n10);
    }
}

