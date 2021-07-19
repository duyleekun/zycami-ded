/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

public class AbstractExecutionThreadService$2
implements Executor {
    public final /* synthetic */ AbstractExecutionThreadService this$0;

    public AbstractExecutionThreadService$2(AbstractExecutionThreadService abstractExecutionThreadService) {
        this.this$0 = abstractExecutionThreadService;
    }

    public void execute(Runnable runnable) {
        MoreExecutors.newThread(this.this$0.serviceName(), runnable).start();
    }
}

