/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.MoreExecutors;
import java.util.concurrent.Executor;

public class AbstractIdleService$1
implements Executor {
    public final /* synthetic */ AbstractIdleService this$0;

    public AbstractIdleService$1(AbstractIdleService abstractIdleService) {
        this.this$0 = abstractIdleService;
    }

    public void execute(Runnable runnable) {
        MoreExecutors.newThread((String)AbstractIdleService.access$200(this.this$0).get(), runnable).start();
    }
}

