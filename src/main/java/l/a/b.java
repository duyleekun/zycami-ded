/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package l.a;

import android.content.Context;
import l.a.e.c;

public class b {
    private static volatile b a;

    private b(Context object) {
        object = l.a.c.w((Context)object);
        c c10 = new c();
        ((l.a.c)object).l(c10);
    }

    public static b a() {
        return a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static b b(Context context) {
        Object object = a;
        if (object != null) return a;
        object = b.class;
        synchronized (object) {
            b b10 = a;
            if (b10 != null) return a;
            a = b10 = new b(context);
            return a;
        }
    }
}

