/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.gui.Scrollable;
import com.mob.tools.gui.Scrollable$OnScrollListener;
import com.mob.tools.gui.ScrollableListView;

public class ScrollableListView$1
implements Scrollable$OnScrollListener {
    public final /* synthetic */ ScrollableListView this$0;

    public ScrollableListView$1(ScrollableListView scrollableListView) {
        this.this$0 = scrollableListView;
    }

    public void onScrollChanged(Scrollable scrollable, int n10, int n11, int n12, int n13) {
        scrollable = this.this$0;
        n10 = n11 <= 0 && n13 <= 0 ? 1 : 0;
        ScrollableListView.access$002((ScrollableListView)scrollable, n10 != 0);
    }
}

