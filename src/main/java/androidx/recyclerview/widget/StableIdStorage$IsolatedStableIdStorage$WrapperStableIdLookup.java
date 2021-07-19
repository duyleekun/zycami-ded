/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.collection.LongSparseArray;
import androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;

public class StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup
implements StableIdStorage$StableIdLookup {
    private final LongSparseArray mLocalToGlobalLookup;
    public final /* synthetic */ StableIdStorage$IsolatedStableIdStorage this$0;

    public StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup(StableIdStorage$IsolatedStableIdStorage object) {
        this.this$0 = object;
        this.mLocalToGlobalLookup = object = new LongSparseArray();
    }

    public long localToGlobal(long l10) {
        Long l11 = (Long)this.mLocalToGlobalLookup.get(l10);
        if (l11 == null) {
            long l12 = this.this$0.obtainId();
            l11 = l12;
            LongSparseArray longSparseArray = this.mLocalToGlobalLookup;
            longSparseArray.put(l10, l11);
        }
        return l11;
    }
}

