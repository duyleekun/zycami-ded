/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;

public class StableIdStorage$IsolatedStableIdStorage
implements StableIdStorage {
    public long mNextStableId = 0L;

    public StableIdStorage$StableIdLookup createStableIdLookup() {
        StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup stableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup = new StableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup(this);
        return stableIdStorage$IsolatedStableIdStorage$WrapperStableIdLookup;
    }

    public long obtainId() {
        long l10;
        long l11 = this.mNextStableId;
        this.mNextStableId = l10 = 1L + l11;
        return l11;
    }
}

