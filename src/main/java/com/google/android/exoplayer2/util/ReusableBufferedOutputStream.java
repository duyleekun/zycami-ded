/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.BufferedOutputStream;
import java.io.OutputStream;

public final class ReusableBufferedOutputStream
extends BufferedOutputStream {
    private boolean closed;

    public ReusableBufferedOutputStream(OutputStream outputStream) {
        super(outputStream);
    }

    public ReusableBufferedOutputStream(OutputStream outputStream, int n10) {
        super(outputStream, n10);
    }

    public void close() {
        Throwable throwable;
        block6: {
            boolean bl2;
            this.closed = bl2 = true;
            try {
                this.flush();
                bl2 = false;
                throwable = null;
            }
            catch (Throwable throwable2) {
                // empty catch block
            }
            OutputStream outputStream = this.out;
            try {
                outputStream.close();
            }
            catch (Throwable throwable3) {
                if (throwable != null) break block6;
                throwable = throwable3;
            }
        }
        if (throwable != null) {
            Util.sneakyThrow(throwable);
        }
    }

    public void reset(OutputStream outputStream) {
        Assertions.checkState(this.closed);
        this.out = outputStream;
        this.count = 0;
        this.closed = false;
    }
}

