/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import java.io.Reader;

public final class BaseEncoding$3
extends Reader {
    public final /* synthetic */ Reader val$delegate;
    public final /* synthetic */ String val$toIgnore;

    public BaseEncoding$3(Reader reader, String string2) {
        this.val$delegate = reader;
        this.val$toIgnore = string2;
    }

    public void close() {
        this.val$delegate.close();
    }

    public int read() {
        char c10;
        String string2;
        int n10;
        Reader reader;
        int n11;
        while ((n11 = (reader = this.val$delegate).read()) != (n10 = -1) && (n10 = (string2 = this.val$toIgnore).indexOf(c10 = (char)n11)) >= 0) {
        }
        return n11;
    }

    public int read(char[] object, int n10, int n11) {
        object = new UnsupportedOperationException;
        object();
        throw object;
    }
}

