/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package d.j.a.f.c;

import android.content.Context;
import android.text.TextUtils;
import d.j.a.b;
import d.j.a.c;
import d.j.a.d;
import java.util.HashMap;
import java.util.Map;

public class a
extends d.j.a.a {
    private static final Map b;
    private static final Object c;
    private static String d;
    private d.j.a.f.a a;

    static {
        Object object = new HashMap();
        b = object;
        c = object = new Object();
    }

    private a(Context object, String string2) {
        object = d.j.a.f.a.b(object, string2);
        this.a = object;
    }

    public static d.j.a.a a() {
        return d.j.a.f.c.a.b(d);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d.j.a.a b(String object) {
        Object object2 = c;
        synchronized (object2) {
            Object object3 = b;
            object = object3.get(object);
            object = (d.j.a.a)object;
            if (object != null) {
                return object;
            }
            object3 = "you should call AGConnectApp.initialize first";
            object = new IllegalStateException((String)object3);
            throw object;
        }
    }

    public static d.j.a.a c(Context context) {
        Object object = context.getApplicationContext();
        if (object != null) {
            context = object;
        }
        object = context.getPackageName();
        d = object;
        return d.j.a.f.c.a.d(context, (String)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static d.j.a.a d(Context object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            object = new IllegalArgumentException("packageName can not be empty");
            throw object;
        }
        Object object2 = c;
        synchronized (object2) {
            Map map = b;
            Object object3 = map.get(string2);
            object3 = (d.j.a.a)object3;
            if (object3 == null) {
                a a10 = new a((Context)object, string2);
                map.put(string2, a10);
            }
            return object3;
        }
    }

    public void e(String string2) {
        this.a.k("/client/api_key", string2);
    }

    public void f(String string2) {
        this.a.k("/client/client_id", string2);
    }

    public void g(String string2) {
        this.a.k("/client/client_secret", string2);
    }

    public void h(c c10) {
        ((d.j.a.g.d.a)d.j.a.b.b()).e(c10);
    }

    public void i(d d10) {
        ((d.j.a.g.d.a)d.j.a.b.b()).f(d10);
    }

    public void j(String object, String string2) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (!bl2) {
            this.a.k((String)object, string2);
            return;
        }
        object = new IllegalArgumentException("path can not be empty");
        throw object;
    }
}

