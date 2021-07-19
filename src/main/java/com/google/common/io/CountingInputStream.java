/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class CountingInputStream
extends FilterInputStream {
    private long count;
    private long mark;

    public CountingInputStream(InputStream inputStream) {
        inputStream = (InputStream)Preconditions.checkNotNull(inputStream);
        super(inputStream);
        this.mark = -1;
    }

    public long getCount() {
        return this.count;
    }

    public void mark(int n10) {
        synchronized (this) {
            InputStream inputStream = this.in;
            inputStream.mark(n10);
            long l10 = this.count;
            this.mark = l10;
            return;
        }
    }

    public int read() {
        int n10;
        InputStream inputStream = this.in;
        int n11 = inputStream.read();
        if (n11 != (n10 = -1)) {
            long l10 = this.count;
            long l11 = 1L;
            this.count = l10 += l11;
        }
        return n11;
    }

    public int read(byte[] byArray, int n10, int n11) {
        InputStream inputStream = this.in;
        int n12 = inputStream.read(byArray, n10, n11);
        if (n12 != (n10 = -1)) {
            long l10 = this.count;
            long l11 = n12;
            this.count = l10 += l11;
        }
        return n12;
    }

    public void reset() {
        synchronized (this) {
            Object object;
            block11: {
                object = this.in;
                boolean bl2 = ((InputStream)object).markSupported();
                if (!bl2) break block11;
                long l10 = this.mark;
                long l11 = -1;
                bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (bl2) {
                    object = this.in;
                    ((InputStream)object).reset();
                    l10 = this.mark;
                    this.count = l10;
                    return;
                }
                String string2 = "Mark not set";
                object = new IOException(string2);
                throw object;
            }
            String string3 = "Mark not supported";
            object = new IOException(string3);
            throw object;
        }
    }

    public long skip(long l10) {
        long l11;
        l10 = this.in.skip(l10);
        this.count = l11 = this.count + l10;
        return l10;
    }
}

