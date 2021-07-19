/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl.utils.executor;

import androidx.camera.core.impl.utils.executor.IoExecutor$1;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public final class IoExecutor
implements Executor {
    private static volatile Executor sExecutor;
    private final ExecutorService mIoService;

    public IoExecutor() {
        Object object = new IoExecutor$1(this);
        this.mIoService = object = Executors.newFixedThreadPool(2, (ThreadFactory)object);
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
        object = IoExecutor.class;
        synchronized (object) {
            Executor executor = sExecutor;
            if (executor == null) {
                sExecutor = executor = new IoExecutor();
            }
            return sExecutor;
        }
    }

    public void execute(Runnable runnable) {
        this.mIoService.execute(runnable);
    }
}

