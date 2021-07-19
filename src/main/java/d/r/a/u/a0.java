/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.u;

import android.content.Context;
import d.r.a.u.f;

public final class a0
extends f {
    private static a0 h;

    public static a0 m() {
        Class<a0> clazz = a0.class;
        synchronized (clazz) {
            a0 a02 = h;
            if (a02 == null) {
                h = a02 = new a0();
            }
            a02 = h;
            return a02;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void l(Context context) {
        synchronized (this) {
            Context context2 = this.a;
            if (context2 == null) {
                this.a = context;
                String string2 = "com.vivo.push_preferences";
                this.c(context, string2);
            }
            return;
        }
    }
}

