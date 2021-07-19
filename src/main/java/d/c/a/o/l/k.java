/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 */
package d.c.a.o.l;

import android.content.Context;
import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.j.d;
import d.c.a.o.j.p.b;
import d.c.a.o.l.k$b;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.t.e;

public final class k
implements n {
    private final Context a;

    public k(Context context) {
        this.a = context;
    }

    public n$a c(Uri uri, int n10, int n11, f object) {
        e e10 = new e(uri);
        Context context = this.a;
        object = new k$b(context, uri);
        n$a n$a = new n$a(e10, (d)object);
        return n$a;
    }

    public boolean d(Uri uri) {
        return b.b(uri);
    }
}

