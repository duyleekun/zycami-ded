/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.c;

import d.v.d.g.c.r;
import d.v.d.g.c.s;
import d.v.d.h.f;
import d.v.d.i.a.b;
import d.v.d.i.a.c$a;
import d.v.d.i.f.u;

public class s$a
implements c$a {
    public final /* synthetic */ s a;

    public s$a(s s10) {
        this.a = s10;
    }

    public void b(b object, int n10) {
        object = this.a;
        int n11 = s.a((s)object);
        if (n11 == n10) {
            return;
        }
        object = this.a.B();
        n11 = (int)(((u)object).o() ? 1 : 0);
        if (n11 == 0) {
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("preview data change status=");
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(",isOpenData=");
        s s10 = this.a;
        int n12 = s.a(s10);
        ((StringBuilder)object).append(n12);
        f.a(((StringBuilder)object).toString());
        object = this.a.b;
        n12 = 3;
        if (n10 == n12) {
            n12 = 1;
        } else {
            n12 = 0;
            s10 = null;
        }
        ((r)object).e(n12 != 0);
        s.b(this.a, n10);
    }
}

