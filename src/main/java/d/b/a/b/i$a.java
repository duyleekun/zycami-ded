/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.b0;
import d.b.a.b.i;

public final class i$a {
    private String a;

    private i$a() {
    }

    public /* synthetic */ i$a(b0 b02) {
        this();
    }

    public final i a() {
        Object object = this.a;
        if (object != null) {
            object = new i(null);
            String string2 = this.a;
            i.c((i)object, string2);
            return object;
        }
        object = new IllegalArgumentException("Purchase token must be set");
        throw object;
    }

    public final i$a b(String string2) {
        this.a = string2;
        return this;
    }
}

