/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal.model;

import com.google.android.gms.internal.mlkit_common.zzx;
import com.google.mlkit.common.internal.model.AutoValue_ModelUtils_ModelLoggingInfo;

public abstract class ModelUtils$ModelLoggingInfo {
    public static ModelUtils$ModelLoggingInfo zza(long l10, String string2) {
        string2 = zzx.zza(string2);
        AutoValue_ModelUtils_ModelLoggingInfo autoValue_ModelUtils_ModelLoggingInfo = new AutoValue_ModelUtils_ModelLoggingInfo(l10, string2);
        return autoValue_ModelUtils_ModelLoggingInfo;
    }

    public abstract String getHash();

    public abstract long getSize();
}

