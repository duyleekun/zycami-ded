/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.widget.AbsListView
 *  android.widget.AbsListView$OnScrollListener
 */
package com.mob.tools.gui;

import android.widget.AbsListView;
import com.mob.tools.gui.PullToRequestListAdapter;
import com.mob.tools.gui.Scrollable;

public class PullToRequestListAdapter$1
implements AbsListView.OnScrollListener {
    private int firstVisibleItem;
    public final /* synthetic */ PullToRequestListAdapter this$0;
    private int visibleItemCount;

    public PullToRequestListAdapter$1(PullToRequestListAdapter pullToRequestListAdapter) {
        this.this$0 = pullToRequestListAdapter;
    }

    public void onScroll(AbsListView object, int n10, int n11, int n12) {
        int n13;
        this.firstVisibleItem = n10;
        this.visibleItemCount = n11;
        int n14 = n11 + -1;
        Object object2 = object.getChildAt(n14);
        PullToRequestListAdapter pullToRequestListAdapter = this.this$0;
        int n15 = n10 + n11;
        if (n15 == n12 && object2 != null && (n14 = object2.getBottom()) <= (n13 = object.getBottom())) {
            n13 = 1;
        } else {
            n13 = 0;
            object = null;
        }
        PullToRequestListAdapter.access$302(pullToRequestListAdapter, n13 != 0);
        object = this.this$0;
        object2 = PullToRequestListAdapter.access$400((PullToRequestListAdapter)object);
        ((PullToRequestListAdapter)object).onScroll((Scrollable)object2, n10, n11, n12);
    }

    public void onScrollStateChanged(AbsListView object, int n10) {
        object = this.this$0;
        int n11 = 2;
        n11 = n10 == n11 ? 1 : 0;
        PullToRequestListAdapter.access$002((PullToRequestListAdapter)object, n11 != 0);
        if (n10 == 0) {
            object = PullToRequestListAdapter.access$100(this.this$0);
            if (object != null) {
                object = PullToRequestListAdapter.access$100(this.this$0);
                n10 = this.firstVisibleItem;
                n11 = this.visibleItemCount;
                object.onListStopScrolling(n10, n11);
            } else {
                object = PullToRequestListAdapter.access$200(this.this$0);
                if (object != null) {
                    object = PullToRequestListAdapter.access$200(this.this$0);
                    object.notifyDataSetChanged();
                }
            }
        }
    }
}

