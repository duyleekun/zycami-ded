/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$ComboCameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureCallbacks$NoOpCameraCaptureCallback;
import java.util.Arrays;
import java.util.List;

public final class CameraCaptureCallbacks {
    private CameraCaptureCallbacks() {
    }

    public static CameraCaptureCallback createComboCallback(List list) {
        int n10;
        int n11 = list.isEmpty();
        if (n11 != 0) {
            return CameraCaptureCallbacks.createNoOpCallback();
        }
        n11 = list.size();
        if (n11 == (n10 = 1)) {
            return (CameraCaptureCallback)list.get(0);
        }
        CameraCaptureCallbacks$ComboCameraCaptureCallback cameraCaptureCallbacks$ComboCameraCaptureCallback = new CameraCaptureCallbacks$ComboCameraCaptureCallback(list);
        return cameraCaptureCallbacks$ComboCameraCaptureCallback;
    }

    public static CameraCaptureCallback createComboCallback(CameraCaptureCallback ... cameraCaptureCallbackArray) {
        return CameraCaptureCallbacks.createComboCallback(Arrays.asList(cameraCaptureCallbackArray));
    }

    public static CameraCaptureCallback createNoOpCallback() {
        CameraCaptureCallbacks$NoOpCameraCaptureCallback cameraCaptureCallbacks$NoOpCameraCaptureCallback = new CameraCaptureCallbacks$NoOpCameraCaptureCallback();
        return cameraCaptureCallbacks$NoOpCameraCaptureCallback;
    }
}

