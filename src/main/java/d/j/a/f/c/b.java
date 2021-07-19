/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.j.a.f.c;

import android.content.Context;
import d.j.a.f.a;
import d.j.a.f.c.b$a;
import d.j.a.f.c.c;
import d.j.a.f.c.e;
import d.j.a.f.c.h;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class b
extends a {
    private final Context c;
    private final String d;
    private d.j.a.f.b e;
    private volatile c f;
    private final Object g;
    private Map h;

    public b(Context context, String string2) {
        HashMap hashMap = new HashMap();
        this.g = hashMap;
        this.h = hashMap = new HashMap();
        this.c = context;
        this.d = string2;
    }

    private static d.j.a.f.b l(Context context, InputStream inputStream) {
        b$a b$a = new b$a(context, inputStream);
        return b$a;
    }

    private static String m(String string2) {
        int c10 = string2.length();
        char c11 = '/';
        int n10 = 0;
        if (c10 > 0) {
            char c12;
            while ((c12 = string2.charAt(n10)) == c11) {
                ++n10;
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(c11);
        string2 = string2.substring(n10);
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public boolean c(String string2) {
        return this.d(string2, false);
    }

    public boolean d(String string2, boolean bl2) {
        String string3 = String.valueOf(bl2);
        return Boolean.parseBoolean(this.h(string2, string3));
    }

    public int e(String string2) {
        return this.f(string2, 0);
    }

    public int f(String string2, int n10) {
        String string3;
        try {
            string3 = String.valueOf(n10);
        }
        catch (NumberFormatException numberFormatException) {
            return n10;
        }
        string2 = this.h(string2, string3);
        return Integer.parseInt(string2);
    }

    public String g(String string2) {
        return this.h(string2, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public String h(String string2, String string3) {
        boolean bl2;
        Objects.requireNonNull(string2, "path must not be null.");
        Object object = this.f;
        if (object == null) {
            object = this.g;
            synchronized (object) {
                Object object2 = this.f;
                if (object2 == null) {
                    object2 = this.e;
                    if (object2 != null) {
                        object2 = ((d.j.a.f.b)object2).c();
                        e e10 = new e((InputStream)object2);
                        this.f = e10;
                        object2 = this.e;
                        ((d.j.a.f.b)object2).a();
                        object2 = null;
                        this.e = null;
                    } else {
                        Context context = this.c;
                        String string4 = this.d;
                        this.f = object2 = new h(context, string4);
                    }
                }
            }
        }
        if (!(bl2 = (object = this.h).containsKey(string2 = b.m(string2)))) {
            return this.f.a(string2, string3);
        }
        object = this.h.get(string2);
        if (object == null) return string3;
        string3 = string2 = this.h.get(string2);
        return string2;
    }

    public void i(d.j.a.f.b b10) {
        this.e = b10;
    }

    public void j(InputStream object) {
        object = b.l(this.c, (InputStream)object);
        this.i((d.j.a.f.b)object);
    }

    public void k(String string2, String string3) {
        this.h.put(string2, string3);
    }
}

