/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.api;

import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;

public abstract class TransformedResult {
    public abstract void andFinally(ResultCallbacks var1);

    public abstract TransformedResult then(ResultTransform var1);
}

