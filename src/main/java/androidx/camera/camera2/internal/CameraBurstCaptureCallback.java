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
import androidx.camera.camera2.internal.CameraBurstCaptureCallback$CaptureSequenceCallback;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CameraBurstCaptureCallback
extends CameraCaptureSession.CaptureCallback {
    public final Map mCallbackMap;
    public CameraBurstCaptureCallback$CaptureSequenceCallback mCaptureSequenceCallback = null;

    public CameraBurstCaptureCallback() {
        HashMap hashMap;
        this.mCallbackMap = hashMap = new HashMap();
    }

    private List getCallbacks(CaptureRequest object) {
        Map map = this.mCallbackMap;
        if ((object = (List)map.get(object)) == null) {
            object = Collections.emptyList();
        }
        return object;
    }

    public void addCamera2Callbacks(CaptureRequest captureRequest, List object) {
        Object object2 = (List)this.mCallbackMap.get(captureRequest);
        if (object2 != null) {
            int n10 = object.size();
            int n11 = object2.size();
            ArrayList arrayList = new ArrayList(n10 += n11);
            arrayList.addAll(object);
            arrayList.addAll(object2);
            object = this.mCallbackMap;
            object.put(captureRequest, arrayList);
        } else {
            object2 = this.mCallbackMap;
            object2.put(captureRequest, object);
        }
    }

    public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long l10) {
        boolean bl2;
        Iterator iterator2 = this.getCallbacks(captureRequest).iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10;
            Object object = e10 = iterator2.next();
            object = (CameraCaptureSession.CaptureCallback)e10;
            object.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, l10);
        }
    }

    public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        boolean bl2;
        Iterator iterator2 = this.getCallbacks(captureRequest).iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
        }
    }

    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        boolean bl2;
        Iterator iterator2 = this.getCallbacks(captureRequest).iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
        }
    }

    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        boolean bl2;
        Iterator iterator2 = this.getCallbacks(captureRequest).iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback)iterator2.next();
            captureCallback.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
        }
    }

    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int n10) {
        CameraBurstCaptureCallback$CaptureSequenceCallback cameraBurstCaptureCallback$CaptureSequenceCallback = this.mCaptureSequenceCallback;
        if (cameraBurstCaptureCallback$CaptureSequenceCallback != null) {
            boolean bl2 = true;
            cameraBurstCaptureCallback$CaptureSequenceCallback.onCaptureSequenceCompletedOrAborted(cameraCaptureSession, n10, bl2);
        }
    }

    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int n10, long l10) {
        CameraBurstCaptureCallback$CaptureSequenceCallback cameraBurstCaptureCallback$CaptureSequenceCallback = this.mCaptureSequenceCallback;
        if (cameraBurstCaptureCallback$CaptureSequenceCallback != null) {
            cameraBurstCaptureCallback$CaptureSequenceCallback.onCaptureSequenceCompletedOrAborted(cameraCaptureSession, n10, false);
        }
    }

    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long l10, long l11) {
        boolean bl2;
        Iterator iterator2 = this.getCallbacks(captureRequest).iterator();
        while (bl2 = iterator2.hasNext()) {
            Object e10;
            Object object = e10 = iterator2.next();
            object = (CameraCaptureSession.CaptureCallback)e10;
            object.onCaptureStarted(cameraCaptureSession, captureRequest, l10, l11);
        }
    }

    public void setCaptureSequenceCallback(CameraBurstCaptureCallback$CaptureSequenceCallback cameraBurstCaptureCallback$CaptureSequenceCallback) {
        this.mCaptureSequenceCallback = cameraBurstCaptureCallback$CaptureSequenceCallback;
    }
}

