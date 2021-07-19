/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package d.j.b.a.b.d;

import android.util.Log;
import d.j.b.a.b.d.a;

public class b {
    public static final b b;
    private boolean a;

    static {
        b b10;
        b = b10 = new b();
    }

    private b() {
        String string2 = "com.huawei.appgallery.log.LogAdaptor";
        Class.forName(string2);
        boolean bl2 = true;
        try {
            this.a = bl2;
        }
        catch (ClassNotFoundException classNotFoundException) {
            bl2 = false;
            string2 = null;
            this.a = false;
        }
    }

    public void a(String string2, String string3) {
        boolean bl2 = this.a;
        if (bl2) {
            a a10 = d.j.b.a.b.d.a.a;
            a10.e(string2, string3);
        } else {
            Log.e((String)string2, (String)string3);
        }
    }

    public void b(String string2, String string3, Throwable throwable) {
        boolean bl2 = this.a;
        if (bl2) {
            a a10 = d.j.b.a.b.d.a.a;
            a10.e(string2, string3, throwable);
        } else {
            Log.e((String)string2, (String)string3, (Throwable)throwable);
        }
    }

    public void c(String string2, String string3) {
        boolean bl2 = this.a;
        if (bl2) {
            a a10 = d.j.b.a.b.d.a.a;
            a10.w(string2, string3);
        } else {
            Log.w((String)string2, (String)string3);
        }
    }
}

