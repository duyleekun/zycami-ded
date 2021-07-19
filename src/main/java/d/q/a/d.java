/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import d.q.a.b0;
import d.q.a.c0;
import d.q.a.d$a;
import d.q.a.h;
import d.q.a.p;
import e.a.g;

public final class d {
    private d() {
        AssertionError assertionError = new AssertionError((Object)"No instances");
        throw assertionError;
    }

    public static h a(b0 b02) {
        p.a(b02, "provider == null");
        return d.b(c0.a(b02));
    }

    public static h b(g g10) {
        p.a(g10, "scope == null");
        d$a d$a = new d$a(g10);
        return d$a;
    }
}

