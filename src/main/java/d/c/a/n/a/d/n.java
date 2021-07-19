/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package d.c.a.n.a.d;

import android.content.Context;
import android.graphics.Bitmap;
import d.c.a.c;
import d.c.a.n.a.d.k;
import d.c.a.o.i;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.g;
import java.security.MessageDigest;

public class n
implements i {
    private final i c;

    public n(i i10) {
        this.c = i10 = (i)d.c.a.u.k.d(i10);
    }

    public s a(Context object, s s10, int n10, int n11) {
        k k10 = (k)s10.get();
        Object object2 = d.c.a.c.d((Context)object).g();
        Bitmap bitmap = k10.e();
        g g10 = new g(bitmap, (e)object2);
        n10 = (int)(g10.equals(object = (object2 = this.c).a((Context)object, g10, n10, n11)) ? 1 : 0);
        if (n10 == 0) {
            g10.recycle();
        }
        object = (Bitmap)object.get();
        i i10 = this.c;
        k10.q(i10, (Bitmap)object);
        return s10;
    }

    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof n;
        if (bl2) {
            object = (n)object;
            i i10 = this.c;
            object = ((n)object).c;
            return i10.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}

