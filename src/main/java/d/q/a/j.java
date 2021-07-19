/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AutoDisposingSubscriberImpl;
import d.q.a.u;
import e.a.g;
import i.g.c;
import i.g.d;

public final class j
extends e.a.j
implements u {
    private final c b;
    private final g c;

    public j(c c10, g g10) {
        this.b = c10;
        this.c = g10;
    }

    public void m6(d d10) {
        c c10 = this.b;
        g g10 = this.c;
        AutoDisposingSubscriberImpl autoDisposingSubscriberImpl = new AutoDisposingSubscriberImpl(g10, d10);
        c10.subscribe(autoDisposingSubscriberImpl);
    }
}

