/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.graphics.RectF
 *  android.os.Bundle
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.recyclerview.R$styleable;
import androidx.recyclerview.widget.ChildHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$1;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$2;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$Properties;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.ViewBoundsCheck;
import androidx.recyclerview.widget.ViewBoundsCheck$Callback;
import androidx.recyclerview.widget.ViewInfoStore;
import java.util.ArrayList;

public abstract class RecyclerView$LayoutManager {
    public boolean mAutoMeasure;
    public ChildHelper mChildHelper;
    private int mHeight;
    private int mHeightMode;
    public ViewBoundsCheck mHorizontalBoundCheck;
    private final ViewBoundsCheck$Callback mHorizontalBoundCheckCallback;
    public boolean mIsAttachedToWindow;
    private boolean mItemPrefetchEnabled;
    private boolean mMeasurementCacheEnabled;
    public int mPrefetchMaxCountObserved;
    public boolean mPrefetchMaxObservedInInitialPrefetch;
    public RecyclerView mRecyclerView;
    public boolean mRequestedSimpleAnimations;
    public RecyclerView$SmoothScroller mSmoothScroller;
    public ViewBoundsCheck mVerticalBoundCheck;
    private final ViewBoundsCheck$Callback mVerticalBoundCheckCallback;
    private int mWidth;
    private int mWidthMode;

    public RecyclerView$LayoutManager() {
        boolean bl2;
        ViewBoundsCheck viewBoundsCheck;
        Object object = new RecyclerView$LayoutManager$1(this);
        this.mHorizontalBoundCheckCallback = object;
        RecyclerView$LayoutManager$2 recyclerView$LayoutManager$2 = new RecyclerView$LayoutManager$2(this);
        this.mVerticalBoundCheckCallback = recyclerView$LayoutManager$2;
        this.mHorizontalBoundCheck = viewBoundsCheck = new ViewBoundsCheck((ViewBoundsCheck$Callback)object);
        this.mVerticalBoundCheck = object = new ViewBoundsCheck(recyclerView$LayoutManager$2);
        this.mRequestedSimpleAnimations = false;
        this.mIsAttachedToWindow = false;
        this.mAutoMeasure = false;
        this.mMeasurementCacheEnabled = bl2 = true;
        this.mItemPrefetchEnabled = bl2;
    }

    /*
     * Enabled aggressive block sorting
     */
    private void addViewInt(View object, int n10, boolean bl2) {
        boolean bl3;
        Object object2;
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        block12: {
            int n11;
            block11: {
                RecyclerView recyclerView;
                recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt((View)object);
                if (!bl2 && !(bl2 = recyclerView$ViewHolder.isRemoved())) {
                    object2 = this.mRecyclerView.mViewInfoStore;
                    ((ViewInfoStore)object2).removeFromDisappearedInLayout(recyclerView$ViewHolder);
                } else {
                    object2 = this.mRecyclerView.mViewInfoStore;
                    ((ViewInfoStore)object2).addToDisappearedInLayout(recyclerView$ViewHolder);
                }
                object2 = (RecyclerView$LayoutParams)object.getLayoutParams();
                n11 = recyclerView$ViewHolder.wasReturnedFromScrap();
                if (n11 != 0 || (n11 = recyclerView$ViewHolder.isScrap()) != 0) break block11;
                Object object3 = object.getParent();
                if (object3 == (recyclerView = this.mRecyclerView)) {
                    Object object4;
                    object3 = this.mChildHelper;
                    n11 = ((ChildHelper)object3).indexOfChild((View)object);
                    int n12 = -1;
                    if (n10 == n12) {
                        object4 = this.mChildHelper;
                        n10 = ((ChildHelper)object4).getChildCount();
                    }
                    if (n11 == n12) {
                        object2 = new StringBuilder();
                        ((StringBuilder)object2).append("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                        int n13 = this.mRecyclerView.indexOfChild((View)object);
                        ((StringBuilder)object2).append(n13);
                        object = this.mRecyclerView.exceptionLabel();
                        ((StringBuilder)object2).append((String)object);
                        object = ((StringBuilder)object2).toString();
                        object4 = new IllegalStateException((String)object);
                        throw object4;
                    }
                    if (n11 != n10) {
                        object = this.mRecyclerView.mLayout;
                        ((RecyclerView$LayoutManager)object).moveView(n11, n10);
                    }
                    break block12;
                } else {
                    object3 = this.mChildHelper;
                    ((ChildHelper)object3).addView((View)object, n10, false);
                    n10 = 1;
                    ((RecyclerView$LayoutParams)object2).mInsetsDirty = n10;
                    RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.mSmoothScroller;
                    if (recyclerView$SmoothScroller != null && (n10 = (int)(recyclerView$SmoothScroller.isRunning() ? 1 : 0)) != 0) {
                        recyclerView$SmoothScroller = this.mSmoothScroller;
                        recyclerView$SmoothScroller.onChildAttachedToWindow((View)object);
                    }
                }
                break block12;
            }
            n11 = recyclerView$ViewHolder.isScrap();
            if (n11 != 0) {
                recyclerView$ViewHolder.unScrap();
            } else {
                recyclerView$ViewHolder.clearReturnedFromScrapFlag();
            }
            ChildHelper childHelper = this.mChildHelper;
            ViewGroup.LayoutParams layoutParams = object.getLayoutParams();
            childHelper.attachViewToParent((View)object, n10, layoutParams, false);
        }
        if (bl3 = ((RecyclerView$LayoutParams)object2).mPendingInvalidate) {
            object = recyclerView$ViewHolder.itemView;
            object.invalidate();
            ((RecyclerView$LayoutParams)object2).mPendingInvalidate = false;
        }
    }

    public static int chooseSize(int n10, int n11, int n12) {
        int n13 = View.MeasureSpec.getMode((int)n10);
        n10 = View.MeasureSpec.getSize((int)n10);
        int n14 = -1 << -1;
        if (n13 != n14) {
            n14 = 0x40000000;
            if (n13 != n14) {
                n10 = Math.max(n11, n12);
            }
            return n10;
        }
        n11 = Math.max(n11, n12);
        return Math.min(n10, n11);
    }

    private void detachViewInternal(int n10, View view) {
        this.mChildHelper.detachViewFromParent(n10);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int getChildMeasureSpec(int n10, int n11, int n12, int n13, boolean bl2) {
        block11: {
            int n14;
            int n15;
            int n16;
            block13: {
                block10: {
                    int n17;
                    block12: {
                        block9: {
                            block8: {
                                n10 -= n12;
                                n12 = 0;
                                n10 = Math.max(0, n10);
                                n16 = -2;
                                n17 = -1;
                                n15 = -1 << -1;
                                n14 = 0x40000000;
                                if (!bl2) break block8;
                                if (n13 >= 0) break block9;
                                if (n13 == n17 && (n11 == n15 || n11 != 0 && n11 == n14)) break block10;
                                break block11;
                            }
                            if (n13 < 0) break block12;
                        }
                        n11 = n14;
                        return View.MeasureSpec.makeMeasureSpec((int)n13, (int)n11);
                    }
                    if (n13 != n17) break block13;
                }
                n13 = n10;
                return View.MeasureSpec.makeMeasureSpec((int)n13, (int)n11);
            }
            if (n13 == n16) {
                if (n11 != n15 && n11 != n14) {
                    n13 = n10;
                    n11 = 0;
                    return View.MeasureSpec.makeMeasureSpec((int)n13, (int)n11);
                }
                n13 = n10;
                n11 = n15;
                return View.MeasureSpec.makeMeasureSpec((int)n13, (int)n11);
            }
        }
        n11 = 0;
        n13 = 0;
        return View.MeasureSpec.makeMeasureSpec((int)n13, (int)n11);
    }

    /*
     * Enabled aggressive block sorting
     */
    public static int getChildMeasureSpec(int n10, int n11, int n12, boolean n13) {
        block8: {
            block5: {
                block7: {
                    int n14;
                    block6: {
                        block4: {
                            n10 -= n11;
                            n11 = 0;
                            n10 = Math.max(0, n10);
                            n14 = 0x40000000;
                            if (n13 == 0) break block4;
                            if (n12 < 0) break block5;
                            break block6;
                        }
                        if (n12 >= 0) break block6;
                        n13 = -1;
                        if (n12 != n13) break block7;
                        n12 = n10;
                    }
                    n11 = n14;
                    return View.MeasureSpec.makeMeasureSpec((int)n12, (int)n11);
                }
                n13 = -2;
                if (n12 == n13) break block8;
            }
            n12 = 0;
            return View.MeasureSpec.makeMeasureSpec((int)n12, (int)n11);
        }
        n11 = -1 << -1;
        n12 = n10;
        return View.MeasureSpec.makeMeasureSpec((int)n12, (int)n11);
    }

    private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
        int n10;
        int n11 = 2;
        int[] nArray = new int[n11];
        int n12 = this.getPaddingLeft();
        int n13 = this.getPaddingTop();
        int n14 = this.getWidth();
        int n15 = this.getPaddingRight();
        n14 -= n15;
        n15 = this.getHeight();
        int n16 = this.getPaddingBottom();
        n15 -= n16;
        n16 = view.getLeft();
        int n17 = rect.left;
        n16 += n17;
        n17 = view.getScrollX();
        n16 -= n17;
        n17 = view.getTop();
        int n18 = rect.top;
        n17 += n18;
        int n19 = view.getScrollY();
        n17 -= n19;
        n19 = rect.width() + n16;
        int n20 = rect.height() + n17;
        n16 -= n12;
        n12 = 0;
        n18 = Math.min(0, n16);
        n17 -= n13;
        n13 = Math.min(0, n17);
        n19 -= n14;
        n14 = Math.max(0, n19);
        n20 -= n15;
        n20 = Math.max(0, n20);
        n15 = this.getLayoutDirection();
        if (n15 == (n10 = 1)) {
            if (n14 == 0) {
                n14 = Math.max(n18, n19);
            }
        } else {
            if (n18 == 0) {
                n18 = Math.min(n16, n14);
            }
            n14 = n18;
        }
        if (n13 == 0) {
            n13 = Math.min(n17, n20);
        }
        nArray[0] = n14;
        nArray[n10] = n13;
        return nArray;
    }

    public static RecyclerView$LayoutManager$Properties getProperties(Context context, AttributeSet attributeSet, int n10, int n11) {
        RecyclerView$LayoutManager$Properties recyclerView$LayoutManager$Properties = new RecyclerView$LayoutManager$Properties();
        int[] nArray = R$styleable.RecyclerView;
        context = context.obtainStyledAttributes(attributeSet, nArray, n10, n11);
        int n12 = R$styleable.RecyclerView_android_orientation;
        n10 = 1;
        recyclerView$LayoutManager$Properties.orientation = n12 = context.getInt(n12, n10);
        n12 = R$styleable.RecyclerView_spanCount;
        recyclerView$LayoutManager$Properties.spanCount = n12 = context.getInt(n12, n10);
        n12 = R$styleable.RecyclerView_reverseLayout;
        n12 = (int)(context.getBoolean(n12, false) ? 1 : 0);
        recyclerView$LayoutManager$Properties.reverseLayout = n12;
        n12 = R$styleable.RecyclerView_stackFromEnd;
        n12 = (int)(context.getBoolean(n12, false) ? 1 : 0);
        recyclerView$LayoutManager$Properties.stackFromEnd = n12;
        context.recycle();
        return recyclerView$LayoutManager$Properties;
    }

    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int n10, int n11) {
        if ((recyclerView = recyclerView.getFocusedChild()) == null) {
            return false;
        }
        int n12 = this.getPaddingLeft();
        int n13 = this.getPaddingTop();
        int n14 = this.getWidth();
        int n15 = this.getPaddingRight();
        n14 -= n15;
        n15 = this.getHeight();
        int n16 = this.getPaddingBottom();
        Rect rect = this.mRecyclerView.mTempRect;
        this.getDecoratedBoundsWithMargins((View)recyclerView, rect);
        int n17 = rect.left - n10;
        return n17 < n14 && (n17 = rect.right - n10) > n12 && (n17 = rect.top - n11) < (n15 -= n16) && (n17 = rect.bottom - n11) > n13;
        {
        }
    }

    private static boolean isMeasurementUpToDate(int n10, int n11, int n12) {
        int n13 = View.MeasureSpec.getMode((int)n11);
        n11 = View.MeasureSpec.getSize((int)n11);
        boolean bl2 = false;
        if (n12 > 0 && n10 != n12) {
            return false;
        }
        n12 = -1 << -1;
        boolean bl3 = true;
        if (n13 != n12) {
            if (n13 != 0) {
                n12 = 0x40000000;
                if (n13 != n12) {
                    return false;
                }
                if (n11 == n10) {
                    bl2 = bl3;
                }
                return bl2;
            }
            return bl3;
        }
        if (n11 >= n10) {
            bl2 = bl3;
        }
        return bl2;
    }

    private void scrapOrRecycleView(RecyclerView$Recycler object, int n10, View view) {
        RecyclerView$Adapter recyclerView$Adapter;
        RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(view);
        boolean bl2 = recyclerView$ViewHolder.shouldIgnore();
        if (bl2) {
            return;
        }
        bl2 = recyclerView$ViewHolder.isInvalid();
        if (bl2 && !(bl2 = recyclerView$ViewHolder.isRemoved()) && !(bl2 = (recyclerView$Adapter = this.mRecyclerView.mAdapter).hasStableIds())) {
            this.removeViewAt(n10);
            ((RecyclerView$Recycler)object).recycleViewHolderInternal(recyclerView$ViewHolder);
        } else {
            this.detachViewAt(n10);
            ((RecyclerView$Recycler)object).scrapView(view);
            object = this.mRecyclerView.mViewInfoStore;
            ((ViewInfoStore)object).onViewDetached(recyclerView$ViewHolder);
        }
    }

    public void addDisappearingView(View view) {
        this.addDisappearingView(view, -1);
    }

    public void addDisappearingView(View view, int n10) {
        this.addViewInt(view, n10, true);
    }

    public void addView(View view) {
        this.addView(view, -1);
    }

    public void addView(View view, int n10) {
        this.addViewInt(view, n10, false);
    }

    public void assertInLayoutOrScroll(String string2) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertInLayoutOrScroll(string2);
        }
    }

    public void assertNotInLayoutOrScroll(String string2) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertNotInLayoutOrScroll(string2);
        }
    }

    public void attachView(View view) {
        this.attachView(view, -1);
    }

    public void attachView(View view, int n10) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        this.attachView(view, n10, recyclerView$LayoutParams);
    }

    public void attachView(View view, int n10, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        Object object;
        RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(view);
        boolean bl2 = recyclerView$ViewHolder.isRemoved();
        if (bl2) {
            object = this.mRecyclerView.mViewInfoStore;
            ((ViewInfoStore)object).addToDisappearedInLayout(recyclerView$ViewHolder);
        } else {
            object = this.mRecyclerView.mViewInfoStore;
            ((ViewInfoStore)object).removeFromDisappearedInLayout(recyclerView$ViewHolder);
        }
        object = this.mChildHelper;
        boolean bl3 = recyclerView$ViewHolder.isRemoved();
        ((ChildHelper)object).attachViewToParent(view, n10, (ViewGroup.LayoutParams)recyclerView$LayoutParams, bl3);
    }

    public void calculateItemDecorationsForChild(View view, Rect rect) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
            return;
        }
        view = recyclerView.getItemDecorInsetsForChild(view);
        rect.set((Rect)view);
    }

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return false;
    }

    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        boolean bl2;
        if (recyclerView$LayoutParams != null) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView$LayoutParams = null;
        }
        return bl2;
    }

    public void collectAdjacentPrefetchPositions(int n10, int n11, RecyclerView$State recyclerView$State, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
    }

    public void collectInitialPrefetchPositions(int n10, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
    }

    public int computeHorizontalScrollExtent(RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeHorizontalScrollOffset(RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeHorizontalScrollRange(RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeVerticalScrollExtent(RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeVerticalScrollOffset(RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeVerticalScrollRange(RecyclerView$State recyclerView$State) {
        return 0;
    }

    public void detachAndScrapAttachedViews(RecyclerView$Recycler recyclerView$Recycler) {
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            View view = this.getChildAt(i10);
            this.scrapOrRecycleView(recyclerView$Recycler, i10, view);
        }
    }

    public void detachAndScrapView(View view, RecyclerView$Recycler recyclerView$Recycler) {
        int n10 = this.mChildHelper.indexOfChild(view);
        this.scrapOrRecycleView(recyclerView$Recycler, n10, view);
    }

    public void detachAndScrapViewAt(int n10, RecyclerView$Recycler recyclerView$Recycler) {
        View view = this.getChildAt(n10);
        this.scrapOrRecycleView(recyclerView$Recycler, n10, view);
    }

    public void detachView(View view) {
        ChildHelper childHelper = this.mChildHelper;
        int n10 = childHelper.indexOfChild(view);
        if (n10 >= 0) {
            this.detachViewInternal(n10, view);
        }
    }

    public void detachViewAt(int n10) {
        View view = this.getChildAt(n10);
        this.detachViewInternal(n10, view);
    }

    public void dispatchAttachedToWindow(RecyclerView recyclerView) {
        this.mIsAttachedToWindow = true;
        this.onAttachedToWindow(recyclerView);
    }

    public void dispatchDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        this.mIsAttachedToWindow = false;
        this.onDetachedFromWindow(recyclerView, recyclerView$Recycler);
    }

    public void endAnimation(View object) {
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mRecyclerView.mItemAnimator;
        if (recyclerView$ItemAnimator != null) {
            object = RecyclerView.getChildViewHolderInt(object);
            recyclerView$ItemAnimator.endAnimation((RecyclerView$ViewHolder)object);
        }
    }

    public View findContainingItemView(View view) {
        Object object = this.mRecyclerView;
        if (object == null) {
            return null;
        }
        if ((view = ((RecyclerView)object).findContainingItemView(view)) == null) {
            return null;
        }
        object = this.mChildHelper;
        boolean bl2 = ((ChildHelper)object).isHidden(view);
        if (bl2) {
            return null;
        }
        return view;
    }

    public View findViewByPosition(int n10) {
        int n11 = this.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            boolean bl2;
            RecyclerView$State recyclerView$State;
            int n12;
            View view = this.getChildAt(i10);
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(view);
            if (recyclerView$ViewHolder == null || (n12 = recyclerView$ViewHolder.getLayoutPosition()) != n10 || (n12 = (int)(recyclerView$ViewHolder.shouldIgnore() ? 1 : 0)) != 0 || (n12 = (int)((recyclerView$State = this.mRecyclerView.mState).isPreLayout() ? 1 : 0)) == 0 && (bl2 = recyclerView$ViewHolder.isRemoved())) continue;
            return view;
        }
        return null;
    }

    public abstract RecyclerView$LayoutParams generateDefaultLayoutParams();

    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = new RecyclerView$LayoutParams(context, attributeSet);
        return recyclerView$LayoutParams;
    }

    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup.LayoutParams object) {
        boolean bl2 = object instanceof RecyclerView$LayoutParams;
        if (bl2) {
            object = (RecyclerView$LayoutParams)((Object)object);
            RecyclerView$LayoutParams recyclerView$LayoutParams = new RecyclerView$LayoutParams((RecyclerView$LayoutParams)((Object)object));
            return recyclerView$LayoutParams;
        }
        bl2 = object instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            object = (ViewGroup.MarginLayoutParams)object;
            RecyclerView$LayoutParams recyclerView$LayoutParams = new RecyclerView$LayoutParams((ViewGroup.MarginLayoutParams)object);
            return recyclerView$LayoutParams;
        }
        RecyclerView$LayoutParams recyclerView$LayoutParams = new RecyclerView$LayoutParams((ViewGroup.LayoutParams)object);
        return recyclerView$LayoutParams;
    }

    public int getBaseline() {
        return -1;
    }

    public int getBottomDecorationHeight(View view) {
        return ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets.bottom;
    }

    public View getChildAt(int n10) {
        View view;
        ChildHelper childHelper = this.mChildHelper;
        if (childHelper != null) {
            view = childHelper.getChildAt(n10);
        } else {
            n10 = 0;
            view = null;
        }
        return view;
    }

    public int getChildCount() {
        int n10;
        ChildHelper childHelper = this.mChildHelper;
        if (childHelper != null) {
            n10 = childHelper.getChildCount();
        } else {
            n10 = 0;
            childHelper = null;
        }
        return n10;
    }

    public boolean getClipToPadding() {
        boolean bl2;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (bl2 = recyclerView.mClipToPadding)) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView = null;
        }
        return bl2;
    }

    public int getColumnCountForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return -1;
    }

    public int getDecoratedBottom(View view) {
        int n10 = view.getBottom();
        int n11 = this.getBottomDecorationHeight(view);
        return n10 + n11;
    }

    public void getDecoratedBoundsWithMargins(View view, Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public int getDecoratedLeft(View view) {
        int n10 = view.getLeft();
        int n11 = this.getLeftDecorationWidth(view);
        return n10 - n11;
    }

    public int getDecoratedMeasuredHeight(View view) {
        Rect rect = ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets;
        int n10 = view.getMeasuredHeight();
        int n11 = rect.top;
        int n12 = rect.bottom;
        return (n10 += n11) + n12;
    }

    public int getDecoratedMeasuredWidth(View view) {
        Rect rect = ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets;
        int n10 = view.getMeasuredWidth();
        int n11 = rect.left;
        int n12 = rect.right;
        return (n10 += n11) + n12;
    }

    public int getDecoratedRight(View view) {
        int n10 = view.getRight();
        int n11 = this.getRightDecorationWidth(view);
        return n10 + n11;
    }

    public int getDecoratedTop(View view) {
        int n10 = view.getTop();
        int n11 = this.getTopDecorationHeight(view);
        return n10 - n11;
    }

    public View getFocusedChild() {
        ChildHelper childHelper;
        boolean bl2;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return null;
        }
        if ((recyclerView = recyclerView.getFocusedChild()) != null && !(bl2 = (childHelper = this.mChildHelper).isHidden((View)recyclerView))) {
            return recyclerView;
        }
        return null;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getHeightMode() {
        return this.mHeightMode;
    }

    public int getItemCount() {
        int n10;
        Object object = this.mRecyclerView;
        if (object != null) {
            object = ((RecyclerView)object).getAdapter();
        } else {
            n10 = 0;
            object = null;
        }
        if (object != null) {
            n10 = ((RecyclerView$Adapter)object).getItemCount();
        } else {
            n10 = 0;
            object = null;
        }
        return n10;
    }

    public int getItemViewType(View view) {
        return RecyclerView.getChildViewHolderInt(view).getItemViewType();
    }

    public int getLayoutDirection() {
        return ViewCompat.getLayoutDirection((View)this.mRecyclerView);
    }

    public int getLeftDecorationWidth(View view) {
        return ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets.left;
    }

    public int getMinimumHeight() {
        return ViewCompat.getMinimumHeight((View)this.mRecyclerView);
    }

    public int getMinimumWidth() {
        return ViewCompat.getMinimumWidth((View)this.mRecyclerView);
    }

    public int getPaddingBottom() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            n10 = recyclerView.getPaddingBottom();
        } else {
            n10 = 0;
            recyclerView = null;
        }
        return n10;
    }

    public int getPaddingEnd() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            n10 = ViewCompat.getPaddingEnd((View)recyclerView);
        } else {
            n10 = 0;
            recyclerView = null;
        }
        return n10;
    }

    public int getPaddingLeft() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            n10 = recyclerView.getPaddingLeft();
        } else {
            n10 = 0;
            recyclerView = null;
        }
        return n10;
    }

    public int getPaddingRight() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            n10 = recyclerView.getPaddingRight();
        } else {
            n10 = 0;
            recyclerView = null;
        }
        return n10;
    }

    public int getPaddingStart() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            n10 = ViewCompat.getPaddingStart((View)recyclerView);
        } else {
            n10 = 0;
            recyclerView = null;
        }
        return n10;
    }

    public int getPaddingTop() {
        int n10;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            n10 = recyclerView.getPaddingTop();
        } else {
            n10 = 0;
            recyclerView = null;
        }
        return n10;
    }

    public int getPosition(View view) {
        return ((RecyclerView$LayoutParams)view.getLayoutParams()).getViewLayoutPosition();
    }

    public int getRightDecorationWidth(View view) {
        return ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets.right;
    }

    public int getRowCountForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return -1;
    }

    public int getSelectionModeForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int getTopDecorationHeight(View view) {
        return ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets.top;
    }

    /*
     * WARNING - void declaration
     */
    public void getTransformedBoundingBox(View view, boolean bl2, Rect rect) {
        float f10;
        void var3_8;
        int n10;
        int n11;
        int n12;
        Object object;
        if (bl2) {
            object = ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets;
            n12 = -object.left;
            n11 = -object.top;
            n10 = view.getWidth();
            int n13 = object.right;
            n10 += n13;
            n13 = view.getHeight();
            int n14 = object.bottom;
            var3_8.set(n12, n11, n10, n13 += n14);
        } else {
            int n15 = view.getWidth();
            n12 = view.getHeight();
            n11 = 0;
            f10 = 0.0f;
            var3_8.set(0, 0, n15, n12);
        }
        object = this.mRecyclerView;
        if (object != null && (object = view.getMatrix()) != null && (n12 = (int)(object.isIdentity() ? 1 : 0)) == 0) {
            RectF rectF = this.mRecyclerView.mTempRectF;
            rectF.set((Rect)var3_8);
            object.mapRect(rectF);
            float f11 = rectF.left;
            int n16 = (int)Math.floor(f11);
            f10 = rectF.top;
            double d10 = Math.floor(f10);
            n11 = (int)d10;
            float f12 = rectF.right;
            double d11 = Math.ceil(f12);
            n10 = (int)d11;
            float f13 = rectF.bottom;
            double d12 = Math.ceil(f13);
            n12 = (int)d12;
            var3_8.set(n16, n11, n10, n12);
        }
        int n17 = view.getLeft();
        int n18 = view.getTop();
        var3_8.offset(n17, n18);
    }

    public int getWidth() {
        return this.mWidth;
    }

    public int getWidthMode() {
        return this.mWidthMode;
    }

    public boolean hasFlexibleChildInBothOrientations() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            int n11;
            ViewGroup.LayoutParams layoutParams = this.getChildAt(i10).getLayoutParams();
            int n12 = layoutParams.width;
            if (n12 >= 0 || (n11 = layoutParams.height) >= 0) continue;
            return true;
        }
        return false;
    }

    public boolean hasFocus() {
        boolean bl2;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (bl2 = recyclerView.hasFocus())) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView = null;
        }
        return bl2;
    }

    public void ignoreView(View object) {
        int n10;
        int n11;
        Object object2;
        Object object3 = object.getParent();
        if (object3 == (object2 = this.mRecyclerView) && (n11 = object2.indexOfChild((View)object)) != (n10 = -1)) {
            object = RecyclerView.getChildViewHolderInt((View)object);
            ((RecyclerView$ViewHolder)object).addFlags(128);
            this.mRecyclerView.mViewInfoStore.removeViewHolder((RecyclerView$ViewHolder)object);
            return;
        }
        object3 = new StringBuilder();
        ((StringBuilder)object3).append("View should be fully attached to be ignored");
        object2 = this.mRecyclerView.exceptionLabel();
        ((StringBuilder)object3).append((String)object2);
        object3 = ((StringBuilder)object3).toString();
        object = new IllegalArgumentException((String)object3);
        throw object;
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public boolean isAutoMeasureEnabled() {
        return this.mAutoMeasure;
    }

    public boolean isFocused() {
        boolean bl2;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null && (bl2 = recyclerView.isFocused())) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView = null;
        }
        return bl2;
    }

    public final boolean isItemPrefetchEnabled() {
        return this.mItemPrefetchEnabled;
    }

    public boolean isLayoutHierarchical(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return false;
    }

    public boolean isMeasurementCacheEnabled() {
        return this.mMeasurementCacheEnabled;
    }

    public boolean isSmoothScrolling() {
        boolean bl2;
        RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.mSmoothScroller;
        if (recyclerView$SmoothScroller != null && (bl2 = recyclerView$SmoothScroller.isRunning())) {
            bl2 = true;
        } else {
            bl2 = false;
            recyclerView$SmoothScroller = null;
        }
        return bl2;
    }

    public boolean isViewPartiallyVisible(View view, boolean bl2, boolean bl3) {
        boolean bl4;
        ViewBoundsCheck viewBoundsCheck = this.mHorizontalBoundCheck;
        int n10 = 24579;
        bl3 = viewBoundsCheck.isViewWithinBoundFlags(view, n10);
        boolean bl5 = true;
        if (bl3 && (bl4 = (viewBoundsCheck = this.mVerticalBoundCheck).isViewWithinBoundFlags(view, n10))) {
            bl4 = bl5;
        } else {
            bl4 = false;
            view = null;
        }
        if (bl2) {
            return bl4;
        }
        return bl4 ^ bl5;
    }

    public void layoutDecorated(View view, int n10, int n11, int n12, int n13) {
        Rect rect = ((RecyclerView$LayoutParams)view.getLayoutParams()).mDecorInsets;
        int n14 = rect.left;
        n10 += n14;
        n14 = rect.top;
        n11 += n14;
        n14 = rect.right;
        int n15 = rect.bottom;
        view.layout(n10, n11, n12 -= n14, n13 -= n15);
    }

    public void layoutDecoratedWithMargins(View view, int n10, int n11, int n12, int n13) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        Rect rect = recyclerView$LayoutParams.mDecorInsets;
        int n14 = rect.left;
        n10 += n14;
        n14 = recyclerView$LayoutParams.leftMargin;
        n10 += n14;
        n14 = rect.top;
        n11 += n14;
        n14 = recyclerView$LayoutParams.topMargin;
        n11 += n14;
        n14 = rect.right;
        n12 -= n14;
        n14 = recyclerView$LayoutParams.rightMargin;
        int n15 = rect.bottom;
        n13 -= n15;
        int n16 = recyclerView$LayoutParams.bottomMargin;
        view.layout(n10, n11, n12 -= n14, n13 -= n16);
    }

    public void measureChild(View view, int n10, int n11) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        Rect rect = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int n12 = rect.left;
        int n13 = rect.right;
        n10 += (n12 += n13);
        n12 = rect.top;
        int n14 = rect.bottom;
        n11 += (n12 += n14);
        n14 = this.getWidth();
        n12 = this.getWidthMode();
        n13 = this.getPaddingLeft();
        int n15 = this.getPaddingRight();
        n13 = n13 + n15 + n10;
        n10 = recyclerView$LayoutParams.width;
        n15 = (int)(this.canScrollHorizontally() ? 1 : 0);
        n10 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n12, n13, n10, n15 != 0);
        n14 = this.getHeight();
        n12 = this.getHeightMode();
        n13 = this.getPaddingTop();
        n15 = this.getPaddingBottom();
        n13 = n13 + n15 + n11;
        n11 = recyclerView$LayoutParams.height;
        n15 = (int)(this.canScrollVertically() ? 1 : 0);
        boolean bl2 = this.shouldMeasureChild(view, n10, n11 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n12, n13, n11, n15 != 0), recyclerView$LayoutParams);
        if (bl2) {
            view.measure(n10, n11);
        }
    }

    public void measureChildWithMargins(View view, int n10, int n11) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        Rect rect = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int n12 = rect.left;
        int n13 = rect.right;
        n10 += (n12 += n13);
        n12 = rect.top;
        int n14 = rect.bottom;
        n11 += (n12 += n14);
        n14 = this.getWidth();
        n12 = this.getWidthMode();
        n13 = this.getPaddingLeft();
        int n15 = this.getPaddingRight();
        n13 += n15;
        n15 = recyclerView$LayoutParams.leftMargin;
        n13 += n15;
        n15 = recyclerView$LayoutParams.rightMargin;
        n13 = n13 + n15 + n10;
        n10 = recyclerView$LayoutParams.width;
        n15 = (int)(this.canScrollHorizontally() ? 1 : 0);
        n10 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n12, n13, n10, n15 != 0);
        n14 = this.getHeight();
        n12 = this.getHeightMode();
        n13 = this.getPaddingTop();
        n15 = this.getPaddingBottom();
        n13 += n15;
        n15 = recyclerView$LayoutParams.topMargin;
        n13 += n15;
        n15 = recyclerView$LayoutParams.bottomMargin;
        n13 = n13 + n15 + n11;
        n11 = recyclerView$LayoutParams.height;
        n15 = (int)(this.canScrollVertically() ? 1 : 0);
        boolean bl2 = this.shouldMeasureChild(view, n10, n11 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n12, n13, n11, n15 != 0), recyclerView$LayoutParams);
        if (bl2) {
            view.measure(n10, n11);
        }
    }

    public void moveView(int n10, int n11) {
        Object object = this.getChildAt(n10);
        if (object != null) {
            this.detachViewAt(n10);
            this.attachView((View)object, n11);
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("Cannot move a child from non-existing index:");
        ((StringBuilder)object).append(n10);
        String string2 = this.mRecyclerView.toString();
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void offsetChildrenHorizontal(int n10) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(n10);
        }
    }

    public void offsetChildrenVertical(int n10) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(n10);
        }
    }

    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter recyclerView$Adapter2) {
    }

    public boolean onAddFocusables(RecyclerView recyclerView, ArrayList arrayList, int n10, int n11) {
        return false;
    }

    public void onAttachedToWindow(RecyclerView recyclerView) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        this.onDetachedFromWindow(recyclerView);
    }

    public View onFocusSearchFailed(View view, int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        Object object = this.mRecyclerView;
        RecyclerView$Recycler recyclerView$Recycler = ((RecyclerView)object).mRecycler;
        object = ((RecyclerView)object).mState;
        this.onInitializeAccessibilityEvent(recyclerView$Recycler, (RecyclerView$State)object, accessibilityEvent);
    }

    public void onInitializeAccessibilityEvent(RecyclerView$Recycler object, RecyclerView$State recyclerView$State, AccessibilityEvent accessibilityEvent) {
        object = this.mRecyclerView;
        if (object != null && accessibilityEvent != null) {
            int n10;
            int n11 = 1;
            int n12 = object.canScrollVertically(n11);
            if (n12 == 0 && (n12 = (object = this.mRecyclerView).canScrollVertically(n10 = -1)) == 0 && (n12 = (int)((object = this.mRecyclerView).canScrollHorizontally(n10) ? 1 : 0)) == 0 && (n12 = (int)((object = this.mRecyclerView).canScrollHorizontally(n11) ? 1 : 0)) == 0) {
                n11 = 0;
            }
            accessibilityEvent.setScrollable(n11 != 0);
            object = this.mRecyclerView.mAdapter;
            if (object != null) {
                n12 = ((RecyclerView$Adapter)object).getItemCount();
                accessibilityEvent.setItemCount(n12);
            }
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object = this.mRecyclerView;
        RecyclerView$Recycler recyclerView$Recycler = ((RecyclerView)object).mRecycler;
        object = ((RecyclerView)object).mState;
        this.onInitializeAccessibilityNodeInfo(recyclerView$Recycler, (RecyclerView$State)object, accessibilityNodeInfoCompat);
    }

    public void onInitializeAccessibilityNodeInfo(RecyclerView$Recycler object, RecyclerView$State recyclerView$State, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        RecyclerView recyclerView = this.mRecyclerView;
        int n10 = -1;
        int n11 = recyclerView.canScrollVertically(n10);
        boolean bl2 = true;
        if (n11 != 0 || (n11 = (int)((recyclerView = this.mRecyclerView).canScrollHorizontally(n10) ? 1 : 0)) != 0) {
            n11 = 8192;
            accessibilityNodeInfoCompat.addAction(n11);
            accessibilityNodeInfoCompat.setScrollable(bl2);
        }
        if ((n11 = (int)((recyclerView = this.mRecyclerView).canScrollVertically((int)(bl2 ? 1 : 0)) ? 1 : 0)) != 0 || (n11 = (int)((recyclerView = this.mRecyclerView).canScrollHorizontally((int)(bl2 ? 1 : 0)) ? 1 : 0)) != 0) {
            n11 = 4096;
            accessibilityNodeInfoCompat.addAction(n11);
            accessibilityNodeInfoCompat.setScrollable(bl2);
        }
        n11 = this.getRowCountForAccessibility((RecyclerView$Recycler)object, recyclerView$State);
        n10 = this.getColumnCountForAccessibility((RecyclerView$Recycler)object, recyclerView$State);
        bl2 = this.isLayoutHierarchical((RecyclerView$Recycler)object, recyclerView$State);
        int n12 = this.getSelectionModeForAccessibility((RecyclerView$Recycler)object, recyclerView$State);
        object = AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(n11, n10, bl2, n12);
        accessibilityNodeInfoCompat.setCollectionInfo(object);
    }

    public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object;
        boolean bl2;
        boolean bl3;
        Object object2 = RecyclerView.getChildViewHolderInt(view);
        if (object2 != null && !(bl3 = ((RecyclerView$ViewHolder)object2).isRemoved()) && !(bl2 = ((ChildHelper)(object = this.mChildHelper)).isHidden((View)(object2 = ((RecyclerView$ViewHolder)object2).itemView)))) {
            object2 = this.mRecyclerView;
            object = ((RecyclerView)object2).mRecycler;
            object2 = ((RecyclerView)object2).mState;
            this.onInitializeAccessibilityNodeInfoForItem((RecyclerView$Recycler)object, (RecyclerView$State)object2, view, accessibilityNodeInfoCompat);
        }
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    public View onInterceptFocusSearch(View view, int n10) {
        return null;
    }

    public void onItemsAdded(RecyclerView recyclerView, int n10, int n11) {
    }

    public void onItemsChanged(RecyclerView recyclerView) {
    }

    public void onItemsMoved(RecyclerView recyclerView, int n10, int n11, int n12) {
    }

    public void onItemsRemoved(RecyclerView recyclerView, int n10, int n11) {
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n10, int n11) {
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n10, int n11, Object object) {
        this.onItemsUpdated(recyclerView, n10, n11);
    }

    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        Log.e((String)"RecyclerView", (String)"You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
    }

    public void onMeasure(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int n10, int n11) {
        this.mRecyclerView.defaultOnMeasure(n10, n11);
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, View view, View view2) {
        boolean bl2;
        boolean bl3 = this.isSmoothScrolling();
        if (!bl3 && !(bl2 = recyclerView.isComputingLayout())) {
            bl2 = false;
            recyclerView = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean onRequestChildFocus(RecyclerView recyclerView, RecyclerView$State recyclerView$State, View view, View view2) {
        return this.onRequestChildFocus(recyclerView, view, view2);
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onScrollStateChanged(int n10) {
    }

    public void onSmoothScrollerStopped(RecyclerView$SmoothScroller recyclerView$SmoothScroller) {
        RecyclerView$SmoothScroller recyclerView$SmoothScroller2 = this.mSmoothScroller;
        if (recyclerView$SmoothScroller2 == recyclerView$SmoothScroller) {
            recyclerView$SmoothScroller = null;
            this.mSmoothScroller = null;
        }
    }

    public boolean performAccessibilityAction(int n10, Bundle bundle) {
        Object object = this.mRecyclerView;
        RecyclerView$Recycler recyclerView$Recycler = ((RecyclerView)object).mRecycler;
        object = ((RecyclerView)object).mState;
        return this.performAccessibilityAction(recyclerView$Recycler, (RecyclerView$State)object, n10, bundle);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public boolean performAccessibilityAction(RecyclerView$Recycler var1_1, RecyclerView$State var2_2, int var3_3, Bundle var4_4) {
        block10: {
            block8: {
                block9: {
                    var1_1 = this.mRecyclerView;
                    if (var1_1 == null) {
                        return false;
                    }
                    var5_5 = 4096;
                    var6_6 = true;
                    if (var3_3 == var5_5) break block8;
                    var5_5 = 8192;
                    if (var3_3 == var5_5) break block9;
                    var7_7 = 0;
                    var8_8 = 0;
                    break block10;
                }
                var3_3 = -1;
                var9_9 = (int)var1_1.canScrollVertically(var3_3);
                if (var9_9 != 0) {
                    var9_9 = this.getHeight();
                    var5_5 = this.getPaddingTop();
                    var9_9 -= var5_5;
                    var5_5 = this.getPaddingBottom();
                    var9_9 = -(var9_9 - var5_5);
                } else {
                    var9_9 = 0;
                    var1_1 = null;
                }
                var4_4 /* !! */  = this.mRecyclerView;
                var3_3 = (int)var4_4 /* !! */ .canScrollHorizontally(var3_3);
                if (var3_3 == 0) ** GOTO lbl-1000
                var3_3 = this.getWidth();
                var5_5 = this.getPaddingLeft();
                var3_3 -= var5_5;
                var5_5 = this.getPaddingRight();
                var3_3 = -(var3_3 - var5_5);
                ** GOTO lbl52
            }
            var9_9 = var1_1.canScrollVertically((int)var6_6);
            if (var9_9 != 0) {
                var9_9 = this.getHeight();
                var3_3 = this.getPaddingTop();
                var9_9 -= var3_3;
                var3_3 = this.getPaddingBottom();
                var9_9 -= var3_3;
            } else {
                var9_9 = 0;
                var1_1 = null;
            }
            var10_10 = this.mRecyclerView;
            var3_3 = (int)var10_10.canScrollHorizontally((int)var6_6);
            if (var3_3 != 0) {
                var3_3 = this.getWidth();
                var5_5 = this.getPaddingLeft();
                var3_3 -= var5_5;
                var5_5 = this.getPaddingRight();
                var3_3 -= var5_5;
lbl52:
                // 2 sources

                var8_8 = var9_9;
                var7_7 = var3_3;
            } else lbl-1000:
            // 2 sources

            {
                var8_8 = var9_9;
                var7_7 = 0;
            }
        }
        if (var8_8 == 0 && var7_7 == 0) {
            return false;
        }
        this.mRecyclerView.smoothScrollBy(var7_7, var8_8, null, -1 << -1, true);
        return var6_6;
    }

    public boolean performAccessibilityActionForItem(View view, int n10, Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView$Recycler recyclerView$Recycler = recyclerView.mRecycler;
        RecyclerView$State recyclerView$State = recyclerView.mState;
        return this.performAccessibilityActionForItem(recyclerView$Recycler, recyclerView$State, view, n10, bundle);
    }

    public boolean performAccessibilityActionForItem(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, View view, int n10, Bundle bundle) {
        return false;
    }

    public void postOnAnimation(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            ViewCompat.postOnAnimation((View)recyclerView, runnable);
        }
    }

    public void removeAllViews() {
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            ChildHelper childHelper = this.mChildHelper;
            childHelper.removeViewAt(i10);
        }
    }

    public void removeAndRecycleAllViews(RecyclerView$Recycler recyclerView$Recycler) {
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(this.getChildAt(i10));
            boolean bl2 = recyclerView$ViewHolder.shouldIgnore();
            if (bl2) continue;
            this.removeAndRecycleViewAt(i10, recyclerView$Recycler);
        }
    }

    public void removeAndRecycleScrapInt(RecyclerView$Recycler object) {
        int n10 = ((RecyclerView$Recycler)object).getScrapCount();
        for (int i10 = n10 + -1; i10 >= 0; i10 += -1) {
            View view = ((RecyclerView$Recycler)object).getScrapViewAt(i10);
            RecyclerView$ViewHolder recyclerView$ViewHolder = RecyclerView.getChildViewHolderInt(view);
            boolean bl2 = recyclerView$ViewHolder.shouldIgnore();
            if (bl2) continue;
            bl2 = false;
            RecyclerView$ItemAnimator recyclerView$ItemAnimator = null;
            recyclerView$ViewHolder.setIsRecyclable(false);
            boolean bl3 = recyclerView$ViewHolder.isTmpDetached();
            if (bl3) {
                RecyclerView recyclerView = this.mRecyclerView;
                recyclerView.removeDetachedView(view, false);
            }
            if ((recyclerView$ItemAnimator = this.mRecyclerView.mItemAnimator) != null) {
                recyclerView$ItemAnimator.endAnimation(recyclerView$ViewHolder);
            }
            bl2 = true;
            recyclerView$ViewHolder.setIsRecyclable(bl2);
            ((RecyclerView$Recycler)object).quickRecycleScrapView(view);
        }
        ((RecyclerView$Recycler)object).clearScrap();
        if (n10 > 0) {
            object = this.mRecyclerView;
            object.invalidate();
        }
    }

    public void removeAndRecycleView(View view, RecyclerView$Recycler recyclerView$Recycler) {
        this.removeView(view);
        recyclerView$Recycler.recycleView(view);
    }

    public void removeAndRecycleViewAt(int n10, RecyclerView$Recycler recyclerView$Recycler) {
        View view = this.getChildAt(n10);
        this.removeViewAt(n10);
        recyclerView$Recycler.recycleView(view);
    }

    public boolean removeCallbacks(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.removeCallbacks(runnable);
        }
        return false;
    }

    public void removeDetachedView(View view) {
        this.mRecyclerView.removeDetachedView(view, false);
    }

    public void removeView(View view) {
        this.mChildHelper.removeView(view);
    }

    public void removeViewAt(int n10) {
        Object object = this.getChildAt(n10);
        if (object != null) {
            object = this.mChildHelper;
            ((ChildHelper)object).removeViewAt(n10);
        }
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View view, Rect rect, boolean bl2) {
        return this.requestChildRectangleOnScreen(recyclerView, view, rect, bl2, false);
    }

    public boolean requestChildRectangleOnScreen(RecyclerView recyclerView, View object, Rect rect, boolean bl2, boolean bl3) {
        object = this.getChildRectangleOnScreenScrollAmount((View)object, rect);
        rect = null;
        View view = object[0];
        boolean bl4 = true;
        View view2 = object[bl4];
        if (bl3 && !(bl3 = this.isFocusedChildVisibleAfterScrolling(recyclerView, (int)view, (int)view2)) || view == false && view2 == false) {
            return false;
        }
        if (bl2) {
            recyclerView.scrollBy((int)view, (int)view2);
        } else {
            recyclerView.smoothScrollBy((int)view, (int)view2);
        }
        return bl4;
    }

    public void requestLayout() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public void requestSimpleAnimationsInNextLayout() {
        this.mRequestedSimpleAnimations = true;
    }

    public int scrollHorizontallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return 0;
    }

    public void scrollToPosition(int n10) {
    }

    public int scrollVerticallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return 0;
    }

    public void setAutoMeasureEnabled(boolean bl2) {
        this.mAutoMeasure = bl2;
    }

    public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
        int n10 = recyclerView.getWidth();
        int n11 = 0x40000000;
        n10 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n11);
        int n12 = View.MeasureSpec.makeMeasureSpec((int)recyclerView.getHeight(), (int)n11);
        this.setMeasureSpecs(n10, n12);
    }

    public final void setItemPrefetchEnabled(boolean bl2) {
        boolean bl3 = this.mItemPrefetchEnabled;
        if (bl2 != bl3) {
            this.mItemPrefetchEnabled = bl2;
            bl2 = false;
            this.mPrefetchMaxCountObserved = 0;
            Object object = this.mRecyclerView;
            if (object != null) {
                object = ((RecyclerView)object).mRecycler;
                ((RecyclerView$Recycler)object).updateViewCacheSize();
            }
        }
    }

    public void setMeasureSpecs(int n10, int n11) {
        int n12;
        this.mWidth = n12 = View.MeasureSpec.getSize((int)n10);
        this.mWidthMode = n10 = View.MeasureSpec.getMode((int)n10);
        n12 = 0;
        if (n10 == 0 && (n10 = (int)(RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC ? 1 : 0)) == 0) {
            this.mWidth = 0;
        }
        this.mHeight = n10 = View.MeasureSpec.getSize((int)n11);
        this.mHeightMode = n10 = View.MeasureSpec.getMode((int)n11);
        if (n10 == 0 && (n10 = (int)(RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC ? 1 : 0)) == 0) {
            this.mHeight = 0;
        }
    }

    public void setMeasuredDimension(int n10, int n11) {
        RecyclerView.access$300(this.mRecyclerView, n10, n11);
    }

    public void setMeasuredDimension(Rect rect, int n10, int n11) {
        int n12 = rect.width();
        int n13 = this.getPaddingLeft();
        n12 += n13;
        n13 = this.getPaddingRight();
        n12 += n13;
        int n14 = rect.height();
        n13 = this.getPaddingTop();
        n14 += n13;
        n13 = this.getPaddingBottom();
        n14 += n13;
        n13 = this.getMinimumWidth();
        n10 = RecyclerView$LayoutManager.chooseSize(n10, n12, n13);
        n12 = this.getMinimumHeight();
        n14 = RecyclerView$LayoutManager.chooseSize(n11, n14, n12);
        this.setMeasuredDimension(n10, n14);
    }

    public void setMeasuredDimensionFromChildren(int n10, int n11) {
        int n12;
        int n13 = this.getChildCount();
        if (n13 == 0) {
            this.mRecyclerView.defaultOnMeasure(n10, n11);
            return;
        }
        int n14 = -1 << -1;
        int n15 = n12 = -1 >>> 1;
        int n16 = n14;
        for (int i10 = 0; i10 < n13; ++i10) {
            View view = this.getChildAt(i10);
            Rect rect = this.mRecyclerView.mTempRect;
            this.getDecoratedBoundsWithMargins(view, rect);
            int n17 = rect.left;
            if (n17 < n12) {
                n12 = n17;
            }
            if ((n17 = rect.right) > n14) {
                n14 = n17;
            }
            if ((n17 = rect.top) < n15) {
                n15 = n17;
            }
            if ((n17 = rect.bottom) <= n16) continue;
            n16 = n17;
        }
        this.mRecyclerView.mTempRect.set(n12, n15, n14, n16);
        Rect rect = this.mRecyclerView.mTempRect;
        this.setMeasuredDimension(rect, n10, n11);
    }

    public void setMeasurementCacheEnabled(boolean bl2) {
        this.mMeasurementCacheEnabled = bl2;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        int n10;
        if (recyclerView == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            n10 = 0;
            recyclerView = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            int n11;
            ChildHelper childHelper;
            this.mRecyclerView = recyclerView;
            this.mChildHelper = childHelper = recyclerView.mChildHelper;
            this.mWidth = n11 = recyclerView.getWidth();
            this.mHeight = n10 = recyclerView.getHeight();
        }
        this.mWidthMode = n10 = 0x40000000;
        this.mHeightMode = n10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean shouldMeasureChild(View view, int n10, int n11, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        int n12;
        int n13 = view.isLayoutRequested();
        if (n13 != 0) return 1 != 0;
        n13 = this.mMeasurementCacheEnabled;
        if (n13 == 0) return 1 != 0;
        n13 = view.getWidth();
        n10 = (int)(RecyclerView$LayoutManager.isMeasurementUpToDate(n13, n10, n12 = recyclerView$LayoutParams.width) ? 1 : 0);
        if (n10 == 0) return 1 != 0;
        int n14 = view.getHeight();
        n10 = recyclerView$LayoutParams.height;
        if ((n14 = (int)(RecyclerView$LayoutManager.isMeasurementUpToDate(n14, n11, n10) ? 1 : 0)) != 0) return 0 != 0;
        return 1 != 0;
    }

    public boolean shouldMeasureTwice() {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean shouldReMeasureChild(View view, int n10, int n11, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        int n12;
        int n13 = this.mMeasurementCacheEnabled;
        if (n13 == 0) return 1 != 0;
        n13 = view.getMeasuredWidth();
        n10 = (int)(RecyclerView$LayoutManager.isMeasurementUpToDate(n13, n10, n12 = recyclerView$LayoutParams.width) ? 1 : 0);
        if (n10 == 0) return 1 != 0;
        int n14 = view.getMeasuredHeight();
        n10 = recyclerView$LayoutParams.height;
        if ((n14 = (int)(RecyclerView$LayoutManager.isMeasurementUpToDate(n14, n11, n10) ? 1 : 0)) != 0) return 0 != 0;
        return 1 != 0;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State recyclerView$State, int n10) {
        Log.e((String)"RecyclerView", (String)"You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void startSmoothScroll(RecyclerView$SmoothScroller recyclerView$SmoothScroller) {
        boolean bl2;
        Object object = this.mSmoothScroller;
        if (object != null && recyclerView$SmoothScroller != object && (bl2 = ((RecyclerView$SmoothScroller)object).isRunning())) {
            object = this.mSmoothScroller;
            ((RecyclerView$SmoothScroller)object).stop();
        }
        this.mSmoothScroller = recyclerView$SmoothScroller;
        object = this.mRecyclerView;
        recyclerView$SmoothScroller.start((RecyclerView)object, this);
    }

    public void stopIgnoringView(View object) {
        object = RecyclerView.getChildViewHolderInt((View)object);
        ((RecyclerView$ViewHolder)object).stopIgnoring();
        ((RecyclerView$ViewHolder)object).resetInternal();
        ((RecyclerView$ViewHolder)object).addFlags(4);
    }

    public void stopSmoothScroller() {
        RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.mSmoothScroller;
        if (recyclerView$SmoothScroller != null) {
            recyclerView$SmoothScroller.stop();
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }
}

