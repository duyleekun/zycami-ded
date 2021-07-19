/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.Service$Listener;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.ScheduledExecutorService;

public class AbstractScheduledService$1
extends Service$Listener {
    public final /* synthetic */ AbstractScheduledService this$0;
    public final /* synthetic */ ScheduledExecutorService val$executor;

    public AbstractScheduledService$1(AbstractScheduledService abstractScheduledService, ScheduledExecutorService scheduledExecutorService) {
        this.this$0 = abstractScheduledService;
        this.val$executor = scheduledExecutorService;
    }

    public void failed(Service$State service$State, Throwable throwable) {
        this.val$executor.shutdown();
    }

    public void terminated(Service$State service$State) {
        this.val$executor.shutdown();
    }
}

