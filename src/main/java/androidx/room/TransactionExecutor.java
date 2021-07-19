/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.TransactionExecutor$1;
import java.util.ArrayDeque;
import java.util.concurrent.Executor;

public class TransactionExecutor
implements Executor {
    private Runnable mActive;
    private final Executor mExecutor;
    private final ArrayDeque mTasks;

    public TransactionExecutor(Executor executor) {
        ArrayDeque arrayDeque;
        this.mTasks = arrayDeque = new ArrayDeque();
        this.mExecutor = executor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void execute(Runnable runnable) {
        synchronized (this) {
            ArrayDeque arrayDeque = this.mTasks;
            TransactionExecutor$1 transactionExecutor$1 = new TransactionExecutor$1(this, runnable);
            arrayDeque.offer(transactionExecutor$1);
            runnable = this.mActive;
            if (runnable == null) {
                this.scheduleNext();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void scheduleNext() {
        synchronized (this) {
            Object object = this.mTasks;
            object = ((ArrayDeque)object).poll();
            this.mActive = object = (Runnable)object;
            if (object != null) {
                Executor executor = this.mExecutor;
                executor.execute((Runnable)object);
            }
            return;
        }
    }
}

