/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.SequentialExecutor$1;
import com.google.common.util.concurrent.SequentialExecutor$QueueWorker;
import com.google.common.util.concurrent.SequentialExecutor$WorkerRunningState;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.logging.Logger;

public final class SequentialExecutor
implements Executor {
    private static final Logger log = Logger.getLogger(SequentialExecutor.class.getName());
    private final Executor executor;
    private final Deque queue;
    private final SequentialExecutor$QueueWorker worker;
    private long workerRunCount;
    private SequentialExecutor$WorkerRunningState workerRunningState;

    public SequentialExecutor(Executor executor) {
        Object object;
        this.queue = object = new Object();
        object = SequentialExecutor$WorkerRunningState.IDLE;
        this.workerRunningState = object;
        this.workerRunCount = 0L;
        super(this, null);
        this.worker = object;
        this.executor = executor = (Executor)Preconditions.checkNotNull(executor);
    }

    public static /* synthetic */ Deque access$100(SequentialExecutor sequentialExecutor) {
        return sequentialExecutor.queue;
    }

    public static /* synthetic */ SequentialExecutor$WorkerRunningState access$200(SequentialExecutor sequentialExecutor) {
        return sequentialExecutor.workerRunningState;
    }

    public static /* synthetic */ SequentialExecutor$WorkerRunningState access$202(SequentialExecutor sequentialExecutor, SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState) {
        sequentialExecutor.workerRunningState = sequentialExecutor$WorkerRunningState;
        return sequentialExecutor$WorkerRunningState;
    }

    public static /* synthetic */ long access$308(SequentialExecutor sequentialExecutor) {
        long l10;
        long l11 = sequentialExecutor.workerRunCount;
        sequentialExecutor.workerRunCount = l10 = 1L + l11;
        return l11;
    }

    public static /* synthetic */ Logger access$400() {
        return log;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void execute(Runnable object) {
        Preconditions.checkNotNull(object);
        Object object2 = this.queue;
        synchronized (object2) {
            Object object3 = this.workerRunningState;
            Object object4 = SequentialExecutor$WorkerRunningState.RUNNING;
            if (object3 != object4 && object3 != (object4 = SequentialExecutor$WorkerRunningState.QUEUED)) {
                boolean bl2;
                block22: {
                    Object object5;
                    long l10 = this.workerRunCount;
                    object3 = new SequentialExecutor$1(this, (Runnable)object);
                    object = this.queue;
                    object.add(object3);
                    object = SequentialExecutor$WorkerRunningState.QUEUING;
                    this.workerRunningState = object;
                    // MONITOREXIT @DISABLED, blocks:[21, 11] lbl15 : MonitorExitStatement: MONITOREXIT : var2_5 /* !! */ 
                    bl2 = true;
                    try {
                        object5 = this.executor;
                        SequentialExecutor$QueueWorker sequentialExecutor$QueueWorker = this.worker;
                        object5.execute(sequentialExecutor$QueueWorker);
                        object3 = this.workerRunningState;
                        if (object3 == object) {
                            bl2 = false;
                            object2 = null;
                        }
                        if (bl2) {
                            return;
                        }
                        object5 = this.queue;
                    }
                    catch (Error error) {
                        break block22;
                    }
                    catch (RuntimeException runtimeException) {
                        // empty catch block
                        break block22;
                    }
                    synchronized (object5) {
                        long l11 = this.workerRunCount;
                        bl2 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                        if (!bl2 && (object2 = this.workerRunningState) == object) {
                            this.workerRunningState = object4;
                        }
                        return;
                    }
                }
                object4 = this.queue;
                synchronized (object4) {
                    void var1_4;
                    boolean bl3;
                    Object object6 = this.workerRunningState;
                    SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState = SequentialExecutor$WorkerRunningState.IDLE;
                    if (object6 != sequentialExecutor$WorkerRunningState && object6 != (sequentialExecutor$WorkerRunningState = SequentialExecutor$WorkerRunningState.QUEUING) || !(bl3 = (object6 = this.queue).removeLastOccurrence(object3))) {
                        bl2 = false;
                        object2 = null;
                    }
                    bl3 = var1_4 instanceof RejectedExecutionException;
                    if (bl3 && !bl2) {
                        return;
                    }
                    throw (Throwable)var1_4;
                }
            }
            object3 = this.queue;
            object3.add(object);
            return;
        }
    }
}

