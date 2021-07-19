/*
 * Decompiled with CFR 0.151.
 */
package androidx.viewpager2.widget;

import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import androidx.viewpager2.widget.ViewPager2$1;

public abstract class ViewPager2$DataSetChangeObserver
extends RecyclerView$AdapterDataObserver {
    private ViewPager2$DataSetChangeObserver() {
    }

    public /* synthetic */ ViewPager2$DataSetChangeObserver(ViewPager2$1 viewPager2$1) {
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

