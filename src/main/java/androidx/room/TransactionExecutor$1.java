/*
 * Decompiled with CFR 0.151.
 */
package androidx.room;

import androidx.room.TransactionExecutor;

public class TransactionExecutor$1
implements Runnable {
    public final /* synthetic */ TransactionExecutor this$0;
    public final /* synthetic */ Runnable val$command;

    public TransactionExecutor$1(TransactionExecutor transactionExecutor, Runnable runnable) {
        this.this$0 = transactionExecutor;
        this.val$command = runnable;
    }

    public void run() {
        try {
            Runnable runnable = this.val$command;
            runnable.run();
            return;
        }
        finally {
            this.this$0.scheduleNext();
        }
    }
}

