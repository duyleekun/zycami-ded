/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.ByteString;

public final class WireFormat$JavaType
extends Enum {
    private static final /* synthetic */ WireFormat$JavaType[] $VALUES;
    public static final /* enum */ WireFormat$JavaType BOOLEAN;
    public static final /* enum */ WireFormat$JavaType BYTE_STRING;
    public static final /* enum */ WireFormat$JavaType DOUBLE;
    public static final /* enum */ WireFormat$JavaType ENUM;
    public static final /* enum */ WireFormat$JavaType FLOAT;
    public static final /* enum */ WireFormat$JavaType INT;
    public static final /* enum */ WireFormat$JavaType LONG;
    public static final /* enum */ WireFormat$JavaType MESSAGE;
    public static final /* enum */ WireFormat$JavaType STRING;
    private final Object defaultDefault;

    static {
        WireFormat$JavaType wireFormat$JavaType;
        WireFormat$JavaType wireFormat$JavaType2;
        WireFormat$JavaType wireFormat$JavaType3;
        Object object = 0;
        INT = wireFormat$JavaType3 = new WireFormat$JavaType("INT", 0, object);
        Object object2 = 0L;
        int n10 = 1;
        object = new WireFormat$JavaType("LONG", n10, object2);
        LONG = object;
        Object object3 = Float.valueOf(0.0f);
        int n11 = 2;
        object2 = new WireFormat$JavaType("FLOAT", n11, object3);
        FLOAT = object2;
        Object object4 = 0.0;
        int n12 = 3;
        object3 = new WireFormat$JavaType("DOUBLE", n12, object4);
        DOUBLE = object3;
        Object object5 = Boolean.FALSE;
        object4 = new WireFormat$JavaType("BOOLEAN", 4, object5);
        BOOLEAN = object4;
        object5 = new WireFormat$JavaType("STRING", 5, (Object)"");
        STRING = object5;
        Object object6 = ByteString.EMPTY;
        BYTE_STRING = wireFormat$JavaType2 = new WireFormat$JavaType("BYTE_STRING", 6, object6);
        object6 = new WireFormat$JavaType("ENUM", 7, null);
        ENUM = object6;
        int n13 = 8;
        MESSAGE = wireFormat$JavaType = new WireFormat$JavaType("MESSAGE", n13, null);
        WireFormat$JavaType[] wireFormat$JavaTypeArray = new WireFormat$JavaType[9];
        wireFormat$JavaTypeArray[0] = wireFormat$JavaType3;
        wireFormat$JavaTypeArray[n10] = object;
        wireFormat$JavaTypeArray[n11] = object2;
        wireFormat$JavaTypeArray[n12] = object3;
        wireFormat$JavaTypeArray[4] = object4;
        wireFormat$JavaTypeArray[5] = object5;
        wireFormat$JavaTypeArray[6] = wireFormat$JavaType2;
        wireFormat$JavaTypeArray[7] = object6;
        wireFormat$JavaTypeArray[n13] = wireFormat$JavaType;
        $VALUES = wireFormat$JavaTypeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private WireFormat$JavaType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.defaultDefault = var3_1;
    }

    public static WireFormat$JavaType valueOf(String string2) {
        return Enum.valueOf(WireFormat$JavaType.class, string2);
    }

    public static WireFormat$JavaType[] values() {
        return (WireFormat$JavaType[])$VALUES.clone();
    }

    public Object getDefaultDefault() {
        return this.defaultDefault;
    }
}

