/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.Logger;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import androidx.camera.core.impl.utils.executor.SequentialExecutor$WorkerRunningState;
import java.util.Deque;

public final class SequentialExecutor$QueueWorker
implements Runnable {
    public final /* synthetic */ SequentialExecutor this$0;

    public SequentialExecutor$QueueWorker(SequentialExecutor sequentialExecutor) {
        this.this$0 = sequentialExecutor;
    }

    /*
     * Loose catch block
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void workOnQueue() {
        Object object;
        Object object2;
        boolean bl2 = false;
        Object object3 = null;
        boolean bl3 = false;
        Thread thread = null;
        while (true) {
            Object object4 = this.this$0;
            object4 = ((SequentialExecutor)object4).mQueue;
            // MONITORENTER : object4
            if (bl2) break block14;
            object3 = this.this$0;
            object2 = ((SequentialExecutor)object3).mWorkerRunningState;
            object = SequentialExecutor$WorkerRunningState.RUNNING;
            if (object2 != object) break block15;
            break;
        }
        catch (Throwable throwable) {
            if (!bl3) throw throwable;
            thread = Thread.currentThread();
            thread.interrupt();
            throw throwable;
        }
        {
            block14: {
                block15: {
                    // MONITOREXIT : object4
                    if (!bl3) return;
                    object3 = Thread.currentThread();
                    ((Thread)object3).interrupt();
                    return;
                }
                long l10 = ((SequentialExecutor)object3).mWorkerRunCount;
                long l11 = 1L;
                ((SequentialExecutor)object3).mWorkerRunCount = l10 += l11;
                ((SequentialExecutor)object3).mWorkerRunningState = object;
                bl2 = true;
            }
            object2 = this.this$0;
            object2 = object2.mQueue;
            object2 = object2.poll();
            if ((object2 = (Runnable)object2) == null) {
                object3 = this.this$0;
                object2 = SequentialExecutor$WorkerRunningState.IDLE;
                ((SequentialExecutor)object3).mWorkerRunningState = object2;
                // MONITOREXIT : object4
                if (!bl3) return;
                object3 = Thread.currentThread();
                ((Thread)object3).interrupt();
                return;
            }
            // MONITOREXIT : object4
            boolean bl4 = Thread.interrupted();
            bl3 |= bl4;
            try {
                object2.run();
            }
            catch (RuntimeException runtimeException) {
                object = "SequentialExecutor";
                StringBuilder stringBuilder = new StringBuilder();
                String string2 = "Exception while executing runnable ";
                stringBuilder.append(string2);
                stringBuilder.append(object2);
                object2 = stringBuilder.toString();
                Logger.e((String)object, (String)object2, runtimeException);
            }
            continue;
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
            Deque deque = this.this$0.mQueue;
            synchronized (deque) {
                SequentialExecutor$WorkerRunningState sequentialExecutor$WorkerRunningState;
                SequentialExecutor sequentialExecutor = this.this$0;
                sequentialExecutor.mWorkerRunningState = sequentialExecutor$WorkerRunningState = SequentialExecutor$WorkerRunningState.IDLE;
                throw error;
            }
        }
    }
}

