/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.a0$a;
import g.b0;
import g.d;
import g.d$b;
import g.s;
import g.t;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.CollectionsKt__CollectionsKt;

public final class a0 {
    private d a;
    private final t b;
    private final String c;
    private final s d;
    private final b0 e;
    private final Map f;

    public a0(t t10, String string2, s s10, b0 b02, Map map) {
        f0.p(t10, "url");
        f0.p(string2, "method");
        f0.p(s10, "headers");
        f0.p(map, "tags");
        this.b = t10;
        this.c = string2;
        this.d = s10;
        this.e = b02;
        this.f = map;
    }

    public final b0 a() {
        return this.e;
    }

    public final d b() {
        return this.g();
    }

    public final s c() {
        return this.d;
    }

    public final String d() {
        return this.c;
    }

    public final t e() {
        return this.b;
    }

    public final b0 f() {
        return this.e;
    }

    public final d g() {
        Object object = this.a;
        if (object == null) {
            object = g.d.p;
            s s10 = this.d;
            this.a = object = ((d$b)object).c(s10);
        }
        return object;
    }

    public final Map h() {
        return this.f;
    }

    public final String i(String string2) {
        f0.p(string2, "name");
        return this.d.e(string2);
    }

    public final List j(String string2) {
        f0.p(string2, "name");
        return this.d.o(string2);
    }

    public final s k() {
        return this.d;
    }

    public final boolean l() {
        return this.b.G();
    }

    public final String m() {
        return this.c;
    }

    public final a0$a n() {
        a0$a a0$a = new a0$a(this);
        return a0$a;
    }

    public final Object o() {
        return this.p(Object.class);
    }

    public final Object p(Class clazz) {
        f0.p(clazz, "type");
        Object v10 = this.f.get(clazz);
        return clazz.cast(v10);
    }

    public final t q() {
        return this.b;
    }

    public String toString() {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Request{method=");
        Object object = this.c;
        ((StringBuilder)charSequence).append((String)object);
        ((StringBuilder)charSequence).append(", url=");
        object = this.b;
        ((StringBuilder)charSequence).append(object);
        object = this.d;
        int c10 = ((s)object).size();
        if (c10 != 0) {
            boolean bl3;
            ((StringBuilder)charSequence).append(", headers=[");
            object = this.d;
            int n10 = 0;
            String string2 = null;
            object = object.iterator();
            while (bl3 = object.hasNext()) {
                Object object2 = object.next();
                int n11 = n10 + 1;
                if (n10 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                object2 = (Pair)object2;
                String string3 = (String)((Pair)object2).component1();
                object2 = (String)((Pair)object2).component2();
                if (n10 > 0) {
                    string2 = ", ";
                    ((StringBuilder)charSequence).append(string2);
                }
                ((StringBuilder)charSequence).append(string3);
                ((StringBuilder)charSequence).append(':');
                ((StringBuilder)charSequence).append((String)object2);
                n10 = n11;
            }
            char c11 = ']';
            ((StringBuilder)charSequence).append(c11);
        }
        if (bl2 = (object = this.f).isEmpty() ^ true) {
            ((StringBuilder)charSequence).append(", tags=");
            object = this.f;
            ((StringBuilder)charSequence).append(object);
        }
        ((StringBuilder)charSequence).append('}');
        charSequence = ((StringBuilder)charSequence).toString();
        f0.o(charSequence, "StringBuilder().apply(builderAction).toString()");
        return charSequence;
    }
}

