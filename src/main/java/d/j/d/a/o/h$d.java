/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.d;
import d.j.d.a.g;
import d.j.d.a.k;
import d.j.d.a.o.h;
import d.j.d.a.o.h$d$a;

public final class h$d
implements g {
    public final /* synthetic */ d a;
    public final /* synthetic */ h b;
    public final /* synthetic */ h c;

    public h$d(h h10, d d10, h h11) {
        this.c = h10;
        this.a = d10;
        this.b = h11;
    }

    public final void onComplete(k object) {
        Object object2;
        try {
            object2 = this.a;
        }
        catch (Exception exception) {
            this.b.z(exception);
            return;
        }
        object = object2.a((k)object);
        object = (k)object;
        if (object == null) {
            object = this.b;
            object2 = new NullPointerException("Continuation returned null");
            ((h)object).z((Exception)object2);
            return;
        }
        object2 = new h$d$a(this);
        ((k)object).e((g)object2);
    }
}

