/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.e;
import d.j.d.a.f;
import d.j.d.a.k;
import d.j.d.a.o.b$a;
import java.util.concurrent.Executor;

public final class b
implements e {
    private f a;
    private Executor b;
    private final Object c;

    public b(Executor executor, f f10) {
        Object object;
        this.c = object = new Object();
        this.a = f10;
        this.b = executor;
    }

    public static /* synthetic */ Object a(b b10) {
        return b10.c;
    }

    public static /* synthetic */ f b(b b10) {
        return b10.a;
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

    public final void onComplete(k object) {
        boolean bl2 = ((k)object).t();
        if (bl2) {
            object = this.b;
            b$a b$a = new b$a(this);
            object.execute(b$a);
        }
    }
}

