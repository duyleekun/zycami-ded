/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  androidx.viewpager2.widget.AnimateLayoutChangeDetector
 */
package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import androidx.viewpager2.widget.AnimateLayoutChangeDetector;
import androidx.viewpager2.widget.ScrollEventAdapter$ScrollEventValues;
import androidx.viewpager2.widget.ViewPager2;
import androidx.viewpager2.widget.ViewPager2$OnPageChangeCallback;
import java.util.Locale;

public final class ScrollEventAdapter
extends RecyclerView$OnScrollListener {
    private static final int NO_POSITION = 255;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2$OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;
    private final LinearLayoutManager mLayoutManager;
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventAdapter$ScrollEventValues mScrollValues;
    private int mTarget;
    private final ViewPager2 mViewPager;

    public ScrollEventAdapter(ViewPager2 object) {
        this.mViewPager = object;
        object = object.mRecyclerView;
        this.mRecyclerView = object;
        object = (LinearLayoutManager)object.getLayoutManager();
        this.mLayoutManager = object;
        this.mScrollValues = object;
        this.resetState();
    }

    private void dispatchScrolled(int n10, float f10, int n11) {
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.mCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            viewPager2$OnPageChangeCallback.onPageScrolled(n10, f10, n11);
        }
    }

    private void dispatchSelected(int n10) {
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.mCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            viewPager2$OnPageChangeCallback.onPageSelected(n10);
        }
    }

    private void dispatchStateChanged(int n10) {
        int n11 = this.mAdapterState;
        int n12 = 3;
        if (n11 == n12 && (n11 = this.mScrollState) == 0) {
            return;
        }
        n11 = this.mScrollState;
        if (n11 == n10) {
            return;
        }
        this.mScrollState = n10;
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.mCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            viewPager2$OnPageChangeCallback.onPageScrollStateChanged(n10);
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int n10;
        int n11 = this.mAdapterState;
        int n12 = 1;
        if (n11 != n12 && n11 != (n10 = 4)) {
            n12 = 0;
        }
        return n12 != 0;
    }

    private void resetState() {
        int n10;
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = n10 = -1;
        this.mTarget = n10;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean n10) {
        this.mFakeDragging = n10;
        int n11 = 1;
        n10 = n10 != 0 ? 4 : n11;
        this.mAdapterState = n10;
        n10 = this.mTarget;
        int n12 = -1;
        if (n10 != n12) {
            this.mDragStartPosition = n10;
            this.mTarget = n12;
        } else {
            n10 = this.mDragStartPosition;
            if (n10 == n12) {
                this.mDragStartPosition = n10 = this.getPosition();
            }
        }
        this.dispatchStateChanged(n11);
    }

    private void updateScrollEventValues() {
        float f10;
        int n10;
        int n11;
        Object object = this.mScrollValues;
        Object object2 = this.mLayoutManager;
        ((ScrollEventAdapter$ScrollEventValues)object).mPosition = n11 = ((LinearLayoutManager)object2).findFirstVisibleItemPosition();
        int n12 = -1;
        float f11 = 0.0f / 0.0f;
        if (n11 == n12) {
            ((ScrollEventAdapter$ScrollEventValues)object).reset();
            return;
        }
        Object object3 = this.mLayoutManager;
        object2 = ((LinearLayoutManager)object3).findViewByPosition(n11);
        if (object2 == null) {
            ((ScrollEventAdapter$ScrollEventValues)object).reset();
            return;
        }
        object3 = this.mLayoutManager;
        n12 = ((RecyclerView$LayoutManager)object3).getLeftDecorationWidth((View)object2);
        Object[] objectArray = this.mLayoutManager;
        int n13 = objectArray.getRightDecorationWidth((View)object2);
        LinearLayoutManager linearLayoutManager = this.mLayoutManager;
        int n14 = linearLayoutManager.getTopDecorationHeight((View)object2);
        LinearLayoutManager linearLayoutManager2 = this.mLayoutManager;
        int n15 = linearLayoutManager2.getBottomDecorationHeight((View)object2);
        ViewGroup.LayoutParams layoutParams = object2.getLayoutParams();
        int n16 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (n16 != 0) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            n16 = layoutParams.leftMargin;
            n12 += n16;
            n16 = layoutParams.rightMargin;
            n13 += n16;
            n16 = layoutParams.topMargin;
            n14 += n16;
            n10 = layoutParams.bottomMargin;
            n15 += n10;
        }
        n10 = object2.getHeight() + n14 + n15;
        n15 = object2.getWidth() + n12 + n13;
        objectArray = this.mLayoutManager;
        n13 = objectArray.getOrientation();
        n16 = 1;
        if (n13 == 0) {
            n13 = n16;
        } else {
            n13 = 0;
            objectArray = null;
        }
        if (n13 != 0) {
            n11 = object2.getLeft() - n12;
            n12 = this.mRecyclerView.getPaddingLeft();
            n11 -= n12;
            object3 = this.mViewPager;
            n12 = (int)(((ViewPager2)((Object)object3)).isRtl() ? 1 : 0);
            if (n12 != 0) {
                n11 = -n11;
            }
            n10 = n15;
        } else {
            n11 = object2.getTop() - n14;
            object3 = this.mRecyclerView;
            n12 = object3.getPaddingTop();
            n11 -= n12;
        }
        ((ScrollEventAdapter$ScrollEventValues)object).mOffsetPx = n11 = -n11;
        if (n11 < 0) {
            object3 = this.mLayoutManager;
            object2 = new AnimateLayoutChangeDetector((LinearLayoutManager)object3);
            n11 = (int)(object2.mayHaveInterferingAnimations() ? 1 : 0);
            if (n11 != 0) {
                object = new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
                throw object;
            }
            object3 = Locale.US;
            objectArray = new Object[n16];
            objectArray[0] = object = Integer.valueOf(((ScrollEventAdapter$ScrollEventValues)object).mOffsetPx);
            object = String.format((Locale)object3, "Page can only be offset by a positive amount, not by %d", objectArray);
            object2 = new IllegalStateException((String)object);
            throw object2;
        }
        if (n10 == 0) {
            n11 = 0;
            f10 = 0.0f;
            object2 = null;
        } else {
            f10 = n11;
            f11 = n10;
            f10 /= f11;
        }
        ((ScrollEventAdapter$ScrollEventValues)object).mOffset = f10;
    }

    public double getRelativeScrollPosition() {
        this.updateScrollEventValues();
        ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
        double d10 = scrollEventAdapter$ScrollEventValues.mPosition;
        double d11 = scrollEventAdapter$ScrollEventValues.mOffset;
        return d10 + d11;
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        int n10 = this.mScrollState;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        int n10 = this.mScrollState;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        this.startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        int n10 = this.isDragging();
        if (n10 != 0 && (n10 = this.mFakeDragging) == 0) {
            return;
        }
        n10 = 0;
        this.mFakeDragging = false;
        this.updateScrollEventValues();
        ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
        int n11 = scrollEventAdapter$ScrollEventValues.mOffsetPx;
        if (n11 == 0) {
            int n12 = scrollEventAdapter$ScrollEventValues.mPosition;
            n11 = this.mDragStartPosition;
            if (n12 != n11) {
                this.dispatchSelected(n12);
            }
            this.dispatchStateChanged(0);
            this.resetState();
        } else {
            n10 = 2;
            this.dispatchStateChanged(n10);
        }
    }

    /*
     * WARNING - void declaration
     */
    public void notifyProgrammaticScroll(int n10, boolean bl2) {
        boolean bl3;
        void var2_5;
        int n11 = 2;
        if (bl2) {
            int n12 = n11;
        } else {
            int n13 = 3;
        }
        this.mAdapterState = var2_5;
        boolean bl4 = false;
        this.mFakeDragging = false;
        int n14 = this.mTarget;
        if (n14 != n10) {
            bl3 = true;
        }
        this.mTarget = n10;
        this.dispatchStateChanged(n11);
        if (bl3) {
            this.dispatchSelected(n10);
        }
    }

    public void onScrollStateChanged(RecyclerView object, int n10) {
        int n11 = this.mAdapterState;
        int n12 = 1;
        if ((n11 != n12 || (n11 = this.mScrollState) != n12) && n10 == n12) {
            this.startDrag(false);
            return;
        }
        n11 = (int)(this.isInAnyDraggingState() ? 1 : 0);
        int n13 = 2;
        if (n11 != 0 && n10 == n13) {
            n11 = (int)(this.mScrollHappened ? 1 : 0);
            if (n11 != 0) {
                this.dispatchStateChanged(n13);
                this.mDispatchSelected = n12;
            }
            return;
        }
        n11 = (int)(this.isInAnyDraggingState() ? 1 : 0);
        int n14 = -1;
        if (n11 != 0 && n10 == 0) {
            this.updateScrollEventValues();
            n11 = (int)(this.mScrollHappened ? 1 : 0);
            if (n11 == 0) {
                object = this.mScrollValues;
                n11 = ((ScrollEventAdapter$ScrollEventValues)object).mPosition;
                if (n11 != n14) {
                    boolean bl2 = false;
                    this.dispatchScrolled(n11, 0.0f, 0);
                }
            } else {
                object = this.mScrollValues;
                int n15 = ((ScrollEventAdapter$ScrollEventValues)object).mOffsetPx;
                if (n15 == 0) {
                    n15 = this.mDragStartPosition;
                    n11 = ((ScrollEventAdapter$ScrollEventValues)object).mPosition;
                    if (n15 != n11) {
                        this.dispatchSelected(n11);
                    }
                } else {
                    n12 = 0;
                }
            }
            if (n12 != 0) {
                this.dispatchStateChanged(0);
                this.resetState();
            }
        }
        if ((n11 = this.mAdapterState) == n13 && n10 == 0 && (n11 = (int)(this.mDataSetChangeHappened ? 1 : 0)) != 0) {
            this.updateScrollEventValues();
            object = this.mScrollValues;
            n10 = ((ScrollEventAdapter$ScrollEventValues)object).mOffsetPx;
            if (n10 == 0) {
                n10 = this.mTarget;
                n11 = ((ScrollEventAdapter$ScrollEventValues)object).mPosition;
                if (n10 != n11) {
                    if (n11 == n14) {
                        n11 = 0;
                        object = null;
                    }
                    this.dispatchSelected(n11);
                }
                this.dispatchStateChanged(0);
                this.resetState();
            }
        }
    }

    /*
     * Unable to fully structure code
     */
    public void onScrolled(RecyclerView var1_1, int var2_2, int var3_3) {
        block12: {
            block11: {
                var4_4 = 1;
                this.mScrollHappened = var4_4;
                this.updateScrollEventValues();
                var5_5 = this.mDispatchSelected;
                var6_6 = -1;
                if (var5_5 == 0) break block11;
                this.mDispatchSelected = false;
                if (var3_3 > 0) ** GOTO lbl-1000
                if (var3_3 != 0) ** GOTO lbl-1000
                if (var2_2 < 0) {
                    var2_2 = var4_4;
                } else {
                    var2_2 = 0;
                    var7_7 = null;
                }
                var8_8 = this.mViewPager;
                var3_3 = (int)var8_8.isRtl();
                if (var2_2 != var3_3) lbl-1000:
                // 2 sources

                {
                    var2_2 = 0;
                    var7_7 = null;
                } else lbl-1000:
                // 2 sources

                {
                    var2_2 = var4_4;
                }
                if (var2_2 == 0) ** GOTO lbl-1000
                var7_7 = this.mScrollValues;
                var3_3 = var7_7.mOffsetPx;
                if (var3_3 != 0) {
                    var2_2 = var7_7.mPosition + var4_4;
                } else lbl-1000:
                // 2 sources

                {
                    var7_7 = this.mScrollValues;
                    var2_2 = var7_7.mPosition;
                }
                this.mTarget = var2_2;
                var3_3 = this.mDragStartPosition;
                if (var3_3 != var2_2) {
                    this.dispatchSelected(var2_2);
                }
                break block12;
            }
            var2_2 = this.mAdapterState;
            if (var2_2 == 0) {
                var7_7 = this.mScrollValues;
                var2_2 = var7_7.mPosition;
                if (var2_2 == var6_6) {
                    var2_2 = 0;
                    var7_7 = null;
                }
                this.dispatchSelected(var2_2);
            }
        }
        var7_7 = this.mScrollValues;
        var3_3 = var7_7.mPosition;
        if (var3_3 == var6_6) {
            var3_3 = 0;
            var8_8 = null;
        }
        var9_9 = var7_7.mOffset;
        var2_2 = var7_7.mOffsetPx;
        this.dispatchScrolled(var3_3, var9_9, var2_2);
        var7_7 = this.mScrollValues;
        var3_3 = var7_7.mPosition;
        var5_5 = this.mTarget;
        if ((var3_3 == var5_5 || var5_5 == var6_6) && (var2_2 = var7_7.mOffsetPx) == 0 && (var2_2 = this.mScrollState) != var4_4) {
            this.dispatchStateChanged(0);
            this.resetState();
        }
    }

    public void setOnPageChangeCallback(ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback) {
        this.mCallback = viewPager2$OnPageChangeCallback;
    }
}

