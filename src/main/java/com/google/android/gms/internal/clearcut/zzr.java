/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.clearcut;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.clearcut.zzge$zzv$zzb;
import com.google.android.gms.internal.clearcut.zzs;

public final class zzr
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String packageName;
    private final boolean zzay;
    private final int zzaz;
    private final int zzi;
    public final String zzj;
    public final int zzk;
    private final String zzl;
    private final String zzm;
    private final boolean zzn;

    static {
        zzs zzs2 = new zzs();
        CREATOR = zzs2;
    }

    public zzr(String string2, int n10, int n11, String string3, String string4, String string5, boolean bl2, zzge$zzv$zzb zzge$zzv$zzb) {
        int n12;
        this.packageName = string2 = (String)Preconditions.checkNotNull(string2);
        this.zzi = n10;
        this.zzk = n11;
        this.zzj = string3;
        this.zzl = string4;
        this.zzm = string5;
        this.zzay = n12 = bl2 ^ 1;
        this.zzn = bl2;
        this.zzaz = n12 = zzge$zzv$zzb.zzc();
    }

    public zzr(String string2, int n10, int n11, String string3, String string4, boolean bl2, String string5, boolean bl3, int n12) {
        this.packageName = string2;
        this.zzi = n10;
        this.zzk = n11;
        this.zzl = string3;
        this.zzm = string4;
        this.zzay = bl2;
        this.zzj = string5;
        this.zzn = bl3;
        this.zzaz = n12;
    }

    public final boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof zzr;
        if (n10 != 0) {
            int n11;
            int n12;
            object = (zzr)object;
            String string2 = this.packageName;
            String string3 = ((zzr)object).packageName;
            n10 = Objects.equal(string2, string3);
            if (n10 != 0 && (n10 = this.zzi) == (n12 = ((zzr)object).zzi) && (n10 = this.zzk) == (n12 = ((zzr)object).zzk) && (n10 = (int)(Objects.equal(string2 = this.zzj, string3 = ((zzr)object).zzj) ? 1 : 0)) != 0 && (n10 = (int)(Objects.equal(string2 = this.zzl, string3 = ((zzr)object).zzl) ? 1 : 0)) != 0 && (n10 = (int)(Objects.equal(string2 = this.zzm, string3 = ((zzr)object).zzm) ? 1 : 0)) != 0 && (n10 = (int)(this.zzay ? 1 : 0)) == (n12 = (int)(((zzr)object).zzay ? 1 : 0)) && (n10 = (int)(this.zzn ? 1 : 0)) == (n12 = (int)(((zzr)object).zzn ? 1 : 0)) && (n10 = this.zzaz) == (n11 = ((zzr)object).zzaz)) {
                return bl2;
            }
        }
        return false;
    }

    public final int hashCode() {
        Object object = this.packageName;
        object = this.zzi;
        Object[] objectArray = new Object[]{object, object, object = Integer.valueOf(this.zzk), object = this.zzj, object = this.zzl, object = this.zzm, object = Boolean.valueOf(this.zzay), object = Boolean.valueOf(this.zzn), object = Integer.valueOf(this.zzaz)};
        return Objects.hashCode(objectArray);
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("package=");
        String string2 = this.packageName;
        stringBuilder.append(string2);
        int n10 = 44;
        stringBuilder.append((char)n10);
        stringBuilder.append("packageVersionCode=");
        int bl2 = this.zzi;
        stringBuilder.append(bl2);
        stringBuilder.append((char)n10);
        stringBuilder.append("logSource=");
        int n11 = this.zzk;
        stringBuilder.append(n11);
        stringBuilder.append((char)n10);
        stringBuilder.append("logSourceName=");
        String string3 = this.zzj;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append("uploadAccount=");
        string3 = this.zzl;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append("loggingId=");
        string3 = this.zzm;
        stringBuilder.append(string3);
        stringBuilder.append((char)n10);
        stringBuilder.append("logAndroidId=");
        boolean bl3 = this.zzay;
        stringBuilder.append(bl3);
        stringBuilder.append((char)n10);
        stringBuilder.append("isAnonymous=");
        boolean bl4 = this.zzn;
        stringBuilder.append(bl4);
        stringBuilder.append((char)n10);
        stringBuilder.append("qosTier=");
        n10 = this.zzaz;
        stringBuilder.append(n10);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        String string2 = this.packageName;
        SafeParcelWriter.writeString(parcel, 2, string2, false);
        int n11 = this.zzi;
        SafeParcelWriter.writeInt(parcel, 3, n11);
        n11 = this.zzk;
        SafeParcelWriter.writeInt(parcel, 4, n11);
        string2 = this.zzl;
        SafeParcelWriter.writeString(parcel, 5, string2, false);
        string2 = this.zzm;
        SafeParcelWriter.writeString(parcel, 6, string2, false);
        n11 = (int)(this.zzay ? 1 : 0);
        SafeParcelWriter.writeBoolean(parcel, 7, n11 != 0);
        string2 = this.zzj;
        SafeParcelWriter.writeString(parcel, 8, string2, false);
        n11 = this.zzn;
        SafeParcelWriter.writeBoolean(parcel, 9, n11 != 0);
        n11 = this.zzaz;
        SafeParcelWriter.writeInt(parcel, 10, n11);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

