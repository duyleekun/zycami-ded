/*
 * Decompiled with CFR 0.151.
 */
package j$.time.q;

import j$.e.a.a.a.a;
import j$.time.d;
import j$.time.q.A;
import j$.time.q.q;
import j$.time.q.u;
import j$.time.q.x;
import java.io.Serializable;
import java.util.concurrent.ConcurrentMap;

public final class B
implements Serializable {
    private static final ConcurrentMap g;
    public static final x h;
    private final d a;
    private final int b;
    private final transient u c;
    private final transient u d;
    private final transient u e;
    private final transient u f;

    static {
        Serializable serializable;
        int n10 = 4;
        g = serializable = new Serializable(n10, 0.75f, 2);
        d d10 = j$.time.d.a;
        serializable = new Serializable(d10, n10);
        B.f(j$.time.d.d, 1);
        h = q.d;
    }

    private B(d object, int n10) {
        A a10 = A.d(this);
        this.c = a10;
        a10 = A.f(this);
        this.d = a10;
        A.h(this);
        a10 = A.g(this);
        this.e = a10;
        a10 = A.e(this);
        this.f = a10;
        int n11 = 1;
        if (n10 >= n11 && n10 <= (n11 = 7)) {
            this.a = object;
            this.b = n10;
            return;
        }
        object = new IllegalArgumentException("Minimal number of days is invalid");
        throw object;
    }

    static /* synthetic */ u a(B b10) {
        return b10.c;
    }

    static /* synthetic */ u b(B b10) {
        return b10.e;
    }

    public static B f(d d10, int n10) {
        CharSequence charSequence = new StringBuilder();
        Object object = d10.toString();
        charSequence.append((String)object);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        object = g;
        Object object2 = (B)object.get(charSequence);
        if (object2 == null) {
            object2 = new B(d10, n10);
            object.putIfAbsent(charSequence, object2);
            d10 = object.get(charSequence);
            object2 = d10;
            object2 = (B)((Object)d10);
        }
        return object2;
    }

    public u c() {
        return this.c;
    }

    public d d() {
        return this.a;
    }

    public int e() {
        return this.b;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof B;
        if (n10 != 0) {
            int n11;
            n10 = this.hashCode();
            if (n10 != (n11 = object.hashCode())) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public u g() {
        return this.f;
    }

    public u h() {
        return this.d;
    }

    public int hashCode() {
        int n10 = this.a.ordinal() * 7;
        int n11 = this.b;
        return n10 + n11;
    }

    public u i() {
        return this.e;
    }

    public String toString() {
        StringBuilder stringBuilder = j$.e.a.a.a.a.b("WeekFields[");
        d d10 = this.a;
        stringBuilder.append(d10);
        stringBuilder.append(',');
        int n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(']');
        return stringBuilder.toString();
    }
}

