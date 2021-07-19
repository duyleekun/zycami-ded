/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp;

import com.bumptech.glide.integration.webp.WebpHeaderParser$c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class WebpHeaderParser$b
implements WebpHeaderParser$c {
    private final ByteBuffer a;

    public WebpHeaderParser$b(ByteBuffer byteBuffer) {
        this.a = byteBuffer;
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        byteBuffer.order(byteOrder);
    }

    public int a() {
        int n10 = this.c() << 8 & 0xFF00;
        int n11 = this.c() & 0xFF;
        return n10 | n11;
    }

    public short b() {
        return (short)(this.c() & 0xFF);
    }

    public int c() {
        int n10;
        ByteBuffer byteBuffer = this.a;
        int n11 = byteBuffer.remaining();
        if (n11 < (n10 = 1)) {
            return -1;
        }
        return this.a.get();
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

