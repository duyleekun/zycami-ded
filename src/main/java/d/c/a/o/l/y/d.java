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
import d.c.a.o.j.p.b;
import d.c.a.o.j.p.c;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.t.e;

public class d
implements n {
    private final Context a;

    public d(Context context) {
        this.a = context = context.getApplicationContext();
    }

    public n$a c(Uri object, int n10, int n11, f f10) {
        if ((n10 = (int)(b.d(n10, n11) ? 1 : 0)) != 0) {
            e e10 = new e(object);
            object = c.e(this.a, object);
            n$a n$a = new n$a(e10, (d.c.a.o.j.d)object);
            return n$a;
        }
        return null;
    }

    public boolean d(Uri uri) {
        return b.a(uri);
    }
}

