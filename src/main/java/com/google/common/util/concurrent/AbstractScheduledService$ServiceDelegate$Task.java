/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractScheduledService$ServiceDelegate$Task
implements Runnable {
    public final /* synthetic */ AbstractScheduledService$ServiceDelegate this$1;

    public AbstractScheduledService$ServiceDelegate$Task(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        this.this$1 = abstractScheduledService$ServiceDelegate;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Throwable throwable3;
        block8: {
            Object object;
            block9: {
                object = AbstractScheduledService$ServiceDelegate.access$200(this.this$1);
                ((ReentrantLock)object).lock();
                try {
                    object = this.this$1;
                    object = AbstractScheduledService$ServiceDelegate.access$300((AbstractScheduledService$ServiceDelegate)object);
                    boolean bl2 = object.isCancelled();
                    if (bl2) {
                        AbstractScheduledService$ServiceDelegate.access$200(this.this$1).unlock();
                        return;
                    }
                }
                catch (Throwable throwable2) {
                    Service service;
                    try {
                        try {
                            service = this.this$1;
                            service = ((AbstractScheduledService$ServiceDelegate)service).this$0;
                            ((AbstractScheduledService)service).shutDown();
                        }
                        catch (Exception exception) {
                            Logger logger = AbstractScheduledService.access$400();
                            Level level = Level.WARNING;
                            String string2 = "Error while attempting to shut down the service after failure.";
                            logger.log(level, string2, exception);
                        }
                    }
                    catch (Throwable throwable3) {
                        break block8;
                    }
                    service = this.this$1;
                    ((AbstractService)service).notifyFailed(throwable2);
                    object = this.this$1;
                    object = AbstractScheduledService$ServiceDelegate.access$300((AbstractScheduledService$ServiceDelegate)object);
                    service = null;
                    object.cancel(false);
                    break block9;
                }
                {
                    object = this.this$1;
                    object = ((AbstractScheduledService$ServiceDelegate)object).this$0;
                    ((AbstractScheduledService)object).runOneIteration();
                }
            }
            object = AbstractScheduledService$ServiceDelegate.access$200(this.this$1);
            ((ReentrantLock)object).unlock();
            return;
        }
        AbstractScheduledService$ServiceDelegate.access$200(this.this$1).unlock();
        throw throwable3;
    }
}

