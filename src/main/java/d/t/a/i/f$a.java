/*
 * Decompiled with CFR 0.151.
 */
package d.t.a.i;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class f$a {
    private final ByteBuffer a;

    public f$a(byte[] object, int n10) {
        object = ByteBuffer.wrap((byte[])object);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.a = object = (ByteBuffer)((ByteBuffer)object).order(byteOrder).limit(n10);
    }

    public short a(int n10) {
        return this.a.getShort(n10);
    }

    public int b(int n10) {
        return this.a.getInt(n10);
    }

    public int c() {
        return this.a.remaining();
    }

    public void d(ByteOrder byteOrder) {
        this.a.order(byteOrder);
    }
}

