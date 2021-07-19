/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0;

import d.v.e0.ce;
import d.v.e0.ie.l;
import d.v.y.c.s1.n.d;

public class ce$z
implements l {
    public final /* synthetic */ l a;
    public final /* synthetic */ ce b;

    public ce$z(ce ce2, l l10) {
        this.b = ce2;
        this.a = l10;
    }

    public void onFailed(Throwable throwable) {
        this.a.onFailed(throwable);
    }

    public void s(d object) {
        boolean bl2 = ((d)object).p();
        if (bl2) {
            object = this.a;
            Boolean bl3 = Boolean.TRUE;
            object.call(bl3);
        } else {
            object = this.a;
            Object var3_4 = null;
            object.onFailed(null);
        }
    }
}

