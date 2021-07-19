/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.s0.b;
import k.d;

public final class c$a
implements b {
    private final d a;
    private volatile boolean b;

    public c$a(d d10) {
        this.a = d10;
    }

    public void dispose() {
        this.b = true;
        this.a.cancel();
    }

    public boolean isDisposed() {
        return this.b;
    }
}

