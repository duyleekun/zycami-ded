/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class a$a
extends InputStream {
    private static final int c = 255;
    private final ByteBuffer a;
    private int b = -1;

    public a$a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
    }

    public int available() {
        return this.a.remaining();
    }

    public void mark(int n10) {
        synchronized (this) {
            ByteBuffer byteBuffer = this.a;
            n10 = byteBuffer.position();
            this.b = n10;
            return;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        ByteBuffer byteBuffer = this.a;
        boolean bl2 = byteBuffer.hasRemaining();
        if (!bl2) {
            return -1;
        }
        return this.a.get() & 0xFF;
    }

    public int read(byte[] byArray, int n10, int n11) {
        ByteBuffer byteBuffer = this.a;
        int n12 = byteBuffer.hasRemaining();
        if (n12 == 0) {
            return -1;
        }
        n12 = this.available();
        n11 = Math.min(n11, n12);
        this.a.get(byArray, n10, n11);
        return n11;
    }

    public void reset() {
        synchronized (this) {
            block6: {
                int n10 = this.b;
                int n11 = -1;
                if (n10 == n11) break block6;
                ByteBuffer byteBuffer = this.a;
                byteBuffer.position(n10);
                return;
            }
            String string2 = "Cannot reset to unset mark position";
            IOException iOException = new IOException(string2);
            throw iOException;
        }
    }

    public long skip(long l10) {
        ByteBuffer byteBuffer = this.a;
        boolean bl2 = byteBuffer.hasRemaining();
        if (!bl2) {
            return -1;
        }
        long l11 = this.available();
        l10 = Math.min(l10, l11);
        byteBuffer = this.a;
        int n10 = (int)((long)byteBuffer.position() + l10);
        byteBuffer.position(n10);
        return l10;
    }
}

