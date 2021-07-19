/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.display.DisplayManager$DisplayListener
 */
package androidx.camera.view;

import android.hardware.display.DisplayManager;
import androidx.camera.view.CameraView;

public class CameraView$1
implements DisplayManager.DisplayListener {
    public final /* synthetic */ CameraView this$0;

    public CameraView$1(CameraView cameraView) {
        this.this$0 = cameraView;
    }

    public void onDisplayAdded(int n10) {
    }

    public void onDisplayChanged(int n10) {
        this.this$0.mCameraModule.invalidateView();
    }

    public void onDisplayRemoved(int n10) {
    }
}

