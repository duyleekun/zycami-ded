/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.a.f;

import android.content.Context;
import d.j.a.f.b;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public abstract class a {
    private static final Map a;
    private static final Object b;

    static {
        Object object = new HashMap();
        a = object;
        b = object = new Object();
    }

    public static a a(Context context) {
        Object object = context.getApplicationContext();
        if (object != null) {
            context = object;
        }
        object = context.getPackageName();
        return d.j.a.f.a.b(context, (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a b(Context context, String string2) {
        Object object = b;
        synchronized (object) {
            Map map = a;
            Object object2 = map.get(string2);
            object2 = (a)object2;
            if (object2 == null) {
                object2 = new Object(context, string2);
                map.put(string2, object2);
            }
            return object2;
        }
    }

    public abstract boolean c(String var1);

    public abstract boolean d(String var1, boolean var2);

    public abstract int e(String var1);

    public abstract int f(String var1, int var2);

    public abstract String g(String var1);

    public abstract String h(String var1, String var2);

    public abstract void i(b var1);

    public abstract void j(InputStream var1);

    public abstract void k(String var1, String var2);
}

