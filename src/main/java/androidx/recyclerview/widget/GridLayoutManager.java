/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.util.Log
 *  android.util.SparseIntArray
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager$LayoutParams;
import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager$AnchorInfo;
import androidx.recyclerview.widget.LinearLayoutManager$LayoutChunkResult;
import androidx.recyclerview.widget.LinearLayoutManager$LayoutState;
import androidx.recyclerview.widget.LinearLayoutManager$SavedState;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$State;
import java.util.Arrays;

public class GridLayoutManager
extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = 255;
    private static final String TAG = "GridLayoutManager";
    public int[] mCachedBorders;
    public final Rect mDecorInsets;
    public boolean mPendingSpanCountChange = false;
    public final SparseIntArray mPreLayoutSpanIndexCache;
    public final SparseIntArray mPreLayoutSpanSizeCache;
    public View[] mSet;
    public int mSpanCount = -1;
    public GridLayoutManager$SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public GridLayoutManager(Context object, int n10) {
        super((Context)object);
        super();
        this.mPreLayoutSpanSizeCache = object;
        super();
        this.mPreLayoutSpanIndexCache = object;
        super();
        this.mSpanSizeLookup = object;
        super();
        this.mDecorInsets = object;
        this.setSpanCount(n10);
    }

    public GridLayoutManager(Context object, int n10, int n11, boolean bl2) {
        super((Context)object, n11, bl2);
        super();
        this.mPreLayoutSpanSizeCache = object;
        super();
        this.mPreLayoutSpanIndexCache = object;
        super();
        this.mSpanSizeLookup = object;
        super();
        this.mDecorInsets = object;
        this.setSpanCount(n10);
    }

    public GridLayoutManager(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        Object object;
        this.mPreLayoutSpanSizeCache = object = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = object = new SparseIntArray();
        super();
        this.mSpanSizeLookup = object;
        super();
        this.mDecorInsets = object;
        int n12 = RecyclerView$LayoutManager.getProperties((Context)context, (AttributeSet)attributeSet, (int)n10, (int)n11).spanCount;
        this.setSpanCount(n12);
    }

    /*
     * WARNING - void declaration
     */
    private void assignSpans(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int n10, boolean bl2) {
        int n11 = 0;
        int n12 = -1;
        if (bl2) {
            boolean bl3 = true;
            n12 = n10;
            n10 = 0;
        } else {
            n10 += -1;
            int n13 = n12;
        }
        while (n10 != n12) {
            void var4_7;
            View view = this.mSet[n10];
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams)view.getLayoutParams();
            int n14 = this.getPosition(view);
            gridLayoutManager$LayoutParams.mSpanSize = n14 = this.getSpanSize(recyclerView$Recycler, recyclerView$State, n14);
            gridLayoutManager$LayoutParams.mSpanIndex = n11;
            n11 += n14;
            n10 += var4_7;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int n10 = this.getChildCount();
        for (int i10 = 0; i10 < n10; ++i10) {
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams)this.getChildAt(i10).getLayoutParams();
            int n11 = gridLayoutManager$LayoutParams.getViewLayoutPosition();
            SparseIntArray sparseIntArray = this.mPreLayoutSpanSizeCache;
            int n12 = gridLayoutManager$LayoutParams.getSpanSize();
            sparseIntArray.put(n11, n12);
            sparseIntArray = this.mPreLayoutSpanIndexCache;
            int n13 = gridLayoutManager$LayoutParams.getSpanIndex();
            sparseIntArray.put(n11, n13);
        }
    }

    private void calculateItemBorders(int n10) {
        int[] nArray = this.mCachedBorders;
        int n11 = this.mSpanCount;
        int[] nArray2 = GridLayoutManager.calculateItemBorders(nArray, n11, n10);
        this.mCachedBorders = nArray2;
    }

    public static int[] calculateItemBorders(int[] nArray, int n10, int n11) {
        int n12;
        int n13;
        int n14;
        block7: {
            block6: {
                n14 = 1;
                if (nArray == null || (n13 = nArray.length) != (n12 = n10 + 1)) break block6;
                n13 = nArray.length - n14;
                if ((n13 = nArray[n13]) == n11) break block7;
            }
            int n15 = n10 + 1;
            nArray = new int[n15];
        }
        n13 = 0;
        nArray[0] = 0;
        n12 = n11 / n10;
        n11 %= n10;
        int n16 = 0;
        while (n14 <= n10) {
            int n17;
            if ((n13 += n11) > 0 && (n17 = n10 - n13) < n11) {
                n17 = n12 + 1;
                n13 -= n10;
            } else {
                n17 = n12;
            }
            nArray[n14] = n16 += n17;
            ++n14;
        }
        return nArray;
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        int n11 = 0;
        float f10 = 0.0f;
        GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup = null;
        if (n10 != 0 && (n10 = recyclerView$State.getItemCount()) != 0) {
            this.ensureLayoutState();
            n10 = (int)(this.isSmoothScrollbarEnabled() ? 1 : 0);
            boolean bl2 = n10 ^ 1;
            int n12 = 1;
            View view = this.findFirstVisibleChildClosestToStart(bl2, n12 != 0);
            int n13 = n10 ^ 1;
            View view2 = this.findFirstVisibleChildClosestToEnd(n13 != 0, n12 != 0);
            if (view != null && view2 != null) {
                GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup2 = this.mSpanSizeLookup;
                int n14 = this.getPosition(view);
                int n15 = this.mSpanCount;
                int n16 = gridLayoutManager$SpanSizeLookup2.getCachedSpanGroupIndex(n14, n15);
                GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup3 = this.mSpanSizeLookup;
                n15 = this.getPosition(view2);
                int n17 = this.mSpanCount;
                n14 = gridLayoutManager$SpanSizeLookup3.getCachedSpanGroupIndex(n15, n17);
                n15 = Math.min(n16, n14);
                n16 = Math.max(n16, n14);
                gridLayoutManager$SpanSizeLookup3 = this.mSpanSizeLookup;
                int n18 = recyclerView$State.getItemCount() - n12;
                n17 = this.mSpanCount;
                n18 = gridLayoutManager$SpanSizeLookup3.getCachedSpanGroupIndex(n18, n17) + n12;
                n14 = (int)(this.mShouldReverseLayout ? 1 : 0);
                if (n14 != 0) {
                    n18 = n18 - n16 - n12;
                    n18 = Math.max(0, n18);
                } else {
                    n18 = Math.max(0, n15);
                }
                if (n10 == 0) {
                    return n18;
                }
                n10 = this.mOrientationHelper.getDecoratedEnd(view2);
                n11 = this.mOrientationHelper.getDecoratedStart(view);
                n10 = Math.abs(n10 - n11);
                gridLayoutManager$SpanSizeLookup = this.mSpanSizeLookup;
                n16 = this.getPosition(view);
                n14 = this.mSpanCount;
                n11 = gridLayoutManager$SpanSizeLookup.getCachedSpanGroupIndex(n16, n14);
                gridLayoutManager$SpanSizeLookup2 = this.mSpanSizeLookup;
                n13 = this.getPosition(view2);
                n14 = this.mSpanCount;
                n13 = gridLayoutManager$SpanSizeLookup2.getCachedSpanGroupIndex(n13, n14) - n11 + n12;
                float f11 = n10;
                f10 = n13;
                float f12 = (float)n18 * (f11 /= f10);
                n10 = this.mOrientationHelper.getStartAfterPadding();
                n11 = this.mOrientationHelper.getDecoratedStart(view);
                f11 = n10 - n11;
                return Math.round(f12 + f11);
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        int n11 = 0;
        float f10 = 0.0f;
        if (n10 != 0 && (n10 = recyclerView$State.getItemCount()) != 0) {
            this.ensureLayoutState();
            n10 = (int)(this.isSmoothScrollbarEnabled() ? 1 : 0);
            int n12 = 1;
            Object object = this.findFirstVisibleChildClosestToStart((n10 ^= n12) != 0, n12 != 0);
            int n13 = this.isSmoothScrollbarEnabled() ^ n12;
            View view = this.findFirstVisibleChildClosestToEnd(n13 != 0, n12 != 0);
            if (object != null && view != null) {
                n11 = this.isSmoothScrollbarEnabled();
                if (n11 == 0) {
                    object = this.mSpanSizeLookup;
                    int n14 = recyclerView$State.getItemCount() - n12;
                    n11 = this.mSpanCount;
                    return ((GridLayoutManager$SpanSizeLookup)object).getCachedSpanGroupIndex(n14, n11) + n12;
                }
                n11 = this.mOrientationHelper.getDecoratedEnd(view);
                int n15 = this.mOrientationHelper.getDecoratedStart((View)object);
                GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup = this.mSpanSizeLookup;
                n10 = this.getPosition((View)object);
                int n16 = this.mSpanCount;
                n10 = gridLayoutManager$SpanSizeLookup.getCachedSpanGroupIndex(n10, n16);
                gridLayoutManager$SpanSizeLookup = this.mSpanSizeLookup;
                n13 = this.getPosition(view);
                n16 = this.mSpanCount;
                n13 = gridLayoutManager$SpanSizeLookup.getCachedSpanGroupIndex(n13, n16);
                gridLayoutManager$SpanSizeLookup = this.mSpanSizeLookup;
                int n17 = recyclerView$State.getItemCount() - n12;
                n16 = this.mSpanCount;
                n17 = gridLayoutManager$SpanSizeLookup.getCachedSpanGroupIndex(n17, n16) + n12;
                n13 = n13 - n10 + n12;
                float f11 = n11 -= n15;
                f10 = n13;
                float f12 = n17;
                return (int)((f11 /= f10) * f12);
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo, int n10) {
        int n11 = 1;
        n10 = n10 == n11 ? n11 : 0;
        int n12 = linearLayoutManager$AnchorInfo.mPosition;
        n12 = this.getSpanIndex(recyclerView$Recycler, recyclerView$State, n12);
        if (n10 != 0) {
            while (n12 > 0 && (n10 = linearLayoutManager$AnchorInfo.mPosition) > 0) {
                linearLayoutManager$AnchorInfo.mPosition = n10 += -1;
                n12 = this.getSpanIndex(recyclerView$Recycler, recyclerView$State, n10);
            }
        } else {
            int n13;
            int n14;
            n10 = recyclerView$State.getItemCount() - n11;
            n11 = linearLayoutManager$AnchorInfo.mPosition;
            while (n11 < n10 && (n14 = this.getSpanIndex(recyclerView$Recycler, recyclerView$State, n13 = n11 + 1)) > n12) {
                n11 = n13;
                n12 = n14;
            }
            linearLayoutManager$AnchorInfo.mPosition = n11;
        }
    }

    private void ensureViewSet() {
        int n10;
        int n11;
        View[] viewArray = this.mSet;
        if (viewArray == null || (n11 = viewArray.length) != (n10 = this.mSpanCount)) {
            n11 = this.mSpanCount;
            this.mSet = viewArray = new View[n11];
        }
    }

    private int getSpanGroupIndex(RecyclerView$Recycler object, RecyclerView$State object2, int n10) {
        int n11;
        boolean n112 = ((RecyclerView$State)object2).isPreLayout();
        if (!n112) {
            object = this.mSpanSizeLookup;
            int n12 = this.mSpanCount;
            return ((GridLayoutManager$SpanSizeLookup)object).getCachedSpanGroupIndex(n10, n12);
        }
        int n13 = ((RecyclerView$Recycler)object).convertPreLayoutPositionToPostLayout(n10);
        if (n13 == (n11 = -1)) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot find span size for pre layout position. ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Log.w((String)TAG, (String)object);
            return 0;
        }
        object2 = this.mSpanSizeLookup;
        n10 = this.mSpanCount;
        return ((GridLayoutManager$SpanSizeLookup)object2).getCachedSpanGroupIndex(n13, n10);
    }

    private int getSpanIndex(RecyclerView$Recycler object, RecyclerView$State object2, int n10) {
        boolean n11 = ((RecyclerView$State)object2).isPreLayout();
        if (!n11) {
            object = this.mSpanSizeLookup;
            int n12 = this.mSpanCount;
            return ((GridLayoutManager$SpanSizeLookup)object).getCachedSpanIndex(n10, n12);
        }
        object2 = this.mPreLayoutSpanIndexCache;
        int n13 = -1;
        int n14 = object2.get(n10, n13);
        if (n14 != n13) {
            return n14;
        }
        int n15 = ((RecyclerView$Recycler)object).convertPreLayoutPositionToPostLayout(n10);
        if (n15 == n13) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Log.w((String)TAG, (String)object);
            return 0;
        }
        object2 = this.mSpanSizeLookup;
        n10 = this.mSpanCount;
        return ((GridLayoutManager$SpanSizeLookup)object2).getCachedSpanIndex(n15, n10);
    }

    private int getSpanSize(RecyclerView$Recycler object, RecyclerView$State recyclerView$State, int n10) {
        int n11 = recyclerView$State.isPreLayout();
        if (n11 == 0) {
            return this.mSpanSizeLookup.getSpanSize(n10);
        }
        recyclerView$State = this.mPreLayoutSpanSizeCache;
        int n12 = -1;
        n11 = recyclerView$State.get(n10, n12);
        if (n11 != n12) {
            return n11;
        }
        int n13 = ((RecyclerView$Recycler)object).convertPreLayoutPositionToPostLayout(n10);
        if (n13 == n12) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            Log.w((String)TAG, (String)object);
            return 1;
        }
        return this.mSpanSizeLookup.getSpanSize(n13);
    }

    private void guessMeasurement(float f10, int n10) {
        float f11 = this.mSpanCount;
        int n11 = Math.max(Math.round(f10 * f11), n10);
        this.calculateItemBorders(n11);
    }

    private void measureChild(View view, int n10, boolean bl2) {
        int n11;
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams)view.getLayoutParams();
        Object object = gridLayoutManager$LayoutParams.mDecorInsets;
        int n12 = ((Rect)object).top;
        int n13 = ((Rect)object).bottom;
        n12 += n13;
        n13 = gridLayoutManager$LayoutParams.topMargin;
        n12 += n13;
        n13 = gridLayoutManager$LayoutParams.bottomMargin;
        n12 += n13;
        n13 = ((Rect)object).left;
        int n14 = ((Rect)object).right;
        n13 += n14;
        n14 = gridLayoutManager$LayoutParams.leftMargin;
        n13 += n14;
        n14 = gridLayoutManager$LayoutParams.rightMargin;
        n13 += n14;
        n14 = gridLayoutManager$LayoutParams.mSpanIndex;
        int bl3 = gridLayoutManager$LayoutParams.mSpanSize;
        n14 = this.getSpaceForSpanRange(n14, bl3);
        int n15 = this.mOrientation;
        int n16 = 1;
        if (n15 == n16) {
            int n17 = gridLayoutManager$LayoutParams.width;
            n10 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n10, n13, n17, false);
            object = this.mOrientationHelper;
            n14 = ((OrientationHelper)object).getTotalSpace();
            n13 = this.getHeightMode();
            n11 = gridLayoutManager$LayoutParams.height;
            n11 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n13, n12, n11, n16 != 0);
        } else {
            int n18 = gridLayoutManager$LayoutParams.height;
            n10 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n10, n12, n18, false);
            object = this.mOrientationHelper;
            n14 = ((OrientationHelper)object).getTotalSpace();
            n12 = this.getWidthMode();
            n11 = gridLayoutManager$LayoutParams.width;
            int n19 = RecyclerView$LayoutManager.getChildMeasureSpec(n14, n12, n13, n11, n16 != 0);
            n11 = n10;
            n10 = n19;
        }
        this.measureChildWithDecorationsAndMargin(view, n10, n11, bl2);
    }

    private void measureChildWithDecorationsAndMargin(View view, int n10, int n11, boolean bl2) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams)view.getLayoutParams();
        if (bl2 = bl2 ? this.shouldReMeasureChild(view, n10, n11, recyclerView$LayoutParams) : this.shouldMeasureChild(view, n10, n11, recyclerView$LayoutParams)) {
            view.measure(n10, n11);
        }
    }

    private void updateMeasurements() {
        int n10;
        int n11 = this.getOrientation();
        if (n11 == (n10 = 1)) {
            n11 = this.getWidth();
            n10 = this.getPaddingRight();
            n11 -= n10;
            n10 = this.getPaddingLeft();
        } else {
            n11 = this.getHeight();
            n10 = this.getPaddingBottom();
            n11 -= n10;
            n10 = this.getPaddingTop();
        }
        this.calculateItemBorders(n11 -= n10);
    }

    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof GridLayoutManager$LayoutParams;
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int n10;
        int n11 = this.mSpanCount;
        for (int i10 = 0; i10 < (n10 = this.mSpanCount) && (n10 = (int)(linearLayoutManager$LayoutState.hasMore(recyclerView$State) ? 1 : 0)) != 0 && n11 > 0; n11 -= n10, ++i10) {
            n10 = linearLayoutManager$LayoutState.mCurrentPosition;
            int n12 = linearLayoutManager$LayoutState.mScrollingOffset;
            n12 = Math.max(0, n12);
            recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(n10, n12);
            GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup = this.mSpanSizeLookup;
            n10 = gridLayoutManager$SpanSizeLookup.getSpanSize(n10);
            n10 = linearLayoutManager$LayoutState.mCurrentPosition;
            n12 = linearLayoutManager$LayoutState.mItemDirection;
            linearLayoutManager$LayoutState.mCurrentPosition = n10 += n12;
        }
    }

    public int computeHorizontalScrollOffset(RecyclerView$State recyclerView$State) {
        boolean bl2 = this.mUsingSpansToEstimateScrollBarDimensions;
        if (bl2) {
            return this.computeScrollOffsetWithSpanInfo(recyclerView$State);
        }
        return super.computeHorizontalScrollOffset(recyclerView$State);
    }

    public int computeHorizontalScrollRange(RecyclerView$State recyclerView$State) {
        boolean bl2 = this.mUsingSpansToEstimateScrollBarDimensions;
        if (bl2) {
            return this.computeScrollRangeWithSpanInfo(recyclerView$State);
        }
        return super.computeHorizontalScrollRange(recyclerView$State);
    }

    public int computeVerticalScrollOffset(RecyclerView$State recyclerView$State) {
        boolean bl2 = this.mUsingSpansToEstimateScrollBarDimensions;
        if (bl2) {
            return this.computeScrollOffsetWithSpanInfo(recyclerView$State);
        }
        return super.computeVerticalScrollOffset(recyclerView$State);
    }

    public int computeVerticalScrollRange(RecyclerView$State recyclerView$State) {
        boolean bl2 = this.mUsingSpansToEstimateScrollBarDimensions;
        if (bl2) {
            return this.computeScrollRangeWithSpanInfo(recyclerView$State);
        }
        return super.computeVerticalScrollRange(recyclerView$State);
    }

    public View findReferenceChild(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean n10, boolean n11) {
        n10 = this.getChildCount();
        int n12 = -1;
        int n13 = 1;
        if (n11 != 0) {
            n10 = this.getChildCount() - n13;
            n13 = n12;
        } else {
            n11 = 0;
            n12 = n10;
            n10 = 0;
        }
        n11 = recyclerView$State.getItemCount();
        this.ensureLayoutState();
        OrientationHelper orientationHelper = this.mOrientationHelper;
        int n14 = orientationHelper.getStartAfterPadding();
        OrientationHelper orientationHelper2 = this.mOrientationHelper;
        int n15 = orientationHelper2.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (n10 != n12) {
            View view3 = this.getChildAt(n10);
            int n16 = this.getPosition(view3);
            if (n16 >= 0 && n16 < n11 && (n16 = this.getSpanIndex(recyclerView$Recycler, recyclerView$State, n16)) == 0) {
                Object object = (RecyclerView$LayoutParams)view3.getLayoutParams();
                n16 = (int)(object.isItemRemoved() ? 1 : 0);
                if (n16 != 0) {
                    if (view2 == null) {
                        view2 = view3;
                    }
                } else {
                    object = this.mOrientationHelper;
                    n16 = ((OrientationHelper)object).getDecoratedStart(view3);
                    if (n16 < n15 && (n16 = ((OrientationHelper)(object = this.mOrientationHelper)).getDecoratedEnd(view3)) >= n14) {
                        return view3;
                    }
                    if (view == null) {
                        view = view3;
                    }
                }
            }
            n10 += n13;
        }
        if (view == null) {
            view = view2;
        }
        return view;
    }

    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        int n10 = this.mOrientation;
        int n11 = -2;
        int n12 = -1;
        if (n10 == 0) {
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = new GridLayoutManager$LayoutParams(n11, n12);
            return gridLayoutManager$LayoutParams;
        }
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = new GridLayoutManager$LayoutParams(n12, n11);
        return gridLayoutManager$LayoutParams;
    }

    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = new GridLayoutManager$LayoutParams(context, attributeSet);
        return gridLayoutManager$LayoutParams;
    }

    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = new GridLayoutManager$LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
            return gridLayoutManager$LayoutParams;
        }
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = new GridLayoutManager$LayoutParams(layoutParams);
        return gridLayoutManager$LayoutParams;
    }

    public int getColumnCountForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int n10 = this.mOrientation;
        int n11 = 1;
        if (n10 == n11) {
            return this.mSpanCount;
        }
        n10 = recyclerView$State.getItemCount();
        if (n10 < n11) {
            return 0;
        }
        n10 = recyclerView$State.getItemCount() - n11;
        return this.getSpanGroupIndex(recyclerView$Recycler, recyclerView$State, n10) + n11;
    }

    public int getRowCountForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int n10;
        int n11 = this.mOrientation;
        if (n11 == 0) {
            return this.mSpanCount;
        }
        n11 = recyclerView$State.getItemCount();
        if (n11 < (n10 = 1)) {
            return 0;
        }
        n11 = recyclerView$State.getItemCount() - n10;
        return this.getSpanGroupIndex(recyclerView$Recycler, recyclerView$State, n11) + n10;
    }

    public int getSpaceForSpanRange(int n10, int n11) {
        int n12 = this.mOrientation;
        int n13 = 1;
        if (n12 == n13 && (n12 = (int)(this.isLayoutRTL() ? 1 : 0)) != 0) {
            int[] nArray = this.mCachedBorders;
            n13 = this.mSpanCount;
            int n14 = n13 - n10;
            n14 = nArray[n14];
            n13 = n13 - n10 - n11;
            n10 = nArray[n13];
            return n14 - n10;
        }
        int[] nArray = this.mCachedBorders;
        n11 += n10;
        n11 = nArray[n11];
        n10 = nArray[n10];
        return n11 - n10;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public GridLayoutManager$SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /*
     * WARNING - void declaration
     */
    public void layoutChunk(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult) {
        Object object;
        void var30_36;
        float f10;
        View view;
        void var30_32;
        Object object2;
        Object object3;
        Object n11;
        Object n12;
        Object n13;
        int n14;
        Object object4;
        View view2;
        int n15;
        GridLayoutManager gridLayoutManager = this;
        Object object5 = recyclerView$Recycler;
        Object object6 = recyclerView$State;
        Object object7 = linearLayoutManager$LayoutState;
        LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult2 = linearLayoutManager$LayoutChunkResult;
        Object object8 = this.mOrientationHelper;
        Object object9 = ((OrientationHelper)object8).getModeInOther();
        Object n16 = 0x40000000;
        float f11 = 2.0f;
        int n17 = 1;
        int n18 = 0;
        float f12 = 0.0f;
        Object object10 = null;
        if (object9 != n16) {
            n15 = n17;
        } else {
            n15 = 0;
            view2 = null;
        }
        Object n19 = this.getChildCount();
        if (n19 > 0) {
            object4 = gridLayoutManager.mCachedBorders;
            n14 = gridLayoutManager.mSpanCount;
            n19 = object4[n14];
        } else {
            n19 = 0;
            object4 = null;
        }
        if (n15 != 0) {
            this.updateMeasurements();
        }
        n14 = (n14 = ((LinearLayoutManager$LayoutState)object7).mItemDirection) == n17 ? n17 : 0;
        int n20 = gridLayoutManager.mSpanCount;
        if (n14 == 0) {
            n20 = ((LinearLayoutManager$LayoutState)object7).mCurrentPosition;
            n20 = gridLayoutManager.getSpanIndex((RecyclerView$Recycler)object5, (RecyclerView$State)object6, n20);
            n13 = ((LinearLayoutManager$LayoutState)object7).mCurrentPosition;
            n13 = gridLayoutManager.getSpanSize((RecyclerView$Recycler)object5, (RecyclerView$State)object6, (int)n13);
            n20 += n13;
        }
        for (n13 = 0; n13 < (n12 = gridLayoutManager.mSpanCount) && (n12 = (Object)((LinearLayoutManager$LayoutState)object7).hasMore((RecyclerView$State)object6)) != 0 && n20 > 0; ++n13) {
            n12 = ((LinearLayoutManager$LayoutState)object7).mCurrentPosition;
            n11 = gridLayoutManager.getSpanSize((RecyclerView$Recycler)object5, (RecyclerView$State)object6, (int)n12);
            if (n11 <= (n16 = gridLayoutManager.mSpanCount)) {
                if ((n20 -= n11) < 0 || (object3 = ((LinearLayoutManager$LayoutState)object7).next((RecyclerView$Recycler)object5)) == null) break;
                object2 = gridLayoutManager.mSet;
                object2[n13] = object3;
                n16 = 0x40000000;
                f11 = 2.0f;
                continue;
            }
            object6 = new StringBuilder();
            ((StringBuilder)object6).append("Item at position ");
            ((StringBuilder)object6).append((int)n12);
            ((StringBuilder)object6).append(" requires ");
            ((StringBuilder)object6).append((int)n11);
            ((StringBuilder)object6).append(" spans but GridLayoutManager has only ");
            int n21 = gridLayoutManager.mSpanCount;
            ((StringBuilder)object6).append(n21);
            ((StringBuilder)object6).append(" spans.");
            object6 = ((StringBuilder)object6).toString();
            object5 = new IllegalArgumentException((String)object6);
            throw object5;
        }
        if (n13 == 0) {
            linearLayoutManager$LayoutChunkResult2.mFinished = n17;
            return;
        }
        n16 = 0;
        f11 = 0.0f;
        object3 = null;
        gridLayoutManager.assignSpans((RecyclerView$Recycler)object5, (RecyclerView$State)object6, (int)n13, n14 != 0);
        boolean n10 = false;
        object5 = null;
        Object object11 = 0;
        object6 = null;
        while (++var30_32 < n13) {
            view = gridLayoutManager.mSet[var30_32];
            object2 = ((LinearLayoutManager$LayoutState)object7).mScrapList;
            if (object2 == null) {
                if (n14 != 0) {
                    gridLayoutManager.addView(view);
                } else {
                    gridLayoutManager.addView(view, 0);
                }
            } else if (n14 != 0) {
                gridLayoutManager.addDisappearingView(view);
            } else {
                gridLayoutManager.addDisappearingView(view, 0);
            }
            object2 = gridLayoutManager.mDecorInsets;
            gridLayoutManager.calculateItemDecorationsForChild(view, (Rect)object2);
            gridLayoutManager.measureChild(view, (int)object9, false);
            object2 = gridLayoutManager.mOrientationHelper;
            n12 = object2.getDecoratedMeasurement(view);
            if (n12 > object11) {
                object11 = n12;
            }
            object2 = (GridLayoutManager$LayoutParams)view.getLayoutParams();
            n11 = 1065353216;
            float f13 = 1.0f;
            object10 = gridLayoutManager.mOrientationHelper;
            n18 = ((OrientationHelper)object10).getDecoratedMeasurementInOther(view);
            f12 = (float)n18 * f13;
            f10 = object2.mSpanSize;
            float f14 = (f12 /= f10) - f11;
            n20 = (int)(f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1));
            if (n20 > 0) {
                f11 = f12;
            }
            n18 = 0;
            f12 = 0.0f;
            object10 = null;
        }
        if (n15 != 0) {
            void var30_34;
            gridLayoutManager.guessMeasurement(f11, (int)n19);
            boolean bl2 = false;
            object5 = null;
            object11 = 0;
            object6 = null;
            while (++var30_34 < n13) {
                object8 = gridLayoutManager.mSet[var30_34];
                n16 = 0x40000000;
                f11 = 2.0f;
                gridLayoutManager.measureChild((View)object8, (int)n16, n17 != 0);
                object3 = gridLayoutManager.mOrientationHelper;
                object9 = ((OrientationHelper)object3).getDecoratedMeasurement((View)object8);
                if (object9 > object11) {
                    object11 = object9;
                }
            }
        }
        boolean bl3 = false;
        object5 = null;
        while (++var30_36 < n13) {
            object3 = gridLayoutManager.mOrientationHelper;
            object8 = gridLayoutManager.mSet[var30_36];
            n16 = ((OrientationHelper)object3).getDecoratedMeasurement((View)object8);
            if (n16 != object11) {
                object3 = (GridLayoutManager$LayoutParams)object8.getLayoutParams();
                object10 = ((RecyclerView$LayoutParams)object3).mDecorInsets;
                n15 = ((Rect)object10).top;
                n19 = ((Rect)object10).bottom;
                n15 += n19;
                n19 = ((ViewGroup.MarginLayoutParams)object3).topMargin;
                n15 += n19;
                n19 = ((ViewGroup.MarginLayoutParams)object3).bottomMargin;
                n15 += n19;
                n19 = ((Rect)object10).left;
                n18 = ((Rect)object10).right;
                n19 += n18;
                n18 = ((ViewGroup.MarginLayoutParams)object3).leftMargin;
                n19 += n18;
                n18 = ((ViewGroup.MarginLayoutParams)object3).rightMargin;
                n19 += n18;
                n18 = ((GridLayoutManager$LayoutParams)object3).mSpanIndex;
                n14 = ((GridLayoutManager$LayoutParams)object3).mSpanSize;
                n18 = gridLayoutManager.getSpaceForSpanRange(n18, n14);
                n14 = gridLayoutManager.mOrientation;
                if (n14 == n17) {
                    n16 = ((ViewGroup.MarginLayoutParams)object3).width;
                    n14 = 0x40000000;
                    n20 = 0;
                    f10 = 0.0f;
                    view = null;
                    n16 = RecyclerView$LayoutManager.getChildMeasureSpec(n18, n14, n19, n16, false);
                    n18 = View.MeasureSpec.makeMeasureSpec((int)(object11 - n15), (int)n14);
                } else {
                    n14 = 0x40000000;
                    n20 = 0;
                    f10 = 0.0f;
                    view = null;
                    n19 = View.MeasureSpec.makeMeasureSpec((int)(object11 - n19), (int)n14);
                    n16 = ((ViewGroup.MarginLayoutParams)object3).height;
                    n18 = RecyclerView$LayoutManager.getChildMeasureSpec(n18, n14, n15, n16, false);
                    n16 = n19;
                }
                gridLayoutManager.measureChildWithDecorationsAndMargin((View)object8, (int)n16, n18, n17 != 0);
                continue;
            }
            n14 = 0x40000000;
            n20 = 0;
            f10 = 0.0f;
            view = null;
        }
        n20 = 0;
        f10 = 0.0f;
        view = null;
        linearLayoutManager$LayoutChunkResult2.mConsumed = object11;
        int n21 = gridLayoutManager.mOrientation;
        object9 = -1;
        if (n21 == n17) {
            int n22 = ((LinearLayoutManager$LayoutState)object7).mLayoutDirection;
            if (n22 == object9) {
                int n23 = ((LinearLayoutManager$LayoutState)object7).mOffset;
                object9 = object11 = n23 - object11;
            } else {
                Object object12 = ((LinearLayoutManager$LayoutState)object7).mOffset;
                object9 = object12;
                Object object13 = object11 += object12;
            }
            object11 = 0;
            object6 = null;
            object = 0;
            object7 = null;
        } else {
            int n24 = ((LinearLayoutManager$LayoutState)object7).mLayoutDirection;
            if (n24 == object9) {
                Object object14 = ((LinearLayoutManager$LayoutState)object7).mOffset;
                object = object14 - object11;
                object9 = 0;
                object8 = null;
                object11 = object14;
                boolean bl4 = false;
                object5 = null;
            } else {
                int n25 = ((LinearLayoutManager$LayoutState)object7).mOffset;
                object11 += n25;
                object = n25;
                boolean bl5 = false;
                object5 = null;
                object9 = 0;
                object8 = null;
            }
        }
        while (n20 < n13) {
            Object object15;
            Object object16;
            view2 = gridLayoutManager.mSet[n20];
            object3 = view2.getLayoutParams();
            object4 = object3;
            object4 = (Object)((GridLayoutManager$LayoutParams)((Object)object3));
            n16 = gridLayoutManager.mOrientation;
            if (n16 == n17) {
                object11 = this.isLayoutRTL();
                if (object11 != 0) {
                    object11 = this.getPaddingLeft();
                    object7 = gridLayoutManager.mCachedBorders;
                    n16 = gridLayoutManager.mSpanCount;
                    n18 = ((GridLayoutManager$LayoutParams)object4).mSpanIndex;
                    object = object7[n16 -= n18];
                    object11 += object;
                    object7 = gridLayoutManager.mOrientationHelper;
                    object = ((OrientationHelper)object7).getDecoratedMeasurementInOther(view2);
                    object = object11 - object;
                    n14 = object16;
                    n12 = object11;
                    n11 = object;
                } else {
                    object11 = this.getPaddingLeft();
                    object7 = gridLayoutManager.mCachedBorders;
                    n16 = ((GridLayoutManager$LayoutParams)object4).mSpanIndex;
                    object = object7[n16];
                    object11 += object;
                    object7 = gridLayoutManager.mOrientationHelper;
                    object = ((OrientationHelper)object7).getDecoratedMeasurementInOther(view2) + object11;
                    n14 = object16;
                    n11 = object11;
                    n12 = object;
                }
                object15 = object9;
            } else {
                object16 = this.getPaddingTop();
                object8 = gridLayoutManager.mCachedBorders;
                n16 = ((GridLayoutManager$LayoutParams)object4).mSpanIndex;
                object9 = object8[n16];
                object16 += object9;
                object8 = gridLayoutManager.mOrientationHelper;
                object9 = ((OrientationHelper)object8).getDecoratedMeasurementInOther(view2) + object16;
                object15 = object16;
                n12 = object11;
                n11 = object;
                n14 = object9;
            }
            object5 = this;
            object6 = view2;
            object = n11;
            object9 = object15;
            n16 = n12;
            n18 = n14;
            this.layoutDecoratedWithMargins(view2, (int)n11, (int)object15, (int)n12, n14);
            object16 = ((RecyclerView$LayoutParams)((Object)object4)).isItemRemoved();
            if (object16 != 0 || (object16 = ((RecyclerView$LayoutParams)((Object)object4)).isItemChanged()) != 0) {
                linearLayoutManager$LayoutChunkResult2.mIgnoreConsumed = n17;
            }
            object16 = linearLayoutManager$LayoutChunkResult2.mFocusable;
            object11 = view2.hasFocusable();
            linearLayoutManager$LayoutChunkResult2.mFocusable = object16 |= object11;
            ++n20;
            object16 = n14;
            object11 = n12;
            object = n11;
            object9 = object15;
        }
        Arrays.fill(gridLayoutManager.mSet, null);
    }

    public void onAnchorReady(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo, int n10) {
        super.onAnchorReady(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo, n10);
        this.updateMeasurements();
        int n11 = recyclerView$State.getItemCount();
        if (n11 > 0 && (n11 = (int)(recyclerView$State.isPreLayout() ? 1 : 0)) == 0) {
            this.ensureAnchorIsInCorrectSpan(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo, n10);
        }
        this.ensureViewSet();
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public View onFocusSearchFailed(View var1_1, int var2_2, RecyclerView$Recycler var3_3, RecyclerView$State var4_4) {
        var5_5 = this;
        var6_6 = var3_3;
        var7_7 = var4_4;
        var8_8 = this.findContainingItemView(var1_1);
        var9_9 = 0;
        var10_10 /* !! */  = null;
        if (var8_8 == null) {
            return null;
        }
        var11_11 = (GridLayoutManager$LayoutParams)var8_8.getLayoutParams();
        var12_12 = var11_11.mSpanIndex;
        var13_13 = var11_11.mSpanSize + var12_12;
        var14_14 /* !! */  = super.onFocusSearchFailed(var1_1, var2_2, var3_3, var4_4);
        if (var14_14 /* !! */  == null) {
            return null;
        }
        var15_15 = var2_2;
        var15_15 = this.convertFocusDirectionToLayoutDirection(var2_2);
        if (var15_15 == (var16_16 = 1)) {
            var15_15 = var16_16;
        } else {
            var15_15 = 0;
            var14_14 /* !! */  = null;
        }
        var17_17 = var5_5.mShouldReverseLayout;
        if (var15_15 != var17_17) {
            var15_15 = var16_16;
        } else {
            var15_15 = 0;
            var14_14 /* !! */  = null;
        }
        var17_17 = -1;
        if (var15_15 != 0) {
            var15_15 = this.getChildCount() - var16_16;
            var18_18 = var17_17;
            var19_19 = var17_17;
        } else {
            var18_18 = this.getChildCount();
            var19_19 = var16_16;
            var15_15 = 0;
            var14_14 /* !! */  = null;
        }
        var20_20 = var5_5.mOrientation;
        var20_20 = var20_20 == var16_16 && (var20_20 = (int)this.isLayoutRTL()) != 0 ? var16_16 : 0;
        var21_21 = var5_5.getSpanGroupIndex(var6_6, var7_7, var15_15);
        var22_22 = var17_17;
        var23_23 = var17_17;
        var24_24 = 0;
        var25_25 = 0;
        var17_17 = var15_15;
        var15_15 = 0;
        var14_14 /* !! */  = null;
        while (var17_17 != var18_18) {
            block25: {
                block31: {
                    block29: {
                        block28: {
                            block30: {
                                block27: {
                                    block26: {
                                        var16_16 = var5_5.getSpanGroupIndex(var6_6, var7_7, var17_17);
                                        var6_6 = var5_5.getChildAt(var17_17);
                                        if (var6_6 == var8_8) break;
                                        var26_26 = var6_6.hasFocusable();
                                        if (!var26_26 || var16_16 == var21_21) break block26;
                                        if (var10_10 /* !! */  != null) break;
                                        var27_27 = var8_8;
                                        var28_28 = var14_14 /* !! */ ;
                                        var29_29 = var24_24;
                                        var30_30 = var18_18;
                                        var15_15 = var23_23;
                                        var24_24 = var25_25;
                                        ** GOTO lbl-1000
                                    }
                                    var31_31 = (GridLayoutManager$LayoutParams)var6_6.getLayoutParams();
                                    var32_32 = var31_31.mSpanIndex;
                                    var27_27 = var8_8;
                                    var33_33 = var31_31.mSpanSize + var32_32;
                                    var29_29 = var6_6.hasFocusable();
                                    if (var29_29 != 0 && var32_32 == var12_12 && var33_33 == var13_13) {
                                        return var6_6;
                                    }
                                    var29_29 = var6_6.hasFocusable();
                                    if (var29_29 != 0 && var10_10 /* !! */  == null || (var29_29 = var6_6.hasFocusable()) == 0 && var14_14 /* !! */  == null) {
                                        var28_28 = var14_14 /* !! */ ;
lbl73:
                                        // 3 sources

                                        while (true) {
                                            var29_29 = var24_24;
                                            var30_30 = var18_18;
                                            var15_15 = var23_23;
                                            var24_24 = var25_25;
lbl78:
                                            // 2 sources

                                            while (true) {
                                                var18_18 = 1;
                                                break block25;
                                                break;
                                            }
                                            break;
                                        }
                                    }
                                    var29_29 = Math.max(var32_32, var12_12);
                                    var30_30 = Math.min(var33_33, var13_13);
                                    var28_28 = var14_14 /* !! */ ;
                                    var15_15 = var30_30 - var29_29;
                                    var29_29 = (int)var6_6.hasFocusable();
                                    if (var29_29 == 0) break block27;
                                    if (var15_15 > var24_24) ** GOTO lbl73
                                    if (var15_15 != var24_24) break block28;
                                    if (var32_32 > var22_22) {
                                        var15_15 = 1;
                                    } else {
                                        var15_15 = 0;
                                        var14_14 /* !! */  = null;
                                    }
                                    if (var20_20 == var15_15) {
                                        ** continue;
                                    }
                                    break block28;
                                }
                                if (var10_10 /* !! */  != null) break block28;
                                var29_29 = var24_24;
                                var30_30 = var18_18;
                                var24_24 = 0;
                                var18_18 = 1;
                                var34_34 = var5_5.isViewPartiallyVisible((View)var6_6, false, (boolean)var18_18);
                                if (!var34_34) break block29;
                                var24_24 = var25_25;
                                if (var15_15 <= var25_25) break block30;
                                var15_15 = var23_23;
                                break block25;
                            }
                            if (var15_15 == var25_25) {
                                var15_15 = var23_23;
                                if (var32_32 <= var23_23) {
                                    var18_18 = 0;
                                }
                                if (var20_20 == var18_18) {
                                    ** continue;
                                }
                            } else {
                                var15_15 = var23_23;
                            }
                            break block31;
                        }
                        var29_29 = var24_24;
                        var30_30 = var18_18;
                    }
                    var15_15 = var23_23;
                    var24_24 = var25_25;
                }
                var18_18 = 0;
            }
            if (var18_18 != 0) {
                var18_18 = (int)var6_6.hasFocusable();
                if (var18_18 != 0) {
                    var9_9 = var31_31.mSpanIndex;
                    var33_33 = Math.min(var33_33, var13_13);
                    var32_32 = Math.max(var32_32, var12_12);
                    var32_32 = var33_33 - var32_32;
                    var22_22 = var9_9;
                    var23_23 = var15_15;
                    var25_25 = var24_24;
                    var14_14 /* !! */  = var28_28;
                    var10_10 /* !! */  = var6_6;
                    var24_24 = var32_32;
                } else {
                    var15_15 = var31_31.mSpanIndex;
                    var33_33 = Math.min(var33_33, var13_13);
                    var32_32 = Math.max(var32_32, var12_12);
                    var25_25 = var33_33 - var32_32;
                    var23_23 = var15_15;
                    var24_24 = var29_29;
                    var14_14 /* !! */  = var6_6;
                }
            } else lbl-1000:
            // 2 sources

            {
                var23_23 = var15_15;
                var25_25 = var24_24;
                var24_24 = var29_29;
                var14_14 /* !! */  = var28_28;
            }
            var17_17 += var19_19;
            var6_6 = var3_3;
            var7_7 = var4_4;
            var8_8 = var27_27;
            var18_18 = var30_30;
            var16_16 = 1;
        }
        var28_28 = var14_14 /* !! */ ;
        if (var10_10 /* !! */  == null) {
            var10_10 /* !! */  = var14_14 /* !! */ ;
        }
        return var10_10 /* !! */ ;
    }

    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView$Recycler object, RecyclerView$State recyclerView$State, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        Object object2 = view.getLayoutParams();
        int n10 = object2 instanceof GridLayoutManager$LayoutParams;
        if (n10 == 0) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        object2 = (GridLayoutManager$LayoutParams)((Object)object2);
        int n11 = ((RecyclerView$LayoutParams)((Object)object2)).getViewLayoutPosition();
        int n12 = this.getSpanGroupIndex((RecyclerView$Recycler)object, recyclerView$State, n11);
        int n13 = this.mOrientation;
        if (n13 == 0) {
            n10 = ((GridLayoutManager$LayoutParams)((Object)object2)).getSpanIndex();
            int n14 = ((GridLayoutManager$LayoutParams)((Object)object2)).getSpanSize();
            int n15 = 1;
            int n16 = n12;
            object = AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(n10, n14, n12, n15, false, false);
            accessibilityNodeInfoCompat.setCollectionItemInfo(object);
        } else {
            int n17 = 1;
            int n18 = ((GridLayoutManager$LayoutParams)((Object)object2)).getSpanIndex();
            int n19 = ((GridLayoutManager$LayoutParams)((Object)object2)).getSpanSize();
            n10 = n12;
            object = AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(n12, n17, n18, n19, false, false);
            accessibilityNodeInfoCompat.setCollectionItemInfo(object);
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int n10, int n11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsMoved(RecyclerView recyclerView, int n10, int n11, int n12) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsRemoved(RecyclerView recyclerView, int n10, int n11) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n10, int n11, Object object) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        boolean bl2 = recyclerView$State.isPreLayout();
        if (bl2) {
            this.cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recyclerView$Recycler, recyclerView$State);
        this.clearPreLayoutSpanMappingCache();
    }

    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.mPendingSpanCountChange = false;
    }

    public int scrollHorizontallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        this.updateMeasurements();
        this.ensureViewSet();
        return super.scrollHorizontallyBy(n10, recyclerView$Recycler, recyclerView$State);
    }

    public int scrollVerticallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        this.updateMeasurements();
        this.ensureViewSet();
        return super.scrollVerticallyBy(n10, recyclerView$Recycler, recyclerView$State);
    }

    public void setMeasuredDimension(Rect object, int n10, int n11) {
        Object object2;
        int[] nArray = this.mCachedBorders;
        if (nArray == null) {
            super.setMeasuredDimension((Rect)object, n10, n11);
        }
        int n12 = this.getPaddingLeft();
        int n13 = this.getPaddingRight();
        n12 += n13;
        n13 = this.getPaddingTop();
        int n14 = this.getPaddingBottom();
        n13 += n14;
        n14 = this.mOrientation;
        int n15 = 1;
        if (n14 == n15) {
            object2 = object.height() + n13;
            n13 = this.getMinimumHeight();
            object2 = RecyclerView$LayoutManager.chooseSize(n11, object2, n13);
            int[] nArray2 = this.mCachedBorders;
            n13 = nArray2.length - n15;
            n11 = nArray2[n13] + n12;
            n12 = this.getMinimumWidth();
            n10 = RecyclerView$LayoutManager.chooseSize(n10, n11, n12);
        } else {
            object2 = object.width() + n12;
            n12 = this.getMinimumWidth();
            n10 = RecyclerView$LayoutManager.chooseSize(n10, object2, n12);
            object = this.mCachedBorders;
            n12 = ((Rect)object).length - n15;
            object2 = object[n12] + n13;
            n12 = this.getMinimumHeight();
            object2 = RecyclerView$LayoutManager.chooseSize(n11, object2, n12);
        }
        this.setMeasuredDimension(n10, (int)object2);
    }

    public void setSpanCount(int n10) {
        int n11 = this.mSpanCount;
        if (n10 == n11) {
            return;
        }
        n11 = 1;
        this.mPendingSpanCountChange = n11;
        if (n10 >= n11) {
            this.mSpanCount = n10;
            this.mSpanSizeLookup.invalidateSpanIndexCache();
            this.requestLayout();
            return;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Span count should be at least 1. Provided ");
        stringBuilder.append(n10);
        String string2 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public void setSpanSizeLookup(GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup) {
        this.mSpanSizeLookup = gridLayoutManager$SpanSizeLookup;
    }

    public void setStackFromEnd(boolean bl2) {
        if (!bl2) {
            super.setStackFromEnd(false);
            return;
        }
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        throw unsupportedOperationException;
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean bl2) {
        this.mUsingSpansToEstimateScrollBarDimensions = bl2;
    }

    public boolean supportsPredictiveItemAnimations() {
        boolean bl2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState == null && !(bl2 = this.mPendingSpanCountChange)) {
            bl2 = true;
        } else {
            bl2 = false;
            linearLayoutManager$SavedState = null;
        }
        return bl2;
    }
}

