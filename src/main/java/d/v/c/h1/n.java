/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.h1;

import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;

public class n
extends RecyclerView$AdapterDataObserver {
    public RecyclerView$AdapterDataObserver a;
    public int b;

    public n(RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver, int n10) {
        this.a = recyclerView$AdapterDataObserver;
        this.b = n10;
    }

    public void onChanged() {
        this.a.onChanged();
    }

    public void onItemRangeChanged(int n10, int n11) {
        RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.a;
        int n12 = this.b;
        recyclerView$AdapterDataObserver.onItemRangeChanged(n10 += n12, n11);
    }

    public void onItemRangeChanged(int n10, int n11, Object object) {
        RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.a;
        int n12 = this.b;
        recyclerView$AdapterDataObserver.onItemRangeChanged(n10 += n12, n11, object);
    }

    public void onItemRangeInserted(int n10, int n11) {
        RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.a;
        int n12 = this.b;
        recyclerView$AdapterDataObserver.onItemRangeInserted(n10 += n12, n11);
    }

    public void onItemRangeMoved(int n10, int n11, int n12) {
        int n13 = this.b;
        super.onItemRangeMoved(n10 += n13, n11 += n13, n12);
    }

    public void onItemRangeRemoved(int n10, int n11) {
        RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = this.a;
        int n12 = this.b;
        recyclerView$AdapterDataObserver.onItemRangeRemoved(n10 += n12, n11);
    }
}

