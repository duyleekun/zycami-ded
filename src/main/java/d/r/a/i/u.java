/*
 * Decompiled with CFR 0.151.
 */
package d.r.a.i;

import d.r.a.f.a;
import d.r.a.h$d;
import d.r.a.h$f;
import d.r.a.l;
import d.r.a.m;
import d.r.a.o;
import d.r.a.r.f;
import d.r.a.u.v;
import d.r.a.u.w;

public final class u
extends m {
    public u(o o10) {
        super(o10);
    }

    public final void a(o object) {
        Object object2 = object;
        object2 = (h$d)object;
        f f10 = w.a(this.a);
        Object[] objectArray = null;
        if (f10 == null) {
            object = l.b();
            object2 = ((h$d)object2).c;
            objectArray = new Object[]{};
            ((l)object).h((String)object2, 1005, objectArray);
            return;
        }
        String string2 = f10.a;
        int n10 = f10.e;
        if (n10 != 0) {
            object = l.b();
            object2 = ((h$d)object2).c;
            n10 = 1004;
            objectArray = new Object[]{};
            ((l)object).h((String)object2, n10, objectArray);
            object = new h$f();
        } else {
            n10 = v.a((h$d)object2);
            if (n10 != 0) {
                object = l.b();
                object2 = ((h$d)object2).c;
                objectArray = new Object[]{};
                ((l)object).h((String)object2, n10, objectArray);
                return;
            }
        }
        d.r.a.f.a.b(this.a, string2, (o)object);
    }
}

