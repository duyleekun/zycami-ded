/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.io;

import com.google.common.base.Preconditions;
import com.google.common.io.ByteSource;
import java.io.InputStream;
import java.util.Iterator;

public final class MultiInputStream
extends InputStream {
    private InputStream in;
    private Iterator it;

    public MultiInputStream(Iterator iterator2) {
        this.it = iterator2 = (Iterator)Preconditions.checkNotNull(iterator2);
        this.advance();
    }

    private void advance() {
        this.close();
        Object object = this.it;
        boolean bl2 = object.hasNext();
        if (bl2) {
            this.in = object = ((ByteSource)this.it.next()).openStream();
        }
    }

    public int available() {
        InputStream inputStream = this.in;
        if (inputStream == null) {
            return 0;
        }
        return inputStream.available();
    }

    public void close() {
        InputStream inputStream = this.in;
        if (inputStream != null) {
            try {
                inputStream.close();
            }
            finally {
                this.in = null;
            }
        }
    }

    public boolean markSupported() {
        return false;
    }

    public int read() {
        int n10;
        while (true) {
            InputStream inputStream = this.in;
            n10 = -1;
            if (inputStream == null) break;
            int n11 = inputStream.read();
            if (n11 != n10) {
                return n11;
            }
            this.advance();
        }
        return n10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        int n12;
        while (true) {
            InputStream inputStream = this.in;
            n12 = -1;
            if (inputStream == null) break;
            int n13 = inputStream.read(byArray, n10, n11);
            if (n13 != n12) {
                return n13;
            }
            this.advance();
        }
        return n12;
    }

    public long skip(long l10) {
        long l11;
        InputStream inputStream = this.in;
        long l12 = 0L;
        if (inputStream != null && (l11 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1)) > 0) {
            long l13 = inputStream.skip(l10);
            long l14 = l13 - l12;
            Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                return l13;
            }
            object = this.read();
            if (object == (l11 = (long)-1)) {
                return l12;
            }
            inputStream = this.in;
            l12 = 1L;
            return inputStream.skip(l10 -= l12) + l12;
        }
        return l12;
    }
}

