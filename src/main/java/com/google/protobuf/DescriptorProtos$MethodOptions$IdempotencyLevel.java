/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$MethodOptions;
import com.google.protobuf.DescriptorProtos$MethodOptions$IdempotencyLevel$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class DescriptorProtos$MethodOptions$IdempotencyLevel
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ DescriptorProtos$MethodOptions$IdempotencyLevel[] $VALUES;
    public static final /* enum */ DescriptorProtos$MethodOptions$IdempotencyLevel IDEMPOTENCY_UNKNOWN;
    public static final int IDEMPOTENCY_UNKNOWN_VALUE = 0;
    public static final /* enum */ DescriptorProtos$MethodOptions$IdempotencyLevel IDEMPOTENT;
    public static final int IDEMPOTENT_VALUE = 2;
    public static final /* enum */ DescriptorProtos$MethodOptions$IdempotencyLevel NO_SIDE_EFFECTS;
    public static final int NO_SIDE_EFFECTS_VALUE = 1;
    private static final DescriptorProtos$MethodOptions$IdempotencyLevel[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        DescriptorProtos$MethodOptions$IdempotencyLevel descriptorProtos$MethodOptions$IdempotencyLevel;
        DescriptorProtos$MethodOptions$IdempotencyLevel descriptorProtos$MethodOptions$IdempotencyLevel2;
        Object object = new DescriptorProtos$MethodOptions$IdempotencyLevel("IDEMPOTENCY_UNKNOWN", 0, 0);
        IDEMPOTENCY_UNKNOWN = object;
        int n10 = 1;
        NO_SIDE_EFFECTS = descriptorProtos$MethodOptions$IdempotencyLevel2 = new DescriptorProtos$MethodOptions$IdempotencyLevel("NO_SIDE_EFFECTS", n10, n10);
        int n11 = 2;
        IDEMPOTENT = descriptorProtos$MethodOptions$IdempotencyLevel = new DescriptorProtos$MethodOptions$IdempotencyLevel("IDEMPOTENT", n11, n11);
        DescriptorProtos$MethodOptions$IdempotencyLevel[] descriptorProtos$MethodOptions$IdempotencyLevelArray = new DescriptorProtos$MethodOptions$IdempotencyLevel[3];
        descriptorProtos$MethodOptions$IdempotencyLevelArray[0] = object;
        descriptorProtos$MethodOptions$IdempotencyLevelArray[n10] = descriptorProtos$MethodOptions$IdempotencyLevel2;
        descriptorProtos$MethodOptions$IdempotencyLevelArray[n11] = descriptorProtos$MethodOptions$IdempotencyLevel;
        $VALUES = descriptorProtos$MethodOptions$IdempotencyLevelArray;
        internalValueMap = object = new DescriptorProtos$MethodOptions$IdempotencyLevel$1();
        VALUES = DescriptorProtos$MethodOptions$IdempotencyLevel.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DescriptorProtos$MethodOptions$IdempotencyLevel() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    return null;
                }
                return IDEMPOTENT;
            }
            return NO_SIDE_EFFECTS;
        }
        return IDEMPOTENCY_UNKNOWN;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$MethodOptions.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel valueOf(int n10) {
        return DescriptorProtos$MethodOptions$IdempotencyLevel.forNumber(n10);
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        DescriptorProtos$MethodOptions$IdempotencyLevel[] descriptorProtos$MethodOptions$IdempotencyLevelArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (descriptorProtos$MethodOptions$IdempotencyLevelArray == (descriptors$EnumDescriptor = DescriptorProtos$MethodOptions$IdempotencyLevel.getDescriptor())) {
            descriptorProtos$MethodOptions$IdempotencyLevelArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return descriptorProtos$MethodOptions$IdempotencyLevelArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel valueOf(String string2) {
        return Enum.valueOf(DescriptorProtos$MethodOptions$IdempotencyLevel.class, string2);
    }

    public static DescriptorProtos$MethodOptions$IdempotencyLevel[] values() {
        return (DescriptorProtos$MethodOptions$IdempotencyLevel[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$MethodOptions$IdempotencyLevel.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = DescriptorProtos$MethodOptions$IdempotencyLevel.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

