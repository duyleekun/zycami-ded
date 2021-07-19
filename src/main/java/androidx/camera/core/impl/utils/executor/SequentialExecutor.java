/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.SequentialExecutor$1;
import androidx.camera.core.impl.utils.executor.SequentialExecutor$QueueWorker;
import androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState;
import androidx.core.util.Preconditions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

public final class SequentialExecutor
implements Executor {
    private static final String TAG = "SequentialExecutor";
    private final Executor mExecutor;
    public final Deque mQueue;
    private final SequentialExecutor$QueueWorker mWorker;
    public long mWorkerRunCount;
    public SequentialExecutor$WorkerRunningState mWorkerRunningState;

    public SequentialExecutor(Executor executor) {
        Object object = new ArrayDeque();
        this.mQueue = object;
        this.mWorker = object = new SequentialExecutor$QueueWorker(this);
        object = SequentialExecutor$WorkerRunningState.IDLE;
        this.mWorkerRunningState = object;
        this.mWorkerRunCount = 0L;
        this.mExecutor = executor = (Executor)Preconditions.checkNotNull(executor);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void execute(Runnable object) {
        Preconditions.checkNotNull(object);
        Object object2 = this.mQueue;
        synchronized (object2) {
            Object object3 = this.mWorkerRunningState;
            Object object4 = SequentialExecutor$WorkerRunningState.RUNNING;
            if (object3 != object4 && object3 != (object4 = SequentialExecutor$WorkerRunningState.QUEUED)) {
                boolean bl2;
                block22: {
                    Object object5;
                    long l10 = this.mWorkerRunCount;
                    object3 = new SequentialExecutor$1(this, (Runnable)object);
                    object = this.mQueue;
                    object.add(object3);
                    object = SequentialExecutor$WorkerRunningState.QUEUING;
                    this.mWorkerRunningState = object;
                    // MONITOREXIT @DISABLED, blocks:[21, 11] lbl15 : MonitorExitStatement: MONITOREXIT : var2_5 /* !! */ 
                    bl2 = true;
                    try {
                        object5 = this.mExecutor;
                        SequentialExecutor$QueueWorker sequentialExecutor$QueueWorker = this.mWorker;
                        object5.execute(sequentialExecutor$QueueWorker);
                        object3 = this.mWorkerRunningState;
                        if (object3 == object) {
                            bl2 = false;
                            object2 = null;
                        }
                        if (bl2) {
                            return;
                        }
                        object5 = this.mQueue;
                    }
                    catch (Error error) {
                        break block22;
                    }
                    catch (RuntimeException runtimeException) {
                        // empty catch block
                        break block22;
                    }
                    synchronized (object5) {
                        long l11 = this.mWorkerRunCount;
                        bl2 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                        if (!bl2 && (object2 = this.mWorkerRunningState) == object) {
                            this.mWorkerRunningState = object4;
                        }
                        return;
                    }
                }
                object4 = this.mQueue;
                synchronized (object4) {
                    void var1_4;
                    boolean bl3;
                    Object object6 = this.mWorkerRunningState;
                    SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState = SequentialExecutor$WorkerRunningState.IDLE;
                    if (object6 != sequentialExecutor$WorkerRunningState && object6 != (sequentialExecutor$WorkerRunningState = SequentialExecutor$WorkerRunningState.QUEUING) || !(bl3 = (object6 = this.mQueue).removeLastOccurrence(object3))) {
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
            object3 = this.mQueue;
            object3.add(object);
            return;
        }
    }
}

