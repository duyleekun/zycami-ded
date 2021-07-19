/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.util.DisplayMetrics
 *  android.view.View
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.view.animation.LinearInterpolator
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action;
import androidx.recyclerview.widget.RecyclerView$State;

public class LinearSmoothScroller
extends RecyclerView$SmoothScroller {
    private static final boolean DEBUG = false;
    private static final float MILLISECONDS_PER_INCH = 25.0f;
    public static final int SNAP_TO_ANY = 0;
    public static final int SNAP_TO_END = 1;
    public static final int SNAP_TO_START = 255;
    private static final float TARGET_SEEK_EXTRA_SCROLL_RATIO = 1.2f;
    private static final int TARGET_SEEK_SCROLL_DISTANCE_PX = 10000;
    public final DecelerateInterpolator mDecelerateInterpolator;
    private final DisplayMetrics mDisplayMetrics;
    private boolean mHasCalculatedMillisPerPixel;
    public int mInterimTargetDx;
    public int mInterimTargetDy;
    public final LinearInterpolator mLinearInterpolator;
    private float mMillisPerPixel;
    public PointF mTargetVector;

    public LinearSmoothScroller(Context context) {
        LinearInterpolator linearInterpolator;
        this.mLinearInterpolator = linearInterpolator = new LinearInterpolator();
        this.mDecelerateInterpolator = linearInterpolator;
        this.mHasCalculatedMillisPerPixel = false;
        this.mInterimTargetDx = 0;
        this.mInterimTargetDy = 0;
        context = context.getResources().getDisplayMetrics();
        this.mDisplayMetrics = context;
    }

    private int clampApplyScroll(int n10, int n11) {
        if ((n10 *= (n11 = n10 - n11)) <= 0) {
            return 0;
        }
        return n11;
    }

    private float getSpeedPerPixel() {
        boolean bl2 = this.mHasCalculatedMillisPerPixel;
        if (!bl2) {
            float f10;
            DisplayMetrics displayMetrics = this.mDisplayMetrics;
            this.mMillisPerPixel = f10 = this.calculateSpeedPerPixel(displayMetrics);
            bl2 = true;
            f10 = Float.MIN_VALUE;
            this.mHasCalculatedMillisPerPixel = bl2;
        }
        return this.mMillisPerPixel;
    }

    public int calculateDtToFit(int n10, int n11, int n12, int n13, int n14) {
        int n15 = -1;
        if (n14 != n15) {
            if (n14 != 0) {
                n10 = 1;
                if (n14 == n10) {
                    return n13 - n11;
                }
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException("snap preference should be one of the constants defined in SmoothScroller, starting with SNAP_");
                throw illegalArgumentException;
            }
            if ((n12 -= n10) > 0) {
                return n12;
            }
            if ((n13 -= n11) < 0) {
                return n13;
            }
            return 0;
        }
        return n12 - n10;
    }

    public int calculateDxToMakeVisible(View view, int n10) {
        int n11;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.getLayoutManager();
        if (recyclerView$LayoutManager != null && (n11 = recyclerView$LayoutManager.canScrollHorizontally()) != 0) {
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
            int n12 = recyclerView$LayoutManager.getDecoratedLeft(view);
            int n13 = recyclerView$LayoutParams.leftMargin;
            int n14 = n12 - n13;
            int n15 = recyclerView$LayoutManager.getDecoratedRight(view);
            n11 = recyclerView$LayoutParams.rightMargin;
            int n16 = n15 + n11;
            int n17 = recyclerView$LayoutManager.getPaddingLeft();
            n15 = recyclerView$LayoutManager.getWidth();
            int n18 = recyclerView$LayoutManager.getPaddingRight();
            int n19 = n15 - n18;
            return this.calculateDtToFit(n14, n16, n17, n19, n10);
        }
        return 0;
    }

    public int calculateDyToMakeVisible(View view, int n10) {
        int n11;
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.getLayoutManager();
        if (recyclerView$LayoutManager != null && (n11 = recyclerView$LayoutManager.canScrollVertically()) != 0) {
            RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
            int n12 = recyclerView$LayoutManager.getDecoratedTop(view);
            int n13 = recyclerView$LayoutParams.topMargin;
            int n14 = n12 - n13;
            int n15 = recyclerView$LayoutManager.getDecoratedBottom(view);
            n11 = recyclerView$LayoutParams.bottomMargin;
            int n16 = n15 + n11;
            int n17 = recyclerView$LayoutManager.getPaddingTop();
            n15 = recyclerView$LayoutManager.getHeight();
            int n18 = recyclerView$LayoutManager.getPaddingBottom();
            int n19 = n15 - n18;
            return this.calculateDtToFit(n14, n16, n17, n19, n10);
        }
        return 0;
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        float f10 = displayMetrics.densityDpi;
        return 25.0f / f10;
    }

    public int calculateTimeForDeceleration(int n10) {
        return (int)Math.ceil((double)this.calculateTimeForScrolling(n10) / 0.3356);
    }

    public int calculateTimeForScrolling(int n10) {
        float f10 = Math.abs(n10);
        float f11 = this.getSpeedPerPixel();
        return (int)Math.ceil(f10 * f11);
    }

    public int getHorizontalSnapPreference() {
        int n10;
        float f10;
        float f11;
        float f12;
        PointF pointF = this.mTargetVector;
        if (pointF != null && (f12 = (f11 = (f10 = pointF.x) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            float f13 = f10 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 > 0) {
                n10 = 1;
                f10 = Float.MIN_VALUE;
            } else {
                n10 = -1;
                f10 = 0.0f / 0.0f;
            }
        } else {
            n10 = 0;
            f10 = 0.0f;
            pointF = null;
        }
        return n10;
    }

    public int getVerticalSnapPreference() {
        int n10;
        float f10;
        float f11;
        float f12;
        PointF pointF = this.mTargetVector;
        if (pointF != null && (f12 = (f11 = (f10 = pointF.y) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) != false) {
            float f13 = f10 - 0.0f;
            n10 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
            if (n10 > 0) {
                n10 = 1;
                f10 = Float.MIN_VALUE;
            } else {
                n10 = -1;
                f10 = 0.0f / 0.0f;
            }
        } else {
            n10 = 0;
            f10 = 0.0f;
            pointF = null;
        }
        return n10;
    }

    public void onSeekTargetStep(int n10, int n11, RecyclerView$State recyclerView$State, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        int n12 = this.getChildCount();
        if (n12 == 0) {
            this.stop();
            return;
        }
        n12 = this.mInterimTargetDx;
        this.mInterimTargetDx = n10 = this.clampApplyScroll(n12, n10);
        n10 = this.mInterimTargetDy;
        this.mInterimTargetDy = n10 = this.clampApplyScroll(n10, n11);
        n11 = this.mInterimTargetDx;
        if (n11 == 0 && n10 == 0) {
            this.updateActionForInterimTarget(recyclerView$SmoothScroller$Action);
        }
    }

    public void onStart() {
    }

    public void onStop() {
        this.mInterimTargetDy = 0;
        this.mInterimTargetDx = 0;
        this.mTargetVector = null;
    }

    public void onTargetFound(View view, RecyclerView$State recyclerView$State, RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        int n10 = this.getHorizontalSnapPreference();
        n10 = this.calculateDxToMakeVisible(view, n10);
        int n11 = this.getVerticalSnapPreference();
        int n12 = this.calculateDyToMakeVisible(view, n11);
        n11 = n10 * n10;
        int n13 = n12 * n12;
        double d10 = Math.sqrt(n11 + n13);
        n11 = (int)d10;
        if ((n11 = this.calculateTimeForDeceleration(n11)) > 0) {
            n10 = -n10;
            n12 = -n12;
            DecelerateInterpolator decelerateInterpolator = this.mDecelerateInterpolator;
            recyclerView$SmoothScroller$Action.update(n10, n12, n11, (Interpolator)decelerateInterpolator);
        }
    }

    public void updateActionForInterimTarget(RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action) {
        int n10 = this.getTargetPosition();
        PointF pointF = this.computeScrollVectorForPosition(n10);
        if (pointF != null) {
            float f10;
            float f11 = pointF.x;
            float f12 = 0.0f;
            LinearInterpolator linearInterpolator = null;
            float f13 = f11 - 0.0f;
            Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
            if (object != false || (object = (f10 = (f11 = pointF.y) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) != false) {
                this.normalize(pointF);
                this.mTargetVector = pointF;
                f11 = pointF.x;
                f12 = 10000.0f;
                object = (int)(f11 * f12);
                this.mInterimTargetDx = (int)object;
                this.mInterimTargetDy = n10 = (int)(pointF.y * f12);
                n10 = this.calculateTimeForScrolling(10000);
                f11 = this.mInterimTargetDx;
                f12 = 1.2f;
                object = (int)(f11 * f12);
                int n11 = (int)((float)this.mInterimTargetDy * f12);
                n10 = (int)((float)n10 * f12);
                linearInterpolator = this.mLinearInterpolator;
                recyclerView$SmoothScroller$Action.update((int)object, n11, n10, (Interpolator)linearInterpolator);
                return;
            }
        }
        n10 = this.getTargetPosition();
        recyclerView$SmoothScroller$Action.jumpTo(n10);
        this.stop();
    }
}

