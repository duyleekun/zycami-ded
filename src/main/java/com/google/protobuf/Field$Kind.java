/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Kind$1;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Field$Kind
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Field$Kind[] $VALUES;
    public static final /* enum */ Field$Kind TYPE_BOOL;
    public static final int TYPE_BOOL_VALUE = 8;
    public static final /* enum */ Field$Kind TYPE_BYTES;
    public static final int TYPE_BYTES_VALUE = 12;
    public static final /* enum */ Field$Kind TYPE_DOUBLE;
    public static final int TYPE_DOUBLE_VALUE = 1;
    public static final /* enum */ Field$Kind TYPE_ENUM;
    public static final int TYPE_ENUM_VALUE = 14;
    public static final /* enum */ Field$Kind TYPE_FIXED32;
    public static final int TYPE_FIXED32_VALUE = 7;
    public static final /* enum */ Field$Kind TYPE_FIXED64;
    public static final int TYPE_FIXED64_VALUE = 6;
    public static final /* enum */ Field$Kind TYPE_FLOAT;
    public static final int TYPE_FLOAT_VALUE = 2;
    public static final /* enum */ Field$Kind TYPE_GROUP;
    public static final int TYPE_GROUP_VALUE = 10;
    public static final /* enum */ Field$Kind TYPE_INT32;
    public static final int TYPE_INT32_VALUE = 5;
    public static final /* enum */ Field$Kind TYPE_INT64;
    public static final int TYPE_INT64_VALUE = 3;
    public static final /* enum */ Field$Kind TYPE_MESSAGE;
    public static final int TYPE_MESSAGE_VALUE = 11;
    public static final /* enum */ Field$Kind TYPE_SFIXED32;
    public static final int TYPE_SFIXED32_VALUE = 15;
    public static final /* enum */ Field$Kind TYPE_SFIXED64;
    public static final int TYPE_SFIXED64_VALUE = 16;
    public static final /* enum */ Field$Kind TYPE_SINT32;
    public static final int TYPE_SINT32_VALUE = 17;
    public static final /* enum */ Field$Kind TYPE_SINT64;
    public static final int TYPE_SINT64_VALUE = 18;
    public static final /* enum */ Field$Kind TYPE_STRING;
    public static final int TYPE_STRING_VALUE = 9;
    public static final /* enum */ Field$Kind TYPE_UINT32;
    public static final int TYPE_UINT32_VALUE = 13;
    public static final /* enum */ Field$Kind TYPE_UINT64;
    public static final int TYPE_UINT64_VALUE = 4;
    public static final /* enum */ Field$Kind TYPE_UNKNOWN;
    public static final int TYPE_UNKNOWN_VALUE;
    public static final /* enum */ Field$Kind UNRECOGNIZED;
    private static final Field$Kind[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        Field$Kind field$Kind;
        Field$Kind field$Kind2;
        Field$Kind field$Kind3;
        Field$Kind field$Kind4;
        Field$Kind field$Kind5;
        Field$Kind field$Kind6;
        Field$Kind field$Kind7;
        Field$Kind field$Kind8;
        Field$Kind field$Kind9;
        Field$Kind field$Kind10;
        Field$Kind field$Kind11;
        Field$Kind field$Kind12;
        Field$Kind field$Kind13;
        Field$Kind field$Kind14;
        Object object = new Field$Kind("TYPE_UNKNOWN", 0, 0);
        TYPE_UNKNOWN = object;
        int n10 = 1;
        TYPE_DOUBLE = field$Kind14 = new Field$Kind("TYPE_DOUBLE", n10, n10);
        int n11 = 2;
        TYPE_FLOAT = field$Kind13 = new Field$Kind("TYPE_FLOAT", n11, n11);
        int n12 = 3;
        TYPE_INT64 = field$Kind12 = new Field$Kind("TYPE_INT64", n12, n12);
        int n13 = 4;
        TYPE_UINT64 = field$Kind11 = new Field$Kind("TYPE_UINT64", n13, n13);
        int n14 = 5;
        TYPE_INT32 = field$Kind10 = new Field$Kind("TYPE_INT32", n14, n14);
        int n15 = 6;
        TYPE_FIXED64 = field$Kind9 = new Field$Kind("TYPE_FIXED64", n15, n15);
        n15 = 7;
        TYPE_FIXED32 = field$Kind8 = new Field$Kind("TYPE_FIXED32", n15, n15);
        n14 = 8;
        TYPE_BOOL = field$Kind7 = new Field$Kind("TYPE_BOOL", n14, n14);
        n13 = 9;
        TYPE_STRING = field$Kind6 = new Field$Kind("TYPE_STRING", n13, n13);
        n12 = 10;
        TYPE_GROUP = field$Kind5 = new Field$Kind("TYPE_GROUP", n12, n12);
        n11 = 11;
        TYPE_MESSAGE = field$Kind4 = new Field$Kind("TYPE_MESSAGE", n11, n11);
        n10 = 12;
        TYPE_BYTES = field$Kind3 = new Field$Kind("TYPE_BYTES", n10, n10);
        int n16 = 13;
        TYPE_UINT32 = field$Kind2 = new Field$Kind("TYPE_UINT32", n16, n16);
        Field$Kind field$Kind15 = field$Kind2;
        n11 = 14;
        Field$Kind[] field$KindArray = new Field$Kind("TYPE_ENUM", n11, n11);
        TYPE_ENUM = field$KindArray;
        Field$Kind[] field$KindArray2 = field$KindArray;
        n10 = 15;
        TYPE_SFIXED32 = field$Kind = new Field$Kind("TYPE_SFIXED32", n10, n10);
        Field$Kind field$Kind16 = field$Kind;
        n16 = 16;
        TYPE_SFIXED64 = field$Kind2 = new Field$Kind("TYPE_SFIXED64", n16, n16);
        Field$Kind field$Kind17 = field$Kind2;
        n11 = 17;
        field$KindArray = new Field$Kind("TYPE_SINT32", n11, n11);
        TYPE_SINT32 = field$KindArray;
        Field$Kind[] field$KindArray3 = field$KindArray;
        n10 = 18;
        TYPE_SINT64 = field$Kind = new Field$Kind("TYPE_SINT64", n10, n10);
        n16 = 19;
        UNRECOGNIZED = field$Kind2 = new Field$Kind("UNRECOGNIZED", n16, -1);
        field$KindArray = new Field$Kind[20];
        field$KindArray[0] = object;
        field$KindArray[1] = field$Kind14;
        field$KindArray[2] = field$Kind13;
        field$KindArray[3] = field$Kind12;
        field$KindArray[4] = field$Kind11;
        field$KindArray[5] = field$Kind10;
        field$KindArray[6] = field$Kind9;
        field$KindArray[7] = field$Kind8;
        field$KindArray[8] = field$Kind7;
        field$KindArray[9] = field$Kind6;
        field$KindArray[10] = field$Kind5;
        field$KindArray[11] = field$Kind4;
        field$KindArray[12] = field$Kind3;
        field$KindArray[13] = field$Kind15;
        field$KindArray[14] = field$KindArray2;
        field$KindArray[15] = field$Kind16;
        field$KindArray[16] = field$Kind17;
        field$KindArray[17] = field$KindArray3;
        field$KindArray[18] = field$Kind;
        field$KindArray[n16] = field$Kind2;
        $VALUES = field$KindArray;
        internalValueMap = object = new Field$Kind$1();
        VALUES = Field$Kind.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Field$Kind() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Field$Kind forNumber(int n10) {
        switch (n10) {
            default: {
                return null;
            }
            case 18: {
                return TYPE_SINT64;
            }
            case 17: {
                return TYPE_SINT32;
            }
            case 16: {
                return TYPE_SFIXED64;
            }
            case 15: {
                return TYPE_SFIXED32;
            }
            case 14: {
                return TYPE_ENUM;
            }
            case 13: {
                return TYPE_UINT32;
            }
            case 12: {
                return TYPE_BYTES;
            }
            case 11: {
                return TYPE_MESSAGE;
            }
            case 10: {
                return TYPE_GROUP;
            }
            case 9: {
                return TYPE_STRING;
            }
            case 8: {
                return TYPE_BOOL;
            }
            case 7: {
                return TYPE_FIXED32;
            }
            case 6: {
                return TYPE_FIXED64;
            }
            case 5: {
                return TYPE_INT32;
            }
            case 4: {
                return TYPE_UINT64;
            }
            case 3: {
                return TYPE_INT64;
            }
            case 2: {
                return TYPE_FLOAT;
            }
            case 1: {
                return TYPE_DOUBLE;
            }
            case 0: 
        }
        return TYPE_UNKNOWN;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Field.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Field$Kind valueOf(int n10) {
        return Field$Kind.forNumber(n10);
    }

    public static Field$Kind valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Field$Kind[] field$KindArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (field$KindArray == (descriptors$EnumDescriptor = Field$Kind.getDescriptor())) {
            int n10;
            int n11 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            if (n11 == (n10 = -1)) {
                return UNRECOGNIZED;
            }
            field$KindArray = VALUES;
            int n12 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return field$KindArray[n12];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Field$Kind valueOf(String string2) {
        return Enum.valueOf(Field$Kind.class, string2);
    }

    public static Field$Kind[] values() {
        return (Field$Kind[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Field$Kind.getDescriptor();
    }

    public final int getNumber() {
        Object object = UNRECOGNIZED;
        if (this != object) {
            return this.value;
        }
        object = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw object;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = Field$Kind.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

