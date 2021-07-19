/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.graphics.SurfaceTexture
 *  android.util.Size
 */
package com.google.mediapipe.components;

import android.app.Activity;
import android.graphics.SurfaceTexture;
import android.util.Size;
import com.google.mediapipe.components.CameraHelper$CameraFacing;
import com.google.mediapipe.components.CameraHelper$OnCameraStartedListener;

public abstract class CameraHelper {
    public static final String TAG = "CameraHelper";
    public CameraHelper$CameraFacing cameraFacing;
    public CameraHelper$OnCameraStartedListener onCameraStartedListener;

    public abstract Size computeDisplaySizeFromViewSize(Size var1);

    public abstract boolean isCameraRotated();

    public void setOnCameraStartedListener(CameraHelper$OnCameraStartedListener cameraHelper$OnCameraStartedListener) {
        this.onCameraStartedListener = cameraHelper$OnCameraStartedListener;
    }

    public abstract void startCamera(Activity var1, CameraHelper$CameraFacing var2, SurfaceTexture var3);
}

