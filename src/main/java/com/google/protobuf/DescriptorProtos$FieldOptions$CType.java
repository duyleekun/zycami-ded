/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldOptions;
import com.google.protobuf.DescriptorProtos$FieldOptions$CType$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class DescriptorProtos$FieldOptions$CType
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ DescriptorProtos$FieldOptions$CType[] $VALUES;
    public static final /* enum */ DescriptorProtos$FieldOptions$CType CORD;
    public static final int CORD_VALUE = 1;
    public static final /* enum */ DescriptorProtos$FieldOptions$CType STRING;
    public static final /* enum */ DescriptorProtos$FieldOptions$CType STRING_PIECE;
    public static final int STRING_PIECE_VALUE = 2;
    public static final int STRING_VALUE;
    private static final DescriptorProtos$FieldOptions$CType[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType;
        DescriptorProtos$FieldOptions$CType descriptorProtos$FieldOptions$CType2;
        Object object = new DescriptorProtos$FieldOptions$CType("STRING", 0, 0);
        STRING = object;
        int n10 = 1;
        CORD = descriptorProtos$FieldOptions$CType2 = new DescriptorProtos$FieldOptions$CType("CORD", n10, n10);
        int n11 = 2;
        STRING_PIECE = descriptorProtos$FieldOptions$CType = new DescriptorProtos$FieldOptions$CType("STRING_PIECE", n11, n11);
        DescriptorProtos$FieldOptions$CType[] descriptorProtos$FieldOptions$CTypeArray = new DescriptorProtos$FieldOptions$CType[3];
        descriptorProtos$FieldOptions$CTypeArray[0] = object;
        descriptorProtos$FieldOptions$CTypeArray[n10] = descriptorProtos$FieldOptions$CType2;
        descriptorProtos$FieldOptions$CTypeArray[n11] = descriptorProtos$FieldOptions$CType;
        $VALUES = descriptorProtos$FieldOptions$CTypeArray;
        internalValueMap = object = new DescriptorProtos$FieldOptions$CType$1();
        VALUES = DescriptorProtos$FieldOptions$CType.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DescriptorProtos$FieldOptions$CType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DescriptorProtos$FieldOptions$CType forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return STRING_PIECE;
            }
            return CORD;
        }
        return STRING;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FieldOptions.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static DescriptorProtos$FieldOptions$CType valueOf(int n10) {
        return DescriptorProtos$FieldOptions$CType.forNumber(n10);
    }

    public static DescriptorProtos$FieldOptions$CType valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        DescriptorProtos$FieldOptions$CType[] descriptorProtos$FieldOptions$CTypeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (descriptorProtos$FieldOptions$CTypeArray == (descriptors$EnumDescriptor = DescriptorProtos$FieldOptions$CType.getDescriptor())) {
            descriptorProtos$FieldOptions$CTypeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return descriptorProtos$FieldOptions$CTypeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static DescriptorProtos$FieldOptions$CType valueOf(String string2) {
        return Enum.valueOf(DescriptorProtos$FieldOptions$CType.class, string2);
    }

    public static DescriptorProtos$FieldOptions$CType[] values() {
        return (DescriptorProtos$FieldOptions$CType[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FieldOptions$CType.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = DescriptorProtos$FieldOptions$CType.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

