/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 *  android.view.animation.Interpolator
 */
package androidx.recyclerview.widget;

import android.util.Log;
import android.view.animation.Interpolator;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewFlinger;

public class RecyclerView$SmoothScroller$Action {
    public static final int UNDEFINED_DURATION = Integer.MIN_VALUE;
    private boolean mChanged = false;
    private int mConsecutiveUpdates = 0;
    private int mDuration;
    private int mDx;
    private int mDy;
    private Interpolator mInterpolator;
    private int mJumpToPosition = -1;

    public RecyclerView$SmoothScroller$Action(int n10, int n11) {
        this(n10, n11, -1 << -1, null);
    }

    public RecyclerView$SmoothScroller$Action(int n10, int n11, int n12) {
        this(n10, n11, n12, null);
    }

    public RecyclerView$SmoothScroller$Action(int n10, int n11, int n12, Interpolator interpolator2) {
        this.mDx = n10;
        this.mDy = n11;
        this.mDuration = n12;
        this.mInterpolator = interpolator2;
    }

    private void validate() {
        int n10;
        Object object = this.mInterpolator;
        int n11 = 1;
        if (object != null && (n10 = this.mDuration) < n11) {
            object = new IllegalStateException("If you provide an interpolator, you must set a positive duration");
            throw object;
        }
        n10 = this.mDuration;
        if (n10 >= n11) {
            return;
        }
        object = new IllegalStateException("Scroll duration must be a positive number");
        throw object;
    }

    public int getDuration() {
        return this.mDuration;
    }

    public int getDx() {
        return this.mDx;
    }

    public int getDy() {
        return this.mDy;
    }

    public Interpolator getInterpolator() {
        return this.mInterpolator;
    }

    public boolean hasJumpTarget() {
        int n10 = this.mJumpToPosition;
        n10 = n10 >= 0 ? 1 : 0;
        return n10 != 0;
    }

    public void jumpTo(int n10) {
        this.mJumpToPosition = n10;
    }

    public void runIfNecessary(RecyclerView object) {
        int n10 = this.mJumpToPosition;
        if (n10 >= 0) {
            this.mJumpToPosition = -1;
            ((RecyclerView)object).jumpToPositionForSmoothScroller(n10);
            this.mChanged = false;
            return;
        }
        n10 = (int)(this.mChanged ? 1 : 0);
        if (n10 != 0) {
            int n11;
            this.validate();
            object = ((RecyclerView)object).mViewFlinger;
            n10 = this.mDx;
            int n12 = this.mDy;
            int n13 = this.mDuration;
            Interpolator interpolator2 = this.mInterpolator;
            ((RecyclerView$ViewFlinger)object).smoothScrollBy(n10, n12, n13, interpolator2);
            this.mConsecutiveUpdates = n11 = this.mConsecutiveUpdates + 1;
            n10 = 10;
            if (n11 > n10) {
                object = "RecyclerView";
                String string2 = "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary";
                Log.e((String)object, (String)string2);
            }
            this.mChanged = false;
        } else {
            this.mConsecutiveUpdates = 0;
        }
    }

    public void setDuration(int n10) {
        this.mChanged = true;
        this.mDuration = n10;
    }

    public void setDx(int n10) {
        this.mChanged = true;
        this.mDx = n10;
    }

    public void setDy(int n10) {
        this.mChanged = true;
        this.mDy = n10;
    }

    public void setInterpolator(Interpolator interpolator2) {
        this.mChanged = true;
        this.mInterpolator = interpolator2;
    }

    public void update(int n10, int n11, int n12, Interpolator interpolator2) {
        this.mDx = n10;
        this.mDy = n11;
        this.mDuration = n12;
        this.mInterpolator = interpolator2;
        this.mChanged = true;
    }
}

