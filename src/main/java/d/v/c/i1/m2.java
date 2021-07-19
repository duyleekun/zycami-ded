/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources
 *  android.graphics.drawable.Drawable
 */
package d.v.c.i1;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d.v.c.i1.m2$a;
import d.v.c.i1.n2;
import d.v.e.l.o1;
import java.util.Collections;
import java.util.List;

public abstract class m2
extends ItemTouchHelper$Callback {
    private m2$a a;

    private boolean b(RecyclerView recyclerView) {
        return recyclerView.getAdapter() instanceof n2;
    }

    public abstract List a();

    public void c(m2$a m2$a) {
        this.a = m2$a;
    }

    public boolean canDropOver(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        RecyclerView$Adapter recyclerView$Adapter = recyclerView.getAdapter();
        RecyclerView$Adapter recyclerView$Adapter2 = recyclerView.getAdapter();
        boolean bl2 = recyclerView$Adapter2 instanceof n2;
        if (bl2) {
            recyclerView$Adapter = (n2)recyclerView$Adapter;
            int n10 = recyclerView$ViewHolder2.getAdapterPosition();
            return ((n2)recyclerView$Adapter).s(n10) ^ true;
        }
        return super.canDropOver(recyclerView, recyclerView$ViewHolder, recyclerView$ViewHolder2);
    }

    public void clearView(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        super.clearView(recyclerView, recyclerView$ViewHolder);
        m2$a m2$a = this.a;
        if (m2$a != null) {
            int n10 = recyclerView$ViewHolder.getAdapterPosition() + -1;
            m2$a.b(n10);
        }
        recyclerView$ViewHolder.itemView.setForeground(null);
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return ItemTouchHelper$Callback.makeMovementFlags(15, 0);
    }

    public boolean isLongPressDragEnabled() {
        return false;
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        int n10;
        int n11 = recyclerView$ViewHolder.getAdapterPosition();
        int n12 = recyclerView$ViewHolder2.getAdapterPosition();
        int n13 = this.b(recyclerView);
        if (n13 != 0) {
            n13 = n11 + -1;
            n10 = n12 + -1;
        } else {
            n13 = n11;
            n10 = n12;
        }
        Object object = this.a;
        if (object != null) {
            object.c(n13, n10);
        }
        object = this.a();
        int n14 = object.size();
        if (n13 >= 0 && n13 < n14 && n10 >= 0 && n10 < n14) {
            if (n13 < n10) {
                while (n13 < n10) {
                    n14 = n13 + 1;
                    Collections.swap(object, n13, n14);
                    n13 = n14;
                }
            } else {
                while (n13 > n10) {
                    n14 = n13 + -1;
                    Collections.swap(object, n13, n14);
                    n13 += -1;
                }
            }
            recyclerView.getAdapter().notifyItemMoved(n11, n12);
            return true;
        }
        return false;
    }

    public void onSelectedChanged(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        if (n10 != 0 && recyclerView$ViewHolder != null) {
            Object object = recyclerView$ViewHolder.itemView;
            Resources resources = object.getResources();
            int n11 = 2131232086;
            resources = o1.o(resources, n11);
            object.setForeground((Drawable)resources);
            object = this.a;
            if (object != null) {
                int n12 = recyclerView$ViewHolder.getAdapterPosition() + -1;
                object.a(n12);
            }
        }
        super.onSelectedChanged(recyclerView$ViewHolder, n10);
    }

    public void onSwiped(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
    }
}

