/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.NullValue$1;
import com.google.protobuf.ProtocolMessageEnum;
import com.google.protobuf.StructProto;
import java.util.List;

public final class NullValue
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ NullValue[] $VALUES;
    public static final /* enum */ NullValue NULL_VALUE;
    public static final int NULL_VALUE_VALUE;
    public static final /* enum */ NullValue UNRECOGNIZED;
    private static final NullValue[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        NullValue nullValue;
        Object object = new NullValue("NULL_VALUE", 0, 0);
        NULL_VALUE = object;
        int n10 = 1;
        UNRECOGNIZED = nullValue = new NullValue("UNRECOGNIZED", n10, -1);
        NullValue[] nullValueArray = new NullValue[2];
        nullValueArray[0] = object;
        nullValueArray[n10] = nullValue;
        $VALUES = nullValueArray;
        internalValueMap = object = new NullValue$1();
        VALUES = NullValue.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private NullValue() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static NullValue forNumber(int n10) {
        if (n10 != 0) {
            return null;
        }
        return NULL_VALUE;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)StructProto.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static NullValue valueOf(int n10) {
        return NullValue.forNumber(n10);
    }

    public static NullValue valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        NullValue[] nullValueArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (nullValueArray == (descriptors$EnumDescriptor = NullValue.getDescriptor())) {
            int n10;
            int n11 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            if (n11 == (n10 = -1)) {
                return UNRECOGNIZED;
            }
            nullValueArray = VALUES;
            int n12 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return nullValueArray[n12];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static NullValue valueOf(String string2) {
        return Enum.valueOf(NullValue.class, string2);
    }

    public static NullValue[] values() {
        return (NullValue[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return NullValue.getDescriptor();
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
        List list = NullValue.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

