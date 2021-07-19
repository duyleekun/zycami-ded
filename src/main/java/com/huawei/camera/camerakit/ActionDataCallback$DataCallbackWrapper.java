/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.DngCreator
 *  android.media.Image
 *  android.util.Size
 *  com.huawei.camerakit.api.ActionDataCallback
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.DngCreator;
import android.media.Image;
import android.util.Size;
import com.huawei.camera.camerakit.ActionDataCallback;
import com.huawei.camera.camerakit.ActionDataCallback$1;
import com.huawei.camera.camerakit.CameraKit;
import com.huawei.camera.camerakit.Mode;

public final class ActionDataCallback$DataCallbackWrapper
extends com.huawei.camerakit.api.ActionDataCallback {
    private ActionDataCallback dataCallback;
    private Mode mode;

    private ActionDataCallback$DataCallbackWrapper(Mode mode, ActionDataCallback actionDataCallback) {
        this.mode = mode;
        this.dataCallback = actionDataCallback;
    }

    public /* synthetic */ ActionDataCallback$DataCallbackWrapper(Mode mode, ActionDataCallback actionDataCallback, ActionDataCallback$1 actionDataCallback$1) {
        this(mode, actionDataCallback);
    }

    public void onImageAvailable(int n10, Image image) {
        ActionDataCallback actionDataCallback = this.dataCallback;
        Mode mode = this.mode;
        actionDataCallback.onImageAvailable(mode, n10, image);
    }

    public void onRawImageAvailable(int n10, Image image, DngCreator dngCreator) {
        int n11;
        int n12 = CameraKit.getApiLevel();
        if (n12 >= (n11 = 1)) {
            ActionDataCallback actionDataCallback = this.dataCallback;
            Mode mode = this.mode;
            actionDataCallback.onRawImageAvailable(mode, n10, image, dngCreator);
        }
    }

    public void onThumbnailAvailable(int n10, Size size, byte[] byArray) {
        ActionDataCallback actionDataCallback = this.dataCallback;
        Mode mode = this.mode;
        actionDataCallback.onThumbnailAvailable(mode, n10, size, byArray);
    }
}

