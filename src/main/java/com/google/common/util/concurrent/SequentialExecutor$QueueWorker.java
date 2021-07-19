/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.util.concurrent.SequentialExecutor;
import com.google.common.util.concurrent.SequentialExecutor$1;
import com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState;
import java.util.Deque;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class SequentialExecutor$QueueWorker
implements Runnable {
    public final /* synthetic */ SequentialExecutor this$0;

    private SequentialExecutor$QueueWorker(SequentialExecutor sequentialExecutor) {
        this.this$0 = sequentialExecutor;
    }

    public /* synthetic */ SequentialExecutor$QueueWorker(SequentialExecutor sequentialExecutor, SequentialExecutor$1 sequentialExecutor$1) {
        this(sequentialExecutor);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void workOnQueue() {
        boolean bl2 = false;
        Object object = null;
        boolean bl3 = false;
        Thread thread = null;
        while (true) {
            Object object2;
            try {
                Object object3 = this.this$0;
                object3 = SequentialExecutor.access$100((SequentialExecutor)object3);
                synchronized (object3) {
                    if (bl2) break block18;
                    object = this.this$0;
                }
            }
            catch (Throwable throwable) {
                if (bl3) {
                    thread = Thread.currentThread();
                    thread.interrupt();
                }
                throw throwable;
            }
            {
                block18: {
                    if ((object = SequentialExecutor.access$200((SequentialExecutor)object)) == (object2 = SequentialExecutor$WorkerRunningState.RUNNING)) {
                        // MONITOREXIT @DISABLED, blocks:[16, 9, 12] lbl19 : MonitorExitStatement: MONITOREXIT : var5_6
                        if (bl3) {
                            object = Thread.currentThread();
                            ((Thread)object).interrupt();
                        }
                        return;
                    }
                    object = this.this$0;
                    SequentialExecutor.access$308((SequentialExecutor)object);
                    object = this.this$0;
                    SequentialExecutor.access$202((SequentialExecutor)object, (SequentialExecutor$WorkerRunningState)((Object)object2));
                    bl2 = true;
                }
                object2 = this.this$0;
                object2 = SequentialExecutor.access$100((SequentialExecutor)object2);
                object2 = object2.poll();
                if ((object2 = (Runnable)object2) == null) {
                    object = this.this$0;
                    object2 = SequentialExecutor$WorkerRunningState.IDLE;
                    SequentialExecutor.access$202((SequentialExecutor)object, (SequentialExecutor$WorkerRunningState)((Object)object2));
                    // MONITOREXIT @DISABLED, blocks:[9, 12, 14] lbl39 : MonitorExitStatement: MONITOREXIT : var5_6
                    if (bl3) {
                        object = Thread.currentThread();
                        ((Thread)object).interrupt();
                    }
                    return;
                }
            }
            {
                boolean bl4 = Thread.interrupted();
                bl3 |= bl4;
                try {
                    object2.run();
                }
                catch (RuntimeException runtimeException) {
                    Logger logger = SequentialExecutor.access$400();
                    Level level = Level.SEVERE;
                    StringBuilder stringBuilder = new StringBuilder();
                    String string2 = "Exception while executing runnable ";
                    stringBuilder.append(string2);
                    stringBuilder.append(object2);
                    object2 = stringBuilder.toString();
                    logger.log(level, (String)object2, runtimeException);
                    continue;
                }
            }
            break;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        try {
            this.workOnQueue();
            return;
        }
        catch (Error error) {
            Deque deque = SequentialExecutor.access$100(this.this$0);
            synchronized (deque) {
                SequentialExecutor sequentialExecutor = this.this$0;
                SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState = SequentialExecutor$WorkerRunningState.IDLE;
                SequentialExecutor.access$202(sequentialExecutor, sequentialExecutor$WorkerRunningState);
                throw error;
            }
        }
    }
}

