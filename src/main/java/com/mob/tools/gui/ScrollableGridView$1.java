/*
 * Decompiled with CFR 0.151.
 */
package com.mob.tools.gui;

import com.mob.tools.gui.Scrollable;
import com.mob.tools.gui.Scrollable$OnScrollListener;
import com.mob.tools.gui.ScrollableGridView;

public class ScrollableGridView$1
implements Scrollable$OnScrollListener {
    public final /* synthetic */ ScrollableGridView this$0;

    public ScrollableGridView$1(ScrollableGridView scrollableGridView) {
        this.this$0 = scrollableGridView;
    }

    public void onScrollChanged(Scrollable scrollable, int n10, int n11, int n12, int n13) {
        scrollable = this.this$0;
        n10 = n11 <= 0 && n13 <= 0 ? 1 : 0;
        ScrollableGridView.access$002((ScrollableGridView)scrollable, n10 != 0);
    }
}

