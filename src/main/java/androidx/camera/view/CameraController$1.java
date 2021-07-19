/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package androidx.camera.view;

import android.content.Context;
import androidx.camera.view.CameraController;
import androidx.camera.view.SensorRotationListener;

public class CameraController$1
extends SensorRotationListener {
    public final /* synthetic */ CameraController this$0;

    public CameraController$1(CameraController cameraController, Context context) {
        this.this$0 = cameraController;
        super(context);
    }

    public void onRotationChanged(int n10) {
        this.this$0.mImageCapture.setTargetRotation(n10);
        this.this$0.mVideoCapture.setTargetRotation(n10);
    }
}

