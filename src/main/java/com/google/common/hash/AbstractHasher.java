/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.common.hash.Funnel;
import com.google.common.hash.Hasher;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

public abstract class AbstractHasher
implements Hasher {
    public final Hasher putBoolean(boolean bl2) {
        return this.putByte((byte)(bl2 ? 1 : 0));
    }

    public Hasher putBytes(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.hasArray();
        if (n10 != 0) {
            byte[] byArray = byteBuffer.array();
            int n11 = byteBuffer.arrayOffset();
            int n12 = byteBuffer.position();
            n11 += n12;
            n12 = byteBuffer.remaining();
            this.putBytes(byArray, n11, n12);
            n10 = byteBuffer.limit();
            byteBuffer.position(n10);
        } else {
            for (n10 = byteBuffer.remaining(); n10 > 0; n10 += -1) {
                byte by2 = byteBuffer.get();
                this.putByte(by2);
            }
        }
        return this;
    }

    public Hasher putBytes(byte[] byArray) {
        int n10 = byArray.length;
        return this.putBytes(byArray, 0, n10);
    }

    public Hasher putBytes(byte[] byArray, int n10, int n11) {
        int n12 = n10 + n11;
        byte by2 = byArray.length;
        Preconditions.checkPositionIndexes(n10, n12, by2);
        for (n12 = 0; n12 < n11; ++n12) {
            by2 = n10 + n12;
            by2 = byArray[by2];
            this.putByte(by2);
        }
        return this;
    }

    public Hasher putChar(char c10) {
        byte by2 = (byte)c10;
        this.putByte(by2);
        c10 = (char)(c10 >>> 8);
        this.putByte((byte)c10);
        return this;
    }

    public final Hasher putDouble(double d10) {
        long l10 = Double.doubleToRawLongBits(d10);
        return this.putLong(l10);
    }

    public final Hasher putFloat(float f10) {
        int n10 = Float.floatToRawIntBits(f10);
        return this.putInt(n10);
    }

    public Hasher putInt(int n10) {
        byte by2 = (byte)n10;
        this.putByte(by2);
        by2 = (byte)(n10 >>> 8);
        this.putByte(by2);
        by2 = (byte)(n10 >>> 16);
        this.putByte(by2);
        n10 = (byte)(n10 >>> 24);
        this.putByte((byte)n10);
        return this;
    }

    public Hasher putLong(long l10) {
        int n10;
        for (int i10 = 0; i10 < (n10 = 64); i10 += 8) {
            long l11 = l10 >>> i10;
            n10 = (byte)l11;
            this.putByte((byte)n10);
        }
        return this;
    }

    public Hasher putObject(Object object, Funnel funnel) {
        funnel.funnel(object, this);
        return this;
    }

    public Hasher putShort(short s10) {
        byte by2 = (byte)s10;
        this.putByte(by2);
        s10 = (byte)(s10 >>> 8);
        this.putByte((byte)s10);
        return this;
    }

    public Hasher putString(CharSequence object, Charset charset) {
        object = object.toString().getBytes(charset);
        return this.putBytes((byte[])object);
    }

    public Hasher putUnencodedChars(CharSequence charSequence) {
        int n10 = charSequence.length();
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = charSequence.charAt(i10);
            this.putChar(c10);
        }
        return this;
    }
}

