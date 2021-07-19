/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.FastScroller;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;

public class FastScroller$2
extends RecyclerView$OnScrollListener {
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$2(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void onScrolled(RecyclerView recyclerView, int n10, int n11) {
        FastScroller fastScroller = this.this$0;
        n11 = recyclerView.computeHorizontalScrollOffset();
        int n12 = recyclerView.computeVerticalScrollOffset();
        fastScroller.updateScrollPosition(n11, n12);
    }
}

