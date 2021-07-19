/*
 * Decompiled with CFR 0.151.
 */
package androidx.recyclerview.widget;

public final class ConcatAdapter$Config$StableIdMode
extends Enum {
    private static final /* synthetic */ ConcatAdapter$Config$StableIdMode[] $VALUES;
    public static final /* enum */ ConcatAdapter$Config$StableIdMode ISOLATED_STABLE_IDS;
    public static final /* enum */ ConcatAdapter$Config$StableIdMode NO_STABLE_IDS;
    public static final /* enum */ ConcatAdapter$Config$StableIdMode SHARED_STABLE_IDS;

    static {
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode;
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode2;
        ConcatAdapter$Config$StableIdMode concatAdapter$Config$StableIdMode3;
        NO_STABLE_IDS = concatAdapter$Config$StableIdMode3 = new ConcatAdapter$Config$StableIdMode("NO_STABLE_IDS", 0);
        int n10 = 1;
        ISOLATED_STABLE_IDS = concatAdapter$Config$StableIdMode2 = new ConcatAdapter$Config$StableIdMode("ISOLATED_STABLE_IDS", n10);
        int n11 = 2;
        SHARED_STABLE_IDS = concatAdapter$Config$StableIdMode = new ConcatAdapter$Config$StableIdMode("SHARED_STABLE_IDS", n11);
        ConcatAdapter$Config$StableIdMode[] concatAdapter$Config$StableIdModeArray = new ConcatAdapter$Config$StableIdMode[3];
        concatAdapter$Config$StableIdModeArray[0] = concatAdapter$Config$StableIdMode3;
        concatAdapter$Config$StableIdModeArray[n10] = concatAdapter$Config$StableIdMode2;
        concatAdapter$Config$StableIdModeArray[n11] = concatAdapter$Config$StableIdMode;
        $VALUES = concatAdapter$Config$StableIdModeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ConcatAdapter$Config$StableIdMode() {
        void var2_-1;
        void var1_-1;
    }

    public static ConcatAdapter$Config$StableIdMode valueOf(String string2) {
        return Enum.valueOf(ConcatAdapter$Config$StableIdMode.class, string2);
    }

    public static ConcatAdapter$Config$StableIdMode[] values() {
        return (ConcatAdapter$Config$StableIdMode[])$VALUES.clone();
    }
}

