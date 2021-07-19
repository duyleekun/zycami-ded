/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.Drawable
 */
package d.c.a.o.m.d;

import android.content.Context;
import android.graphics.drawable.Drawable;
import d.c.a.c;
import d.c.a.o.i;
import d.c.a.o.k.s;
import d.c.a.o.k.x.e;
import d.c.a.o.m.d.p;
import d.c.a.o.m.d.x;
import java.security.MessageDigest;

public class q
implements i {
    private final i c;
    private final boolean d;

    public q(i i10, boolean bl2) {
        this.c = i10;
        this.d = bl2;
    }

    private s d(Context context, s s10) {
        return x.d(context.getResources(), s10);
    }

    public s a(Context object, s object2, int n10, int n11) {
        Object object3 = d.c.a.c.d(object).g();
        Object object4 = (Drawable)object2.get();
        if ((object3 = p.a((e)object3, (Drawable)object4, n10, n11)) == null) {
            boolean bl2 = this.d;
            if (!bl2) {
                return object2;
            }
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to convert ");
            ((StringBuilder)object2).append(object4);
            ((StringBuilder)object2).append(" to a Bitmap");
            object2 = ((StringBuilder)object2).toString();
            object = new IllegalArgumentException((String)object2);
            throw object;
        }
        object4 = this.c;
        s s10 = object4.a((Context)object, (s)object3, n10, n11);
        if ((n11 = (int)(s10.equals(object3) ? 1 : 0)) != 0) {
            s10.recycle();
            return object2;
        }
        return this.d((Context)object, s10);
    }

    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
    }

    public i c() {
        return this;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof q;
        if (bl2) {
            object = (q)object;
            i i10 = this.c;
            object = ((q)object).c;
            return i10.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}

