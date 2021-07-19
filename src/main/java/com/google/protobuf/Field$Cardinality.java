/*
 * Decompiled with CFR 0.151.
 */
package com.google.protobuf;

import com.google.protobuf.Descriptors$EnumDescriptor;
import com.google.protobuf.Descriptors$EnumValueDescriptor;
import com.google.protobuf.Field;
import com.google.protobuf.Field$Cardinality$1;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.ProtocolMessageEnum;
import java.util.List;

public final class Field$Cardinality
extends Enum
implements ProtocolMessageEnum {
    private static final /* synthetic */ Field$Cardinality[] $VALUES;
    public static final /* enum */ Field$Cardinality CARDINALITY_OPTIONAL;
    public static final int CARDINALITY_OPTIONAL_VALUE = 1;
    public static final /* enum */ Field$Cardinality CARDINALITY_REPEATED;
    public static final int CARDINALITY_REPEATED_VALUE = 3;
    public static final /* enum */ Field$Cardinality CARDINALITY_REQUIRED;
    public static final int CARDINALITY_REQUIRED_VALUE = 2;
    public static final /* enum */ Field$Cardinality CARDINALITY_UNKNOWN;
    public static final int CARDINALITY_UNKNOWN_VALUE;
    public static final /* enum */ Field$Cardinality UNRECOGNIZED;
    private static final Field$Cardinality[] VALUES;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        Field$Cardinality field$Cardinality;
        Field$Cardinality field$Cardinality2;
        Field$Cardinality field$Cardinality3;
        Field$Cardinality field$Cardinality4;
        Object object = new Field$Cardinality("CARDINALITY_UNKNOWN", 0, 0);
        CARDINALITY_UNKNOWN = object;
        int n10 = 1;
        CARDINALITY_OPTIONAL = field$Cardinality4 = new Field$Cardinality("CARDINALITY_OPTIONAL", n10, n10);
        int n11 = 2;
        CARDINALITY_REQUIRED = field$Cardinality3 = new Field$Cardinality("CARDINALITY_REQUIRED", n11, n11);
        int n12 = 3;
        CARDINALITY_REPEATED = field$Cardinality2 = new Field$Cardinality("CARDINALITY_REPEATED", n12, n12);
        int n13 = 4;
        UNRECOGNIZED = field$Cardinality = new Field$Cardinality("UNRECOGNIZED", n13, -1);
        Field$Cardinality[] field$CardinalityArray = new Field$Cardinality[5];
        field$CardinalityArray[0] = object;
        field$CardinalityArray[n10] = field$Cardinality4;
        field$CardinalityArray[n11] = field$Cardinality3;
        field$CardinalityArray[n12] = field$Cardinality2;
        field$CardinalityArray[n13] = field$Cardinality;
        $VALUES = field$CardinalityArray;
        internalValueMap = object = new Field$Cardinality$1();
        VALUES = Field$Cardinality.values();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private Field$Cardinality() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static Field$Cardinality forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        return null;
                    }
                    return CARDINALITY_REPEATED;
                }
                return CARDINALITY_REQUIRED;
            }
            return CARDINALITY_OPTIONAL;
        }
        return CARDINALITY_UNKNOWN;
    }

    public static final Descriptors$EnumDescriptor getDescriptor() {
        return (Descriptors$EnumDescriptor)Field.getDescriptor().getEnumTypes().get(1);
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Field$Cardinality valueOf(int n10) {
        return Field$Cardinality.forNumber(n10);
    }

    public static Field$Cardinality valueOf(Descriptors$EnumValueDescriptor object) {
        Descriptors$EnumDescriptor descriptors$EnumDescriptor;
        Field$Cardinality[] field$CardinalityArray = ((Descriptors$EnumValueDescriptor)object).getType();
        if (field$CardinalityArray == (descriptors$EnumDescriptor = Field$Cardinality.getDescriptor())) {
            int n10;
            int n11 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            if (n11 == (n10 = -1)) {
                return UNRECOGNIZED;
            }
            field$CardinalityArray = VALUES;
            int n12 = ((Descriptors$EnumValueDescriptor)object).getIndex();
            return field$CardinalityArray[n12];
        }
        object = new IllegalArgumentException("EnumValueDescriptor is not for this type.");
        throw object;
    }

    public static Field$Cardinality valueOf(String string2) {
        return Enum.valueOf(Field$Cardinality.class, string2);
    }

    public static Field$Cardinality[] values() {
        return (Field$Cardinality[])$VALUES.clone();
    }

    public final Descriptors$EnumDescriptor getDescriptorForType() {
        return Field$Cardinality.getDescriptor();
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
        List list = Field$Cardinality.getDescriptor().getValues();
        int n10 = this.ordinal();
        return (Descriptors$EnumValueDescriptor)list.get(n10);
    }
}

