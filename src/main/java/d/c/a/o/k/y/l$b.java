/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.DisplayMetrics
 */
package d.c.a.o.k.y;

import android.util.DisplayMetrics;
import d.c.a.o.k.y.l$c;

public final class l$b
implements l$c {
    private final DisplayMetrics a;

    public l$b(DisplayMetrics displayMetrics) {
        this.a = displayMetrics;
    }

    public int a() {
        return this.a.heightPixels;
    }

    public int b() {
        return this.a.widthPixels;
    }
}

