/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.measurement;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public final class zzc {
    private static final ClassLoader zza = zzc.class.getClassLoader();

    private zzc() {
    }

    public static boolean zza(Parcel parcel) {
        int n10 = parcel.readInt();
        return n10 != 0;
    }

    public static void zzb(Parcel parcel, boolean bl2) {
        parcel.writeInt((int)(bl2 ? 1 : 0));
    }

    public static Parcelable zzc(Parcel parcel, Parcelable.Creator creator) {
        int n10 = parcel.readInt();
        if (n10 == 0) {
            return null;
        }
        return (Parcelable)creator.createFromParcel(parcel);
    }

    public static void zzd(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }

    public static void zze(Parcel parcel, IInterface iInterface) {
        if (iInterface == null) {
            parcel.writeStrongBinder(null);
            return;
        }
        iInterface = iInterface.asBinder();
        parcel.writeStrongBinder((IBinder)iInterface);
    }

    public static HashMap zzf(Parcel parcel) {
        ClassLoader classLoader = zza;
        return parcel.readHashMap(classLoader);
    }
}

