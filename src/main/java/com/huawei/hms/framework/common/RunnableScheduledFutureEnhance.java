/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import java.util.concurrent.Delayed;
import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.TimeUnit;

public class RunnableScheduledFutureEnhance
implements RunnableScheduledFuture {
    private String parentName;
    private RunnableScheduledFuture proxy;

    public RunnableScheduledFutureEnhance(RunnableScheduledFuture runnableScheduledFuture) {
        String string2;
        this.parentName = string2 = Thread.currentThread().getName();
        this.proxy = runnableScheduledFuture;
    }

    public boolean cancel(boolean bl2) {
        return this.proxy.cancel(bl2);
    }

    public int compareTo(Delayed delayed) {
        return this.proxy.compareTo(delayed);
    }

    public boolean equals(Object object) {
        return this.proxy.equals(object);
    }

    public Object get() {
        return this.proxy.get();
    }

    public Object get(long l10, TimeUnit timeUnit) {
        return this.proxy.get(l10, timeUnit);
    }

    public long getDelay(TimeUnit timeUnit) {
        return this.proxy.getDelay(timeUnit);
    }

    public String getParentName() {
        return this.parentName;
    }

    public int hashCode() {
        return this.proxy.hashCode();
    }

    public boolean isCancelled() {
        return this.proxy.isCancelled();
    }

    public boolean isDone() {
        return this.proxy.isDone();
    }

    public boolean isPeriodic() {
        return this.proxy.isPeriodic();
    }

    public void run() {
        this.proxy.run();
    }
}

