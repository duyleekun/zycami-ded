/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.e;
import d.j.d.a.g;
import d.j.d.a.k;
import d.j.d.a.o.d$a;
import java.util.concurrent.Executor;

public final class d
implements e {
    private g a;
    public Executor b;
    private final Object c;

    public d(Executor executor, g g10) {
        Object object;
        this.c = object = new Object();
        this.a = g10;
        this.b = executor;
    }

    public static /* synthetic */ Object a(d d10) {
        return d10.c;
    }

    public static /* synthetic */ g b(d d10) {
        return d10.a;
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
        Executor executor = this.b;
        d$a d$a = new d$a(this, k10);
        executor.execute(d$a);
    }
}

