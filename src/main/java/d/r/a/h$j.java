/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$t;

public final class h$j
extends h$t {
    public String e;
    private String f;
    public String g;

    public h$j(int n10) {
        super(n10);
    }

    public final void d(g g10) {
        super.d(g10);
        String string2 = this.e;
        g10.f("app_id", string2);
        string2 = this.f;
        g10.f("client_id", string2);
        string2 = this.g;
        g10.f("client_token", string2);
    }

    public final void e(g object) {
        String string2;
        super.e((g)object);
        this.e = string2 = ((g)object).b("app_id");
        this.f = string2 = ((g)object).b("client_id");
        this.g = object = ((g)object).b("client_token");
    }

    public final String toString() {
        return "OnBindCommand";
    }
}

