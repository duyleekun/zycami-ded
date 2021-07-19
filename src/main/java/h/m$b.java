/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.m;
import java.io.InputStream;

public final class m$b
extends InputStream {
    public final /* synthetic */ m a;

    public m$b(m m10) {
        this.a = m10;
    }

    public int available() {
        long l10 = this.a.S0();
        long l11 = -1 >>> 1;
        return (int)Math.min(l10, l11);
    }

    public void close() {
    }

    public int read() {
        long l10;
        m m10 = this.a;
        long l11 = m10.S0();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            m10 = this.a;
            object = m10.readByte() & 0xFF;
        } else {
            object = -1;
        }
        return (int)object;
    }

    public int read(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "sink");
        return this.a.read(byArray, n10, n11);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m m10 = this.a;
        stringBuilder.append(m10);
        stringBuilder.append(".inputStream()");
        return stringBuilder.toString();
    }
}

