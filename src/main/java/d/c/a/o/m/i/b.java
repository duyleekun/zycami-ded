/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package d.c.a.o.m.i;

import android.content.Context;
import android.content.res.Resources;
import d.c.a.o.f;
import d.c.a.o.k.s;
import d.c.a.o.m.d.x;
import d.c.a.o.m.i.e;
import d.c.a.u.k;

public class b
implements e {
    private final Resources a;

    public b(Context context) {
        context = context.getResources();
        this((Resources)context);
    }

    public b(Resources resources) {
        this.a = resources = (Resources)k.d(resources);
    }

    public b(Resources resources, d.c.a.o.k.x.e e10) {
        this(resources);
    }

    public s a(s s10, f f10) {
        return x.d(this.a, s10);
    }
}

