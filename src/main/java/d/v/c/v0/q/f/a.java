/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.q.f;

import d.v.c.v0.l.i;
import k.d;

public class a {
    private static volatile a a;

    private a() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a a() {
        Object object = a;
        if (object != null) return a;
        object = a.class;
        synchronized (object) {
            a a10 = a;
            if (a10 != null) return a;
            a = a10 = new a();
            return a;
        }
    }

    public d b(long l10) {
        return i.a.c(l10);
    }
}

