/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

import androidx.recyclerview.widget.ConcatAdapter$Config$StableIdMode;

public final class ConcatAdapter$Config {
    public static final ConcatAdapter$Config DEFAULT;
    public final boolean isolateViewTypes;
    public final ConcatAdapter$Config$StableIdMode stableIdMode;

    static {
        ConcatAdapter$Config concatAdapter$Config;
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode = ConcatAdapter$Config$StableIdMode.NO_STABLE_IDS;
        DEFAULT = concatAdapter$Config = new ConcatAdapter$Config(true, concatAdapter$Config$StableIdMode);
    }

    public ConcatAdapter$Config(boolean bl2, ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode) {
        this.isolateViewTypes = bl2;
        this.stableIdMode = concatAdapter$Config$StableIdMode;
    }
}

