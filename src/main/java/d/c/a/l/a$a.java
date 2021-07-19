/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.a;
import java.io.Closeable;
import java.util.concurrent.Callable;

public class a$a
implements Callable {
    public final /* synthetic */ a a;

    public a$a(a a10) {
        this.a = a10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Void a() {
        a a10 = this.a;
        synchronized (a10) {
            Closeable closeable = this.a;
            closeable = d.c.a.l.a.a(closeable);
            if (closeable == null) {
                return null;
            }
            closeable = this.a;
            d.c.a.l.a.C(closeable);
            closeable = this.a;
            boolean bl2 = d.c.a.l.a.O(closeable);
            if (bl2) {
                closeable = this.a;
                d.c.a.l.a.S(closeable);
                closeable = this.a;
                d.c.a.l.a.n0(closeable, 0);
            }
            return null;
        }
    }
}

