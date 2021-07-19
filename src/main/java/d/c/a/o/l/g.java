/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.text.TextUtils
 */
package d.c.a.o.l;

import android.net.Uri;
import android.text.TextUtils;
import d.c.a.o.c;
import d.c.a.o.l.h;
import d.c.a.u.k;
import java.net.URL;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.Map;

public class g
implements c {
    private static final String j = "@#&=*+-_.,:!?()/~'%;$";
    private final h c;
    private final URL d;
    private final String e;
    private String f;
    private URL g;
    private volatile byte[] h;
    private int i;

    public g(String string2) {
        h h10 = d.c.a.o.l.h.b;
        this(string2, h10);
    }

    public g(String object, h h10) {
        this.d = null;
        object = k.b((String)object);
        this.e = object;
        this.c = object = (h)k.d(h10);
    }

    public g(URL uRL) {
        h h10 = d.c.a.o.l.h.b;
        this(uRL, h10);
    }

    public g(URL object, h h10) {
        object = (URL)k.d(object);
        this.d = object;
        this.e = null;
        this.c = object = (h)k.d(h10);
    }

    private byte[] d() {
        Object object = this.h;
        if (object == null) {
            object = this.c();
            Charset charset = d.c.a.o.c.b;
            this.h = object = (Object)object.getBytes(charset);
        }
        return this.h;
    }

    private String f() {
        String string2 = this.f;
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = this.e;
            boolean bl3 = TextUtils.isEmpty((CharSequence)string2);
            if (bl3) {
                string2 = ((URL)k.d(this.d)).toString();
            }
            String string3 = j;
            this.f = string2 = Uri.encode((String)string2, (String)string3);
        }
        return this.f;
    }

    private URL g() {
        URL uRL = this.g;
        if (uRL == null) {
            String string2 = this.f();
            this.g = uRL = new URL(string2);
        }
        return this.g;
    }

    public void b(MessageDigest messageDigest) {
        byte[] byArray = this.d();
        messageDigest.update(byArray);
    }

    public String c() {
        String string2 = this.e;
        if (string2 == null) {
            string2 = ((URL)k.d(this.d)).toString();
        }
        return string2;
    }

    public Map e() {
        return this.c.a();
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof g;
        boolean bl3 = false;
        if (bl2) {
            boolean bl4;
            String string2;
            object = (g)object;
            Object object2 = this.c();
            bl2 = ((String)object2).equals(string2 = ((g)object).c());
            if (bl2 && (bl4 = (object2 = this.c).equals(object = ((g)object).c))) {
                bl3 = true;
            }
        }
        return bl3;
    }

    public String h() {
        return this.f();
    }

    public int hashCode() {
        int n10 = this.i;
        if (n10 == 0) {
            String string2 = this.c();
            this.i = n10 = string2.hashCode();
            n10 *= 31;
            h h10 = this.c;
            int n11 = h10.hashCode();
            this.i = n10 += n11;
        }
        return this.i;
    }

    public URL i() {
        return this.g();
    }

    public String toString() {
        return this.c();
    }
}

