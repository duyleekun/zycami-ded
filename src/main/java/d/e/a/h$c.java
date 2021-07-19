/*
 * Decompiled with CFR 0.151.
 */
package d.e.a;

import d.e.a.h;
import java.util.concurrent.ThreadFactory;

public class h$c
implements ThreadFactory {
    public final /* synthetic */ h a;

    public h$c(h h10) {
        this.a = h10;
    }

    public Thread newThread(Runnable runnable) {
        int n10;
        long l10;
        String string2;
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread thread = new Thread(threadGroup, runnable, string2 = "logan-thread-send-log", l10 = 0L);
        int n11 = thread.isDaemon();
        if (n11 != 0) {
            n11 = 0;
            runnable = null;
            thread.setDaemon(false);
        }
        if ((n11 = thread.getPriority()) != (n10 = 5)) {
            thread.setPriority(n10);
        }
        return thread;
    }
}

