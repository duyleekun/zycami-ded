/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core.impl;

import android.os.Handler;
import androidx.camera.core.impl.AutoValue_CameraThreadConfig;
import java.util.concurrent.Executor;

public abstract class CameraThreadConfig {
    public static CameraThreadConfig create(Executor executor, Handler handler) {
        AutoValue_CameraThreadConfig autoValue_CameraThreadConfig = new AutoValue_CameraThreadConfig(executor, handler);
        return autoValue_CameraThreadConfig;
    }

    public abstract Executor getCameraExecutor();

    public abstract Handler getSchedulerHandler();
}

