/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.Log
 */
package d.j.a;

import android.content.Context;
import android.util.Log;
import d.j.a.f.c.a;

public abstract class b {
    private static b a;

    public static b b() {
        return a;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void d(Context object) {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            Object object2 = "AGConnectInstance";
            String string2 = "AGConnectInstance#initialize";
            Log.i((String)object2, (String)string2);
            d.j.a.f.c.a.c(object);
            object2 = object.getApplicationContext();
            if (object2 != null) {
                String string3 = object2;
            }
            object2 = a;
            if (object2 == null) {
                void var0_2;
                a = object2 = new d.j.a.g.d.a((Context)var0_2);
            }
            return;
        }
    }

    public abstract Context a();

    public abstract Object c(Class var1);
}

