/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.n.a.q0.x;

import android.content.Context;
import c.a.l.e;
import c.b.a.c;
import d.n.a.q0.x.p;
import d.n.a.q0.x.r;

public final class q
implements e {
    private final c a;
    private final c b;

    public q(c c10, c c11) {
        this.a = c10;
        this.b = c11;
    }

    public static q a(c c10, c c11) {
        q q10 = new q(c10, c11);
        return q10;
    }

    public static p c(Context context, r r10) {
        p p10 = new p(context, r10);
        return p10;
    }

    public p b() {
        Context context = (Context)this.a.get();
        r r10 = (r)this.b.get();
        p p10 = new p(context, r10);
        return p10;
    }
}

