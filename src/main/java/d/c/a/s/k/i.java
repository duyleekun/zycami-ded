/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s.k;

import com.bumptech.glide.load.DataSource;
import d.c.a.s.k.e;
import d.c.a.s.k.f;
import d.c.a.s.k.g;
import d.c.a.s.k.j;
import d.c.a.s.k.j$a;

public class i
implements g {
    private final j$a a;
    private j b;

    public i(j$a j$a) {
        this.a = j$a;
    }

    public f a(DataSource object, boolean bl2) {
        DataSource dataSource = DataSource.MEMORY_CACHE;
        if (object != dataSource && bl2) {
            object = this.b;
            if (object == null) {
                j$a j$a = this.a;
                object = new j(j$a);
                this.b = object;
            }
            return this.b;
        }
        return e.b();
    }
}

