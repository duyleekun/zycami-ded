/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView;

public class ViewPager2$SmoothScrollToPosition
implements Runnable {
    private final int mPosition;
    private final RecyclerView mRecyclerView;

    public ViewPager2$SmoothScrollToPosition(int n10, RecyclerView recyclerView) {
        this.mPosition = n10;
        this.mRecyclerView = recyclerView;
    }

    public void run() {
        RecyclerView recyclerView = this.mRecyclerView;
        int n10 = this.mPosition;
        recyclerView.smoothScrollToPosition(n10);
    }
}

