/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.s.a;
import f.h2.t.f0;
import f.r2.o;
import f.r2.p;
import f.r2.p$b;
import f.r2.s;

public final class l {
    public static final double a(a a10) {
        f0.p(a10, "block");
        o o10 = p$b.c.a();
        a10.invoke();
        return o10.a();
    }

    public static final double b(p object, a a10) {
        f0.p(object, "$this$measureTime");
        f0.p(a10, "block");
        object = object.a();
        a10.invoke();
        return ((o)object).a();
    }

    public static final s c(a object) {
        f0.p(object, "block");
        o o10 = p$b.c.a();
        object = object.invoke();
        double d10 = o10.a();
        s s10 = new s(object, d10, null);
        return s10;
    }

    public static final s d(p object, a object2) {
        f0.p(object, "$this$measureTimedValue");
        f0.p(object2, "block");
        object = object.a();
        object2 = object2.invoke();
        double d10 = ((o)object).a();
        s s10 = new s(object2, d10, null);
        return s10;
    }
}

