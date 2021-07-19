/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.integration.webp;

import com.bumptech.glide.integration.webp.WebpHeaderParser$c;
import java.io.InputStream;

public final class WebpHeaderParser$d
implements WebpHeaderParser$c {
    private final InputStream a;

    public WebpHeaderParser$d(InputStream inputStream) {
        this.a = inputStream;
    }

    public int a() {
        int n10 = this.a.read() << 8 & 0xFF00;
        int n11 = this.a.read() & 0xFF;
        return n10 | n11;
    }

    public short b() {
        return (short)(this.a.read() & 0xFF);
    }

    public int c() {
        return this.a.read();
    }

    public int read(byte[] byArray, int n10) {
        int n11;
        int n12;
        for (n11 = n10; n11 > 0; n11 -= n12) {
            InputStream inputStream = this.a;
            int n13 = n10 - n11;
            n12 = inputStream.read(byArray, n13, n11);
            if (n12 == (n13 = -1)) break;
        }
        return n10 - n11;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long skip(long l10) {
        long l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object < 0) {
            return l12;
        }
        long l14 = l10;
        while ((l11 = l14 == l12 ? 0 : (l14 < l12 ? -1 : 1)) > 0) {
            InputStream inputStream = this.a;
            long l15 = inputStream.skip(l14);
            long l16 = l15 - l12;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 <= 0) {
                int n10;
                inputStream = this.a;
                l11 = inputStream.read();
                if (l11 == (n10 = -1)) {
                    return l10 - l14;
                }
                l15 = 1L;
            }
            l14 -= l15;
        }
        return l10 - l14;
    }
}

