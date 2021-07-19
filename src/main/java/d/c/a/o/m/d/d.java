/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.drawable.BitmapDrawable
 */
package d.c.a.o.m.d;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import d.c.a.o.i;
import d.c.a.o.k.s;
import d.c.a.o.m.d.q;
import d.c.a.u.k;
import java.security.MessageDigest;

public class d
implements i {
    private final i c;

    public d(i i10) {
        q q10 = new q(i10, false);
        this.c = i10 = (i)k.d(q10);
    }

    private static s c(s object) {
        Object object2 = object.get();
        boolean bl2 = object2 instanceof BitmapDrawable;
        if (bl2) {
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Wrapped transformation unexpectedly returned a non BitmapDrawable resource: ");
        object = object.get();
        stringBuilder.append(object);
        object = stringBuilder.toString();
        object2 = new IllegalArgumentException((String)object);
        throw object2;
    }

    private static s d(s s10) {
        return s10;
    }

    public s a(Context context, s s10, int n10, int n11) {
        s10 = d.d(s10);
        return d.c(this.c.a(context, s10, n10, n11));
    }

    public void b(MessageDigest messageDigest) {
        this.c.b(messageDigest);
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof d;
        if (bl2) {
            object = (d)object;
            i i10 = this.c;
            object = ((d)object).c;
            return i10.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }
}

