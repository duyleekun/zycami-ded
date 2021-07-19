/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.mlkit.common.model;

import android.net.Uri;
import com.google.android.gms.common.internal.Objects;
import com.google.mlkit.common.model.zzb;

public class LocalModel {
    private final String zza;
    private final String zzb;
    private final Uri zzc;

    private LocalModel(String string2, String string3, Uri uri) {
        this.zza = string2;
        this.zzb = string3;
        this.zzc = uri;
    }

    public /* synthetic */ LocalModel(String string2, String string3, Uri uri, zzb zzb2) {
        this(string2, string3, uri);
    }

    public boolean equals(Object object) {
        boolean bl2;
        if (object == null) {
            return false;
        }
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof LocalModel;
        if (!bl4) {
            return false;
        }
        object = (LocalModel)object;
        String string2 = this.zza;
        String string3 = ((LocalModel)object).zza;
        bl4 = Objects.equal(string2, string3);
        if (bl4 && (bl4 = Objects.equal(string2 = this.zzb, string3 = ((LocalModel)object).zzb)) && (bl2 = Objects.equal(string2 = this.zzc, object = ((LocalModel)object).zzc))) {
            return bl3;
        }
        return false;
    }

    public String getAbsoluteFilePath() {
        return this.zza;
    }

    public String getAssetFilePath() {
        return this.zzb;
    }

    public Uri getUri() {
        return this.zzc;
    }

    public int hashCode() {
        Object[] objectArray = new Object[3];
        String string2 = this.zza;
        objectArray[0] = string2;
        string2 = this.zzb;
        objectArray[1] = string2;
        string2 = this.zzc;
        objectArray[2] = string2;
        return Objects.hashCode(objectArray);
    }
}

