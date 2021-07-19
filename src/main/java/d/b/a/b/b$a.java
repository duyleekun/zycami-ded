/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.b;
import d.b.a.b.q;

public final class b$a {
    private String a;

    private b$a() {
    }

    public /* synthetic */ b$a(q q10) {
        this();
    }

    public final b a() {
        Object object = this.a;
        if (object != null) {
            object = new b(null);
            String string2 = this.a;
            b.c((b)object, string2);
            return object;
        }
        object = new IllegalArgumentException("Purchase token must be set");
        throw object;
    }

    public final b$a b(String string2) {
        this.a = string2;
        return this;
    }
}

