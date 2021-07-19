/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.CameraCaptureSession$CaptureCallback
 */
package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCaptureSession;
import androidx.camera.camera2.internal.Camera2CaptureCallbacks;
import androidx.camera.camera2.internal.CaptureCallbackAdapter;
import androidx.camera.camera2.internal.CaptureCallbackContainer;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$ComboCameraCaptureCallback;
import java.util.ArrayList;
import java.util.List;

public final class CaptureCallbackConverter {
    private CaptureCallbackConverter() {
    }

    public static CameraCaptureSession.CaptureCallback toCaptureCallback(CameraCaptureCallback cameraCaptureCallback) {
        if (cameraCaptureCallback == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        CaptureCallbackConverter.toCaptureCallback(cameraCaptureCallback, arrayList);
        int n10 = arrayList.size();
        int n11 = 1;
        if (n10 == n11) {
            n10 = 0;
            cameraCaptureCallback = (CameraCaptureSession.CaptureCallback)arrayList.get(0);
        } else {
            cameraCaptureCallback = Camera2CaptureCallbacks.createComboCallback(arrayList);
        }
        return cameraCaptureCallback;
    }

    public static void toCaptureCallback(CameraCaptureCallback object, List list) {
        boolean bl2 = object instanceof CameraCaptureCallbacks$ComboCameraCaptureCallback;
        if (bl2) {
            object = ((CameraCaptureCallbacks$ComboCameraCaptureCallback)object).getCallbacks().iterator();
            while (bl2 = object.hasNext()) {
                CameraCaptureCallback cameraCaptureCallback = (CameraCaptureCallback)object.next();
                CaptureCallbackConverter.toCaptureCallback(cameraCaptureCallback, list);
            }
        } else {
            bl2 = object instanceof CaptureCallbackContainer;
            if (bl2) {
                object = ((CaptureCallbackContainer)object).getCaptureCallback();
                list.add(object);
            } else {
                CaptureCallbackAdapter captureCallbackAdapter = new CaptureCallbackAdapter((CameraCaptureCallback)object);
                list.add(captureCallbackAdapter);
            }
        }
    }
}

