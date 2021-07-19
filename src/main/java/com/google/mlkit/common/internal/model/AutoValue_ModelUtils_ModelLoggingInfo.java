/*
 * Decompiled with CFR 0.151.
 */
package com.google.mlkit.common.internal.model;

import com.google.mlkit.common.internal.model.ModelUtils$ModelLoggingInfo;
import java.util.Objects;

public final class AutoValue_ModelUtils_ModelLoggingInfo
extends ModelUtils$ModelLoggingInfo {
    private final long zza;
    private final String zzb;

    public AutoValue_ModelUtils_ModelLoggingInfo(long l10, String string2) {
        this.zza = l10;
        Objects.requireNonNull(string2, "Null hash");
        this.zzb = string2;
    }

    public final boolean equals(Object object) {
        String string2;
        boolean bl2;
        long l10;
        long l11;
        long l12;
        boolean bl3 = true;
        if (object == this) {
            return bl3;
        }
        boolean bl4 = object instanceof ModelUtils$ModelLoggingInfo;
        if (bl4 && !(bl4 = (l12 = (l11 = this.zza) - (l10 = ((ModelUtils$ModelLoggingInfo)(object = (ModelUtils$ModelLoggingInfo)object)).getSize())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) && (bl2 = (string2 = this.zzb).equals(object = ((ModelUtils$ModelLoggingInfo)object).getHash()))) {
            return bl3;
        }
        return false;
    }

    public final String getHash() {
        return this.zzb;
    }

    public final long getSize() {
        return this.zza;
    }

    public final int hashCode() {
        long l10 = this.zza;
        long l11 = l10 >>> 32;
        int n10 = (int)(l10 ^ l11);
        int n11 = 1000003;
        n10 = (n10 ^ n11) * n11;
        n11 = this.zzb.hashCode();
        return n10 ^ n11;
    }

    public final String toString() {
        long l10 = this.zza;
        String string2 = this.zzb;
        int n10 = String.valueOf(string2).length() + 50;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("ModelLoggingInfo{size=");
        stringBuilder.append(l10);
        stringBuilder.append(", hash=");
        stringBuilder.append(string2);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

