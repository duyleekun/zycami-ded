/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package d.c.a.o.l.y;

import android.content.Context;
import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.j.p.b;
import d.c.a.o.j.p.c;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.o.m.d.g0;

public class e
implements n {
    private final Context a;

    public e(Context context) {
        this.a = context = context.getApplicationContext();
    }

    private boolean e(f object) {
        long l10;
        long l11;
        long l12;
        boolean bl2;
        d.c.a.o.e e10 = g0.g;
        if ((object = (Long)((f)object).c(e10)) != null && !(bl2 = (l12 = (l11 = ((Long)object).longValue()) - (l10 = (long)-1)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public n$a c(Uri object, int n10, int n11, f f10) {
        if ((n10 = (int)(b.d(n10, n11) ? 1 : 0)) != 0 && (n10 = (int)(this.e(f10) ? 1 : 0)) != 0) {
            d.c.a.t.e e10 = new d.c.a.t.e(object);
            object = c.f(this.a, object);
            n$a n$a = new n$a(e10, (d)object);
            return n$a;
        }
        return null;
    }

    public boolean d(Uri uri) {
        return b.c(uri);
    }
}

