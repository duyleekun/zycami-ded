/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.SharedPreferences
 *  android.content.SharedPreferences$Editor
 *  android.os.Looper
 *  android.text.TextUtils
 */
package d.r.a.u;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import java.io.Serializable;
import java.util.HashMap;

public class f {
    public Context a;
    private String b;
    private volatile SharedPreferences c;
    private HashMap d;
    private HashMap e;
    private HashMap f;
    private HashMap g;

    public f() {
        HashMap hashMap;
        this.d = hashMap = new HashMap();
        this.e = hashMap = new HashMap();
        this.f = hashMap = new HashMap();
        this.g = hashMap = new HashMap();
    }

    public static void d(SharedPreferences.Editor editor) {
        Looper looper;
        if (editor == null) {
            return;
        }
        Looper looper2 = Looper.myLooper();
        if (looper2 == (looper = Looper.getMainLooper())) {
            editor.apply();
            return;
        }
        editor.commit();
    }

    private void j() {
        Object object = this.c;
        if (object == null) {
            object = this.a;
            if (object != null) {
                String string2 = this.b;
                this.c = object = object.getSharedPreferences(string2, 0);
            } else {
                Throwable throwable = new Throwable();
                object = new RuntimeException("SharedPreferences is not init", throwable);
                throw object;
            }
        }
    }

    public final String a(String string2) {
        String string3 = (String)this.d.get(string2);
        if (string3 != null) {
            return string3;
        }
        this.j();
        Object object = this.c;
        if (object != null) {
            string3 = this.c;
            boolean bl2 = false;
            object = null;
            boolean bl3 = TextUtils.isEmpty((CharSequence)(string3 = string3.getString(string2, null)));
            if (!bl3 && !(bl2 = string3.equals(null))) {
                object = this.d;
                ((HashMap)object).put(string2, string3);
            }
        }
        return string3;
    }

    public final void b() {
        this.e.clear();
        this.f.clear();
        this.g.clear();
        this.d.clear();
        this.j();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            sharedPreferences = this.c.edit();
            sharedPreferences.clear();
            d.r.a.u.f.d((SharedPreferences.Editor)sharedPreferences);
        }
    }

    public final void c(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            this.b = string2;
            string2 = object.getSharedPreferences(string2, 0);
            this.c = string2;
            this.a = object;
            return;
        }
        object = new RuntimeException("sharedFileName can't be null");
        throw object;
    }

    public final void e(String string2, int n10) {
        HashMap hashMap = this.f;
        Integer n11 = n10;
        hashMap.put(string2, n11);
        this.j();
        hashMap = this.c;
        if (hashMap != null) {
            hashMap = this.c.edit();
            hashMap.putInt(string2, n10);
            d.r.a.u.f.d((SharedPreferences.Editor)hashMap);
        }
    }

    public final void f(String string2, long l10) {
        HashMap hashMap = this.e;
        Long l11 = l10;
        hashMap.put(string2, l11);
        this.j();
        hashMap = this.c;
        if (hashMap != null) {
            hashMap = this.c.edit();
            hashMap.putLong(string2, l10);
            d.r.a.u.f.d((SharedPreferences.Editor)hashMap);
        }
    }

    public final void g(String string2, String string3) {
        this.d.put(string2, string3);
        this.j();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            sharedPreferences = this.c.edit();
            sharedPreferences.putString(string2, string3);
            d.r.a.u.f.d((SharedPreferences.Editor)sharedPreferences);
        }
    }

    public final int h(String string2) {
        int n10;
        boolean bl2;
        Integer n11 = (Integer)this.f.get(string2);
        if (n11 != null) {
            return n11;
        }
        this.j();
        Object object = this.c;
        if (object != null && !(bl2 = (n11 = Integer.valueOf(n10 = this.c.getInt(string2, 0))).equals(object = Integer.valueOf(0)))) {
            object = this.f;
            ((HashMap)object).put(string2, n11);
        }
        return n11;
    }

    public final long i(String string2, long l10) {
        Serializable serializable;
        long l11;
        boolean bl2;
        Long l12 = (Long)this.e.get(string2);
        if (l12 != null) {
            return l12;
        }
        this.j();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null && !(bl2 = (l12 = Long.valueOf(l11 = this.c.getLong(string2, l10))).equals(serializable = Long.valueOf(l10)))) {
            serializable = this.e;
            ((HashMap)serializable).put(string2, l12);
        }
        return l12;
    }

    public final void k(String string2) {
        this.e.remove(string2);
        this.f.remove(string2);
        this.g.remove(string2);
        this.d.remove(string2);
        this.j();
        SharedPreferences sharedPreferences = this.c;
        if (sharedPreferences != null) {
            sharedPreferences = this.c.edit();
            SharedPreferences sharedPreferences2 = this.c;
            boolean bl2 = sharedPreferences2.contains(string2);
            if (bl2) {
                sharedPreferences.remove(string2);
                d.r.a.u.f.d((SharedPreferences.Editor)sharedPreferences);
            }
        }
    }
}

