/*
 * Decompiled with CFR 0.151.
 */
package com.google.mediapipe.proto;

import com.google.mediapipe.proto.CalculatorProto$InputCollection$InputType;
import com.google.protobuf.Internal$EnumVerifier;

public final class CalculatorProto$InputCollection$InputType$InputTypeVerifier
implements Internal$EnumVerifier {
    public static final Internal$EnumVerifier INSTANCE;

    static {
        CalculatorProto$InputCollection$InputType$InputTypeVerifier calculatorProto$InputCollection$InputType$InputTypeVerifier = new CalculatorProto$InputCollection$InputType$InputTypeVerifier();
        INSTANCE = calculatorProto$InputCollection$InputType$InputTypeVerifier;
    }

    private CalculatorProto$InputCollection$InputType$InputTypeVerifier() {
    }

    public boolean isInRange(int n10) {
        CalculatorProto$InputCollection$InputType calculatorProto$InputCollection$InputType = CalculatorProto$InputCollection$InputType.forNumber(n10);
        if (calculatorProto$InputCollection$InputType != null) {
            n10 = 1;
        } else {
            n10 = 0;
            calculatorProto$InputCollection$InputType = null;
        }
        return n10 != 0;
    }
}

