/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.graphics.Rect
 *  android.os.Parcelable
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.accessibility.AccessibilityEvent
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.recyclerview.widget.LayoutState;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.RecyclerView$State;
import androidx.recyclerview.widget.ScrollbarHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$1;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$AnchorInfo;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$SavedState;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$Span;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

public class StaggeredGridLayoutManager
extends RecyclerView$LayoutManager
implements RecyclerView$SmoothScroller$ScrollVectorProvider {
    public static final boolean DEBUG = false;
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private final StaggeredGridLayoutManager$AnchorInfo mAnchorInfo;
    private final Runnable mCheckForGapsRunnable;
    private int mFullSizeSpec;
    private int mGapStrategy;
    private boolean mLaidOutInvalidFullSpan;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;
    private final LayoutState mLayoutState;
    public StaggeredGridLayoutManager$LazySpanLookup mLazySpanLookup;
    private int mOrientation;
    private StaggeredGridLayoutManager$SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    private int[] mPrefetchDistances;
    public OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;
    public boolean mReverseLayout;
    public OrientationHelper mSecondaryOrientation;
    public boolean mShouldReverseLayout;
    private int mSizePerSpan;
    private boolean mSmoothScrollbarEnabled;
    private int mSpanCount;
    public StaggeredGridLayoutManager$Span[] mSpans;
    private final Rect mTmpRect;

    public StaggeredGridLayoutManager(int n10, int n11) {
        LayoutState layoutState;
        int n12;
        this.mSpanCount = n12 = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = n12;
        this.mPendingScrollPositionOffset = -1 << -1;
        Object object = new StaggeredGridLayoutManager$LazySpanLookup();
        this.mLazySpanLookup = object;
        this.mGapStrategy = 2;
        this.mTmpRect = object;
        this.mAnchorInfo = object = new StaggeredGridLayoutManager$AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = object = new StaggeredGridLayoutManager$1(this);
        this.mOrientation = n11;
        this.setSpanCount(n10);
        this.mLayoutState = layoutState = new LayoutState();
        this.createOrientationHelpers();
    }

    public StaggeredGridLayoutManager(Context object, AttributeSet attributeSet, int n10, int n11) {
        int n12;
        this.mSpanCount = n12 = -1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mPendingScrollPosition = n12;
        this.mPendingScrollPositionOffset = -1 << -1;
        Object object2 = new StaggeredGridLayoutManager$LazySpanLookup();
        this.mLazySpanLookup = object2;
        this.mGapStrategy = 2;
        this.mTmpRect = object2;
        this.mAnchorInfo = object2 = new StaggeredGridLayoutManager$AnchorInfo(this);
        this.mLaidOutInvalidFullSpan = false;
        this.mSmoothScrollbarEnabled = true;
        this.mCheckForGapsRunnable = object2 = new StaggeredGridLayoutManager$1(this);
        object = RecyclerView$LayoutManager.getProperties(object, attributeSet, n10, n11);
        int n13 = object.orientation;
        this.setOrientation(n13);
        n13 = object.spanCount;
        this.setSpanCount(n13);
        boolean bl2 = object.reverseLayout;
        this.setReverseLayout(bl2);
        super();
        this.mLayoutState = object;
        this.createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i10 = this.mSpanCount + -1; i10 >= 0; i10 += -1) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            staggeredGridLayoutManager$Span.appendToSpan(view);
        }
    }

    private void applyPendingSavedState(StaggeredGridLayoutManager$AnchorInfo object) {
        Object object2;
        int n10;
        int n11;
        Object object3 = this.mPendingSavedState;
        int n12 = ((StaggeredGridLayoutManager$SavedState)object3).mSpanOffsetsSize;
        if (n12 > 0) {
            n11 = this.mSpanCount;
            if (n12 == n11) {
                object3 = null;
                for (n10 = 0; n10 < (n12 = this.mSpanCount); ++n10) {
                    this.mSpans[n10].clear();
                    object2 = this.mPendingSavedState;
                    int[] nArray = ((StaggeredGridLayoutManager$SavedState)object2).mSpanOffsets;
                    n11 = nArray[n10];
                    int n13 = -1 << -1;
                    if (n11 != n13) {
                        n12 = (int)(((StaggeredGridLayoutManager$SavedState)object2).mAnchorLayoutFromEnd ? 1 : 0);
                        if (n12 != 0) {
                            object2 = this.mPrimaryOrientation;
                            n12 = ((OrientationHelper)object2).getEndAfterPadding();
                        } else {
                            object2 = this.mPrimaryOrientation;
                            n12 = ((OrientationHelper)object2).getStartAfterPadding();
                        }
                        n11 += n12;
                    }
                    object2 = this.mSpans[n10];
                    ((StaggeredGridLayoutManager$Span)object2).setLine(n11);
                }
            } else {
                ((StaggeredGridLayoutManager$SavedState)object3).invalidateSpanInfo();
                object3 = this.mPendingSavedState;
                ((StaggeredGridLayoutManager$SavedState)object3).mAnchorPosition = n12 = ((StaggeredGridLayoutManager$SavedState)object3).mVisibleAnchorPosition;
            }
        }
        object3 = this.mPendingSavedState;
        n12 = (int)(((StaggeredGridLayoutManager$SavedState)object3).mLastLayoutRTL ? 1 : 0);
        this.mLastLayoutRTL = n12;
        n10 = ((StaggeredGridLayoutManager$SavedState)object3).mReverseLayout;
        this.setReverseLayout(n10 != 0);
        this.resolveShouldLayoutReverse();
        object3 = this.mPendingSavedState;
        n12 = ((StaggeredGridLayoutManager$SavedState)object3).mAnchorPosition;
        n11 = -1;
        if (n12 != n11) {
            this.mPendingScrollPosition = n12;
            n12 = (int)(((StaggeredGridLayoutManager$SavedState)object3).mAnchorLayoutFromEnd ? 1 : 0);
            ((StaggeredGridLayoutManager$AnchorInfo)object).mLayoutFromEnd = n12;
        } else {
            n12 = (int)(this.mShouldReverseLayout ? 1 : 0);
            ((StaggeredGridLayoutManager$AnchorInfo)object).mLayoutFromEnd = n12;
        }
        int n14 = ((StaggeredGridLayoutManager$SavedState)object3).mSpanLookupSize;
        n12 = 1;
        if (n14 > n12) {
            object = this.mLazySpanLookup;
            object2 = ((StaggeredGridLayoutManager$SavedState)object3).mSpanLookup;
            ((StaggeredGridLayoutManager$LazySpanLookup)object).mData = (int[])object2;
            ((StaggeredGridLayoutManager$LazySpanLookup)object).mFullSpanItems = object3 = ((StaggeredGridLayoutManager$SavedState)object3).mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, StaggeredGridLayoutManager$LayoutParams object, LayoutState layoutState) {
        int n10 = layoutState.mLayoutDirection;
        int n11 = 1;
        if (n10 == n11) {
            n10 = (int)(((StaggeredGridLayoutManager$LayoutParams)object).mFullSpan ? 1 : 0);
            if (n10 != 0) {
                this.appendViewToAllSpans(view);
            } else {
                object = ((StaggeredGridLayoutManager$LayoutParams)object).mSpan;
                ((StaggeredGridLayoutManager$Span)object).appendToSpan(view);
            }
        } else {
            n10 = (int)(((StaggeredGridLayoutManager$LayoutParams)object).mFullSpan ? 1 : 0);
            if (n10 != 0) {
                this.prependViewToAllSpans(view);
            } else {
                object = ((StaggeredGridLayoutManager$LayoutParams)object).mSpan;
                ((StaggeredGridLayoutManager$Span)object).prependToSpan(view);
            }
        }
    }

    private int calculateScrollDirectionForPosition(int n10) {
        int n11 = this.getChildCount();
        int n12 = -1;
        int n13 = 1;
        if (n11 == 0) {
            n10 = (int)(this.mShouldReverseLayout ? 1 : 0);
            if (n10 != 0) {
                n12 = n13;
            }
            return n12;
        }
        n11 = this.getFirstChildPosition();
        if ((n10 = n10 < n11 ? n13 : 0) == (n11 = (int)(this.mShouldReverseLayout ? 1 : 0))) {
            n12 = n13;
        }
        return n12;
    }

    private boolean checkSpanForGap(StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span) {
        int n10 = this.mShouldReverseLayout;
        int n11 = 0;
        if (n10 != 0) {
            OrientationHelper orientationHelper;
            int n12;
            n10 = staggeredGridLayoutManager$Span.getEndLine();
            if (n10 < (n12 = (orientationHelper = this.mPrimaryOrientation).getEndAfterPadding())) {
                ArrayList arrayList = staggeredGridLayoutManager$Span.mViews;
                n11 = arrayList.size() + -1;
                arrayList = (View)arrayList.get(n11);
                return staggeredGridLayoutManager$Span.getLayoutParams((View)arrayList).mFullSpan ^ true;
            }
        } else {
            OrientationHelper orientationHelper;
            int n13;
            n10 = staggeredGridLayoutManager$Span.getStartLine();
            if (n10 > (n13 = (orientationHelper = this.mPrimaryOrientation).getStartAfterPadding())) {
                View view = (View)staggeredGridLayoutManager$Span.mViews.get(0);
                return staggeredGridLayoutManager$Span.getLayoutParams((View)view).mFullSpan ^ true;
            }
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        if (!n10) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        n10 = this.mSmoothScrollbarEnabled ^ true;
        View view = this.findFirstVisibleItemClosestToStart(n10 != 0);
        n10 = this.mSmoothScrollbarEnabled ^ true;
        View view2 = this.findFirstVisibleItemClosestToEnd(n10 != 0);
        boolean bl2 = this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollExtent(recyclerView$State, orientationHelper, view, view2, this, bl2);
    }

    private int computeScrollOffset(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        if (!n10) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        n10 = this.mSmoothScrollbarEnabled ^ true;
        View view = this.findFirstVisibleItemClosestToStart(n10 != 0);
        n10 = this.mSmoothScrollbarEnabled ^ true;
        View view2 = this.findFirstVisibleItemClosestToEnd(n10 != 0);
        boolean bl2 = this.mSmoothScrollbarEnabled;
        boolean bl3 = this.mShouldReverseLayout;
        return ScrollbarHelper.computeScrollOffset(recyclerView$State, orientationHelper, view, view2, this, bl2, bl3);
    }

    private int computeScrollRange(RecyclerView$State recyclerView$State) {
        int n10 = this.getChildCount();
        if (!n10) {
            return 0;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        n10 = this.mSmoothScrollbarEnabled ^ true;
        View view = this.findFirstVisibleItemClosestToStart(n10 != 0);
        n10 = this.mSmoothScrollbarEnabled ^ true;
        View view2 = this.findFirstVisibleItemClosestToEnd(n10 != 0);
        boolean bl2 = this.mSmoothScrollbarEnabled;
        return ScrollbarHelper.computeScrollRange(recyclerView$State, orientationHelper, view, view2, this, bl2);
    }

    private int convertFocusDirectionToLayoutDirection(int n10) {
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

    private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFullSpanItemFromEnd(int n10) {
        int n11;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        int[] nArray = new int[this.mSpanCount];
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan = nArray;
        nArray = null;
        for (int i10 = 0; i10 < (n11 = this.mSpanCount); ++i10) {
            int[] nArray2 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan;
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            int n12 = staggeredGridLayoutManager$Span.getEndLine(n10);
            nArray2[i10] = n12 = n10 - n12;
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFullSpanItemFromStart(int n10) {
        int n11;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        int[] nArray = new int[this.mSpanCount];
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan = nArray;
        nArray = null;
        for (int i10 = 0; i10 < (n11 = this.mSpanCount); ++i10) {
            int n12;
            int[] nArray2 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan;
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            nArray2[i10] = n12 = staggeredGridLayoutManager$Span.getStartLine(n10) - n10;
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    private void createOrientationHelpers() {
        OrientationHelper orientationHelper;
        int n10 = this.mOrientation;
        this.mPrimaryOrientation = orientationHelper = OrientationHelper.createOrientationHelper(this, n10);
        n10 = this.mOrientation;
        n10 = 1 - n10;
        this.mSecondaryOrientation = orientationHelper = OrientationHelper.createOrientationHelper(this, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private int fill(RecyclerView$Recycler var1_1, LayoutState var2_2, RecyclerView$State var3_3) {
        var4_4 = this;
        var5_5 = var1_1;
        var6_6 = var2_2;
        var7_7 = this.mRemainingSpans;
        var8_8 = this.mSpanCount;
        var9_9 = 0;
        var10_10 = null;
        var11_11 = 1;
        var7_7.set(0, var8_8, (boolean)var11_11);
        var7_7 = this.mLayoutState;
        var12_12 = var7_7.mInfinite;
        if (var12_12 != 0) {
            var12_12 = var2_2.mLayoutDirection;
            var12_12 = var12_12 == var11_11 ? -1 >>> 1 : -1 << -1;
        } else {
            var12_12 = var2_2.mLayoutDirection;
            if (var12_12 == var11_11) {
                var12_12 = var2_2.mEndLine;
                var8_8 = var2_2.mAvailable;
                var12_12 += var8_8;
            } else {
                var12_12 = var2_2.mStartLine;
                var8_8 = var2_2.mAvailable;
                var12_12 -= var8_8;
            }
        }
        var13_13 = var12_12;
        var12_12 = var6_6.mLayoutDirection;
        var4_4.updateAllRemainingSpans(var12_12, var13_13);
        var12_12 = (int)var4_4.mShouldReverseLayout;
        if (var12_12 != 0) {
            var7_7 = var4_4.mPrimaryOrientation;
            var12_12 = var7_7.getEndAfterPadding();
        } else {
            var7_7 = var4_4.mPrimaryOrientation;
            var12_12 = var7_7.getStartAfterPadding();
        }
        var14_14 = var12_12;
        var12_12 = 0;
        var7_7 = null;
        while (true) {
            var8_8 = (int)var2_2.hasMore(var3_3);
            var15_15 = -1;
            if (var8_8 == 0) break;
            var16_16 = var4_4.mLayoutState;
            var8_8 = (int)var16_16.mInfinite;
            if (var8_8 == 0 && (var8_8 = (int)(var16_16 = var4_4.mRemainingSpans).isEmpty()) != 0) break;
            var17_17 = var6_6.next(var5_5);
            var18_18 /* !! */  = var7_7 = var17_17.getLayoutParams();
            var16_16 = var4_4.mLazySpanLookup;
            var18_18 /* !! */  = (StaggeredGridLayoutManager$LayoutParams)var7_7;
            var12_12 = var18_18 /* !! */ .getViewLayoutPosition();
            var8_8 = var16_16.getSpan(var12_12);
            var19_19 = var8_8 == var15_15 ? var11_11 : 0;
            if (var19_19 != 0) {
                var8_8 = (int)var18_18 /* !! */ .mFullSpan;
                var16_16 = var8_8 != 0 ? var4_4.mSpans[0] : var4_4.getNextSpan(var6_6);
                var20_20 = var4_4.mLazySpanLookup;
                var20_20.setSpan(var12_12, (StaggeredGridLayoutManager$Span)var16_16);
            } else {
                var20_20 = var4_4.mSpans;
                var16_16 = var20_20[var8_8];
            }
            var21_21 = var16_16;
            var18_18 /* !! */ .mSpan = var16_16;
            var8_8 = var6_6.mLayoutDirection;
            if (var8_8 == var11_11) {
                var4_4.addView(var17_17);
            } else {
                var4_4.addView(var17_17, 0);
            }
            var4_4.measureChildWithDecorationsAndMargin(var17_17, (StaggeredGridLayoutManager$LayoutParams)var18_18 /* !! */ , false);
            var8_8 = var6_6.mLayoutDirection;
            if (var8_8 == var11_11) {
                var8_8 = (int)var18_18 /* !! */ .mFullSpan;
                var8_8 = var8_8 != 0 ? var4_4.getMaxEnd(var14_14) : var21_21.getEndLine(var14_14);
                var20_20 = var4_4.mPrimaryOrientation;
                var22_22 = var20_20.getDecoratedMeasurement(var17_17) + var8_8;
                if (var19_19 != 0 && (var23_23 = (int)var18_18 /* !! */ .mFullSpan) != 0) {
                    var24_24 = var4_4.createFullSpanItemFromEnd(var8_8);
                    var24_24.mGapDir = var15_15;
                    var24_24.mPosition = var12_12;
                    var10_10 = var4_4.mLazySpanLookup;
                    var10_10.addFullSpanItem(var24_24);
                }
                var23_23 = var22_22;
                var22_22 = var8_8;
            } else {
                var8_8 = (int)var18_18 /* !! */ .mFullSpan;
                var8_8 = var8_8 != 0 ? var4_4.getMinStart(var14_14) : var21_21.getStartLine(var14_14);
                var20_20 = var4_4.mPrimaryOrientation;
                var22_22 = var20_20.getDecoratedMeasurement(var17_17);
                var22_22 = var8_8 - var22_22;
                if (var19_19 != 0 && (var23_23 = (int)var18_18 /* !! */ .mFullSpan) != 0) {
                    var24_24 = var4_4.createFullSpanItemFromStart(var8_8);
                    var24_24.mGapDir = var11_11;
                    var24_24.mPosition = var12_12;
                    var10_10 = var4_4.mLazySpanLookup;
                    var10_10.addFullSpanItem(var24_24);
                }
                var23_23 = var8_8;
            }
            var8_8 = (int)var18_18 /* !! */ .mFullSpan;
            if (var8_8 != 0 && (var8_8 = var6_6.mItemDirection) == var15_15) {
                if (var19_19 != 0) {
                    var4_4.mLaidOutInvalidFullSpan = var11_11;
                } else {
                    var8_8 = var6_6.mLayoutDirection;
                    var8_8 = var8_8 == var11_11 ? (int)this.areAllEndsEqual() : (int)this.areAllStartsEqual();
                    if ((var8_8 ^= var11_11) != 0) {
                        var16_16 = var4_4.mLazySpanLookup;
                        var7_7 = var16_16.getFullSpanItem(var12_12);
                        if (var7_7 != null) {
                            var7_7.mHasUnwantedGapAfter = var11_11;
                        }
                        var4_4.mLaidOutInvalidFullSpan = var11_11;
                    }
                }
            }
            var4_4.attachViewToSpans(var17_17, (StaggeredGridLayoutManager$LayoutParams)var18_18 /* !! */ , var6_6);
            var12_12 = (int)this.isLayoutRTL();
            if (var12_12 != 0 && (var12_12 = var4_4.mOrientation) == var11_11) {
                var12_12 = (int)var18_18 /* !! */ .mFullSpan;
                if (var12_12 != 0) {
                    var7_7 = var4_4.mSecondaryOrientation;
                    var12_12 = var7_7.getEndAfterPadding();
                } else {
                    var7_7 = var4_4.mSecondaryOrientation;
                    var12_12 = var7_7.getEndAfterPadding();
                    var8_8 = var4_4.mSpanCount - var11_11;
                    var15_15 = var21_21.mIndex;
                    var8_8 -= var15_15;
                    var15_15 = var4_4.mSizePerSpan;
                    var12_12 -= (var8_8 *= var15_15);
                }
                var16_16 = var4_4.mSecondaryOrientation;
                var8_8 = var16_16.getDecoratedMeasurement(var17_17);
                var8_8 = var12_12 - var8_8;
                var9_9 = var12_12;
                var19_19 = var8_8;
            } else {
                var12_12 = (int)var18_18 /* !! */ .mFullSpan;
                if (var12_12 != 0) {
                    var7_7 = var4_4.mSecondaryOrientation;
                    var12_12 = var7_7.getStartAfterPadding();
                } else {
                    var12_12 = var21_21.mIndex;
                    var8_8 = var4_4.mSizePerSpan;
                    var12_12 *= var8_8;
                    var16_16 = var4_4.mSecondaryOrientation;
                    var8_8 = var16_16.getStartAfterPadding();
                    var12_12 += var8_8;
                }
                var16_16 = var4_4.mSecondaryOrientation;
                var8_8 = var16_16.getDecoratedMeasurement(var17_17) + var12_12;
                var19_19 = var12_12;
                var9_9 = var8_8;
            }
            var12_12 = var4_4.mOrientation;
            if (var12_12 == var11_11) {
                var7_7 = this;
                var16_16 = var17_17;
                var15_15 = var19_19;
                var19_19 = var22_22;
                var22_22 = var9_9;
                this.layoutDecoratedWithMargins(var17_17, var15_15, var19_19, var9_9, var23_23);
            } else {
                var7_7 = this;
                var16_16 = var17_17;
                var15_15 = var22_22;
                var22_22 = var23_23;
                var23_23 = var9_9;
                this.layoutDecoratedWithMargins(var17_17, var15_15, var19_19, var22_22, var9_9);
            }
            var12_12 = (int)var18_18 /* !! */ .mFullSpan;
            if (var12_12 != 0) {
                var7_7 = var4_4.mLayoutState;
                var12_12 = var7_7.mLayoutDirection;
                var4_4.updateAllRemainingSpans(var12_12, var13_13);
            } else {
                var7_7 = var4_4.mLayoutState;
                var12_12 = var7_7.mLayoutDirection;
                var4_4.updateRemainingSpans((StaggeredGridLayoutManager$Span)var21_21, var12_12, var13_13);
            }
            var7_7 = var4_4.mLayoutState;
            var4_4.recycle(var5_5, (LayoutState)var7_7);
            var7_7 = var4_4.mLayoutState;
            var12_12 = (int)var7_7.mStopInFocusable;
            if (var12_12 == 0 || (var12_12 = (int)var17_17.hasFocusable()) == 0) ** GOTO lbl182
            var12_12 = (int)var18_18 /* !! */ .mFullSpan;
            if (var12_12 == 0) {
                var7_7 = var4_4.mRemainingSpans;
                var8_8 = var21_21.mIndex;
                var19_19 = 0;
                var7_7.set(var8_8, false);
            } else {
                var7_7 = var4_4.mRemainingSpans;
                var7_7.clear();
lbl182:
                // 2 sources

                var19_19 = 0;
            }
            var9_9 = 0;
            var10_10 = null;
            var12_12 = var11_11;
        }
        var19_19 = 0;
        if (var12_12 == 0) {
            var7_7 = var4_4.mLayoutState;
            var4_4.recycle(var5_5, (LayoutState)var7_7);
        }
        var7_7 = var4_4.mLayoutState;
        var12_12 = var7_7.mLayoutDirection;
        if (var12_12 == var15_15) {
            var7_7 = var4_4.mPrimaryOrientation;
            var12_12 = var7_7.getStartAfterPadding();
            var12_12 = var4_4.getMinStart(var12_12);
            var16_16 = var4_4.mPrimaryOrientation;
            var8_8 = var16_16.getStartAfterPadding() - var12_12;
        } else {
            var7_7 = var4_4.mPrimaryOrientation;
            var12_12 = var7_7.getEndAfterPadding();
            var12_12 = var4_4.getMaxEnd(var12_12);
            var16_16 = var4_4.mPrimaryOrientation;
            var8_8 = var16_16.getEndAfterPadding();
            var8_8 = var12_12 - var8_8;
        }
        if (var8_8 > 0) {
            var12_12 = var6_6.mAvailable;
            var9_9 = Math.min(var12_12, var8_8);
        } else {
            var9_9 = 0;
            var10_10 = null;
        }
        return var9_9;
    }

    private int findFirstReferenceChildPosition(int n10) {
        int n11 = this.getChildCount();
        for (int i10 = 0; i10 < n11; ++i10) {
            View view = this.getChildAt(i10);
            int n12 = this.getPosition(view);
            if (n12 < 0 || n12 >= n10) continue;
            return n12;
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int n10) {
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            View view = this.getChildAt(i10);
            int n11 = this.getPosition(view);
            if (n11 < 0 || n11 >= n10) continue;
            return n11;
        }
        return 0;
    }

    private void fixEndGap(RecyclerView$Recycler object, RecyclerView$State recyclerView$State, boolean bl2) {
        int n10 = -1 << -1;
        int n11 = this.getMaxEnd(n10);
        if (n11 == n10) {
            return;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        n10 = orientationHelper.getEndAfterPadding() - n11;
        if (n10 > 0) {
            n11 = -n10;
            int n12 = -this.scrollBy(n11, (RecyclerView$Recycler)object, recyclerView$State);
            if (bl2 && (n10 -= n12) > 0) {
                object = this.mPrimaryOrientation;
                ((OrientationHelper)object).offsetChildren(n10);
            }
        }
    }

    private void fixStartGap(RecyclerView$Recycler object, RecyclerView$State recyclerView$State, boolean bl2) {
        int n10 = -1 >>> 1;
        int n11 = this.getMinStart(n10);
        if (n11 == n10) {
            return;
        }
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        n10 = orientationHelper.getStartAfterPadding();
        if ((n11 -= n10) > 0) {
            int n12 = this.scrollBy(n11, (RecyclerView$Recycler)object, recyclerView$State);
            if (bl2 && (n11 -= n12) > 0) {
                object = this.mPrimaryOrientation;
                int n13 = -n11;
                ((OrientationHelper)object).offsetChildren(n13);
            }
        }
    }

    private int getMaxEnd(int n10) {
        int n11;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[0];
        int n12 = staggeredGridLayoutManager$Span.getEndLine(n10);
        for (int i10 = 1; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i10];
            n11 = staggeredGridLayoutManager$Span2.getEndLine(n10);
            if (n11 <= n12) continue;
            n12 = n11;
        }
        return n12;
    }

    private int getMaxStart(int n10) {
        int n11;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[0];
        int n12 = staggeredGridLayoutManager$Span.getStartLine(n10);
        for (int i10 = 1; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i10];
            n11 = staggeredGridLayoutManager$Span2.getStartLine(n10);
            if (n11 <= n12) continue;
            n12 = n11;
        }
        return n12;
    }

    private int getMinEnd(int n10) {
        int n11;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[0];
        int n12 = staggeredGridLayoutManager$Span.getEndLine(n10);
        for (int i10 = 1; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i10];
            n11 = staggeredGridLayoutManager$Span2.getEndLine(n10);
            if (n11 >= n12) continue;
            n12 = n11;
        }
        return n12;
    }

    private int getMinStart(int n10) {
        int n11;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[0];
        int n12 = staggeredGridLayoutManager$Span.getStartLine(n10);
        for (int i10 = 1; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i10];
            n11 = staggeredGridLayoutManager$Span2.getStartLine(n10);
            if (n11 >= n12) continue;
            n12 = n11;
        }
        return n12;
    }

    private StaggeredGridLayoutManager$Span getNextSpan(LayoutState layoutState) {
        int n10;
        int n11 = layoutState.mLayoutDirection;
        n11 = (int)(this.preferLastSpan(n11) ? 1 : 0);
        int n12 = -1;
        int n13 = 1;
        if (n11 != 0) {
            n11 = this.mSpanCount - n13;
            n10 = n12;
        } else {
            n11 = 0;
            n12 = this.mSpanCount;
            n10 = n13;
        }
        int n14 = layoutState.mLayoutDirection;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = null;
        if (n14 == n13) {
            n14 = -1 >>> 1;
            OrientationHelper orientationHelper = this.mPrimaryOrientation;
            n13 = orientationHelper.getStartAfterPadding();
            while (n11 != n12) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[n11];
                int n15 = staggeredGridLayoutManager$Span2.getEndLine(n13);
                if (n15 < n14) {
                    staggeredGridLayoutManager$Span = staggeredGridLayoutManager$Span2;
                    n14 = n15;
                }
                n11 += n10;
            }
            return staggeredGridLayoutManager$Span;
        }
        n14 = -1 << -1;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        n13 = orientationHelper.getEndAfterPadding();
        while (n11 != n12) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span3 = this.mSpans[n11];
            int n16 = staggeredGridLayoutManager$Span3.getStartLine(n13);
            if (n16 > n14) {
                staggeredGridLayoutManager$Span = staggeredGridLayoutManager$Span3;
                n14 = n16;
            }
            n11 += n10;
        }
        return staggeredGridLayoutManager$Span;
    }

    private void handleUpdate(int n10, int n11, int n12) {
        int n13;
        int n14;
        int n15;
        int n16;
        block10: {
            block9: {
                block7: {
                    block8: {
                        n16 = this.mShouldReverseLayout;
                        n16 = n16 != 0 ? this.getLastChildPosition() : this.getFirstChildPosition();
                        n15 = 8;
                        if (n12 != n15) break block7;
                        if (n10 >= n11) break block8;
                        n14 = n11 + 1;
                        break block9;
                    }
                    n14 = n10 + 1;
                    n13 = n11;
                    break block10;
                }
                n14 = n10 + n11;
            }
            n13 = n10;
        }
        StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup = this.mLazySpanLookup;
        staggeredGridLayoutManager$LazySpanLookup.invalidateAfter(n13);
        int n17 = 1;
        if (n12 != n17) {
            int n18 = 2;
            if (n12 != n18) {
                if (n12 == n15) {
                    StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup2 = this.mLazySpanLookup;
                    staggeredGridLayoutManager$LazySpanLookup2.offsetForRemoval(n10, n17);
                    StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup3 = this.mLazySpanLookup;
                    staggeredGridLayoutManager$LazySpanLookup3.offsetForAddition(n11, n17);
                }
            } else {
                StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup4 = this.mLazySpanLookup;
                staggeredGridLayoutManager$LazySpanLookup4.offsetForRemoval(n10, n11);
            }
        } else {
            StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup5 = this.mLazySpanLookup;
            staggeredGridLayoutManager$LazySpanLookup5.offsetForAddition(n10, n11);
        }
        if (n14 <= n16) {
            return;
        }
        n10 = (int)(this.mShouldReverseLayout ? 1 : 0);
        n10 = n10 != 0 ? this.getFirstChildPosition() : this.getLastChildPosition();
        if (n13 <= n10) {
            this.requestLayout();
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, int n10, int n11, boolean bl2) {
        Object object = this.mTmpRect;
        this.calculateItemDecorationsForChild(view, (Rect)object);
        object = (StaggeredGridLayoutManager$LayoutParams)view.getLayoutParams();
        int n12 = object.leftMargin;
        Rect rect = this.mTmpRect;
        int n13 = rect.left;
        n12 += n13;
        n13 = object.rightMargin;
        int n14 = rect.right;
        n10 = this.updateSpecWithExtra(n10, n12, n13 += n14);
        n12 = object.topMargin;
        rect = this.mTmpRect;
        n13 = rect.top;
        n12 += n13;
        n13 = object.bottomMargin;
        n14 = rect.bottom;
        n11 = this.updateSpecWithExtra(n11, n12, n13 += n14);
        bl2 = bl2 ? this.shouldReMeasureChild(view, n10, n11, (RecyclerView$LayoutParams)((Object)object)) : this.shouldMeasureChild(view, n10, n11, (RecyclerView$LayoutParams)((Object)object));
        if (bl2) {
            view.measure(n10, n11);
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams, boolean bl2) {
        int n10 = staggeredGridLayoutManager$LayoutParams.mFullSpan;
        int n11 = 1;
        if (n10 != 0) {
            n10 = this.mOrientation;
            if (n10 == n11) {
                n10 = this.mFullSizeSpec;
                int n12 = this.getHeight();
                int n13 = this.getHeightMode();
                int n14 = this.getPaddingTop();
                int n15 = this.getPaddingBottom();
                int n16 = staggeredGridLayoutManager$LayoutParams.height;
                n16 = RecyclerView$LayoutManager.getChildMeasureSpec(n12, n13, n14 += n15, n16, n11 != 0);
                this.measureChildWithDecorationsAndMargin(view, n10, n16, bl2);
            } else {
                n10 = this.getWidth();
                int n17 = this.getWidthMode();
                int n18 = this.getPaddingLeft();
                int n19 = this.getPaddingRight();
                int n20 = staggeredGridLayoutManager$LayoutParams.width;
                n20 = RecyclerView$LayoutManager.getChildMeasureSpec(n10, n17, n18 += n19, n20, n11 != 0);
                n10 = this.mFullSizeSpec;
                this.measureChildWithDecorationsAndMargin(view, n20, n10, bl2);
            }
        } else {
            n10 = this.mOrientation;
            int n21 = 0;
            if (n10 == n11) {
                n10 = this.mSizePerSpan;
                int n22 = this.getWidthMode();
                int n23 = staggeredGridLayoutManager$LayoutParams.width;
                n10 = RecyclerView$LayoutManager.getChildMeasureSpec(n10, n22, 0, n23, false);
                n21 = this.getHeight();
                n22 = this.getHeightMode();
                n23 = this.getPaddingTop();
                int n24 = this.getPaddingBottom();
                int n25 = staggeredGridLayoutManager$LayoutParams.height;
                n25 = RecyclerView$LayoutManager.getChildMeasureSpec(n21, n22, n23 += n24, n25, n11 != 0);
                this.measureChildWithDecorationsAndMargin(view, n10, n25, bl2);
            } else {
                n10 = this.getWidth();
                int n26 = this.getWidthMode();
                int n27 = this.getPaddingLeft();
                int n28 = this.getPaddingRight();
                n27 += n28;
                n28 = staggeredGridLayoutManager$LayoutParams.width;
                n10 = RecyclerView$LayoutManager.getChildMeasureSpec(n10, n26, n27, n28, n11 != 0);
                n11 = this.mSizePerSpan;
                n26 = this.getHeightMode();
                int n29 = staggeredGridLayoutManager$LayoutParams.height;
                n29 = RecyclerView$LayoutManager.getChildMeasureSpec(n11, n26, 0, n29, false);
                this.measureChildWithDecorationsAndMargin(view, n10, n29, bl2);
            }
        }
    }

    private void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean n10) {
        Object object;
        int n11;
        StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo;
        block28: {
            block27: {
                int n12;
                int n13;
                Object object2;
                int n14;
                staggeredGridLayoutManager$AnchorInfo = this.mAnchorInfo;
                Object object3 = this.mPendingSavedState;
                int n15 = -1;
                if ((object3 != null || (n14 = this.mPendingScrollPosition) != n15) && (n14 = recyclerView$State.getItemCount()) == 0) {
                    this.removeAndRecycleAllViews(recyclerView$Recycler);
                    staggeredGridLayoutManager$AnchorInfo.reset();
                    return;
                }
                n14 = (int)(staggeredGridLayoutManager$AnchorInfo.mValid ? 1 : 0);
                n11 = 1;
                if (n14 != 0 && (n14 = this.mPendingScrollPosition) == n15 && (object3 = this.mPendingSavedState) == null) {
                    n14 = 0;
                    object3 = null;
                } else {
                    n14 = n11;
                }
                if (n14 != 0) {
                    staggeredGridLayoutManager$AnchorInfo.reset();
                    object2 = this.mPendingSavedState;
                    if (object2 != null) {
                        this.applyPendingSavedState(staggeredGridLayoutManager$AnchorInfo);
                    } else {
                        this.resolveShouldLayoutReverse();
                        n13 = (int)(this.mShouldReverseLayout ? 1 : 0);
                        staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd = n13;
                    }
                    this.updateAnchorInfoForLayout(recyclerView$State, staggeredGridLayoutManager$AnchorInfo);
                    staggeredGridLayoutManager$AnchorInfo.mValid = n11;
                }
                if ((object2 = this.mPendingSavedState) == null && (n13 = this.mPendingScrollPosition) == n15 && ((n13 = (int)(staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0)) != (n12 = this.mLastLayoutFromEnd) || (n13 = (int)(this.isLayoutRTL() ? 1 : 0)) != (n12 = (int)(this.mLastLayoutRTL ? 1 : 0)))) {
                    object2 = this.mLazySpanLookup;
                    ((StaggeredGridLayoutManager$LazySpanLookup)object2).clear();
                    staggeredGridLayoutManager$AnchorInfo.mInvalidateOffsets = n11;
                }
                if ((n13 = this.getChildCount()) > 0 && ((object2 = this.mPendingSavedState) == null || (n13 = ((StaggeredGridLayoutManager$SavedState)object2).mSpanOffsetsSize) < n11)) {
                    n13 = (int)(staggeredGridLayoutManager$AnchorInfo.mInvalidateOffsets ? 1 : 0);
                    if (n13 != 0) {
                        object3 = null;
                        for (n14 = 0; n14 < (n13 = this.mSpanCount); ++n14) {
                            object2 = this.mSpans[n14];
                            ((StaggeredGridLayoutManager$Span)object2).clear();
                            n13 = staggeredGridLayoutManager$AnchorInfo.mOffset;
                            n12 = -1 << -1;
                            if (n13 == n12) continue;
                            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[n14];
                            staggeredGridLayoutManager$Span.setLine(n13);
                        }
                    } else if (n14 == 0 && (object3 = (Object)this.mAnchorInfo.mSpanReferenceLines) != null) {
                        object3 = null;
                        for (n14 = 0; n14 < (n13 = this.mSpanCount); ++n14) {
                            object2 = this.mSpans[n14];
                            ((StaggeredGridLayoutManager$Span)object2).clear();
                            int[] nArray = this.mAnchorInfo.mSpanReferenceLines;
                            n12 = nArray[n14];
                            ((StaggeredGridLayoutManager$Span)object2).setLine(n12);
                        }
                    } else {
                        object3 = null;
                        for (n14 = 0; n14 < (n13 = this.mSpanCount); ++n14) {
                            object2 = this.mSpans[n14];
                            n12 = (int)(this.mShouldReverseLayout ? 1 : 0);
                            int n16 = staggeredGridLayoutManager$AnchorInfo.mOffset;
                            ((StaggeredGridLayoutManager$Span)object2).cacheReferenceLineAndClear(n12 != 0, n16);
                        }
                        object3 = this.mAnchorInfo;
                        object2 = this.mSpans;
                        ((StaggeredGridLayoutManager$AnchorInfo)object3).saveSpanReferenceLines((StaggeredGridLayoutManager$Span[])object2);
                    }
                }
                this.detachAndScrapAttachedViews(recyclerView$Recycler);
                this.mLayoutState.mRecycle = false;
                this.mLaidOutInvalidFullSpan = false;
                object3 = this.mSecondaryOrientation;
                n14 = ((OrientationHelper)object3).getTotalSpace();
                this.updateMeasureSpecs(n14);
                n14 = staggeredGridLayoutManager$AnchorInfo.mPosition;
                this.updateLayoutState(n14, recyclerView$State);
                n14 = (int)(staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0);
                if (n14 != 0) {
                    this.setLayoutStateDirection(n15);
                    object3 = this.mLayoutState;
                    this.fill(recyclerView$Recycler, (LayoutState)object3, recyclerView$State);
                    this.setLayoutStateDirection(n11);
                    object3 = this.mLayoutState;
                    n15 = staggeredGridLayoutManager$AnchorInfo.mPosition;
                    n13 = ((LayoutState)object3).mItemDirection;
                    ((LayoutState)object3).mCurrentPosition = n15 += n13;
                    this.fill(recyclerView$Recycler, (LayoutState)object3, recyclerView$State);
                } else {
                    this.setLayoutStateDirection(n11);
                    object3 = this.mLayoutState;
                    this.fill(recyclerView$Recycler, (LayoutState)object3, recyclerView$State);
                    this.setLayoutStateDirection(n15);
                    object3 = this.mLayoutState;
                    n15 = staggeredGridLayoutManager$AnchorInfo.mPosition;
                    n13 = ((LayoutState)object3).mItemDirection;
                    ((LayoutState)object3).mCurrentPosition = n15 += n13;
                    this.fill(recyclerView$Recycler, (LayoutState)object3, recyclerView$State);
                }
                this.repositionToWrapContentIfNecessary();
                n14 = this.getChildCount();
                if (n14 > 0) {
                    n14 = (int)(this.mShouldReverseLayout ? 1 : 0);
                    if (n14 != 0) {
                        this.fixEndGap(recyclerView$Recycler, recyclerView$State, n11 != 0);
                        this.fixStartGap(recyclerView$Recycler, recyclerView$State, false);
                    } else {
                        this.fixStartGap(recyclerView$Recycler, recyclerView$State, n11 != 0);
                        this.fixEndGap(recyclerView$Recycler, recyclerView$State, false);
                    }
                }
                if (n10 == 0 || (n10 = recyclerView$State.isPreLayout()) != 0) break block27;
                n10 = this.mGapStrategy;
                if (n10 != 0 && (n10 = this.getChildCount()) > 0 && ((n10 = (int)(this.mLaidOutInvalidFullSpan ? 1 : 0)) != 0 || (object = this.hasGapsToFix()) != null)) {
                    n10 = n11;
                } else {
                    n10 = 0;
                    object = null;
                }
                if (n10 == 0) break block27;
                object = this.mCheckForGapsRunnable;
                this.removeCallbacks((Runnable)object);
                n10 = (int)(this.checkForGaps() ? 1 : 0);
                if (n10 != 0) break block28;
            }
            n11 = 0;
        }
        n10 = recyclerView$State.isPreLayout();
        if (n10 != 0) {
            object = this.mAnchorInfo;
            ((StaggeredGridLayoutManager$AnchorInfo)object).reset();
        }
        this.mLastLayoutFromEnd = n10 = staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd;
        n10 = (int)(this.isLayoutRTL() ? 1 : 0);
        this.mLastLayoutRTL = n10;
        if (n11 != 0) {
            object = this.mAnchorInfo;
            ((StaggeredGridLayoutManager$AnchorInfo)object).reset();
            this.onLayoutChildren(recyclerView$Recycler, recyclerView$State, false);
        }
    }

    private boolean preferLastSpan(int n10) {
        int n11 = this.mOrientation;
        int n12 = -1;
        int n13 = 1;
        if (n11 == 0) {
            if ((n10 = n10 == n12 ? n13 : 0) == (n11 = (int)(this.mShouldReverseLayout ? 1 : 0))) {
                n13 = 0;
            }
            return n13 != 0;
        }
        n10 = n10 == n12 ? n13 : 0;
        n11 = (int)(this.mShouldReverseLayout ? 1 : 0);
        if ((n10 = n10 == n11 ? n13 : 0) != (n11 = (int)(this.isLayoutRTL() ? 1 : 0))) {
            n13 = 0;
        }
        return n13 != 0;
    }

    private void prependViewToAllSpans(View view) {
        for (int i10 = this.mSpanCount + -1; i10 >= 0; i10 += -1) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            staggeredGridLayoutManager$Span.prependToSpan(view);
        }
    }

    private void recycle(RecyclerView$Recycler recyclerView$Recycler, LayoutState layoutState) {
        int n10 = layoutState.mRecycle;
        if (n10 != 0 && (n10 = layoutState.mInfinite) == 0) {
            n10 = layoutState.mAvailable;
            int n11 = -1;
            if (n10 == 0) {
                n10 = layoutState.mLayoutDirection;
                if (n10 == n11) {
                    int n12 = layoutState.mEndLine;
                    this.recycleFromEnd(recyclerView$Recycler, n12);
                } else {
                    int n13 = layoutState.mStartLine;
                    this.recycleFromStart(recyclerView$Recycler, n13);
                }
            } else {
                n10 = layoutState.mLayoutDirection;
                if (n10 == n11) {
                    int n14;
                    n10 = layoutState.mStartLine;
                    if ((n10 -= (n11 = this.getMaxStart(n10))) < 0) {
                        n14 = layoutState.mEndLine;
                    } else {
                        n11 = layoutState.mEndLine;
                        n14 = layoutState.mAvailable;
                        n14 = Math.min(n10, n14);
                        n14 = n11 - n14;
                    }
                    this.recycleFromEnd(recyclerView$Recycler, n14);
                } else {
                    int n15;
                    n10 = layoutState.mEndLine;
                    n10 = this.getMinEnd(n10);
                    n11 = layoutState.mEndLine;
                    if ((n10 -= n11) < 0) {
                        n15 = layoutState.mStartLine;
                    } else {
                        n11 = layoutState.mStartLine;
                        n15 = layoutState.mAvailable;
                        n15 = Math.min(n10, n15) + n11;
                    }
                    this.recycleFromStart(recyclerView$Recycler, n15);
                }
            }
        }
    }

    private void recycleFromEnd(RecyclerView$Recycler recyclerView$Recycler, int n10) {
        View view;
        Object object;
        int n11;
        int n12 = this.getChildCount();
        int n13 = 1;
        n12 -= n13;
        while (n12 >= 0 && (n11 = ((OrientationHelper)(object = this.mPrimaryOrientation)).getDecoratedStart(view = this.getChildAt(n12))) >= n10 && (n11 = ((OrientationHelper)(object = this.mPrimaryOrientation)).getTransformedStartWithDecoration(view)) >= n10) {
            Object object2;
            object = (StaggeredGridLayoutManager$LayoutParams)view.getLayoutParams();
            int n14 = ((StaggeredGridLayoutManager$LayoutParams)object).mFullSpan;
            if (n14 != 0) {
                int n15;
                n11 = 0;
                object = null;
                object2 = null;
                for (n14 = 0; n14 < (n15 = this.mSpanCount); ++n14) {
                    ArrayList arrayList = this.mSpans[n14].mViews;
                    n15 = arrayList.size();
                    if (n15 != n13) continue;
                    return;
                }
                while (n11 < (n14 = this.mSpanCount)) {
                    object2 = this.mSpans[n11];
                    ((StaggeredGridLayoutManager$Span)object2).popEnd();
                    ++n11;
                }
            } else {
                object2 = object.mSpan.mViews;
                n14 = ((ArrayList)object2).size();
                if (n14 == n13) {
                    return;
                }
                object = ((StaggeredGridLayoutManager$LayoutParams)object).mSpan;
                ((StaggeredGridLayoutManager$Span)object).popEnd();
            }
            this.removeAndRecycleView(view, recyclerView$Recycler);
            n12 += -1;
        }
    }

    private void recycleFromStart(RecyclerView$Recycler recyclerView$Recycler, int n10) {
        int n11;
        while ((n11 = this.getChildCount()) > 0) {
            n11 = 0;
            Object object = null;
            Object object2 = this.mPrimaryOrientation;
            View view = this.getChildAt(0);
            int n12 = ((OrientationHelper)object2).getDecoratedEnd(view);
            if (n12 > n10 || (n12 = ((OrientationHelper)(object2 = this.mPrimaryOrientation)).getTransformedEndWithDecoration(view)) > n10) break;
            object2 = (StaggeredGridLayoutManager$LayoutParams)view.getLayoutParams();
            int n13 = ((StaggeredGridLayoutManager$LayoutParams)object2).mFullSpan;
            int n14 = 1;
            if (n13 != 0) {
                object2 = null;
                for (n12 = 0; n12 < (n13 = this.mSpanCount); ++n12) {
                    ArrayList arrayList = this.mSpans[n12].mViews;
                    n13 = arrayList.size();
                    if (n13 != n14) continue;
                    return;
                }
                while (n11 < (n12 = this.mSpanCount)) {
                    object2 = this.mSpans[n11];
                    ((StaggeredGridLayoutManager$Span)object2).popStart();
                    ++n11;
                }
            } else {
                object = object2.mSpan.mViews;
                n11 = ((ArrayList)object).size();
                if (n11 == n14) {
                    return;
                }
                object = ((StaggeredGridLayoutManager$LayoutParams)object2).mSpan;
                ((StaggeredGridLayoutManager$Span)object).popStart();
            }
            this.removeAndRecycleView(view, recyclerView$Recycler);
        }
    }

    private void repositionToWrapContentIfNecessary() {
        float f10;
        int n10;
        Object object;
        float f11;
        int n11;
        Object object2;
        int n12;
        int n13;
        OrientationHelper orientationHelper = this.mSecondaryOrientation;
        int n14 = orientationHelper.getMode();
        if (n14 == (n13 = 0x40000000)) {
            return;
        }
        n14 = 0;
        float f12 = 0.0f;
        orientationHelper = null;
        n13 = this.getChildCount();
        int n15 = 0;
        for (n12 = 0; n12 < n13; ++n12) {
            OrientationHelper orientationHelper2 = this.mSecondaryOrientation;
            object2 = this.getChildAt(n12);
            n11 = orientationHelper2.getDecoratedMeasurement((View)object2);
            f11 = n11;
            float f13 = f11 - f12;
            object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object < 0) continue;
            n10 = (int)((object2 = (StaggeredGridLayoutManager$LayoutParams)object2.getLayoutParams()).isFullSpan() ? 1 : 0);
            if (n10 != 0) {
                f11 *= 1.0f;
                n10 = this.mSpanCount;
                f10 = n10;
                f11 /= f10;
            }
            f12 = Math.max(f12, f11);
        }
        n12 = this.mSizePerSpan;
        f10 = this.mSpanCount;
        n14 = Math.round(f12 *= f10);
        object2 = this.mSecondaryOrientation;
        n10 = object2.getMode();
        n11 = -1 << -1;
        f11 = -0.0f;
        if (n10 == n11) {
            object2 = this.mSecondaryOrientation;
            n10 = object2.getTotalSpace();
            n14 = Math.min(n14, n10);
        }
        this.updateMeasureSpecs(n14);
        n14 = this.mSizePerSpan;
        if (n14 == n12) {
            return;
        }
        while (n15 < n13) {
            orientationHelper = this.getChildAt(n15);
            object2 = (StaggeredGridLayoutManager$LayoutParams)orientationHelper.getLayoutParams();
            n11 = (int)(object2.mFullSpan ? 1 : 0);
            if (n11 == 0) {
                int n16;
                n11 = (int)(this.isLayoutRTL() ? 1 : 0);
                object = true;
                if (n11 != 0 && (n11 = this.mOrientation) == object) {
                    n11 = this.mSpanCount;
                    n16 = n11 + -1;
                    object2 = object2.mSpan;
                    n10 = object2.mIndex;
                    n16 = -(n16 - n10);
                    int n17 = this.mSizePerSpan;
                    n16 *= n17;
                    n11 = n11 - object - n10;
                    n10 = -n11 * n12;
                    orientationHelper.offsetLeftAndRight(n16 -= n10);
                } else {
                    object2 = object2.mSpan;
                    n10 = object2.mIndex;
                    n11 = this.mSizePerSpan * n10;
                    n10 *= n12;
                    n16 = this.mOrientation;
                    if (n16 == object) {
                        orientationHelper.offsetLeftAndRight(n11 -= n10);
                    } else {
                        orientationHelper.offsetTopAndBottom(n11 -= n10);
                    }
                }
            }
            ++n15;
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

    private void setLayoutStateDirection(int n10) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = n10;
        int n11 = this.mShouldReverseLayout;
        int n12 = 1;
        int n13 = -1;
        float f10 = 0.0f / 0.0f;
        if (n11 != (n10 = n10 == n13 ? n12 : 0)) {
            n12 = n13;
        }
        layoutState.mItemDirection = n12;
    }

    private void updateAllRemainingSpans(int n10, int n11) {
        int n12;
        for (int i10 = 0; i10 < (n12 = this.mSpanCount); ++i10) {
            Object object = this.mSpans[i10].mViews;
            n12 = (int)(((ArrayList)object).isEmpty() ? 1 : 0);
            if (n12 != 0) continue;
            object = this.mSpans[i10];
            this.updateRemainingSpans((StaggeredGridLayoutManager$Span)object, n10, n11);
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView$State recyclerView$State, StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        int n10;
        boolean bl2 = this.mLastLayoutFromEnd;
        if (bl2) {
            n10 = recyclerView$State.getItemCount();
            n10 = this.findLastReferenceChildPosition(n10);
        } else {
            n10 = recyclerView$State.getItemCount();
            n10 = this.findFirstReferenceChildPosition(n10);
        }
        staggeredGridLayoutManager$AnchorInfo.mPosition = n10;
        staggeredGridLayoutManager$AnchorInfo.mOffset = -1 << -1;
        return true;
    }

    private void updateLayoutState(int n10, RecyclerView$State object) {
        Object object2;
        int n11;
        Object object3 = this.mLayoutState;
        int n12 = 0;
        ((LayoutState)object3).mAvailable = 0;
        ((LayoutState)object3).mCurrentPosition = n10;
        int n13 = this.isSmoothScrolling();
        int n14 = 1;
        if (n13 != 0 && (n11 = ((RecyclerView$State)object).getTargetScrollPosition()) != (n13 = -1)) {
            n13 = (int)(this.mShouldReverseLayout ? 1 : 0);
            if (n11 < n10) {
                n10 = n14;
            } else {
                n10 = 0;
                object2 = null;
            }
            if (n13 == n10) {
                object2 = this.mPrimaryOrientation;
                n10 = ((OrientationHelper)object2).getTotalSpace();
                n11 = 0;
                object = null;
            } else {
                n11 = this.mPrimaryOrientation.getTotalSpace();
                n10 = 0;
                object2 = null;
            }
        } else {
            n10 = 0;
            object2 = null;
            n11 = 0;
            object = null;
        }
        n13 = (int)(this.getClipToPadding() ? 1 : 0);
        if (n13 != 0) {
            int n15;
            object3 = this.mLayoutState;
            OrientationHelper orientationHelper = this.mPrimaryOrientation;
            ((LayoutState)object3).mStartLine = n15 = orientationHelper.getStartAfterPadding() - n11;
            object = this.mLayoutState;
            object3 = this.mPrimaryOrientation;
            ((LayoutState)object).mEndLine = n13 = ((OrientationHelper)object3).getEndAfterPadding() + n10;
        } else {
            int n16;
            object3 = this.mLayoutState;
            OrientationHelper orientationHelper = this.mPrimaryOrientation;
            ((LayoutState)object3).mEndLine = n16 = orientationHelper.getEnd() + n10;
            object2 = this.mLayoutState;
            ((LayoutState)object2).mStartLine = n11 = -n11;
        }
        object2 = this.mLayoutState;
        ((LayoutState)object2).mStopInFocusable = false;
        ((LayoutState)object2).mRecycle = n14;
        object = this.mPrimaryOrientation;
        n11 = ((OrientationHelper)object).getMode();
        if (n11 == 0 && (n11 = ((OrientationHelper)(object = this.mPrimaryOrientation)).getEnd()) == 0) {
            n12 = n14;
        }
        ((LayoutState)object2).mInfinite = n12;
    }

    private void updateRemainingSpans(StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span, int n10, int n11) {
        int n12 = staggeredGridLayoutManager$Span.getDeletedSize();
        int n13 = -1;
        if (n10 == n13) {
            n10 = staggeredGridLayoutManager$Span.getStartLine() + n12;
            if (n10 <= n11) {
                BitSet bitSet = this.mRemainingSpans;
                int n14 = staggeredGridLayoutManager$Span.mIndex;
                bitSet.set(n14, false);
            }
        } else {
            n10 = staggeredGridLayoutManager$Span.getEndLine() - n12;
            if (n10 >= n11) {
                BitSet bitSet = this.mRemainingSpans;
                int n15 = staggeredGridLayoutManager$Span.mIndex;
                bitSet.set(n15, false);
            }
        }
    }

    private int updateSpecWithExtra(int n10, int n11, int n12) {
        int n13;
        if (n11 == 0 && n12 == 0) {
            return n10;
        }
        int n14 = View.MeasureSpec.getMode((int)n10);
        if (n14 != (n13 = -1 << -1) && n14 != (n13 = 0x40000000)) {
            return n10;
        }
        n10 = View.MeasureSpec.getSize((int)n10) - n11 - n12;
        return View.MeasureSpec.makeMeasureSpec((int)Math.max(0, n10), (int)n14);
    }

    public boolean areAllEndsEqual() {
        int n10;
        int n11;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[0];
        int n12 = -1 << -1;
        int n13 = staggeredGridLayoutManager$Span.getEndLine(n12);
        for (int i10 = n10 = 1; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i10];
            n11 = staggeredGridLayoutManager$Span2.getEndLine(n12);
            if (n11 == n13) continue;
            return false;
        }
        return n10 != 0;
    }

    public boolean areAllStartsEqual() {
        int n10;
        int n11;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[0];
        int n12 = -1 << -1;
        int n13 = staggeredGridLayoutManager$Span.getStartLine(n12);
        for (int i10 = n10 = 1; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i10];
            n11 = staggeredGridLayoutManager$Span2.getStartLine(n12);
            if (n11 == n13) continue;
            return false;
        }
        return n10 != 0;
    }

    public void assertNotInLayoutOrScroll(String string2) {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState == null) {
            super.assertNotInLayoutOrScroll(string2);
        }
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

    public boolean checkForGaps() {
        int n10 = this.getChildCount();
        int n11 = 0;
        StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup = null;
        if (n10 != 0 && (n10 = this.mGapStrategy) != 0 && (n10 = (int)(this.isAttachedToWindow() ? 1 : 0)) != 0) {
            View view;
            int n12;
            n10 = (int)(this.mShouldReverseLayout ? 1 : 0);
            if (n10 != 0) {
                n10 = this.getLastChildPosition();
                n12 = this.getFirstChildPosition();
            } else {
                n10 = this.getFirstChildPosition();
                n12 = this.getLastChildPosition();
            }
            int n13 = 1;
            if (n10 == 0 && (view = this.hasGapsToFix()) != null) {
                this.mLazySpanLookup.clear();
                this.requestSimpleAnimationsInNextLayout();
                this.requestLayout();
                return n13 != 0;
            }
            int n14 = this.mLaidOutInvalidFullSpan;
            if (n14 == 0) {
                return false;
            }
            n14 = this.mShouldReverseLayout;
            int n15 = -1;
            n14 = n14 != 0 ? n15 : n13;
            Object object = this.mLazySpanLookup;
            if ((object = ((StaggeredGridLayoutManager$LazySpanLookup)object).getFirstFullSpanItemInRange(n10, n12 += n13, n14, n13 != 0)) == null) {
                this.mLaidOutInvalidFullSpan = false;
                this.mLazySpanLookup.forceInvalidateAfter(n12);
                return false;
            }
            staggeredGridLayoutManager$LazySpanLookup = this.mLazySpanLookup;
            n12 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mPosition;
            Object object2 = staggeredGridLayoutManager$LazySpanLookup.getFirstFullSpanItemInRange(n10, n12, n14 *= n15, n13 != 0);
            if (object2 == null) {
                object2 = this.mLazySpanLookup;
                n11 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mPosition;
                ((StaggeredGridLayoutManager$LazySpanLookup)object2).forceInvalidateAfter(n11);
            } else {
                staggeredGridLayoutManager$LazySpanLookup = this.mLazySpanLookup;
                n10 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object2).mPosition + n13;
                staggeredGridLayoutManager$LazySpanLookup.forceInvalidateAfter(n10);
            }
            this.requestSimpleAnimationsInNextLayout();
            this.requestLayout();
            return n13 != 0;
        }
        return false;
    }

    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof StaggeredGridLayoutManager$LayoutParams;
    }

    public void collectAdjacentPrefetchPositions(int n10, int n11, RecyclerView$State recyclerView$State, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int n12 = this.mOrientation;
        if (n12 != 0) {
            n10 = n11;
        }
        n11 = this.getChildCount();
        if (n11 != 0 && n10 != 0) {
            int n13;
            Object object;
            Object object2;
            this.prepareLayoutStateForDelta(n10, recyclerView$State);
            int[] nArray = this.mPrefetchDistances;
            if (nArray == null || (n10 = nArray.length) < (n11 = this.mSpanCount)) {
                n10 = this.mSpanCount;
                this.mPrefetchDistances = nArray = new int[n10];
            }
            n10 = 0;
            nArray = null;
            Object object3 = null;
            n12 = 0;
            for (n11 = 0; n11 < (object2 = this.mSpanCount); ++n11) {
                Object object4;
                object = this.mLayoutState;
                n13 = ((LayoutState)object).mItemDirection;
                int n14 = -1;
                if (n13 == n14) {
                    object2 = ((LayoutState)object).mStartLine;
                    object4 = this.mSpans[n11];
                    n13 = ((StaggeredGridLayoutManager$Span)object4).getStartLine((int)object2);
                } else {
                    object4 = this.mSpans[n11];
                    object2 = ((LayoutState)object).mEndLine;
                    object2 = ((StaggeredGridLayoutManager$Span)object4).getEndLine((int)object2);
                    object4 = this.mLayoutState;
                    n13 = ((LayoutState)object4).mEndLine;
                }
                if ((object2 -= n13) < 0) continue;
                object4 = this.mPrefetchDistances;
                object4[n12] = object2;
                ++n12;
            }
            object3 = this.mPrefetchDistances;
            Arrays.sort((int[])object3, 0, n12);
            while (n10 < n12 && (n11 = (int)(((LayoutState)(object3 = (Object)this.mLayoutState)).hasMore(recyclerView$State) ? 1 : 0)) != 0) {
                n11 = this.mLayoutState.mCurrentPosition;
                object = this.mPrefetchDistances;
                object2 = object[n10];
                recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(n11, (int)object2);
                object3 = this.mLayoutState;
                object2 = ((LayoutState)object3).mCurrentPosition;
                n13 = ((LayoutState)object3).mItemDirection;
                ((LayoutState)object3).mCurrentPosition = object2 += n13;
                ++n10;
            }
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
        n10 = this.calculateScrollDirectionForPosition(n10);
        PointF pointF = new PointF();
        if (n10 == 0) {
            return null;
        }
        int n11 = this.mOrientation;
        if (n11 == 0) {
            float f10;
            pointF.x = f10 = (float)n10;
            pointF.y = 0.0f;
        } else {
            float f11;
            pointF.x = 0.0f;
            pointF.y = f11 = (float)n10;
        }
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] object) {
        block5: {
            int n10;
            int n11;
            block4: {
                block3: {
                    if (object != null) break block3;
                    int n12 = this.mSpanCount;
                    object = new int[n12];
                    break block4;
                }
                n11 = ((int[])object).length;
                n10 = this.mSpanCount;
                if (n11 < n10) break block5;
            }
            Object var5_6 = null;
            for (n11 = 0; n11 < (n10 = this.mSpanCount); ++n11) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[n11];
                object[n11] = n10 = staggeredGridLayoutManager$Span.findFirstCompletelyVisibleItemPosition();
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        int n13 = this.mSpanCount;
        stringBuilder.append(n13);
        stringBuilder.append(", array size:");
        int n14 = ((int[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public View findFirstVisibleItemClosestToEnd(boolean bl2) {
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        int n10 = orientationHelper.getStartAfterPadding();
        OrientationHelper orientationHelper2 = this.mPrimaryOrientation;
        int n11 = orientationHelper2.getEndAfterPadding();
        View view = null;
        for (int i10 = this.getChildCount() + -1; i10 >= 0; i10 += -1) {
            View view2 = this.getChildAt(i10);
            OrientationHelper orientationHelper3 = this.mPrimaryOrientation;
            int n12 = orientationHelper3.getDecoratedStart(view2);
            OrientationHelper orientationHelper4 = this.mPrimaryOrientation;
            int n13 = orientationHelper4.getDecoratedEnd(view2);
            if (n13 <= n10 || n12 >= n11) continue;
            if (n13 > n11 && bl2) {
                if (view != null) continue;
                view = view2;
                continue;
            }
            return view2;
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean bl2) {
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        int n10 = orientationHelper.getStartAfterPadding();
        OrientationHelper orientationHelper2 = this.mPrimaryOrientation;
        int n11 = orientationHelper2.getEndAfterPadding();
        int n12 = this.getChildCount();
        View view = null;
        for (int i10 = 0; i10 < n12; ++i10) {
            View view2 = this.getChildAt(i10);
            OrientationHelper orientationHelper3 = this.mPrimaryOrientation;
            int n13 = orientationHelper3.getDecoratedStart(view2);
            OrientationHelper orientationHelper4 = this.mPrimaryOrientation;
            int n14 = orientationHelper4.getDecoratedEnd(view2);
            if (n14 <= n10 || n13 >= n11) continue;
            if (n13 < n10 && bl2) {
                if (view != null) continue;
                view = view2;
                continue;
            }
            return view2;
        }
        return view;
    }

    public int findFirstVisibleItemPositionInt() {
        int n10 = this.mShouldReverseLayout;
        boolean bl2 = true;
        View view = n10 != 0 ? this.findFirstVisibleItemClosestToEnd(bl2) : this.findFirstVisibleItemClosestToStart(bl2);
        n10 = view == null ? -1 : this.getPosition(view);
        return n10;
    }

    public int[] findFirstVisibleItemPositions(int[] object) {
        block5: {
            int n10;
            int n11;
            block4: {
                block3: {
                    if (object != null) break block3;
                    int n12 = this.mSpanCount;
                    object = new int[n12];
                    break block4;
                }
                n11 = ((int[])object).length;
                n10 = this.mSpanCount;
                if (n11 < n10) break block5;
            }
            Object var5_6 = null;
            for (n11 = 0; n11 < (n10 = this.mSpanCount); ++n11) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[n11];
                object[n11] = n10 = staggeredGridLayoutManager$Span.findFirstVisibleItemPosition();
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        int n13 = this.mSpanCount;
        stringBuilder.append(n13);
        stringBuilder.append(", array size:");
        int n14 = ((int[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] object) {
        block5: {
            int n10;
            int n11;
            block4: {
                block3: {
                    if (object != null) break block3;
                    int n12 = this.mSpanCount;
                    object = new int[n12];
                    break block4;
                }
                n11 = ((int[])object).length;
                n10 = this.mSpanCount;
                if (n11 < n10) break block5;
            }
            Object var5_6 = null;
            for (n11 = 0; n11 < (n10 = this.mSpanCount); ++n11) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[n11];
                object[n11] = n10 = staggeredGridLayoutManager$Span.findLastCompletelyVisibleItemPosition();
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        int n13 = this.mSpanCount;
        stringBuilder.append(n13);
        stringBuilder.append(", array size:");
        int n14 = ((int[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public int[] findLastVisibleItemPositions(int[] object) {
        block5: {
            int n10;
            int n11;
            block4: {
                block3: {
                    if (object != null) break block3;
                    int n12 = this.mSpanCount;
                    object = new int[n12];
                    break block4;
                }
                n11 = ((int[])object).length;
                n10 = this.mSpanCount;
                if (n11 < n10) break block5;
            }
            Object var5_6 = null;
            for (n11 = 0; n11 < (n10 = this.mSpanCount); ++n11) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[n11];
                object[n11] = n10 = staggeredGridLayoutManager$Span.findLastVisibleItemPosition();
            }
            return object;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Provided int[]'s size must be more than or equal to span count. Expected:");
        int n13 = this.mSpanCount;
        stringBuilder.append(n13);
        stringBuilder.append(", array size:");
        int n14 = ((int[])object).length;
        stringBuilder.append(n14);
        object = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)object);
        throw illegalArgumentException;
    }

    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        int n10 = this.mOrientation;
        int n11 = -2;
        int n12 = -1;
        if (n10 == 0) {
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = new StaggeredGridLayoutManager$LayoutParams(n11, n12);
            return staggeredGridLayoutManager$LayoutParams;
        }
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = new StaggeredGridLayoutManager$LayoutParams(n12, n11);
        return staggeredGridLayoutManager$LayoutParams;
    }

    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = new StaggeredGridLayoutManager$LayoutParams(context, attributeSet);
        return staggeredGridLayoutManager$LayoutParams;
    }

    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        boolean bl2 = layoutParams instanceof ViewGroup.MarginLayoutParams;
        if (bl2) {
            layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = new StaggeredGridLayoutManager$LayoutParams((ViewGroup.MarginLayoutParams)layoutParams);
            return staggeredGridLayoutManager$LayoutParams;
        }
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = new StaggeredGridLayoutManager$LayoutParams(layoutParams);
        return staggeredGridLayoutManager$LayoutParams;
    }

    public int getFirstChildPosition() {
        int n10 = this.getChildCount();
        int n11 = 0;
        if (n10 != 0) {
            View view = this.getChildAt(0);
            n11 = this.getPosition(view);
        }
        return n11;
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getLastChildPosition() {
        int n10 = this.getChildCount();
        if (n10 == 0) {
            n10 = 0;
            Object var2_2 = null;
        } else {
            View view = this.getChildAt(n10 += -1);
            n10 = this.getPosition(view);
        }
        return n10;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public View hasGapsToFix() {
        var1_1 = this.getChildCount();
        var2_2 = 1;
        var3_3 = 1.4E-45f;
        var1_1 -= var2_2;
        var5_5 = this.mSpanCount;
        var4_4 = new BitSet(var5_5);
        var5_5 = this.mSpanCount;
        var4_4.set(0, var5_5, (boolean)var2_2);
        var5_5 = this.mOrientation;
        var6_6 = -1;
        var5_5 = var5_5 == var2_2 && (var5_5 = (int)this.isLayoutRTL()) != 0 ? var2_2 : var6_6;
        var7_7 = this.mShouldReverseLayout;
        if (var7_7 != 0) {
            var7_7 = var6_6;
        } else {
            var7_7 = var1_1 + 1;
            var1_1 = 0;
        }
        if (var1_1 < var7_7) {
            var6_6 = var2_2;
        }
        while (var1_1 != var7_7) {
            block16: {
                block17: {
                    var8_8 = this.getChildAt(var1_1);
                    var9_9 /* !! */  = (StaggeredGridLayoutManager$LayoutParams)var8_8.getLayoutParams();
                    var10_10 /* !! */  = var9_9 /* !! */ .mSpan;
                    var11_11 = var10_10 /* !! */ .mIndex;
                    if ((var11_11 = (int)var4_4.get(var11_11)) != 0) {
                        var10_10 /* !! */  = var9_9 /* !! */ .mSpan;
                        var11_11 = (int)this.checkSpanForGap(var10_10 /* !! */ );
                        if (var11_11 != 0) {
                            return var8_8;
                        }
                        var10_10 /* !! */  = var9_9 /* !! */ .mSpan;
                        var11_11 = var10_10 /* !! */ .mIndex;
                        var4_4.clear(var11_11);
                    }
                    if ((var11_11 = (int)var9_9 /* !! */ .mFullSpan) != 0 || (var11_11 = var1_1 + var6_6) == var7_7) break block16;
                    var10_10 /* !! */  = this.getChildAt(var11_11);
                    var12_12 = this.mShouldReverseLayout;
                    if (var12_12 == 0) break block17;
                    var13_13 = this.mPrimaryOrientation;
                    var12_12 = var13_13.getDecoratedEnd(var8_8);
                    if (var12_12 < (var15_15 = (var14_14 = this.mPrimaryOrientation).getDecoratedEnd((View)var10_10 /* !! */ ))) {
                        return var8_8;
                    }
                    if (var12_12 != var15_15) ** GOTO lbl-1000
                    ** GOTO lbl-1000
                }
                var13_13 = this.mPrimaryOrientation;
                var12_12 = var13_13.getDecoratedStart(var8_8);
                if (var12_12 > (var15_15 = (var14_14 = this.mPrimaryOrientation).getDecoratedStart((View)var10_10 /* !! */ ))) {
                    return var8_8;
                }
                if (var12_12 == var15_15) lbl-1000:
                // 2 sources

                {
                    var12_12 = var2_2;
                } else lbl-1000:
                // 2 sources

                {
                    var12_12 = 0;
                    var13_13 = null;
                }
                if (var12_12 != 0) {
                    var10_10 /* !! */  = (StaggeredGridLayoutManager$LayoutParams)var10_10 /* !! */ .getLayoutParams();
                    var9_9 /* !! */  = var9_9 /* !! */ .mSpan;
                    var16_16 = var9_9 /* !! */ .mIndex;
                    var10_10 /* !! */  = var10_10 /* !! */ .mSpan;
                    var11_11 = var10_10 /* !! */ .mIndex;
                    if ((var16_16 -= var11_11) < 0) {
                        var16_16 = var2_2;
                    } else {
                        var16_16 = 0;
                        var9_9 /* !! */  = null;
                    }
                    if (var5_5 < 0) {
                        var11_11 = var2_2;
                    } else {
                        var11_11 = 0;
                        var10_10 /* !! */  = null;
                    }
                    if (var16_16 != var11_11) {
                        return var8_8;
                    }
                }
            }
            var1_1 += var6_6;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        this.requestLayout();
    }

    public boolean isAutoMeasureEnabled() {
        int n10 = this.mGapStrategy;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean isLayoutRTL() {
        int n10;
        int n11 = this.getLayoutDirection();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    public void offsetChildrenHorizontal(int n10) {
        int n11;
        super.offsetChildrenHorizontal(n10);
        for (int i10 = 0; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            staggeredGridLayoutManager$Span.onOffset(n10);
        }
    }

    public void offsetChildrenVertical(int n10) {
        int n11;
        super.offsetChildrenVertical(n10);
        for (int i10 = 0; i10 < (n11 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            staggeredGridLayoutManager$Span.onOffset(n10);
        }
    }

    public void onAdapterChanged(RecyclerView$Adapter recyclerView$Adapter, RecyclerView$Adapter object) {
        int n10;
        this.mLazySpanLookup.clear();
        for (int i10 = 0; i10 < (n10 = this.mSpanCount); ++i10) {
            object = this.mSpans[i10];
            ((StaggeredGridLayoutManager$Span)object).clear();
        }
    }

    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler object) {
        int n10;
        super.onDetachedFromWindow(recyclerView, (RecyclerView$Recycler)object);
        object = this.mCheckForGapsRunnable;
        this.removeCallbacks((Runnable)object);
        object = null;
        for (int i10 = 0; i10 < (n10 = this.mSpanCount); ++i10) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i10];
            staggeredGridLayoutManager$Span.clear();
        }
        recyclerView.requestLayout();
    }

    public View onFocusSearchFailed(View view, int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State object) {
        int n11;
        int n12;
        int n13;
        int n14 = this.getChildCount();
        if (n14 == 0) {
            return null;
        }
        if ((view = this.findContainingItemView(view)) == null) {
            return null;
        }
        this.resolveShouldLayoutReverse();
        n10 = this.convertFocusDirectionToLayoutDirection(n10);
        n14 = -1 << -1;
        if (n10 == n14) {
            return null;
        }
        Object object2 = (StaggeredGridLayoutManager$LayoutParams)view.getLayoutParams();
        boolean bl2 = ((StaggeredGridLayoutManager$LayoutParams)object2).mFullSpan;
        object2 = ((StaggeredGridLayoutManager$LayoutParams)object2).mSpan;
        int n15 = 1;
        int n16 = n10 == n15 ? this.getLastChildPosition() : this.getFirstChildPosition();
        this.updateLayoutState(n16, (RecyclerView$State)object);
        this.setLayoutStateDirection(n10);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = n13 = layoutState.mItemDirection + n16;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        int n17 = orientationHelper.getTotalSpace();
        float f10 = (float)n17 * 0.33333334f;
        layoutState.mAvailable = n13 = (int)f10;
        layoutState = this.mLayoutState;
        layoutState.mStopInFocusable = n15;
        n13 = 0;
        layoutState.mRecycle = false;
        this.fill(recyclerView$Recycler, layoutState, (RecyclerView$State)object);
        this.mLastLayoutFromEnd = n12 = this.mShouldReverseLayout;
        if (!bl2 && (recyclerView$Recycler = ((StaggeredGridLayoutManager$Span)object2).getFocusableViewAfter(n16, n10)) != null && recyclerView$Recycler != view) {
            return recyclerView$Recycler;
        }
        n12 = this.preferLastSpan(n10);
        if (n12 != 0) {
            for (n12 = this.mSpanCount - n15; n12 >= 0; n12 += -1) {
                object = this.mSpans[n12].getFocusableViewAfter(n16, n10);
                if (object == null || object == view) continue;
                return object;
            }
        } else {
            recyclerView$Recycler = null;
            for (n12 = 0; n12 < (n11 = this.mSpanCount); ++n12) {
                object = this.mSpans[n12].getFocusableViewAfter(n16, n10);
                if (object == null || object == view) continue;
                return object;
            }
        }
        n12 = this.mReverseLayout ^ n15;
        n11 = -1;
        if (n10 == n11) {
            n11 = n15;
        } else {
            n11 = 0;
            object = null;
        }
        if (n12 == n11) {
            n12 = n15;
        } else {
            n12 = 0;
            recyclerView$Recycler = null;
        }
        if (!bl2 && (object = this.findViewByPosition(n11 = n12 != 0 ? ((StaggeredGridLayoutManager$Span)object2).findFirstPartiallyVisibleItemPosition() : ((StaggeredGridLayoutManager$Span)object2).findLastPartiallyVisibleItemPosition())) != null && object != view) {
            return object;
        }
        if ((n10 = (int)(this.preferLastSpan(n10) ? 1 : 0)) != 0) {
            for (n10 = this.mSpanCount - n15; n10 >= 0; n10 += -1) {
                n11 = ((StaggeredGridLayoutManager$Span)object2).mIndex;
                if (n10 == n11) continue;
                if (n12 != 0) {
                    object = this.mSpans[n10];
                    n11 = ((StaggeredGridLayoutManager$Span)object).findFirstPartiallyVisibleItemPosition();
                } else {
                    object = this.mSpans[n10];
                    n11 = ((StaggeredGridLayoutManager$Span)object).findLastPartiallyVisibleItemPosition();
                }
                object = this.findViewByPosition(n11);
                if (object == null || object == view) continue;
                return object;
            }
        } else {
            while (n13 < (n10 = this.mSpanCount)) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span;
                if (n12 != 0) {
                    staggeredGridLayoutManager$Span = this.mSpans[n13];
                    n10 = staggeredGridLayoutManager$Span.findFirstPartiallyVisibleItemPosition();
                } else {
                    staggeredGridLayoutManager$Span = this.mSpans[n13];
                    n10 = staggeredGridLayoutManager$Span.findLastPartiallyVisibleItemPosition();
                }
                staggeredGridLayoutManager$Span = this.findViewByPosition(n10);
                if (staggeredGridLayoutManager$Span != null && staggeredGridLayoutManager$Span != view) {
                    return staggeredGridLayoutManager$Span;
                }
                ++n13;
            }
        }
        return null;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        int n10 = this.getChildCount();
        if (n10 > 0) {
            n10 = 0;
            View view = this.findFirstVisibleItemClosestToStart(false);
            View view2 = this.findFirstVisibleItemClosestToEnd(false);
            if (view != null && view2 != null) {
                int n11 = this.getPosition(view);
                if (n11 < (n10 = this.getPosition(view2))) {
                    accessibilityEvent.setFromIndex(n11);
                    accessibilityEvent.setToIndex(n10);
                } else {
                    accessibilityEvent.setFromIndex(n10);
                    accessibilityEvent.setToIndex(n11);
                }
            }
        }
    }

    public void onItemsAdded(RecyclerView recyclerView, int n10, int n11) {
        this.handleUpdate(n10, n11, 1);
    }

    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        this.requestLayout();
    }

    public void onItemsMoved(RecyclerView recyclerView, int n10, int n11, int n12) {
        this.handleUpdate(n10, n11, 8);
    }

    public void onItemsRemoved(RecyclerView recyclerView, int n10, int n11) {
        this.handleUpdate(n10, n11, 2);
    }

    public void onItemsUpdated(RecyclerView recyclerView, int n10, int n11, Object object) {
        this.handleUpdate(n10, n11, 4);
    }

    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        this.onLayoutChildren(recyclerView$Recycler, recyclerView$State, true);
    }

    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = -1 << -1;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        int n10 = parcelable instanceof StaggeredGridLayoutManager$SavedState;
        if (n10 != 0) {
            parcelable = (StaggeredGridLayoutManager$SavedState)parcelable;
            this.mPendingSavedState = parcelable;
            n10 = this.mPendingScrollPosition;
            int n11 = -1;
            if (n10 != n11) {
                parcelable.invalidateAnchorPositionInfo();
                parcelable = this.mPendingSavedState;
                parcelable.invalidateSpanInfo();
            }
            this.requestLayout();
        }
    }

    public Parcelable onSaveInstanceState() {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState;
        block11: {
            int n10;
            block7: {
                int n11;
                Object object;
                staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
                if (staggeredGridLayoutManager$SavedState != null) {
                    StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState2 = this.mPendingSavedState;
                    staggeredGridLayoutManager$SavedState = new StaggeredGridLayoutManager$SavedState(staggeredGridLayoutManager$SavedState2);
                    return staggeredGridLayoutManager$SavedState;
                }
                staggeredGridLayoutManager$SavedState = new StaggeredGridLayoutManager$SavedState();
                staggeredGridLayoutManager$SavedState.mReverseLayout = n10 = this.mReverseLayout;
                staggeredGridLayoutManager$SavedState.mAnchorLayoutFromEnd = n10 = this.mLastLayoutFromEnd;
                staggeredGridLayoutManager$SavedState.mLastLayoutRTL = n10 = this.mLastLayoutRTL;
                Object object2 = this.mLazySpanLookup;
                int n12 = 0;
                if (object2 != null && (object = ((StaggeredGridLayoutManager$LazySpanLookup)object2).mData) != null) {
                    staggeredGridLayoutManager$SavedState.mSpanLookup = object;
                    staggeredGridLayoutManager$SavedState.mSpanLookupSize = n11 = ((int[])object).length;
                    staggeredGridLayoutManager$SavedState.mFullSpanItems = object2 = ((StaggeredGridLayoutManager$LazySpanLookup)object2).mFullSpanItems;
                } else {
                    staggeredGridLayoutManager$SavedState.mSpanLookupSize = 0;
                }
                n10 = this.getChildCount();
                if (n10 <= 0) break block7;
                n10 = (int)(this.mLastLayoutFromEnd ? 1 : 0);
                n10 = n10 != 0 ? this.getLastChildPosition() : this.getFirstChildPosition();
                staggeredGridLayoutManager$SavedState.mAnchorPosition = n10;
                staggeredGridLayoutManager$SavedState.mVisibleAnchorPosition = n10 = this.findFirstVisibleItemPositionInt();
                staggeredGridLayoutManager$SavedState.mSpanOffsetsSize = n10 = this.mSpanCount;
                object2 = new int[n10];
                staggeredGridLayoutManager$SavedState.mSpanOffsets = (int[])object2;
                while (n12 < (n10 = this.mSpanCount)) {
                    block9: {
                        block10: {
                            block8: {
                                n10 = (int)(this.mLastLayoutFromEnd ? 1 : 0);
                                n11 = -1 << -1;
                                if (n10 == 0) break block8;
                                object2 = this.mSpans[n12];
                                n10 = ((StaggeredGridLayoutManager$Span)object2).getEndLine(n11);
                                if (n10 == n11) break block9;
                                object = this.mPrimaryOrientation;
                                n11 = ((OrientationHelper)object).getEndAfterPadding();
                                break block10;
                            }
                            object2 = this.mSpans[n12];
                            n10 = ((StaggeredGridLayoutManager$Span)object2).getStartLine(n11);
                            if (n10 == n11) break block9;
                            object = this.mPrimaryOrientation;
                            n11 = ((OrientationHelper)object).getStartAfterPadding();
                        }
                        n10 -= n11;
                    }
                    object = staggeredGridLayoutManager$SavedState.mSpanOffsets;
                    object[n12] = n10;
                    ++n12;
                }
                break block11;
            }
            staggeredGridLayoutManager$SavedState.mAnchorPosition = n10 = -1;
            staggeredGridLayoutManager$SavedState.mVisibleAnchorPosition = n10;
            staggeredGridLayoutManager$SavedState.mSpanOffsetsSize = 0;
        }
        return staggeredGridLayoutManager$SavedState;
    }

    public void onScrollStateChanged(int n10) {
        if (n10 == 0) {
            this.checkForGaps();
        }
    }

    public void prepareLayoutStateForDelta(int n10, RecyclerView$State object) {
        int n11;
        int n12;
        int n13 = 1;
        if (n10 > 0) {
            n12 = this.getLastChildPosition();
            n11 = n13;
        } else {
            int n14 = this.getFirstChildPosition();
            n11 = -1;
            n12 = n14;
        }
        this.mLayoutState.mRecycle = n13;
        this.updateLayoutState(n12, (RecyclerView$State)object);
        this.setLayoutStateDirection(n11);
        object = this.mLayoutState;
        n13 = ((LayoutState)object).mItemDirection;
        ((LayoutState)object).mCurrentPosition = n12 += n13;
        ((LayoutState)object).mAvailable = n10 = Math.abs(n10);
    }

    public int scrollBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State object) {
        int n11 = this.getChildCount();
        if (n11 != 0 && n10 != 0) {
            this.prepareLayoutStateForDelta(n10, (RecyclerView$State)object);
            LayoutState layoutState = this.mLayoutState;
            int n12 = this.fill(recyclerView$Recycler, layoutState, (RecyclerView$State)object);
            layoutState = this.mLayoutState;
            n11 = layoutState.mAvailable;
            if (n11 >= n12) {
                n10 = n10 < 0 ? -n12 : n12;
            }
            object = this.mPrimaryOrientation;
            n11 = -n10;
            ((OrientationHelper)object).offsetChildren(n11);
            n12 = (int)(this.mShouldReverseLayout ? 1 : 0);
            this.mLastLayoutFromEnd = n12;
            object = this.mLayoutState;
            ((LayoutState)object).mAvailable = 0;
            this.recycle(recyclerView$Recycler, (LayoutState)object);
            return n10;
        }
        return 0;
    }

    public int scrollHorizontallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return this.scrollBy(n10, recyclerView$Recycler, recyclerView$State);
    }

    public void scrollToPosition(int n10) {
        int n11;
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState != null && (n11 = staggeredGridLayoutManager$SavedState.mAnchorPosition) != n10) {
            staggeredGridLayoutManager$SavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = n10;
        this.mPendingScrollPositionOffset = -1 << -1;
        this.requestLayout();
    }

    public void scrollToPositionWithOffset(int n10, int n11) {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState != null) {
            staggeredGridLayoutManager$SavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = n10;
        this.mPendingScrollPositionOffset = n11;
        this.requestLayout();
    }

    public int scrollVerticallyBy(int n10, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return this.scrollBy(n10, recyclerView$Recycler, recyclerView$State);
    }

    public void setGapStrategy(int n10) {
        this.assertNotInLayoutOrScroll(null);
        int n11 = this.mGapStrategy;
        if (n10 == n11) {
            return;
        }
        if (n10 != 0 && n10 != (n11 = 2)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
            throw illegalArgumentException;
        }
        this.mGapStrategy = n10;
        this.requestLayout();
    }

    public void setMeasuredDimension(Rect rect, int n10, int n11) {
        int n12;
        int n13 = this.getPaddingLeft();
        int n14 = this.getPaddingRight();
        n13 += n14;
        n14 = this.getPaddingTop();
        int n15 = this.getPaddingBottom();
        n14 += n15;
        n15 = this.mOrientation;
        int n16 = 1;
        if (n15 == n16) {
            n12 = rect.height() + n14;
            n14 = this.getMinimumHeight();
            n12 = RecyclerView$LayoutManager.chooseSize(n11, n12, n14);
            n11 = this.mSizePerSpan;
            n14 = this.mSpanCount;
            n11 = n11 * n14 + n13;
            n13 = this.getMinimumWidth();
            n10 = RecyclerView$LayoutManager.chooseSize(n10, n11, n13);
        } else {
            n12 = rect.width() + n13;
            n13 = this.getMinimumWidth();
            n10 = RecyclerView$LayoutManager.chooseSize(n10, n12, n13);
            n12 = this.mSizePerSpan;
            n13 = this.mSpanCount;
            n12 = n12 * n13 + n14;
            n13 = this.getMinimumHeight();
            n12 = RecyclerView$LayoutManager.chooseSize(n11, n12, n13);
        }
        this.setMeasuredDimension(n10, n12);
    }

    public void setOrientation(int n10) {
        int n11;
        if (n10 != 0 && n10 != (n11 = 1)) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("invalid orientation.");
            throw illegalArgumentException;
        }
        OrientationHelper orientationHelper = null;
        this.assertNotInLayoutOrScroll(null);
        n11 = this.mOrientation;
        if (n10 == n11) {
            return;
        }
        this.mOrientation = n10;
        OrientationHelper orientationHelper2 = this.mPrimaryOrientation;
        this.mPrimaryOrientation = orientationHelper = this.mSecondaryOrientation;
        this.mSecondaryOrientation = orientationHelper2;
        this.requestLayout();
    }

    public void setReverseLayout(boolean bl2) {
        boolean bl3;
        this.assertNotInLayoutOrScroll(null);
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState != null && (bl3 = staggeredGridLayoutManager$SavedState.mReverseLayout) != bl2) {
            staggeredGridLayoutManager$SavedState.mReverseLayout = bl2;
        }
        this.mReverseLayout = bl2;
        this.requestLayout();
    }

    public void setSpanCount(int n10) {
        StaggeredGridLayoutManager$Span[] staggeredGridLayoutManager$SpanArray = null;
        this.assertNotInLayoutOrScroll(null);
        int n11 = this.mSpanCount;
        if (n10 != n11) {
            this.invalidateSpanAssignments();
            n11 = this.mSpanCount = n10;
            StaggeredGridLayoutManager$Span[] staggeredGridLayoutManager$SpanArray2 = new BitSet(n11);
            this.mRemainingSpans = staggeredGridLayoutManager$SpanArray2;
            staggeredGridLayoutManager$SpanArray2 = new StaggeredGridLayoutManager$Span[this.mSpanCount];
            this.mSpans = staggeredGridLayoutManager$SpanArray2;
            staggeredGridLayoutManager$SpanArray2 = null;
            for (n10 = 0; n10 < (n11 = this.mSpanCount); ++n10) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span;
                staggeredGridLayoutManager$SpanArray = this.mSpans;
                staggeredGridLayoutManager$SpanArray[n10] = staggeredGridLayoutManager$Span = new StaggeredGridLayoutManager$Span(this, n10);
            }
            this.requestLayout();
        }
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State object, int n10) {
        recyclerView = recyclerView.getContext();
        object = new LinearSmoothScroller((Context)recyclerView);
        ((RecyclerView$SmoothScroller)object).setTargetPosition(n10);
        this.startSmoothScroll((RecyclerView$SmoothScroller)object);
    }

    public boolean supportsPredictiveItemAnimations() {
        boolean bl2;
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState == null) {
            bl2 = true;
        } else {
            bl2 = false;
            staggeredGridLayoutManager$SavedState = null;
        }
        return bl2;
    }

    public boolean updateAnchorFromPendingData(RecyclerView$State object, StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        int n10;
        int n11;
        boolean n112 = ((RecyclerView$State)object).isPreLayout();
        int n12 = 0;
        OrientationHelper orientationHelper = null;
        if (!n112 && (n11 = this.mPendingScrollPosition) != (n10 = -1)) {
            int n13;
            int n14 = -1 << -1;
            if (n11 >= 0 && n11 < (n13 = ((RecyclerView$State)object).getItemCount())) {
                int n15;
                object = this.mPendingSavedState;
                int n16 = 1;
                if (object != null && (n15 = ((StaggeredGridLayoutManager$SavedState)object).mAnchorPosition) != n10 && (n13 = ((StaggeredGridLayoutManager$SavedState)object).mSpanOffsetsSize) >= n16) {
                    staggeredGridLayoutManager$AnchorInfo.mOffset = n14;
                    n13 = this.mPendingScrollPosition;
                    staggeredGridLayoutManager$AnchorInfo.mPosition = n13;
                } else {
                    n13 = this.mPendingScrollPosition;
                    object = this.findViewByPosition(n13);
                    if (object != null) {
                        OrientationHelper orientationHelper2;
                        n12 = this.mShouldReverseLayout;
                        n12 = n12 != 0 ? this.getLastChildPosition() : this.getFirstChildPosition();
                        staggeredGridLayoutManager$AnchorInfo.mPosition = n12;
                        n12 = this.mPendingScrollPositionOffset;
                        if (n12 != n14) {
                            n12 = (int)(staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0);
                            if (n12 != 0) {
                                orientationHelper = this.mPrimaryOrientation;
                                n12 = orientationHelper.getEndAfterPadding();
                                n10 = this.mPendingScrollPositionOffset;
                                n12 -= n10;
                                OrientationHelper orientationHelper22 = this.mPrimaryOrientation;
                                n13 = orientationHelper22.getDecoratedEnd((View)object);
                                staggeredGridLayoutManager$AnchorInfo.mOffset = n12 -= n13;
                            } else {
                                orientationHelper = this.mPrimaryOrientation;
                                n12 = orientationHelper.getStartAfterPadding();
                                n10 = this.mPendingScrollPositionOffset;
                                n12 += n10;
                                OrientationHelper orientationHelper3 = this.mPrimaryOrientation;
                                n13 = orientationHelper3.getDecoratedStart((View)object);
                                staggeredGridLayoutManager$AnchorInfo.mOffset = n12 -= n13;
                            }
                            return n16 != 0;
                        }
                        orientationHelper = this.mPrimaryOrientation;
                        n12 = orientationHelper.getDecoratedMeasurement((View)object);
                        if (n12 > (n10 = (orientationHelper2 = this.mPrimaryOrientation).getTotalSpace())) {
                            n13 = (int)(staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd ? 1 : 0);
                            if (n13 != 0) {
                                object = this.mPrimaryOrientation;
                                n13 = ((OrientationHelper)object).getEndAfterPadding();
                            } else {
                                object = this.mPrimaryOrientation;
                                n13 = ((OrientationHelper)object).getStartAfterPadding();
                            }
                            staggeredGridLayoutManager$AnchorInfo.mOffset = n13;
                            return n16 != 0;
                        }
                        orientationHelper = this.mPrimaryOrientation;
                        n12 = orientationHelper.getDecoratedStart((View)object);
                        orientationHelper2 = this.mPrimaryOrientation;
                        n10 = orientationHelper2.getStartAfterPadding();
                        if ((n12 -= n10) < 0) {
                            n13 = -n12;
                            staggeredGridLayoutManager$AnchorInfo.mOffset = n13;
                            return n16 != 0;
                        }
                        orientationHelper = this.mPrimaryOrientation;
                        n12 = orientationHelper.getEndAfterPadding();
                        orientationHelper2 = this.mPrimaryOrientation;
                        n13 = orientationHelper2.getDecoratedEnd((View)object);
                        if ((n12 -= n13) < 0) {
                            staggeredGridLayoutManager$AnchorInfo.mOffset = n12;
                            return n16 != 0;
                        }
                        staggeredGridLayoutManager$AnchorInfo.mOffset = n14;
                    } else {
                        n13 = this.mPendingScrollPosition;
                        staggeredGridLayoutManager$AnchorInfo.mPosition = n13;
                        n10 = this.mPendingScrollPositionOffset;
                        if (n10 == n14) {
                            if ((n13 = this.calculateScrollDirectionForPosition(n13)) == n16) {
                                n12 = n16;
                            }
                            staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd = n12;
                            staggeredGridLayoutManager$AnchorInfo.assignCoordinateFromPadding();
                        } else {
                            staggeredGridLayoutManager$AnchorInfo.assignCoordinateFromPadding(n10);
                        }
                        staggeredGridLayoutManager$AnchorInfo.mInvalidateOffsets = n16;
                    }
                }
                return n16 != 0;
            }
            this.mPendingScrollPosition = n10;
            this.mPendingScrollPositionOffset = n14;
        }
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView$State recyclerView$State, StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        boolean bl2 = this.updateAnchorFromPendingData(recyclerView$State, staggeredGridLayoutManager$AnchorInfo);
        if (bl2) {
            return;
        }
        boolean bl3 = this.updateAnchorFromChildren(recyclerView$State, staggeredGridLayoutManager$AnchorInfo);
        if (bl3) {
            return;
        }
        staggeredGridLayoutManager$AnchorInfo.assignCoordinateFromPadding();
        staggeredGridLayoutManager$AnchorInfo.mPosition = 0;
    }

    public void updateMeasureSpecs(int n10) {
        int n11 = this.mSpanCount;
        this.mSizePerSpan = n11 = n10 / n11;
        n11 = this.mSecondaryOrientation.getMode();
        this.mFullSizeSpec = n10 = View.MeasureSpec.makeMeasureSpec((int)n10, (int)n11);
    }
}

