/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.AbstractScheduledService$ServiceDelegate;
import com.google.common.util.concurrent.AbstractService;
import com.google.common.util.concurrent.Service$State;
import java.util.concurrent.locks.ReentrantLock;

public class AbstractScheduledService$ServiceDelegate$3
implements Runnable {
    public final /* synthetic */ AbstractScheduledService$ServiceDelegate this$1;

    public AbstractScheduledService$ServiceDelegate$3(AbstractScheduledService$ServiceDelegate abstractScheduledService$ServiceDelegate) {
        this.this$1 = abstractScheduledService$ServiceDelegate;
    }

    /*
     * Loose catch block
     */
    public void run() {
        Object object;
        Object object2;
        block21: {
            object2 = this.this$1;
            object2 = AbstractScheduledService$ServiceDelegate.access$200((AbstractScheduledService$ServiceDelegate)object2);
            ((ReentrantLock)object2).lock();
            object2 = this.this$1;
            object2 = ((AbstractService)object2).state();
            object = Service$State.STOPPING;
            if (object2 == object) break block21;
            object2 = this.this$1;
            object2 = AbstractScheduledService$ServiceDelegate.access$200((AbstractScheduledService$ServiceDelegate)object2);
            ((ReentrantLock)object2).unlock();
            return;
        }
        object2 = this.this$1;
        object2 = ((AbstractScheduledService$ServiceDelegate)object2).this$0;
        ((AbstractScheduledService)object2).shutDown();
        object2 = this.this$1;
        object2 = AbstractScheduledService$ServiceDelegate.access$200((AbstractScheduledService$ServiceDelegate)object2);
        ((ReentrantLock)object2).unlock();
        object2 = this.this$1;
        ((AbstractService)object2).notifyStopped();
        catch (Throwable throwable) {
            object = this.this$1;
            object = AbstractScheduledService$ServiceDelegate.access$200((AbstractScheduledService$ServiceDelegate)object);
            try {
                ((ReentrantLock)object).unlock();
                throw throwable;
            }
            catch (Throwable throwable2) {
                object = this.this$1;
                ((AbstractService)object).notifyFailed(throwable2);
            }
        }
    }
}

