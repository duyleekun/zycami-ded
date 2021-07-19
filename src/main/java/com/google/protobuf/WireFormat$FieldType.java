/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.WireFormat$1;
import com.google.protobuf.WireFormat$FieldType$1;
import com.google.protobuf.WireFormat$FieldType$2;
import com.google.protobuf.WireFormat$FieldType$3;
import com.google.protobuf.WireFormat$FieldType$4;
import com.google.protobuf.WireFormat$JavaType;

public class WireFormat$FieldType
extends Enum {
    private static final /* synthetic */ WireFormat$FieldType[] $VALUES;
    public static final /* enum */ WireFormat$FieldType BOOL;
    public static final /* enum */ WireFormat$FieldType BYTES;
    public static final /* enum */ WireFormat$FieldType DOUBLE;
    public static final /* enum */ WireFormat$FieldType ENUM;
    public static final /* enum */ WireFormat$FieldType FIXED32;
    public static final /* enum */ WireFormat$FieldType FIXED64;
    public static final /* enum */ WireFormat$FieldType FLOAT;
    public static final /* enum */ WireFormat$FieldType GROUP;
    public static final /* enum */ WireFormat$FieldType INT32;
    public static final /* enum */ WireFormat$FieldType INT64;
    public static final /* enum */ WireFormat$FieldType MESSAGE;
    public static final /* enum */ WireFormat$FieldType SFIXED32;
    public static final /* enum */ WireFormat$FieldType SFIXED64;
    public static final /* enum */ WireFormat$FieldType SINT32;
    public static final /* enum */ WireFormat$FieldType SINT64;
    public static final /* enum */ WireFormat$FieldType STRING;
    public static final /* enum */ WireFormat$FieldType UINT32;
    public static final /* enum */ WireFormat$FieldType UINT64;
    private final WireFormat$JavaType javaType;
    private final int wireType;

    static {
        WireFormat$FieldType wireFormat$FieldType;
        WireFormat$FieldType wireFormat$FieldType2;
        WireFormat$FieldType wireFormat$FieldType3;
        WireFormat$FieldType wireFormat$FieldType4;
        WireFormat$FieldType wireFormat$FieldType5;
        WireFormat$FieldType wireFormat$FieldType6;
        WireFormat$FieldType wireFormat$FieldType7;
        Enum enum_ = WireFormat$JavaType.DOUBLE;
        int n10 = 1;
        DOUBLE = wireFormat$FieldType7 = new WireFormat$FieldType("DOUBLE", 0, (WireFormat$JavaType)enum_, n10);
        Enum enum_2 = WireFormat$JavaType.FLOAT;
        int n11 = 5;
        FLOAT = enum_ = new WireFormat$FieldType("FLOAT", n10, (WireFormat$JavaType)enum_2, n11);
        WireFormat$FieldType[] wireFormat$FieldTypeArray = WireFormat$JavaType.LONG;
        int n12 = 2;
        INT64 = enum_2 = new WireFormat$FieldType("INT64", n12, (WireFormat$JavaType)wireFormat$FieldTypeArray, 0);
        int n13 = 3;
        UINT64 = wireFormat$FieldType6 = new WireFormat$FieldType("UINT64", n13, (WireFormat$JavaType)wireFormat$FieldTypeArray, 0);
        WireFormat$JavaType wireFormat$JavaType = WireFormat$JavaType.INT;
        INT32 = wireFormat$FieldType5 = new WireFormat$FieldType("INT32", 4, wireFormat$JavaType, 0);
        FIXED64 = wireFormat$FieldType4 = new WireFormat$FieldType("FIXED64", n11, (WireFormat$JavaType)wireFormat$FieldTypeArray, n10);
        FIXED32 = wireFormat$FieldType3 = new WireFormat$FieldType("FIXED32", 6, wireFormat$JavaType, n11);
        WireFormat$JavaType wireFormat$JavaType2 = WireFormat$JavaType.BOOLEAN;
        BOOL = wireFormat$FieldType2 = new WireFormat$FieldType("BOOL", 7, wireFormat$JavaType2, 0);
        wireFormat$JavaType2 = WireFormat$JavaType.STRING;
        WireFormat$FieldType$1 wireFormat$FieldType$1 = new WireFormat$FieldType$1(wireFormat$JavaType2, n12);
        STRING = wireFormat$FieldType$1;
        wireFormat$JavaType2 = WireFormat$JavaType.MESSAGE;
        WireFormat$FieldType wireFormat$FieldType8 = new WireFormat$FieldType$2(wireFormat$JavaType2, n13);
        GROUP = wireFormat$FieldType8;
        WireFormat$FieldType$2 wireFormat$FieldType$2 = wireFormat$FieldType8;
        n11 = 2;
        WireFormat$FieldType wireFormat$FieldType9 = new WireFormat$FieldType$3(wireFormat$JavaType2, n11);
        MESSAGE = wireFormat$FieldType9;
        wireFormat$JavaType2 = WireFormat$JavaType.BYTE_STRING;
        WireFormat$FieldType$3 wireFormat$FieldType$3 = wireFormat$FieldType9;
        WireFormat$FieldType wireFormat$FieldType10 = new WireFormat$FieldType$4(wireFormat$JavaType2, n11);
        BYTES = wireFormat$FieldType10;
        wireFormat$FieldType8 = new WireFormat$FieldType("UINT32", 12, wireFormat$JavaType, 0);
        UINT32 = wireFormat$FieldType8;
        wireFormat$JavaType2 = WireFormat$JavaType.ENUM;
        WireFormat$FieldType wireFormat$FieldType11 = wireFormat$FieldType8;
        WireFormat$FieldType$4 wireFormat$FieldType$4 = wireFormat$FieldType10;
        ENUM = wireFormat$FieldType = new WireFormat$FieldType("ENUM", 13, wireFormat$JavaType2, 0);
        wireFormat$FieldType9 = new WireFormat$FieldType("SFIXED32", 14, wireFormat$JavaType, 5);
        SFIXED32 = wireFormat$FieldType9;
        WireFormat$FieldType wireFormat$FieldType12 = wireFormat$FieldType9;
        wireFormat$FieldType8 = new WireFormat$FieldType("SFIXED64", 15, (WireFormat$JavaType)wireFormat$FieldTypeArray, 1);
        SFIXED64 = wireFormat$FieldType8;
        wireFormat$FieldType9 = new WireFormat$FieldType("SINT32", 16, wireFormat$JavaType, 0);
        SINT32 = wireFormat$FieldType9;
        int n14 = 17;
        wireFormat$FieldType10 = new WireFormat$FieldType("SINT64", n14, (WireFormat$JavaType)wireFormat$FieldTypeArray, 0);
        SINT64 = wireFormat$FieldType10;
        wireFormat$FieldTypeArray = new WireFormat$FieldType[18];
        wireFormat$FieldTypeArray[0] = wireFormat$FieldType7;
        wireFormat$FieldTypeArray[1] = enum_;
        wireFormat$FieldTypeArray[2] = enum_2;
        wireFormat$FieldTypeArray[3] = wireFormat$FieldType6;
        wireFormat$FieldTypeArray[4] = wireFormat$FieldType5;
        wireFormat$FieldTypeArray[5] = wireFormat$FieldType4;
        wireFormat$FieldTypeArray[6] = wireFormat$FieldType3;
        wireFormat$FieldTypeArray[7] = wireFormat$FieldType2;
        wireFormat$FieldTypeArray[8] = wireFormat$FieldType$1;
        wireFormat$FieldTypeArray[9] = wireFormat$FieldType$2;
        wireFormat$FieldTypeArray[10] = wireFormat$FieldType$3;
        wireFormat$FieldTypeArray[11] = wireFormat$FieldType$4;
        wireFormat$FieldTypeArray[12] = wireFormat$FieldType11;
        wireFormat$FieldTypeArray[13] = wireFormat$FieldType;
        wireFormat$FieldTypeArray[14] = wireFormat$FieldType12;
        wireFormat$FieldTypeArray[15] = wireFormat$FieldType8;
        wireFormat$FieldTypeArray[16] = wireFormat$FieldType9;
        wireFormat$FieldTypeArray[n14] = wireFormat$FieldType10;
        $VALUES = wireFormat$FieldTypeArray;
    }

    /*
     * WARNING - void declaration
     */
    private WireFormat$FieldType() {
        void var4_2;
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.javaType = var3_1;
        this.wireType = var4_2;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    public /* synthetic */ WireFormat$FieldType(WireFormat$JavaType wireFormat$JavaType, int n10, WireFormat$1 wireFormat$1) {
        this((String)var1_-1, n10, (WireFormat$JavaType)((Object)wireFormat$1), (int)var4_3);
        void var4_3;
        void var1_-1;
    }

    public static WireFormat$FieldType valueOf(String string2) {
        return Enum.valueOf(WireFormat$FieldType.class, string2);
    }

    public static WireFormat$FieldType[] values() {
        return (WireFormat$FieldType[])$VALUES.clone();
    }

    public WireFormat$JavaType getJavaType() {
        return this.javaType;
    }

    public int getWireType() {
        return this.wireType;
    }

    public boolean isPackable() {
        return true;
    }
}

