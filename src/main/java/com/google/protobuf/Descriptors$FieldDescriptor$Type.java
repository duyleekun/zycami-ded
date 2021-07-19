/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Type;
import com.google.protobuf.Descriptors$FieldDescriptor$JavaType;

public final class Descriptors$FieldDescriptor$Type
extends Enum {
    private static final /* synthetic */ Descriptors$FieldDescriptor$Type[] $VALUES;
    public static final /* enum */ Descriptors$FieldDescriptor$Type BOOL;
    public static final /* enum */ Descriptors$FieldDescriptor$Type BYTES;
    public static final /* enum */ Descriptors$FieldDescriptor$Type DOUBLE;
    public static final /* enum */ Descriptors$FieldDescriptor$Type ENUM;
    public static final /* enum */ Descriptors$FieldDescriptor$Type FIXED32;
    public static final /* enum */ Descriptors$FieldDescriptor$Type FIXED64;
    public static final /* enum */ Descriptors$FieldDescriptor$Type FLOAT;
    public static final /* enum */ Descriptors$FieldDescriptor$Type GROUP;
    public static final /* enum */ Descriptors$FieldDescriptor$Type INT32;
    public static final /* enum */ Descriptors$FieldDescriptor$Type INT64;
    public static final /* enum */ Descriptors$FieldDescriptor$Type MESSAGE;
    public static final /* enum */ Descriptors$FieldDescriptor$Type SFIXED32;
    public static final /* enum */ Descriptors$FieldDescriptor$Type SFIXED64;
    public static final /* enum */ Descriptors$FieldDescriptor$Type SINT32;
    public static final /* enum */ Descriptors$FieldDescriptor$Type SINT64;
    public static final /* enum */ Descriptors$FieldDescriptor$Type STRING;
    public static final /* enum */ Descriptors$FieldDescriptor$Type UINT32;
    public static final /* enum */ Descriptors$FieldDescriptor$Type UINT64;
    private Descriptors$FieldDescriptor$JavaType javaType;

    static {
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type2;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type3;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type4;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type5;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type6;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type7;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type8;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type9;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type10;
        Enum enum_ = Descriptors$FieldDescriptor$JavaType.DOUBLE;
        DOUBLE = descriptors$FieldDescriptor$Type10 = new Descriptors$FieldDescriptor$Type("DOUBLE", 0, (Descriptors$FieldDescriptor$JavaType)enum_);
        Enum enum_2 = Descriptors$FieldDescriptor$JavaType.FLOAT;
        FLOAT = enum_ = new Descriptors$FieldDescriptor$Type("FLOAT", 1, (Descriptors$FieldDescriptor$JavaType)enum_2);
        Descriptors$FieldDescriptor$Type[] descriptors$FieldDescriptor$TypeArray = Descriptors$FieldDescriptor$JavaType.LONG;
        INT64 = enum_2 = new Descriptors$FieldDescriptor$Type("INT64", 2, (Descriptors$FieldDescriptor$JavaType)descriptors$FieldDescriptor$TypeArray);
        UINT64 = descriptors$FieldDescriptor$Type9 = new Descriptors$FieldDescriptor$Type("UINT64", 3, (Descriptors$FieldDescriptor$JavaType)descriptors$FieldDescriptor$TypeArray);
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType = Descriptors$FieldDescriptor$JavaType.INT;
        INT32 = descriptors$FieldDescriptor$Type8 = new Descriptors$FieldDescriptor$Type("INT32", 4, descriptors$FieldDescriptor$JavaType);
        FIXED64 = descriptors$FieldDescriptor$Type7 = new Descriptors$FieldDescriptor$Type("FIXED64", 5, (Descriptors$FieldDescriptor$JavaType)descriptors$FieldDescriptor$TypeArray);
        FIXED32 = descriptors$FieldDescriptor$Type6 = new Descriptors$FieldDescriptor$Type("FIXED32", 6, descriptors$FieldDescriptor$JavaType);
        Enum enum_3 = Descriptors$FieldDescriptor$JavaType.BOOLEAN;
        BOOL = descriptors$FieldDescriptor$Type5 = new Descriptors$FieldDescriptor$Type("BOOL", 7, (Descriptors$FieldDescriptor$JavaType)enum_3);
        enum_3 = Descriptors$FieldDescriptor$JavaType.STRING;
        STRING = descriptors$FieldDescriptor$Type4 = new Descriptors$FieldDescriptor$Type("STRING", 8, (Descriptors$FieldDescriptor$JavaType)enum_3);
        enum_3 = Descriptors$FieldDescriptor$JavaType.MESSAGE;
        GROUP = descriptors$FieldDescriptor$Type3 = new Descriptors$FieldDescriptor$Type("GROUP", 9, (Descriptors$FieldDescriptor$JavaType)enum_3);
        Enum enum_4 = new Descriptors$FieldDescriptor$Type("MESSAGE", 10, (Descriptors$FieldDescriptor$JavaType)enum_3);
        MESSAGE = enum_4;
        enum_3 = Descriptors$FieldDescriptor$JavaType.BYTE_STRING;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type11 = enum_4;
        BYTES = descriptors$FieldDescriptor$Type2 = new Descriptors$FieldDescriptor$Type("BYTES", 11, (Descriptors$FieldDescriptor$JavaType)enum_3);
        UINT32 = descriptors$FieldDescriptor$Type = new Descriptors$FieldDescriptor$Type("UINT32", 12, descriptors$FieldDescriptor$JavaType);
        enum_4 = Descriptors$FieldDescriptor$JavaType.ENUM;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type12 = descriptors$FieldDescriptor$Type;
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type13 = descriptors$FieldDescriptor$Type2;
        ENUM = enum_3 = new Descriptors$FieldDescriptor$Type("ENUM", 13, (Descriptors$FieldDescriptor$JavaType)enum_4);
        SFIXED32 = descriptors$FieldDescriptor$Type = new Descriptors$FieldDescriptor$Type("SFIXED32", 14, descriptors$FieldDescriptor$JavaType);
        Descriptors$FieldDescriptor$Type descriptors$FieldDescriptor$Type14 = descriptors$FieldDescriptor$Type;
        SFIXED64 = enum_4 = new Descriptors$FieldDescriptor$Type("SFIXED64", 15, (Descriptors$FieldDescriptor$JavaType)descriptors$FieldDescriptor$TypeArray);
        SINT32 = descriptors$FieldDescriptor$Type2 = new Descriptors$FieldDescriptor$Type("SINT32", 16, descriptors$FieldDescriptor$JavaType);
        int n10 = 17;
        SINT64 = descriptors$FieldDescriptor$Type = new Descriptors$FieldDescriptor$Type("SINT64", n10, (Descriptors$FieldDescriptor$JavaType)descriptors$FieldDescriptor$TypeArray);
        descriptors$FieldDescriptor$TypeArray = new Descriptors$FieldDescriptor$Type[18];
        descriptors$FieldDescriptor$TypeArray[0] = descriptors$FieldDescriptor$Type10;
        descriptors$FieldDescriptor$TypeArray[1] = enum_;
        descriptors$FieldDescriptor$TypeArray[2] = enum_2;
        descriptors$FieldDescriptor$TypeArray[3] = descriptors$FieldDescriptor$Type9;
        descriptors$FieldDescriptor$TypeArray[4] = descriptors$FieldDescriptor$Type8;
        descriptors$FieldDescriptor$TypeArray[5] = descriptors$FieldDescriptor$Type7;
        descriptors$FieldDescriptor$TypeArray[6] = descriptors$FieldDescriptor$Type6;
        descriptors$FieldDescriptor$TypeArray[7] = descriptors$FieldDescriptor$Type5;
        descriptors$FieldDescriptor$TypeArray[8] = descriptors$FieldDescriptor$Type4;
        descriptors$FieldDescriptor$TypeArray[9] = descriptors$FieldDescriptor$Type3;
        descriptors$FieldDescriptor$TypeArray[10] = descriptors$FieldDescriptor$Type11;
        descriptors$FieldDescriptor$TypeArray[11] = descriptors$FieldDescriptor$Type13;
        descriptors$FieldDescriptor$TypeArray[12] = descriptors$FieldDescriptor$Type12;
        descriptors$FieldDescriptor$TypeArray[13] = enum_3;
        descriptors$FieldDescriptor$TypeArray[14] = descriptors$FieldDescriptor$Type14;
        descriptors$FieldDescriptor$TypeArray[15] = enum_4;
        descriptors$FieldDescriptor$TypeArray[16] = descriptors$FieldDescriptor$Type2;
        descriptors$FieldDescriptor$TypeArray[n10] = descriptors$FieldDescriptor$Type;
        $VALUES = descriptors$FieldDescriptor$TypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Descriptors$FieldDescriptor$Type() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.javaType = var3_1;
    }

    public static Descriptors$FieldDescriptor$Type valueOf(DescriptorProtos$FieldDescriptorProto$Type descriptorProtos$FieldDescriptorProto$Type) {
        Descriptors$FieldDescriptor$Type[] descriptors$FieldDescriptor$TypeArray = Descriptors$FieldDescriptor$Type.values();
        int n10 = descriptorProtos$FieldDescriptorProto$Type.getNumber() + -1;
        return descriptors$FieldDescriptor$TypeArray[n10];
    }

    public static Descriptors$FieldDescriptor$Type valueOf(String string2) {
        return Enum.valueOf(Descriptors$FieldDescriptor$Type.class, string2);
    }

    public static Descriptors$FieldDescriptor$Type[] values() {
        return (Descriptors$FieldDescriptor$Type[])$VALUES.clone();
    }

    public Descriptors$FieldDescriptor$JavaType getJavaType() {
        return this.javaType;
    }

    public DescriptorProtos$FieldDescriptorProto$Type toProto() {
        return DescriptorProtos$FieldDescriptorProto$Type.forNumber(this.ordinal() + 1);
    }
}

