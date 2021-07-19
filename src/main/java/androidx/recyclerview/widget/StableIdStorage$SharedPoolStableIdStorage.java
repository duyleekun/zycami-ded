/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$SharedPoolStableIdStorage$1;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;

public class StableIdStorage$SharedPoolStableIdStorage
implements StableIdStorage {
    private final StableIdStorage$StableIdLookup mSameIdLookup;

    public StableIdStorage$SharedPoolStableIdStorage() {
        StableIdStorage$SharedPoolStableIdStorage$1 stableIdStorage$SharedPoolStableIdStorage$1 = new StableIdStorage$SharedPoolStableIdStorage$1(this);
        this.mSameIdLookup = stableIdStorage$SharedPoolStableIdStorage$1;
    }

    public StableIdStorage$StableIdLookup createStableIdLookup() {
        return this.mSameIdLookup;
    }
}

