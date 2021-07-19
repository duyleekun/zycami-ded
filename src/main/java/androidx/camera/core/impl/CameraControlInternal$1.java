/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 */
package androidx.camera.core.impl;

import android.graphics.Rect;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.impl.CameraCaptureResult$EmptyCameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.List;

public class CameraControlInternal$1
implements CameraControlInternal {
    public void addInteropConfig(Config config) {
    }

    public void cancelAfAeTrigger(boolean bl2, boolean bl3) {
    }

    public ListenableFuture cancelFocusAndMetering() {
        return Futures.immediateFuture(null);
    }

    public void clearInteropConfig() {
    }

    public ListenableFuture enableTorch(boolean bl2) {
        return Futures.immediateFuture(null);
    }

    public int getFlashMode() {
        return 2;
    }

    public Config getInteropConfig() {
        return null;
    }

    public Rect getSensorRect() {
        Rect rect = new Rect();
        return rect;
    }

    public ListenableFuture setExposureCompensationIndex(int n10) {
        return Futures.immediateFuture(0);
    }

    public void setFlashMode(int n10) {
    }

    public ListenableFuture setLinearZoom(float f10) {
        return Futures.immediateFuture(null);
    }

    public ListenableFuture setZoomRatio(float f10) {
        return Futures.immediateFuture(null);
    }

    public ListenableFuture startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        return Futures.immediateFuture(FocusMeteringResult.emptyInstance());
    }

    public void submitCaptureRequests(List list) {
    }

    public ListenableFuture triggerAePrecapture() {
        return Futures.immediateFuture(CameraCaptureResult$EmptyCameraCaptureResult.create());
    }

    public ListenableFuture triggerAf() {
        return Futures.immediateFuture(CameraCaptureResult$EmptyCameraCaptureResult.create());
    }
}

