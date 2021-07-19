/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.View
 */
package androidx.transition;

import android.graphics.PointF;
import android.view.View;
import androidx.transition.ViewUtils;

public class ChangeBounds$ViewBounds {
    private int mBottom;
    private int mBottomRightCalls;
    private int mLeft;
    private int mRight;
    private int mTop;
    private int mTopLeftCalls;
    private View mView;

    public ChangeBounds$ViewBounds(View view) {
        this.mView = view;
    }

    private void setLeftTopRightBottom() {
        View view = this.mView;
        int n10 = this.mLeft;
        int n11 = this.mTop;
        int n12 = this.mRight;
        int n13 = this.mBottom;
        ViewUtils.setLeftTopRightBottom(view, n10, n11, n12, n13);
        this.mTopLeftCalls = 0;
        this.mBottomRightCalls = 0;
    }

    public void setBottomRight(PointF pointF) {
        int n10;
        int n11;
        float f10 = pointF.x;
        this.mRight = n11 = Math.round(f10);
        float f11 = pointF.y;
        this.mBottom = n10 = Math.round(f11);
        this.mBottomRightCalls = n10 = this.mBottomRightCalls + 1;
        n11 = this.mTopLeftCalls;
        if (n11 == n10) {
            this.setLeftTopRightBottom();
        }
    }

    public void setTopLeft(PointF pointF) {
        int n10;
        int n11;
        float f10 = pointF.x;
        this.mLeft = n11 = Math.round(f10);
        float f11 = pointF.y;
        this.mTop = n10 = Math.round(f11);
        this.mTopLeftCalls = n10 = this.mTopLeftCalls + 1;
        n11 = this.mBottomRightCalls;
        if (n10 == n11) {
            this.setLeftTopRightBottom();
        }
    }
}

