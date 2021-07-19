/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.e;
import d.j.d.a.h;
import d.j.d.a.k;
import d.j.d.a.o.f$a;
import java.util.concurrent.Executor;

public final class f
implements e {
    private h a;
    private Executor b;
    private final Object c;

    public f(Executor executor, h h10) {
        Object object;
        this.c = object = new Object();
        this.a = h10;
        this.b = executor;
    }

    public static /* synthetic */ Object a(f f10) {
        return f10.c;
    }

    public static /* synthetic */ h b(f f10) {
        return f10.a;
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
        if (!bl2 && !(bl2 = k10.t())) {
            Executor executor = this.b;
            f$a f$a = new f$a(this, k10);
            executor.execute(f$a);
        }
    }
}

