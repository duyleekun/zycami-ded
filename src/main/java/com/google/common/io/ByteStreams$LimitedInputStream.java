/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ByteStreams$LimitedInputStream
extends FilterInputStream {
    private long left;
    private long mark = -1;

    public ByteStreams$LimitedInputStream(InputStream inputStream, long l10) {
        super(inputStream);
        Preconditions.checkNotNull(inputStream);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            inputStream = null;
        }
        Preconditions.checkArgument((boolean)l12, "limit must be non-negative");
        this.left = l10;
    }

    public int available() {
        long l10 = this.in.available();
        long l11 = this.left;
        return (int)Math.min(l10, l11);
    }

    public void mark(int n10) {
        synchronized (this) {
            InputStream inputStream = this.in;
            inputStream.mark(n10);
            long l10 = this.left;
            this.mark = l10;
            return;
        }
    }

    public int read() {
        long l10 = this.left;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = -1;
        if (l12 == false) {
            return n10;
        }
        InputStream inputStream = this.in;
        l12 = inputStream.read();
        if (l12 != n10) {
            long l13 = this.left;
            long l14 = 1L;
            this.left = l13 -= l14;
        }
        return (int)l12;
    }

    public int read(byte[] byArray, int n10, int n11) {
        long l10 = this.left;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n12 = -1;
        if (l12 == false) {
            return n12;
        }
        InputStream inputStream = this.in;
        long l13 = n11;
        int n13 = inputStream.read(byArray, n10, n11 = (int)(l10 = Math.min(l13, l10)));
        if (n13 != n12) {
            long l14 = this.left;
            l10 = n13;
            this.left = l14 -= l10;
        }
        return n13;
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
                    this.left = l10;
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
        long l11 = this.left;
        l10 = Math.min(l10, l11);
        l10 = this.in.skip(l10);
        this.left = l11 = this.left - l10;
        return l10;
    }
}

