/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$JavaType;

public class GeneratedMessageLite$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        WireFormat$JavaType wireFormat$JavaType;
        int n12 = WireFormat$JavaType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$WireFormat$JavaType = nArray;
        try {
            wireFormat$JavaType = WireFormat$JavaType.MESSAGE;
            n11 = wireFormat$JavaType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            wireFormat$JavaType = WireFormat$JavaType.ENUM;
            n11 = wireFormat$JavaType.ordinal();
            nArray[n11] = n10 = 2;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

