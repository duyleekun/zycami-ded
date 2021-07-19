/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemAnimatorListener;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class RecyclerView$ItemAnimatorRestoreListener
implements RecyclerView$ItemAnimator$ItemAnimatorListener {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$ItemAnimatorRestoreListener(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void onAnimationFinished(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean bl2 = true;
        recyclerView$ViewHolder.setIsRecyclable(bl2);
        Object object = recyclerView$ViewHolder.mShadowedHolder;
        View view = null;
        if (object != null && (object = recyclerView$ViewHolder.mShadowingHolder) == null) {
            recyclerView$ViewHolder.mShadowedHolder = null;
        }
        recyclerView$ViewHolder.mShadowingHolder = null;
        bl2 = recyclerView$ViewHolder.shouldBeKeptAsChild();
        if (!bl2 && !(bl2 = ((RecyclerView)(object = this.this$0)).removeAnimatingView(view = recyclerView$ViewHolder.itemView)) && (bl2 = recyclerView$ViewHolder.isTmpDetached())) {
            object = this.this$0;
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            view = null;
            ((RecyclerView)object).removeDetachedView((View)recyclerView$ViewHolder, false);
        }
    }
}

