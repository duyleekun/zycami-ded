/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;

public final class Descriptors$FieldDescriptor$JavaType
extends Enum {
    private static final /* synthetic */ Descriptors$FieldDescriptor$JavaType[] $VALUES;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType BOOLEAN;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType BYTE_STRING;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType DOUBLE;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType ENUM;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType FLOAT;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType INT;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType LONG;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType MESSAGE;
    public static final /* enum */ Descriptors$FieldDescriptor$JavaType STRING;
    private final Object defaultDefault;

    static {
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType;
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType2;
        Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType3;
        Object object = 0;
        INT = descriptors$FieldDescriptor$JavaType3 = new Descriptors$FieldDescriptor$JavaType("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new Descriptors$FieldDescriptor$JavaType("LONG", n10, object2);
        LONG = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new Descriptors$FieldDescriptor$JavaType("FLOAT", n11, object3);
        FLOAT = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new Descriptors$FieldDescriptor$JavaType("DOUBLE", n12, object4);
        DOUBLE = object3;
        Object object5 = Boolean.FALSE;
        object4 = new Descriptors$FieldDescriptor$JavaType("BOOLEAN", 4, object5);
        BOOLEAN = object4;
        object5 = new Descriptors$FieldDescriptor$JavaType("STRING", 5, (Object)"");
        STRING = object5;
        Object object6 = ByteString.EMPTY;
        BYTE_STRING = descriptors$FieldDescriptor$JavaType2 = new Descriptors$FieldDescriptor$JavaType("BYTE_STRING", 6, object6);
        object6 = new Descriptors$FieldDescriptor$JavaType("ENUM", 7, null);
        ENUM = object6;
        int n13 = 8;
        MESSAGE = descriptors$FieldDescriptor$JavaType = new Descriptors$FieldDescriptor$JavaType("MESSAGE", n13, null);
        Descriptors$FieldDescriptor$JavaType[] descriptors$FieldDescriptor$JavaTypeArray = new Descriptors$FieldDescriptor$JavaType[9];
        descriptors$FieldDescriptor$JavaTypeArray[0] = descriptors$FieldDescriptor$JavaType3;
        descriptors$FieldDescriptor$JavaTypeArray[n10] = object;
        descriptors$FieldDescriptor$JavaTypeArray[n11] = object2;
        descriptors$FieldDescriptor$JavaTypeArray[n12] = object3;
        descriptors$FieldDescriptor$JavaTypeArray[4] = object4;
        descriptors$FieldDescriptor$JavaTypeArray[5] = object5;
        descriptors$FieldDescriptor$JavaTypeArray[6] = descriptors$FieldDescriptor$JavaType2;
        descriptors$FieldDescriptor$JavaTypeArray[7] = object6;
        descriptors$FieldDescriptor$JavaTypeArray[n13] = descriptors$FieldDescriptor$JavaType;
        $VALUES = descriptors$FieldDescriptor$JavaTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Descriptors$FieldDescriptor$JavaType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.defaultDefault = var3_1;
    }

    public static /* synthetic */ Object access$2400(Descriptors$FieldDescriptor$JavaType descriptors$FieldDescriptor$JavaType) {
        return descriptors$FieldDescriptor$JavaType.defaultDefault;
    }

    public static Descriptors$FieldDescriptor$JavaType valueOf(String string2) {
        return Enum.valueOf(Descriptors$FieldDescriptor$JavaType.class, string2);
    }

    public static Descriptors$FieldDescriptor$JavaType[] values() {
        return (Descriptors$FieldDescriptor$JavaType[])$VALUES.clone();
    }
}

