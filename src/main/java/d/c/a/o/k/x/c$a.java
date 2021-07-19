/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import d.c.a.o.k.x.c;
import d.c.a.o.k.x.c$b;
import d.c.a.o.k.x.m;

public class c$a
implements m {
    private final c$b a;
    private int b;
    private int c;
    private Bitmap.Config d;

    public c$a(c$b b10) {
        this.a = b10;
    }

    public void a() {
        this.a.c(this);
    }

    public void b(int n10, int n11, Bitmap.Config config) {
        this.b = n10;
        this.c = n11;
        this.d = config;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof c$a;
        boolean bl2 = false;
        if (n10 != 0) {
            Bitmap.Config config;
            object = (c$a)object;
            n10 = this.b;
            int n11 = ((c$a)object).b;
            if (n10 == n11 && (n10 = this.c) == (n11 = ((c$a)object).c) && (config = this.d) == (object = ((c$a)object).d)) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10 = this.b * 31;
        int n11 = this.c;
        n10 = (n10 + n11) * 31;
        Bitmap.Config config = this.d;
        if (config != null) {
            n11 = config.hashCode();
        } else {
            n11 = 0;
            config = null;
        }
        return n10 + n11;
    }

    public String toString() {
        int n10 = this.b;
        int n11 = this.c;
        Bitmap.Config config = this.d;
        return d.c.a.o.k.x.c.e(n10, n11, config);
    }
}

