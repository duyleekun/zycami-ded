/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.NioByteString;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.InvalidMarkException;

public class NioByteString$1
extends InputStream {
    private final ByteBuffer buf;
    public final /* synthetic */ NioByteString this$0;

    public NioByteString$1(NioByteString object) {
        this.this$0 = object;
        this.buf = object = NioByteString.access$000((NioByteString)object).slice();
    }

    public int available() {
        return this.buf.remaining();
    }

    public void mark(int n10) {
        this.buf.mark();
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        ByteBuffer byteBuffer = this.buf;
        boolean bl2 = byteBuffer.hasRemaining();
        if (!bl2) {
            return -1;
        }
        return this.buf.get() & 0xFF;
    }

    public int read(byte[] byArray, int n10, int n11) {
        ByteBuffer byteBuffer = this.buf;
        int n12 = byteBuffer.hasRemaining();
        if (n12 == 0) {
            return -1;
        }
        n12 = this.buf.remaining();
        n11 = Math.min(n11, n12);
        this.buf.get(byArray, n10, n11);
        return n11;
    }

    public void reset() {
        ByteBuffer byteBuffer;
        try {
            byteBuffer = this.buf;
        }
        catch (InvalidMarkException invalidMarkException) {
            IOException iOException = new IOException(invalidMarkException);
            throw iOException;
        }
        byteBuffer.reset();
    }
}

