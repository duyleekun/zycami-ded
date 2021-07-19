/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$NoOpCameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class CameraCaptureCallbacks$ComboCameraCaptureCallback
extends CameraCaptureCallback {
    private final List mCallbacks;

    public CameraCaptureCallbacks$ComboCameraCaptureCallback(List object) {
        boolean bl2;
        Object object2 = new ArrayList();
        this.mCallbacks = object2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = (CameraCaptureCallback)object.next();
            boolean bl3 = object2 instanceof CameraCaptureCallbacks$NoOpCameraCaptureCallback;
            if (bl3) continue;
            List list = this.mCallbacks;
            list.add(object2);
        }
    }

    public List getCallbacks() {
        return this.mCallbacks;
    }

    public void onCaptureCancelled() {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
            cameraCaptureCallback.onCaptureCancelled();
        }
    }

    public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
            cameraCaptureCallback.onCaptureCompleted(cameraCaptureResult);
        }
    }

    public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
        boolean bl2;
        Iterator iterator2 = this.mCallbacks.iterator();
        while (bl2 = iterator2.hasNext()) {
            CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)iterator2.next();
            cameraCaptureCallback.onCaptureFailed(cameraCaptureFailure);
        }
    }
}

