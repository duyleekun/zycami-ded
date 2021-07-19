/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 *  android.view.animation.DecelerateInterpolator
 *  android.view.animation.Interpolator
 *  android.widget.Scroller
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnFlingListener;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.SnapHelper$1;
import androidx.recyclerview.widget.SnapHelper$2;

public abstract class SnapHelper
extends RecyclerView$OnFlingListener {
    public static final float MILLISECONDS_PER_INCH = 100.0f;
    private Scroller mGravityScroller;
    public RecyclerView mRecyclerView;
    private final RecyclerView$OnScrollListener mScrollListener;

    public SnapHelper() {
        SnapHelper$1 snapHelper$1 = new SnapHelper$1(this);
        this.mScrollListener = snapHelper$1;
    }

    private void destroyCallbacks() {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView$OnScrollListener recyclerView$OnScrollListener = this.mScrollListener;
        recyclerView.removeOnScrollListener(recyclerView$OnScrollListener);
        this.mRecyclerView.setOnFlingListener(null);
    }

    private void setupCallbacks() {
        Object object = this.mRecyclerView.getOnFlingListener();
        if (object == null) {
            object = this.mRecyclerView;
            RecyclerView$OnScrollListener recyclerView$OnScrollListener = this.mScrollListener;
            ((RecyclerView)object).addOnScrollListener(recyclerView$OnScrollListener);
            this.mRecyclerView.setOnFlingListener(this);
            return;
        }
        object = new IllegalStateException("An instance of OnFlingListener already set.");
        throw object;
    }

    private boolean snapFromFling(RecyclerView$LayoutManager recyclerView$LayoutManager, int n10, int n11) {
        boolean bl2 = recyclerView$LayoutManager instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        if (!bl2) {
            return false;
        }
        RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.createScroller(recyclerView$LayoutManager);
        if (recyclerView$SmoothScroller == null) {
            return false;
        }
        if ((n10 = this.findTargetSnapPosition(recyclerView$LayoutManager, n10, n11)) == (n11 = -1)) {
            return false;
        }
        recyclerView$SmoothScroller.setTargetPosition(n10);
        recyclerView$LayoutManager.startSmoothScroll(recyclerView$SmoothScroller);
        return true;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.mRecyclerView;
        if (recyclerView2 == recyclerView) {
            return;
        }
        if (recyclerView2 != null) {
            this.destroyCallbacks();
        }
        this.mRecyclerView = recyclerView;
        if (recyclerView != null) {
            this.setupCallbacks();
            recyclerView2 = this.mRecyclerView.getContext();
            DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
            recyclerView = new Scroller((Context)recyclerView2, (Interpolator)decelerateInterpolator);
            this.mGravityScroller = recyclerView;
            this.snapToTargetExistingView();
        }
    }

    public abstract int[] calculateDistanceToFinalSnap(RecyclerView$LayoutManager var1, View var2);

    public int[] calculateScrollDistance(int n10, int n11) {
        int[] nArray = new int[2];
        this.mGravityScroller.fling(0, 0, n10, n11, -1 << -1, -1 >>> 1, -1 << -1, -1 >>> 1);
        nArray[0] = n10 = this.mGravityScroller.getFinalX();
        nArray[1] = n10 = this.mGravityScroller.getFinalY();
        return nArray;
    }

    public RecyclerView$SmoothScroller createScroller(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        return this.createSnapScroller(recyclerView$LayoutManager);
    }

    public LinearSmoothScroller createSnapScroller(RecyclerView$LayoutManager object) {
        boolean bl2 = object instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        if (!bl2) {
            return null;
        }
        Context context = this.mRecyclerView.getContext();
        object = new SnapHelper$2(this, context);
        return object;
    }

    public abstract View findSnapView(RecyclerView$LayoutManager var1);

    public abstract int findTargetSnapPosition(RecyclerView$LayoutManager var1, int var2, int var3);

    public boolean onFling(int n10, int n11) {
        RecyclerView$LayoutManager recyclerView$LayoutManager = this.mRecyclerView.getLayoutManager();
        boolean bl2 = false;
        if (recyclerView$LayoutManager == null) {
            return false;
        }
        Object object = this.mRecyclerView.getAdapter();
        if (object == null) {
            return false;
        }
        object = this.mRecyclerView;
        int n12 = ((RecyclerView)object).getMinFlingVelocity();
        int n13 = Math.abs(n11);
        if ((n13 > n12 || (n13 = Math.abs(n10)) > n12) && (n10 = (int)(this.snapFromFling(recyclerView$LayoutManager, n10, n11) ? 1 : 0)) != 0) {
            bl2 = true;
        }
        return bl2;
    }

    public void snapToTargetExistingView() {
        Object object = this.mRecyclerView;
        if (object == null) {
            return;
        }
        if ((object = ((RecyclerView)object).getLayoutManager()) == null) {
            return;
        }
        View view = this.findSnapView((RecyclerView$LayoutManager)object);
        if (view == null) {
            return;
        }
        object = this.calculateDistanceToFinalSnap((RecyclerView$LayoutManager)object, view);
        boolean n10 = false;
        view = null;
        Object object2 = object[0];
        int n11 = 1;
        if (object2 != false || (object2 = object[n11]) != false) {
            RecyclerView recyclerView = this.mRecyclerView;
            Object object3 = object[0];
            Object object4 = object[n11];
            recyclerView.smoothScrollBy((int)object3, (int)object4);
        }
    }
}

