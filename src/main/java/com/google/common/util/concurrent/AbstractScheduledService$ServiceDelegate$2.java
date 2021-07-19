/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$Scheduler;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate;
import com.google.common.util.concurrent.AbstractService;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractScheduledService$ServiceDelegate$2
implements Runnable {
    public final /* synthetic */ AbstractScheduledService$ServiceDelegate this$1;

    public AbstractScheduledService$ServiceDelegate$2(AbstractScheduledService$ServiceDelegate serviceDelegate) {
        this.this$1 = serviceDelegate;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = AbstractScheduledService$ServiceDelegate.access$200(this.this$1);
        ((ReentrantLock)object).lock();
        try {
            object = this.this$1;
            object = ((AbstractScheduledService$ServiceDelegate)object).this$0;
            ((AbstractScheduledService)object).startUp();
            object = this.this$1;
            Object object2 = ((AbstractScheduledService$ServiceDelegate)object).this$0;
            object2 = ((AbstractScheduledService)object2).scheduler();
            AbstractScheduledService$ServiceDelegate abstractScheduledService = this.this$1;
            AbstractScheduledService abstractService = abstractScheduledService.this$0;
            AbstractService abstractService2 = AbstractScheduledService.access$500(abstractService);
            Object object3 = this.this$1;
            object3 = AbstractScheduledService$ServiceDelegate.access$600((AbstractScheduledService$ServiceDelegate)object3);
            Object object4 = this.this$1;
            object4 = AbstractScheduledService$ServiceDelegate.access$700((AbstractScheduledService$ServiceDelegate)object4);
            object2 = ((AbstractScheduledService$Scheduler)object2).schedule(abstractService2, (ScheduledExecutorService)object3, (Runnable)object4);
            AbstractScheduledService$ServiceDelegate.access$302((AbstractScheduledService$ServiceDelegate)object, (Future)object2);
            object = this.this$1;
            ((AbstractService)object).notifyStarted();
            return;
        }
        catch (Throwable throwable) {
            try {
                AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate = this.this$1;
                abstractScheduledService$ServiceDelegate.notifyFailed(throwable);
                Object object5 = this.this$1;
                object5 = AbstractScheduledService$ServiceDelegate.access$300((AbstractScheduledService$ServiceDelegate)object5);
                if (object5 == null) return;
                object5 = this.this$1;
                object5 = AbstractScheduledService$ServiceDelegate.access$300((AbstractScheduledService$ServiceDelegate)object5);
                abstractScheduledService$ServiceDelegate = null;
                object5.cancel(false);
                return;
            }
            finally {
                AbstractScheduledService$ServiceDelegate.access$200(this.this$1).unlock();
            }
        }
    }
}

