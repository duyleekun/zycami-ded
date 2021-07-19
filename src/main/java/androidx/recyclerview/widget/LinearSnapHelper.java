/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.graphics.PointF;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import androidx.recyclerview.widget.SnapHelper;

public class LinearSnapHelper
extends SnapHelper {
    private static final float INVALID_DISTANCE = 1.0f;
    private OrientationHelper mHorizontalHelper;
    private OrientationHelper mVerticalHelper;

    private float computeDistancePerChild(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper) {
        int n10 = recyclerView$LayoutManager.getChildCount();
        float f10 = 1.0f;
        if (n10 == 0) {
            return f10;
        }
        View view = null;
        int n11 = -1 << -1;
        int n12 = -1 >>> 1;
        View view2 = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            int n13;
            View view3 = recyclerView$LayoutManager.getChildAt(i10);
            int n14 = recyclerView$LayoutManager.getPosition(view3);
            if (n14 == (n13 = -1)) continue;
            if (n14 < n12) {
                view = view3;
                n12 = n14;
            }
            if (n14 <= n11) continue;
            view2 = view3;
            n11 = n14;
        }
        if (view != null && view2 != null) {
            int n15 = orientationHelper.getDecoratedStart(view);
            n10 = orientationHelper.getDecoratedStart(view2);
            n15 = Math.min(n15, n10);
            n10 = orientationHelper.getDecoratedEnd(view);
            int n16 = orientationHelper.getDecoratedEnd(view2);
            if ((n16 = Math.max(n10, n16) - n15) == 0) {
                return f10;
            }
            float f11 = (float)n16 * f10;
            float f12 = n11 - n12 + 1;
            return f11 / f12;
        }
        return f10;
    }

    private int distanceToCenter(View view, OrientationHelper orientationHelper) {
        int n10 = orientationHelper.getDecoratedStart(view);
        int n11 = orientationHelper.getDecoratedMeasurement(view) / 2;
        n10 += n11;
        n11 = orientationHelper.getStartAfterPadding();
        int n12 = orientationHelper.getTotalSpace() / 2;
        return n10 - (n11 += n12);
    }

    private int estimateNextPositionDiffForFling(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper, int n10, int n11) {
        int n12;
        int n13;
        int[] nArray = this.calculateScrollDistance(n10, n11);
        float f10 = this.computeDistancePerChild(recyclerView$LayoutManager, orientationHelper);
        orientationHelper = null;
        float f11 = f10 - 0.0f;
        float f12 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
        n11 = 0;
        if (f12 <= 0) {
            return 0;
        }
        f12 = Math.abs(nArray[0]);
        f12 = f12 > (n13 = Math.abs(nArray[n12 = 1])) ? (float)nArray[0] : (float)nArray[n12];
        return Math.round((float)f12 / f10);
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

    private OrientationHelper getVerticalHelper(RecyclerView$LayoutManager object) {
        Object object2 = this.mVerticalHelper;
        if (object2 == null || (object2 = ((OrientationHelper)object2).mLayoutManager) != object) {
            this.mVerticalHelper = object = OrientationHelper.createVerticalHelper((RecyclerView$LayoutManager)object);
        }
        return this.mVerticalHelper;
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
        boolean bl2;
        OrientationHelper orientationHelper;
        int n12 = recyclerView$LayoutManager instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        int n13 = -1;
        if (n12 == 0) {
            return n13;
        }
        n12 = recyclerView$LayoutManager.getItemCount();
        if (n12 == 0) {
            return n13;
        }
        View view = this.findSnapView(recyclerView$LayoutManager);
        if (view == null) {
            return n13;
        }
        int n14 = recyclerView$LayoutManager.getPosition(view);
        if (n14 == n13) {
            return n13;
        }
        Object object = recyclerView$LayoutManager;
        object = (RecyclerView$SmoothScroller$ScrollVectorProvider)((Object)recyclerView$LayoutManager);
        int n15 = n12 + -1;
        if ((object = object.computeScrollVectorForPosition(n15)) == null) {
            return n13;
        }
        Object object2 = recyclerView$LayoutManager.canScrollHorizontally();
        int n16 = 0;
        if (object2 != 0) {
            orientationHelper = this.getHorizontalHelper(recyclerView$LayoutManager);
            n10 = this.estimateNextPositionDiffForFling(recyclerView$LayoutManager, orientationHelper, n10, 0);
            float f10 = ((PointF)object).x;
            float f11 = f10 - 0.0f;
            object2 = f11 == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1);
            if (object2 < 0) {
                n10 = -n10;
            }
        } else {
            n10 = 0;
        }
        if ((object2 = recyclerView$LayoutManager.canScrollVertically()) != 0) {
            orientationHelper = this.getVerticalHelper(recyclerView$LayoutManager);
            n11 = this.estimateNextPositionDiffForFling(recyclerView$LayoutManager, orientationHelper, 0, n11);
            float f12 = ((PointF)object).y;
            float f13 = f12 - 0.0f;
            Object object3 = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
            if (object3 < 0) {
                n11 = -n11;
            }
        } else {
            n11 = 0;
        }
        if (bl2 = recyclerView$LayoutManager.canScrollVertically()) {
            n10 = n11;
        }
        if (n10 == 0) {
            return n13;
        }
        if ((n14 += n10) >= 0) {
            n16 = n14;
        }
        if (n16 < n12) {
            n15 = n16;
        }
        return n15;
    }
}

