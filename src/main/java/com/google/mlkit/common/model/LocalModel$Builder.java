/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.mlkit.common.model;

import android.net.Uri;
import com.google.android.gms.common.internal.Preconditions;
import com.google.mlkit.common.model.LocalModel;

public class LocalModel$Builder {
    private String zza = null;
    private String zzb = null;
    private Uri zzc = null;

    public LocalModel build() {
        boolean bl2;
        String string2;
        Object object = this.zza;
        if (object != null && (string2 = this.zzb) == null && (string2 = this.zzc) == null || object == null && (string2 = this.zzb) != null && (string2 = this.zzc) == null || object == null && (object = this.zzb) == null && (object = this.zzc) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Preconditions.checkArgument(bl2, "Set one of filePath, assetFilePath and URI.");
        string2 = this.zza;
        String string3 = this.zzb;
        Uri uri = this.zzc;
        object = new LocalModel(string2, string3, uri, null);
        return object;
    }

    public LocalModel$Builder setAbsoluteFilePath(String string2) {
        boolean bl2;
        Preconditions.checkNotEmpty(string2, "Model Source file path can not be empty");
        String string3 = this.zzb;
        if (string3 == null && (string3 = this.zzc) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        Preconditions.checkArgument(bl2, "A local model source is from local file, asset or URI, you can only set one of them.");
        this.zza = string2;
        return this;
    }

    public LocalModel$Builder setAssetFilePath(String string2) {
        boolean bl2;
        Preconditions.checkNotEmpty(string2, "Model Source file path can not be empty");
        String string3 = this.zza;
        if (string3 == null && (string3 = this.zzc) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            string3 = null;
        }
        Preconditions.checkArgument(bl2, "A local model source is from local file, asset or URI, you can only set one of them.");
        this.zzb = string2;
        return this;
    }

    public LocalModel$Builder setUri(Uri uri) {
        boolean bl2;
        String string2 = this.zza;
        if (string2 == null && (string2 = this.zzb) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            string2 = null;
        }
        Preconditions.checkArgument(bl2, "A local model source is from local file, asset or URI, you can only set one of them.");
        this.zzc = uri;
        return this;
    }
}

