/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 */
package d.v.n.l;

import android.content.Context;
import android.content.SharedPreferences;
import d.v.e.f;

public class e {
    private static final String b = "SP_SAVE_LIVE";
    public static final String c = "SP_LIVE_LOGIN_WEB";
    private static volatile e d;
    private final SharedPreferences a;

    private e(Context context, String string2) {
        context = context.getSharedPreferences(string2, 0);
        this.a = context;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static e d() {
        Object object = d;
        if (object != null) return d;
        object = e.class;
        synchronized (object) {
            e e10 = d;
            if (e10 != null) return d;
            f f10 = f.a();
            f10 = f10.b();
            String string2 = b;
            d = e10 = new e((Context)f10, string2);
            return d;
        }
    }

    public void a() {
        SharedPreferences.Editor editor = this.a.edit();
        editor.clear();
        editor.apply();
    }

    public void b(String string2) {
        SharedPreferences.Editor editor = this.a.edit();
        editor.remove(string2);
        editor.apply();
    }

    public boolean c(String string2, Boolean bl2) {
        SharedPreferences sharedPreferences = this.a;
        boolean bl3 = bl2;
        return sharedPreferences.getBoolean(string2, bl3);
    }

    public void e(String string2, Boolean bl2) {
        SharedPreferences.Editor editor = this.a.edit();
        boolean bl3 = bl2;
        editor.putBoolean(string2, bl3);
        editor.apply();
    }
}

