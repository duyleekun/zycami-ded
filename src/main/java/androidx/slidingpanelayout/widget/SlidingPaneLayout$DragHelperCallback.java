/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.slidingpanelayout.widget;

import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import androidx.customview.widget.ViewDragHelper$Callback;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import androidx.slidingpanelayout.widget.SlidingPaneLayout$LayoutParams;

public class SlidingPaneLayout$DragHelperCallback
extends ViewDragHelper$Callback {
    public final /* synthetic */ SlidingPaneLayout this$0;

    public SlidingPaneLayout$DragHelperCallback(SlidingPaneLayout slidingPaneLayout) {
        this.this$0 = slidingPaneLayout;
    }

    public int clampViewPositionHorizontal(View object, int n10, int n11) {
        int n12;
        object = (SlidingPaneLayout$LayoutParams)this.this$0.mSlideableView.getLayoutParams();
        SlidingPaneLayout slidingPaneLayout = this.this$0;
        n11 = (int)(slidingPaneLayout.isLayoutRtlSupport() ? 1 : 0);
        if (n11 != 0) {
            slidingPaneLayout = this.this$0;
            n11 = slidingPaneLayout.getWidth();
            SlidingPaneLayout slidingPaneLayout2 = this.this$0;
            int n13 = slidingPaneLayout2.getPaddingRight();
            n12 = object.rightMargin;
            n13 += n12;
            n12 = this.this$0.mSlideableView.getWidth();
            n11 -= (n13 += n12);
            object = this.this$0;
            n12 = object.mSlideRange;
            n12 = n11 - n12;
            n10 = Math.min(n10, n11);
            n12 = Math.max(n10, n12);
        } else {
            slidingPaneLayout = this.this$0;
            n11 = slidingPaneLayout.getPaddingLeft();
            n12 = object.leftMargin;
            n11 += n12;
            object = this.this$0;
            n12 = object.mSlideRange + n11;
            n10 = Math.max(n10, n11);
            n12 = Math.min(n10, n12);
        }
        return n12;
    }

    public int clampViewPositionVertical(View view, int n10, int n11) {
        return view.getTop();
    }

    public int getViewHorizontalDragRange(View view) {
        return this.this$0.mSlideRange;
    }

    public void onEdgeDragStarted(int n10, int n11) {
        SlidingPaneLayout slidingPaneLayout = this.this$0;
        ViewDragHelper viewDragHelper = slidingPaneLayout.mDragHelper;
        slidingPaneLayout = slidingPaneLayout.mSlideableView;
        viewDragHelper.captureChildView((View)slidingPaneLayout, n11);
    }

    public void onViewCaptured(View view, int n10) {
        this.this$0.setAllChildrenVisible();
    }

    public void onViewDragStateChanged(int n10) {
        Object object = this.this$0.mDragHelper;
        n10 = object.getViewDragState();
        if (n10 == 0) {
            object = this.this$0;
            float f10 = ((SlidingPaneLayout)object).mSlideOffset;
            float f11 = f10 - 0.0f;
            Object object2 = f11 == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1);
            if (object2 == false) {
                View view = ((SlidingPaneLayout)object).mSlideableView;
                ((SlidingPaneLayout)((Object)object)).updateObscuredViewsVisibility(view);
                object = this.this$0;
                view = ((SlidingPaneLayout)object).mSlideableView;
                ((SlidingPaneLayout)((Object)object)).dispatchOnPanelClosed(view);
                object = this.this$0;
                object2 = false;
                f10 = 0.0f;
                view = null;
                ((SlidingPaneLayout)object).mPreservedOpenState = false;
            } else {
                View view = ((SlidingPaneLayout)object).mSlideableView;
                ((SlidingPaneLayout)((Object)object)).dispatchOnPanelOpened(view);
                object = this.this$0;
                object2 = true;
                f10 = Float.MIN_VALUE;
                ((SlidingPaneLayout)object).mPreservedOpenState = object2;
            }
        }
    }

    public void onViewPositionChanged(View view, int n10, int n11, int n12, int n13) {
        this.this$0.onPanelDragged(n10);
        this.this$0.invalidate();
    }

    public void onViewReleased(View view, float f10, float f11) {
        Object object;
        int n10;
        block7: {
            Object object2;
            block8: {
                float f12;
                int n11;
                SlidingPaneLayout slidingPaneLayout;
                Object object3;
                block4: {
                    Object object4;
                    block6: {
                        block5: {
                            object3 = (SlidingPaneLayout$LayoutParams)view.getLayoutParams();
                            slidingPaneLayout = this.this$0;
                            n11 = slidingPaneLayout.isLayoutRtlSupport();
                            f12 = 0.5f;
                            if (n11 == 0) break block4;
                            slidingPaneLayout = this.this$0;
                            n11 = slidingPaneLayout.getPaddingRight();
                            n10 = object3.rightMargin;
                            n11 += n10;
                            float f13 = f10 - 0.0f;
                            n10 = (int)(f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1));
                            if (n10 < 0) break block5;
                            float f14 = f10 - 0.0f;
                            object4 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
                            if (object4 != false) break block6;
                            object = this.this$0;
                            f10 = ((SlidingPaneLayout)object).mSlideOffset;
                            float f15 = f10 - f12;
                            object4 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                            if (object4 <= 0) break block6;
                        }
                        object = this.this$0;
                        object4 = ((SlidingPaneLayout)object).mSlideRange;
                        n11 += object4;
                    }
                    object = this.this$0.mSlideableView;
                    object4 = object.getWidth();
                    object3 = this.this$0;
                    n10 = object3.getWidth() - n11 - object4;
                    break block7;
                }
                slidingPaneLayout = this.this$0;
                n11 = slidingPaneLayout.getPaddingLeft();
                n10 = object3.leftMargin + n11;
                float f16 = f10 - 0.0f;
                object2 = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
                if (object2 > 0) break block8;
                if (object2 != false) break block7;
                object = this.this$0;
                f10 = ((SlidingPaneLayout)object).mSlideOffset;
                float f17 = f10 - f12;
                object2 = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
                if (object2 <= 0) break block7;
            }
            object = this.this$0;
            object2 = ((SlidingPaneLayout)object).mSlideRange;
            n10 += object2;
        }
        object = this.this$0.mDragHelper;
        int n12 = view.getTop();
        ((ViewDragHelper)object).settleCapturedViewAt(n10, n12);
        this.this$0.invalidate();
    }

    public boolean tryCaptureView(View view, int n10) {
        SlidingPaneLayout slidingPaneLayout = this.this$0;
        n10 = (int)(slidingPaneLayout.mIsUnableToDrag ? 1 : 0);
        if (n10 != 0) {
            return false;
        }
        return ((SlidingPaneLayout$LayoutParams)view.getLayoutParams()).slideable;
    }
}

