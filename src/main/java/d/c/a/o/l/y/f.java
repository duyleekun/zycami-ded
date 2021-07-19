/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Build$VERSION
 */
package d.c.a.o.l.y;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import d.c.a.o.j.p.b;
import d.c.a.o.l.n;
import d.c.a.o.l.n$a;
import d.c.a.o.l.y.f$d;
import d.c.a.t.e;

public final class f
implements n {
    private final Context a;
    private final n b;
    private final n c;
    private final Class d;

    public f(Context context, n n10, n n11, Class clazz) {
        this.a = context = context.getApplicationContext();
        this.b = n10;
        this.c = n11;
        this.d = clazz;
    }

    public n$a c(Uri uri, int n10, int n11, d.c.a.o.f f10) {
        e e10 = new e(uri);
        Context context = this.a;
        n n12 = this.b;
        n n13 = this.c;
        Class clazz = this.d;
        f$d f$d = new f$d(context, n12, n13, uri, n10, n11, f10, clazz);
        n$a n$a = new n$a(e10, f$d);
        return n$a;
    }

    public boolean d(Uri uri) {
        boolean bl2;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 29;
        if (n10 >= n11 && (bl2 = d.c.a.o.j.p.b.b(uri))) {
            bl2 = true;
        } else {
            bl2 = false;
            uri = null;
        }
        return bl2;
    }
}

