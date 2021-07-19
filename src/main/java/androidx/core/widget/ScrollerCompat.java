/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 */
package androidx.core.widget;

import android.content.Context;
import android.view.animation.Interpolator;
import android.widget.OverScroller;

public final class ScrollerCompat {
    public OverScroller mScroller;

    public ScrollerCompat(Context context, Interpolator interpolator2) {
        OverScroller overScroller = interpolator2 != null ? new OverScroller(context, interpolator2) : new OverScroller(context);
        this.mScroller = overScroller;
    }

    public static ScrollerCompat create(Context context) {
        return ScrollerCompat.create(context, null);
    }

    public static ScrollerCompat create(Context context, Interpolator interpolator2) {
        ScrollerCompat scrollerCompat = new ScrollerCompat(context, interpolator2);
        return scrollerCompat;
    }

    public void abortAnimation() {
        this.mScroller.abortAnimation();
    }

    public boolean computeScrollOffset() {
        return this.mScroller.computeScrollOffset();
    }

    public void fling(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17) {
        this.mScroller.fling(n10, n11, n12, n13, n14, n15, n16, n17);
    }

    public void fling(int n10, int n11, int n12, int n13, int n14, int n15, int n16, int n17, int n18, int n19) {
        this.mScroller.fling(n10, n11, n12, n13, n14, n15, n16, n17, n18, n19);
    }

    public float getCurrVelocity() {
        return this.mScroller.getCurrVelocity();
    }

    public int getCurrX() {
        return this.mScroller.getCurrX();
    }

    public int getCurrY() {
        return this.mScroller.getCurrY();
    }

    public int getFinalX() {
        return this.mScroller.getFinalX();
    }

    public int getFinalY() {
        return this.mScroller.getFinalY();
    }

    public boolean isFinished() {
        return this.mScroller.isFinished();
    }

    public boolean isOverScrolled() {
        return this.mScroller.isOverScrolled();
    }

    public void notifyHorizontalEdgeReached(int n10, int n11, int n12) {
        this.mScroller.notifyHorizontalEdgeReached(n10, n11, n12);
    }

    public void notifyVerticalEdgeReached(int n10, int n11, int n12) {
        this.mScroller.notifyVerticalEdgeReached(n10, n11, n12);
    }

    public boolean springBack(int n10, int n11, int n12, int n13, int n14, int n15) {
        return this.mScroller.springBack(n10, n11, n12, n13, n14, n15);
    }

    public void startScroll(int n10, int n11, int n12, int n13) {
        this.mScroller.startScroll(n10, n11, n12, n13);
    }

    public void startScroll(int n10, int n11, int n12, int n13, int n14) {
        this.mScroller.startScroll(n10, n11, n12, n13, n14);
    }
}

