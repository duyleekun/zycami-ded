/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Rect
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.OrientationHelper$1;
import androidx.recyclerview.widget.OrientationHelper$2;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;

public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace = -1 << -1;
    public final RecyclerView$LayoutManager mLayoutManager;
    public final Rect mTmpRect;

    private OrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        Rect rect;
        this.mTmpRect = rect = new Rect();
        this.mLayoutManager = recyclerView$LayoutManager;
    }

    public /* synthetic */ OrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper$1 var2_2) {
        this(recyclerView$LayoutManager);
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        OrientationHelper$1 orientationHelper$1 = new OrientationHelper$1(recyclerView$LayoutManager);
        return orientationHelper$1;
    }

    public static OrientationHelper createOrientationHelper(RecyclerView$LayoutManager object, int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return OrientationHelper.createVerticalHelper((RecyclerView$LayoutManager)object);
            }
            object = new IllegalArgumentException("invalid orientation");
            throw object;
        }
        return OrientationHelper.createHorizontalHelper((RecyclerView$LayoutManager)object);
    }

    public static OrientationHelper createVerticalHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        OrientationHelper$2 orientationHelper$2 = new OrientationHelper$2(recyclerView$LayoutManager);
        return orientationHelper$2;
    }

    public abstract int getDecoratedEnd(View var1);

    public abstract int getDecoratedMeasurement(View var1);

    public abstract int getDecoratedMeasurementInOther(View var1);

    public abstract int getDecoratedStart(View var1);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public RecyclerView$LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        int n10 = -1 << -1;
        int n11 = this.mLastTotalSpace;
        if (n10 == n11) {
            n11 = 0;
        } else {
            n11 = this.getTotalSpace();
            n10 = this.mLastTotalSpace;
            n11 -= n10;
        }
        return n11;
    }

    public abstract int getTransformedEndWithDecoration(View var1);

    public abstract int getTransformedStartWithDecoration(View var1);

    public abstract void offsetChild(View var1, int var2);

    public abstract void offsetChildren(int var1);

    public void onLayoutComplete() {
        int n10;
        this.mLastTotalSpace = n10 = this.getTotalSpace();
    }
}

