/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.RunnableScheduledFutureEnhance;
import com.huawei.hms.framework.common.StringUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

public class ScheduledThreadPoolExecutorEnhance
extends ScheduledThreadPoolExecutor {
    private static final String TAG = "ScheduledThreadPoolExec";

    public ScheduledThreadPoolExecutorEnhance(int n10, ThreadFactory threadFactory) {
        super(n10, threadFactory);
    }

    public void beforeExecute(Thread thread, Runnable runnable) {
        boolean bl2 = runnable instanceof RunnableScheduledFutureEnhance;
        if (bl2) {
            String string2;
            int n10;
            int n11;
            String string3;
            Object object = runnable;
            object = ((RunnableScheduledFutureEnhance)runnable).getParentName();
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

    public RunnableScheduledFuture decorateTask(Runnable runnableScheduledFuture, RunnableScheduledFuture runnableScheduledFuture2) {
        runnableScheduledFuture = super.decorateTask(runnableScheduledFuture, runnableScheduledFuture2);
        RunnableScheduledFutureEnhance runnableScheduledFutureEnhance = new RunnableScheduledFutureEnhance(runnableScheduledFuture);
        return runnableScheduledFutureEnhance;
    }

    public RunnableScheduledFuture decorateTask(Callable object, RunnableScheduledFuture runnableScheduledFuture) {
        object = super.decorateTask(object, runnableScheduledFuture);
        RunnableScheduledFutureEnhance runnableScheduledFutureEnhance = new RunnableScheduledFutureEnhance((RunnableScheduledFuture)object);
        return runnableScheduledFutureEnhance;
    }
}

