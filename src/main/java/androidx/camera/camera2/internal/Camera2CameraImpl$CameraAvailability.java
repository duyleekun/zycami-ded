/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$InternalState;
import androidx.camera.core.impl.CameraStateRegistry$OnOpenAvailableListener;

public final class Camera2CameraImpl$CameraAvailability
extends CameraManager.AvailabilityCallback
implements CameraStateRegistry$OnOpenAvailableListener {
    private boolean mCameraAvailable = true;
    private final String mCameraId;
    public final /* synthetic */ Camera2CameraImpl this$0;

    public Camera2CameraImpl$CameraAvailability(Camera2CameraImpl camera2CameraImpl, String string2) {
        this.this$0 = camera2CameraImpl;
        this.mCameraId = string2;
    }

    public boolean isCameraAvailable() {
        return this.mCameraAvailable;
    }

    public void onCameraAvailable(String object) {
        Object object2 = this.mCameraId;
        boolean bl2 = object2.equals(object);
        if (!bl2) {
            return;
        }
        this.mCameraAvailable = bl2 = true;
        object = this.this$0.mState;
        object2 = Camera2CameraImpl$InternalState.PENDING_OPEN;
        if (object == object2) {
            object = this.this$0;
            object2 = null;
            ((Camera2CameraImpl)object).tryOpenCameraDevice(false);
        }
    }

    public void onCameraUnavailable(String string2) {
        String string3 = this.mCameraId;
        boolean bl2 = string3.equals(string2);
        if (!bl2) {
            return;
        }
        this.mCameraAvailable = false;
    }

    public void onOpenAvailable() {
        Object object = this.this$0.mState;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.PENDING_OPEN;
        if (object == camera2CameraImpl$InternalState) {
            object = this.this$0;
            camera2CameraImpl$InternalState = null;
            ((Camera2CameraImpl)object).tryOpenCameraDevice(false);
        }
    }
}

