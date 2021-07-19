/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.l2.i;
import f.l2.q;
import f.q2.u;
import g.h0.j.c;
import g.s;
import g.s$b;
import j$.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class s$a {
    private final List a;

    public s$a() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList(20);
    }

    public final s$a a(String string2) {
        Object object = "line";
        f0.p(string2, (String)object);
        int n10 = 6;
        int n11 = StringsKt__StringsKt.i3(string2, ':', 0, false, n10, null);
        int n12 = 1;
        String string3 = null;
        int n13 = -1;
        n13 = n11 != n13 ? n12 : 0;
        if (n13 != 0) {
            string3 = string2.substring(0, n11);
            f0.o(string3, "(this as java.lang.Strin\u2026ing(startIndex, endIndex)");
            Objects.requireNonNull(string3, "null cannot be cast to non-null type kotlin.CharSequence");
            string3 = ((Object)StringsKt__StringsKt.p5(string3)).toString();
            string2 = string2.substring(n11 += n12);
            f0.o(string2, "(this as java.lang.String).substring(startIndex)");
            this.b(string3, string2);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Unexpected header: ");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        string2 = string2.toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    public final s$a b(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        s$b s$b = s.b;
        s$b.c(s$b, string2);
        s$b.d(s$b, string3, string2);
        this.g(string2, string3);
        return this;
    }

    public final s$a c(String string2, Instant instant) {
        f0.p(string2, "name");
        f0.p(instant, "value");
        long l10 = instant.toEpochMilli();
        Date date = new Date(l10);
        this.d(string2, date);
        return this;
    }

    public final s$a d(String string2, Date object) {
        f0.p(string2, "name");
        f0.p(object, "value");
        object = c.b((Date)object);
        this.b(string2, (String)object);
        return this;
    }

    public final s$a e(s s10) {
        String string2 = "headers";
        f0.p(s10, string2);
        int n10 = s10.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            String string3 = s10.h(i10);
            String string4 = s10.n(i10);
            this.g(string3, string4);
        }
        return this;
    }

    public final s$a f(String string2) {
        String string3 = "line";
        f0.p(string2, string3);
        String string4 = null;
        int n10 = 4;
        String string5 = string2;
        int n11 = StringsKt__StringsKt.i3(string2, ':', 1, false, n10, null);
        string5 = "(this as java.lang.String).substring(startIndex)";
        int n12 = 1;
        int n13 = 0;
        String string6 = null;
        int n14 = -1;
        if (n11 != n14) {
            string6 = string2.substring(0, n11);
            string4 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
            f0.o(string6, string4);
            string2 = string2.substring(n11 += n12);
            f0.o(string2, string5);
            this.g(string6, string2);
        } else {
            n11 = string2.charAt(0);
            n13 = 58;
            string4 = "";
            if (n11 == n13) {
                string2 = string2.substring(n12);
                f0.o(string2, string5);
                this.g(string4, string2);
            } else {
                this.g(string4, string2);
            }
        }
        return this;
    }

    public final s$a g(String object, String string2) {
        f0.p(object, "name");
        f0.p(string2, "value");
        this.a.add(object);
        object = this.a;
        string2 = ((Object)StringsKt__StringsKt.p5(string2)).toString();
        object.add(string2);
        return this;
    }

    public final s$a h(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        s$b.c(s.b, string2);
        this.g(string2, string3);
        return this;
    }

    public final s i() {
        String[] stringArray = this.a;
        String[] stringArray2 = new String[]{};
        stringArray = stringArray.toArray(stringArray2);
        Objects.requireNonNull(stringArray, "null cannot be cast to non-null type kotlin.Array<T>");
        s s10 = new s(stringArray, null);
        return s10;
    }

    public final String j(String object) {
        f0.p(object, "name");
        int n10 = this.a.size();
        int n11 = 2;
        i i10 = q.S0(q.W(n10 - n11, 0), n11);
        n11 = i10.e();
        int n12 = i10.f();
        n10 = i10.g();
        if (n10 >= 0 ? n11 <= n12 : n11 >= n12) {
            while (true) {
                int n13;
                String string2;
                boolean bl2;
                if (bl2 = u.I1((String)object, string2 = (String)this.a.get(n11), (n13 = 1) != 0)) {
                    object = this.a;
                    return (String)object.get(n11 += n13);
                }
                if (n11 == n12) break;
                n11 += n10;
            }
        }
        return null;
    }

    public final List k() {
        return this.a;
    }

    public final s$a l(String string2) {
        Object object;
        int n10;
        f0.p(string2, "name");
        for (int i10 = 0; i10 < (n10 = (object = this.a).size()); i10 += 2) {
            boolean bl2;
            object = (String)this.a.get(i10);
            n10 = (int)(u.I1(string2, (String)object, bl2 = true) ? 1 : 0);
            if (n10 == 0) continue;
            this.a.remove(i10);
            object = this.a;
            object.remove(i10);
            i10 += -2;
        }
        return this;
    }

    public final s$a m(String string2, String string3) {
        f0.p(string2, "name");
        f0.p(string3, "value");
        s$b s$b = s.b;
        s$b.c(s$b, string2);
        s$b.d(s$b, string3, string2);
        this.l(string2);
        this.g(string2, string3);
        return this;
    }

    public final s$a n(String string2, Instant instant) {
        f0.p(string2, "name");
        f0.p(instant, "value");
        long l10 = instant.toEpochMilli();
        Date date = new Date(l10);
        return this.o(string2, date);
    }

    public final s$a o(String string2, Date object) {
        f0.p(string2, "name");
        f0.p(object, "value");
        object = c.b((Date)object);
        this.m(string2, (String)object);
        return this;
    }
}

