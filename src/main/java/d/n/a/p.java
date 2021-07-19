/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a;

import android.content.Context;
import c.a.l.e;
import c.b.a.c;
import d.n.a.b$d;

public final class p
implements e {
    private final c a;
    private final c b;

    public p(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static p a(c c10, c c11) {
        p p10 = new p(c10, c11);
        return p10;
    }

    public static boolean c(Context context, int n10) {
        return b$d.s(context, n10);
    }

    public Boolean b() {
        Context context = (Context)this.a.get();
        int n10 = (Integer)this.b.get();
        return b$d.s(context, n10);
    }
}

