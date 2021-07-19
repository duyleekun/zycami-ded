/*
 * Decompiled with CFR 0.151.
 */
package e.a.c1;

import e.a.c1.c$a;
import e.a.c1.c$b;
import java.util.Queue;

public final class c$a$a
implements Runnable {
    public final c$b a;
    public final /* synthetic */ c$a b;

    public c$a$a(c$a a10, c$b b10) {
        this.b = a10;
        this.a = b10;
    }

    public void run() {
        Queue queue = this.b.b.b;
        c$b c$b = this.a;
        queue.remove(c$b);
    }
}

