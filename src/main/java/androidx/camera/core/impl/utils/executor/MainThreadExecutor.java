/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 */
package androidx.camera.core.impl.utils.executor;

import android.os.Handler;
import android.os.Looper;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public final class MainThreadExecutor {
    private static volatile ScheduledExecutorService sInstance;

    private MainThreadExecutor() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static ScheduledExecutorService getInstance() {
        Object object = sInstance;
        if (object != null) {
            return sInstance;
        }
        object = MainThreadExecutor.class;
        synchronized (object) {
            ScheduledExecutorService scheduledExecutorService = sInstance;
            if (scheduledExecutorService == null) {
                Looper looper = Looper.getMainLooper();
                Handler handler = new Handler(looper);
                sInstance = scheduledExecutorService = new HandlerScheduledExecutorService(handler);
            }
            return sInstance;
        }
    }
}

