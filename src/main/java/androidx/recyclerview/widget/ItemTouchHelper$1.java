/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;

public class ItemTouchHelper$1
implements Runnable {
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$1(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public void run() {
        boolean bl2;
        Object object = this.this$0;
        Object object2 = ((ItemTouchHelper)object).mSelected;
        if (object2 != null && (bl2 = ((ItemTouchHelper)object).scrollIfNecessary())) {
            object = this.this$0;
            object2 = ((ItemTouchHelper)object).mSelected;
            if (object2 != null) {
                ((ItemTouchHelper)object).moveIfNecessary((RecyclerView$ViewHolder)object2);
            }
            object = this.this$0;
            object2 = ((ItemTouchHelper)object).mRecyclerView;
            object = ((ItemTouchHelper)object).mScrollRunnable;
            object2.removeCallbacks((Runnable)object);
            object = this.this$0.mRecyclerView;
            ViewCompat.postOnAnimation((View)object, this);
        }
    }
}

