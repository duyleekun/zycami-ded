/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 *  android.hardware.camera2.CaptureFailure
 *  android.hardware.camera2.CaptureRequest
 *  android.hardware.camera2.CaptureResult
 *  android.hardware.camera2.TotalCaptureResult
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks$NoOpSessionCaptureCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class Camera2CaptureCallbacks$ComboSessionCaptureCallback
extends CameraCaptureSession.CaptureCallback {
    private final List mCallbacks;

    public Camera2CaptureCallbacks$ComboSessionCaptureCallback(List object) {
        boolean bl2;
        CameraCaptureSession.CaptureCallback captureCallback;
        this.mCallbacks = captureCallback = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            captureCallback = (CameraCaptureSession.CaptureCallback)object.next();
            boolean bl3 = captureCallback instanceof Camera2CaptureCallbacks.NoOpSessionCaptureCallback;
            if (bl3) continue;
            List list = this.mCallbacks;
            list.add(captureCallback);
        }
    }

    public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long l10) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10;
            Object object = e10 = iterator2.next();
            object = (CameraCaptureSession.CaptureCallback)e10;
            object.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, l10);
        }
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
    }

    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
    }

    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }
    }

    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int n10) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureSequenceAborted(cameraCaptureSession, n10);
        }
    }

    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int n10, long l10) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureSequenceCompleted(cameraCaptureSession, n10, l10);
        }
    }

    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long l10, long l11) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10;
            Object object = e10 = iterator2.next();
            object = (CameraCaptureSession.CaptureCallback)e10;
            object.onCaptureStarted(cameraCaptureSession, captureRequest, l10, l11);
        }
    }
}

