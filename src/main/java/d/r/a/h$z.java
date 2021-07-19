/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.o;

public final class h$z
extends o {
    private String c;

    public h$z() {
        super(2008);
    }

    public h$z(String string2) {
        super(2008);
        this.c = string2;
    }

    public final void d(g g10) {
        String string2 = this.c;
        g10.f("package_name", string2);
    }

    public final void e(g object) {
        this.c = object = ((g)object).b("package_name");
    }

    public final String toString() {
        return "StopServiceCommand";
    }
}

