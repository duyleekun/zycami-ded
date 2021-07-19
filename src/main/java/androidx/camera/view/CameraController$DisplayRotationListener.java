/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.hardware.display.DisplayManager$DisplayListener
 */
package androidx.camera.view;

import android.hardware.display.DisplayManager;
import androidx.camera.core.Preview;
import androidx.camera.view.CameraController;

public class CameraController$DisplayRotationListener
implements DisplayManager.DisplayListener {
    public final /* synthetic */ CameraController this$0;

    public CameraController$DisplayRotationListener(CameraController cameraController) {
        this.this$0 = cameraController;
    }

    public void onDisplayAdded(int n10) {
    }

    public void onDisplayChanged(int n10) {
        int n11;
        Object object = this.this$0.mPreviewDisplay;
        if (object != null && (n11 = object.getDisplayId()) == n10) {
            CameraController cameraController = this.this$0;
            object = cameraController.mPreview;
            cameraController = cameraController.mPreviewDisplay;
            n10 = cameraController.getRotation();
            ((Preview)object).setTargetRotation(n10);
        }
    }

    public void onDisplayRemoved(int n10) {
    }
}

