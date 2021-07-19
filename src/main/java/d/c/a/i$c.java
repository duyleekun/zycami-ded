/*
 * Decompiled with CFR 0.151.
 */
package d.c.a;

import d.c.a.i;
import d.c.a.p.c$a;
import d.c.a.p.m;

public class i$c
implements c$a {
    private final m a;
    public final /* synthetic */ i b;

    public i$c(i i10, m m10) {
        this.b = i10;
        this.a = m10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(boolean bl2) {
        if (!bl2) return;
        i i10 = this.b;
        synchronized (i10) {
            m m10 = this.a;
            m10.g();
            return;
        }
    }
}

