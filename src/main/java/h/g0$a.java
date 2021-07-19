/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.g0;
import h.m;
import h.n;
import java.io.IOException;
import java.io.OutputStream;

public final class g0$a
extends OutputStream {
    public final /* synthetic */ g0 a;

    public g0$a(g0 g02) {
        this.a = g02;
    }

    public void close() {
        this.a.close();
    }

    public void flush() {
        g0 g02 = this.a;
        boolean bl2 = g02.b;
        if (!bl2) {
            g02.flush();
        }
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        g0 g02 = this.a;
        stringBuilder.append(g02);
        stringBuilder.append(".outputStream()");
        return stringBuilder.toString();
    }

    public void write(int n10) {
        n n11 = this.a;
        boolean bl2 = ((g0)n11).b;
        if (!bl2) {
            n11 = ((g0)n11).a;
            n10 = (byte)n10;
            ((m)n11).b1(n10);
            this.a.o();
            return;
        }
        IOException iOException = new IOException("closed");
        throw iOException;
    }

    public void write(byte[] object, int n10, int n11) {
        f0.p(object, "data");
        g0 g02 = this.a;
        boolean bl2 = g02.b;
        if (!bl2) {
            g02.a.a1((byte[])object, n10, n11);
            this.a.o();
            return;
        }
        object = new IOException;
        object("closed");
        throw object;
    }
}

