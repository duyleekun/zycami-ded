/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.m0;
import h.x;
import java.util.zip.Inflater;

public final class h {
    public static final x a(m0 m02, Inflater inflater) {
        f0.p(m02, "$this$inflate");
        f0.p(inflater, "inflater");
        x x10 = new x(m02, inflater);
        return x10;
    }

    public static /* synthetic */ x b(m0 m02, Inflater inflater, int n10, Object object) {
        if ((n10 &= 1) != 0) {
            inflater = new Inflater();
        }
        f0.p(m02, "$this$inflate");
        f0.p(inflater, "inflater");
        x x10 = new x(m02, inflater);
        return x10;
    }
}

