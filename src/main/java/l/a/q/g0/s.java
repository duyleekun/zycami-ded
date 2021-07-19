/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package l.a.q.g0;

import android.content.Context;
import l.a.q.g0.p;
import l.a.q.g0.q;
import l.a.q.g0.q$a;

public class s {
    private static volatile s a;

    private s() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static s a() {
        Object object = a;
        if (object != null) return a;
        object = s.class;
        synchronized (object) {
            s s10 = a;
            if (s10 != null) return a;
            a = s10 = new s();
            return a;
        }
    }

    public void b(Context context, String string2, q$a q$a) {
        q q10 = new q();
        q10.b(context, string2, q$a);
    }

    public void c(String string2) {
        p.p(string2);
    }
}

