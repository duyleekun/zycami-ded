/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.network;

import com.mob.tools.network.OnReadListener;
import java.io.InputStream;

public class ByteCounterInputStream
extends InputStream {
    private InputStream is;
    private OnReadListener listener;
    private long readBytes;

    public ByteCounterInputStream(InputStream inputStream) {
        this.is = inputStream;
    }

    public int available() {
        return this.is.available();
    }

    public void close() {
        this.is.close();
    }

    public void mark(int n10) {
        this.is.mark(n10);
    }

    public boolean markSupported() {
        return this.is.markSupported();
    }

    public int read() {
        InputStream inputStream = this.is;
        int n10 = inputStream.read();
        if (n10 >= 0) {
            long l10 = this.readBytes;
            long l11 = 1L;
            this.readBytes = l10 += l11;
            OnReadListener onReadListener = this.listener;
            if (onReadListener != null) {
                onReadListener.onRead(l10);
            }
        }
        return n10;
    }

    public int read(byte[] byArray, int n10, int n11) {
        Object object = this.is;
        int n12 = ((InputStream)object).read(byArray, n10, n11);
        if (n12 > 0) {
            long l10 = this.readBytes;
            long l11 = n12;
            this.readBytes = l10 += l11;
            object = this.listener;
            if (object != null) {
                object.onRead(l10);
            }
        }
        return n12;
    }

    public void reset() {
        synchronized (this) {
            InputStream inputStream = this.is;
            inputStream.reset();
            long l10 = 0L;
            this.readBytes = l10;
            return;
        }
    }

    public void setOnInputStreamReadListener(OnReadListener onReadListener) {
        this.listener = onReadListener;
    }

    public long skip(long l10) {
        return this.is.skip(l10);
    }
}

