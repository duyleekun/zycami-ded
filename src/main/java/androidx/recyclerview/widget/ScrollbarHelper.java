/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$State;

public class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    public static int computeScrollExtent(RecyclerView$State recyclerView$State, OrientationHelper orientationHelper, View view, View view2, RecyclerView$LayoutManager recyclerView$LayoutManager, boolean bl2) {
        int n10;
        int n11 = recyclerView$LayoutManager.getChildCount();
        if (n11 != 0 && (n10 = recyclerView$State.getItemCount()) != 0 && view != null && view2 != null) {
            if (!bl2) {
                n10 = recyclerView$LayoutManager.getPosition(view);
                int n12 = recyclerView$LayoutManager.getPosition(view2);
                return Math.abs(n10 - n12) + 1;
            }
            n10 = orientationHelper.getDecoratedEnd(view2);
            int n13 = orientationHelper.getDecoratedStart(view);
            return Math.min(orientationHelper.getTotalSpace(), n10 -= n13);
        }
        return 0;
    }

    /*
     * WARNING - void declaration
     */
    public static int computeScrollOffset(RecyclerView$State recyclerView$State, OrientationHelper orientationHelper, View view, View view2, RecyclerView$LayoutManager recyclerView$LayoutManager, boolean bl2, boolean bl3) {
        int n10 = recyclerView$LayoutManager.getChildCount();
        if (n10 != 0 && (n10 = recyclerView$State.getItemCount()) != 0 && view != null && view2 != null) {
            int n11;
            void var6_8;
            n10 = recyclerView$LayoutManager.getPosition(view);
            int n12 = recyclerView$LayoutManager.getPosition(view2);
            n10 = Math.min(n10, n12);
            n12 = recyclerView$LayoutManager.getPosition(view);
            int n13 = recyclerView$LayoutManager.getPosition(view2);
            n12 = Math.max(n12, n13);
            if (var6_8 != false) {
                n11 = recyclerView$State.getItemCount() - n12 + -1;
                n11 = Math.max(0, n11);
            } else {
                n11 = Math.max(0, n10);
            }
            if (!bl2) {
                return n11;
            }
            int n14 = orientationHelper.getDecoratedEnd(view2);
            int n15 = orientationHelper.getDecoratedStart(view);
            int n16 = Math.abs(n14 - n15);
            int n17 = recyclerView$LayoutManager.getPosition(view);
            int n18 = recyclerView$LayoutManager.getPosition(view2);
            n18 = Math.abs(n17 - n18) + 1;
            float f10 = n16;
            float f11 = n18;
            float f12 = (float)n11 * (f10 /= f11);
            n18 = orientationHelper.getStartAfterPadding();
            int n19 = orientationHelper.getDecoratedStart(view);
            float f13 = n18 - n19;
            return Math.round(f12 + f13);
        }
        return 0;
    }

    public static int computeScrollRange(RecyclerView$State recyclerView$State, OrientationHelper orientationHelper, View view, View view2, RecyclerView$LayoutManager recyclerView$LayoutManager, boolean bl2) {
        int n10 = recyclerView$LayoutManager.getChildCount();
        if (n10 != 0 && (n10 = recyclerView$State.getItemCount()) != 0 && view != null && view2 != null) {
            if (!bl2) {
                return recyclerView$State.getItemCount();
            }
            int n11 = orientationHelper.getDecoratedEnd(view2);
            int n12 = orientationHelper.getDecoratedStart(view);
            int n13 = n11 - n12;
            n12 = recyclerView$LayoutManager.getPosition(view);
            int n14 = recyclerView$LayoutManager.getPosition(view2);
            n12 = Math.abs(n12 - n14) + 1;
            float f10 = n13;
            float f11 = n12;
            float f12 = recyclerView$State.getItemCount();
            return (int)((f10 /= f11) * f12);
        }
        return 0;
    }
}

