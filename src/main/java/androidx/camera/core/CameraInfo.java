/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.ExposureState;
import androidx.lifecycle.LiveData;

public interface CameraInfo {
    public static final String IMPLEMENTATION_TYPE_CAMERA2 = "androidx.camera.camera2";
    public static final String IMPLEMENTATION_TYPE_CAMERA2_LEGACY = "androidx.camera.camera2.legacy";
    public static final String IMPLEMENTATION_TYPE_FAKE = "androidx.camera.fake";
    public static final String IMPLEMENTATION_TYPE_UNKNOWN = "<unknown>";

    public ExposureState getExposureState();

    public String getImplementationType();

    public int getSensorRotationDegrees();

    public int getSensorRotationDegrees(int var1);

    public LiveData getTorchState();

    public LiveData getZoomState();

    public boolean hasFlashUnit();
}

