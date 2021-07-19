/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.l2.d;
import f.l2.e;
import f.l2.f;
import f.l2.g;
import f.l2.h;

public class p {
    public static final void a(boolean bl2, Number object) {
        CharSequence charSequence = "step";
        f0.p(object, (String)charSequence);
        if (bl2) {
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Step must be positive, was: ");
        ((StringBuilder)charSequence).append(object);
        ((StringBuilder)charSequence).append('.');
        object = ((StringBuilder)charSequence).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    private static final boolean b(Iterable object, Object object2) {
        boolean bl2;
        String string2 = "$this$contains";
        f0.p(object, string2);
        if (object2 != null && (bl2 = (object = (g)object).contains((Comparable)(object2 = (Comparable)object2)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public static final f c(double d10, double d11) {
        d d12 = new d(d10, d11);
        return d12;
    }

    public static final f d(float f10, float f11) {
        e e10 = new e(f10, f11);
        return e10;
    }

    public static final g e(Comparable comparable, Comparable comparable2) {
        f0.p(comparable, "$this$rangeTo");
        f0.p(comparable2, "that");
        h h10 = new h(comparable, comparable2);
        return h10;
    }
}

