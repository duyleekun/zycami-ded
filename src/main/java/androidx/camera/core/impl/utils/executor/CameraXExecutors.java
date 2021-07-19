/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import androidx.camera.core.impl.utils.executor.DirectExecutor;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import androidx.camera.core.impl.utils.executor.HighPriorityExecutor;
import androidx.camera.core.impl.utils.executor.IoExecutor;
import androidx.camera.core.impl.utils.executor.MainThreadExecutor;
import androidx.camera.core.impl.utils.executor.SequentialExecutor;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class CameraXExecutors {
    private CameraXExecutors() {
    }

    public static Executor directExecutor() {
        return DirectExecutor.getInstance();
    }

    public static Executor highPriorityExecutor() {
        return HighPriorityExecutor.getInstance();
    }

    public static Executor ioExecutor() {
        return IoExecutor.getInstance();
    }

    public static boolean isSequentialExecutor(Executor executor) {
        return executor instanceof SequentialExecutor;
    }

    public static ScheduledExecutorService mainThreadExecutor() {
        return MainThreadExecutor.getInstance();
    }

    public static ScheduledExecutorService myLooperExecutor() {
        return HandlerScheduledExecutorService.currentThreadExecutor();
    }

    public static ScheduledExecutorService newHandlerExecutor(Handler handler) {
        HandlerScheduledExecutorService handlerScheduledExecutorService = new HandlerScheduledExecutorService(handler);
        return handlerScheduledExecutorService;
    }

    public static Executor newSequentialExecutor(Executor executor) {
        SequentialExecutor sequentialExecutor = new SequentialExecutor(executor);
        return sequentialExecutor;
    }
}

