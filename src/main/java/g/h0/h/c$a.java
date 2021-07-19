/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import g.h0.d;
import g.h0.h.a;
import java.util.concurrent.CountDownLatch;

public final class c$a
extends a {
    private final CountDownLatch e;

    public c$a() {
        Object object = new StringBuilder();
        String string2 = d.i;
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(" awaitIdle");
        object = ((StringBuilder)object).toString();
        super((String)object, false);
        this.e = object = new CountDownLatch(1);
    }

    public long f() {
        this.e.countDown();
        return -1;
    }

    public final CountDownLatch i() {
        return this.e;
    }
}

