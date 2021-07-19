/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StaggeredGridLayoutManager;

public class StaggeredGridLayoutManager$1
implements Runnable {
    public final /* synthetic */ StaggeredGridLayoutManager this$0;

    public StaggeredGridLayoutManager$1(StaggeredGridLayoutManager staggeredGridLayoutManager) {
        this.this$0 = staggeredGridLayoutManager;
    }

    public void run() {
        this.this$0.checkForGaps();
    }
}

