/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.m;
import java.io.OutputStream;

public final class m$c
extends OutputStream {
    public final /* synthetic */ m a;

    public m$c(m m10) {
        this.a = m10;
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        m m10 = this.a;
        stringBuilder.append(m10);
        stringBuilder.append(".outputStream()");
        return stringBuilder.toString();
    }

    public void write(int n10) {
        this.a.b1(n10);
    }

    public void write(byte[] byArray, int n10, int n11) {
        f0.p(byArray, "data");
        this.a.a1(byArray, n10, n11);
    }
}

