/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package d.c.a.o.m.d;

import android.content.Context;
import android.content.res.Resources;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.x;
import d.c.a.u.k;

public class a
implements g {
    private final g a;
    private final Resources b;

    public a(Context context, g g10) {
        context = context.getResources();
        this((Resources)context, g10);
    }

    public a(Resources object, g g10) {
        this.b = object = (Resources)k.d(object);
        object = (g)k.d(g10);
        this.a = object;
    }

    public a(Resources resources, e e10, g g10) {
        this(resources, g10);
    }

    public boolean a(Object object, f f10) {
        return this.a.a(object, f10);
    }

    public s b(Object object, int n10, int n11, f f10) {
        object = this.a.b(object, n10, n11, f10);
        return x.d(this.b, (s)object);
    }
}

