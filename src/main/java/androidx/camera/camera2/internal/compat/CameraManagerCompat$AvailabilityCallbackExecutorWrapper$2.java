/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper;

public class CameraManagerCompat$AvailabilityCallbackExecutorWrapper$2
implements Runnable {
    public final /* synthetic */ CameraManagerCompat$AvailabilityCallbackExecutorWrapper this$0;
    public final /* synthetic */ String val$cameraId;

    public CameraManagerCompat$AvailabilityCallbackExecutorWrapper$2(CameraManagerCompat$AvailabilityCallbackExecutorWrapper cameraManagerCompat$AvailabilityCallbackExecutorWrapper, String string2) {
        this.this$0 = cameraManagerCompat$AvailabilityCallbackExecutorWrapper;
        this.val$cameraId = string2;
    }

    public void run() {
        CameraManager.AvailabilityCallback availabilityCallback = this.this$0.mWrappedCallback;
        String string2 = this.val$cameraId;
        availabilityCallback.onCameraAvailable(string2);
    }
}

