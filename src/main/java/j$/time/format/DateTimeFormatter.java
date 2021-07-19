/*
 * Decompiled with CFR 0.151.
 */
package j$.time.format;

import j$.time.c;
import j$.time.format.A;
import j$.time.format.B;
import j$.time.format.e;
import j$.time.format.t;
import j$.time.format.v;
import j$.time.format.z;
import j$.time.k;
import j$.time.p.j;
import j$.time.q.h;
import j$.time.q.q;
import j$.time.q.s;
import j$.time.q.u;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public final class DateTimeFormatter {
    public static final DateTimeFormatter f;
    private final e a;
    private final Locale b;
    private final j.z c;
    private final j d;
    private final k e;

    static {
        Object object = new t();
        Enum enum_ = h.E;
        Object object2 = B.d;
        int n10 = 10;
        object = ((t)object).p((u)((Object)enum_), 4, n10, (B)((Object)object2));
        char c10 = '-';
        ((t)object).e(c10);
        h h10 = h.B;
        char c11 = '\u0002';
        ((t)object).o(h10, c11);
        ((t)object).e(c10);
        h h11 = h.w;
        ((t)object).o(h11, c11);
        Object object3 = A.a;
        Serializable serializable = j$.time.p.k.a;
        object = ((t)object).x((A)((Object)object3), (j)((Object)serializable));
        Object object4 = new t();
        ((t)object4).t();
        ((t)object4).a((DateTimeFormatter)object);
        ((t)object4).i();
        ((t)object4).x((A)((Object)object3), (j)((Object)serializable));
        object4 = new t();
        ((t)object4).t();
        ((t)object4).a((DateTimeFormatter)object);
        ((t)object4).s();
        ((t)object4).i();
        ((t)object4).x((A)((Object)object3), (j)((Object)serializable));
        object4 = new t();
        h h12 = h.q;
        ((t)object4).o(h12, c11);
        char c12 = ':';
        ((t)object4).e(c12);
        h h13 = h.m;
        ((t)object4).o(h13, c11);
        ((t)object4).s();
        ((t)object4).e(c12);
        h h14 = h.k;
        ((t)object4).o(h14, c11);
        ((t)object4).s();
        Object object5 = h.e;
        int n11 = 1;
        ((t)object4).b((u)object5, 0, 9, n11 != 0);
        Object object6 = ((t)object4).x((A)((Object)object3), null);
        object4 = new t();
        ((t)object4).t();
        ((t)object4).a((DateTimeFormatter)object6);
        ((t)object4).i();
        ((t)object4).x((A)((Object)object3), null);
        object4 = new t();
        ((t)object4).t();
        ((t)object4).a((DateTimeFormatter)object6);
        ((t)object4).s();
        ((t)object4).i();
        ((t)object4).x((A)((Object)object3), null);
        object4 = new t();
        ((t)object4).t();
        ((t)object4).a((DateTimeFormatter)object);
        ((t)object4).e('T');
        ((t)object4).a((DateTimeFormatter)object6);
        object = ((t)object4).x((A)((Object)object3), (j)((Object)serializable));
        object6 = new t();
        ((t)object6).t();
        ((t)object6).a((DateTimeFormatter)object);
        ((t)object6).i();
        object6 = ((t)object6).x((A)((Object)object3), (j)((Object)serializable));
        object4 = new t();
        ((t)object4).a((DateTimeFormatter)object6);
        ((t)object4).s();
        c11 = '[';
        ((t)object4).e(c11);
        ((t)object4).u();
        ((t)object4).q();
        c12 = ']';
        ((t)object4).e(c12);
        ((t)object4).x((A)((Object)object3), (j)((Object)serializable));
        object4 = new t();
        ((t)object4).a((DateTimeFormatter)object);
        ((t)object4).s();
        ((t)object4).i();
        ((t)object4).s();
        ((t)object4).e(c11);
        ((t)object4).u();
        ((t)object4).q();
        ((t)object4).e(c12);
        ((t)object4).x((A)((Object)object3), (j)((Object)serializable));
        object = new t();
        ((t)object).t();
        object = ((t)object).p((u)((Object)enum_), 4, n10, (B)((Object)object2));
        ((t)object).e('-');
        object6 = h.x;
        ((t)object).o((u)object6, 3);
        ((t)object).s();
        ((t)object).i();
        ((t)object).x((A)((Object)object3), (j)((Object)serializable));
        object = new t();
        ((t)object).t();
        object6 = q.c;
        object = ((t)object).p((u)object6, 4, n10, (B)((Object)object2));
        ((t)object).f("-W");
        object2 = q.b;
        ((t)object).o((u)object2, 2);
        ((t)object).e('-');
        object2 = h.t;
        ((t)object).o((u)object2, n11);
        ((t)object).s();
        ((t)object).i();
        ((t)object).x((A)((Object)object3), (j)((Object)serializable));
        object = new t();
        ((t)object).t();
        ((t)object).c();
        f = ((t)object).x((A)((Object)object3), null);
        object = new t();
        ((t)object).t();
        ((t)object).o((u)((Object)enum_), 4);
        n10 = 2;
        ((t)object).o(h10, n10);
        ((t)object).o(h11, n10);
        ((t)object).s();
        ((t)object).h("+HHMMss", "Z");
        ((t)object).x((A)((Object)object3), (j)((Object)serializable));
        object = new HashMap();
        Long l10 = 1L;
        ((HashMap)object).put(l10, "Mon");
        Long l11 = 2;
        ((HashMap)object).put(l11, "Tue");
        object6 = (long)3;
        ((HashMap)object).put(object6, "Wed");
        object3 = Long.valueOf(4);
        ((HashMap)object).put(object3, "Thu");
        object4 = (long)5;
        ((HashMap)object).put(object4, "Fri");
        object5 = (long)6;
        ((HashMap)object).put(object5, "Sat");
        Object object7 = (long)7;
        j$.time.p.k k10 = serializable;
        ((HashMap)object).put(object7, "Sun");
        serializable = new HashMap();
        ((HashMap)serializable).put(l10, "Jan");
        ((HashMap)serializable).put(l11, "Feb");
        ((HashMap)serializable).put(object6, "Mar");
        ((HashMap)serializable).put(object3, "Apr");
        ((HashMap)serializable).put(object4, "May");
        ((HashMap)serializable).put(object5, "Jun");
        ((HashMap)serializable).put(object7, "Jul");
        object7 = (long)8;
        ((HashMap)serializable).put(object7, "Aug");
        object7 = (long)9;
        ((HashMap)serializable).put(object7, "Sep");
        object7 = (long)10;
        ((HashMap)serializable).put(object7, "Oct");
        object7 = (long)11;
        ((HashMap)serializable).put(object7, "Nov");
        object7 = (long)12;
        ((HashMap)serializable).put(object7, "Dec");
        object7 = new t();
        ((t)object7).t();
        ((t)object7).v();
        ((t)object7).s();
        ((t)object7).l((u)object2, (Map)object);
        ((t)object7).f(", ");
        ((t)object7).r();
        object = B.c;
        n10 = 2;
        object = ((t)object7).p(h11, 1, n10, (B)((Object)object));
        char c13 = ' ';
        ((t)object).e(c13);
        ((t)object).l(h10, (Map)((Object)serializable));
        ((t)object).e(c13);
        ((t)object).o((u)((Object)enum_), 4);
        ((t)object).e(c13);
        ((t)object).o(h12, n10);
        char c14 = ':';
        ((t)object).e(c14);
        ((t)object).o(h13, n10);
        ((t)object).s();
        ((t)object).e(c14);
        enum_ = h14;
        ((t)object).o(h14, n10);
        ((t)object).r();
        ((t)object).e(c13);
        ((t)object).h("+HHMM", "GMT");
        enum_ = A.b;
        object2 = k10;
        ((t)object).x((A)enum_, k10);
    }

    DateTimeFormatter(e e10, Locale locale, j.z z10, A a10, Set set, j j10, k k10) {
        this.a = e10;
        this.b = locale;
        this.c = z10;
        Objects.requireNonNull(a10, "resolverStyle");
        this.d = j10;
        this.e = null;
    }

    public static DateTimeFormatter ofPattern(String string2) {
        t t10 = new t();
        t10.j(string2);
        return t10.w();
    }

    public String a(s object) {
        Object object2;
        int n10 = 32;
        Serializable serializable = new StringBuilder(n10);
        try {
            object2 = new v((s)object, this);
            object = this.a;
        }
        catch (IOException iOException) {
            object2 = iOException.getMessage();
            serializable = new c((String)object2, iOException);
            throw serializable;
        }
        ((e)object).m((v)object2, (StringBuilder)serializable);
        return ((StringBuilder)serializable).toString();
    }

    public j b() {
        return this.d;
    }

    public j.z c() {
        return this.c;
    }

    public Locale d() {
        return this.b;
    }

    public k e() {
        return this.e;
    }

    e f(boolean bl2) {
        return this.a.a(bl2);
    }

    public String toString() {
        String string2;
        String string3 = this.a.toString();
        int n10 = string3.startsWith(string2 = "[");
        if (n10 == 0) {
            n10 = string3.length();
            int n11 = 1;
            string3 = string3.substring(n11, n10 -= n11);
        }
        return string3;
    }
}

