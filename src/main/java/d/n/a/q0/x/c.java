/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a.q0.x;

import android.content.Context;
import c.a.l.e;
import d.n.a.q0.x.b;

public final class c
implements e {
    private final c.b.a.c a;

    public c(c.b.a.c c10) {
        this.a = c10;
    }

    public static c a(c.b.a.c c10) {
        c c11 = new c(c10);
        return c11;
    }

    public b b() {
        Context context = (Context)this.a.get();
        b b10 = new b(context);
        return b10;
    }
}

