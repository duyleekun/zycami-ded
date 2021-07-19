/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package g.h0.n.i;

import android.os.Build;
import f.h2.t.u;
import g.h0.n.h;
import g.h0.n.h$a;
import g.h0.n.i.a;
import g.h0.n.i.k;

public final class a$a {
    private a$a() {
    }

    public /* synthetic */ a$a(u u10) {
        this();
    }

    public final k a() {
        a a10;
        boolean bl2 = this.b();
        if (bl2) {
            a10 = new a();
        } else {
            bl2 = false;
            a10 = null;
        }
        return a10;
    }

    public final boolean b() {
        int n10;
        h$a h$a = h.e;
        int n11 = h$a.h();
        if (n11 != 0 && (n11 = Build.VERSION.SDK_INT) >= (n10 = 29)) {
            n11 = 1;
        } else {
            n11 = 0;
            h$a = null;
        }
        return n11 != 0;
    }
}

