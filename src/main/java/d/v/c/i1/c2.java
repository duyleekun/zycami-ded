/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.i1;

import d.v.c.i1.q2;
import d.v.c.w0.ge;

public final class c2
implements Runnable {
    public final /* synthetic */ q2 a;
    public final /* synthetic */ ge b;

    public /* synthetic */ c2(q2 q22, ge ge2) {
        this.a = q22;
        this.b = ge2;
    }

    public final void run() {
        q2 q22 = this.a;
        ge ge2 = this.b;
        q22.s(ge2);
    }
}

