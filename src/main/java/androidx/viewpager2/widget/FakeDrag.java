/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.SystemClock
 *  android.view.MotionEvent
 *  android.view.VelocityTracker
 *  android.view.ViewConfiguration
 */
package androidx.viewpager2.widget;

import android.content.Context;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ScrollEventAdapter;
import androidx.viewpager2.widget.ViewPager2;

public final class FakeDrag {
    private int mActualDraggedDistance;
    private long mFakeDragBeginTime;
    private int mMaximumVelocity;
    private final RecyclerView mRecyclerView;
    private float mRequestedDragDistance;
    private final ScrollEventAdapter mScrollEventAdapter;
    private VelocityTracker mVelocityTracker;
    private final ViewPager2 mViewPager;

    public FakeDrag(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.mViewPager = viewPager2;
        this.mScrollEventAdapter = scrollEventAdapter;
        this.mRecyclerView = recyclerView;
    }

    private void addFakeMotionEvent(long l10, int n10, float f10, float f11) {
        MotionEvent motionEvent = MotionEvent.obtain((long)this.mFakeDragBeginTime, (long)l10, (int)n10, (float)f10, (float)f11, (int)0);
        this.mVelocityTracker.addMovement(motionEvent);
        motionEvent.recycle();
    }

    private void beginFakeVelocityTracker() {
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker == null) {
            int n10;
            this.mVelocityTracker = velocityTracker = VelocityTracker.obtain();
            velocityTracker = ViewConfiguration.get((Context)this.mViewPager.getContext());
            this.mMaximumVelocity = n10 = velocityTracker.getScaledMaximumFlingVelocity();
        } else {
            velocityTracker.clear();
        }
    }

    public boolean beginFakeDrag() {
        long l10;
        float f10;
        Object object = this.mScrollEventAdapter;
        boolean bl2 = ((ScrollEventAdapter)object).isDragging();
        if (bl2) {
            return false;
        }
        this.mActualDraggedDistance = 0;
        this.mRequestedDragDistance = f10 = 0.0f;
        this.mFakeDragBeginTime = l10 = SystemClock.uptimeMillis();
        this.beginFakeVelocityTracker();
        this.mScrollEventAdapter.notifyBeginFakeDrag();
        object = this.mScrollEventAdapter;
        bl2 = ((ScrollEventAdapter)object).isIdle();
        if (!bl2) {
            object = this.mRecyclerView;
            ((RecyclerView)object).stopScroll();
        }
        long l11 = this.mFakeDragBeginTime;
        this.addFakeMotionEvent(l11, 0, 0.0f, 0.0f);
        return true;
    }

    public boolean endFakeDrag() {
        Object object = this.mScrollEventAdapter;
        boolean n10 = ((ScrollEventAdapter)object).isFakeDragging();
        if (!n10) {
            return false;
        }
        this.mScrollEventAdapter.notifyEndFakeDrag();
        object = this.mVelocityTracker;
        int n11 = this.mMaximumVelocity;
        float f10 = n11;
        object.computeCurrentVelocity(1000, f10);
        float f11 = object.getXVelocity();
        int n12 = (int)f11;
        float f12 = object.getYVelocity();
        int n13 = (int)f12;
        RecyclerView recyclerView = this.mRecyclerView;
        boolean bl2 = recyclerView.fling(n12, n13);
        if (!bl2) {
            object = this.mViewPager;
            ((ViewPager2)((Object)object)).snapToPage();
        }
        return true;
    }

    /*
     * WARNING - void declaration
     */
    public boolean fakeDragBy(float f10) {
        float f11;
        void var3_8;
        int n10;
        float f12;
        Object object = this.mScrollEventAdapter;
        boolean bl2 = ((ScrollEventAdapter)object).isFakeDragging();
        int n11 = 0;
        if (!bl2) {
            return false;
        }
        this.mRequestedDragDistance = f12 = this.mRequestedDragDistance - f10;
        f10 = this.mActualDraggedDistance;
        int n12 = Math.round(f12 -= f10);
        this.mActualDraggedDistance = n10 = this.mActualDraggedDistance + n12;
        long l10 = SystemClock.uptimeMillis();
        object = this.mViewPager;
        int n13 = ((ViewPager2)((Object)object)).getOrientation();
        boolean bl3 = true;
        float f13 = Float.MIN_VALUE;
        if (n13 == 0) {
            boolean bl4 = bl3;
            f12 = f13;
        } else {
            boolean bl5 = false;
            object = null;
            f12 = 0.0f;
        }
        int n14 = var3_8 != false ? n12 : 0;
        if (var3_8 == false) {
            n11 = n12;
        }
        n12 = 0;
        f10 = 0.0f;
        float f14 = var3_8 != false ? (f11 = this.mRequestedDragDistance) : 0.0f;
        if (var3_8 == false) {
            f10 = this.mRequestedDragDistance;
        }
        this.mRecyclerView.scrollBy(n14, n11);
        this.addFakeMotionEvent(l10, 2, f14, f10);
        return bl3;
    }

    public boolean isFakeDragging() {
        return this.mScrollEventAdapter.isFakeDragging();
    }
}

