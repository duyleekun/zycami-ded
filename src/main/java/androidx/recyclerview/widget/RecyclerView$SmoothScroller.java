/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.util.Log
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$Action;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewFlinger;

public abstract class RecyclerView$SmoothScroller {
    private RecyclerView$LayoutManager mLayoutManager;
    private boolean mPendingInitialRun;
    private RecyclerView mRecyclerView;
    private final RecyclerView$SmoothScroller$Action mRecyclingAction;
    private boolean mRunning;
    private boolean mStarted;
    private int mTargetPosition = -1;
    private View mTargetView;

    public RecyclerView$SmoothScroller() {
        RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action;
        this.mRecyclingAction = recyclerView$SmoothScroller$Action = new RecyclerView$SmoothScroller$Action(0, 0);
    }

    public PointF computeScrollVectorForPosition(int n10) {
        Object object = this.getLayoutManager();
        boolean bl2 = object instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        if (bl2) {
            return ((RecyclerView$SmoothScroller$ScrollVectorProvider)object).computeScrollVectorForPosition(n10);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("You should override computeScrollVectorForPosition when the LayoutManager does not implement ");
        object = RecyclerView$SmoothScroller$ScrollVectorProvider.class.getCanonicalName();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        Log.w((String)"RecyclerView", (String)charSequence);
        return null;
    }

    public View findViewByPosition(int n10) {
        return this.mRecyclerView.mLayout.findViewByPosition(n10);
    }

    public int getChildCount() {
        return this.mRecyclerView.mLayout.getChildCount();
    }

    public int getChildPosition(View view) {
        return this.mRecyclerView.getChildLayoutPosition(view);
    }

    public RecyclerView$LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public int getTargetPosition() {
        return this.mTargetPosition;
    }

    public void instantScrollToPosition(int n10) {
        this.mRecyclerView.scrollToPosition(n10);
    }

    public boolean isPendingInitialRun() {
        return this.mPendingInitialRun;
    }

    public boolean isRunning() {
        return this.mRunning;
    }

    public void normalize(PointF pointF) {
        float f10 = pointF.x;
        f10 *= f10;
        float f11 = pointF.y;
        f11 *= f11;
        f10 = (float)Math.sqrt(f10 + f11);
        pointF.x = f11 = pointF.x / f10;
        pointF.y = f11 = pointF.y / f10;
    }

    public void onAnimation(int n10, int n11) {
        float f10;
        int n12;
        Object object;
        RecyclerView recyclerView = this.mRecyclerView;
        int n13 = this.mTargetPosition;
        int n14 = -1;
        if (n13 == n14 || recyclerView == null) {
            this.stop();
        }
        n13 = (int)(this.mPendingInitialRun ? 1 : 0);
        n14 = 0;
        Object object2 = null;
        if (n13 != 0 && (object = this.mTargetView) == null && (object = this.mLayoutManager) != null && (object = this.computeScrollVectorForPosition(n13 = this.mTargetPosition)) != null) {
            float f11;
            float f12;
            float f13 = ((PointF)object).x;
            boolean bl2 = false;
            float f14 = f13 - 0.0f;
            Object object3 = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
            if (object3 != false || (bl2 = (f12 = (f11 = ((PointF)object).y) - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1))) {
                f13 = Math.signum(f13);
                n12 = (int)f13;
                f10 = Math.signum(((PointF)object).y);
                n13 = (int)f10;
                recyclerView.scrollStep(n12, n13, null);
            }
        }
        n13 = 0;
        f10 = 0.0f;
        this.mPendingInitialRun = false;
        object = this.mTargetView;
        if (object != null) {
            n13 = this.getChildPosition((View)object);
            if (n13 == (n12 = this.mTargetPosition)) {
                object = this.mTargetView;
                object2 = recyclerView.mState;
                RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action = this.mRecyclingAction;
                this.onTargetFound((View)object, (RecyclerView$State)object2, recyclerView$SmoothScroller$Action);
                object = this.mRecyclingAction;
                ((RecyclerView$SmoothScroller$Action)object).runIfNecessary(recyclerView);
                this.stop();
            } else {
                object = "RecyclerView";
                String string2 = "Passed over target position while smooth scrolling.";
                Log.e((String)object, (String)string2);
                this.mTargetView = null;
            }
        }
        if ((n13 = (int)(this.mRunning ? 1 : 0)) != 0) {
            object = recyclerView.mState;
            object2 = this.mRecyclingAction;
            this.onSeekTargetStep(n10, n11, (RecyclerView$State)object, (RecyclerView$SmoothScroller$Action)object2);
            Object object4 = this.mRecyclingAction;
            n10 = (int)(((RecyclerView$SmoothScroller$Action)object4).hasJumpTarget() ? 1 : 0);
            RecyclerView$SmoothScroller$Action recyclerView$SmoothScroller$Action = this.mRecyclingAction;
            recyclerView$SmoothScroller$Action.runIfNecessary(recyclerView);
            if (n10 != 0 && (n10 = (int)(this.mRunning ? 1 : 0)) != 0) {
                n10 = 1;
                this.mPendingInitialRun = n10;
                object4 = recyclerView.mViewFlinger;
                ((RecyclerView$ViewFlinger)object4).postOnAnimation();
            }
        }
    }

    public void onChildAttachedToWindow(View view) {
        int n10;
        int n11 = this.getChildPosition(view);
        if (n11 == (n10 = this.getTargetPosition())) {
            this.mTargetView = view;
        }
    }

    public abstract void onSeekTargetStep(int var1, int var2, RecyclerView$State var3, RecyclerView$SmoothScroller$Action var4);

    public abstract void onStart();

    public abstract void onStop();

    public abstract void onTargetFound(View var1, RecyclerView$State var2, RecyclerView$SmoothScroller$Action var3);

    public void setTargetPosition(int n10) {
        this.mTargetPosition = n10;
    }

    public void start(RecyclerView object, RecyclerView$LayoutManager recyclerView$LayoutManager) {
        Object object2 = ((RecyclerView)object).mViewFlinger;
        ((RecyclerView$ViewFlinger)object2).stop();
        int n10 = this.mStarted;
        if (n10 != 0) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("An instance of ");
            String string2 = this.getClass().getSimpleName();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" was started more than once. Each instance of");
            string2 = this.getClass().getSimpleName();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(" is intended to only be used once. You should create a new instance for each use.");
            object2 = ((StringBuilder)object2).toString();
            string2 = "RecyclerView";
            Log.w((String)string2, (String)object2);
        }
        this.mRecyclerView = object;
        this.mLayoutManager = recyclerView$LayoutManager;
        int n11 = this.mTargetPosition;
        n10 = -1;
        if (n11 != n10) {
            boolean bl2;
            object.mState.mTargetPosition = n11;
            this.mRunning = bl2 = true;
            this.mPendingInitialRun = bl2;
            n11 = this.getTargetPosition();
            recyclerView$LayoutManager = this.findViewByPosition(n11);
            this.mTargetView = recyclerView$LayoutManager;
            this.onStart();
            this.mRecyclerView.mViewFlinger.postOnAnimation();
            this.mStarted = bl2;
            return;
        }
        object = new IllegalArgumentException("Invalid target position");
        throw object;
    }

    public final void stop() {
        int n10;
        boolean bl2 = this.mRunning;
        if (!bl2) {
            return;
        }
        this.mRunning = false;
        this.onStop();
        RecyclerView$State recyclerView$State = this.mRecyclerView.mState;
        recyclerView$State.mTargetPosition = n10 = -1;
        this.mTargetView = null;
        this.mTargetPosition = n10;
        this.mPendingInitialRun = false;
        this.mLayoutManager.onSmoothScrollerStopped(this);
        this.mLayoutManager = null;
        this.mRecyclerView = null;
    }
}

