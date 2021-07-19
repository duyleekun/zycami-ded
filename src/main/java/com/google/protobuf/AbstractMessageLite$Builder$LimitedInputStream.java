/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import java.io.FilterInputStream;
import java.io.InputStream;

public final class AbstractMessageLite$Builder$LimitedInputStream
extends FilterInputStream {
    private int limit;

    public AbstractMessageLite$Builder$LimitedInputStream(InputStream inputStream, int n10) {
        super(inputStream);
        this.limit = n10;
    }

    public int available() {
        int n10 = super.available();
        int n11 = this.limit;
        return Math.min(n10, n11);
    }

    public int read() {
        int n10 = this.limit;
        if (n10 <= 0) {
            return -1;
        }
        n10 = super.read();
        if (n10 >= 0) {
            int n11;
            this.limit = n11 = this.limit + -1;
        }
        return n10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12 = this.limit;
        if (n12 <= 0) {
            return -1;
        }
        int n13 = super.read(byArray, n10, n11 = Math.min(n11, n12));
        if (n13 >= 0) {
            this.limit = n10 = this.limit - n13;
        }
        return n13;
    }

    public long skip(long l10) {
        long l11 = this.limit;
        l10 = Math.min(l10, l11);
        long l12 = (l10 = super.skip(l10)) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            l11 = (long)this.limit - l10;
            object = (int)l11;
            this.limit = (int)object;
        }
        return l10;
    }
}

