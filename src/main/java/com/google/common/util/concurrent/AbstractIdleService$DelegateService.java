/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Supplier;
import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.AbstractIdleService$1;
import com.google.common.util.concurrent.AbstractIdleService$DelegateService$1;
import com.google.common.util.concurrent.AbstractIdleService$DelegateService$2;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

public final class AbstractIdleService$DelegateService
extends AbstractService {
    public final /* synthetic */ AbstractIdleService this$0;

    private AbstractIdleService$DelegateService(AbstractIdleService abstractIdleService) {
        this.this$0 = abstractIdleService;
    }

    public /* synthetic */ AbstractIdleService$DelegateService(AbstractIdleService abstractIdleService, AbstractIdleService$1 abstractIdleService$1) {
        this(abstractIdleService);
    }

    public final void doStart() {
        Executor executor = this.this$0.executor();
        Object object = AbstractIdleService.access$200(this.this$0);
        executor = MoreExecutors.renamingDecorator(executor, (Supplier)object);
        object = new AbstractIdleService$DelegateService$1(this);
        executor.execute((Runnable)object);
    }

    public final void doStop() {
        Executor executor = this.this$0.executor();
        Object object = AbstractIdleService.access$200(this.this$0);
        executor = MoreExecutors.renamingDecorator(executor, (Supplier)object);
        object = new AbstractIdleService$DelegateService$2(this);
        executor.execute((Runnable)object);
    }

    public String toString() {
        return this.this$0.toString();
    }
}

