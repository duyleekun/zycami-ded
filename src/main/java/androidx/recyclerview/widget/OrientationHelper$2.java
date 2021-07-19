/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;

public class OrientationHelper$2
extends OrientationHelper {
    public OrientationHelper$2(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        super(recyclerView$LayoutManager, null);
    }

    public int getDecoratedEnd(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        int n10 = this.mLayoutManager.getDecoratedBottom(view);
        int n11 = recyclerView$LayoutParams.bottomMargin;
        return n10 + n11;
    }

    public int getDecoratedMeasurement(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        int n10 = this.mLayoutManager.getDecoratedMeasuredHeight(view);
        int n11 = recyclerView$LayoutParams.topMargin;
        int n12 = recyclerView$LayoutParams.bottomMargin;
        return (n10 += n11) + n12;
    }

    public int getDecoratedMeasurementInOther(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        int n10 = this.mLayoutManager.getDecoratedMeasuredWidth(view);
        int n11 = recyclerView$LayoutParams.leftMargin;
        int n12 = recyclerView$LayoutParams.rightMargin;
        return (n10 += n11) + n12;
    }

    public int getDecoratedStart(View view) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        int n10 = this.mLayoutManager.getDecoratedTop(view);
        int n11 = recyclerView$LayoutParams.topMargin;
        return n10 - n11;
    }

    public int getEnd() {
        return this.mLayoutManager.getHeight();
    }

    public int getEndAfterPadding() {
        int n10 = this.mLayoutManager.getHeight();
        int n11 = this.mLayoutManager.getPaddingBottom();
        return n10 - n11;
    }

    public int getEndPadding() {
        return this.mLayoutManager.getPaddingBottom();
    }

    public int getMode() {
        return this.mLayoutManager.getHeightMode();
    }

    public int getModeInOther() {
        return this.mLayoutManager.getWidthMode();
    }

    public int getStartAfterPadding() {
        return this.mLayoutManager.getPaddingTop();
    }

    public int getTotalSpace() {
        int n10 = this.mLayoutManager.getHeight();
        int n11 = this.mLayoutManager.getPaddingTop();
        n10 -= n11;
        n11 = this.mLayoutManager.getPaddingBottom();
        return n10 - n11;
    }

    public int getTransformedEndWithDecoration(View view) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayoutManager;
        Rect rect = this.mTmpRect;
        recyclerView$LayoutManager.getTransformedBoundingBox(view, true, rect);
        return this.mTmpRect.bottom;
    }

    public int getTransformedStartWithDecoration(View view) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mLayoutManager;
        Rect rect = this.mTmpRect;
        recyclerView$LayoutManager.getTransformedBoundingBox(view, true, rect);
        return this.mTmpRect.top;
    }

    public void offsetChild(View view, int n10) {
        view.offsetTopAndBottom(n10);
    }

    public void offsetChildren(int n10) {
        this.mLayoutManager.offsetChildrenVertical(n10);
    }
}

