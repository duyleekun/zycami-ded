/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o;

import d.c.a.o.c;
import d.c.a.o.e$a;
import d.c.a.o.e$b;
import d.c.a.u.k;
import java.nio.charset.Charset;
import java.security.MessageDigest;

public final class e {
    private static final e$b e;
    private final Object a;
    private final e$b b;
    private final String c;
    private volatile byte[] d;

    static {
        e$a e$a = new e$a();
        e = e$a;
    }

    private e(String object, Object object2, e$b e$b) {
        object = k.b((String)object);
        this.c = object;
        this.a = object2;
        this.b = object = (e$b)k.d(e$b);
    }

    public static e a(String string2, e$b e$b) {
        e e10 = new e(string2, null, e$b);
        return e10;
    }

    public static e b(String string2, Object object, e$b e$b) {
        e e10 = new e(string2, object, e$b);
        return e10;
    }

    private static e$b c() {
        return e;
    }

    private byte[] e() {
        Object object = this.d;
        if (object == null) {
            object = this.c;
            Charset charset = d.c.a.o.c.b;
            this.d = object = (Object)object.getBytes(charset);
        }
        return this.d;
    }

    public static e f(String string2) {
        e$b e$b = d.c.a.o.e.c();
        e e10 = new e(string2, null, e$b);
        return e10;
    }

    public static e g(String string2, Object object) {
        e$b e$b = d.c.a.o.e.c();
        e e10 = new e(string2, object, e$b);
        return e10;
    }

    public Object d() {
        return this.a;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof e;
        if (bl2) {
            object = (e)object;
            String string2 = this.c;
            object = ((e)object).c;
            return string2.equals(object);
        }
        return false;
    }

    public void h(Object object, MessageDigest messageDigest) {
        e$b e$b = this.b;
        byte[] byArray = this.e();
        e$b.a(byArray, object, messageDigest);
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Option{key='");
        String string2 = this.c;
        stringBuilder.append(string2);
        stringBuilder.append('\'');
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

