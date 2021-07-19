/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 *  android.widget.ListView
 */
package androidx.core.widget;

import android.view.View;
import android.widget.ListView;
import androidx.core.widget.AutoScrollHelper;
import androidx.core.widget.ListViewCompat;

public class ListViewAutoScrollHelper
extends AutoScrollHelper {
    private final ListView mTarget;

    public ListViewAutoScrollHelper(ListView listView) {
        super((View)listView);
        this.mTarget = listView;
    }

    public boolean canTargetScrollHorizontally(int n10) {
        return false;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean canTargetScrollVertically(int n10) {
        View view;
        ListView listView = this.mTarget;
        int n11 = listView.getCount();
        if (n11 == 0) {
            return false;
        }
        int n12 = listView.getChildCount();
        int n13 = listView.getFirstVisiblePosition();
        int n14 = n13 + n12;
        int n15 = 1;
        if (n10 > 0) {
            int n16;
            View view2;
            if (n14 < n11 || (n10 = (view2 = listView.getChildAt(n12 -= n15)).getBottom()) > (n16 = listView.getHeight())) return n15 != 0;
            return false;
        }
        if (n10 >= 0) return false;
        if (n13 > 0 || (n10 = (view = listView.getChildAt(0)).getTop()) < 0) return n15 != 0;
        return false;
    }

    public void scrollTargetBy(int n10, int n11) {
        ListViewCompat.scrollListBy(this.mTarget, n11);
    }
}

