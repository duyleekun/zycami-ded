/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.ItemTouchHelper$RecoverAnimation;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ItemAnimator;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class ItemTouchHelper$4
implements Runnable {
    public final /* synthetic */ ItemTouchHelper this$0;
    public final /* synthetic */ ItemTouchHelper$RecoverAnimation val$anim;
    public final /* synthetic */ int val$swipeDir;

    public ItemTouchHelper$4(ItemTouchHelper itemTouchHelper, ItemTouchHelper$RecoverAnimation recoverAnimation, int n10) {
        this.this$0 = itemTouchHelper;
        this.val$anim = recoverAnimation;
        this.val$swipeDir = n10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public void run() {
        Object object;
        block5: {
            RecyclerView$ViewHolder recyclerView$ViewHolder;
            int n10;
            block4: {
                object = this.this$0.mRecyclerView;
                if (object == null) return;
                n10 = ((RecyclerView)object).isAttachedToWindow();
                if (n10 == 0) return;
                object = this.val$anim;
                int n11 = ((ItemTouchHelper$RecoverAnimation)object).mOverridden;
                if (n11 != 0) return;
                object = ((ItemTouchHelper$RecoverAnimation)object).mViewHolder;
                n10 = ((RecyclerView$ViewHolder)object).getAbsoluteAdapterPosition();
                if (n10 == (n11 = -1)) return;
                object = this.this$0.mRecyclerView.getItemAnimator();
                if (object == null) break block4;
                n11 = 0;
                recyclerView$ViewHolder = null;
                n10 = (int)(((RecyclerView$ItemAnimator)object).isRunning(null) ? 1 : 0);
                if (n10 != 0) break block5;
            }
            if ((n10 = (int)(((ItemTouchHelper)(object = this.this$0)).hasRunningRecoverAnim() ? 1 : 0)) == 0) {
                object = this.this$0.mCallback;
                recyclerView$ViewHolder = this.val$anim.mViewHolder;
                int n12 = this.val$swipeDir;
                ((ItemTouchHelper$Callback)object).onSwiped(recyclerView$ViewHolder, n12);
                return;
            }
        }
        object = this.this$0.mRecyclerView;
        object.post((Runnable)this);
    }
}

