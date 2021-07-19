/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package d.j.f.a.a.h.f;

import android.os.Build;
import d.j.f.a.a.h.f.a;
import d.j.f.a.a.h.f.c;
import d.j.f.a.a.h.f.g;

public class d {
    private static final String b = "d";
    private byte[] a = null;

    private d() {
    }

    private void a(String string2, String string3, String string4, String object) {
        object = c.c((String)object);
        this.b(string2, string3, string4, (byte[])object);
    }

    private void b(String object, String string2, String string3, byte[] byArray) {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 26;
        if (n10 < n11) {
            String string4 = b;
            String string5 = "initRootKey: sha1";
            g.d(string4, string5);
            n10 = 0;
            string4 = null;
            object = d.j.f.a.a.h.f.a.h((String)object, string2, string3, byArray, false);
            this.a = (byte[])object;
        } else {
            String string6 = b;
            String string7 = "initRootKey: sha256";
            g.d(string6, string7);
            n10 = 1;
            object = d.j.f.a.a.h.f.a.h((String)object, string2, string3, byArray, n10 != 0);
            this.a = (byte[])object;
        }
    }

    public static d e(String string2, String string3, String string4, String string5) {
        d d10 = new d();
        d10.a(string2, string3, string4, string5);
        return d10;
    }

    public static d f(String string2, String string3, String string4, byte[] byArray) {
        d d10 = new d();
        d10.b(string2, string3, string4, byArray);
        return d10;
    }

    public byte[] c() {
        return (byte[])this.a.clone();
    }

    public String d() {
        return c.b(this.a);
    }
}

