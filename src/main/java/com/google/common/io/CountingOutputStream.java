/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public final class CountingOutputStream
extends FilterOutputStream {
    private long count;

    public CountingOutputStream(OutputStream outputStream) {
        outputStream = (OutputStream)Preconditions.checkNotNull(outputStream);
        super(outputStream);
    }

    public void close() {
        this.out.close();
    }

    public long getCount() {
        return this.count;
    }

    public void write(int n10) {
        long l10;
        this.out.write(n10);
        this.count = l10 = this.count + 1L;
    }

    public void write(byte[] byArray, int n10, int n11) {
        this.out.write(byArray, n10, n11);
        long l10 = this.count;
        long l11 = n11;
        this.count = l10 += l11;
    }
}

