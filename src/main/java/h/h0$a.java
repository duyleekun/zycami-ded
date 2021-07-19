/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.h0;
import h.j;
import h.m;
import h.m0;
import h.o;
import java.io.IOException;
import java.io.InputStream;

public final class h0$a
extends InputStream {
    public final /* synthetic */ h0 a;

    public h0$a(h0 h02) {
        this.a = h02;
    }

    public int available() {
        Object object = this.a;
        boolean bl2 = ((h0)object).b;
        if (!bl2) {
            long l10 = ((h0)object).a.S0();
            long l11 = -1 >>> 1;
            return (int)Math.min(l10, l11);
        }
        object = new IOException("closed");
        throw object;
    }

    public void close() {
        this.a.close();
    }

    public int read() {
        Object object = this.a;
        boolean bl2 = ((h0)object).b;
        if (!bl2) {
            long l10;
            object = ((h0)object).a;
            long l11 = ((m)object).S0();
            long l12 = l11 - (l10 = 0L);
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 == false) {
                object = this.a;
                m0 m02 = ((h0)object).c;
                object = ((h0)object).a;
                int n10 = 8192;
                l10 = n10;
                l11 = m02.read((m)object, l10);
                long l13 = l11 - (l10 = (long)-1);
                object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object2 == false) {
                    return -1;
                }
            }
            return this.a.a.readByte() & 0xFF;
        }
        object = new IOException("closed");
        throw object;
    }

    public int read(byte[] object, int n10, int n11) {
        f0.p(object, "data");
        o o10 = this.a;
        Object object2 = ((h0)o10).b;
        if (!object2) {
            long l10 = ((byte[])object).length;
            long l11 = n10;
            long l12 = n11;
            j.e(l10, l11, l12);
            o10 = this.a.a;
            long l13 = ((m)o10).S0();
            long l14 = 0L;
            object2 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
            if (!object2) {
                o10 = this.a;
                m0 m02 = ((h0)o10).c;
                o10 = ((h0)o10).a;
                int n12 = 8192;
                l14 = n12;
                l13 = m02.read((m)o10, l14);
                long l15 = l13 - (l14 = (long)-1);
                object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (!object2) {
                    return -1;
                }
            }
            return this.a.a.read((byte[])object, n10, n11);
        }
        object = new IOException;
        object("closed");
        throw object;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        h0 h02 = this.a;
        stringBuilder.append(h02);
        stringBuilder.append(".inputStream()");
        return stringBuilder.toString();
    }
}

