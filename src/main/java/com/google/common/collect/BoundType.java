/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

public final class BoundType
extends Enum {
    private static final /* synthetic */ BoundType[] $VALUES;
    public static final /* enum */ BoundType CLOSED;
    public static final /* enum */ BoundType OPEN;
    public final boolean inclusive;

    static {
        BoundType boundType;
        BoundType boundType2;
        OPEN = boundType2 = new BoundType("OPEN", 0, false);
        int n10 = 1;
        CLOSED = boundType = new BoundType("CLOSED", n10, n10 != 0);
        BoundType[] boundTypeArray = new BoundType[2];
        boundTypeArray[0] = boundType2;
        boundTypeArray[n10] = boundType;
        $VALUES = boundTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private BoundType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.inclusive = var3_1;
    }

    public static BoundType forBoolean(boolean bl2) {
        BoundType boundType = bl2 ? CLOSED : OPEN;
        return boundType;
    }

    public static BoundType valueOf(String string2) {
        return Enum.valueOf(BoundType.class, string2);
    }

    public static BoundType[] values() {
        return (BoundType[])$VALUES.clone();
    }

    public BoundType flip() {
        return BoundType.forBoolean(this.inclusive ^ true);
    }
}

