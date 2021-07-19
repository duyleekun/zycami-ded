/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import g.e0;
import java.util.LinkedHashSet;
import java.util.Set;

public final class h {
    private final Set a;

    public h() {
        LinkedHashSet linkedHashSet;
        this.a = linkedHashSet = new LinkedHashSet();
    }

    public final void a(e0 e02) {
        synchronized (this) {
            Object object = "route";
            f0.p(e02, (String)object);
            object = this.a;
            object.remove(e02);
            return;
        }
    }

    public final void b(e0 e02) {
        synchronized (this) {
            Object object = "failedRoute";
            f0.p(e02, (String)object);
            object = this.a;
            object.add(e02);
            return;
        }
    }

    public final boolean c(e0 e02) {
        synchronized (this) {
            Object object = "route";
            f0.p(e02, (String)object);
            object = this.a;
            boolean bl2 = object.contains(e02);
            return bl2;
        }
    }
}

