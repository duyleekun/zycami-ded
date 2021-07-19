/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal.model;

import com.google.mlkit.common.model.RemoteModel;
import com.google.mlkit.common.sdkinternal.model.ModelValidator$ValidationResult;
import java.io.File;

public interface ModelValidator {
    public ModelValidator$ValidationResult validateModel(File var1, RemoteModel var2);
}

