/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.sdkinternal;

import com.google.mlkit.common.sdkinternal.MLTaskInput;
import com.google.mlkit.common.sdkinternal.ModelResource;

public abstract class MLTask
extends ModelResource {
    public abstract Object run(MLTaskInput var1);
}

