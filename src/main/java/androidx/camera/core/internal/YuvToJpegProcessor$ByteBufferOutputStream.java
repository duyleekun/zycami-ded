/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.internal;

import java.io.EOFException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class YuvToJpegProcessor$ByteBufferOutputStream
extends OutputStream {
    private final ByteBuffer mByteBuffer;

    public YuvToJpegProcessor$ByteBufferOutputStream(ByteBuffer byteBuffer) {
        this.mByteBuffer = byteBuffer;
    }

    public void write(int n10) {
        ByteBuffer byteBuffer = this.mByteBuffer;
        boolean bl2 = byteBuffer.hasRemaining();
        if (bl2) {
            byteBuffer = this.mByteBuffer;
            n10 = (byte)n10;
            byteBuffer.put((byte)n10);
            return;
        }
        EOFException eOFException = new EOFException("Output ByteBuffer has no bytes remaining.");
        throw eOFException;
    }

    public void write(byte[] object, int n10, int n11) {
        int n12;
        int n13;
        Objects.requireNonNull(object);
        if (n10 >= 0 && n10 <= (n13 = ((byte[])object).length) && n11 >= 0 && (n13 = n10 + n11) <= (n12 = ((byte[])object).length) && n13 >= 0) {
            if (n11 == 0) {
                return;
            }
            ByteBuffer byteBuffer = this.mByteBuffer;
            n13 = byteBuffer.remaining();
            if (n13 >= n11) {
                this.mByteBuffer.put((byte[])object, n10, n11);
                return;
            }
            object = new EOFException;
            object("Output ByteBuffer has insufficient bytes remaining.");
            throw object;
        }
        object = new IndexOutOfBoundsException;
        object();
        throw object;
    }
}

