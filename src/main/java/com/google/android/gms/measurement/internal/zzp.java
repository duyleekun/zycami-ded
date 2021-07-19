/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.measurement.internal.zzq;
import java.util.List;

public final class zzp
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    public final String zza;
    public final String zzb;
    public final String zzc;
    public final String zzd;
    public final long zze;
    public final long zzf;
    public final String zzg;
    public final boolean zzh;
    public final boolean zzi;
    public final long zzj;
    public final String zzk;
    public final long zzl;
    public final long zzm;
    public final int zzn;
    public final boolean zzo;
    public final boolean zzp;
    public final String zzq;
    public final Boolean zzr;
    public final long zzs;
    public final List zzt;
    public final String zzu;
    public final String zzv;

    static {
        zzq zzq2 = new zzq();
        CREATOR = zzq2;
    }

    public zzp(String string2, String string3, String string4, long l10, String string5, long l11, long l12, String string6, boolean n10, boolean n11, String string7, long l13, long l14, int n12, boolean bl2, boolean bl3, String string8, Boolean bl4, long l15, List list, String string9, String string10) {
        zzp zzp2 = this;
        Preconditions.checkNotEmpty(string2);
        Object object = string2;
        this.zza = string2;
        int n13 = TextUtils.isEmpty((CharSequence)string3);
        int n14 = 1;
        if (n14 != n13) {
            object = string3;
        } else {
            n13 = 0;
            object = null;
        }
        zzp2.zzb = object;
        object = string4;
        zzp2.zzc = string4;
        zzp2.zzj = l10;
        object = string5;
        zzp2.zzd = string5;
        zzp2.zze = l11;
        zzp2.zzf = l12;
        object = string6;
        zzp2.zzg = string6;
        n13 = n10;
        zzp2.zzh = n10;
        n13 = n11;
        zzp2.zzi = n11;
        object = string7;
        zzp2.zzk = string7;
        zzp2.zzl = l13;
        zzp2.zzm = l14;
        n13 = n12;
        zzp2.zzn = n12;
        n13 = (int)(bl2 ? 1 : 0);
        zzp2.zzo = bl2;
        n13 = (int)(bl3 ? 1 : 0);
        zzp2.zzp = bl3;
        object = string8;
        zzp2.zzq = string8;
        object = bl4;
        zzp2.zzr = bl4;
        zzp2.zzs = l15;
        object = list;
        zzp2.zzt = list;
        object = string9;
        zzp2.zzu = string9;
        object = string10;
        zzp2.zzv = string10;
    }

    public zzp(String string2, String string3, String string4, String string5, long l10, long l11, String string6, boolean bl2, boolean bl3, long l12, String string7, long l13, long l14, int n10, boolean bl4, boolean bl5, String string8, Boolean bl6, long l15, List list, String string9, String string10) {
        this.zza = string2;
        this.zzb = string3;
        this.zzc = string4;
        this.zzj = l12;
        this.zzd = string5;
        this.zze = l10;
        this.zzf = l11;
        this.zzg = string6;
        this.zzh = bl2;
        this.zzi = bl3;
        this.zzk = string7;
        this.zzl = l13;
        this.zzm = l14;
        this.zzn = n10;
        this.zzo = bl4;
        this.zzp = bl5;
        this.zzq = string8;
        this.zzr = bl6;
        this.zzs = l15;
        this.zzt = list;
        this.zzu = string9;
        this.zzv = string10;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.zza;
        SafeParcelWriter.writeString(parcel, 2, (String)object, false);
        object = this.zzb;
        SafeParcelWriter.writeString(parcel, 3, (String)object, false);
        object = this.zzc;
        SafeParcelWriter.writeString(parcel, 4, (String)object, false);
        object = this.zzd;
        SafeParcelWriter.writeString(parcel, 5, (String)object, false);
        long l10 = this.zze;
        SafeParcelWriter.writeLong(parcel, 6, l10);
        l10 = this.zzf;
        SafeParcelWriter.writeLong(parcel, 7, l10);
        object = this.zzg;
        SafeParcelWriter.writeString(parcel, 8, (String)object, false);
        boolean bl2 = this.zzh;
        SafeParcelWriter.writeBoolean(parcel, 9, bl2);
        boolean bl3 = this.zzi;
        SafeParcelWriter.writeBoolean(parcel, 10, bl3);
        l10 = this.zzj;
        SafeParcelWriter.writeLong(parcel, 11, l10);
        object = this.zzk;
        SafeParcelWriter.writeString(parcel, 12, (String)object, false);
        l10 = this.zzl;
        SafeParcelWriter.writeLong(parcel, 13, l10);
        l10 = this.zzm;
        SafeParcelWriter.writeLong(parcel, 14, l10);
        int n11 = this.zzn;
        SafeParcelWriter.writeInt(parcel, 15, n11);
        boolean bl4 = this.zzo;
        SafeParcelWriter.writeBoolean(parcel, 16, bl4);
        boolean bl5 = this.zzp;
        SafeParcelWriter.writeBoolean(parcel, 18, bl5);
        object = this.zzq;
        SafeParcelWriter.writeString(parcel, 19, (String)object, false);
        object = this.zzr;
        SafeParcelWriter.writeBooleanObject(parcel, 21, (Boolean)object, false);
        l10 = this.zzs;
        SafeParcelWriter.writeLong(parcel, 22, l10);
        object = this.zzt;
        SafeParcelWriter.writeStringList(parcel, 23, (List)object, false);
        object = this.zzu;
        SafeParcelWriter.writeString(parcel, 24, (String)object, false);
        object = this.zzv;
        SafeParcelWriter.writeString(parcel, 25, (String)object, false);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

