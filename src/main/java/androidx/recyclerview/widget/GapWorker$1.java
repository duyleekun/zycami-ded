/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.GapWorker$Task;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Comparator;

public class GapWorker$1
implements Comparator {
    public int compare(GapWorker$Task gapWorker$Task, GapWorker$Task gapWorker$Task2) {
        int n10;
        RecyclerView recyclerView = gapWorker$Task.view;
        int n11 = 1;
        int n12 = recyclerView == null ? n11 : 0;
        RecyclerView recyclerView2 = gapWorker$Task2.view;
        if (recyclerView2 == null) {
            n10 = n11;
        } else {
            n10 = 0;
            recyclerView2 = null;
        }
        int n13 = -1;
        float f10 = 0.0f / 0.0f;
        if (n12 != n10) {
            if (recyclerView != null) {
                n11 = n13;
            }
            return n11;
        }
        int n14 = gapWorker$Task.immediate;
        n12 = (int)(gapWorker$Task2.immediate ? 1 : 0);
        if (n14 != n12) {
            if (n14 != 0) {
                n11 = n13;
            }
            return n11;
        }
        n14 = gapWorker$Task2.viewVelocity;
        n11 = gapWorker$Task.viewVelocity;
        if ((n14 -= n11) != 0) {
            return n14;
        }
        int n15 = gapWorker$Task.distanceToItem;
        int n16 = gapWorker$Task2.distanceToItem;
        if ((n15 -= n16) != 0) {
            return n15;
        }
        return 0;
    }
}

