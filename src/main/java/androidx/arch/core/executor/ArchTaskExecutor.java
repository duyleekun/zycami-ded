/*
 * Decompiled with CFR 0.151.
 */
package androidx.arch.core.executor;

import androidx.arch.core.executor.ArchTaskExecutor$1;
import androidx.arch.core.executor.ArchTaskExecutor$2;
import androidx.arch.core.executor.DefaultTaskExecutor;
import androidx.arch.core.executor.TaskExecutor;
import java.util.concurrent.Executor;

public class ArchTaskExecutor
extends TaskExecutor {
    private static final Executor sIOThreadExecutor;
    private static volatile ArchTaskExecutor sInstance;
    private static final Executor sMainThreadExecutor;
    private TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;

    static {
        Executor executor = new ArchTaskExecutor$1();
        sMainThreadExecutor = executor;
        executor = new ArchTaskExecutor$2();
        sIOThreadExecutor = executor;
    }

    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = defaultTaskExecutor;
    }

    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ArchTaskExecutor getInstance() {
        Object object = sInstance;
        if (object != null) {
            return sInstance;
        }
        object = ArchTaskExecutor.class;
        synchronized (object) {
            ArchTaskExecutor archTaskExecutor = sInstance;
            if (archTaskExecutor == null) {
                sInstance = archTaskExecutor = new ArchTaskExecutor();
            }
            return sInstance;
        }
    }

    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }

    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    public void setDelegate(TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor;
    }
}

