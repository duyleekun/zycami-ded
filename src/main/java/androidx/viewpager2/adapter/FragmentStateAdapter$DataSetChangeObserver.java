/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.adapter;

import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.viewpager2.adapter.FragmentStateAdapter$1;

public abstract class FragmentStateAdapter$DataSetChangeObserver
extends RecyclerView$AdapterDataObserver {
    private FragmentStateAdapter$DataSetChangeObserver() {
    }

    public /* synthetic */ FragmentStateAdapter$DataSetChangeObserver(FragmentStateAdapter$1 fragmentStateAdapter$1) {
        this();
    }

    public abstract void onChanged();

    public final void onItemRangeChanged(int n10, int n11) {
        this.onChanged();
    }

    public final void onItemRangeChanged(int n10, int n11, Object object) {
        this.onChanged();
    }

    public final void onItemRangeInserted(int n10, int n11) {
        this.onChanged();
    }

    public final void onItemRangeMoved(int n10, int n11, int n12) {
        this.onChanged();
    }

    public final void onItemRangeRemoved(int n10, int n11) {
        this.onChanged();
    }
}

