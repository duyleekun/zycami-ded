/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.o.a.a.b.b;

import android.content.Context;
import com.quvideo.mobile.external.platform.httpcore.provider.OooO00o;
import com.quvideo.mobile.external.platform.httpcore.provider.OooO0O0;
import d.o.a.a.b.b.b;

public class a {
    public static boolean f = false;
    private static volatile a g;
    private volatile boolean a = false;
    private b b;
    private Context c;
    private OooO0O0 d;
    private OooO00o e;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static a g() {
        Object object = g;
        if (object != null) return g;
        object = a.class;
        synchronized (object) {
            a a10 = g;
            if (a10 != null) return g;
            g = a10 = new a();
            return g;
        }
    }

    public OooO00o a() {
        return this.e;
    }

    public Object b(Class clazz, String string2, boolean bl2) {
        return this.b.a(clazz, string2, bl2);
    }

    public void c(Context object, OooO0O0 oooO0O0) {
        boolean bl2 = this.a;
        if (bl2) {
            return;
        }
        this.a = true;
        this.c = object;
        f = oooO0O0.OooO00o;
        this.d = oooO0O0;
        object = new b();
        this.b = object;
    }

    public void d(OooO00o oooO00o) {
        this.e = oooO00o;
    }

    public OooO0O0 e() {
        return this.d;
    }

    public Context f() {
        return this.c;
    }
}

