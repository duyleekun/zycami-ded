/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;

public class RecyclerView$2
implements Runnable {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$2(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void run() {
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.this$0.mItemAnimator;
        if (recyclerView$ItemAnimator != null) {
            recyclerView$ItemAnimator.runPendingAnimations();
        }
        this.this$0.mPostedAnimatorRunner = false;
    }
}

