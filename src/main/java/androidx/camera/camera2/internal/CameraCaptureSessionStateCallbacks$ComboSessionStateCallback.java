/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession
 *  android.hardware.camera2.CameraCaptureSession$StateCallback
 *  android.view.Surface
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import android.view.Surface;
import androidx.camera.camera2.internal.CameraCaptureSessionStateCallbacks$NoOpSessionStateCallback;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CameraCaptureSessionStateCallbacks$ComboSessionStateCallback
extends CameraCaptureSession.StateCallback {
    private final List mCallbacks;

    public CameraCaptureSessionStateCallbacks$ComboSessionStateCallback(List object) {
        boolean bl2;
        CameraCaptureSession.StateCallback stateCallback;
        this.mCallbacks = stateCallback = new ArrayList();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            stateCallback = (CameraCaptureSession.StateCallback)object.next();
            boolean bl3 = stateCallback instanceof CameraCaptureSessionStateCallbacks.NoOpSessionStateCallback;
            if (bl3) continue;
            List list = this.mCallbacks;
            list.add(stateCallback);
        }
    }

    public void onActive(CameraCaptureSession cameraCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onActive(cameraCaptureSession);
        }
    }

    public void onCaptureQueueEmpty(CameraCaptureSession cameraCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onCaptureQueueEmpty(cameraCaptureSession);
        }
    }

    public void onClosed(CameraCaptureSession cameraCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onClosed(cameraCaptureSession);
        }
    }

    public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onConfigureFailed(cameraCaptureSession);
        }
    }

    public void onConfigured(CameraCaptureSession cameraCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onConfigured(cameraCaptureSession);
        }
    }

    public void onReady(CameraCaptureSession cameraCaptureSession) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onReady(cameraCaptureSession);
        }
    }

    public void onSurfacePrepared(CameraCaptureSession cameraCaptureSession, Surface surface) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.StateCallback stateCallback = (CameraCaptureSession.StateCallback)iterator2.next();
            stateCallback.onSurfacePrepared(cameraCaptureSession, surface);
        }
    }
}

