/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import com.google.android.gms.common.data.DataBufferObserver$Observable;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet
implements DataBufferObserver,
DataBufferObserver$Observable {
    private HashSet zalm;

    public DataBufferObserverSet() {
        HashSet hashSet;
        this.zalm = hashSet = new HashSet();
    }

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        this.zalm.add(dataBufferObserver);
    }

    public final void clear() {
        this.zalm.clear();
    }

    public final boolean hasObservers() {
        HashSet hashSet = this.zalm;
        boolean bl2 = hashSet.isEmpty();
        return !bl2;
    }

    public final void onDataChanged() {
        boolean bl2;
        Iterator iterator2 = this.zalm.iterator();
        while (bl2 = iterator2.hasNext()) {
            DataBufferObserver dataBufferObserver = (DataBufferObserver)iterator2.next();
            dataBufferObserver.onDataChanged();
        }
    }

    public final void onDataRangeChanged(int n10, int n11) {
        boolean bl2;
        Iterator iterator2 = this.zalm.iterator();
        while (bl2 = iterator2.hasNext()) {
            DataBufferObserver dataBufferObserver = (DataBufferObserver)iterator2.next();
            dataBufferObserver.onDataRangeChanged(n10, n11);
        }
    }

    public final void onDataRangeInserted(int n10, int n11) {
        boolean bl2;
        Iterator iterator2 = this.zalm.iterator();
        while (bl2 = iterator2.hasNext()) {
            DataBufferObserver dataBufferObserver = (DataBufferObserver)iterator2.next();
            dataBufferObserver.onDataRangeInserted(n10, n11);
        }
    }

    public final void onDataRangeMoved(int n10, int n11, int n12) {
        boolean bl2;
        Iterator iterator2 = this.zalm.iterator();
        while (bl2 = iterator2.hasNext()) {
            DataBufferObserver dataBufferObserver = (DataBufferObserver)iterator2.next();
            dataBufferObserver.onDataRangeMoved(n10, n11, n12);
        }
    }

    public final void onDataRangeRemoved(int n10, int n11) {
        boolean bl2;
        Iterator iterator2 = this.zalm.iterator();
        while (bl2 = iterator2.hasNext()) {
            DataBufferObserver dataBufferObserver = (DataBufferObserver)iterator2.next();
            dataBufferObserver.onDataRangeRemoved(n10, n11);
        }
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zalm.remove(dataBufferObserver);
    }
}

