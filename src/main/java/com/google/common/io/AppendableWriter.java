/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

public class AppendableWriter
extends Writer {
    private boolean closed;
    private final Appendable target;

    public AppendableWriter(Appendable appendable) {
        this.target = appendable = (Appendable)Preconditions.checkNotNull(appendable);
    }

    private void checkNotClosed() {
        boolean bl2 = this.closed;
        if (!bl2) {
            return;
        }
        IOException iOException = new IOException("Cannot write to a closed writer.");
        throw iOException;
    }

    public Writer append(char c10) {
        this.checkNotClosed();
        this.target.append(c10);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int n10, int n11) {
        this.checkNotClosed();
        this.target.append(charSequence, n10, n11);
        return this;
    }

    public void close() {
        boolean bl2;
        this.closed = bl2 = true;
        Object object = this.target;
        boolean bl3 = object instanceof Closeable;
        if (bl3) {
            object = (Closeable)object;
            object.close();
        }
    }

    public void flush() {
        this.checkNotClosed();
        Object object = this.target;
        boolean bl2 = object instanceof Flushable;
        if (bl2) {
            object = (Flushable)object;
            object.flush();
        }
    }

    public void write(int n10) {
        this.checkNotClosed();
        Appendable appendable = this.target;
        n10 = (char)n10;
        appendable.append((char)n10);
    }

    public void write(String string2) {
        this.checkNotClosed();
        this.target.append(string2);
    }

    public void write(String string2, int n10, int n11) {
        this.checkNotClosed();
        Appendable appendable = this.target;
        appendable.append(string2, n10, n11 += n10);
    }

    public void write(char[] cArray, int n10, int n11) {
        this.checkNotClosed();
        Appendable appendable = this.target;
        String string2 = new String(cArray, n10, n11);
        appendable.append(string2);
    }
}

