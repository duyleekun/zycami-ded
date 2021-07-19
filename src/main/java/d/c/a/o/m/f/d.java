/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.drawable.Drawable
 */
package d.c.a.o.m.f;

import android.graphics.drawable.Drawable;
import d.c.a.o.k.s;
import d.c.a.o.m.f.b;

public final class d
extends b {
    private d(Drawable drawable2) {
        super(drawable2);
    }

    public static s d(Drawable drawable2) {
        d d10 = drawable2 != null ? new d(drawable2) : null;
        return d10;
    }

    public Class b() {
        return this.a.getClass();
    }

    public int getSize() {
        int n10 = this.a.getIntrinsicWidth();
        int n11 = this.a.getIntrinsicHeight();
        n10 = n10 * n11 * 4;
        return Math.max(1, n10);
    }

    public void recycle() {
    }
}

