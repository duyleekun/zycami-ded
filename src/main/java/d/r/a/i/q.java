/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.i;

import android.content.Context;
import d.r.a.h$j;
import d.r.a.h$t;
import d.r.a.i.q$a;
import d.r.a.l;
import d.r.a.n;
import d.r.a.o;

public final class q
extends d.r.a.i.o {
    public q(o o10) {
        super(o10);
    }

    public static /* synthetic */ Context d(q q10) {
        return q10.a;
    }

    public final void a(o o10) {
        o10 = (h$j)o10;
        Object object = l.b();
        String string2 = ((h$t)o10).c;
        int n10 = ((h$t)o10).d;
        Object[] objectArray = new Object[]{};
        ((l)object).h(string2, n10, objectArray);
        object = new q$a(this, (h$j)o10);
        n.c((Runnable)object);
    }
}

