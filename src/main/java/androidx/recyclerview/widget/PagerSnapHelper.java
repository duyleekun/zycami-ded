/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.PointF
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper$1;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.SnapHelper;

public class PagerSnapHelper
extends SnapHelper {
    private static final int MAX_SCROLL_ON_FLING_DURATION = 100;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    private int distanceToCenter(View view, OrientationHelper orientationHelper) {
        int n10 = orientationHelper.getDecoratedStart(view);
        int n11 = orientationHelper.getDecoratedMeasurement(view) / 2;
        n10 += n11;
        n11 = orientationHelper.getStartAfterPadding();
        int n12 = orientationHelper.getTotalSpace() / 2;
        return n10 - (n11 += n12);
    }

    private View findCenterView(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper) {
        int n10 = recyclerView$LayoutManager.getChildCount();
        View view = null;
        if (n10 == 0) {
            return null;
        }
        int n11 = orientationHelper.getStartAfterPadding();
        int n12 = orientationHelper.getTotalSpace() / 2;
        n11 += n12;
        n12 = -1 >>> 1;
        for (int i10 = 0; i10 < n10; ++i10) {
            View view2 = recyclerView$LayoutManager.getChildAt(i10);
            int n13 = orientationHelper.getDecoratedStart(view2);
            int n14 = orientationHelper.getDecoratedMeasurement(view2) / 2;
            if ((n13 = Math.abs(n13 + n14 - n11)) >= n12) continue;
            view = view2;
            n12 = n13;
        }
        return view;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView$LayoutManager object) {
        Object object2 = this.mHorizontalHelper;
        if (object2 == null || (object2 = ((OrientationHelper)object2).mLayoutManager) != object) {
            this.mHorizontalHelper = object = OrientationHelper.createHorizontalHelper((RecyclerView$LayoutManager)object);
        }
        return this.mHorizontalHelper;
    }

    private OrientationHelper getOrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        boolean bl2 = recyclerView$LayoutManager.canScrollVertically();
        if (bl2) {
            return this.getVerticalHelper(recyclerView$LayoutManager);
        }
        bl2 = recyclerView$LayoutManager.canScrollHorizontally();
        if (bl2) {
            return this.getHorizontalHelper(recyclerView$LayoutManager);
        }
        return null;
    }

    private OrientationHelper getVerticalHelper(RecyclerView$LayoutManager object) {
        Object object2 = this.mVerticalHelper;
        if (object2 == null || (object2 = ((OrientationHelper)object2).mLayoutManager) != object) {
            this.mVerticalHelper = object = OrientationHelper.createVerticalHelper((RecyclerView$LayoutManager)object);
        }
        return this.mVerticalHelper;
    }

    private boolean isForwardFling(RecyclerView$LayoutManager recyclerView$LayoutManager, int n10, int n11) {
        boolean bl2 = recyclerView$LayoutManager.canScrollHorizontally();
        boolean bl3 = true;
        if (bl2) {
            if (n10 <= 0) {
                bl3 = false;
            }
            return bl3;
        }
        if (n11 <= 0) {
            bl3 = false;
        }
        return bl3;
    }

    private boolean isReverseLayout(RecyclerView$LayoutManager object) {
        int n10 = ((RecyclerView$LayoutManager)object).getItemCount();
        int n11 = object instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        int n12 = 0;
        if (n11 != 0) {
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            object = (RecyclerView$SmoothScroller$ScrollVectorProvider)object;
            n11 = 1;
            if ((object = object.computeScrollVectorForPosition(n10 -= n11)) != null && ((n10 = (int)((f14 = (f13 = ((PointF)object).x) - 0.0f) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1))) < 0 || (f12 = (f11 = (f10 = ((PointF)object).y) - 0.0f) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0)) {
                n12 = n11;
            }
        }
        return n12 != 0;
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView$LayoutManager object, View view) {
        int n10 = 2;
        int[] nArray = new int[n10];
        boolean n11 = ((RecyclerView$LayoutManager)object).canScrollHorizontally();
        if (n11) {
            int n12;
            OrientationHelper orientationHelper = this.getHorizontalHelper((RecyclerView$LayoutManager)object);
            nArray[0] = n12 = this.distanceToCenter(view, orientationHelper);
        } else {
            nArray[0] = 0;
        }
        boolean bl2 = ((RecyclerView$LayoutManager)object).canScrollVertically();
        int n13 = 1;
        if (bl2) {
            int n14;
            object = this.getVerticalHelper((RecyclerView$LayoutManager)object);
            nArray[n13] = n14 = this.distanceToCenter(view, (OrientationHelper)object);
        } else {
            nArray[n13] = 0;
        }
        return nArray;
    }

    public RecyclerView$SmoothScroller createScroller(RecyclerView$LayoutManager object) {
        boolean bl2 = object instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        if (!bl2) {
            return null;
        }
        Context context = this.mRecyclerView.getContext();
        object = new PagerSnapHelper$1(this, context);
        return object;
    }

    public View findSnapView(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        boolean bl2 = recyclerView$LayoutManager.canScrollVertically();
        if (bl2) {
            OrientationHelper orientationHelper = this.getVerticalHelper(recyclerView$LayoutManager);
            return this.findCenterView(recyclerView$LayoutManager, orientationHelper);
        }
        bl2 = recyclerView$LayoutManager.canScrollHorizontally();
        if (bl2) {
            OrientationHelper orientationHelper = this.getHorizontalHelper(recyclerView$LayoutManager);
            return this.findCenterView(recyclerView$LayoutManager, orientationHelper);
        }
        return null;
    }

    public int findTargetSnapPosition(RecyclerView$LayoutManager recyclerView$LayoutManager, int n10, int n11) {
        int n12 = recyclerView$LayoutManager.getItemCount();
        int n13 = -1;
        if (n12 == 0) {
            return n13;
        }
        OrientationHelper orientationHelper = this.getOrientationHelper(recyclerView$LayoutManager);
        if (orientationHelper == null) {
            return n13;
        }
        int n14 = -1 << -1;
        int n15 = -1 >>> 1;
        int n16 = recyclerView$LayoutManager.getChildCount();
        View view = null;
        View view2 = null;
        for (int i10 = 0; i10 < n16; ++i10) {
            View view3 = recyclerView$LayoutManager.getChildAt(i10);
            if (view3 == null) continue;
            int n17 = this.distanceToCenter(view3, orientationHelper);
            if (n17 <= 0 && n17 > n14) {
                view2 = view3;
                n14 = n17;
            }
            if (n17 < 0 || n17 >= n15) continue;
            view = view3;
            n15 = n17;
        }
        if ((n10 = (int)(this.isForwardFling(recyclerView$LayoutManager, n10, n11) ? 1 : 0)) != 0 && view != null) {
            return recyclerView$LayoutManager.getPosition(view);
        }
        if (n10 == 0 && view2 != null) {
            return recyclerView$LayoutManager.getPosition(view2);
        }
        if (n10 != 0) {
            view = view2;
        }
        if (view == null) {
            return n13;
        }
        n11 = recyclerView$LayoutManager.getPosition(view);
        int n18 = this.isReverseLayout(recyclerView$LayoutManager);
        n18 = n18 == n10 ? n13 : 1;
        if ((n11 += n18) >= 0 && n11 < n12) {
            return n11;
        }
        return n13;
    }
}

