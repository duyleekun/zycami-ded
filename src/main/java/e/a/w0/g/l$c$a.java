/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.g;

import e.a.w0.g.l$b;
import e.a.w0.g.l$c;
import java.util.concurrent.PriorityBlockingQueue;

public final class l$c$a
implements Runnable {
    public final l$b a;
    public final /* synthetic */ l$c b;

    public l$c$a(l$c l$c, l$b l$b) {
        this.b = l$c;
        this.a = l$b;
    }

    public void run() {
        this.a.d = true;
        PriorityBlockingQueue priorityBlockingQueue = this.b.a;
        l$b l$b = this.a;
        priorityBlockingQueue.remove(l$b);
    }
}

