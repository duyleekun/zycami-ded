/*
 * Decompiled with CFR 0.151.
 */
package d.b.a.b;

import d.b.a.b.e$b;
import d.b.a.b.h;
import d.b.a.b.m;
import d.b.a.b.q0;
import java.util.List;

public final class p0
implements Runnable {
    private final /* synthetic */ e$b a;
    private final /* synthetic */ q0 b;

    public p0(q0 q02, e$b e$b) {
        this.b = q02;
        this.a = e$b;
    }

    public final void run() {
        m m10 = this.b.b;
        h h10 = this.a.a();
        List list = this.a.b();
        m10.f(h10, list);
    }
}

