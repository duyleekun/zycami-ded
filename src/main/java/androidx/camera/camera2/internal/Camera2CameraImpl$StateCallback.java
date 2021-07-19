/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraDevice
 *  android.hardware.camera2.CameraDevice$StateCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import androidx.camera.camera2.internal.Camera2CameraImpl;
import androidx.camera.camera2.internal.Camera2CameraImpl$3;
import androidx.camera.camera2.internal.Camera2CameraImpl$InternalState;
import androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback$CameraReopenMonitor;
import androidx.camera.camera2.internal.Camera2CameraImpl$StateCallback$ScheduledReopen;
import androidx.camera.core.Logger;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public final class Camera2CameraImpl$StateCallback
extends CameraDevice.StateCallback {
    public static final int REOPEN_DELAY_MS = 700;
    private final Camera2CameraImpl$StateCallback$CameraReopenMonitor mCameraReopenMonitor;
    private final Executor mExecutor;
    public ScheduledFuture mScheduledReopenHandle;
    private Camera2CameraImpl$StateCallback$ScheduledReopen mScheduledReopenRunnable;
    private final ScheduledExecutorService mScheduler;
    public final /* synthetic */ Camera2CameraImpl this$0;

    public Camera2CameraImpl$StateCallback(Camera2CameraImpl object, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.this$0 = object;
        this.mCameraReopenMonitor = object = new Camera2CameraImpl$StateCallback$CameraReopenMonitor(this);
        this.mExecutor = executor;
        this.mScheduler = scheduledExecutorService;
    }

    private void handleErrorOnOpen(CameraDevice object, int n10) {
        int n11;
        int n12;
        Object object2 = this.this$0.mState;
        Object object3 = Camera2CameraImpl$InternalState.OPENING;
        int n13 = 1;
        if (object2 != object3 && (object2 = this.this$0.mState) != (object3 = Camera2CameraImpl$InternalState.OPENED) && (object2 = this.this$0.mState) != (object3 = Camera2CameraImpl$InternalState.REOPENING)) {
            n12 = 0;
            object2 = null;
        } else {
            n12 = n13;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("Attempt to handle open error from non open state: ");
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.this$0.mState;
        ((StringBuilder)object3).append((Object)camera2CameraImpl$InternalState);
        object3 = ((StringBuilder)object3).toString();
        Preconditions.checkState(n12 != 0, (String)object3);
        object2 = "Camera2CameraImpl";
        int n14 = 2;
        if (n10 != n13 && n10 != n14 && n10 != (n11 = 4)) {
            object3 = new StringBuilder();
            String string2 = "Error observed on open (or opening) camera device ";
            ((StringBuilder)object3).append(string2);
            object = object.getId();
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(": ");
            object = Camera2CameraImpl.getErrorMessage(n10);
            ((StringBuilder)object3).append((String)object);
            ((StringBuilder)object3).append(" closing camera.");
            object = ((StringBuilder)object3).toString();
            Logger.e((String)object2, (String)object);
            object = this.this$0;
            Camera2CameraImpl$InternalState camera2CameraImpl$InternalState2 = Camera2CameraImpl$InternalState.CLOSING;
            ((Camera2CameraImpl)object).setState(camera2CameraImpl$InternalState2);
            object = this.this$0;
            ((Camera2CameraImpl)object).closeCamera(false);
        } else {
            object3 = new Object[n14];
            object3[0] = object = object.getId();
            object3[n13] = object = Camera2CameraImpl.getErrorMessage(n10);
            object = String.format("Attempt to reopen camera[%s] after error[%s]", (Object[])object3);
            Logger.d((String)object2, (String)object);
            this.reopenCameraAfterError();
        }
    }

    private void reopenCameraAfterError() {
        Camera2CameraImpl camera2CameraImpl = this.this$0;
        int n10 = camera2CameraImpl.mCameraDeviceError;
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            camera2CameraImpl = null;
        }
        Preconditions.checkState(n10 != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
        camera2CameraImpl = this.this$0;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = Camera2CameraImpl$InternalState.REOPENING;
        camera2CameraImpl.setState(camera2CameraImpl$InternalState);
        this.this$0.closeCamera(false);
    }

    public boolean cancelScheduledReopen() {
        Object object = this.mScheduledReopenHandle;
        boolean bl2 = false;
        if (object != null) {
            object = this.this$0;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("Cancelling scheduled re-open: ");
            Camera2CameraImpl$StateCallback$ScheduledReopen camera2CameraImpl$StateCallback$ScheduledReopen = this.mScheduledReopenRunnable;
            ((StringBuilder)object2).append(camera2CameraImpl$StateCallback$ScheduledReopen);
            object2 = ((StringBuilder)object2).toString();
            ((Camera2CameraImpl)object).debugLog((String)object2);
            this.mScheduledReopenRunnable.cancel();
            object = null;
            this.mScheduledReopenRunnable = null;
            object2 = this.mScheduledReopenHandle;
            object2.cancel(false);
            this.mScheduledReopenHandle = null;
            bl2 = true;
        }
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onClosed(CameraDevice object) {
        int n10;
        this.this$0.debugLog("CameraDevice.onClosed()");
        Object object2 = this.this$0.mCameraDevice;
        int n11 = 0;
        Object var4_4 = null;
        if (object2 == null) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = "Unexpected onClose callback on camera device: ";
        stringBuilder.append(string2);
        stringBuilder.append(object);
        object = stringBuilder.toString();
        Preconditions.checkState(n10 != 0, (String)object);
        object = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        object2 = this.this$0.mState;
        n10 = ((Enum)object2).ordinal();
        CameraDevice cameraDevice = object[n10];
        n10 = 3;
        if (cameraDevice != n10) {
            n10 = 6;
            if (cameraDevice != n10) {
                n10 = 7;
                if (cameraDevice != n10) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Camera closed while in state: ");
                    Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.this$0.mState;
                    ((StringBuilder)object2).append((Object)camera2CameraImpl$InternalState);
                    object2 = ((StringBuilder)object2).toString();
                    object = new IllegalStateException((String)object2);
                    throw object;
                }
            } else {
                object = this.this$0;
                n10 = ((Camera2CameraImpl)object).mCameraDeviceError;
                if (n10 != 0) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("Camera closed due to error: ");
                    n11 = this.this$0.mCameraDeviceError;
                    String string3 = Camera2CameraImpl.getErrorMessage(n11);
                    ((StringBuilder)object2).append(string3);
                    object2 = ((StringBuilder)object2).toString();
                    ((Camera2CameraImpl)object).debugLog((String)object2);
                    this.scheduleCameraReopen();
                    return;
                }
                ((Camera2CameraImpl)object).tryOpenCameraDevice(false);
                return;
            }
        }
        boolean bl2 = this.this$0.isSessionCloseComplete();
        Preconditions.checkState(bl2);
        object = this.this$0;
        ((Camera2CameraImpl)object).finishClose();
    }

    public void onDisconnected(CameraDevice cameraDevice) {
        this.this$0.debugLog("CameraDevice.onDisconnected()");
        this.onError(cameraDevice, 1);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onError(CameraDevice object, int n10) {
        Camera2CameraImpl camera2CameraImpl = this.this$0;
        camera2CameraImpl.mCameraDevice = object;
        camera2CameraImpl.mCameraDeviceError = n10;
        int[] nArray = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = camera2CameraImpl.mState;
        int n11 = camera2CameraImpl$InternalState.ordinal();
        n11 = nArray[n11];
        int n12 = 2;
        int n13 = 1;
        String string2 = "Camera2CameraImpl";
        String string3 = null;
        int n14 = 3;
        if (n11 != n14) {
            int n15 = 4;
            if (n11 != n15 && n11 != (n15 = 5) && n11 != (n15 = 6)) {
                n15 = 7;
                if (n11 != n15) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("onError() should not be possible from state: ");
                    Camera2CameraImpl$InternalState camera2CameraImpl$InternalState2 = this.this$0.mState;
                    stringBuilder.append((Object)camera2CameraImpl$InternalState2);
                    String string4 = stringBuilder.toString();
                    object = new IllegalStateException(string4);
                    throw object;
                }
            } else {
                Object[] objectArray = new Object[n14];
                String string5 = object.getId();
                objectArray[0] = string5;
                string3 = Camera2CameraImpl.getErrorMessage(n10);
                objectArray[n13] = string3;
                String string6 = this.this$0.mState.name();
                objectArray[n12] = string6;
                String string7 = "CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.";
                String string8 = String.format(string7, objectArray);
                Logger.d(string2, string8);
                this.handleErrorOnOpen((CameraDevice)object, n10);
                return;
            }
        }
        Object[] objectArray = new Object[n14];
        objectArray[0] = object = object.getId();
        objectArray[n13] = object = Camera2CameraImpl.getErrorMessage(n10);
        objectArray[n12] = object = this.this$0.mState.name();
        object = String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", objectArray);
        Logger.e(string2, (String)object);
        object = this.this$0;
        ((Camera2CameraImpl)object).closeCamera(false);
    }

    /*
     * Enabled aggressive block sorting
     */
    public void onOpened(CameraDevice object) {
        Object object2 = this.this$0;
        String string2 = "CameraDevice.onOpened()";
        ((Camera2CameraImpl)object2).debugLog(string2);
        object2 = this.this$0;
        ((Camera2CameraImpl)object2).mCameraDevice = object;
        ((Camera2CameraImpl)object2).updateDefaultRequestBuilderToCameraControl((CameraDevice)object);
        object = this.this$0;
        ((Camera2CameraImpl)object).mCameraDeviceError = 0;
        object2 = Camera2CameraImpl$3.$SwitchMap$androidx$camera$camera2$internal$Camera2CameraImpl$InternalState;
        object = ((Camera2CameraImpl)object).mState;
        int n10 = ((Enum)object).ordinal();
        n10 = (int)object2[n10];
        int n11 = 3 != 0;
        if (n10 != n11) {
            int n12;
            int n13 = 5 != 0;
            if (n10 != n13 && n10 != (n12 = 6)) {
                int n14 = 7;
                if (n10 != n14) {
                    object2 = new StringBuilder();
                    ((StringBuilder)object2).append("onOpened() should not be possible from state: ");
                    Camera2CameraImpl$InternalState camera2CameraImpl$InternalState = this.this$0.mState;
                    ((StringBuilder)object2).append((Object)camera2CameraImpl$InternalState);
                    object2 = ((StringBuilder)object2).toString();
                    object = new IllegalStateException((String)object2);
                    throw object;
                }
            } else {
                object = this.this$0;
                object2 = Camera2CameraImpl$InternalState.OPENED;
                ((Camera2CameraImpl)object).setState((Camera2CameraImpl$InternalState)((Object)object2));
                object = this.this$0;
                ((Camera2CameraImpl)object).openCaptureSession();
                return;
            }
        }
        n10 = this.this$0.isSessionCloseComplete() ? 1 : 0;
        Preconditions.checkState(n10 != 0);
        this.this$0.mCameraDevice.close();
        object = this.this$0;
        boolean bl2 = false;
        object2 = null;
        ((Camera2CameraImpl)object).mCameraDevice = null;
    }

    public void resetReopenMonitor() {
        this.mCameraReopenMonitor.reset();
    }

    public void scheduleCameraReopen() {
        Object object;
        boolean bl2;
        ScheduledFuture scheduledFuture = this.mScheduledReopenRunnable;
        boolean bl3 = true;
        Camera2CameraImpl$StateCallback$ScheduledReopen camera2CameraImpl$StateCallback$ScheduledReopen = null;
        if (scheduledFuture == null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            scheduledFuture = null;
        }
        Preconditions.checkState(bl2);
        scheduledFuture = this.mScheduledReopenHandle;
        if (scheduledFuture != null) {
            bl3 = false;
            object = null;
        }
        Preconditions.checkState(bl3);
        scheduledFuture = this.mCameraReopenMonitor;
        bl2 = ((Camera2CameraImpl$StateCallback$CameraReopenMonitor)((Object)scheduledFuture)).canScheduleCameraReopen();
        if (bl2) {
            object = this.mExecutor;
            scheduledFuture = new ScheduledFuture(this, (Executor)object);
            this.mScheduledReopenRunnable = scheduledFuture;
            scheduledFuture = this.this$0;
            object = new StringBuilder();
            ((StringBuilder)object).append("Attempting camera re-open in 700ms: ");
            camera2CameraImpl$StateCallback$ScheduledReopen = this.mScheduledReopenRunnable;
            ((StringBuilder)object).append(camera2CameraImpl$StateCallback$ScheduledReopen);
            object = ((StringBuilder)object).toString();
            ((Camera2CameraImpl)((Object)scheduledFuture)).debugLog((String)object);
            scheduledFuture = this.mScheduler;
            object = this.mScheduledReopenRunnable;
            long l10 = 700L;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.mScheduledReopenHandle = scheduledFuture = scheduledFuture.schedule((Runnable)object, l10, timeUnit);
        } else {
            Logger.e("Camera2CameraImpl", "Camera reopening attempted for 10000ms without success.");
            scheduledFuture = this.this$0;
            object = Camera2CameraImpl$InternalState.PENDING_OPEN;
            ((Camera2CameraImpl)((Object)scheduledFuture)).setState((Camera2CameraImpl$InternalState)((Object)object), false);
        }
    }
}

