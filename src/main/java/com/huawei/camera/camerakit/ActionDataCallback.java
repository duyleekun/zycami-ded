/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.camera2.DngCreator
 *  android.media.Image
 *  android.util.Size
 */
package com.huawei.camera.camerakit;

import android.hardware.camera2.DngCreator;
import android.media.Image;
import android.util.Size;
import com.huawei.camera.camerakit.ActionDataCallback$DataCallbackWrapper;
import com.huawei.camera.camerakit.Mode;

public abstract class ActionDataCallback {
    public static ActionDataCallback$DataCallbackWrapper obtain(Mode mode, ActionDataCallback actionDataCallback) {
        ActionDataCallback$DataCallbackWrapper actionDataCallback$DataCallbackWrapper = new ActionDataCallback$DataCallbackWrapper(mode, actionDataCallback, null);
        return actionDataCallback$DataCallbackWrapper;
    }

    public void onImageAvailable(Mode mode, int n10, Image image) {
    }

    public void onRawImageAvailable(Mode mode, int n10, Image image, DngCreator dngCreator) {
    }

    public void onThumbnailAvailable(Mode mode, int n10, Size size, byte[] byArray) {
    }
}

