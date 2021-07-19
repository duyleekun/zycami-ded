/*
 * Decompiled with CFR 0.151.
 */
package f.y1;

import f.h2.s.l;
import f.h2.s.p;
import f.h2.t.f0;
import f.y1.b$a;
import f.y1.b$b;
import f.y1.b$c;
import f.y1.b$d;
import f.y1.b$e;
import f.y1.b$f;
import f.y1.b$g;
import f.y1.b$h;
import f.y1.b$i;
import f.y1.b$j;
import f.y1.b$k;
import f.y1.b$l;
import f.y1.b$m;
import f.y1.b$n;
import f.y1.e;
import f.y1.f;
import f.y1.g;
import java.util.Comparator;
import java.util.Objects;

public class b {
    public static final /* synthetic */ int a(Object object, Object object2, l[] lArray) {
        return b.k(object, object2, lArray);
    }

    private static final Comparator b(Comparator comparator, l l10) {
        b$c b$c = new b$c(comparator, l10);
        return b$c;
    }

    private static final Comparator c(l l10) {
        b$b b$b = new b$b(l10);
        return b$b;
    }

    public static final Comparator d(l ... lArray) {
        Object object = "selectors";
        f0.p(lArray, (String)object);
        int n10 = lArray.length;
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            object = new b$a(lArray);
            return object;
        }
        object = "Failed requirement.".toString();
        lArray = new IllegalArgumentException((String)object);
        throw lArray;
    }

    private static final Comparator e(Comparator comparator, l l10) {
        b$e b$e = new b$e(comparator, l10);
        return b$e;
    }

    private static final Comparator f(l l10) {
        b$d b$d = new b$d(l10);
        return b$d;
    }

    public static final int g(Comparable comparable, Comparable comparable2) {
        if (comparable == comparable2) {
            return 0;
        }
        if (comparable == null) {
            return -1;
        }
        if (comparable2 == null) {
            return 1;
        }
        return comparable.compareTo(comparable2);
    }

    private static final int h(Object object, Object object2, Comparator comparator, l l10) {
        object = l10.invoke(object);
        object2 = l10.invoke(object2);
        return comparator.compare(object, object2);
    }

    private static final int i(Object object, Object object2, l l10) {
        object = (Comparable)l10.invoke(object);
        object2 = (Comparable)l10.invoke(object2);
        return b.g((Comparable)object, (Comparable)object2);
    }

    public static final int j(Object object, Object object2, l ... lArray) {
        String string2 = "selectors";
        f0.p(lArray, string2);
        int n10 = lArray.length;
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            return b.k(object, object2, lArray);
        }
        object2 = "Failed requirement.".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    private static final int k(Object object, Object object2, l[] lArray) {
        for (l l10 : lArray) {
            Comparable object3;
            Comparable comparable = (Comparable)l10.invoke(object);
            int n10 = b.g(comparable, object3 = (Comparable)l10.invoke(object2));
            if (n10 == 0) continue;
            return n10;
        }
        return 0;
    }

    public static final Comparator l() {
        e e10 = e.a;
        Objects.requireNonNull(e10, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return e10;
    }

    private static final Comparator m() {
        return b.n(b.l());
    }

    public static final Comparator n(Comparator comparator) {
        f0.p(comparator, "comparator");
        b$f b$f = new b$f(comparator);
        return b$f;
    }

    private static final Comparator o() {
        return b.p(b.l());
    }

    public static final Comparator p(Comparator comparator) {
        f0.p(comparator, "comparator");
        b$g b$g = new b$g(comparator);
        return b$g;
    }

    public static final Comparator q() {
        f f10 = f.a;
        Objects.requireNonNull(f10, "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */");
        return f10;
    }

    public static final Comparator r(Comparator object) {
        Object object2 = "$this$reversed";
        f0.p(object, (String)object2);
        boolean bl2 = object instanceof g;
        if (bl2) {
            object = ((g)object).a();
        } else {
            object2 = e.a;
            boolean bl3 = f0.g(object, object2);
            String string2 = "null cannot be cast to non-null type kotlin.Comparator<T> /* = java.util.Comparator<T> */";
            if (bl3) {
                object = f.a;
                Objects.requireNonNull(object, string2);
            } else {
                f f10 = f.a;
                bl3 = f0.g(object, f10);
                if (bl3) {
                    Objects.requireNonNull(object2, string2);
                } else {
                    object2 = new g((Comparator)object);
                }
                object = object2;
            }
        }
        return object;
    }

    public static final Comparator s(Comparator comparator, Comparator comparator2) {
        f0.p(comparator, "$this$then");
        f0.p(comparator2, "comparator");
        b$h b$h = new b$h(comparator, comparator2);
        return b$h;
    }

    private static final Comparator t(Comparator comparator, Comparator comparator2, l l10) {
        b$j b$j = new b$j(comparator, comparator2, l10);
        return b$j;
    }

    private static final Comparator u(Comparator comparator, l l10) {
        b$i b$i = new b$i(comparator, l10);
        return b$i;
    }

    private static final Comparator v(Comparator comparator, Comparator comparator2, l l10) {
        b$l b$l = new b$l(comparator, comparator2, l10);
        return b$l;
    }

    private static final Comparator w(Comparator comparator, l l10) {
        b$k b$k = new b$k(comparator, l10);
        return b$k;
    }

    private static final Comparator x(Comparator comparator, p p10) {
        b$m b$m = new b$m(comparator, p10);
        return b$m;
    }

    public static final Comparator y(Comparator comparator, Comparator comparator2) {
        f0.p(comparator, "$this$thenDescending");
        f0.p(comparator2, "comparator");
        b$n b$n = new b$n(comparator, comparator2);
        return b$n;
    }
}

