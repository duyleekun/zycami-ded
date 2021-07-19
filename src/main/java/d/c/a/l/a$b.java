/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.l;

import d.c.a.l.a$a;
import java.util.concurrent.ThreadFactory;

public final class a$b
implements ThreadFactory {
    private a$b() {
    }

    public /* synthetic */ a$b(a$a a$a) {
        this();
    }

    public Thread newThread(Runnable runnable) {
        synchronized (this) {
            String string2 = "glide-disk-lru-cache-thread";
            Thread thread = new Thread(runnable, string2);
            int n10 = 1;
            thread.setPriority(n10);
            return thread;
        }
    }
}

