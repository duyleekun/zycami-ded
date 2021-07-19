/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.r.a.u;

import android.content.Context;
import d.r.a.u.b0;
import d.r.a.u.h;
import d.r.a.u.s;
import d.r.a.u.y;
import d.r.a.u.z;
import java.util.HashMap;

public final class c0
implements h {
    private static final HashMap d;
    private static final HashMap e;
    private static final HashMap f;
    private static c0 g;
    public Context a;
    private h b;
    private boolean c = false;

    static {
        HashMap hashMap;
        d = hashMap = new HashMap();
        e = hashMap = new HashMap();
        f = hashMap = new HashMap();
    }

    private c0(Context object) {
        boolean bl2;
        this.a = object;
        this.c = bl2 = this.a((Context)object);
        super("init status is ");
        boolean bl3 = this.c;
        ((StringBuilder)object).append(bl3);
        ((StringBuilder)object).append(";  curCache is ");
        h h10 = this.b;
        ((StringBuilder)object).append(h10);
        object = ((StringBuilder)object).toString();
        s.m("SystemCache", (String)object);
    }

    public static c0 c(Context object) {
        Class<c0> clazz = c0.class;
        synchronized (clazz) {
            c0 c02 = g;
            if (c02 == null) {
                object = object.getApplicationContext();
                g = c02 = new c0((Context)object);
            }
            object = g;
            return object;
        }
    }

    public final String a(String string2, String string3) {
        h h10;
        String string4 = (String)f.get(string2);
        if (string4 == null && (h10 = this.b) != null) {
            return h10.a(string2, string3);
        }
        return string4;
    }

    public final boolean a(Context context) {
        h h10;
        this.b = h10 = new z();
        boolean bl2 = h10.a(context);
        if (!bl2) {
            this.b = h10 = new y();
            bl2 = h10.a(context);
        }
        if (!bl2) {
            this.b = h10 = new b0();
            bl2 = h10.a(context);
        }
        if (!bl2) {
            context = null;
            this.b = null;
        }
        return bl2;
    }

    public final void b(String string2, String string3) {
        Object object = f;
        ((HashMap)object).put(string2, string3);
        boolean bl2 = this.c;
        if (bl2 && (object = this.b) != null) {
            object.b(string2, string3);
        }
    }
}

