/*
 * Decompiled with CFR 0.151.
 */
package d.v.y.d;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class c {
    public static ByteBuffer a(int n10, boolean bl2) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(n10);
        ByteOrder byteOrder = bl2 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        byteBuffer.order(byteOrder);
        return byteBuffer;
    }

    public static ByteBuffer b(byte[] object, boolean bl2) {
        object = ByteBuffer.wrap((byte[])object);
        ByteOrder byteOrder = bl2 ? ByteOrder.BIG_ENDIAN : ByteOrder.LITTLE_ENDIAN;
        ((ByteBuffer)object).order(byteOrder);
        return object;
    }
}

