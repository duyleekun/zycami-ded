/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 */
package d.c.a.o.m.d;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import d.c.a.o.f;
import d.c.a.o.g;
import d.c.a.o.k.s;
import d.c.a.o.m.d.p;
import d.c.a.o.m.f.e;

public class z
implements g {
    private final e a;
    private final d.c.a.o.k.x.e b;

    public z(e e10, d.c.a.o.k.x.e e11) {
        this.a = e10;
        this.b = e11;
    }

    public s c(Uri object, int n10, int n11, f f10) {
        e e10 = this.a;
        if ((object = e10.c((Uri)object, n10, n11, f10)) == null) {
            return null;
        }
        object = (Drawable)object.get();
        return p.a(this.b, (Drawable)object, n10, n11);
    }

    public boolean d(Uri object, f f10) {
        object = object.getScheme();
        return "android.resource".equals(object);
    }
}

