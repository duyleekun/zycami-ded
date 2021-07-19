/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraManager$AvailabilityCallback
 */
package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraManager;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper$1;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper$2;
import androidx.camera.camera2.internal.compat.CameraManagerCompat$AvailabilityCallbackExecutorWrapper$3;
import java.util.concurrent.Executor;

public final class CameraManagerCompat$AvailabilityCallbackExecutorWrapper
extends CameraManager.AvailabilityCallback {
    private boolean mDisabled;
    private final Executor mExecutor;
    private final Object mLock;
    public final CameraManager.AvailabilityCallback mWrappedCallback;

    public CameraManagerCompat$AvailabilityCallbackExecutorWrapper(Executor executor, CameraManager.AvailabilityCallback availabilityCallback) {
        Object object;
        this.mLock = object = new Object();
        this.mDisabled = false;
        this.mExecutor = executor;
        this.mWrappedCallback = availabilityCallback;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCameraAccessPrioritiesChanged() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mDisabled;
            if (!bl2) {
                Executor executor = this.mExecutor;
                CameraManagerCompat$AvailabilityCallbackExecutorWrapper$1 cameraManagerCompat$AvailabilityCallbackExecutorWrapper$1 = new CameraManagerCompat$AvailabilityCallbackExecutorWrapper$1(this);
                executor.execute(cameraManagerCompat$AvailabilityCallbackExecutorWrapper$1);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCameraAvailable(String string2) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mDisabled;
            if (!bl2) {
                Executor executor = this.mExecutor;
                CameraManagerCompat$AvailabilityCallbackExecutorWrapper$2 cameraManagerCompat$AvailabilityCallbackExecutorWrapper$2 = new CameraManagerCompat$AvailabilityCallbackExecutorWrapper$2(this, string2);
                executor.execute(cameraManagerCompat$AvailabilityCallbackExecutorWrapper$2);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onCameraUnavailable(String string2) {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2 = this.mDisabled;
            if (!bl2) {
                Executor executor = this.mExecutor;
                CameraManagerCompat$AvailabilityCallbackExecutorWrapper$3 cameraManagerCompat$AvailabilityCallbackExecutorWrapper$3 = new CameraManagerCompat$AvailabilityCallbackExecutorWrapper$3(this, string2);
                executor.execute(cameraManagerCompat$AvailabilityCallbackExecutorWrapper$3);
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setDisabled() {
        Object object = this.mLock;
        synchronized (object) {
            boolean bl2;
            this.mDisabled = bl2 = true;
            return;
        }
    }
}

