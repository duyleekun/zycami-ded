/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.h0$c;
import e.a.w0.e.b.k$c;
import java.util.Collection;

public final class k$c$a
implements Runnable {
    private final Collection a;
    public final /* synthetic */ k$c b;

    public k$c$a(k$c c10, Collection collection) {
        this.b = c10;
        this.a = collection;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object;
        k$c k$c = this.b;
        synchronized (k$c) {
            object = this.b;
            object = ((k$c)object).s0;
            Collection collection = this.a;
            object.remove(collection);
        }
        k$c = this.b;
        object = this.a;
        h0$c h0$c = k$c.r0;
        k$c.l(k$c, object, false, h0$c);
    }
}

