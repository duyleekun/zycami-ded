/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$FieldType;

public class CodedOutputStreamWriter$1 {
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
            wireFormat$FieldType = WireFormat$FieldType.BOOL;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 1;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.FIXED32;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 2;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.INT32;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 3;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.SFIXED32;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 4;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.SINT32;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 5;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.UINT32;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 6;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.FIXED64;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 7;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.INT64;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 8;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.SFIXED64;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 9;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.SINT64;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.UINT64;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 11;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            wireFormat$FieldType = WireFormat$FieldType.STRING;
            n11 = wireFormat$FieldType.ordinal();
            nArray[n11] = n10 = 12;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

