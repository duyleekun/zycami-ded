/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.u;

import android.content.Context;
import d.r.a.u.a;
import d.r.a.u.b;
import d.r.a.u.l;
import d.r.a.u.m;

public class e {
    private static a a;
    private static b b;
    private static String c = "com.vivo.push.util.NotifyDataAdapter";
    private static String d = "com.vivo.push.util.NotifyLayoutAdapter";

    public static a a(Context context) {
        e.d(context);
        return a;
    }

    public static b b(Context context) {
        e.d(context);
        return b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static Object c(String clazz, Object object) {
        Object var2_2 = null;
        try {
            clazz = Class.forName(clazz);
        }
        catch (Exception exception) {
            clazz = null;
        }
        if (clazz != null) {
            try {
                var2_2 = clazz.newInstance();
            }
            catch (Exception exception) {}
        }
        if (var2_2 != null) return var2_2;
        return object;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private static void d(Context context) {
        Class<e> clazz = e.class;
        synchronized (clazz) {
            Object object;
            Object object2 = a;
            if (object2 == null) {
                object2 = c;
                object = new l();
                object2 = e.c((String)object2, object);
                a = object2 = (a)object2;
                object2.a(context);
            }
            if ((object2 = b) == null) {
                object2 = d;
                object = new m();
                object2 = e.c((String)object2, object);
                b = object2 = (b)object2;
                object2.a(context);
            }
            return;
        }
    }
}

