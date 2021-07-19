/*
 * Decompiled with CFR 0.151.
 */
package d.o.a.a.b.c;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class b$b
implements ThreadFactory {
    private static final AtomicInteger d;
    private final ThreadGroup a;
    private final AtomicInteger b;
    private final String c;

    static {
        AtomicInteger atomicInteger;
        d = atomicInteger = new AtomicInteger(1);
    }

    public b$b() {
        int n10 = 1;
        Object object = new AtomicInteger(n10);
        this.b = object;
        object = System.getSecurityManager();
        object = object != null ? ((SecurityManager)object).getThreadGroup() : Thread.currentThread().getThreadGroup();
        this.a = object;
        object = new StringBuilder();
        ((StringBuilder)object).append("oss_upload_Pool - ");
        n10 = d.getAndIncrement();
        ((StringBuilder)object).append(n10);
        ((StringBuilder)object).append(" - thread - ");
        this.c = object = ((StringBuilder)object).toString();
    }

    public Thread newThread(Runnable runnable) {
        int n10;
        Thread thread;
        ThreadGroup threadGroup = this.a;
        Object object = new StringBuilder();
        Object object2 = this.c;
        ((StringBuilder)object).append((String)object2);
        int n11 = this.b.getAndIncrement();
        ((StringBuilder)object).append(n11);
        String string2 = ((StringBuilder)object).toString();
        long l10 = 0L;
        object = thread;
        object2 = runnable;
        thread = new Thread(threadGroup, runnable, string2, l10);
        int n12 = thread.isDaemon();
        if (n12 != 0) {
            n12 = 0;
            runnable = null;
            thread.setDaemon(false);
        }
        if ((n12 = thread.getPriority()) != (n10 = 5)) {
            thread.setPriority(n10);
        }
        return thread;
    }
}

