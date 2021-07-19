/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.a;
import d.r.a.l;
import d.r.a.l$f;
import d.r.a.u.s;

public final class l$a
implements a {
    public final /* synthetic */ l$f a;
    public final /* synthetic */ l b;

    public l$a(l l10, l$f l$f) {
        this.b = l10;
        this.a = l$f;
    }

    public final void onStateChanged(int n10) {
        if (n10 == 0) {
            int n11;
            Object object = this.a.e;
            if (object != null && (n11 = ((Object[])object).length) != 0) {
                l l10 = this.b;
                object = (String)object[0];
                l10.f((String)object);
                return;
            }
            s.a("PushClientManager", "bind app result is null");
            return;
        }
        l l11 = this.b;
        l11.j = null;
        l11.i.k("APP_TOKEN");
    }
}

