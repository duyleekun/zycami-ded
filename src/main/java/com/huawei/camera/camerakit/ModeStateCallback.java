/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeStateCallback$ModeStateCallbackWrapper;

public abstract class ModeStateCallback {
    public static ModeStateCallback$ModeStateCallbackWrapper obtain(ModeStateCallback modeStateCallback) {
        ModeStateCallback$ModeStateCallbackWrapper modeStateCallback$ModeStateCallbackWrapper = new ModeStateCallback$ModeStateCallbackWrapper(modeStateCallback, null);
        return modeStateCallback$ModeStateCallbackWrapper;
    }

    public void onConfigureFailed(Mode mode, int n10) {
    }

    public void onConfigured(Mode mode) {
    }

    public void onCreateFailed(String string2, int n10, int n11) {
    }

    public void onCreated(Mode mode) {
    }

    public void onFatalError(Mode mode, int n10) {
    }

    public void onReleased(Mode mode) {
    }
}

