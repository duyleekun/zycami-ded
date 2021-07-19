/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.camera2.impl;

import androidx.camera.camera2.impl.CameraEventCallback;
import androidx.camera.camera2.impl.CameraEventCallbacks$ComboCameraEventCallback;
import androidx.camera.core.impl.MultiValueSet;
import java.util.Arrays;
import java.util.List;

public final class CameraEventCallbacks
extends MultiValueSet {
    public CameraEventCallbacks(CameraEventCallback ... object) {
        object = Arrays.asList(object);
        this.addAll((List)object);
    }

    public static CameraEventCallbacks createEmptyCallback() {
        CameraEventCallback[] cameraEventCallbackArray = new CameraEventCallback[]{};
        CameraEventCallbacks cameraEventCallbacks = new CameraEventCallbacks(cameraEventCallbackArray);
        return cameraEventCallbacks;
    }

    public MultiValueSet clone() {
        CameraEventCallbacks cameraEventCallbacks = CameraEventCallbacks.createEmptyCallback();
        List list = this.getAllItems();
        cameraEventCallbacks.addAll(list);
        return cameraEventCallbacks;
    }

    public CameraEventCallbacks$ComboCameraEventCallback createComboCallback() {
        List list = this.getAllItems();
        CameraEventCallbacks$ComboCameraEventCallback cameraEventCallbacks$ComboCameraEventCallback = new CameraEventCallbacks$ComboCameraEventCallback(list);
        return cameraEventCallbacks$ComboCameraEventCallback;
    }
}

