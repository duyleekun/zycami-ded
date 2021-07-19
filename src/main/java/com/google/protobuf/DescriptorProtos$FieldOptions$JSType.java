/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$JSType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class DescriptorProtos$FieldOptions$JSType
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ DescriptorProtos$FieldOptions$JSType[] $VALUES;
    public static final /* enum */ DescriptorProtos$FieldOptions$JSType JS_NORMAL;
    public static final int JS_NORMAL_VALUE = 0;
    public static final /* enum */ DescriptorProtos$FieldOptions$JSType JS_NUMBER;
    public static final int JS_NUMBER_VALUE = 2;
    public static final /* enum */ DescriptorProtos$FieldOptions$JSType JS_STRING;
    public static final int JS_STRING_VALUE = 1;
    private static final DescriptorProtos$FieldOptions$JSType[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType;
        DescriptorProtos$FieldOptions$JSType descriptorProtos$FieldOptions$JSType2;
        Object object = new DescriptorProtos$FieldOptions$JSType("JS_NORMAL", 0, 0);
        JS_NORMAL = object;
        int n10 = 1;
        JS_STRING = descriptorProtos$FieldOptions$JSType2 = new DescriptorProtos$FieldOptions$JSType("JS_STRING", n10, n10);
        int n11 = 2;
        JS_NUMBER = descriptorProtos$FieldOptions$JSType = new DescriptorProtos$FieldOptions$JSType("JS_NUMBER", n11, n11);
        DescriptorProtos$FieldOptions$JSType[] descriptorProtos$FieldOptions$JSTypeArray = new DescriptorProtos$FieldOptions$JSType[3];
        descriptorProtos$FieldOptions$JSTypeArray[0] = object;
        descriptorProtos$FieldOptions$JSTypeArray[n10] = descriptorProtos$FieldOptions$JSType2;
        descriptorProtos$FieldOptions$JSTypeArray[n11] = descriptorProtos$FieldOptions$JSType;
        $VALUES = descriptorProtos$FieldOptions$JSTypeArray;
        internalValueMap = object = new DescriptorProtos$FieldOptions$JSType$1();
        VALUES = DescriptorProtos$FieldOptions$JSType.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DescriptorProtos$FieldOptions$JSType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DescriptorProtos$FieldOptions$JSType forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return JS_NUMBER;
            }
            return JS_STRING;
        }
        return JS_NORMAL;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static DescriptorProtos$FieldOptions$JSType valueOf(int n10) {
        return DescriptorProtos$FieldOptions$JSType.forNumber(n10);
    }

    public static DescriptorProtos$FieldOptions$JSType valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        DescriptorProtos$FieldOptions$JSType[] descriptorProtos$FieldOptions$JSTypeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (descriptorProtos$FieldOptions$JSTypeArray == (descriptors$EnumDescriptor = DescriptorProtos$FieldOptions$JSType.getDescriptor())) {
            descriptorProtos$FieldOptions$JSTypeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return descriptorProtos$FieldOptions$JSTypeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static DescriptorProtos$FieldOptions$JSType valueOf(String string2) {
        return Enum.valueOf(DescriptorProtos$FieldOptions$JSType.class, string2);
    }

    public static DescriptorProtos$FieldOptions$JSType[] values() {
        return (DescriptorProtos$FieldOptions$JSType[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FieldOptions$JSType.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = DescriptorProtos$FieldOptions$JSType.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

