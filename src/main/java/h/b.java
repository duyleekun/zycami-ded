/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.k0;
import h.p;
import java.util.zip.Deflater;

public final class b {
    public static final p a(k0 k02, Deflater deflater) {
        f0.p(k02, "$this$deflate");
        f0.p(deflater, "deflater");
        p p10 = new p(k02, deflater);
        return p10;
    }

    public static /* synthetic */ p b(k0 k02, Deflater deflater, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            deflater = new Deflater();
        }
        f0.p(k02, "$this$deflate");
        f0.p(deflater, "deflater");
        p p10 = new p(k02, deflater);
        return p10;
    }
}

