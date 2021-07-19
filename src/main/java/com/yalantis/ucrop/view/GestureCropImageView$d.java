/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.ScaleGestureDetector
 *  android.view.ScaleGestureDetector$SimpleOnScaleGestureListener
 */
package com.yalantis.ucrop.view;

import android.view.ScaleGestureDetector;
import com.yalantis.ucrop.view.GestureCropImageView;
import com.yalantis.ucrop.view.GestureCropImageView$a;

public class GestureCropImageView$d
extends ScaleGestureDetector.SimpleOnScaleGestureListener {
    public final /* synthetic */ GestureCropImageView a;

    private GestureCropImageView$d(GestureCropImageView gestureCropImageView) {
        this.a = gestureCropImageView;
    }

    public /* synthetic */ GestureCropImageView$d(GestureCropImageView gestureCropImageView, GestureCropImageView$a gestureCropImageView$a) {
        this(gestureCropImageView);
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        GestureCropImageView gestureCropImageView = this.a;
        float f10 = scaleGestureDetector.getScaleFactor();
        float f11 = GestureCropImageView.H(this.a);
        float f12 = GestureCropImageView.I(this.a);
        gestureCropImageView.l(f10, f11, f12);
        return true;
    }
}

