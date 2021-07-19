/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.sdkinternal.model.ModelValidator$ValidationResult$ErrorCode;

public class ModelValidator$ValidationResult {
    public static final ModelValidator$ValidationResult VALID;
    private final ModelValidator$ValidationResult$ErrorCode zza;
    private final String zzb;

    static {
        ModelValidator$ValidationResult modelValidator$ValidationResult;
        ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode = ModelValidator$ValidationResult$ErrorCode.OK;
        VALID = modelValidator$ValidationResult = new ModelValidator$ValidationResult(modelValidator$ValidationResult$ErrorCode, null);
    }

    public ModelValidator$ValidationResult(ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode, String string2) {
        this.zza = modelValidator$ValidationResult$ErrorCode;
        this.zzb = string2;
    }

    public ModelValidator$ValidationResult$ErrorCode getErrorCode() {
        return this.zza;
    }

    public String getErrorMessage() {
        return this.zzb;
    }

    public boolean isValid() {
        ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode = this.zza;
        ModelValidator$ValidationResult$ErrorCode modelValidator$ValidationResult$ErrorCode2 = ModelValidator$ValidationResult$ErrorCode.OK;
        return modelValidator$ValidationResult$ErrorCode == modelValidator$ValidationResult$ErrorCode2;
    }
}

