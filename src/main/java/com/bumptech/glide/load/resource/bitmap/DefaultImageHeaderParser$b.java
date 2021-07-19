/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public final class DefaultImageHeaderParser$b {
    private final ByteBuffer a;

    public DefaultImageHeaderParser$b(byte[] object, int n10) {
        object = ByteBuffer.wrap((byte[])object);
        ByteOrder byteOrder = ByteOrder.BIG_ENDIAN;
        this.a = object = (ByteBuffer)((ByteBuffer)object).order(byteOrder).limit(n10);
    }

    private boolean c(int n10, int n11) {
        ByteBuffer byteBuffer = this.a;
        int n12 = byteBuffer.remaining() - n10;
        n10 = n12 >= n11 ? 1 : 0;
        return n10 != 0;
    }

    public short a(int n10) {
        boolean bl2 = this.c(n10, 2);
        if (bl2) {
            ByteBuffer byteBuffer = this.a;
            n10 = byteBuffer.getShort(n10);
        } else {
            n10 = -1;
        }
        return (short)n10;
    }

    public int b(int n10) {
        boolean bl2 = this.c(n10, 4);
        if (bl2) {
            ByteBuffer byteBuffer = this.a;
            n10 = byteBuffer.getInt(n10);
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int d() {
        return this.a.remaining();
    }

    public void e(ByteOrder byteOrder) {
        this.a.order(byteOrder);
    }
}

