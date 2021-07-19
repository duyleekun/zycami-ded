/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zza;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzv;

public final class zzt
extends zza
implements zzv {
    public zzt(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final void zzd(String string2, String string3, Bundle bundle, long l10) {
        Parcel parcel = this.zza();
        parcel.writeString(string2);
        parcel.writeString(string3);
        zzc.zzd(parcel, (Parcelable)bundle);
        parcel.writeLong(l10);
        this.zzc(1, parcel);
    }

    public final int zze() {
        Parcel parcel = this.zza();
        parcel = this.zzz(2, parcel);
        int n10 = parcel.readInt();
        parcel.recycle();
        return n10;
    }
}

