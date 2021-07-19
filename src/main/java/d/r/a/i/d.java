/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.r.a.i;

import android.content.Context;
import android.text.TextUtils;
import d.r.a.h$j;
import d.r.a.h$t;
import d.r.a.i.d$a;
import d.r.a.l;
import d.r.a.n;
import d.r.a.o;

public final class d
extends d.r.a.i.o {
    public d(o o10) {
        super(o10);
    }

    public static /* synthetic */ Context d(d d10) {
        return d10.a;
    }

    public static /* synthetic */ Context e(d d10) {
        return d10.a;
    }

    public final void a(o o10) {
        o10 = (h$j)o10;
        String string2 = ((h$j)o10).g;
        Object object = l.b();
        String string3 = ((h$t)o10).c;
        int n10 = ((h$t)o10).d;
        int n11 = 1;
        Object[] objectArray = new Object[n11];
        objectArray[0] = string2;
        ((l)object).h(string3, n10, objectArray);
        object = ((h$t)o10).c;
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2 && !(bl2 = TextUtils.isEmpty((CharSequence)string2))) {
            object = l.b();
            ((l)object).f(string2);
        }
        object = new d$a(this, string2, (h$j)o10);
        n.c((Runnable)object);
    }
}

