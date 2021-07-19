/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.o0;
import f.x1.p0;
import f.x1.w0;
import f.x1.x0;
import java.util.Map;
import java.util.NoSuchElementException;

public class r0 {
    public static final Object a(Map object, Object object2) {
        boolean bl2;
        CharSequence charSequence = "$this$getOrImplicitDefault";
        f0.p(object, charSequence);
        boolean bl3 = object instanceof o0;
        if (bl3) {
            return ((o0)object).d(object2);
        }
        charSequence = object.get(object2);
        if (charSequence == null && !(bl2 = object.containsKey(object2))) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("Key ");
            ((StringBuilder)charSequence).append(object2);
            ((StringBuilder)charSequence).append(" is missing in the map.");
            object2 = ((StringBuilder)charSequence).toString();
            object = new NoSuchElementException((String)object2);
            throw object;
        }
        return charSequence;
    }

    public static final Map b(Map object, l l10) {
        f0.p(object, "$this$withDefault");
        Object object2 = "defaultValue";
        f0.p(l10, (String)object2);
        boolean bl2 = object instanceof o0;
        object = bl2 ? r0.b(((o0)object).a(), l10) : (object2 = new p0((Map)object, l10));
        return object;
    }

    public static final Map c(Map object, l l10) {
        f0.p(object, "$this$withDefault");
        Object object2 = "defaultValue";
        f0.p(l10, (String)object2);
        boolean bl2 = object instanceof w0;
        object = bl2 ? r0.c(((w0)object).a(), l10) : (object2 = new x0((Map)object, l10));
        return object;
    }
}

