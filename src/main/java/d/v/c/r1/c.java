/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.r1;

import androidx.recyclerview.widget.ItemTouchHelper$Callback;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d.v.c.r1.c$a;
import java.util.Collections;
import java.util.List;

public class c
extends ItemTouchHelper$Callback {
    private c$a a;
    private List b;
    private boolean c = true;

    public c(List list) {
        this.b = list;
    }

    public c(List list, boolean bl2) {
        this.b = list;
        this.c = bl2;
    }

    public void a(c$a c$a) {
        this.a = c$a;
    }

    public void clearView(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        boolean bl2;
        super.clearView(recyclerView, recyclerView$ViewHolder);
        c$a c$a = this.a;
        if (c$a != null) {
            int n10 = recyclerView$ViewHolder.getAdapterPosition();
            c$a.b(n10);
        }
        if (bl2 = this.c) {
            recyclerView$ViewHolder = recyclerView$ViewHolder.itemView;
            bl2 = false;
            c$a = null;
            recyclerView$ViewHolder.setBackground(null);
        }
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    public int getMovementFlags(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder) {
        return ItemTouchHelper$Callback.makeMovementFlags(15, 0);
    }

    public boolean onMove(RecyclerView recyclerView, RecyclerView$ViewHolder recyclerView$ViewHolder, RecyclerView$ViewHolder recyclerView$ViewHolder2) {
        int n10;
        int n11;
        int n12;
        c$a c$a = this.a;
        if (c$a != null) {
            int n13 = recyclerView$ViewHolder.getAdapterPosition();
            n12 = recyclerView$ViewHolder2.getAdapterPosition();
            c$a.c(n13, n12);
        }
        if ((n11 = recyclerView$ViewHolder.getAdapterPosition()) < (n10 = recyclerView$ViewHolder2.getAdapterPosition())) {
            int n14 = n11;
            while (n14 < n10) {
                List list = this.b;
                n12 = n14 + 1;
                Collections.swap(list, n14, n12);
                n14 = n12;
            }
        } else {
            for (int i10 = n11; i10 > n10; i10 += -1) {
                List list = this.b;
                n12 = i10 + -1;
                Collections.swap(list, i10, n12);
            }
        }
        recyclerView.getAdapter().notifyItemMoved(n11, n10);
        return true;
    }

    public void onSelectedChanged(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
        if (n10 != 0 && recyclerView$ViewHolder != null) {
            int n11;
            Object object;
            boolean bl2 = this.c;
            if (bl2) {
                object = recyclerView$ViewHolder.itemView;
                n11 = 2131232085;
                object.setBackgroundResource(n11);
            }
            if ((object = this.a) != null) {
                n11 = recyclerView$ViewHolder.getAdapterPosition();
                object.a(n11);
            }
        }
        super.onSelectedChanged(recyclerView$ViewHolder, n10);
    }

    public void onSwiped(RecyclerView$ViewHolder recyclerView$ViewHolder, int n10) {
    }
}

