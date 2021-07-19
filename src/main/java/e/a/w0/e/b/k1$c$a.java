/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.w0.e.b.k1$c;
import io.reactivex.processors.UnicastProcessor;

public final class k1$c$a
implements Runnable {
    private final UnicastProcessor a;
    public final /* synthetic */ k1$c b;

    public k1$c$a(k1$c c10, UnicastProcessor unicastProcessor) {
        this.b = c10;
        this.a = unicastProcessor;
    }

    public void run() {
        k1$c k1$c = this.b;
        UnicastProcessor unicastProcessor = this.a;
        k1$c.k(unicastProcessor);
    }
}

