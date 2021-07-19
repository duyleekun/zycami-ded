/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.time.LocalDate;
import j$.time.q.h;
import j$.time.q.s;
import j$.time.q.w;

/*
 * Renamed from j$.time.q.a
 */
public final class a_0
implements w {
    public static final /* synthetic */ a_0 a;

    static {
        a_0 a_02;
        a = a_02 = new a_0();
    }

    private /* synthetic */ a_0() {
    }

    public final Object a(s s10) {
        h h10 = h.y;
        boolean bl2 = s10.g(h10);
        if (bl2) {
            long l10 = s10.h(h10);
            s10 = LocalDate.L(l10);
        } else {
            s10 = null;
        }
        return s10;
    }
}

