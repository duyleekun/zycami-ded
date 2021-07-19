/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import com.bumptech.glide.load.engine.DecodeJob$e;
import d.c.a.o.k.y.a;
import d.c.a.o.k.y.a$a;
import d.c.a.o.k.y.b;

public class i$c
implements DecodeJob$e {
    private final a$a a;
    private volatile a b;

    public i$c(a$a a$a) {
        this.a = a$a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public a a() {
        Object object = this.b;
        if (object != null) return this.b;
        synchronized (this) {
            object = this.b;
            if (object == null) {
                object = this.a;
                this.b = object = object.build();
            }
            if ((object = this.b) != null) return this.b;
            this.b = object = new b();
            return this.b;
        }
    }

    public void b() {
        synchronized (this) {
            a a10;
            block5: {
                a10 = this.b;
                if (a10 != null) break block5;
                return;
            }
            a10 = this.b;
            a10.clear();
            return;
        }
    }
}

