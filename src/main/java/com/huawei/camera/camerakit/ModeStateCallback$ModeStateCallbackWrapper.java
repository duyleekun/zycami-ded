/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  com.huawei.camerakit.api.ModeInterface
 *  com.huawei.camerakit.api.ModeStateCallback
 */
package com.huawei.camera.camerakit;

import com.huawei.camera.camerakit.Mode;
import com.huawei.camera.camerakit.ModeStateCallback;
import com.huawei.camera.camerakit.ModeStateCallback$1;
import com.huawei.camerakit.api.ModeInterface;

public class ModeStateCallback$ModeStateCallbackWrapper
extends com.huawei.camerakit.api.ModeStateCallback {
    private ModeStateCallback callback;
    private Mode modeImpl;

    private ModeStateCallback$ModeStateCallbackWrapper(ModeStateCallback object) {
        this.callback = object;
        this.modeImpl = object = new Mode();
    }

    public /* synthetic */ ModeStateCallback$ModeStateCallbackWrapper(ModeStateCallback modeStateCallback, ModeStateCallback$1 modeStateCallback$1) {
        this(modeStateCallback);
    }

    public void onConfigureFailed(int n10) {
        ModeStateCallback modeStateCallback = this.callback;
        Mode mode = this.modeImpl;
        modeStateCallback.onConfigureFailed(mode, n10);
    }

    public void onConfigured() {
        ModeStateCallback modeStateCallback = this.callback;
        Mode mode = this.modeImpl;
        modeStateCallback.onConfigured(mode);
    }

    public void onCreateFailed(String string2, int n10, int n11) {
        this.callback.onCreateFailed(string2, n10, n11);
    }

    public void onCreated(ModeInterface object) {
        if (object != null) {
            Mode mode;
            this.modeImpl = mode = new Mode((ModeInterface)object);
            object = this.callback;
            ((ModeStateCallback)object).onCreated(mode);
        } else {
            object = this.callback;
            Object var2_3 = null;
            ((ModeStateCallback)object).onCreated(null);
        }
    }

    public void onFatalError(int n10) {
        ModeStateCallback modeStateCallback = this.callback;
        Mode mode = this.modeImpl;
        modeStateCallback.onFatalError(mode, n10);
    }

    public void onReleased() {
        ModeStateCallback modeStateCallback = this.callback;
        Mode mode = this.modeImpl;
        modeStateCallback.onReleased(mode);
    }
}

