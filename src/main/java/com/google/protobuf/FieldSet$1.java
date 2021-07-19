/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$FieldType;
import com.google.protobuf.WireFormat$JavaType;

public class FieldSet$1 {
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$FieldType;
    public static final /* synthetic */ int[] $SwitchMap$com$google$protobuf$WireFormat$JavaType;

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    static {
        Object object;
        int n10;
        int n11;
        Enum enum_;
        int n12;
        Object object2;
        int n13;
        Object object3;
        int n14;
        Object object4;
        int n15;
        Object object5;
        int n16;
        Object object6;
        int n17;
        Object object7;
        int n18;
        Object object8;
        int n19;
        Object object9;
        int n20 = WireFormat$FieldType.values().length;
        int[] nArray = new int[n20];
        $SwitchMap$com$google$protobuf$WireFormat$FieldType = nArray;
        int n21 = 1;
        try {
            object9 = WireFormat$FieldType.DOUBLE;
            n19 = object9.ordinal();
            nArray[n19] = n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n20 = 2;
        try {
            object9 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object8 = WireFormat$FieldType.FLOAT;
            n18 = object8.ordinal();
            object9[n18] = (WireFormat$FieldType)n20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n19 = 3;
        try {
            object8 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object7 = WireFormat$FieldType.INT64;
            n17 = object7.ordinal();
            object8[n17] = (WireFormat$FieldType)n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n18 = 4;
        try {
            object7 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object6 = WireFormat$FieldType.UINT64;
            n16 = object6.ordinal();
            object7[n16] = (WireFormat$FieldType)n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n17 = 5;
        try {
            object6 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object5 = WireFormat$FieldType.INT32;
            n15 = object5.ordinal();
            object6[n15] = (WireFormat$FieldType)n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n16 = 6;
        try {
            object5 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object4 = WireFormat$FieldType.FIXED64;
            n14 = object4.ordinal();
            object5[n14] = (WireFormat$FieldType)n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n15 = 7;
        try {
            object4 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object3 = WireFormat$FieldType.FIXED32;
            n13 = object3.ordinal();
            object4[n13] = (WireFormat$FieldType)n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n14 = 8;
        try {
            object3 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            object2 = WireFormat$FieldType.BOOL;
            n12 = ((Enum)object2).ordinal();
            object3[n12] = (WireFormat$FieldType)n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n13 = 9;
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.GROUP;
            n11 = enum_.ordinal();
            object2[n11] = (WireFormat$FieldType)n13;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.MESSAGE;
            n11 = enum_.ordinal();
            n10 = 10;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.STRING;
            n11 = enum_.ordinal();
            n10 = 11;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.BYTES;
            n11 = enum_.ordinal();
            n10 = 12;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.UINT32;
            n11 = enum_.ordinal();
            n10 = 13;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.SFIXED32;
            n11 = enum_.ordinal();
            n10 = 14;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.SFIXED64;
            n11 = enum_.ordinal();
            n10 = 15;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.SINT32;
            n11 = enum_.ordinal();
            n10 = 16;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.SINT64;
            n11 = enum_.ordinal();
            n10 = 17;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object2 = $SwitchMap$com$google$protobuf$WireFormat$FieldType;
            enum_ = WireFormat$FieldType.ENUM;
            n11 = enum_.ordinal();
            n10 = 18;
            object2[n11] = (WireFormat$FieldType)n10;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        n12 = WireFormat$JavaType.values().length;
        object2 = new int[n12];
        $SwitchMap$com$google$protobuf$WireFormat$JavaType = (int[])object2;
        try {
            enum_ = WireFormat$JavaType.INT;
            n11 = enum_.ordinal();
            object2[n11] = (WireFormat$FieldType)n21;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            object = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object2 = WireFormat$JavaType.LONG;
            n12 = ((Enum)object2).ordinal();
            object[n12] = n20;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = (Object)WireFormat$JavaType.FLOAT;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n19;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = WireFormat$JavaType.DOUBLE;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n18;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = WireFormat$JavaType.BOOLEAN;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n17;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = WireFormat$JavaType.STRING;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n16;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = WireFormat$JavaType.BYTE_STRING;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n15;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = WireFormat$JavaType.ENUM;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n14;
        }
        catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray = $SwitchMap$com$google$protobuf$WireFormat$JavaType;
            object = WireFormat$JavaType.MESSAGE;
            n21 = ((Enum)object).ordinal();
            nArray[n21] = n13;
            return;
        }
        catch (NoSuchFieldError noSuchFieldError) {
            return;
        }
    }
}

