/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.CameraExecutor$1;
import androidx.camera.core.impl.CameraFactory;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CameraExecutor
implements Executor {
    private static final int DEFAULT_CORE_THREADS = 1;
    private static final int DEFAULT_MAX_THREADS = 1;
    private static final ThreadFactory THREAD_FACTORY;
    private final Object mExecutorLock;
    private ThreadPoolExecutor mThreadPoolExecutor;

    static {
        CameraExecutor$1 cameraExecutor$1 = new CameraExecutor$1();
        THREAD_FACTORY = cameraExecutor$1;
    }

    public CameraExecutor() {
        Object object;
        this.mExecutorLock = object = new Object();
        this.mThreadPoolExecutor = object = CameraExecutor.createExecutor();
    }

    private static ThreadPoolExecutor createExecutor() {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        LinkedBlockingQueue<Runnable> linkedBlockingQueue = new LinkedBlockingQueue<Runnable>();
        ThreadFactory threadFactory = THREAD_FACTORY;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 0L, timeUnit, linkedBlockingQueue, threadFactory);
        return threadPoolExecutor;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void deinit() {
        Object object = this.mExecutorLock;
        synchronized (object) {
            ThreadPoolExecutor threadPoolExecutor = this.mThreadPoolExecutor;
            boolean bl2 = threadPoolExecutor.isShutdown();
            if (!bl2) {
                threadPoolExecutor = this.mThreadPoolExecutor;
                threadPoolExecutor.shutdown();
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void execute(Runnable runnable) {
        Preconditions.checkNotNull(runnable);
        Object object = this.mExecutorLock;
        synchronized (object) {
            ThreadPoolExecutor threadPoolExecutor = this.mThreadPoolExecutor;
            threadPoolExecutor.execute(runnable);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void init(CameraFactory cameraFactory) {
        ThreadPoolExecutor threadPoolExecutor;
        Preconditions.checkNotNull(cameraFactory);
        Object object = this.mExecutorLock;
        synchronized (object) {
            threadPoolExecutor = this.mThreadPoolExecutor;
            boolean bl2 = threadPoolExecutor.isShutdown();
            if (bl2) {
                this.mThreadPoolExecutor = threadPoolExecutor = CameraExecutor.createExecutor();
            }
            threadPoolExecutor = this.mThreadPoolExecutor;
        }
        int n10 = cameraFactory.getAvailableCameraIds().size();
        n10 = Math.max(1, n10);
        threadPoolExecutor.setMaximumPoolSize(n10);
        threadPoolExecutor.setCorePoolSize(n10);
    }
}

