/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.animation.Animator;
import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class ItemTouchHelper$3
extends ItemTouchHelper$RecoverAnimation {
    public final /* synthetic */ ItemTouchHelper this$0;
    public final /* synthetic */ RecyclerView$ViewHolder val$prevSelected;
    public final /* synthetic */ int val$swipeDir;

    public ItemTouchHelper$3(ItemTouchHelper itemTouchHelper, RecyclerView$ViewHolder recyclerView$ViewHolder, int n10, int n11, float f10, float f11, float f12, float f13, int n12, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        this.this$0 = itemTouchHelper;
        this.val$swipeDir = n12;
        this.val$prevSelected = recyclerView$ViewHolder2;
        super(recyclerView$ViewHolder, n10, n11, f10, f11, f12, f13);
    }

    public void onAnimationEnd(Animator object) {
        RecyclerView$ViewHolder recyclerView$ViewHolder;
        Object object2;
        super.onAnimationEnd((Animator)object);
        int n10 = this.mOverridden;
        if (n10 != 0) {
            return;
        }
        n10 = this.val$swipeDir;
        if (n10 <= 0) {
            object = this.this$0;
            object2 = ((ItemTouchHelper)object).mCallback;
            object = ((ItemTouchHelper)object).mRecyclerView;
            recyclerView$ViewHolder = this.val$prevSelected;
            ((ItemTouchHelper$Callback)object2).clearView((RecyclerView)object, recyclerView$ViewHolder);
        } else {
            object = this.this$0.mPendingCleanup;
            object2 = this.val$prevSelected.itemView;
            object.add(object2);
            this.mIsPendingCleanup = true;
            n10 = this.val$swipeDir;
            if (n10 > 0) {
                object2 = this.this$0;
                ((ItemTouchHelper)object2).postDispatchSwipe(this, n10);
            }
        }
        object = this.this$0;
        object2 = ((ItemTouchHelper)object).mOverdrawChild;
        recyclerView$ViewHolder = this.val$prevSelected.itemView;
        if (object2 == recyclerView$ViewHolder) {
            ((ItemTouchHelper)object).removeChildDrawingOrderCallbackIfNecessary((View)recyclerView$ViewHolder);
        }
    }
}

