/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core;

import androidx.camera.core.FocusMeteringAction;
import com.google.common.util.concurrent.ListenableFuture;

public interface CameraControl {
    public ListenableFuture cancelFocusAndMetering();

    public ListenableFuture enableTorch(boolean var1);

    public ListenableFuture setExposureCompensationIndex(int var1);

    public ListenableFuture setLinearZoom(float var1);

    public ListenableFuture setZoomRatio(float var1);

    public ListenableFuture startFocusAndMetering(FocusMeteringAction var1);
}

