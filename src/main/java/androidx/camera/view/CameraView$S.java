/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 */
package androidx.camera.view;

import android.view.ScaleGestureDetector;

public class CameraView$S
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    private ScaleGestureDetector.OnScaleGestureListener mListener;

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return this.mListener.onScale(scaleGestureDetector);
    }

    public void setRealGestureDetector(ScaleGestureDetector.OnScaleGestureListener onScaleGestureListener) {
        this.mListener = onScaleGestureListener;
    }
}

