/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1$1;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1$2;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

public class AbstractExecutionThreadService$1
extends AbstractService {
    public final /* synthetic */ AbstractExecutionThreadService this$0;

    public AbstractExecutionThreadService$1(AbstractExecutionThreadService abstractExecutionThreadService) {
        this.this$0 = abstractExecutionThreadService;
    }

    public final void doStart() {
        Executor executor = this.this$0.executor();
        Object object = new AbstractExecutionThreadService$1$1(this);
        executor = MoreExecutors.renamingDecorator(executor, (Supplier)object);
        object = new AbstractExecutionThreadService$1$2(this);
        executor.execute((Runnable)object);
    }

    public void doStop() {
        this.this$0.triggerShutdown();
    }

    public String toString() {
        return this.this$0.toString();
    }
}

