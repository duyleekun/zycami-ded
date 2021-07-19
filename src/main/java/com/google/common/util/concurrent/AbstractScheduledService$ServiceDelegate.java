/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$1;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$1;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$2;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$3;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate$Task;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public final class AbstractScheduledService$ServiceDelegate
extends AbstractService {
    private volatile ScheduledExecutorService executorService;
    private final ReentrantLock lock;
    private volatile Future runningTask;
    private final Runnable task;
    public final /* synthetic */ AbstractScheduledService this$0;

    private AbstractScheduledService$ServiceDelegate(AbstractScheduledService object) {
        this.this$0 = object;
        this.lock = object = new ReentrantLock();
        this.task = object = new AbstractScheduledService$ServiceDelegate$Task(this);
    }

    public /* synthetic */ AbstractScheduledService$ServiceDelegate(AbstractScheduledService abstractScheduledService, AbstractScheduledService$1 abstractScheduledService$1) {
        this(abstractScheduledService);
    }

    public static /* synthetic */ ReentrantLock access$200(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        return abstractScheduledService$ServiceDelegate.lock;
    }

    public static /* synthetic */ Future access$300(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        return abstractScheduledService$ServiceDelegate.runningTask;
    }

    public static /* synthetic */ Future access$302(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate, Future future) {
        abstractScheduledService$ServiceDelegate.runningTask = future;
        return future;
    }

    public static /* synthetic */ ScheduledExecutorService access$600(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        return abstractScheduledService$ServiceDelegate.executorService;
    }

    public static /* synthetic */ Runnable access$700(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        return abstractScheduledService$ServiceDelegate.task;
    }

    public final void doStart() {
        ScheduledExecutorService scheduledExecutorService = this.this$0.executor();
        Object object = new AbstractScheduledService$ServiceDelegate$1(this);
        scheduledExecutorService = this.executorService = (scheduledExecutorService = MoreExecutors.renamingDecorator(scheduledExecutorService, (Supplier)object));
        object = new AbstractScheduledService$ServiceDelegate$2(this);
        scheduledExecutorService.execute((Runnable)object);
    }

    public final void doStop() {
        this.runningTask.cancel(false);
        ScheduledExecutorService scheduledExecutorService = this.executorService;
        AbstractScheduledService$ServiceDelegate$3 abstractScheduledService$ServiceDelegate$3 = new AbstractScheduledService$ServiceDelegate$3(this);
        scheduledExecutorService.execute(abstractScheduledService$ServiceDelegate$3);
    }

    public String toString() {
        return this.this$0.toString();
    }
}

