/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.SequentialExecutor;

public class SequentialExecutor$1
implements Runnable {
    public final /* synthetic */ SequentialExecutor this$0;
    public final /* synthetic */ Runnable val$task;

    public SequentialExecutor$1(SequentialExecutor sequentialExecutor, Runnable runnable) {
        this.this$0 = sequentialExecutor;
        this.val$task = runnable;
    }

    public void run() {
        this.val$task.run();
    }
}

