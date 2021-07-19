/*
 * Decompiled with CFR 0.151.
 */
package i.d.u;

import java.nio.Buffer;
import java.nio.ByteBuffer;

public class b {
    private b() {
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(0);
    }

    public static int b(ByteBuffer object, ByteBuffer byteBuffer) {
        if (object != null && byteBuffer != null) {
            int n10;
            int n11 = ((Buffer)object).remaining();
            if (n11 > (n10 = byteBuffer.remaining())) {
                n11 = Math.min(n11, n10);
                ((ByteBuffer)object).limit(n11);
                byteBuffer.put((ByteBuffer)object);
                return n11;
            }
            byteBuffer.put((ByteBuffer)object);
            return n11;
        }
        object = new IllegalArgumentException();
        throw object;
    }
}

