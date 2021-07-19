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
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.executor.HandlerScheduledExecutorService;
import java.util.concurrent.ScheduledExecutorService;

public class HandlerScheduledExecutorService$1
extends ThreadLocal {
    public ScheduledExecutorService initialValue() {
        Object object;
        Looper looper = Looper.myLooper();
        if (looper == (object = Looper.getMainLooper())) {
            return CameraXExecutors.mainThreadExecutor();
        }
        looper = Looper.myLooper();
        if (looper != null) {
            object = Looper.myLooper();
            looper = new Handler(object);
            object = new HandlerScheduledExecutorService((Handler)looper);
            return object;
        }
        return null;
    }
}

