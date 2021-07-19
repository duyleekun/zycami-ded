/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import java.util.concurrent.ThreadFactory;

public class HighPriorityExecutor$1
implements ThreadFactory {
    private static final String THREAD_NAME = "CameraX-camerax_high_priority";
    public final /* synthetic */ HighPriorityExecutor this$0;

    public HighPriorityExecutor$1(HighPriorityExecutor highPriorityExecutor) {
        this.this$0 = highPriorityExecutor;
    }

    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setPriority(10);
        thread.setName(THREAD_NAME);
        return thread;
    }
}

