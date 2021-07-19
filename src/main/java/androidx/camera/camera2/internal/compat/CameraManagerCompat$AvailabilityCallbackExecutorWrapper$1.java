/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.internal.compat;

import androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper;

public class CameraManagerCompat$AvailabilityCallbackExecutorWrapper$1
implements Runnable {
    public final /* synthetic */ CameraManagerCompat$AvailabilityCallbackExecutorWrapper this$0;

    public CameraManagerCompat$AvailabilityCallbackExecutorWrapper$1(CameraManagerCompat$AvailabilityCallbackExecutorWrapper availabilityCallbackExecutorWrapper) {
        this.this$0 = availabilityCallbackExecutorWrapper;
    }

    public void run() {
        this.this$0.mWrappedCallback.onCameraAccessPrioritiesChanged();
    }
}

