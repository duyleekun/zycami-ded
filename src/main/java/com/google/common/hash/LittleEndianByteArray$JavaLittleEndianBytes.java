/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.hash;

import com.google.common.hash.LittleEndianByteArray$1;
import com.google.common.hash.LittleEndianByteArray$JavaLittleEndianBytes$1;
import com.google.common.hash.LittleEndianByteArray$LittleEndianBytes;

public abstract class LittleEndianByteArray$JavaLittleEndianBytes
extends Enum
implements LittleEndianByteArray$LittleEndianBytes {
    private static final /* synthetic */ LittleEndianByteArray$JavaLittleEndianBytes[] $VALUES;
    public static final /* enum */ LittleEndianByteArray$JavaLittleEndianBytes INSTANCE;

    static {
        LittleEndianByteArray$JavaLittleEndianBytes$1 littleEndianByteArray$JavaLittleEndianBytes$1 = new LittleEndianByteArray$JavaLittleEndianBytes$1();
        INSTANCE = littleEndianByteArray$JavaLittleEndianBytes$1;
        LittleEndianByteArray$JavaLittleEndianBytes[] littleEndianByteArray$JavaLittleEndianBytesArray = new LittleEndianByteArray$JavaLittleEndianBytes[]{littleEndianByteArray$JavaLittleEndianBytes$1};
        $VALUES = littleEndianByteArray$JavaLittleEndianBytesArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private LittleEndianByteArray$JavaLittleEndianBytes() {
        void var2_-1;
        void var1_-1;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ LittleEndianByteArray$JavaLittleEndianBytes(LittleEndianByteArray$1 littleEndianByteArray$1) {
        this((String)var1_-1, (int)var2_1);
        void var2_1;
        void var1_-1;
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes valueOf(String string2) {
        return Enum.valueOf(LittleEndianByteArray$JavaLittleEndianBytes.class, string2);
    }

    public static LittleEndianByteArray$JavaLittleEndianBytes[] values() {
        return (LittleEndianByteArray$JavaLittleEndianBytes[])$VALUES.clone();
    }
}

