/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.b$c;
import e.a.h0;
import java.util.concurrent.ExecutorService;

public final class b$d$a
implements b$c {
    public final /* synthetic */ ExecutorService a;
    public final /* synthetic */ h0 b;
    public final /* synthetic */ ExecutorService c;

    public b$d$a(ExecutorService executorService, h0 h02, ExecutorService executorService2) {
        this.a = executorService;
        this.b = h02;
        this.c = executorService2;
    }

    public void a() {
        this.a.shutdown();
        this.b.h();
        this.c.shutdown();
    }
}

