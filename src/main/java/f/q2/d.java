/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import java.nio.charset.Charset;

public final class d {
    public static final Charset a;
    public static final Charset b;
    public static final Charset c;
    public static final Charset d;
    public static final Charset e;
    public static final Charset f;
    private static Charset g;
    private static Charset h;
    private static Charset i;
    public static final d j;

    static {
        Object object = new d();
        j = object;
        object = Charset.forName("UTF-8");
        f0.o(object, "Charset.forName(\"UTF-8\")");
        a = object;
        object = Charset.forName("UTF-16");
        f0.o(object, "Charset.forName(\"UTF-16\")");
        b = object;
        object = Charset.forName("UTF-16BE");
        f0.o(object, "Charset.forName(\"UTF-16BE\")");
        c = object;
        object = Charset.forName("UTF-16LE");
        f0.o(object, "Charset.forName(\"UTF-16LE\")");
        d = object;
        object = Charset.forName("US-ASCII");
        f0.o(object, "Charset.forName(\"US-ASCII\")");
        e = object;
        object = Charset.forName("ISO-8859-1");
        f0.o(object, "Charset.forName(\"ISO-8859-1\")");
        f = object;
    }

    private d() {
    }

    public final Charset a() {
        Charset charset = g;
        if (charset == null) {
            charset = Charset.forName("UTF-32");
            String string2 = "Charset.forName(\"UTF-32\")";
            f0.o(charset, string2);
            g = charset;
        }
        return charset;
    }

    public final Charset b() {
        Charset charset = i;
        if (charset == null) {
            charset = Charset.forName("UTF-32BE");
            String string2 = "Charset.forName(\"UTF-32BE\")";
            f0.o(charset, string2);
            i = charset;
        }
        return charset;
    }

    public final Charset c() {
        Charset charset = h;
        if (charset == null) {
            charset = Charset.forName("UTF-32LE");
            String string2 = "Charset.forName(\"UTF-32LE\")";
            f0.o(charset, string2);
            h = charset;
        }
        return charset;
    }
}

