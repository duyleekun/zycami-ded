/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ConcatAdapter$Config;
import androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode;

public final class ConcatAdapter$Config$Builder {
    private boolean mIsolateViewTypes;
    private ConcatAdapter$Config$StableIdMode mStableIdMode;

    public ConcatAdapter$Config$Builder() {
        boolean bl2;
        Object object = ConcatAdapter$Config.DEFAULT;
        this.mIsolateViewTypes = bl2 = object.isolateViewTypes;
        object = object.stableIdMode;
        this.mStableIdMode = object;
    }

    public ConcatAdapter$Config build() {
        boolean bl2 = this.mIsolateViewTypes;
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode = this.mStableIdMode;
        ConcatAdapter$Config concatAdapter$Config = new ConcatAdapter$Config(bl2, concatAdapter$Config$StableIdMode);
        return concatAdapter$Config;
    }

    public ConcatAdapter$Config$Builder setIsolateViewTypes(boolean bl2) {
        this.mIsolateViewTypes = bl2;
        return this;
    }

    public ConcatAdapter$Config$Builder setStableIdMode(ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode) {
        this.mStableIdMode = concatAdapter$Config$StableIdMode;
        return this;
    }
}

