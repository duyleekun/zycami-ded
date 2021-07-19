/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import java.io.Writer;

public final class BaseEncoding$5
extends Writer {
    public final /* synthetic */ Writer val$delegate;
    public final /* synthetic */ Appendable val$seperatingAppendable;

    public BaseEncoding$5(Appendable appendable, Writer writer) {
        this.val$seperatingAppendable = appendable;
        this.val$delegate = writer;
    }

    public void close() {
        this.val$delegate.close();
    }

    public void flush() {
        this.val$delegate.flush();
    }

    public void write(int n10) {
        Appendable appendable = this.val$seperatingAppendable;
        n10 = (char)n10;
        appendable.append((char)n10);
    }

    public void write(char[] object, int n10, int n11) {
        object = new UnsupportedOperationException;
        object();
        throw object;
    }
}

