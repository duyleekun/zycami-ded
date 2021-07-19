/*
 * Decompiled with CFR 0.151.
 */
package d.v.n.l;

import d.v.e.l.m2$b;
import d.v.n.l.d;
import d.v.n.l.e;
import e.a.s0.b;

public class d$e
implements m2$b {
    public final /* synthetic */ String a;
    public final /* synthetic */ d b;

    public d$e(d d10, String string2) {
        this.b = d10;
        this.a = string2;
    }

    public void a(Long l10) {
    }

    public void onComplete() {
        int n10;
        Object object = this.b;
        int n11 = d.e((d)object);
        if (n11 < (n10 = 5)) {
            d.g(this.b);
            object = this.b;
            ((d)object).v();
        } else {
            object = this.b;
            n10 = 0;
            String string2 = null;
            d.f((d)object, 0);
            object = this.b.d;
            if (object != null) {
                object.a();
                object = e.d();
                string2 = this.a;
                ((e)object).b(string2);
            }
        }
    }

    public void onError(Throwable object) {
        object = this.b.d;
        if (object != null) {
            object.a();
        }
    }

    public void onSubscribe(b b10) {
    }
}

