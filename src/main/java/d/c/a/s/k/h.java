/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.animation.Animation
 */
package d.c.a.s.k;

import android.view.animation.Animation;
import com.bumptech.glide.load.DataSource;
import d.c.a.s.k.e;
import d.c.a.s.k.f;
import d.c.a.s.k.g;
import d.c.a.s.k.h$a;
import d.c.a.s.k.h$b;
import d.c.a.s.k.k;
import d.c.a.s.k.k$a;

public class h
implements g {
    private final k$a a;
    private f b;

    public h(int n10) {
        h$b h$b = new h$b(n10);
        this(h$b);
    }

    public h(Animation animation) {
        h$a h$a = new h$a(animation);
        this(h$a);
    }

    public h(k$a k$a) {
        this.a = k$a;
    }

    public f a(DataSource object, boolean bl2) {
        DataSource dataSource = DataSource.MEMORY_CACHE;
        if (object != dataSource && bl2) {
            object = this.b;
            if (object == null) {
                k$a k$a = this.a;
                object = new k(k$a);
                this.b = object;
            }
            return this.b;
        }
        return e.b();
    }
}

