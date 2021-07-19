/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s.k;

import com.bumptech.glide.load.DataSource;
import d.c.a.s.k.d;
import d.c.a.s.k.e;
import d.c.a.s.k.f;
import d.c.a.s.k.g;

public class c
implements g {
    private final int a;
    private final boolean b;
    private d c;

    public c(int n10, boolean bl2) {
        this.a = n10;
        this.b = bl2;
    }

    private f b() {
        d d10 = this.c;
        if (d10 == null) {
            int n10 = this.a;
            boolean bl2 = this.b;
            this.c = d10 = new d(n10, bl2);
        }
        return this.c;
    }

    public f a(DataSource object, boolean bl2) {
        DataSource dataSource = DataSource.MEMORY_CACHE;
        object = object == dataSource ? e.b() : this.b();
        return object;
    }
}

