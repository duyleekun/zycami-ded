/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

public final class ModelValidator$ValidationResult$ErrorCode
extends Enum {
    public static final /* enum */ ModelValidator$ValidationResult$ErrorCode MODEL_FORMAT_INVALID;
    public static final /* enum */ ModelValidator$ValidationResult$ErrorCode OK;
    public static final /* enum */ ModelValidator$ValidationResult$ErrorCode TFLITE_VERSION_INCOMPATIBLE;
    private static final /* synthetic */ ModelValidator$ValidationResult$ErrorCode[] zza;

    static {
        ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode;
        ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode2;
        ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode3;
        OK = modelValidator$ValidationResult$ErrorCode3 = new ModelValidator$ValidationResult$ErrorCode("OK", 0);
        int n10 = 1;
        TFLITE_VERSION_INCOMPATIBLE = modelValidator$ValidationResult$ErrorCode2 = new ModelValidator$ValidationResult$ErrorCode("TFLITE_VERSION_INCOMPATIBLE", n10);
        int n11 = 2;
        MODEL_FORMAT_INVALID = modelValidator$ValidationResult$ErrorCode = new ModelValidator$ValidationResult$ErrorCode("MODEL_FORMAT_INVALID", n11);
        ModelValidator$ValidationResult$ErrorCode[] modelValidator$ValidationResult$ErrorCodeArray = new ModelValidator$ValidationResult$ErrorCode[3];
        modelValidator$ValidationResult$ErrorCodeArray[0] = modelValidator$ValidationResult$ErrorCode3;
        modelValidator$ValidationResult$ErrorCodeArray[n10] = modelValidator$ValidationResult$ErrorCode2;
        modelValidator$ValidationResult$ErrorCodeArray[n11] = modelValidator$ValidationResult$ErrorCode;
        zza = modelValidator$ValidationResult$ErrorCodeArray;
    }

    /*
     * WARNING - Possible parameter corruption
     * WARNING - void declaration
     */
    private ModelValidator$ValidationResult$ErrorCode() {
        void var2_-1;
        void var1_-1;
    }

    public static ModelValidator$ValidationResult$ErrorCode[] values() {
        return (ModelValidator$ValidationResult$ErrorCode[])zza.clone();
    }
}

