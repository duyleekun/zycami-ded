/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.view.View
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.ItemTouchHelper$ViewDropHandler;
import androidx.recyclerview.widget.LinearLayoutManager$AnchorInfo;
import androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult;
import androidx.recyclerview.widget.LinearLayoutManager$LayoutState;
import androidx.recyclerview.widget.LinearLayoutManager$SavedState;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$Properties;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.ScrollbarHelper;
import androidx.recyclerview.widget.ViewBoundsCheck;
import java.util.List;

public class LinearLayoutManager
extends RecyclerView$LayoutManager
implements ItemTouchHelper$ViewDropHandler,
RecyclerView$SmoothScroller$ScrollVectorProvider {
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public final LinearLayoutManager$AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LinearLayoutManager$LayoutChunkResult mLayoutChunkResult;
    private LinearLayoutManager$LayoutState mLayoutState;
    public int mOrientation;
    public OrientationHelper mOrientationHelper;
    public LinearLayoutManager$SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    public LinearLayoutManager(Context object, int n10, boolean bl2) {
        int n11;
        this.mOrientation = n11 = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = n11;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -1 << -1;
        this.mPendingSavedState = null;
        this.mAnchorInfo = object;
        super();
        this.mLayoutChunkResult = object;
        this.mInitialPrefetchItemCount = n11 = 2;
        object = new int[n11];
        this.mReusableIntPair = (int[])object;
        this.setOrientation(n10);
        this.setReverseLayout(bl2);
    }

    public LinearLayoutManager(Context object, AttributeSet attributeSet, int n10, int n11) {
        int n12;
        this.mOrientation = n12 = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = n12;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -1 << -1;
        this.mPendingSavedState = null;
        Object object2 = new LinearLayoutManager$AnchorInfo();
        this.mAnchorInfo = object2;
        this.mLayoutChunkResult = object2 = new LinearLayoutManager$LayoutChunkResult();
        this.mInitialPrefetchItemCount = n12 = 2;
        object2 = new int[n12];
        this.mReusableIntPair = (int[])object2;
        object = RecyclerView$LayoutManager.getProperties((Context)object, attributeSet, n10, n11);
        int bl2 = ((RecyclerView$LayoutManager$Properties)object).orientation;
        this.setOrientation(bl2);
        boolean bl3 = ((RecyclerView$LayoutManager$Properties)object).reverseLayout;
        this.setReverseLayout(bl3);
        boolean bl4 = ((RecyclerView$LayoutManager$Properties)object).stackFromEnd;
        this.setStackFromEnd(bl4);
    }

    private int computeScrollExtent(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        if (!n10) {
            return 0;
        }
        this.ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        n10 = (int)(this.mSmoothScrollbarEnabled ? 1 : 0);
        boolean bl2 = true;
        View view = this.findFirstVisibleChildClosestToStart((n10 ^= bl2) != 0, bl2);
        n10 = this.mSmoothScrollbarEnabled ^ bl2;
        Object object = this.findFirstVisibleChildClosestToEnd(n10 != 0, bl2);
        boolean bl3 = this.mSmoothScrollbarEnabled;
        View view2 = view;
        view = object;
        object = this;
        return ScrollbarHelper.computeScrollExtent(recyclerView$State, orientationHelper, view2, view, this, bl3);
    }

    private int computeScrollOffset(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        if (!n10) {
            return 0;
        }
        this.ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        n10 = (int)(this.mSmoothScrollbarEnabled ? 1 : 0);
        boolean bl2 = true;
        View view = this.findFirstVisibleChildClosestToStart((n10 ^= bl2) != 0, bl2);
        n10 = this.mSmoothScrollbarEnabled ^ bl2;
        Object object = this.findFirstVisibleChildClosestToEnd(n10 != 0, bl2);
        boolean bl3 = this.mSmoothScrollbarEnabled;
        boolean bl4 = this.mShouldReverseLayout;
        View view2 = view;
        view = object;
        object = this;
        return ScrollbarHelper.computeScrollOffset(recyclerView$State, orientationHelper, view2, view, this, bl3, bl4);
    }

    private int computeScrollRange(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        if (!n10) {
            return 0;
        }
        this.ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        n10 = (int)(this.mSmoothScrollbarEnabled ? 1 : 0);
        boolean bl2 = true;
        View view = this.findFirstVisibleChildClosestToStart((n10 ^= bl2) != 0, bl2);
        n10 = this.mSmoothScrollbarEnabled ^ bl2;
        Object object = this.findFirstVisibleChildClosestToEnd(n10 != 0, bl2);
        boolean bl3 = this.mSmoothScrollbarEnabled;
        View view2 = view;
        view = object;
        object = this;
        return ScrollbarHelper.computeScrollRange(recyclerView$State, orientationHelper, view2, view, this, bl3);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        int n10 = this.getChildCount();
        return this.findOnePartiallyOrCompletelyInvisibleChild(0, n10);
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        int n10 = this.getChildCount() + -1;
        return this.findOnePartiallyOrCompletelyInvisibleChild(n10, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        boolean bl2 = this.mShouldReverseLayout;
        View view = bl2 ? this.findFirstPartiallyOrCompletelyInvisibleChild() : this.findLastPartiallyOrCompletelyInvisibleChild();
        return view;
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        boolean bl2 = this.mShouldReverseLayout;
        View view = bl2 ? this.findLastPartiallyOrCompletelyInvisibleChild() : this.findFirstPartiallyOrCompletelyInvisibleChild();
        return view;
    }

    private int fixLayoutEndGap(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State object, boolean bl2) {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n11 = orientationHelper.getEndAfterPadding() - n10;
        if (n11 > 0) {
            int n12;
            n11 = -n11;
            int n13 = -this.scrollBy(n11, recyclerView$Recycler, (RecyclerView$State)object);
            if (bl2 && (n12 = ((OrientationHelper)(object = this.mOrientationHelper)).getEndAfterPadding() - (n10 += n13)) > 0) {
                this.mOrientationHelper.offsetChildren(n12);
                return n12 + n13;
            }
            return n13;
        }
        return 0;
    }

    private int fixLayoutStartGap(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State object, boolean bl2) {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n11 = orientationHelper.getStartAfterPadding();
        if ((n11 = n10 - n11) > 0) {
            int n12;
            int n13 = -this.scrollBy(n11, recyclerView$Recycler, (RecyclerView$State)object);
            n10 += n13;
            if (bl2 && (n10 -= (n12 = ((OrientationHelper)(object = this.mOrientationHelper)).getStartAfterPadding())) > 0) {
                object = this.mOrientationHelper;
                int n14 = -n10;
                ((OrientationHelper)object).offsetChildren(n14);
                n13 -= n10;
            }
            return n13;
        }
        return 0;
    }

    private View getChildClosestToEnd() {
        int n10 = this.mShouldReverseLayout;
        n10 = n10 != 0 ? 0 : this.getChildCount() + -1;
        return this.getChildAt(n10);
    }

    private View getChildClosestToStart() {
        int n10 = this.mShouldReverseLayout;
        n10 = n10 != 0 ? this.getChildCount() + -1 : 0;
        return this.getChildAt(n10);
    }

    private void layoutForPredictiveAnimations(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int n10, int n11) {
        LinearLayoutManager linearLayoutManager = this;
        Object object = recyclerView$Recycler;
        RecyclerView$State recyclerView$State2 = recyclerView$State;
        int n12 = recyclerView$State.willRunPredictiveAnimations();
        if (n12 != 0 && (n12 = this.getChildCount()) != 0 && (n12 = (int)(recyclerView$State.isPreLayout() ? 1 : 0)) == 0 && (n12 = (int)(this.supportsPredictiveItemAnimations() ? 1 : 0)) != 0) {
            Object object2 = recyclerView$Recycler.getScrapList();
            int n13 = object2.size();
            View view = this.getChildAt(0);
            int n14 = this.getPosition(view);
            int n15 = 0;
            int n16 = 0;
            for (int i10 = 0; i10 < n13; ++i10) {
                int n17;
                OrientationHelper orientationHelper;
                RecyclerView$ViewHolder recyclerView$ViewHolder = (RecyclerView$ViewHolder)object2.get(i10);
                int n18 = recyclerView$ViewHolder.isRemoved();
                if (n18 != 0) continue;
                n18 = recyclerView$ViewHolder.getLayoutPosition();
                int n19 = 1;
                if (n18 < n14) {
                    n18 = n19;
                } else {
                    n18 = 0;
                    orientationHelper = null;
                }
                int n20 = linearLayoutManager.mShouldReverseLayout;
                int n21 = -1;
                float f10 = 0.0f / 0.0f;
                if (n18 != n20) {
                    n19 = n21;
                }
                if (n19 == n21) {
                    orientationHelper = linearLayoutManager.mOrientationHelper;
                    recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
                    n17 = orientationHelper.getDecoratedMeasurement((View)recyclerView$ViewHolder);
                    n15 += n17;
                    continue;
                }
                orientationHelper = linearLayoutManager.mOrientationHelper;
                recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
                n17 = orientationHelper.getDecoratedMeasurement((View)recyclerView$ViewHolder);
                n16 += n17;
            }
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = linearLayoutManager.mLayoutState;
            linearLayoutManager$LayoutState.mScrapList = object2;
            if (n15 > 0) {
                object2 = this.getChildClosestToStart();
                n12 = this.getPosition((View)object2);
                n13 = n10;
                this.updateLayoutStateToFillStart(n12, n10);
                object2 = linearLayoutManager.mLayoutState;
                ((LinearLayoutManager$LayoutState)object2).mExtraFillSpace = n15;
                ((LinearLayoutManager$LayoutState)object2).mAvailable = 0;
                ((LinearLayoutManager$LayoutState)object2).assignPositionFromScrapList();
                object2 = linearLayoutManager.mLayoutState;
                this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object2, recyclerView$State2, false);
            }
            if (n16 > 0) {
                object2 = this.getChildClosestToEnd();
                n12 = this.getPosition((View)object2);
                n13 = n11;
                this.updateLayoutStateToFillEnd(n12, n11);
                object2 = linearLayoutManager.mLayoutState;
                ((LinearLayoutManager$LayoutState)object2).mExtraFillSpace = n16;
                ((LinearLayoutManager$LayoutState)object2).mAvailable = 0;
                ((LinearLayoutManager$LayoutState)object2).assignPositionFromScrapList();
                object2 = linearLayoutManager.mLayoutState;
                this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object2, recyclerView$State2, false);
            }
            object = linearLayoutManager.mLayoutState;
            recyclerView$State2 = null;
            ((LinearLayoutManager$LayoutState)object).mScrapList = null;
        }
    }

    private void logChildren() {
        int n10;
        String string2 = TAG;
        Log.d((String)string2, (String)"internal representation of views on the screen");
        for (int i10 = 0; i10 < (n10 = this.getChildCount()); ++i10) {
            Object object = this.getChildAt(i10);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("item ");
            int n11 = this.getPosition((View)object);
            stringBuilder.append(n11);
            stringBuilder.append(", coord:");
            OrientationHelper orientationHelper = this.mOrientationHelper;
            n10 = orientationHelper.getDecoratedStart((View)object);
            stringBuilder.append(n10);
            object = stringBuilder.toString();
            Log.d((String)string2, (String)object);
        }
        Log.d((String)string2, (String)"==============");
    }

    private void recycleByLayoutState(RecyclerView$Recycler recyclerView$Recycler, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState) {
        int n10 = linearLayoutManager$LayoutState.mRecycle;
        if (n10 != 0 && (n10 = linearLayoutManager$LayoutState.mInfinite) == 0) {
            n10 = linearLayoutManager$LayoutState.mScrollingOffset;
            int n11 = linearLayoutManager$LayoutState.mNoRecycleSpace;
            int n12 = linearLayoutManager$LayoutState.mLayoutDirection;
            int n13 = -1;
            if (n12 == n13) {
                this.recycleViewsFromEnd(recyclerView$Recycler, n10, n11);
            } else {
                this.recycleViewsFromStart(recyclerView$Recycler, n10, n11);
            }
        }
    }

    private void recycleChildren(RecyclerView$Recycler recyclerView$Recycler, int n10, int n11) {
        if (n10 == n11) {
            return;
        }
        if (n11 > n10) {
            n11 += -1;
            while (n11 >= n10) {
                this.removeAndRecycleViewAt(n11, recyclerView$Recycler);
                n11 += -1;
            }
        } else {
            while (n10 > n11) {
                this.removeAndRecycleViewAt(n10, recyclerView$Recycler);
                n10 += -1;
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView$Recycler recyclerView$Recycler, int n10, int n11) {
        int n12 = this.getChildCount();
        if (n10 < 0) {
            return;
        }
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n13 = orientationHelper.getEnd() - n10 + n11;
        n10 = (int)(this.mShouldReverseLayout ? 1 : 0);
        if (n10 != 0) {
            n10 = 0;
            Object var7_7 = null;
            for (n11 = 0; n11 < n12; ++n11) {
                int n14;
                OrientationHelper orientationHelper2 = this.mOrientationHelper;
                View view = this.getChildAt(n11);
                int n15 = orientationHelper2.getDecoratedStart(view);
                if (n15 >= n13 && (n14 = (orientationHelper2 = this.mOrientationHelper).getTransformedStartWithDecoration(view)) >= n13) {
                    continue;
                }
                this.recycleChildren(recyclerView$Recycler, 0, n11);
                return;
            }
        } else {
            for (n10 = n12 += -1; n10 >= 0; n10 += -1) {
                OrientationHelper orientationHelper3 = this.mOrientationHelper;
                View view = this.getChildAt(n10);
                int n16 = orientationHelper3.getDecoratedStart(view);
                if (n16 >= n13 && (n11 = (orientationHelper3 = this.mOrientationHelper).getTransformedStartWithDecoration(view)) >= n13) {
                    continue;
                }
                this.recycleChildren(recyclerView$Recycler, n12, n10);
                break;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView$Recycler recyclerView$Recycler, int n10, int n11) {
        if (n10 < 0) {
            return;
        }
        n10 -= n11;
        n11 = this.getChildCount();
        int n12 = this.mShouldReverseLayout;
        if (n12 != 0) {
            for (n12 = n11 += -1; n12 >= 0; n12 += -1) {
                int n13;
                OrientationHelper orientationHelper = this.mOrientationHelper;
                View view = this.getChildAt(n12);
                int n14 = orientationHelper.getDecoratedEnd(view);
                if (n14 <= n10 && (n13 = (orientationHelper = this.mOrientationHelper).getTransformedEndWithDecoration(view)) <= n10) {
                    continue;
                }
                this.recycleChildren(recyclerView$Recycler, n11, n12);
                return;
            }
        } else {
            n12 = 0;
            Object var5_6 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                int n15;
                OrientationHelper orientationHelper = this.mOrientationHelper;
                View view = this.getChildAt(i10);
                int n16 = orientationHelper.getDecoratedEnd(view);
                if (n16 <= n10 && (n15 = (orientationHelper = this.mOrientationHelper).getTransformedEndWithDecoration(view)) <= n10) {
                    continue;
                }
                this.recycleChildren(recyclerView$Recycler, 0, i10);
                break;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        int n10 = this.mOrientation;
        int n11 = 1;
        if (n10 != n11 && (n10 = (int)(this.isLayoutRTL() ? 1 : 0)) != 0) {
            n10 = this.mReverseLayout ^ n11;
            this.mShouldReverseLayout = n10;
        } else {
            n10 = (int)(this.mReverseLayout ? 1 : 0);
            this.mShouldReverseLayout = n10;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State object, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        int n10;
        int n11 = this.getChildCount();
        boolean bl2 = false;
        if (n11 == 0) {
            return false;
        }
        Object object2 = this.getFocusedChild();
        boolean bl3 = true;
        if (object2 != null && (n10 = linearLayoutManager$AnchorInfo.isViewValidAsAnchor((View)object2, (RecyclerView$State)object)) != 0) {
            int n12 = this.getPosition((View)object2);
            linearLayoutManager$AnchorInfo.assignFromViewAndKeepVisibleRect((View)object2, n12);
            return bl3;
        }
        n11 = (int)(this.mLastStackFromEnd ? 1 : 0);
        n10 = this.mStackFromEnd;
        if (n11 != n10) {
            return false;
        }
        n11 = (int)(linearLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0);
        if ((recyclerView$Recycler = this.findReferenceChild(recyclerView$Recycler, (RecyclerView$State)object, n11 != 0, n10 != 0)) != null) {
            boolean bl4;
            n11 = this.getPosition((View)recyclerView$Recycler);
            linearLayoutManager$AnchorInfo.assignFromView((View)recyclerView$Recycler, n11);
            boolean n13 = ((RecyclerView$State)object).isPreLayout();
            if (!n13 && (bl4 = this.supportsPredictiveItemAnimations())) {
                object = this.mOrientationHelper;
                int n12 = ((OrientationHelper)object).getDecoratedStart((View)recyclerView$Recycler);
                int n14 = this.mOrientationHelper.getDecoratedEnd((View)recyclerView$Recycler);
                object2 = this.mOrientationHelper;
                n11 = ((OrientationHelper)object2).getStartAfterPadding();
                OrientationHelper orientationHelper = this.mOrientationHelper;
                n10 = orientationHelper.getEndAfterPadding();
                boolean bl5 = n14 <= n11 && n12 < n11 ? bl3 : false;
                if (n12 >= n10 && n14 > n10) {
                    bl2 = bl3;
                }
                if (bl5 || bl2) {
                    n14 = (int)(linearLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0);
                    if (n14 != 0) {
                        n11 = n10;
                    }
                    linearLayoutManager$AnchorInfo.mCoordinate = n11;
                }
            }
            return bl3;
        }
        return false;
    }

    private boolean updateAnchorFromPendingData(RecyclerView$State object, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        int n10;
        int n11;
        boolean n112 = ((RecyclerView$State)object).isPreLayout();
        int n12 = 0;
        Object object2 = null;
        if (!n112 && (n11 = this.mPendingScrollPosition) != (n10 = -1)) {
            int n13;
            int n14 = -1 << -1;
            if (n11 >= 0 && n11 < (n13 = ((RecyclerView$State)object).getItemCount())) {
                linearLayoutManager$AnchorInfo.mPosition = n13 = this.mPendingScrollPosition;
                object = this.mPendingSavedState;
                int n15 = 1;
                if (object != null && (n13 = (int)(((LinearLayoutManager$SavedState)object).hasValidAnchor() ? 1 : 0)) != 0) {
                    object = this.mPendingSavedState;
                    n13 = (int)(((LinearLayoutManager$SavedState)object).mAnchorLayoutFromEnd ? 1 : 0);
                    linearLayoutManager$AnchorInfo.mLayoutFromEnd = n13;
                    if (n13 != 0) {
                        object = this.mOrientationHelper;
                        n13 = ((OrientationHelper)object).getEndAfterPadding();
                        object2 = this.mPendingSavedState;
                        n12 = ((LinearLayoutManager$SavedState)object2).mAnchorOffset;
                        linearLayoutManager$AnchorInfo.mCoordinate = n13 -= n12;
                    } else {
                        object = this.mOrientationHelper;
                        n13 = ((OrientationHelper)object).getStartAfterPadding();
                        object2 = this.mPendingSavedState;
                        n12 = ((LinearLayoutManager$SavedState)object2).mAnchorOffset;
                        linearLayoutManager$AnchorInfo.mCoordinate = n13 += n12;
                    }
                    return n15 != 0;
                }
                n13 = this.mPendingScrollPositionOffset;
                if (n13 == n14) {
                    n13 = this.mPendingScrollPosition;
                    object = this.findViewByPosition(n13);
                    if (object != null) {
                        OrientationHelper orientationHelper;
                        OrientationHelper orientationHelper2 = this.mOrientationHelper;
                        n10 = orientationHelper2.getDecoratedMeasurement((View)object);
                        if (n10 > (n14 = (orientationHelper = this.mOrientationHelper).getTotalSpace())) {
                            linearLayoutManager$AnchorInfo.assignCoordinateFromPadding();
                            return n15 != 0;
                        }
                        orientationHelper2 = this.mOrientationHelper;
                        n10 = orientationHelper2.getDecoratedStart((View)object);
                        orientationHelper = this.mOrientationHelper;
                        n14 = orientationHelper.getStartAfterPadding();
                        if ((n10 -= n14) < 0) {
                            linearLayoutManager$AnchorInfo.mCoordinate = n13 = this.mOrientationHelper.getStartAfterPadding();
                            linearLayoutManager$AnchorInfo.mLayoutFromEnd = false;
                            return n15 != 0;
                        }
                        object2 = this.mOrientationHelper;
                        n12 = ((OrientationHelper)object2).getEndAfterPadding();
                        orientationHelper2 = this.mOrientationHelper;
                        n10 = orientationHelper2.getDecoratedEnd((View)object);
                        if ((n12 -= n10) < 0) {
                            linearLayoutManager$AnchorInfo.mCoordinate = n13 = this.mOrientationHelper.getEndAfterPadding();
                            linearLayoutManager$AnchorInfo.mLayoutFromEnd = n15;
                            return n15 != 0;
                        }
                        n12 = (int)(linearLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0);
                        if (n12 != 0) {
                            n13 = this.mOrientationHelper.getDecoratedEnd((View)object);
                            object2 = this.mOrientationHelper;
                            n12 = ((OrientationHelper)object2).getTotalSpaceChange();
                            n13 += n12;
                        } else {
                            object2 = this.mOrientationHelper;
                            n13 = ((OrientationHelper)object2).getDecoratedStart((View)object);
                        }
                        linearLayoutManager$AnchorInfo.mCoordinate = n13;
                    } else {
                        n13 = this.getChildCount();
                        if (n13 > 0) {
                            n10 = this.mPendingScrollPosition;
                            object = this.getChildAt(0);
                            n13 = this.getPosition((View)object);
                            if (n10 < n13) {
                                n13 = n15;
                            } else {
                                n13 = 0;
                                object = null;
                            }
                            n10 = (int)(this.mShouldReverseLayout ? 1 : 0);
                            if (n13 == n10) {
                                n12 = n15;
                            }
                            linearLayoutManager$AnchorInfo.mLayoutFromEnd = n12;
                        }
                        linearLayoutManager$AnchorInfo.assignCoordinateFromPadding();
                    }
                    return n15 != 0;
                }
                n13 = (int)(this.mShouldReverseLayout ? 1 : 0);
                linearLayoutManager$AnchorInfo.mLayoutFromEnd = n13;
                if (n13 != 0) {
                    object = this.mOrientationHelper;
                    n13 = ((OrientationHelper)object).getEndAfterPadding();
                    n12 = this.mPendingScrollPositionOffset;
                    linearLayoutManager$AnchorInfo.mCoordinate = n13 -= n12;
                } else {
                    object = this.mOrientationHelper;
                    n13 = ((OrientationHelper)object).getStartAfterPadding();
                    n12 = this.mPendingScrollPositionOffset;
                    linearLayoutManager$AnchorInfo.mCoordinate = n13 += n12;
                }
                return n15 != 0;
            }
            this.mPendingScrollPosition = n10;
            this.mPendingScrollPositionOffset = n14;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        boolean bl2 = this.updateAnchorFromPendingData(recyclerView$State, linearLayoutManager$AnchorInfo);
        if (bl2) {
            return;
        }
        int n10 = this.updateAnchorFromChildren(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo);
        if (n10 != 0) {
            return;
        }
        linearLayoutManager$AnchorInfo.assignCoordinateFromPadding();
        n10 = this.mStackFromEnd;
        if (n10 != 0) {
            n10 = recyclerView$State.getItemCount() + -1;
        } else {
            n10 = 0;
            recyclerView$Recycler = null;
        }
        linearLayoutManager$AnchorInfo.mPosition = n10;
    }

    private void updateLayoutState(int n10, int n11, boolean bl2, RecyclerView$State object) {
        int n12;
        Object object2 = this.mLayoutState;
        ((LinearLayoutManager$LayoutState)object2).mInfinite = n12 = this.resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = n10;
        object2 = this.mReusableIntPair;
        n12 = 0;
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = null;
        object2[0] = false;
        Object object3 = 1;
        object2[object3] = false;
        this.calculateExtraLayoutSpace((RecyclerView$State)object, (int[])object2);
        object = this.mReusableIntPair;
        Object object4 = object[0];
        object4 = Math.max(0, (int)object4);
        object2 = this.mReusableIntPair;
        Object object5 = object2[object3];
        object5 = Math.max(0, (int)object5);
        if (n10 == object3) {
            n12 = object3;
        }
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState2 = this.mLayoutState;
        Object object6 = n12 != 0 ? object5 : object4;
        linearLayoutManager$LayoutState2.mExtraFillSpace = (int)object6;
        if (n12 == 0) {
            object4 = object5;
        }
        linearLayoutManager$LayoutState2.mNoRecycleSpace = (int)object4;
        object4 = -1;
        float f10 = 0.0f / 0.0f;
        if (n12 != 0) {
            object5 = this.mOrientationHelper.getEndPadding();
            linearLayoutManager$LayoutState2.mExtraFillSpace = (int)(object6 += object5);
            linearLayoutManager$LayoutState2 = this.getChildClosestToEnd();
            object2 = this.mLayoutState;
            n12 = (int)(this.mShouldReverseLayout ? 1 : 0);
            if (n12 != 0) {
                object3 = object4;
            }
            ((LinearLayoutManager$LayoutState)object2).mItemDirection = object3;
            object4 = this.getPosition((View)linearLayoutManager$LayoutState2);
            linearLayoutManager$LayoutState = this.mLayoutState;
            object3 = linearLayoutManager$LayoutState.mItemDirection;
            ((LinearLayoutManager$LayoutState)object2).mCurrentPosition = (int)(object4 += object3);
            object4 = this.mOrientationHelper.getDecoratedEnd((View)linearLayoutManager$LayoutState2);
            linearLayoutManager$LayoutState.mOffset = (int)object4;
            n10 = this.mOrientationHelper.getDecoratedEnd((View)linearLayoutManager$LayoutState2);
            object = this.mOrientationHelper;
            object4 = ((OrientationHelper)object).getEndAfterPadding();
            n10 -= object4;
        } else {
            linearLayoutManager$LayoutState2 = this.getChildClosestToStart();
            object2 = this.mLayoutState;
            n12 = ((LinearLayoutManager$LayoutState)object2).mExtraFillSpace;
            OrientationHelper orientationHelper = this.mOrientationHelper;
            object6 = orientationHelper.getStartAfterPadding();
            ((LinearLayoutManager$LayoutState)object2).mExtraFillSpace = n12 += object6;
            object2 = this.mLayoutState;
            n12 = (int)(this.mShouldReverseLayout ? 1 : 0);
            if (n12 == 0) {
                object3 = object4;
            }
            ((LinearLayoutManager$LayoutState)object2).mItemDirection = object3;
            object4 = this.getPosition((View)linearLayoutManager$LayoutState2);
            linearLayoutManager$LayoutState = this.mLayoutState;
            object3 = linearLayoutManager$LayoutState.mItemDirection;
            ((LinearLayoutManager$LayoutState)object2).mCurrentPosition = (int)(object4 += object3);
            object4 = this.mOrientationHelper.getDecoratedStart((View)linearLayoutManager$LayoutState2);
            linearLayoutManager$LayoutState.mOffset = (int)object4;
            n10 = -this.mOrientationHelper.getDecoratedStart((View)linearLayoutManager$LayoutState2);
            object = this.mOrientationHelper;
            object4 = ((OrientationHelper)object).getStartAfterPadding();
            n10 += object4;
        }
        object = this.mLayoutState;
        ((LinearLayoutManager$LayoutState)object).mAvailable = n11;
        if (bl2) {
            ((LinearLayoutManager$LayoutState)object).mAvailable = n11 -= n10;
        }
        ((LinearLayoutManager$LayoutState)object).mScrollingOffset = n10;
    }

    private void updateLayoutStateToFillEnd(int n10, int n11) {
        int n12;
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        OrientationHelper orientationHelper = this.mOrientationHelper;
        linearLayoutManager$LayoutState.mAvailable = n12 = orientationHelper.getEndAfterPadding() - n11;
        linearLayoutManager$LayoutState = this.mLayoutState;
        n12 = (int)(this.mShouldReverseLayout ? 1 : 0);
        int n13 = 1;
        n12 = n12 != 0 ? -1 : n13;
        linearLayoutManager$LayoutState.mItemDirection = n12;
        linearLayoutManager$LayoutState.mCurrentPosition = n10;
        linearLayoutManager$LayoutState.mLayoutDirection = n13;
        linearLayoutManager$LayoutState.mOffset = n11;
        linearLayoutManager$LayoutState.mScrollingOffset = -1 << -1;
    }

    private void updateLayoutStateToFillEnd(LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        int n10 = linearLayoutManager$AnchorInfo.mPosition;
        int n11 = linearLayoutManager$AnchorInfo.mCoordinate;
        this.updateLayoutStateToFillEnd(n10, n11);
    }

    private void updateLayoutStateToFillStart(int n10, int n11) {
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n12 = orientationHelper.getStartAfterPadding();
        linearLayoutManager$LayoutState.mAvailable = n12 = n11 - n12;
        linearLayoutManager$LayoutState = this.mLayoutState;
        linearLayoutManager$LayoutState.mCurrentPosition = n10;
        n10 = (int)(this.mShouldReverseLayout ? 1 : 0);
        n12 = -1;
        n10 = n10 != 0 ? 1 : n12;
        linearLayoutManager$LayoutState.mItemDirection = n10;
        linearLayoutManager$LayoutState.mLayoutDirection = n12;
        linearLayoutManager$LayoutState.mOffset = n11;
        linearLayoutManager$LayoutState.mScrollingOffset = -1 << -1;
    }

    private void updateLayoutStateToFillStart(LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        int n10 = linearLayoutManager$AnchorInfo.mPosition;
        int n11 = linearLayoutManager$AnchorInfo.mCoordinate;
        this.updateLayoutStateToFillStart(n10, n11);
    }

    public void assertNotInLayoutOrScroll(String string2) {
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState == null) {
            super.assertNotInLayoutOrScroll(string2);
        }
    }

    public void calculateExtraLayoutSpace(RecyclerView$State recyclerView$State, int[] nArray) {
        int n10 = this.getExtraLayoutSpace(recyclerView$State);
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        int n11 = linearLayoutManager$LayoutState.mLayoutDirection;
        int n12 = -1;
        if (n11 == n12) {
            n11 = 0;
            linearLayoutManager$LayoutState = null;
        } else {
            n11 = n10;
            n10 = 0;
            recyclerView$State = null;
        }
        nArray[0] = n10;
        nArray[1] = n11;
    }

    public boolean canScrollHorizontally() {
        int n10 = this.mOrientation;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean canScrollVertically() {
        int n10 = this.mOrientation;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void collectAdjacentPrefetchPositions(int n10, int n11, RecyclerView$State recyclerView$State, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int n12 = this.mOrientation;
        if (n12 != 0) {
            n10 = n11;
        }
        n11 = this.getChildCount();
        if (n11 != 0 && n10 != 0) {
            this.ensureLayoutState();
            n11 = 1;
            n12 = n10 > 0 ? n11 : -1;
            n10 = Math.abs(n10);
            this.updateLayoutState(n12, n10, n11 != 0, recyclerView$State);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
            this.collectPrefetchPositionsForLayoutState(recyclerView$State, linearLayoutManager$LayoutState, recyclerView$LayoutManager$LayoutPrefetchRegistry);
        }
    }

    public void collectInitialPrefetchPositions(int n10, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int n11;
        int n12;
        int n13;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        int n14 = -1;
        if (linearLayoutManager$SavedState != null && (n13 = linearLayoutManager$SavedState.hasValidAnchor()) != 0) {
            linearLayoutManager$SavedState = this.mPendingSavedState;
            n12 = linearLayoutManager$SavedState.mAnchorLayoutFromEnd;
            n13 = linearLayoutManager$SavedState.mAnchorPosition;
        } else {
            this.resolveShouldLayoutReverse();
            n12 = this.mShouldReverseLayout;
            n13 = this.mPendingScrollPosition;
            if (n13 == n14) {
                if (n12 != 0) {
                    n13 = n10 + -1;
                } else {
                    n13 = 0;
                    linearLayoutManager$SavedState = null;
                }
            }
        }
        if (n12 == 0) {
            n14 = 1;
        }
        for (n12 = 0; n12 < (n11 = this.mInitialPrefetchItemCount) && n13 >= 0 && n13 < n10; n13 += n14, ++n12) {
            recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(n13, 0);
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int n10;
        int n11 = linearLayoutManager$LayoutState.mCurrentPosition;
        if (n11 >= 0 && n11 < (n10 = recyclerView$State.getItemCount())) {
            recyclerView$State = null;
            int n12 = linearLayoutManager$LayoutState.mScrollingOffset;
            n10 = Math.max(0, n12);
            recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(n11, n10);
        }
    }

    public int computeHorizontalScrollExtent(RecyclerView$State recyclerView$State) {
        return this.computeScrollExtent(recyclerView$State);
    }

    public int computeHorizontalScrollOffset(RecyclerView$State recyclerView$State) {
        return this.computeScrollOffset(recyclerView$State);
    }

    public int computeHorizontalScrollRange(RecyclerView$State recyclerView$State) {
        return this.computeScrollRange(recyclerView$State);
    }

    public PointF computeScrollVectorForPosition(int n10) {
        int n11 = this.getChildCount();
        if (n11 == 0) {
            return null;
        }
        n11 = 0;
        View view = this.getChildAt(0);
        int n12 = this.getPosition(view);
        int n13 = 1;
        if (n10 < n12) {
            n11 = n13;
        }
        if (n11 != (n10 = (int)(this.mShouldReverseLayout ? 1 : 0))) {
            n13 = -1;
        }
        n10 = this.mOrientation;
        n11 = 0;
        if (n10 == 0) {
            float f10 = n13;
            PointF pointF = new PointF(f10, 0.0f);
            return pointF;
        }
        float f11 = n13;
        PointF pointF = new PointF(0.0f, f11);
        return pointF;
    }

    public int computeVerticalScrollExtent(RecyclerView$State recyclerView$State) {
        return this.computeScrollExtent(recyclerView$State);
    }

    public int computeVerticalScrollOffset(RecyclerView$State recyclerView$State) {
        return this.computeScrollOffset(recyclerView$State);
    }

    public int computeVerticalScrollRange(RecyclerView$State recyclerView$State) {
        return this.computeScrollRange(recyclerView$State);
    }

    public int convertFocusDirectionToLayoutDirection(int n10) {
        int n11 = -1;
        int n12 = 1;
        if (n10 != n12) {
            int n13 = 2;
            if (n10 != n13) {
                n13 = 17;
                int n14 = -1 << -1;
                if (n10 != n13) {
                    n13 = 33;
                    if (n10 != n13) {
                        n11 = 66;
                        if (n10 != n11) {
                            n11 = 130;
                            if (n10 != n11) {
                                return n14;
                            }
                            n10 = this.mOrientation;
                            if (n10 != n12) {
                                n12 = n14;
                            }
                            return n12;
                        }
                        n10 = this.mOrientation;
                        if (n10 != 0) {
                            n12 = n14;
                        }
                        return n12;
                    }
                    n10 = this.mOrientation;
                    if (n10 != n12) {
                        n11 = n14;
                    }
                    return n11;
                }
                n10 = this.mOrientation;
                if (n10 != 0) {
                    n11 = n14;
                }
                return n11;
            }
            n10 = this.mOrientation;
            if (n10 == n12) {
                return n12;
            }
            n10 = (int)(this.isLayoutRTL() ? 1 : 0);
            if (n10 != 0) {
                return n11;
            }
            return n12;
        }
        n10 = this.mOrientation;
        if (n10 == n12) {
            return n11;
        }
        n10 = (int)(this.isLayoutRTL() ? 1 : 0);
        if (n10 != 0) {
            return n12;
        }
        return n11;
    }

    public LinearLayoutManager$LayoutState createLayoutState() {
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = new LinearLayoutManager$LayoutState();
        return linearLayoutManager$LayoutState;
    }

    public void ensureLayoutState() {
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        if (linearLayoutManager$LayoutState == null) {
            this.mLayoutState = linearLayoutManager$LayoutState = this.createLayoutState();
        }
    }

    public int fill(RecyclerView$Recycler recyclerView$Recycler, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, RecyclerView$State recyclerView$State, boolean bl2) {
        int n10;
        int n11 = linearLayoutManager$LayoutState.mAvailable;
        int n12 = linearLayoutManager$LayoutState.mScrollingOffset;
        int n13 = -1 << -1;
        if (n12 != n13) {
            if (n11 < 0) {
                linearLayoutManager$LayoutState.mScrollingOffset = n12 += n11;
            }
            this.recycleByLayoutState(recyclerView$Recycler, linearLayoutManager$LayoutState);
        }
        n12 = linearLayoutManager$LayoutState.mAvailable;
        int n14 = linearLayoutManager$LayoutState.mExtraFillSpace;
        n12 += n14;
        LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult = this.mLayoutChunkResult;
        while (((n10 = linearLayoutManager$LayoutState.mInfinite) != 0 || n12 > 0) && (n10 = linearLayoutManager$LayoutState.hasMore(recyclerView$State)) != 0) {
            List list;
            linearLayoutManager$LayoutChunkResult.resetInternal();
            this.layoutChunk(recyclerView$Recycler, recyclerView$State, linearLayoutManager$LayoutState, linearLayoutManager$LayoutChunkResult);
            n10 = linearLayoutManager$LayoutChunkResult.mFinished;
            if (n10 != 0) break;
            n10 = linearLayoutManager$LayoutState.mOffset;
            int n15 = linearLayoutManager$LayoutChunkResult.mConsumed;
            int n16 = linearLayoutManager$LayoutState.mLayoutDirection;
            linearLayoutManager$LayoutState.mOffset = n10 += (n15 *= n16);
            n10 = (int)(linearLayoutManager$LayoutChunkResult.mIgnoreConsumed ? 1 : 0);
            if (n10 == 0 || (list = linearLayoutManager$LayoutState.mScrapList) != null || (n10 = (int)(recyclerView$State.isPreLayout() ? 1 : 0)) == 0) {
                n10 = linearLayoutManager$LayoutState.mAvailable;
                n15 = linearLayoutManager$LayoutChunkResult.mConsumed;
                linearLayoutManager$LayoutState.mAvailable = n10 -= n15;
                n12 -= n15;
            }
            if ((n10 = linearLayoutManager$LayoutState.mScrollingOffset) != n13) {
                n15 = linearLayoutManager$LayoutChunkResult.mConsumed;
                linearLayoutManager$LayoutState.mScrollingOffset = n10 += n15;
                n15 = linearLayoutManager$LayoutState.mAvailable;
                if (n15 < 0) {
                    linearLayoutManager$LayoutState.mScrollingOffset = n10 += n15;
                }
                this.recycleByLayoutState(recyclerView$Recycler, linearLayoutManager$LayoutState);
            }
            if (!bl2 || (n10 = (int)(linearLayoutManager$LayoutChunkResult.mFocusable ? 1 : 0)) == 0) continue;
        }
        int n17 = linearLayoutManager$LayoutState.mAvailable;
        return n11 - n17;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        boolean bl2;
        int n10 = this.getChildCount();
        View view = this.findOneVisibleChild(0, n10, bl2 = true, false);
        n10 = view == null ? -1 : this.getPosition(view);
        return n10;
    }

    public View findFirstVisibleChildClosestToEnd(boolean bl2, boolean bl3) {
        int n10 = this.mShouldReverseLayout;
        if (n10 != 0) {
            int n11 = this.getChildCount();
            return this.findOneVisibleChild(0, n11, bl2, bl3);
        }
        n10 = this.getChildCount() + -1;
        return this.findOneVisibleChild(n10, -1, bl2, bl3);
    }

    public View findFirstVisibleChildClosestToStart(boolean bl2, boolean bl3) {
        int n10 = this.mShouldReverseLayout;
        if (n10 != 0) {
            n10 = this.getChildCount() + -1;
            return this.findOneVisibleChild(n10, -1, bl2, bl3);
        }
        int n11 = this.getChildCount();
        return this.findOneVisibleChild(0, n11, bl2, bl3);
    }

    public int findFirstVisibleItemPosition() {
        boolean bl2;
        int n10 = this.getChildCount();
        View view = this.findOneVisibleChild(0, n10, false, bl2 = true);
        n10 = view == null ? -1 : this.getPosition(view);
        return n10;
    }

    public int findLastCompletelyVisibleItemPosition() {
        int n10 = this.getChildCount();
        int n11 = 1;
        int n12 = -1;
        View view = this.findOneVisibleChild(n10 -= n11, n12, n11 != 0, false);
        if (view != null) {
            n12 = this.getPosition(view);
        }
        return n12;
    }

    public int findLastVisibleItemPosition() {
        int n10 = this.getChildCount();
        int n11 = 1;
        int n12 = -1;
        View view = this.findOneVisibleChild(n10 -= n11, n12, false, n11 != 0);
        if (view != null) {
            n12 = this.getPosition(view);
        }
        return n12;
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int n10, int n11) {
        View view;
        int n12;
        OrientationHelper orientationHelper;
        int n13;
        this.ensureLayoutState();
        if (n11 > n10) {
            n13 = 1;
        } else if (n11 < n10) {
            n13 = -1;
        } else {
            n13 = 0;
            orientationHelper = null;
        }
        if (n13 == 0) {
            return this.getChildAt(n10);
        }
        orientationHelper = this.mOrientationHelper;
        Object object = this.getChildAt(n10);
        n13 = orientationHelper.getDecoratedStart((View)object);
        if (n13 < (n12 = ((OrientationHelper)(object = this.mOrientationHelper)).getStartAfterPadding())) {
            n13 = 16644;
            n12 = 16388;
        } else {
            n13 = 4161;
            n12 = 4097;
        }
        int n14 = this.mOrientation;
        if (n14 == 0) {
            ViewBoundsCheck viewBoundsCheck = this.mHorizontalBoundCheck;
            view = viewBoundsCheck.findOneViewWithinBoundFlags(n10, n11, n13, n12);
        } else {
            ViewBoundsCheck viewBoundsCheck = this.mVerticalBoundCheck;
            view = viewBoundsCheck.findOneViewWithinBoundFlags(n10, n11, n13, n12);
        }
        return view;
    }

    /*
     * WARNING - void declaration
     */
    public View findOneVisibleChild(int n10, int n11, boolean bl2, boolean bl3) {
        View view;
        void var3_6;
        void var4_7;
        this.ensureLayoutState();
        int n12 = 320;
        if (bl2) {
            int n13 = 24579;
        } else {
            int n14 = n12;
        }
        if (var4_7 == false) {
            n12 = 0;
        }
        int n15 = this.mOrientation;
        if (n15 == 0) {
            ViewBoundsCheck viewBoundsCheck = this.mHorizontalBoundCheck;
            view = viewBoundsCheck.findOneViewWithinBoundFlags(n10, n11, (int)var3_6, n12);
        } else {
            ViewBoundsCheck viewBoundsCheck = this.mVerticalBoundCheck;
            view = viewBoundsCheck.findOneViewWithinBoundFlags(n10, n11, (int)var3_6, n12);
        }
        return view;
    }

    public View findReferenceChild(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean bl2, boolean bl3) {
        int n10;
        LinearLayoutManager linearLayoutManager = this;
        this.ensureLayoutState();
        int n11 = this.getChildCount();
        int n12 = -1;
        int n13 = 1;
        if (bl3) {
            n11 = this.getChildCount() - n13;
            n10 = n12;
        } else {
            n12 = n11;
            n11 = 0;
            n10 = n13;
        }
        int n14 = recyclerView$State.getItemCount();
        OrientationHelper orientationHelper = linearLayoutManager.mOrientationHelper;
        int n15 = orientationHelper.getStartAfterPadding();
        OrientationHelper orientationHelper2 = linearLayoutManager.mOrientationHelper;
        int n16 = orientationHelper2.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (n11 != n12) {
            block14: {
                View view4;
                block18: {
                    block19: {
                        block17: {
                            int n17;
                            block16: {
                                RecyclerView$LayoutParams recyclerView$LayoutParams;
                                int n18;
                                int n19;
                                OrientationHelper orientationHelper3;
                                block15: {
                                    view4 = linearLayoutManager.getChildAt(n11);
                                    n17 = linearLayoutManager.getPosition(view4);
                                    orientationHelper3 = linearLayoutManager.mOrientationHelper;
                                    n19 = orientationHelper3.getDecoratedStart(view4);
                                    OrientationHelper orientationHelper4 = linearLayoutManager.mOrientationHelper;
                                    n18 = orientationHelper4.getDecoratedEnd(view4);
                                    if (n17 < 0 || n17 >= n14) break block14;
                                    recyclerView$LayoutParams = (RecyclerView$LayoutParams)view4.getLayoutParams();
                                    n17 = (int)(recyclerView$LayoutParams.isItemRemoved() ? 1 : 0);
                                    if (n17 == 0) break block15;
                                    if (view3 == null) {
                                        view3 = view4;
                                    }
                                    break block14;
                                }
                                if (n18 <= n15 && n19 < n15) {
                                    n17 = n13;
                                } else {
                                    n17 = 0;
                                    recyclerView$LayoutParams = null;
                                }
                                if (n19 >= n16 && n18 > n16) {
                                    n19 = n13;
                                } else {
                                    n19 = 0;
                                    orientationHelper3 = null;
                                }
                                if (n17 == 0 && n19 == 0) {
                                    return view4;
                                }
                                if (!bl2) break block16;
                                if (n19 != 0) break block17;
                                if (view != null) break block14;
                                break block18;
                            }
                            if (n17 == 0) break block19;
                        }
                        view2 = view4;
                        break block14;
                    }
                    if (view != null) break block14;
                }
                view = view4;
            }
            n11 += n10;
        }
        if (view == null) {
            view = view2 != null ? view2 : view3;
        }
        return view;
    }

    public View findViewByPosition(int n10) {
        View view;
        int n11 = this.getChildCount();
        if (n11 == 0) {
            return null;
        }
        View view2 = this.getChildAt(0);
        int n12 = this.getPosition(view2);
        if ((n12 = n10 - n12) >= 0 && n12 < n11 && (n12 = this.getPosition(view = this.getChildAt(n12))) == n10) {
            return view;
        }
        return super.findViewByPosition(n10);
    }

    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        int n10 = -2;
        RecyclerView$LayoutParams recyclerView$LayoutParams = new RecyclerView$LayoutParams(n10, n10);
        return recyclerView$LayoutParams;
    }

    public int getExtraLayoutSpace(RecyclerView$State recyclerView$State) {
        boolean bl2 = recyclerView$State.hasTargetScrollPosition();
        if (bl2) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        int n10;
        int n11 = this.getLayoutDirection();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult) {
        boolean bl2;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        Object object;
        recyclerView$Recycler = linearLayoutManager$LayoutState.next(recyclerView$Recycler);
        int n15 = 1;
        if (recyclerView$Recycler == null) {
            linearLayoutManager$LayoutChunkResult.mFinished = n15;
            return;
        }
        Object object2 = object = recyclerView$Recycler.getLayoutParams();
        object2 = (RecyclerView$LayoutParams)((Object)object);
        object = linearLayoutManager$LayoutState.mScrapList;
        int n16 = -1;
        int n17 = 0;
        OrientationHelper orientationHelper = null;
        if (object == null) {
            n14 = this.mShouldReverseLayout;
            n13 = linearLayoutManager$LayoutState.mLayoutDirection;
            n13 = n13 == n16 ? (int)n15 : 0;
            if (n14 == n13) {
                this.addView((View)recyclerView$Recycler);
            } else {
                this.addView((View)recyclerView$Recycler, 0);
            }
        } else {
            n14 = this.mShouldReverseLayout;
            n13 = linearLayoutManager$LayoutState.mLayoutDirection;
            n13 = n13 == n16 ? (int)n15 : 0;
            if (n14 == n13) {
                this.addDisappearingView((View)recyclerView$Recycler);
            } else {
                this.addDisappearingView((View)recyclerView$Recycler, 0);
            }
        }
        this.measureChildWithMargins((View)recyclerView$Recycler, 0, 0);
        object = this.mOrientationHelper;
        linearLayoutManager$LayoutChunkResult.mConsumed = n14 = ((OrientationHelper)object).getDecoratedMeasurement((View)recyclerView$Recycler);
        n14 = this.mOrientation;
        if (n14 == n15) {
            n14 = (int)(this.isLayoutRTL() ? 1 : 0);
            if (n14 != 0) {
                n14 = this.getWidth();
                n17 = this.getPaddingRight();
                n14 -= n17;
                orientationHelper = this.mOrientationHelper;
                n17 = orientationHelper.getDecoratedMeasurementInOther((View)recyclerView$Recycler);
                n17 = n14 - n17;
            } else {
                n17 = this.getPaddingLeft();
                object = this.mOrientationHelper;
                n14 = ((OrientationHelper)object).getDecoratedMeasurementInOther((View)recyclerView$Recycler) + n17;
            }
            n13 = linearLayoutManager$LayoutState.mLayoutDirection;
            if (n13 == n16) {
                n12 = linearLayoutManager$LayoutState.mOffset;
                n16 = linearLayoutManager$LayoutChunkResult.mConsumed;
                n16 = n12 - n16;
                n11 = n12;
                n10 = n14;
                n13 = n16;
            } else {
                n12 = linearLayoutManager$LayoutState.mOffset;
                n16 = linearLayoutManager$LayoutChunkResult.mConsumed + n12;
                n13 = n12;
                n10 = n14;
                n11 = n16;
            }
        } else {
            n14 = this.getPaddingTop();
            orientationHelper = this.mOrientationHelper;
            n17 = orientationHelper.getDecoratedMeasurementInOther((View)recyclerView$Recycler) + n14;
            n13 = linearLayoutManager$LayoutState.mLayoutDirection;
            if (n13 == n16) {
                n12 = linearLayoutManager$LayoutState.mOffset;
                n16 = linearLayoutManager$LayoutChunkResult.mConsumed;
                n16 = n12 - n16;
                n10 = n12;
                n13 = n14;
                n11 = n17;
                n17 = n16;
            } else {
                n12 = linearLayoutManager$LayoutState.mOffset;
                n16 = linearLayoutManager$LayoutChunkResult.mConsumed + n12;
                n13 = n14;
                n10 = n16;
                n11 = n17;
                n17 = n12;
            }
        }
        object = this;
        this.layoutDecoratedWithMargins((View)recyclerView$Recycler, n17, n13, n10, n11);
        n12 = (int)(((RecyclerView$LayoutParams)((Object)object2)).isItemRemoved() ? 1 : 0);
        if (n12 != 0 || (n12 = (int)(((RecyclerView$LayoutParams)((Object)object2)).isItemChanged() ? 1 : 0)) != 0) {
            linearLayoutManager$LayoutChunkResult.mIgnoreConsumed = n15;
        }
        linearLayoutManager$LayoutChunkResult.mFocusable = bl2 = recyclerView$Recycler.hasFocusable();
    }

    public void onAnchorReady(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo, int n10) {
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        super.onDetachedFromWindow(recyclerView, recyclerView$Recycler);
        boolean bl2 = this.mRecycleChildrenOnDetach;
        if (bl2) {
            this.removeAndRecycleAllViews(recyclerView$Recycler);
            recyclerView$Recycler.clear();
        }
    }

    public View onFocusSearchFailed(View view, int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        this.resolveShouldLayoutReverse();
        int n11 = this.getChildCount();
        if (n11 == 0) {
            return null;
        }
        n11 = this.convertFocusDirectionToLayoutDirection(n10);
        if (n11 == (n10 = -1 << -1)) {
            return null;
        }
        this.ensureLayoutState();
        float f10 = 0.33333334f;
        int n12 = (int)((float)this.mOrientationHelper.getTotalSpace() * f10);
        this.updateLayoutState(n11, n12, false, recyclerView$State);
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        linearLayoutManager$LayoutState.mScrollingOffset = n10;
        linearLayoutManager$LayoutState.mRecycle = false;
        this.fill(recyclerView$Recycler, linearLayoutManager$LayoutState, recyclerView$State, true);
        n10 = -1;
        recyclerView$Recycler = n11 == n10 ? this.findPartiallyOrCompletelyInvisibleChildClosestToStart() : this.findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        view = n11 == n10 ? this.getChildClosestToStart() : this.getChildClosestToEnd();
        n10 = (int)(view.hasFocusable() ? 1 : 0);
        if (n10 != 0) {
            if (recyclerView$Recycler == null) {
                return null;
            }
            return view;
        }
        return recyclerView$Recycler;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        int n10 = this.getChildCount();
        if (n10 > 0) {
            n10 = this.findFirstVisibleItemPosition();
            accessibilityEvent.setFromIndex(n10);
            n10 = this.findLastVisibleItemPosition();
            accessibilityEvent.setToIndex(n10);
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public void onLayoutChildren(RecyclerView$Recycler object, RecyclerView$State recyclerView$State) {
        void var11_57;
        int n10;
        int n11;
        int n12;
        int n13;
        int n14;
        void var11_41;
        Object object2;
        boolean bl2;
        int n15;
        int n16;
        Object object3 = this.mPendingSavedState;
        int n17 = -1;
        if ((object3 != null || (n16 = this.mPendingScrollPosition) != n17) && (n15 = recyclerView$State.getItemCount()) == 0) {
            this.removeAndRecycleAllViews((RecyclerView$Recycler)object);
            return;
        }
        object3 = this.mPendingSavedState;
        if (object3 != null && (bl2 = ((LinearLayoutManager$SavedState)object3).hasValidAnchor())) {
            int n18;
            object3 = this.mPendingSavedState;
            this.mPendingScrollPosition = n18 = ((LinearLayoutManager$SavedState)object3).mAnchorPosition;
        }
        this.ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        this.resolveShouldLayoutReverse();
        object3 = this.getFocusedChild();
        Object object4 = this.mAnchorInfo;
        int n19 = ((LinearLayoutManager$AnchorInfo)object4).mValid;
        int n20 = 1;
        float f10 = Float.MIN_VALUE;
        if (n19 != 0 && (n19 = this.mPendingScrollPosition) == n17 && (object2 = this.mPendingSavedState) == null) {
            int n21;
            int n22;
            if (object3 != null && ((n22 = ((OrientationHelper)(object4 = this.mOrientationHelper)).getDecoratedStart((View)object3)) >= (n19 = ((OrientationHelper)(object2 = this.mOrientationHelper)).getEndAfterPadding()) || (n21 = ((OrientationHelper)(object4 = this.mOrientationHelper)).getDecoratedEnd((View)object3)) <= (n19 = ((OrientationHelper)(object2 = this.mOrientationHelper)).getStartAfterPadding()))) {
                object4 = this.mAnchorInfo;
                n19 = this.getPosition((View)object3);
                ((LinearLayoutManager$AnchorInfo)object4).assignFromViewAndKeepVisibleRect((View)object3, n19);
            }
        } else {
            ((LinearLayoutManager$AnchorInfo)object4).reset();
            object3 = this.mAnchorInfo;
            int n23 = this.mShouldReverseLayout;
            n19 = (int)(this.mStackFromEnd ? 1 : 0);
            int n24 = n23 ^ n19;
            ((LinearLayoutManager$AnchorInfo)object3).mLayoutFromEnd = n24;
            this.updateAnchorInfoForLayout((RecyclerView$Recycler)object, recyclerView$State, (LinearLayoutManager$AnchorInfo)object3);
            object3 = this.mAnchorInfo;
            ((LinearLayoutManager$AnchorInfo)object3).mValid = n20;
        }
        object3 = this.mLayoutState;
        int n25 = ((LinearLayoutManager$LayoutState)object3).mLastScrollDelta;
        if (n25 >= 0) {
            int n26 = n20;
        } else {
            int n27 = n17;
        }
        ((LinearLayoutManager$LayoutState)object3).mLayoutDirection = var11_41;
        object3 = this.mReusableIntPair;
        object3[0] = false;
        object3[n20] = false;
        this.calculateExtraLayoutSpace(recyclerView$State, (int[])object3);
        object3 = this.mReusableIntPair;
        Object object5 = object3[0];
        int n28 = Math.max(0, (int)object5);
        int n29 = this.mOrientationHelper.getStartAfterPadding();
        int n30 = n28 + n29;
        object4 = this.mReusableIntPair;
        Object object6 = object4[n20];
        int n31 = Math.max(0, (int)object6);
        object2 = this.mOrientationHelper;
        n19 = ((OrientationHelper)object2).getEndPadding();
        int n32 = n31 + n19;
        n19 = (int)(recyclerView$State.isPreLayout() ? 1 : 0);
        if (n19 != 0 && (n19 = this.mPendingScrollPosition) != n17 && (n14 = this.mPendingScrollPositionOffset) != (n13 = -1 << -1) && (object2 = this.findViewByPosition(n19)) != null) {
            n14 = (int)(this.mShouldReverseLayout ? 1 : 0);
            if (n14 != 0) {
                OrientationHelper orientationHelper = this.mOrientationHelper;
                n14 = orientationHelper.getEndAfterPadding();
                OrientationHelper orientationHelper2 = this.mOrientationHelper;
                n19 = orientationHelper2.getDecoratedEnd((View)object2);
                n14 -= n19;
                n19 = this.mPendingScrollPositionOffset;
            } else {
                n19 = this.mOrientationHelper.getDecoratedStart((View)object2);
                OrientationHelper orientationHelper = this.mOrientationHelper;
                n14 = orientationHelper.getStartAfterPadding();
                n19 -= n14;
                n14 = this.mPendingScrollPositionOffset;
            }
            if ((n14 -= n19) > 0) {
                n12 = n30 + n14;
            } else {
                n11 = n32 - n14;
            }
        }
        object2 = this.mAnchorInfo;
        n14 = ((LinearLayoutManager$AnchorInfo)object2).mLayoutFromEnd;
        if (n14 != 0 ? (n14 = (int)(this.mShouldReverseLayout ? 1 : 0)) != 0 : (n14 = (int)(this.mShouldReverseLayout ? 1 : 0)) == 0) {
            n17 = n20;
        }
        this.onAnchorReady((RecyclerView$Recycler)object, recyclerView$State, (LinearLayoutManager$AnchorInfo)object2, n17);
        this.detachAndScrapAttachedViews((RecyclerView$Recycler)object);
        Object object7 = this.mLayoutState;
        n19 = (int)(this.resolveIsInfinite() ? 1 : 0);
        ((LinearLayoutManager$LayoutState)object7).mInfinite = n19;
        object7 = this.mLayoutState;
        n19 = (int)(recyclerView$State.isPreLayout() ? 1 : 0);
        ((LinearLayoutManager$LayoutState)object7).mIsPreLayout = n19;
        this.mLayoutState.mNoRecycleSpace = 0;
        object7 = this.mAnchorInfo;
        n19 = (int)(((LinearLayoutManager$AnchorInfo)object7).mLayoutFromEnd ? 1 : 0);
        if (n19 != 0) {
            int n33;
            int n34;
            this.updateLayoutStateToFillStart((LinearLayoutManager$AnchorInfo)object7);
            object7 = this.mLayoutState;
            ((LinearLayoutManager$LayoutState)object7).mExtraFillSpace = n12;
            this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object7, recyclerView$State, false);
            object3 = this.mLayoutState;
            n17 = ((LinearLayoutManager$LayoutState)object3).mOffset;
            n19 = ((LinearLayoutManager$LayoutState)object3).mCurrentPosition;
            int n35 = ((LinearLayoutManager$LayoutState)object3).mAvailable;
            if (n35 > 0) {
                n34 = n11 + n35;
            }
            object3 = this.mAnchorInfo;
            this.updateLayoutStateToFillEnd((LinearLayoutManager$AnchorInfo)object3);
            object3 = this.mLayoutState;
            ((LinearLayoutManager$LayoutState)object3).mExtraFillSpace = n34;
            int n36 = ((LinearLayoutManager$LayoutState)object3).mCurrentPosition;
            n14 = ((LinearLayoutManager$LayoutState)object3).mItemDirection;
            ((LinearLayoutManager$LayoutState)object3).mCurrentPosition = n33 = n36 + n14;
            this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object3, recyclerView$State, false);
            object3 = this.mLayoutState;
            int n37 = ((LinearLayoutManager$LayoutState)object3).mOffset;
            int n38 = ((LinearLayoutManager$LayoutState)object3).mAvailable;
            if (n38 > 0) {
                this.updateLayoutStateToFillStart(n19, n17);
                object7 = this.mLayoutState;
                ((LinearLayoutManager$LayoutState)object7).mExtraFillSpace = n38;
                this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object7, recyclerView$State, false);
                object3 = this.mLayoutState;
                n17 = ((LinearLayoutManager$LayoutState)object3).mOffset;
            }
        } else {
            int n39;
            int n40;
            this.updateLayoutStateToFillEnd((LinearLayoutManager$AnchorInfo)object7);
            object7 = this.mLayoutState;
            ((LinearLayoutManager$LayoutState)object7).mExtraFillSpace = n11;
            this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object7, recyclerView$State, false);
            object7 = this.mLayoutState;
            int n41 = ((LinearLayoutManager$LayoutState)object7).mOffset;
            n19 = ((LinearLayoutManager$LayoutState)object7).mCurrentPosition;
            n17 = ((LinearLayoutManager$LayoutState)object7).mAvailable;
            if (n17 > 0) {
                n40 = n12 + n17;
            }
            object7 = this.mAnchorInfo;
            this.updateLayoutStateToFillStart((LinearLayoutManager$AnchorInfo)object7);
            object7 = this.mLayoutState;
            ((LinearLayoutManager$LayoutState)object7).mExtraFillSpace = n40;
            int n42 = ((LinearLayoutManager$LayoutState)object7).mCurrentPosition;
            n14 = ((LinearLayoutManager$LayoutState)object7).mItemDirection;
            ((LinearLayoutManager$LayoutState)object7).mCurrentPosition = n39 = n42 + n14;
            this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object7, recyclerView$State, false);
            object3 = this.mLayoutState;
            n17 = ((LinearLayoutManager$LayoutState)object3).mOffset;
            int n43 = ((LinearLayoutManager$LayoutState)object3).mAvailable;
            if (n43 > 0) {
                this.updateLayoutStateToFillEnd(n19, n41);
                object4 = this.mLayoutState;
                ((LinearLayoutManager$LayoutState)object4).mExtraFillSpace = n43;
                this.fill((RecyclerView$Recycler)object, (LinearLayoutManager$LayoutState)object4, recyclerView$State, false);
                object3 = this.mLayoutState;
                int n44 = ((LinearLayoutManager$LayoutState)object3).mOffset;
            }
        }
        if ((n10 = this.getChildCount()) > 0) {
            void var11_56;
            void var5_27;
            void var11_53;
            int n45 = (int)(this.mShouldReverseLayout ? 1 : 0);
            n19 = (int)(this.mStackFromEnd ? 1 : 0);
            int n46 = n45 ^ n19;
            if (n46 != 0) {
                int n47 = this.fixLayoutEndGap((int)var11_53, (RecyclerView$Recycler)object, recyclerView$State, n20 != 0);
                void var11_54 = var11_53 + n47;
                int n48 = this.fixLayoutStartGap(n17 += n47, (RecyclerView$Recycler)object, recyclerView$State, false);
            } else {
                int n49 = this.fixLayoutStartGap(n17, (RecyclerView$Recycler)object, recyclerView$State, n20 != 0);
                n17 += n49;
                void var11_55 = var11_53 + n49;
                int n50 = this.fixLayoutEndGap((int)var11_55, (RecyclerView$Recycler)object, recyclerView$State, false);
            }
            n17 += var5_27;
            var11_57 = var11_56 + var5_27;
        }
        this.layoutForPredictiveAnimations((RecyclerView$Recycler)object, recyclerView$State, n17, (int)var11_57);
        boolean bl3 = recyclerView$State.isPreLayout();
        if (!bl3) {
            object = this.mOrientationHelper;
            ((OrientationHelper)object).onLayoutComplete();
        } else {
            object = this.mAnchorInfo;
            ((LinearLayoutManager$AnchorInfo)object).reset();
        }
        this.mLastStackFromEnd = bl3 = this.mStackFromEnd;
    }

    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -1 << -1;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int n10 = parcelable instanceof LinearLayoutManager$SavedState;
        if (n10 != 0) {
            parcelable = (LinearLayoutManager$SavedState)parcelable;
            this.mPendingSavedState = parcelable;
            n10 = this.mPendingScrollPosition;
            int n11 = -1;
            if (n10 != n11) {
                parcelable.invalidateAnchor();
            }
            this.requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState != null) {
            LinearLayoutManager$SavedState linearLayoutManager$SavedState2 = this.mPendingSavedState;
            linearLayoutManager$SavedState = new LinearLayoutManager$SavedState(linearLayoutManager$SavedState2);
            return linearLayoutManager$SavedState;
        }
        linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        int n10 = this.getChildCount();
        if (n10 > 0) {
            this.ensureLayoutState();
            n10 = (int)(this.mLastStackFromEnd ? 1 : 0);
            int n11 = this.mShouldReverseLayout;
            linearLayoutManager$SavedState.mAnchorLayoutFromEnd = n10 ^= n11;
            if (n10 != 0) {
                int n12;
                View view = this.getChildClosestToEnd();
                OrientationHelper orientationHelper = this.mOrientationHelper;
                int n13 = orientationHelper.getEndAfterPadding();
                OrientationHelper orientationHelper2 = this.mOrientationHelper;
                int n14 = orientationHelper2.getDecoratedEnd(view);
                linearLayoutManager$SavedState.mAnchorOffset = n12 = n13 - n14;
                linearLayoutManager$SavedState.mAnchorPosition = n10 = this.getPosition(view);
            } else {
                int n15;
                View view = this.getChildClosestToStart();
                linearLayoutManager$SavedState.mAnchorPosition = n15 = this.getPosition(view);
                n10 = this.mOrientationHelper.getDecoratedStart(view);
                OrientationHelper orientationHelper = this.mOrientationHelper;
                int n16 = orientationHelper.getStartAfterPadding();
                linearLayoutManager$SavedState.mAnchorOffset = n10 -= n16;
            }
        } else {
            linearLayoutManager$SavedState.invalidateAnchor();
        }
        return linearLayoutManager$SavedState;
    }

    public void prepareForDrop(View object, View view, int n10, int n11) {
        Object object2 = "Cannot drop a view during a scroll or layout calculation";
        this.assertNotInLayoutOrScroll((String)object2);
        this.ensureLayoutState();
        this.resolveShouldLayoutReverse();
        n10 = this.getPosition((View)object);
        n11 = this.getPosition(view);
        int n12 = 1;
        int n13 = -1;
        n10 = n10 < n11 ? n12 : n13;
        boolean bl2 = this.mShouldReverseLayout;
        if (bl2) {
            if (n10 == n12) {
                object2 = this.mOrientationHelper;
                n10 = ((OrientationHelper)object2).getEndAfterPadding();
                int n14 = this.mOrientationHelper.getDecoratedStart(view);
                OrientationHelper orientationHelper = this.mOrientationHelper;
                int n15 = orientationHelper.getDecoratedMeasurement((View)object);
                this.scrollToPositionWithOffset(n11, n10 -= (n14 += n15));
            } else {
                object = this.mOrientationHelper;
                int n16 = ((OrientationHelper)object).getEndAfterPadding();
                object2 = this.mOrientationHelper;
                int n17 = ((OrientationHelper)object2).getDecoratedEnd(view);
                this.scrollToPositionWithOffset(n11, n16 -= n17);
            }
        } else if (n10 == n13) {
            object = this.mOrientationHelper;
            int n18 = ((OrientationHelper)object).getDecoratedStart(view);
            this.scrollToPositionWithOffset(n11, n18);
        } else {
            int n19 = this.mOrientationHelper.getDecoratedEnd(view);
            object2 = this.mOrientationHelper;
            int n20 = ((OrientationHelper)object2).getDecoratedMeasurement((View)object);
            this.scrollToPositionWithOffset(n11, n19 -= n20);
        }
    }

    public boolean resolveIsInfinite() {
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n10 = orientationHelper.getMode();
        if (!n10 && !(n10 = (orientationHelper = this.mOrientationHelper).getEnd())) {
            n10 = 1;
        } else {
            n10 = 0;
            orientationHelper = null;
        }
        return n10 != 0;
    }

    public int scrollBy(int n10, RecyclerView$Recycler object, RecyclerView$State recyclerView$State) {
        int n11 = this.getChildCount();
        if (n11 != 0 && n10 != 0) {
            boolean bl2;
            this.ensureLayoutState();
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
            linearLayoutManager$LayoutState.mRecycle = bl2 = true;
            n11 = n10 > 0 ? (int)(bl2 ? 1 : 0) : -1;
            int n12 = Math.abs(n10);
            this.updateLayoutState(n11, n12, bl2, recyclerView$State);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState2 = this.mLayoutState;
            int n13 = linearLayoutManager$LayoutState2.mScrollingOffset;
            int n14 = this.fill((RecyclerView$Recycler)object, linearLayoutManager$LayoutState2, recyclerView$State, false);
            if ((n13 += n14) < 0) {
                return 0;
            }
            if (n12 > n13) {
                n10 = n11 * n13;
            }
            object = this.mOrientationHelper;
            int n15 = -n10;
            ((OrientationHelper)object).offsetChildren(n15);
            this.mLayoutState.mLastScrollDelta = n10;
            return n10;
        }
        return 0;
    }

    public int scrollHorizontallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int n11 = this.mOrientation;
        int n12 = 1;
        if (n11 == n12) {
            return 0;
        }
        return this.scrollBy(n10, recyclerView$Recycler, recyclerView$State);
    }

    public void scrollToPosition(int n10) {
        this.mPendingScrollPosition = n10;
        this.mPendingScrollPositionOffset = n10 = -1 << -1;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.invalidateAnchor();
        }
        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int n10, int n11) {
        this.mPendingScrollPosition = n10;
        this.mPendingScrollPositionOffset = n11;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.invalidateAnchor();
        }
        this.requestLayout();
    }

    public int scrollVerticallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int n11 = this.mOrientation;
        if (n11 == 0) {
            return 0;
        }
        return this.scrollBy(n10, recyclerView$Recycler, recyclerView$State);
    }

    public void setInitialPrefetchItemCount(int n10) {
        this.mInitialPrefetchItemCount = n10;
    }

    public void setOrientation(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("invalid orientation:");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        OrientationHelper orientationHelper = null;
        this.assertNotInLayoutOrScroll(null);
        n11 = this.mOrientation;
        if (n10 != n11 || (orientationHelper = this.mOrientationHelper) == null) {
            this.mOrientationHelper = orientationHelper = OrientationHelper.createOrientationHelper(this, n10);
            LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo = this.mAnchorInfo;
            linearLayoutManager$AnchorInfo.mOrientationHelper = orientationHelper;
            this.mOrientation = n10;
            this.requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean bl2) {
        this.mRecycleChildrenOnDetach = bl2;
    }

    public void setReverseLayout(boolean bl2) {
        this.assertNotInLayoutOrScroll(null);
        boolean bl3 = this.mReverseLayout;
        if (bl2 == bl3) {
            return;
        }
        this.mReverseLayout = bl2;
        this.requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean bl2) {
        this.mSmoothScrollbarEnabled = bl2;
    }

    public void setStackFromEnd(boolean bl2) {
        this.assertNotInLayoutOrScroll(null);
        boolean bl3 = this.mStackFromEnd;
        if (bl3 == bl2) {
            return;
        }
        this.mStackFromEnd = bl2;
        this.requestLayout();
    }

    public boolean shouldMeasureTwice() {
        int n10;
        int n11 = this.getHeightMode();
        n11 = n11 != (n10 = 0x40000000) && (n11 = this.getWidthMode()) != n10 && (n11 = this.hasFlexibleChildInBothOrientations()) != 0 ? 1 : 0;
        return n11 != 0;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State object, int n10) {
        recyclerView = recyclerView.getContext();
        object = new LinearSmoothScroller((Context)recyclerView);
        ((RecyclerView$SmoothScroller)object).setTargetPosition(n10);
        this.startSmoothScroll((RecyclerView$SmoothScroller)object);
    }

    public boolean supportsPredictiveItemAnimations() {
        boolean bl2;
        boolean bl3;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState == null && (bl3 = this.mLastStackFromEnd) == (bl2 = this.mStackFromEnd)) {
            bl3 = true;
        } else {
            bl3 = false;
            linearLayoutManager$SavedState = null;
        }
        return bl3;
    }

    public void validateChildOrder() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("validating child count ");
        int n10 = this.getChildCount();
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        Log.d((String)string2, (String)object);
        int n11 = this.getChildCount();
        n10 = 1;
        if (n11 < n10) {
            return;
        }
        n11 = 0;
        object = null;
        Object object2 = this.getChildAt(0);
        int n12 = this.getPosition((View)object2);
        OrientationHelper orientationHelper = this.mOrientationHelper;
        Object object3 = this.getChildAt(0);
        int n13 = orientationHelper.getDecoratedStart((View)object3);
        int n14 = this.mShouldReverseLayout;
        String string3 = "detected invalid location";
        String string4 = "detected invalid position. loc invalid? ";
        if (n14) {
            int n15;
            for (n14 = n10; n14 < (n15 = this.getChildCount()); n14 += 1) {
                View view = this.getChildAt(n14);
                int n16 = this.getPosition(view);
                OrientationHelper orientationHelper2 = this.mOrientationHelper;
                n15 = orientationHelper2.getDecoratedStart(view);
                if (n16 < n12) {
                    this.logChildren();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string4);
                    if (n15 >= n13) {
                        n10 = 0;
                        string2 = null;
                    }
                    ((StringBuilder)object3).append(n10 != 0);
                    object = ((StringBuilder)object3).toString();
                    object2 = new RuntimeException((String)object);
                    throw object2;
                }
                if (n15 <= n13) {
                    continue;
                }
                this.logChildren();
                object = new RuntimeException(string3);
                throw object;
            }
        } else {
            int n17;
            for (n14 = n10; n14 < (n17 = this.getChildCount()); n14 += 1) {
                View view = this.getChildAt(n14);
                int n18 = this.getPosition(view);
                OrientationHelper orientationHelper3 = this.mOrientationHelper;
                n17 = orientationHelper3.getDecoratedStart(view);
                if (n18 < n12) {
                    this.logChildren();
                    object3 = new StringBuilder();
                    ((StringBuilder)object3).append(string4);
                    if (n17 >= n13) {
                        n10 = 0;
                        string2 = null;
                    }
                    ((StringBuilder)object3).append(n10 != 0);
                    object = ((StringBuilder)object3).toString();
                    object2 = new RuntimeException((String)object);
                    throw object2;
                }
                if (n17 >= n13) {
                    continue;
                }
                this.logChildren();
                object = new RuntimeException(string3);
                throw object;
            }
        }
    }
}

