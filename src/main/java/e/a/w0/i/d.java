/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.v0.a;
import e.a.v0.g;
import java.util.concurrent.CountDownLatch;

public final class d
extends CountDownLatch
implements g,
a {
    public Throwable a;

    public d() {
        super(1);
    }

    public void a(Throwable throwable) {
        this.a = throwable;
        this.countDown();
    }

    public void run() {
        this.countDown();
    }
}

