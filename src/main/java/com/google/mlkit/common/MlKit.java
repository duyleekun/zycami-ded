/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.mlkit.common;

import android.content.Context;
import com.google.mlkit.common.sdkinternal.MlKitContext;

public class MlKit {
    private MlKit() {
    }

    public static void initialize(Context context) {
        MlKitContext.zza(context);
    }
}

