/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$OnScaleGestureListener
 */
package androidx.camera.view;

import android.content.Context;
import android.view.ScaleGestureDetector;
import androidx.camera.view.CameraView;
import androidx.camera.view.CameraView$S;

public class CameraView$PinchToZoomGestureDetector
extends ScaleGestureDetector
implements ScaleGestureDetector.OnScaleGestureListener {
    public final /* synthetic */ CameraView this$0;

    public CameraView$PinchToZoomGestureDetector(CameraView cameraView, Context context) {
        CameraView$S cameraView$S = new CameraView$S();
        this(cameraView, context, cameraView$S);
    }

    public CameraView$PinchToZoomGestureDetector(CameraView cameraView, Context context, CameraView$S cameraView$S) {
        this.this$0 = cameraView;
        super(context, (ScaleGestureDetector.OnScaleGestureListener)cameraView$S);
        cameraView$S.setRealGestureDetector(this);
    }

    public boolean onScale(ScaleGestureDetector object) {
        float f10 = object.getScaleFactor();
        float f11 = 1.0f;
        float f12 = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        float f13 = 2.0f;
        if (f12 > 0) {
            f10 = (f10 - f11) * f13 + f11;
        } else {
            f10 = (f11 - f10) * f13;
            f10 = f11 - f10;
        }
        f11 = this.this$0.getZoomRatio() * f10;
        object = this.this$0;
        float f14 = ((CameraView)((Object)object)).getMaxZoomRatio();
        f13 = this.this$0.getMinZoomRatio();
        f10 = ((CameraView)((Object)object)).rangeLimit(f11, f14, f13);
        this.this$0.setZoomRatio(f10);
        return true;
    }

    public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
        return true;
    }

    public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
    }
}

