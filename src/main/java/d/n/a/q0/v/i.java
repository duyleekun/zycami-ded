/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import com.polidea.rxandroidble2.scan.ScanCallbackType;
import d.n.a.j0;
import d.n.a.q0.n;
import d.n.a.q0.v.k;
import d.n.a.r0.c;
import d.n.a.r0.d;
import e.a.v0.o;

public class i
implements o {
    private final n a;

    public i(n n10) {
        this.a = n10;
    }

    public d a(k k10) {
        d d10;
        Object object = this.a;
        Object object2 = k10.a().getAddress();
        object2 = ((n)object).a((String)object2);
        int n10 = k10.b();
        long l10 = k10.e();
        ScanCallbackType scanCallbackType = k10.c();
        c c10 = k10.d();
        object = d10;
        d10 = new d((j0)object2, n10, l10, scanCallbackType, c10);
        return d10;
    }
}

