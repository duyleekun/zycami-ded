/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.StableIdStorage;
import androidx.recyclerview.widget.StableIdStorage$NoStableIdStorage$1;
import androidx.recyclerview.widget.StableIdStorage$StableIdLookup;

public class StableIdStorage$NoStableIdStorage
implements StableIdStorage {
    private final StableIdStorage$StableIdLookup mNoIdLookup;

    public StableIdStorage$NoStableIdStorage() {
        StableIdStorage$NoStableIdStorage$1 stableIdStorage$NoStableIdStorage$1 = new StableIdStorage$NoStableIdStorage$1(this);
        this.mNoIdLookup = stableIdStorage$NoStableIdStorage$1;
    }

    public StableIdStorage$StableIdLookup createStableIdLookup() {
        return this.mNoIdLookup;
    }
}

