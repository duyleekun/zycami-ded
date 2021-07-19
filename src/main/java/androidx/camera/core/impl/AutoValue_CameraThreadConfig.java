/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package androidx.camera.core.impl;

import android.os.Handler;
import androidx.camera.core.impl.CameraThreadConfig;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class AutoValue_CameraThreadConfig
extends CameraThreadConfig {
    private final Executor cameraExecutor;
    private final Handler schedulerHandler;

    public AutoValue_CameraThreadConfig(Executor executor, Handler handler) {
        Objects.requireNonNull(executor, "Null cameraExecutor");
        this.cameraExecutor = executor;
        Objects.requireNonNull(handler, "Null schedulerHandler");
        this.schedulerHandler = handler;
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (object == this) {
            return bl2;
        }
        boolean bl3 = object instanceof CameraThreadConfig;
        if (bl3) {
            boolean bl4;
            Executor executor = this.cameraExecutor;
            Executor executor2 = ((CameraThreadConfig)(object = (CameraThreadConfig)object)).getCameraExecutor();
            bl3 = executor.equals(executor2);
            if (!bl3 || !(bl4 = (executor = this.schedulerHandler).equals(object = ((CameraThreadConfig)object).getSchedulerHandler()))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public Executor getCameraExecutor() {
        return this.cameraExecutor;
    }

    public Handler getSchedulerHandler() {
        return this.schedulerHandler;
    }

    public int hashCode() {
        int n10 = this.cameraExecutor.hashCode();
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.schedulerHandler.hashCode();
        return n10 ^ n11;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("CameraThreadConfig{cameraExecutor=");
        Executor executor = this.cameraExecutor;
        stringBuilder.append(executor);
        stringBuilder.append(", schedulerHandler=");
        executor = this.schedulerHandler;
        stringBuilder.append(executor);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

