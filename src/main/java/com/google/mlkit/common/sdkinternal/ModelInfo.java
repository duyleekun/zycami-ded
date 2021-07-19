/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.mlkit.common.sdkinternal;

import android.net.Uri;
import com.google.mlkit.common.sdkinternal.ModelType;

public class ModelInfo {
    private final String zza;
    private final Uri zzb;
    private final String zzc;
    private final ModelType zzd;

    public ModelInfo(String string2, Uri uri, String string3, ModelType modelType) {
        this.zza = string2;
        this.zzb = uri;
        this.zzc = string3;
        this.zzd = modelType;
    }

    public String getModelHash() {
        return this.zzc;
    }

    public String getModelNameForPersist() {
        return this.zza;
    }

    public ModelType getModelType() {
        return this.zzd;
    }

    public Uri getModelUri() {
        return this.zzb;
    }
}

