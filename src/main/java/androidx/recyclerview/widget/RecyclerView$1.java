/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView$1
implements Runnable {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$1(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void run() {
        boolean bl2;
        RecyclerView recyclerView = this.this$0;
        boolean bl3 = recyclerView.mFirstLayoutComplete;
        if (bl3 && !(bl2 = recyclerView.isLayoutRequested())) {
            recyclerView = this.this$0;
            bl3 = recyclerView.mIsAttached;
            if (!bl3) {
                recyclerView.requestLayout();
                return;
            }
            bl3 = recyclerView.mLayoutSuppressed;
            if (bl3) {
                recyclerView.mLayoutWasDefered = true;
                return;
            }
            recyclerView.consumePendingUpdateOperations();
        }
    }
}

