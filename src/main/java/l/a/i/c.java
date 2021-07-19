/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package l.a.i;

import android.content.Context;
import l.a.i.d.a;

public class c {
    private static volatile c a;

    private c(Context object) {
        object = l.a.c.w((Context)object);
        a a10 = new a();
        ((l.a.c)object).l(a10);
    }

    public static c a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static c b(Context context) {
        Object object = a;
        if (object != null) return a;
        object = c.class;
        synchronized (object) {
            c c10 = a;
            if (c10 != null) return a;
            a = c10 = new c(context);
            return a;
        }
    }
}

