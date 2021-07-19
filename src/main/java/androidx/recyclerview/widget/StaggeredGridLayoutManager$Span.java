/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LayoutParams;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
import java.util.ArrayList;

public class StaggeredGridLayoutManager$Span {
    public static final int INVALID_LINE = Integer.MIN_VALUE;
    public int mCachedEnd;
    public int mCachedStart;
    public int mDeletedSize;
    public final int mIndex;
    public ArrayList mViews;
    public final /* synthetic */ StaggeredGridLayoutManager this$0;

    public StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager arrayList, int n10) {
        int n11;
        this.this$0 = arrayList;
        this.mViews = arrayList = new ArrayList();
        this.mCachedStart = n11 = -1 << -1;
        this.mCachedEnd = n11;
        this.mDeletedSize = 0;
        this.mIndex = n10;
    }

    public void appendToSpan(View view) {
        int n10;
        int n11;
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = this.getLayoutParams(view);
        staggeredGridLayoutManager$LayoutParams.mSpan = this;
        Object object = this.mViews;
        ((ArrayList)object).add(view);
        this.mCachedEnd = n11 = -1 << -1;
        ArrayList arrayList = this.mViews;
        int n12 = arrayList.size();
        int n13 = 1;
        if (n12 == n13) {
            this.mCachedStart = n11;
        }
        if ((n11 = (int)(staggeredGridLayoutManager$LayoutParams.isItemRemoved() ? 1 : 0)) != 0 || (n10 = staggeredGridLayoutManager$LayoutParams.isItemChanged()) != 0) {
            n10 = this.mDeletedSize;
            object = this.this$0.mPrimaryOrientation;
            int n14 = ((OrientationHelper)object).getDecoratedMeasurement(view);
            this.mDeletedSize = n10 += n14;
        }
    }

    public void cacheReferenceLineAndClear(boolean n10, int n11) {
        OrientationHelper orientationHelper;
        OrientationHelper orientationHelper2;
        int n12;
        int n13 = -1 << -1;
        int n14 = n10 != 0 ? this.getEndLine(n13) : this.getStartLine(n13);
        this.clear();
        if (n14 == n13) {
            return;
        }
        if (n10 != 0 && n14 < (n12 = (orientationHelper2 = this.this$0.mPrimaryOrientation).getEndAfterPadding()) || n10 == 0 && n14 > (n10 = (orientationHelper = this.this$0.mPrimaryOrientation).getStartAfterPadding())) {
            return;
        }
        if (n11 != n13) {
            n14 += n11;
        }
        this.mCachedEnd = n14;
        this.mCachedStart = n14;
    }

    public void calculateCachedEnd() {
        int n10;
        Object object = this.mViews;
        int n11 = ((ArrayList)object).size();
        int n12 = 1;
        object = (View)((ArrayList)object).get(n11 -= n12);
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = this.getLayoutParams((View)object);
        OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
        this.mCachedEnd = n10 = orientationHelper.getDecoratedEnd((View)object);
        n10 = (int)(staggeredGridLayoutManager$LayoutParams.mFullSpan ? 1 : 0);
        if (n10 != 0) {
            object = this.this$0.mLazySpanLookup;
            n11 = staggeredGridLayoutManager$LayoutParams.getViewLayoutPosition();
            if ((object = ((StaggeredGridLayoutManager$LazySpanLookup)object).getFullSpanItem(n11)) != null && (n11 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mGapDir) == n12) {
                n11 = this.mCachedEnd;
                n12 = this.mIndex;
                n10 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).getGapForSpan(n12);
                this.mCachedEnd = n11 += n10;
            }
        }
    }

    public void calculateCachedStart() {
        int n10;
        Object object = this.mViews;
        int n11 = 0;
        object = (View)((ArrayList)object).get(0);
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = this.getLayoutParams((View)object);
        OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
        this.mCachedStart = n10 = orientationHelper.getDecoratedStart((View)object);
        n10 = (int)(staggeredGridLayoutManager$LayoutParams.mFullSpan ? 1 : 0);
        if (n10 != 0) {
            int n12;
            object = this.this$0.mLazySpanLookup;
            n11 = staggeredGridLayoutManager$LayoutParams.getViewLayoutPosition();
            if ((object = ((StaggeredGridLayoutManager$LazySpanLookup)object).getFullSpanItem(n11)) != null && (n11 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).mGapDir) == (n12 = -1)) {
                n11 = this.mCachedStart;
                n12 = this.mIndex;
                n10 = ((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem)object).getGapForSpan(n12);
                this.mCachedStart = n11 -= n10;
            }
        }
    }

    public void clear() {
        this.mViews.clear();
        this.invalidateCache();
        this.mDeletedSize = 0;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        Object object = this.this$0;
        int n10 = ((StaggeredGridLayoutManager)object).mReverseLayout;
        int n11 = 1;
        if (n10 != 0) {
            object = this.mViews;
            n10 = ((ArrayList)object).size() - n11;
            int n12 = -1;
            n10 = this.findOneVisibleChild(n10, n12, n11 != 0);
        } else {
            object = null;
            ArrayList arrayList = this.mViews;
            int n13 = arrayList.size();
            n10 = this.findOneVisibleChild(0, n13, n11 != 0);
        }
        return n10;
    }

    public int findFirstPartiallyVisibleItemPosition() {
        Object object = this.this$0;
        int n10 = ((StaggeredGridLayoutManager)object).mReverseLayout;
        int n11 = 1;
        if (n10 != 0) {
            object = this.mViews;
            n10 = ((ArrayList)object).size() - n11;
            int n12 = -1;
            n10 = this.findOnePartiallyVisibleChild(n10, n12, n11 != 0);
        } else {
            object = null;
            ArrayList arrayList = this.mViews;
            int n13 = arrayList.size();
            n10 = this.findOnePartiallyVisibleChild(0, n13, n11 != 0);
        }
        return n10;
    }

    public int findFirstVisibleItemPosition() {
        Object object = this.this$0;
        int n10 = ((StaggeredGridLayoutManager)object).mReverseLayout;
        if (n10 != 0) {
            object = this.mViews;
            n10 = ((ArrayList)object).size() + -1;
            int n11 = -1;
            n10 = this.findOneVisibleChild(n10, n11, false);
        } else {
            object = this.mViews;
            n10 = ((ArrayList)object).size();
            n10 = this.findOneVisibleChild(0, n10, false);
        }
        return n10;
    }

    public int findLastCompletelyVisibleItemPosition() {
        Object object = this.this$0;
        int n10 = ((StaggeredGridLayoutManager)object).mReverseLayout;
        int n11 = 1;
        if (n10 != 0) {
            object = null;
            ArrayList arrayList = this.mViews;
            int n12 = arrayList.size();
            n10 = this.findOneVisibleChild(0, n12, n11 != 0);
        } else {
            object = this.mViews;
            n10 = ((ArrayList)object).size() - n11;
            int n13 = -1;
            n10 = this.findOneVisibleChild(n10, n13, n11 != 0);
        }
        return n10;
    }

    public int findLastPartiallyVisibleItemPosition() {
        Object object = this.this$0;
        int n10 = ((StaggeredGridLayoutManager)object).mReverseLayout;
        int n11 = 1;
        if (n10 != 0) {
            object = null;
            ArrayList arrayList = this.mViews;
            int n12 = arrayList.size();
            n10 = this.findOnePartiallyVisibleChild(0, n12, n11 != 0);
        } else {
            object = this.mViews;
            n10 = ((ArrayList)object).size() - n11;
            int n13 = -1;
            n10 = this.findOnePartiallyVisibleChild(n10, n13, n11 != 0);
        }
        return n10;
    }

    public int findLastVisibleItemPosition() {
        Object object = this.this$0;
        int n10 = ((StaggeredGridLayoutManager)object).mReverseLayout;
        if (n10 != 0) {
            object = this.mViews;
            n10 = ((ArrayList)object).size();
            n10 = this.findOneVisibleChild(0, n10, false);
        } else {
            object = this.mViews;
            n10 = ((ArrayList)object).size() + -1;
            int n11 = -1;
            n10 = this.findOneVisibleChild(n10, n11, false);
        }
        return n10;
    }

    public int findOnePartiallyOrCompletelyVisibleChild(int n10, int n11, boolean bl2, boolean bl3, boolean bl4) {
        OrientationHelper orientationHelper = this.this$0.mPrimaryOrientation;
        int n12 = orientationHelper.getStartAfterPadding();
        OrientationHelper orientationHelper2 = this.this$0.mPrimaryOrientation;
        int n13 = orientationHelper2.getEndAfterPadding();
        int n14 = -1;
        int n15 = 1;
        int n16 = n11 > n10 ? n15 : n14;
        while (n10 != n11) {
            View view = (View)this.mViews.get(n10);
            OrientationHelper orientationHelper3 = this.this$0.mPrimaryOrientation;
            int n17 = orientationHelper3.getDecoratedStart(view);
            OrientationHelper orientationHelper4 = this.this$0.mPrimaryOrientation;
            int n18 = orientationHelper4.getDecoratedEnd(view);
            int n19 = 0;
            int n20 = (bl4 ? n17 <= n13 : n17 < n13) ? n15 : 0;
            if (bl4 ? n18 >= n12 : n18 > n12) {
                n19 = n15;
            }
            if (n20 != 0 && n19 != 0) {
                if (bl2 && bl3) {
                    if (n17 >= n12 && n18 <= n13) {
                        return this.this$0.getPosition(view);
                    }
                } else {
                    if (bl3) {
                        return this.this$0.getPosition(view);
                    }
                    if (n17 < n12 || n18 > n13) {
                        return this.this$0.getPosition(view);
                    }
                }
            }
            n10 += n16;
        }
        return n14;
    }

    public int findOnePartiallyVisibleChild(int n10, int n11, boolean bl2) {
        return this.findOnePartiallyOrCompletelyVisibleChild(n10, n11, false, false, bl2);
    }

    public int findOneVisibleChild(int n10, int n11, boolean bl2) {
        return this.findOnePartiallyOrCompletelyVisibleChild(n10, n11, bl2, true, false);
    }

    public int getDeletedSize() {
        return this.mDeletedSize;
    }

    public int getEndLine() {
        int n10 = this.mCachedEnd;
        int n11 = -1 << -1;
        if (n10 != n11) {
            return n10;
        }
        this.calculateCachedEnd();
        return this.mCachedEnd;
    }

    public int getEndLine(int n10) {
        int n11 = this.mCachedEnd;
        int n12 = -1 << -1;
        if (n11 != n12) {
            return n11;
        }
        ArrayList arrayList = this.mViews;
        n11 = arrayList.size();
        if (n11 == 0) {
            return n10;
        }
        this.calculateCachedEnd();
        return this.mCachedEnd;
    }

    public View getFocusableViewAfter(int n10, int n11) {
        int n12 = -1;
        View view = null;
        if (n11 == n12) {
            ArrayList arrayList = this.mViews;
            n11 = arrayList.size();
            Object var6_7 = null;
            for (n12 = 0; n12 < n11; ++n12) {
                int n13;
                View view2 = (View)this.mViews.get(n12);
                StaggeredGridLayoutManager staggeredGridLayoutManager = this.this$0;
                boolean bl2 = staggeredGridLayoutManager.mReverseLayout;
                if (bl2 && (n13 = staggeredGridLayoutManager.getPosition(view2)) <= n10) break;
                staggeredGridLayoutManager = this.this$0;
                bl2 = staggeredGridLayoutManager.mReverseLayout;
                if ((bl2 || (n13 = staggeredGridLayoutManager.getPosition(view2)) < n10) && (n13 = (int)(view2.hasFocusable() ? 1 : 0)) != 0) {
                    view = view2;
                    continue;
                }
                break;
            }
        } else {
            ArrayList arrayList = this.mViews;
            for (n11 = arrayList.size() + -1; n11 >= 0; n11 += -1) {
                int n14;
                View view3 = (View)this.mViews.get(n11);
                StaggeredGridLayoutManager staggeredGridLayoutManager = this.this$0;
                boolean bl3 = staggeredGridLayoutManager.mReverseLayout;
                if (bl3 && (n14 = staggeredGridLayoutManager.getPosition(view3)) >= n10) break;
                staggeredGridLayoutManager = this.this$0;
                bl3 = staggeredGridLayoutManager.mReverseLayout;
                if ((bl3 || (n14 = staggeredGridLayoutManager.getPosition(view3)) > n10) && (n14 = (int)(view3.hasFocusable() ? 1 : 0)) != 0) {
                    view = view3;
                    continue;
                }
                break;
            }
        }
        return view;
    }

    public StaggeredGridLayoutManager$LayoutParams getLayoutParams(View view) {
        return (StaggeredGridLayoutManager$LayoutParams)view.getLayoutParams();
    }

    public int getStartLine() {
        int n10 = this.mCachedStart;
        int n11 = -1 << -1;
        if (n10 != n11) {
            return n10;
        }
        this.calculateCachedStart();
        return this.mCachedStart;
    }

    public int getStartLine(int n10) {
        int n11 = this.mCachedStart;
        int n12 = -1 << -1;
        if (n11 != n12) {
            return n11;
        }
        ArrayList arrayList = this.mViews;
        n11 = arrayList.size();
        if (n11 == 0) {
            return n10;
        }
        this.calculateCachedStart();
        return this.mCachedStart;
    }

    public void invalidateCache() {
        int n10;
        this.mCachedStart = n10 = -1 << -1;
        this.mCachedEnd = n10;
    }

    public void onOffset(int n10) {
        int n11 = this.mCachedStart;
        int n12 = -1 << -1;
        if (n11 != n12) {
            this.mCachedStart = n11 += n10;
        }
        if ((n11 = this.mCachedEnd) != n12) {
            this.mCachedEnd = n11 += n10;
        }
    }

    public void popEnd() {
        int n10;
        ArrayList arrayList = this.mViews;
        int n11 = arrayList.size();
        ArrayList arrayList2 = this.mViews;
        int n12 = n11 + -1;
        arrayList2 = (View)arrayList2.remove(n12);
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = this.getLayoutParams((View)arrayList2);
        OrientationHelper orientationHelper = null;
        staggeredGridLayoutManager$LayoutParams.mSpan = null;
        boolean bl2 = staggeredGridLayoutManager$LayoutParams.isItemRemoved();
        if (bl2 || (n12 = (int)(staggeredGridLayoutManager$LayoutParams.isItemChanged() ? 1 : 0)) != 0) {
            n12 = this.mDeletedSize;
            orientationHelper = this.this$0.mPrimaryOrientation;
            n10 = orientationHelper.getDecoratedMeasurement((View)arrayList2);
            this.mDeletedSize = n12 -= n10;
        }
        n10 = -1 << -1;
        n12 = 1;
        if (n11 == n12) {
            this.mCachedStart = n10;
        }
        this.mCachedEnd = n10;
    }

    public void popStart() {
        ArrayList arrayList = this.mViews;
        int n10 = 0;
        arrayList = (View)arrayList.remove(0);
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = this.getLayoutParams((View)arrayList);
        staggeredGridLayoutManager$LayoutParams.mSpan = null;
        Object object = this.mViews;
        int n11 = ((ArrayList)object).size();
        int n12 = -1 << -1;
        if (n11 == 0) {
            this.mCachedEnd = n12;
        }
        if ((n11 = (int)(staggeredGridLayoutManager$LayoutParams.isItemRemoved() ? 1 : 0)) != 0 || (n10 = staggeredGridLayoutManager$LayoutParams.isItemChanged()) != 0) {
            n10 = this.mDeletedSize;
            object = this.this$0.mPrimaryOrientation;
            int n13 = ((OrientationHelper)object).getDecoratedMeasurement((View)arrayList);
            this.mDeletedSize = n10 -= n13;
        }
        this.mCachedStart = n12;
    }

    public void prependToSpan(View view) {
        int n10;
        int n11;
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = this.getLayoutParams(view);
        staggeredGridLayoutManager$LayoutParams.mSpan = this;
        Object object = this.mViews;
        ((ArrayList)object).add(0, view);
        this.mCachedStart = n11 = -1 << -1;
        ArrayList arrayList = this.mViews;
        int n12 = arrayList.size();
        int n13 = 1;
        if (n12 == n13) {
            this.mCachedEnd = n11;
        }
        if ((n11 = (int)(staggeredGridLayoutManager$LayoutParams.isItemRemoved() ? 1 : 0)) != 0 || (n10 = staggeredGridLayoutManager$LayoutParams.isItemChanged()) != 0) {
            n10 = this.mDeletedSize;
            object = this.this$0.mPrimaryOrientation;
            int n14 = ((OrientationHelper)object).getDecoratedMeasurement(view);
            this.mDeletedSize = n10 += n14;
        }
    }

    public void setLine(int n10) {
        this.mCachedStart = n10;
        this.mCachedEnd = n10;
    }
}

