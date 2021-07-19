/*
 * Decompiled with CFR 0.151.
 */
package com.bumptech.glide.load.resource.bitmap;

import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader;
import com.bumptech.glide.load.resource.bitmap.DefaultImageHeaderParser$Reader$EndOfFileException;
import java.io.InputStream;

public final class DefaultImageHeaderParser$c
implements DefaultImageHeaderParser$Reader {
    private final InputStream a;

    public DefaultImageHeaderParser$c(InputStream inputStream) {
        this.a = inputStream;
    }

    public int a() {
        int n10 = this.b() << 8;
        short s10 = this.b();
        return n10 | s10;
    }

    public short b() {
        int n10;
        Object object = this.a;
        int n11 = ((InputStream)object).read();
        if (n11 != (n10 = -1)) {
            return (short)n11;
        }
        object = new DefaultImageHeaderParser$Reader$EndOfFileException();
        throw object;
    }

    public int read(byte[] object, int n10) {
        int n11;
        int n12 = 0;
        int n13 = 0;
        InputStream inputStream = null;
        while (true) {
            int n14;
            n11 = -1;
            if (n12 >= n10 || (n13 = (inputStream = this.a).read((byte[])object, n12, n14 = n10 - n12)) == n11) break;
            n12 += n13;
        }
        if (n12 == 0 && n13 == n11) {
            object = new DefaultImageHeaderParser$Reader$EndOfFileException;
            object();
            throw object;
        }
        return n12;
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

