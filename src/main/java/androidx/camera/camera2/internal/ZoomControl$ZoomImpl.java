/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig$Builder;
import androidx.concurrent.futures.CallbackToFutureAdapter$Completer;

public interface ZoomControl$ZoomImpl {
    public void addRequestOption(Camera2ImplConfig$Builder var1);

    public Rect getCropSensorRegion();

    public float getMaxZoom();

    public float getMinZoom();

    public void onCaptureResult(TotalCaptureResult var1);

    public void resetZoom();

    public void setZoomRatio(float var1, CallbackToFutureAdapter$Completer var2);
}

