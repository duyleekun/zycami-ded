/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FieldDescriptorProto;
import com.google.protobuf.DescriptorProtos$FieldDescriptorProto$Label$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class DescriptorProtos$FieldDescriptorProto$Label
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ DescriptorProtos$FieldDescriptorProto$Label[] $VALUES;
    public static final /* enum */ DescriptorProtos$FieldDescriptorProto$Label LABEL_OPTIONAL;
    public static final int LABEL_OPTIONAL_VALUE = 1;
    public static final /* enum */ DescriptorProtos$FieldDescriptorProto$Label LABEL_REPEATED;
    public static final int LABEL_REPEATED_VALUE = 3;
    public static final /* enum */ DescriptorProtos$FieldDescriptorProto$Label LABEL_REQUIRED;
    public static final int LABEL_REQUIRED_VALUE = 2;
    private static final DescriptorProtos$FieldDescriptorProto$Label[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label;
        DescriptorProtos$FieldDescriptorProto$Label descriptorProtos$FieldDescriptorProto$Label2;
        int n10 = 1;
        Object object = new DescriptorProtos$FieldDescriptorProto$Label("LABEL_OPTIONAL", 0, n10);
        LABEL_OPTIONAL = object;
        int n11 = 2;
        LABEL_REQUIRED = descriptorProtos$FieldDescriptorProto$Label2 = new DescriptorProtos$FieldDescriptorProto$Label("LABEL_REQUIRED", n10, n11);
        int n12 = 3;
        LABEL_REPEATED = descriptorProtos$FieldDescriptorProto$Label = new DescriptorProtos$FieldDescriptorProto$Label("LABEL_REPEATED", n11, n12);
        DescriptorProtos$FieldDescriptorProto$Label[] descriptorProtos$FieldDescriptorProto$LabelArray = new DescriptorProtos$FieldDescriptorProto$Label[n12];
        descriptorProtos$FieldDescriptorProto$LabelArray[0] = object;
        descriptorProtos$FieldDescriptorProto$LabelArray[n10] = descriptorProtos$FieldDescriptorProto$Label2;
        descriptorProtos$FieldDescriptorProto$LabelArray[n11] = descriptorProtos$FieldDescriptorProto$Label;
        $VALUES = descriptorProtos$FieldDescriptorProto$LabelArray;
        internalValueMap = object = new DescriptorProtos$FieldDescriptorProto$Label$1();
        VALUES = DescriptorProtos$FieldDescriptorProto$Label.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DescriptorProtos$FieldDescriptorProto$Label() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DescriptorProtos$FieldDescriptorProto$Label forNumber(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return null;
                }
                return LABEL_REPEATED;
            }
            return LABEL_REQUIRED;
        }
        return LABEL_OPTIONAL;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FieldDescriptorProto.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(int n10) {
        return DescriptorProtos$FieldDescriptorProto$Label.forNumber(n10);
    }

    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        DescriptorProtos$FieldDescriptorProto$Label[] descriptorProtos$FieldDescriptorProto$LabelArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (descriptorProtos$FieldDescriptorProto$LabelArray == (descriptors$EnumDescriptor = DescriptorProtos$FieldDescriptorProto$Label.getDescriptor())) {
            descriptorProtos$FieldDescriptorProto$LabelArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return descriptorProtos$FieldDescriptorProto$LabelArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static DescriptorProtos$FieldDescriptorProto$Label valueOf(String string2) {
        return Enum.valueOf(DescriptorProtos$FieldDescriptorProto$Label.class, string2);
    }

    public static DescriptorProtos$FieldDescriptorProto$Label[] values() {
        return (DescriptorProtos$FieldDescriptorProto$Label[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FieldDescriptorProto$Label.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = DescriptorProtos$FieldDescriptorProto$Label.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

