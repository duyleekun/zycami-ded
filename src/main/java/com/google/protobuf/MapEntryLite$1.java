/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$FieldType;

public class MapEntryLite$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        int n10;
        int n11;
        WireFormat$FieldType wireFormat$FieldType;
        int n12 = WireFormat$FieldType.values().length;
        int[] nArray = new int[n12];
        $SwitchMap$com$google$protobuf$WireFormat$FieldType = nArray;
        try {
            wireFormat$FieldType = WireFormat$FieldType.MESSAGE;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.ENUM;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.GROUP;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 3;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

