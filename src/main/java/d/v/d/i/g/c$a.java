/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.i.g;

import d.v.d.i.g.c;

public class c$a
implements Runnable {
    public final /* synthetic */ c a;

    public c$a(c c10) {
        this.a = c10;
    }

    public void run() {
        c c10 = this.a;
        Object object = c.p();
        c10.q((Long)object);
        c10 = c.o(this.a);
        object = c.n(this.a);
        c10.postDelayed((Runnable)object, 1000L);
    }
}

