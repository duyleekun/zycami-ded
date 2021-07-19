/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.View
 */
package androidx.recyclerview.widget;

import android.view.View;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView$ChildDrawingOrderCallback;

public class ItemTouchHelper$5
implements RecyclerView$ChildDrawingOrderCallback {
    public final /* synthetic */ ItemTouchHelper this$0;

    public ItemTouchHelper$5(ItemTouchHelper itemTouchHelper) {
        this.this$0 = itemTouchHelper;
    }

    public int onGetChildDrawingOrder(int n10, int n11) {
        ItemTouchHelper itemTouchHelper = this.this$0;
        View view = itemTouchHelper.mOverdrawChild;
        if (view == null) {
            return n11;
        }
        int n12 = itemTouchHelper.mOverdrawChildPosition;
        int n13 = -1;
        if (n12 == n13) {
            n12 = itemTouchHelper.mRecyclerView.indexOfChild(view);
            itemTouchHelper = this.this$0;
            itemTouchHelper.mOverdrawChildPosition = n12;
        }
        if (n11 == (n10 += -1)) {
            return n12;
        }
        if (n11 >= n12) {
            ++n11;
        }
        return n11;
    }
}

