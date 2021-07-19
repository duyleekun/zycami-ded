/*
 * Decompiled with CFR 0.151.
 */
package com.geetest.sdk;

import com.geetest.sdk.ah;
import java.util.concurrent.ThreadFactory;

public class ah$c
implements ThreadFactory {
    public ah$c(ah ah2) {
    }

    public Thread newThread(Runnable runnable) {
        int n10;
        long l10;
        String string2;
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread thread = new Thread(threadGroup, runnable, string2 = "geeLogger-thread-send-log", l10 = 0L);
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

