/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.ThreadFactory;

public class AbstractScheduledService$1ThreadFactoryImpl
implements ThreadFactory {
    public final /* synthetic */ AbstractScheduledService this$0;

    public AbstractScheduledService$1ThreadFactoryImpl(AbstractScheduledService abstractScheduledService) {
        this.this$0 = abstractScheduledService;
    }

    public Thread newThread(Runnable runnable) {
        return MoreExecutors.newThread(this.this$0.serviceName(), runnable);
    }
}

