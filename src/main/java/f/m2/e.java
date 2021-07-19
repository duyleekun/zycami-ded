/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.h2.t.f0;
import f.m2.d;
import java.util.Objects;

public final class e {
    public static final Object a(d object, Object object2) {
        CharSequence charSequence = "$this$cast";
        f0.p(object, (String)charSequence);
        boolean bl2 = object.n(object2);
        if (bl2) {
            Objects.requireNonNull(object2, "null cannot be cast to non-null type T");
            return object2;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("Value cannot be cast to ");
        object = object.p();
        ((StringBuilder)charSequence).append((String)object);
        object = ((StringBuilder)charSequence).toString();
        object2 = new ClassCastException((String)object);
        throw object2;
    }

    public static final Object b(d object, Object object2) {
        String string2 = "$this$safeCast";
        f0.p(object, string2);
        boolean bl2 = object.n(object2);
        if (bl2) {
            object = "null cannot be cast to non-null type T";
            Objects.requireNonNull(object2, (String)object);
        } else {
            object2 = null;
        }
        return object2;
    }
}

