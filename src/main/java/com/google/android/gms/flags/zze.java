/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 */
package com.google.android.gms.flags;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.flags.zzc;
import com.google.android.gms.internal.flags.zza;

public final class zze
extends zza
implements zzc {
    public zze(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.flags.IFlagProvider");
    }

    public final boolean getBooleanFlagValue(String string2, boolean bl2, int n10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        com.google.android.gms.internal.flags.zzc.writeBoolean(parcel, bl2);
        parcel.writeInt(n10);
        string2 = this.zza(2, parcel);
        bl2 = com.google.android.gms.internal.flags.zzc.zza((Parcel)string2);
        string2.recycle();
        return bl2;
    }

    public final int getIntFlagValue(String string2, int n10, int n11) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeInt(n10);
        parcel.writeInt(n11);
        string2 = this.zza(3, parcel);
        n10 = string2.readInt();
        string2.recycle();
        return n10;
    }

    public final long getLongFlagValue(String string2, long l10, int n10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeLong(l10);
        parcel.writeInt(n10);
        string2 = this.zza(4, parcel);
        l10 = string2.readLong();
        string2.recycle();
        return l10;
    }

    public final String getStringFlagValue(String string2, String string3, int n10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        parcel.writeInt(n10);
        string2 = this.zza(5, parcel);
        string3 = string2.readString();
        string2.recycle();
        return string3;
    }

    public final void init(IObjectWrapper iObjectWrapper) {
        Parcel parcel = this.zza();
        com.google.android.gms.internal.flags.zzc.zza(parcel, iObjectWrapper);
        this.zzb(1, parcel);
    }
}

