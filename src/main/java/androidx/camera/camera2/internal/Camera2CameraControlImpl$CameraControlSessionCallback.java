/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.TotalCaptureResult
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.internal.Camera2CameraControlImpl$CaptureResultListener;
import b.a.a.d.f;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;

public final class Camera2CameraControlImpl$CameraControlSessionCallback
extends CameraCaptureSession.CaptureCallback {
    private final Executor mExecutor;
    public final Set mResultListeners;

    public Camera2CameraControlImpl$CameraControlSessionCallback(Executor executor) {
        HashSet hashSet;
        this.mResultListeners = hashSet = new HashSet();
        this.mExecutor = executor;
    }

    private /* synthetic */ void a(TotalCaptureResult object) {
        boolean bl2;
        HashSet<Camera2CameraControlImpl$CaptureResultListener> hashSet = new HashSet<Camera2CameraControlImpl$CaptureResultListener>();
        Iterator iterator2 = this.mResultListeners.iterator();
        while (bl2 = iterator2.hasNext()) {
            Camera2CameraControlImpl$CaptureResultListener camera2CameraControlImpl$CaptureResultListener = (Camera2CameraControlImpl$CaptureResultListener)iterator2.next();
            boolean bl3 = camera2CameraControlImpl$CaptureResultListener.onCaptureResult((TotalCaptureResult)object);
            if (!bl3) continue;
            hashSet.add(camera2CameraControlImpl$CaptureResultListener);
        }
        boolean bl4 = hashSet.isEmpty();
        if (!bl4) {
            object = this.mResultListeners;
            object.removeAll(hashSet);
        }
    }

    public void addListener(Camera2CameraControlImpl$CaptureResultListener camera2CameraControlImpl$CaptureResultListener) {
        this.mResultListeners.add(camera2CameraControlImpl$CaptureResultListener);
    }

    public /* synthetic */ void b(TotalCaptureResult totalCaptureResult) {
        this.a(totalCaptureResult);
    }

    public void onCaptureCompleted(CameraCaptureSession object, CaptureRequest object2, TotalCaptureResult totalCaptureResult) {
        object = this.mExecutor;
        object2 = new f(this, totalCaptureResult);
        object.execute((Runnable)object2);
    }

    public void removeListener(Camera2CameraControlImpl$CaptureResultListener camera2CameraControlImpl$CaptureResultListener) {
        this.mResultListeners.remove(camera2CameraControlImpl$CaptureResultListener);
    }
}

