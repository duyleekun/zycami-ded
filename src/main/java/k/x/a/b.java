/*
 * Decompiled with CFR 0.151.
 */
package k.x.a;

import e.a.g0;
import e.a.z;
import k.d;
import k.x.a.b$a;

public final class b
extends z {
    private final d a;

    public b(d d10) {
        this.a = d10;
    }

    public void K5(g0 g02) {
        d d10 = this.a.clone();
        b$a b$a = new b$a(d10, g02);
        g02.onSubscribe(b$a);
        boolean bl2 = b$a.isDisposed();
        if (!bl2) {
            d10.h(b$a);
        }
    }
}

