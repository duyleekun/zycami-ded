/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.database.Observable
 */
package androidx.recyclerview.widget;

import android.database.Observable;
import androidx.recyclerview.widget.RecyclerView$AdapterDataObserver;
import java.util.ArrayList;

public class RecyclerView$AdapterDataObservable
extends Observable {
    public boolean hasObservers() {
        return this.mObservers.isEmpty() ^ true;
    }

    public void notifyChanged() {
        ArrayList arrayList = this.mObservers;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = (RecyclerView$AdapterDataObserver)this.mObservers.get(i10);
            recyclerView$AdapterDataObserver.onChanged();
        }
    }

    public void notifyItemMoved(int n10, int n11) {
        ArrayList arrayList = this.mObservers;
        int n12 = arrayList.size();
        int n13 = 1;
        n12 -= n13;
        while (n12 >= 0) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = (RecyclerView$AdapterDataObserver)this.mObservers.get(n12);
            recyclerView$AdapterDataObserver.onItemRangeMoved(n10, n11, n13);
            n12 += -1;
        }
    }

    public void notifyItemRangeChanged(int n10, int n11) {
        this.notifyItemRangeChanged(n10, n11, null);
    }

    public void notifyItemRangeChanged(int n10, int n11, Object object) {
        ArrayList arrayList = this.mObservers;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = (RecyclerView$AdapterDataObserver)this.mObservers.get(i10);
            recyclerView$AdapterDataObserver.onItemRangeChanged(n10, n11, object);
        }
    }

    public void notifyItemRangeInserted(int n10, int n11) {
        ArrayList arrayList = this.mObservers;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = (RecyclerView$AdapterDataObserver)this.mObservers.get(i10);
            recyclerView$AdapterDataObserver.onItemRangeInserted(n10, n11);
        }
    }

    public void notifyItemRangeRemoved(int n10, int n11) {
        ArrayList arrayList = this.mObservers;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = (RecyclerView$AdapterDataObserver)this.mObservers.get(i10);
            recyclerView$AdapterDataObserver.onItemRangeRemoved(n10, n11);
        }
    }

    public void notifyStateRestorationPolicyChanged() {
        ArrayList arrayList = this.mObservers;
        for (int i10 = arrayList.size() + -1; i10 >= 0; i10 += -1) {
            RecyclerView$AdapterDataObserver recyclerView$AdapterDataObserver = (RecyclerView$AdapterDataObserver)this.mObservers.get(i10);
            recyclerView$AdapterDataObserver.onStateRestorationPolicyChanged();
        }
    }
}

