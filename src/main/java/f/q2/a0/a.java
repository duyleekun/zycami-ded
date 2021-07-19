/*
 * Decompiled with CFR 0.151.
 */
package f.q2.a0;

import f.h2.t.f0;
import f.q2.h;
import f.q2.i;
import f.q2.j;

public final class a {
    public static final h a(i object, String string2) {
        f0.p(object, "$this$get");
        String string3 = "name";
        f0.p(string2, string3);
        boolean bl2 = object instanceof j;
        if (!bl2) {
            object = null;
        }
        if ((object = (j)object) != null) {
            return object.get(string2);
        }
        object = new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        throw object;
    }
}

