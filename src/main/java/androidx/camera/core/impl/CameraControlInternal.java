/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.CameraControlInternal$1;
import androidx.camera.core.impl.Config;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public interface CameraControlInternal
extends CameraControl {
    public static final CameraControlInternal DEFAULT_EMPTY_INSTANCE;

    static {
        CameraControlInternal$1 cameraControlInternal$1 = new CameraControlInternal$1();
        DEFAULT_EMPTY_INSTANCE = cameraControlInternal$1;
    }

    public void addInteropConfig(Config var1);

    public void cancelAfAeTrigger(boolean var1, boolean var2);

    public void clearInteropConfig();

    public int getFlashMode();

    public Config getInteropConfig();

    public Rect getSensorRect();

    public ListenableFuture setExposureCompensationIndex(int var1);

    public void setFlashMode(int var1);

    public void submitCaptureRequests(List var1);

    public ListenableFuture triggerAePrecapture();

    public ListenableFuture triggerAf();
}

