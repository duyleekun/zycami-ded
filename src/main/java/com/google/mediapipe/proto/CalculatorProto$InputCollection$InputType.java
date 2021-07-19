/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$InputCollection$InputType$1;
import com.google.mediapipe.proto.CalculatorProto$InputCollection$InputType$InputTypeVerifier;
import com.google.protobuf.Internal$EnumLite;
import com.google.protobuf.Internal$EnumLiteMap;
import com.google.protobuf.Internal$EnumVerifier;

public final class CalculatorProto$InputCollection$InputType
extends Enum
implements Internal$EnumLite {
    private static final /* synthetic */ CalculatorProto$InputCollection$InputType[] $VALUES;
    public static final /* enum */ CalculatorProto$InputCollection$InputType FOREIGN_CSV_TEXT;
    public static final int FOREIGN_CSV_TEXT_VALUE = 3;
    public static final /* enum */ CalculatorProto$InputCollection$InputType FOREIGN_RECORDIO;
    public static final int FOREIGN_RECORDIO_VALUE = 2;
    public static final /* enum */ CalculatorProto$InputCollection$InputType INVALID_UPPER_BOUND;
    public static final int INVALID_UPPER_BOUND_VALUE = 4;
    public static final /* enum */ CalculatorProto$InputCollection$InputType RECORDIO;
    public static final int RECORDIO_VALUE = 1;
    public static final /* enum */ CalculatorProto$InputCollection$InputType UNKNOWN;
    public static final int UNKNOWN_VALUE;
    public static final /* enum */ CalculatorProto$InputCollection$InputType UNRECOGNIZED;
    private static final Internal$EnumLiteMap internalValueMap;
    private final int value;

    static {
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType;
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType2;
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType3;
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType4;
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType5;
        Object object = new CalculatorProto$InputCollection$InputType("UNKNOWN", 0, 0);
        UNKNOWN = object;
        int n10 = 1;
        RECORDIO = calculatorProto$InputCollection$InputType5 = new CalculatorProto$InputCollection$InputType("RECORDIO", n10, n10);
        int n11 = 2;
        FOREIGN_RECORDIO = calculatorProto$InputCollection$InputType4 = new CalculatorProto$InputCollection$InputType("FOREIGN_RECORDIO", n11, n11);
        int n12 = 3;
        FOREIGN_CSV_TEXT = calculatorProto$InputCollection$InputType3 = new CalculatorProto$InputCollection$InputType("FOREIGN_CSV_TEXT", n12, n12);
        int n13 = 4;
        INVALID_UPPER_BOUND = calculatorProto$InputCollection$InputType2 = new CalculatorProto$InputCollection$InputType("INVALID_UPPER_BOUND", n13, n13);
        int n14 = 5;
        UNRECOGNIZED = calculatorProto$InputCollection$InputType = new CalculatorProto$InputCollection$InputType("UNRECOGNIZED", n14, -1);
        CalculatorProto$InputCollection$InputType[] calculatorProto$InputCollection$InputTypeArray = new CalculatorProto$InputCollection$InputType[6];
        calculatorProto$InputCollection$InputTypeArray[0] = object;
        calculatorProto$InputCollection$InputTypeArray[n10] = calculatorProto$InputCollection$InputType5;
        calculatorProto$InputCollection$InputTypeArray[n11] = calculatorProto$InputCollection$InputType4;
        calculatorProto$InputCollection$InputTypeArray[n12] = calculatorProto$InputCollection$InputType3;
        calculatorProto$InputCollection$InputTypeArray[n13] = calculatorProto$InputCollection$InputType2;
        calculatorProto$InputCollection$InputTypeArray[n14] = calculatorProto$InputCollection$InputType;
        $VALUES = calculatorProto$InputCollection$InputTypeArray;
        internalValueMap = object = new CalculatorProto$InputCollection$InputType$1();
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private CalculatorProto$InputCollection$InputType() {
        void var3_1;
        void var2_-1;
        void var1_-1;
        this.value = var3_1;
    }

    public static CalculatorProto$InputCollection$InputType forNumber(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 != n11) {
                n11 = 2;
                if (n10 != n11) {
                    n11 = 3;
                    if (n10 != n11) {
                        n11 = 4;
                        if (n10 != n11) {
                            return null;
                        }
                        return INVALID_UPPER_BOUND;
                    }
                    return FOREIGN_CSV_TEXT;
                }
                return FOREIGN_RECORDIO;
            }
            return RECORDIO;
        }
        return UNKNOWN;
    }

    public static Internal$EnumLiteMap internalGetValueMap() {
        return internalValueMap;
    }

    public static Internal$EnumVerifier internalGetVerifier() {
        return CalculatorProto$InputCollection$InputType$InputTypeVerifier.INSTANCE;
    }

    public static CalculatorProto$InputCollection$InputType valueOf(int n10) {
        return CalculatorProto$InputCollection$InputType.forNumber(n10);
    }

    public static CalculatorProto$InputCollection$InputType valueOf(String string2) {
        return Enum.valueOf(CalculatorProto$InputCollection$InputType.class, string2);
    }

    public static CalculatorProto$InputCollection$InputType[] values() {
        return (CalculatorProto$InputCollection$InputType[])$VALUES.clone();
    }

    public final int getNumber() {
        Object object = UNRECOGNIZED;
        if (this != object) {
            return this.value;
        }
        object = new IllegalArgumentException("Can't get the number of an unknown enum value.");
        throw object;
    }
}

