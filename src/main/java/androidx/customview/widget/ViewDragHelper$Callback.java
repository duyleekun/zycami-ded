/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.customview.widget;

import android.view.View;

public abstract class ViewDragHelper$Callback {
    public int clampViewPositionHorizontal(View view, int n10, int n11) {
        return 0;
    }

    public int clampViewPositionVertical(View view, int n10, int n11) {
        return 0;
    }

    public int getOrderedChildIndex(int n10) {
        return n10;
    }

    public int getViewHorizontalDragRange(View view) {
        return 0;
    }

    public int getViewVerticalDragRange(View view) {
        return 0;
    }

    public void onEdgeDragStarted(int n10, int n11) {
    }

    public boolean onEdgeLock(int n10) {
        return false;
    }

    public void onEdgeTouched(int n10, int n11) {
    }

    public void onViewCaptured(View view, int n10) {
    }

    public void onViewDragStateChanged(int n10) {
    }

    public void onViewPositionChanged(View view, int n10, int n11, int n12, int n13) {
    }

    public void onViewReleased(View view, float f10, float f11) {
    }

    public abstract boolean tryCaptureView(View var1, int var2);
}

