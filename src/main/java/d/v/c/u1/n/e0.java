/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.u1.n;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider;
import d.v.c.u1.n.e0$a;

public class e0
extends PagerSnapHelper {
    private static final float d = 70.0f;
    private OrientationHelper a;
    private OrientationHelper b;
    private RecyclerView c;

    public static /* synthetic */ RecyclerView a(e0 e02) {
        return e02.c;
    }

    private int b(RecyclerView$LayoutManager recyclerView$LayoutManager, View view, OrientationHelper orientationHelper) {
        int n10 = orientationHelper.getDecoratedStart(view);
        int n11 = orientationHelper.getStartAfterPadding();
        return n10 - n11;
    }

    private View c(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper orientationHelper) {
        int n10;
        RecyclerView$LayoutManager recyclerView$LayoutManager2;
        int n11 = recyclerView$LayoutManager.getChildCount();
        View view = null;
        if (n11 == 0) {
            return null;
        }
        int n12 = recyclerView$LayoutManager instanceof LinearLayoutManager;
        if (n12 != 0) {
            recyclerView$LayoutManager2 = recyclerView$LayoutManager;
            recyclerView$LayoutManager2 = (LinearLayoutManager)recyclerView$LayoutManager;
            n12 = ((LinearLayoutManager)recyclerView$LayoutManager2).findLastCompletelyVisibleItemPosition();
            if (n12 == (n10 = recyclerView$LayoutManager.getItemCount() + -1)) {
                return null;
            }
        }
        n12 = recyclerView$LayoutManager.getClipToPadding();
        n10 = 0;
        if (n12 != 0) {
            n12 = orientationHelper.getStartAfterPadding();
        } else {
            n12 = 0;
            recyclerView$LayoutManager2 = null;
        }
        int n13 = -1 >>> 1;
        while (n10 < n11) {
            View view2 = recyclerView$LayoutManager.getChildAt(n10);
            int n14 = Math.abs(orientationHelper.getDecoratedStart(view2) - n12);
            if (n14 < n13) {
                view = view2;
                n13 = n14;
            }
            ++n10;
        }
        return view;
    }

    private OrientationHelper getHorizontalHelper(RecyclerView$LayoutManager object) {
        Object object2 = this.b;
        if (object2 == null || (object2 = ((OrientationHelper)object2).getLayoutManager()) != object) {
            this.b = object = OrientationHelper.createHorizontalHelper((RecyclerView$LayoutManager)object);
        }
        return this.b;
    }

    private OrientationHelper getVerticalHelper(RecyclerView$LayoutManager object) {
        Object object2 = this.a;
        if (object2 == null || (object2 = ((OrientationHelper)object2).getLayoutManager()) != object) {
            this.a = object = OrientationHelper.createVerticalHelper((RecyclerView$LayoutManager)object);
        }
        return this.a;
    }

    public void attachToRecyclerView(RecyclerView recyclerView) {
        this.c = recyclerView;
        super.attachToRecyclerView(recyclerView);
    }

    public int[] calculateDistanceToFinalSnap(RecyclerView$LayoutManager recyclerView$LayoutManager, View view) {
        OrientationHelper orientationHelper;
        int n10 = 2;
        int[] nArray = new int[n10];
        int n11 = recyclerView$LayoutManager.canScrollHorizontally();
        if (n11 != 0) {
            orientationHelper = this.getHorizontalHelper(recyclerView$LayoutManager);
            nArray[0] = n11 = this.b(recyclerView$LayoutManager, view, orientationHelper);
        } else {
            nArray[0] = 0;
        }
        n11 = recyclerView$LayoutManager.canScrollVertically();
        int n12 = 1;
        if (n11 != 0) {
            int n13;
            orientationHelper = this.getVerticalHelper(recyclerView$LayoutManager);
            nArray[n12] = n13 = this.b(recyclerView$LayoutManager, view, orientationHelper);
        } else {
            nArray[n12] = 0;
        }
        return nArray;
    }

    public LinearSmoothScroller createSnapScroller(RecyclerView$LayoutManager object) {
        boolean bl2 = object instanceof RecyclerView$SmoothScroller$ScrollVectorProvider;
        if (!bl2) {
            return null;
        }
        Context context = this.c.getContext();
        object = new e0$a(this, context);
        return object;
    }

    public View findSnapView(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        boolean bl2 = recyclerView$LayoutManager.canScrollVertically();
        if (bl2) {
            OrientationHelper orientationHelper = this.getVerticalHelper(recyclerView$LayoutManager);
            return this.c(recyclerView$LayoutManager, orientationHelper);
        }
        OrientationHelper orientationHelper = this.getHorizontalHelper(recyclerView$LayoutManager);
        return this.c(recyclerView$LayoutManager, orientationHelper);
    }
}

