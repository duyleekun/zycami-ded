/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;
import com.google.common.util.concurrent.AbstractExecutionThreadService$1;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AbstractExecutionThreadService$1$2
implements Runnable {
    public final /* synthetic */ AbstractExecutionThreadService$1 this$1;

    public AbstractExecutionThreadService$1$2(AbstractExecutionThreadService$1 var1_1) {
        this.this$1 = var1_1;
    }

    public void run() {
        block23: {
            Service service;
            Throwable throwable2;
            Service service2;
            block22: {
                try {
                    service2 = this.this$1;
                }
                catch (Throwable throwable2) {}
                service2 = ((AbstractExecutionThreadService$1)service2).this$0;
                ((AbstractExecutionThreadService)service2).startUp();
                service2 = this.this$1;
                ((AbstractService)service2).notifyStarted();
                service2 = this.this$1;
                boolean bl2 = ((AbstractService)service2).isRunning();
                if (!bl2) break block22;
                service2 = this.this$1;
                service2 = ((AbstractExecutionThreadService$1)service2).this$0;
                try {
                    ((AbstractExecutionThreadService)service2).run();
                }
                catch (Throwable throwable3) {
                    try {
                        service = this.this$1;
                        service = ((AbstractExecutionThreadService$1)service).this$0;
                        ((AbstractExecutionThreadService)service).shutDown();
                    }
                    catch (Exception exception) {
                        Logger logger = AbstractExecutionThreadService.access$000();
                        Level level = Level.WARNING;
                        String string2 = "Error while attempting to shut down the service after failure.";
                        logger.log(level, string2, exception);
                    }
                }
            }
            service2 = this.this$1;
            {
                service2 = ((AbstractExecutionThreadService$1)service2).this$0;
                ((AbstractExecutionThreadService)service2).shutDown();
                service2 = this.this$1;
                ((AbstractService)service2).notifyStopped();
                break block23;
            }
            {
                finally {
                    service = this.this$1;
                    ((AbstractService)service).notifyFailed(throwable2);
                }
            }
        }
    }
}

