/*
 * Decompiled with CFR 0.151.
 */
package g.i0;

import f.h2.t.f0;
import f.l2.q;
import h.m;
import java.io.EOFException;

public final class b {
    public static final boolean a(m m10) {
        int n10;
        f0.p(m10, "$this$isProbablyUtf8");
        m m11 = new m();
        long l10 = m10.S0();
        long l11 = 64;
        long l12 = q.v(l10, l11);
        l11 = 0L;
        try {
            m10.s0(m11, l11, l12);
            n10 = 16;
        }
        catch (EOFException eOFException) {
            return false;
        }
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11 = m11.V();
            if (n11 != 0) break;
            n11 = m11.Z();
            boolean bl2 = Character.isISOControl(n11);
            if (!bl2) continue;
            n11 = (int)(Character.isWhitespace(n11) ? 1 : 0);
            if (n11 != 0) continue;
            return false;
        }
        return true;
    }
}

