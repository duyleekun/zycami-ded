/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.HighPriorityExecutor$1;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class HighPriorityExecutor
implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mHighPriorityService;

    public HighPriorityExecutor() {
        Object object = new HighPriorityExecutor$1(this);
        this.mHighPriorityService = object = Executors.newSingleThreadExecutor((ThreadFactory)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static Executor getInstance() {
        Object object = sExecutor;
        if (object != null) {
            return sExecutor;
        }
        object = HighPriorityExecutor.class;
        synchronized (object) {
            Executor executor = sExecutor;
            if (executor == null) {
                sExecutor = executor = new HighPriorityExecutor();
            }
            return sExecutor;
        }
    }

    public void execute(Runnable runnable) {
        this.mHighPriorityService.execute(runnable);
    }
}

