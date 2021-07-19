/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.e;
import d.j.d.a.i;
import d.j.d.a.k;
import d.j.d.a.o.g$a;
import java.util.concurrent.Executor;

public final class g
implements e {
    private i a;
    private Executor b;
    private final Object c;

    public g(Executor executor, i i10) {
        Object object;
        this.c = object = new Object();
        this.a = i10;
        this.b = executor;
    }

    public static /* synthetic */ Object a(g g10) {
        return g10.c;
    }

    public static /* synthetic */ i b(g g10) {
        return g10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void cancel() {
        Object object = this.c;
        synchronized (object) {
            Object var2_2 = null;
            this.a = null;
            return;
        }
    }

    public final void onComplete(k k10) {
        boolean bl2 = k10.v();
        if (bl2 && !(bl2 = k10.t())) {
            Executor executor = this.b;
            g$a g$a = new g$a(this, k10);
            executor.execute(g$a);
        }
    }
}

