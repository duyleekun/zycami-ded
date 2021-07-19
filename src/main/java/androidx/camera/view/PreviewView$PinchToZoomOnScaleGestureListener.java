/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 */
package androidx.camera.view;

import android.view.ScaleGestureDetector;
import androidx.camera.view.CameraController;
import androidx.camera.view.PreviewView;

public class PreviewView$PinchToZoomOnScaleGestureListener
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public final /* synthetic */ PreviewView this$0;

    public PreviewView$PinchToZoomOnScaleGestureListener(PreviewView previewView) {
        this.this$0 = previewView;
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        CameraController cameraController = this.this$0.mCameraController;
        if (cameraController != null) {
            float f10 = scaleGestureDetector.getScaleFactor();
            cameraController.onPinchToZoom(f10);
        }
        return true;
    }
}

