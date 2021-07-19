/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewTreeObserver
 *  android.view.ViewTreeObserver$OnScrollChangedListener
 *  android.widget.ScrollView
 */
package com.google.android.material.shape;

import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ScrollView;
import com.google.android.material.shape.InterpolateOnScrollPositionChangeHelper$1;
import com.google.android.material.shape.MaterialShapeDrawable;

public class InterpolateOnScrollPositionChangeHelper {
    private final int[] containerLocation;
    private ScrollView containingScrollView;
    private MaterialShapeDrawable materialShapeDrawable;
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    private final int[] scrollLocation;
    private View shapedView;

    public InterpolateOnScrollPositionChangeHelper(View view, MaterialShapeDrawable materialShapeDrawable, ScrollView scrollView) {
        int n10 = 2;
        int[] nArray = new int[n10];
        this.scrollLocation = nArray;
        Object object = new int[n10];
        this.containerLocation = object;
        object = new InterpolateOnScrollPositionChangeHelper$1;
        super(this);
        this.scrollChangedListener = (ViewTreeObserver.OnScrollChangedListener)object;
        this.shapedView = view;
        this.materialShapeDrawable = materialShapeDrawable;
        this.containingScrollView = scrollView;
    }

    public void setContainingScrollView(ScrollView scrollView) {
        this.containingScrollView = scrollView;
    }

    public void setMaterialShapeDrawable(MaterialShapeDrawable materialShapeDrawable) {
        this.materialShapeDrawable = materialShapeDrawable;
    }

    public void startListeningForScrollChanges(ViewTreeObserver viewTreeObserver) {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.scrollChangedListener;
        viewTreeObserver.addOnScrollChangedListener(onScrollChangedListener);
    }

    public void stopListeningForScrollChanges(ViewTreeObserver viewTreeObserver) {
        ViewTreeObserver.OnScrollChangedListener onScrollChangedListener = this.scrollChangedListener;
        viewTreeObserver.removeOnScrollChangedListener(onScrollChangedListener);
    }

    public void updateInterpolationForScreenPosition() {
        Object object = this.containingScrollView;
        if (object == null) {
            return;
        }
        int n10 = object.getChildCount();
        if (n10 != 0) {
            object = this.containingScrollView;
            Object object2 = this.scrollLocation;
            object.getLocationInWindow(object2);
            object = this.containingScrollView;
            float f10 = 0.0f;
            object = object.getChildAt(0);
            object2 = this.containerLocation;
            object.getLocationInWindow(object2);
            object = this.shapedView;
            n10 = object.getTop();
            object2 = this.scrollLocation;
            int n11 = 1;
            int n12 = object2[n11];
            n10 -= n12;
            n12 = this.containerLocation[n11];
            n10 += n12;
            object2 = this.shapedView;
            n12 = object2.getHeight();
            Object object3 = this.containingScrollView;
            n11 = object3.getHeight();
            float f11 = 1.0f;
            if (n10 < 0) {
                object3 = this.materialShapeDrawable;
                float f12 = n10;
                f10 = n12;
                f12 = f12 / f10 + f11;
                f12 = Math.min(f11, f12);
                f12 = Math.max(0.0f, f12);
                ((MaterialShapeDrawable)object3).setInterpolation(f12);
                object = this.shapedView;
                object.invalidate();
            } else if ((n10 += n12) > n11) {
                object3 = this.materialShapeDrawable;
                float f13 = n10 -= n11;
                f10 = n12;
                f13 /= f10;
                f13 = f11 - f13;
                f13 = Math.min(f11, f13);
                f13 = Math.max(0.0f, f13);
                ((MaterialShapeDrawable)object3).setInterpolation(f13);
                object = this.shapedView;
                object.invalidate();
            } else {
                object = this.materialShapeDrawable;
                float f14 = ((MaterialShapeDrawable)object).getInterpolation();
                float f15 = f14 - f11;
                n10 = (int)(f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1));
                if (n10 != 0) {
                    this.materialShapeDrawable.setInterpolation(f11);
                    object = this.shapedView;
                    object.invalidate();
                }
            }
            return;
        }
        object = new IllegalStateException("Scroll bar must contain a child to calculate interpolation.");
        throw object;
    }
}

