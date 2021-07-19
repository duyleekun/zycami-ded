/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 */
package d.c.a.o.m.d;

import android.content.Context;
import android.graphics.Bitmap;
import d.c.a.c;
import d.c.a.o.i;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.g;
import d.c.a.u.m;

public abstract class h
implements i {
    public final s a(Context object, s object2, int n10, int n11) {
        boolean bl2 = m.v(n10, n11);
        if (bl2) {
            Bitmap bitmap;
            object = c.d(object).g();
            Bitmap bitmap2 = (Bitmap)object2.get();
            int n12 = -1 << -1;
            if (n10 == n12) {
                n10 = bitmap2.getWidth();
            }
            if (n11 == n12) {
                n11 = bitmap2.getHeight();
            }
            if ((n11 = (int)(bitmap2.equals(bitmap = this.c((e)object, bitmap2, n10, n11)) ? 1 : 0)) == 0) {
                object2 = g.d(bitmap, (e)object);
            }
            return object2;
        }
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("Cannot apply transformation on width: ");
        ((StringBuilder)object2).append(n10);
        ((StringBuilder)object2).append(" or height: ");
        ((StringBuilder)object2).append(n11);
        ((StringBuilder)object2).append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
        object2 = ((StringBuilder)object2).toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public abstract Bitmap c(e var1, Bitmap var2, int var3, int var4);
}

