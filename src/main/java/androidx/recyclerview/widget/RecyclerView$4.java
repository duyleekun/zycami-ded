/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator$ItemHolderInfo;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import androidx.recyclerview.widget.RecyclerView$Recycler;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import androidx.recyclerview.widget.ViewInfoStore$ProcessCallback;

public class RecyclerView$4
implements ViewInfoStore$ProcessCallback {
    public final /* synthetic */ RecyclerView this$0;

    public RecyclerView$4(RecyclerView recyclerView) {
        this.this$0 = recyclerView;
    }

    public void processAppeared(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        this.this$0.animateAppearance(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
    }

    public void processDisappeared(RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        this.this$0.mRecycler.unscrapView(recyclerView$ViewHolder);
        this.this$0.animateDisappearance(recyclerView$ViewHolder, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
    }

    public void processPersistent(RecyclerView$ViewHolder object, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo, RecyclerView$ItemAnimator$ItemHolderInfo recyclerView$ItemAnimator$ItemHolderInfo2) {
        ((RecyclerView$ViewHolder)object).setIsRecyclable(false);
        Object object2 = this.this$0;
        boolean bl2 = ((RecyclerView)object2).mDataSetHasChangedAfterLayout;
        if (bl2) {
            object2 = ((RecyclerView)object2).mItemAnimator;
            boolean bl3 = ((RecyclerView$ItemAnimator)object2).animateChange((RecyclerView$ViewHolder)object, (RecyclerView$ViewHolder)object, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
            if (bl3) {
                object = this.this$0;
                ((RecyclerView)object).postAnimationRunner();
            }
        } else {
            object2 = ((RecyclerView)object2).mItemAnimator;
            boolean bl4 = ((RecyclerView$ItemAnimator)object2).animatePersistence((RecyclerView$ViewHolder)object, recyclerView$ItemAnimator$ItemHolderInfo, recyclerView$ItemAnimator$ItemHolderInfo2);
            if (bl4) {
                object = this.this$0;
                ((RecyclerView)object).postAnimationRunner();
            }
        }
    }

    public void unused(RecyclerView$ViewHolder recyclerView$ViewHolder) {
        Object object = this.this$0;
        RecyclerView$LayoutManager recyclerView$LayoutManager = ((RecyclerView)object).mLayout;
        recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
        object = ((RecyclerView)object).mRecycler;
        recyclerView$LayoutManager.removeAndRecycleView((View)recyclerView$ViewHolder, (RecyclerView$Recycler)object);
    }
}

