/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.f.a.a.j.o;

import android.content.Context;

public class e {
    private static Context a;

    public static Context a() {
        return a;
    }

    public static void b(Context context) {
        Context context2;
        if (context != null && (context2 = a) == null) {
            a = context = context.getApplicationContext();
        }
    }
}

