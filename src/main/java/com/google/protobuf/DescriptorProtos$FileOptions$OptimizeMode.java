/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.DescriptorProtos$FileOptions;
import com.google.protobuf.DescriptorProtos$FileOptions$OptimizeMode$1;
import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class DescriptorProtos$FileOptions$OptimizeMode
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ DescriptorProtos$FileOptions$OptimizeMode[] $VALUES;
    public static final /* enum */ DescriptorProtos$FileOptions$OptimizeMode CODE_SIZE;
    public static final int CODE_SIZE_VALUE = 2;
    public static final /* enum */ DescriptorProtos$FileOptions$OptimizeMode LITE_RUNTIME;
    public static final int LITE_RUNTIME_VALUE = 3;
    public static final /* enum */ DescriptorProtos$FileOptions$OptimizeMode SPEED;
    public static final int SPEED_VALUE = 1;
    private static final DescriptorProtos$FileOptions$OptimizeMode[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode;
        DescriptorProtos$FileOptions$OptimizeMode descriptorProtos$FileOptions$OptimizeMode2;
        int n10 = 1;
        Object object = new DescriptorProtos$FileOptions$OptimizeMode("SPEED", 0, n10);
        SPEED = object;
        int n11 = 2;
        CODE_SIZE = descriptorProtos$FileOptions$OptimizeMode2 = new DescriptorProtos$FileOptions$OptimizeMode("CODE_SIZE", n10, n11);
        int n12 = 3;
        LITE_RUNTIME = descriptorProtos$FileOptions$OptimizeMode = new DescriptorProtos$FileOptions$OptimizeMode("LITE_RUNTIME", n11, n12);
        DescriptorProtos$FileOptions$OptimizeMode[] descriptorProtos$FileOptions$OptimizeModeArray = new DescriptorProtos$FileOptions$OptimizeMode[n12];
        descriptorProtos$FileOptions$OptimizeModeArray[0] = object;
        descriptorProtos$FileOptions$OptimizeModeArray[n10] = descriptorProtos$FileOptions$OptimizeMode2;
        descriptorProtos$FileOptions$OptimizeModeArray[n11] = descriptorProtos$FileOptions$OptimizeMode;
        $VALUES = descriptorProtos$FileOptions$OptimizeModeArray;
        internalValueMap = object = new DescriptorProtos$FileOptions$OptimizeMode$1();
        VALUES = DescriptorProtos$FileOptions$OptimizeMode.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private DescriptorProtos$FileOptions$OptimizeMode() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static DescriptorProtos$FileOptions$OptimizeMode forNumber(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    return null;
                }
                return LITE_RUNTIME;
            }
            return CODE_SIZE;
        }
        return SPEED;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)DescriptorProtos$FileOptions.getDescriptor().getEnumTypes().get(0);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(int n10) {
        return DescriptorProtos$FileOptions$OptimizeMode.forNumber(n10);
    }

    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        DescriptorProtos$FileOptions$OptimizeMode[] descriptorProtos$FileOptions$OptimizeModeArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (descriptorProtos$FileOptions$OptimizeModeArray == (descriptors$EnumDescriptor = DescriptorProtos$FileOptions$OptimizeMode.getDescriptor())) {
            descriptorProtos$FileOptions$OptimizeModeArray = VALUES;
            int n10 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return descriptorProtos$FileOptions$OptimizeModeArray[n10];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static DescriptorProtos$FileOptions$OptimizeMode valueOf(String string2) {
        return Enum.valueOf(DescriptorProtos$FileOptions$OptimizeMode.class, string2);
    }

    public static DescriptorProtos$FileOptions$OptimizeMode[] values() {
        return (DescriptorProtos$FileOptions$OptimizeMode[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return DescriptorProtos$FileOptions$OptimizeMode.getDescriptor();
    }

    public final int getNumber() {
        return this.value;
    }

    public final Descriptors$EnumValueDescriptor getValueDescriptor() {
        List list = DescriptorProtos$FileOptions$OptimizeMode.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

