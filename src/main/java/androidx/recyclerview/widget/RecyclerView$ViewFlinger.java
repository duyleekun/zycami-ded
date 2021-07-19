/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Build$VERSION
 *  android.view.View
 *  android.view.animation.Interpolator
 *  android.widget.OverScroller
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.OverScroller;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.GapWorker;
import androidx.recyclerview.widget.GapWorker$LayoutPrefetchRegistryImpl;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$State;
import java.util.ArrayList;

public class RecyclerView$ViewFlinger
implements Runnable {
    private boolean mEatRunOnAnimationRequest;
    public Interpolator mInterpolator;
    private int mLastFlingX;
    private int mLastFlingY;
    public OverScroller mOverScroller;
    private boolean mReSchedulePostAnimationCallback;
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$ViewFlinger(RecyclerView recyclerView) {
        OverScroller overScroller;
        Interpolator interpolator2;
        this.this$0 = recyclerView;
        this.mInterpolator = interpolator2 = RecyclerView.sQuinticInterpolator;
        this.mEatRunOnAnimationRequest = false;
        this.mReSchedulePostAnimationCallback = false;
        recyclerView = recyclerView.getContext();
        this.mOverScroller = overScroller = new OverScroller((Context)recyclerView, interpolator2);
    }

    private int computeScrollDuration(int n10, int n11) {
        boolean bl2 = (n10 = Math.abs(n10)) > (n11 = Math.abs(n11));
        RecyclerView recyclerView = this.this$0;
        int n12 = bl2 ? recyclerView.getWidth() : recyclerView.getHeight();
        if (!bl2) {
            n10 = n11;
        }
        float f10 = n10;
        float f11 = n12;
        return Math.min((int)((f10 / f11 + 1.0f) * 300.0f), 2000);
    }

    private void internalPostOnAnimation() {
        this.this$0.removeCallbacks(this);
        ViewCompat.postOnAnimation((View)this.this$0, this);
    }

    public void fling(int n10, int n11) {
        RecyclerView recyclerView = this.this$0;
        int n12 = 2;
        recyclerView.setScrollState(n12);
        this.mLastFlingY = 0;
        this.mLastFlingX = 0;
        recyclerView = this.mInterpolator;
        Interpolator interpolator2 = RecyclerView.sQuinticInterpolator;
        if (recyclerView != interpolator2) {
            this.mInterpolator = interpolator2;
            Context context = this.this$0.getContext();
            recyclerView = new OverScroller(context, interpolator2);
            this.mOverScroller = recyclerView;
        }
        this.mOverScroller.fling(0, 0, n10, n11, -1 << -1, -1 >>> 1, -1 << -1, -1 >>> 1);
        this.postOnAnimation();
    }

    public void postOnAnimation() {
        boolean bl2 = this.mEatRunOnAnimationRequest;
        if (bl2) {
            this.mReSchedulePostAnimationCallback = bl2 = true;
        } else {
            this.internalPostOnAnimation();
        }
    }

    public void run() {
        Object object;
        RecyclerView$ViewFlinger recyclerView$ViewFlinger = this;
        Object object2 = this.this$0;
        RecyclerView$LayoutManager recyclerView$LayoutManager = ((RecyclerView)object2).mLayout;
        if (recyclerView$LayoutManager == null) {
            this.stop();
            return;
        }
        recyclerView$LayoutManager = null;
        this.mReSchedulePostAnimationCallback = false;
        Object object3 = 1;
        this.mEatRunOnAnimationRequest = object3;
        ((RecyclerView)object2).consumePendingUpdateOperations();
        object2 = this.mOverScroller;
        Object object4 = object2.computeScrollOffset();
        if (object4 != 0) {
            int n10;
            Object object5;
            Object object6;
            object4 = object2.getCurrX();
            Object object7 = object2.getCurrY();
            int n11 = this.mLastFlingX;
            n11 = object4 - n11;
            Object object8 = this.mLastFlingY;
            int n12 = object7 - object8;
            this.mLastFlingX = object4;
            this.mLastFlingY = object7;
            Object object9 = this.this$0;
            int[] nArray = ((RecyclerView)object9).mReusableIntPair;
            nArray[0] = 0;
            nArray[object3] = 0;
            int n13 = 1;
            Object object10 = n11;
            int n14 = n12;
            object4 = ((RecyclerView)object9).dispatchNestedPreScroll(n11, n12, nArray, null, n13);
            if (object4 != 0) {
                object6 = this.this$0.mReusableIntPair;
                object7 = object6[0];
                n11 -= object7;
                object4 = object6[object3];
                n12 -= object4;
            }
            if ((object4 = (object6 = recyclerView$ViewFlinger.this$0).getOverScrollMode()) != (object7 = 2)) {
                object6 = recyclerView$ViewFlinger.this$0;
                ((RecyclerView)object6).considerReleasingGlowsOnScroll(n11, n12);
            }
            object6 = recyclerView$ViewFlinger.this$0;
            object9 = ((RecyclerView)object6).mAdapter;
            if (object9 != null) {
                object9 = ((RecyclerView)object6).mReusableIntPair;
                object9[0] = false;
                object9[object3] = false;
                ((RecyclerView)object6).scrollStep(n11, n12, (int[])object9);
                object6 = recyclerView$ViewFlinger.this$0;
                object9 = ((RecyclerView)object6).mReusableIntPair;
                object10 = object9[0];
                object8 = object9[object3];
                n11 -= object10;
                n12 -= object8;
                object6 = object6.mLayout.mSmoothScroller;
                if (object6 != null && (n14 = (int)(((RecyclerView$SmoothScroller)object6).isPendingInitialRun() ? 1 : 0)) == 0 && (n14 = (int)(((RecyclerView$SmoothScroller)object6).isRunning() ? 1 : 0)) != 0) {
                    object5 = recyclerView$ViewFlinger.this$0.mState;
                    n14 = ((RecyclerView$State)object5).getItemCount();
                    if (n14 == 0) {
                        ((RecyclerView$SmoothScroller)object6).stop();
                    } else {
                        n10 = ((RecyclerView$SmoothScroller)object6).getTargetPosition();
                        if (n10 >= n14) {
                            ((RecyclerView$SmoothScroller)object6).setTargetPosition(n14 -= object3);
                            ((RecyclerView$SmoothScroller)object6).onAnimation((int)object10, (int)object8);
                        } else {
                            ((RecyclerView$SmoothScroller)object6).onAnimation((int)object10, (int)object8);
                        }
                    }
                }
            } else {
                object8 = 0;
                object9 = null;
                object10 = 0;
            }
            if ((object4 = (Object)((ArrayList)(object6 = recyclerView$ViewFlinger.this$0.mItemDecorations)).isEmpty()) == 0) {
                object6 = recyclerView$ViewFlinger.this$0;
                object6.invalidate();
            }
            RecyclerView recyclerView = recyclerView$ViewFlinger.this$0;
            object6 = recyclerView.mReusableIntPair;
            object6[0] = false;
            object6[object3] = false;
            int n15 = 1;
            recyclerView.dispatchNestedScroll((int)object10, (int)object8, n11, n12, null, n15, (int[])object6);
            object6 = recyclerView$ViewFlinger.this$0;
            object5 = ((RecyclerView)object6).mReusableIntPair;
            n10 = object5[0];
            n11 -= n10;
            n14 = object5[object3];
            n12 -= n14;
            if (object10 != 0 || object8 != 0) {
                ((RecyclerView)object6).dispatchOnScrolled((int)object10, (int)object8);
            }
            if ((object4 = (Object)RecyclerView.access$200((RecyclerView)(object6 = recyclerView$ViewFlinger.this$0))) == 0) {
                object6 = recyclerView$ViewFlinger.this$0;
                object6.invalidate();
            }
            if ((object4 = object2.getCurrX()) == (n14 = object2.getFinalX())) {
                object4 = object3;
            } else {
                object4 = 0;
                object6 = null;
            }
            n14 = object2.getCurrY();
            n10 = object2.getFinalY();
            if (n14 == n10) {
                n14 = object3;
            } else {
                n14 = 0;
                object5 = null;
            }
            n10 = (int)(object2.isFinished() ? 1 : 0);
            if (n10 == 0 && (object4 == 0 && n11 == 0 || n14 == 0 && n12 == 0)) {
                object4 = 0;
                object6 = null;
            } else {
                object4 = object3;
            }
            object5 = recyclerView$ViewFlinger.this$0.mLayout.mSmoothScroller;
            if (object5 != null && (n14 = (int)(((RecyclerView$SmoothScroller)object5).isPendingInitialRun() ? 1 : 0)) != 0) {
                n14 = object3;
            } else {
                n14 = 0;
                object5 = null;
            }
            if (n14 == 0 && object4 != 0) {
                object6 = recyclerView$ViewFlinger.this$0;
                object4 = object6.getOverScrollMode();
                if (object4 != object7) {
                    float f10 = object2.getCurrVelocity();
                    object = f10;
                    if (n11 < 0) {
                        object4 = -object;
                    } else if (n11 > 0) {
                        object4 = object;
                    } else {
                        object4 = 0;
                        object6 = null;
                    }
                    if (n12 < 0) {
                        object = -object;
                    } else if (n12 <= 0) {
                        object = 0;
                        object2 = null;
                        f10 = 0.0f;
                    }
                    RecyclerView recyclerView2 = recyclerView$ViewFlinger.this$0;
                    recyclerView2.absorbGlows((int)object4, (int)object);
                }
                if ((object = RecyclerView.ALLOW_THREAD_GAP_WORK) != 0) {
                    object2 = recyclerView$ViewFlinger.this$0.mPrefetchRegistry;
                    ((GapWorker$LayoutPrefetchRegistryImpl)object2).clearPrefetchPositions();
                }
            } else {
                this.postOnAnimation();
                object2 = recyclerView$ViewFlinger.this$0;
                object6 = ((RecyclerView)object2).mGapWorker;
                if (object6 != null) {
                    ((GapWorker)object6).postFromTraversal((RecyclerView)object2, (int)object10, (int)object8);
                }
            }
        }
        if ((object2 = recyclerView$ViewFlinger.this$0.mLayout.mSmoothScroller) != null && (object4 = (Object)((RecyclerView$SmoothScroller)object2).isPendingInitialRun()) != 0) {
            ((RecyclerView$SmoothScroller)object2).onAnimation(0, 0);
        }
        recyclerView$ViewFlinger.mEatRunOnAnimationRequest = false;
        object = recyclerView$ViewFlinger.mReSchedulePostAnimationCallback;
        if (object != 0) {
            this.internalPostOnAnimation();
        } else {
            recyclerView$ViewFlinger.this$0.setScrollState(0);
            object2 = recyclerView$ViewFlinger.this$0;
            ((RecyclerView)object2).stopNestedScroll((int)object3);
        }
    }

    public void smoothScrollBy(int n10, int n11, int n12, Interpolator interpolator2) {
        Context context;
        Object object;
        int n13 = -1 << -1;
        if (n12 == n13) {
            n12 = this.computeScrollDuration(n10, n11);
        }
        int n14 = n12;
        if (interpolator2 == null) {
            interpolator2 = RecyclerView.sQuinticInterpolator;
        }
        if ((object = this.mInterpolator) != interpolator2) {
            this.mInterpolator = interpolator2;
            context = this.this$0.getContext();
            object = new OverScroller(context, interpolator2);
            this.mOverScroller = object;
        }
        n12 = 0;
        this.mLastFlingY = 0;
        this.mLastFlingX = 0;
        object = this.this$0;
        int n15 = 2;
        ((RecyclerView)object).setScrollState(n15);
        context = this.mOverScroller;
        context.startScroll(0, 0, n10, n11, n14);
        n10 = Build.VERSION.SDK_INT;
        n11 = 23;
        if (n10 < n11) {
            OverScroller overScroller = this.mOverScroller;
            overScroller.computeScrollOffset();
        }
        this.postOnAnimation();
    }

    public void stop() {
        this.this$0.removeCallbacks(this);
        this.mOverScroller.abortAnimation();
    }
}

