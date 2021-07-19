/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.d;
import d.j.d.a.g;
import d.j.d.a.k;
import d.j.d.a.o.h;

public final class h$e
implements g {
    public final /* synthetic */ h a;
    public final /* synthetic */ d b;
    public final /* synthetic */ h c;

    public h$e(h h10, h h11, d d10) {
        this.c = h10;
        this.a = h11;
        this.b = d10;
    }

    public final void onComplete(k object) {
        Object object2;
        boolean bl2 = ((k)object).t();
        if (bl2) {
            this.a.B();
            return;
        }
        try {
            object2 = this.b;
        }
        catch (Exception exception) {
            this.a.z(exception);
            return;
        }
        object = object2.a((k)object);
        object2 = this.a;
        ((h)object2).A(object);
    }
}

