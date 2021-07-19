/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.LocationManager
 */
package d.n.a;

import android.content.Context;
import android.location.LocationManager;
import c.a.l.e;
import c.a.l.l;
import c.b.a.c;
import d.n.a.b$d;

public final class q
implements e {
    private final c a;

    public q(c c10) {
        this.a = c10;
    }

    public static q a(c c10) {
        q q10 = new q(c10);
        return q10;
    }

    public static LocationManager c(Context context) {
        return (LocationManager)l.b(b$d.t(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public LocationManager b() {
        return (LocationManager)l.b(b$d.t((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}

