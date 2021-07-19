/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package l.a.o;

import android.content.Context;
import android.content.SharedPreferences;

public class e {
    private static final String d = "meta-data";
    private static final String e = "skin-name";
    private static final String f = "skin-strategy";
    private static final String g = "skin-user-theme-json";
    private static e h;
    private final Context a;
    private final SharedPreferences b;
    private final SharedPreferences.Editor c;

    private e(Context context) {
        this.a = context;
        context = context.getSharedPreferences(d, 0);
        this.b = context;
        context = context.edit();
        this.c = context;
    }

    public static e b() {
        return h;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void f(Context context) {
        Object object = h;
        if (object != null) return;
        object = e.class;
        synchronized (object) {
            e e10 = h;
            if (e10 != null) return;
            context = context.getApplicationContext();
            h = e10 = new e(context);
            return;
        }
    }

    public void a() {
        this.c.apply();
    }

    public String c() {
        return this.b.getString(e, "");
    }

    public int d() {
        return this.b.getInt(f, -1);
    }

    public String e() {
        return this.b.getString(g, "");
    }

    public e g(String string2) {
        this.c.putString(e, string2);
        return this;
    }

    public e h(int n10) {
        this.c.putInt(f, n10);
        return this;
    }

    public e i(String string2) {
        this.c.putString(g, string2);
        return this;
    }
}

