/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 *  android.util.Log
 */
package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.zzn;
import com.google.android.gms.common.zzd;
import com.google.android.gms.common.zzg;
import com.google.android.gms.common.zzm;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.common.zza;

public final class zzj
extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    private final String zza;
    private final zzd zzb;
    private final boolean zzc;
    private final boolean zzd;

    static {
        zzm zzm2 = new zzm();
        CREATOR = zzm2;
    }

    public zzj(String object, IBinder iBinder, boolean bl2, boolean bl3) {
        this.zza = object;
        this.zzb = object = zzj.zza(iBinder);
        this.zzc = bl2;
        this.zzd = bl3;
    }

    public zzj(String string2, zzd zzd2, boolean bl2, boolean bl3) {
        this.zza = string2;
        this.zzb = zzd2;
        this.zzc = bl2;
        this.zzd = bl3;
    }

    private static zzd zza(IBinder object) {
        String string2 = "Could not unwrap certificate";
        String string3 = "GoogleCertificatesQuery";
        zzg zzg2 = null;
        if (object == null) {
            return null;
        }
        try {
            object = zzn.zza(object);
        }
        catch (RemoteException remoteException) {
            Log.e((String)string3, (String)string2, (Throwable)remoteException);
            return null;
        }
        object = object.zzb();
        object = object == null ? null : (Object)((byte[])ObjectWrapper.unwrap((IObjectWrapper)object));
        if (object != null) {
            zzg2 = new zzg((byte[])object);
        } else {
            Log.e((String)string3, (String)string2);
        }
        return zzg2;
    }

    public final void writeToParcel(Parcel parcel, int n10) {
        n10 = SafeParcelWriter.beginObjectHeader(parcel);
        Object object = this.zza;
        boolean bl2 = true;
        SafeParcelWriter.writeString(parcel, (int)(bl2 ? 1 : 0), (String)object, false);
        object = this.zzb;
        if (object == null) {
            String string2 = "certificate binder is null";
            Log.w((String)"GoogleCertificatesQuery", (String)string2);
            object = null;
        } else {
            object = ((zza)((Object)object)).asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 2, (IBinder)object, false);
        bl2 = this.zzc;
        SafeParcelWriter.writeBoolean(parcel, 3, bl2);
        bl2 = this.zzd;
        SafeParcelWriter.writeBoolean(parcel, 4, bl2);
        SafeParcelWriter.finishObjectHeader(parcel, n10);
    }
}

