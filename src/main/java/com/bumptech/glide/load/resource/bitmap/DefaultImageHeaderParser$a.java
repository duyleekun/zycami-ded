/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DefaultImageHeaderParser$a
implements DefaultImageHeaderParser$Reader {
    private final ByteBuffer a;

    public DefaultImageHeaderParser$a(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byteBuffer.order(byteOrder);
    }

    public int a() {
        int n10 = this.b() << 8;
        short s10 = this.b();
        return n10 | s10;
    }

    public short b() {
        int n10;
        Object object = this.a;
        int n11 = ((Buffer)object).remaining();
        if (n11 >= (n10 = 1)) {
            return (short)(this.a.get() & 0xFF);
        }
        object = new DefaultImageHeaderParser$Reader$EndOfFileException();
        throw object;
    }

    public int read(byte[] byArray, int n10) {
        ByteBuffer byteBuffer = this.a;
        int n11 = byteBuffer.remaining();
        if ((n10 = Math.min(n10, n11)) == 0) {
            return -1;
        }
        this.a.get(byArray, 0, n10);
        return n10;
    }

    public long skip(long l10) {
        int n10 = (int)Math.min((long)this.a.remaining(), l10);
        ByteBuffer byteBuffer = this.a;
        int n11 = byteBuffer.position() + n10;
        byteBuffer.position(n11);
        return n10;
    }
}

