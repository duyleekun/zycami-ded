/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.RunnableEnhance;
import com.huawei.hms.framework.common.StringUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExcutorEnhance
extends ThreadPoolExecutor {
    public ThreadPoolExcutorEnhance(int n10, int n11, long l10, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(n10, n11, l10, timeUnit, (BlockingQueue<Runnable>)blockingQueue, threadFactory);
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        boolean bl2 = runnable instanceof RunnableEnhance;
        if (bl2) {
            String string2;
            int n10;
            int n11;
            String string3;
            Object object = runnable;
            object = ((RunnableEnhance)runnable).getParentName();
            int n12 = ((String)object).lastIndexOf(string3 = " -->");
            if (n12 != (n11 = -1)) {
                object = StringUtils.substring((String)object, n12 += 4);
            }
            if ((n10 = (string2 = thread.getName()).lastIndexOf(string3)) != n11) {
                string2 = StringUtils.substring(string2, n10 += 4);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)object);
            stringBuilder.append(string3);
            stringBuilder.append(string2);
            object = stringBuilder.toString();
            thread.setName((String)object);
        }
        super.beforeExecute(thread, runnable);
    }

    public void execute(Runnable runnable) {
        RunnableEnhance runnableEnhance = new RunnableEnhance(runnable);
        super.execute(runnableEnhance);
    }
}

