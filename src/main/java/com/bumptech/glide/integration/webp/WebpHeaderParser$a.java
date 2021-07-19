/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp;

import com.bumptech.glide.integration.webp.WebpHeaderParser$c;

public final class WebpHeaderParser$a
implements WebpHeaderParser$c {
    private final byte[] a;
    private final int b;
    private final int c;
    private int d;

    public WebpHeaderParser$a(byte[] byArray, int n10, int n11) {
        this.a = byArray;
        this.b = n10;
        this.c = n11;
        this.d = n10;
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
        int n10 = this.d;
        int n11 = this.b;
        int n12 = this.c;
        if (n10 >= (n11 += n12)) {
            return -1;
        }
        byte[] byArray = this.a;
        this.d = n12 = n10 + 1;
        return byArray[n10];
    }

    public int read(byte[] byArray, int n10) {
        int n11 = this.b;
        int n12 = this.c;
        n11 += n12;
        n12 = this.d;
        if ((n10 = Math.min(n11 -= n12, n10)) == 0) {
            return -1;
        }
        byte[] byArray2 = this.a;
        n12 = this.d;
        System.arraycopy(byArray2, n12, byArray, 0, n10);
        return n10;
    }

    public long skip(long l10) {
        int n10;
        int n11 = this.b;
        int n12 = this.c;
        n11 += n12;
        n12 = this.d;
        int n13 = (int)Math.min((long)(n11 - n12), l10);
        this.d = n10 = this.d + n13;
        return n13;
    }
}

