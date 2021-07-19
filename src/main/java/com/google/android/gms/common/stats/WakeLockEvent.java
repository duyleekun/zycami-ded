/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.text.TextUtils
 */
package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.stats.StatsEvent;
import com.google.android.gms.common.stats.zzb;
import java.util.List;

public final class WakeLockEvent
extends StatsEvent {
    public static final Parcelable.Creator CREATOR;
    private final int zza;
    private final long zzb;
    private int zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final int zzg;
    private final List zzh;
    private final String zzi;
    private final long zzj;
    private int zzk;
    private final String zzl;
    private final float zzm;
    private final long zzn;
    private final boolean zzo;
    private long zzp;

    static {
        zzb zzb2 = new zzb();
        CREATOR = zzb2;
    }

    public WakeLockEvent(int n10, long l10, int n11, String string2, int n12, List list, String string3, long l11, int n13, String string4, String string5, float f10, long l12, String string6, boolean bl2) {
        this.zza = n10;
        this.zzb = l10;
        this.zzc = n11;
        this.zzd = string2;
        this.zze = string4;
        this.zzf = string6;
        this.zzg = n12;
        this.zzp = -1;
        this.zzh = list;
        this.zzi = string3;
        this.zzj = l11;
        this.zzk = n13;
        this.zzl = string5;
        this.zzm = f10;
        this.zzn = l12;
        this.zzo = bl2;
    }

    public WakeLockEvent(long l10, int n10, String string2, int n11, List list, String string3, long l11, int n12, String string4, String string5, float f10, long l12, String string6, boolean bl2) {
        this(2, l10, n10, string2, n11, list, string3, l11, n12, string4, string5, f10, l12, string6, bl2);
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        int bl2 = this.zza;
        SafeParcelWriter.writeInt(parcel, 1, bl2);
        long l10 = ((StatsEvent)this).zza();
        SafeParcelWriter.writeLong(parcel, 2, l10);
        Object object = this.zzd;
        SafeParcelWriter.writeString(parcel, 4, (String)object, false);
        int n11 = this.zzg;
        SafeParcelWriter.writeInt(parcel, 5, n11);
        object = this.zzh;
        SafeParcelWriter.writeStringList(parcel, 6, (List)object, false);
        l10 = this.zzj;
        SafeParcelWriter.writeLong(parcel, 8, l10);
        object = this.zze;
        SafeParcelWriter.writeString(parcel, 10, (String)object, false);
        int n12 = ((StatsEvent)this).zzb();
        SafeParcelWriter.writeInt(parcel, 11, n12);
        object = this.zzi;
        SafeParcelWriter.writeString(parcel, 12, (String)object, false);
        object = this.zzl;
        SafeParcelWriter.writeString(parcel, 13, (String)object, false);
        int n13 = this.zzk;
        SafeParcelWriter.writeInt(parcel, 14, n13);
        float f10 = this.zzm;
        SafeParcelWriter.writeFloat(parcel, 15, f10);
        l10 = this.zzn;
        SafeParcelWriter.writeLong(parcel, 16, l10);
        object = this.zzf;
        SafeParcelWriter.writeString(parcel, 17, (String)object, false);
        boolean bl3 = this.zzo;
        SafeParcelWriter.writeBoolean(parcel, 18, bl3);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }

    public final long zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzc;
    }

    public final long zzc() {
        return this.zzp;
    }

    public final String zzd() {
        String string2;
        String string3 = this.zzd;
        int n10 = this.zzg;
        Object object = this.zzh;
        String string4 = "";
        if (object == null) {
            object = string4;
        } else {
            String string5 = ",";
            object = TextUtils.join((CharSequence)string5, (Iterable)object);
        }
        int n11 = this.zzk;
        String string6 = this.zze;
        if (string6 == null) {
            string6 = string4;
        }
        if ((string2 = this.zzl) == null) {
            string2 = string4;
        }
        float f10 = this.zzm;
        String string7 = this.zzf;
        if (string7 != null) {
            string4 = string7;
        }
        boolean bl2 = this.zzo;
        int n12 = String.valueOf(string3).length() + 51;
        int n13 = String.valueOf(object).length();
        n12 += n13;
        n13 = String.valueOf(string6).length();
        n12 += n13;
        n13 = String.valueOf(string2).length();
        n12 += n13;
        n13 = String.valueOf(string4).length();
        StringBuilder stringBuilder = new StringBuilder(n12 += n13);
        String string8 = "\t";
        stringBuilder.append(string8);
        stringBuilder.append(string3);
        stringBuilder.append(string8);
        stringBuilder.append(n10);
        stringBuilder.append(string8);
        stringBuilder.append((String)object);
        stringBuilder.append(string8);
        stringBuilder.append(n11);
        stringBuilder.append(string8);
        stringBuilder.append(string6);
        stringBuilder.append(string8);
        stringBuilder.append(string2);
        stringBuilder.append(string8);
        stringBuilder.append(f10);
        stringBuilder.append(string8);
        stringBuilder.append(string4);
        stringBuilder.append(string8);
        stringBuilder.append(bl2);
        return stringBuilder.toString();
    }
}

