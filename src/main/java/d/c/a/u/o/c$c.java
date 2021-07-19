/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.u.o;

import d.c.a.u.o.c;

public class c$c
extends c {
    private volatile boolean b;

    public c$c() {
        super(null);
    }

    public void b(boolean bl2) {
        this.b = bl2;
    }

    public void c() {
        boolean bl2 = this.b;
        if (!bl2) {
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Already released");
        throw illegalStateException;
    }
}

