/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$Config
 */
package d.c.a.o.k.x;

import android.graphics.Bitmap;
import d.c.a.o.k.x.m;
import d.c.a.o.k.x.n;
import d.c.a.o.k.x.n$c;

public final class n$b
implements m {
    private final n$c a;
    public int b;
    private Bitmap.Config c;

    public n$b(n$c c10) {
        this.a = c10;
    }

    public n$b(n$c c10, int n10, Bitmap.Config config) {
        this(c10);
        this.b(n10, config);
    }

    public void a() {
        this.a.c(this);
    }

    public void b(int n10, Bitmap.Config config) {
        this.b = n10;
        this.c = config;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof n$b;
        boolean bl2 = false;
        if (n10 != 0) {
            Bitmap.Config config;
            boolean bl3;
            object = (n$b)object;
            n10 = this.b;
            int n11 = ((n$b)object).b;
            if (n10 == n11 && (bl3 = d.c.a.u.m.d(config = this.c, object = ((n$b)object).c))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public int hashCode() {
        int n10;
        int n11 = this.b * 31;
        Bitmap.Config config = this.c;
        if (config != null) {
            n10 = config.hashCode();
        } else {
            n10 = 0;
            config = null;
        }
        return n11 + n10;
    }

    public String toString() {
        int n10 = this.b;
        Bitmap.Config config = this.c;
        return n.h(n10, config);
    }
}

