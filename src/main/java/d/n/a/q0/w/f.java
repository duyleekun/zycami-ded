/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import c.b.a.c;
import d.n.a.q0.s.y;
import d.n.a.q0.w.e;
import e.a.h0;
import java.util.concurrent.ExecutorService;

public final class f
implements c.a.l.e {
    private final c a;
    private final c b;
    private final c c;
    private final c d;

    public f(c c10, c c11, c c12, c c13) {
        this.a = c10;
        this.b = c11;
        this.c = c12;
        this.d = c13;
    }

    public static f a(c c10, c c11, c c12, c c13) {
        f f10 = new f(c10, c11, c12, c13);
        return f10;
    }

    public static e c(String string2, y y10, ExecutorService executorService, h0 h02) {
        e e10 = new e(string2, y10, executorService, h02);
        return e10;
    }

    public e b() {
        String string2 = (String)this.a.get();
        y y10 = (y)this.b.get();
        ExecutorService executorService = (ExecutorService)this.c.get();
        h0 h02 = (h0)this.d.get();
        e e10 = new e(string2, y10, executorService, h02);
        return e10;
    }
}

