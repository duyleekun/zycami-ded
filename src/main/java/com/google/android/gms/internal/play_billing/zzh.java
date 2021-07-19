/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.play_billing;

import android.os.Parcel;
import android.os.Parcelable;

public class zzh {
    private static final ClassLoader zza = zzh.class.getClassLoader();

    private zzh() {
    }

    public static Parcelable zza(Parcel parcel, Parcelable.Creator creator) {
        int n10 = parcel.readInt();
        if (n10 == 0) {
            return null;
        }
        return (Parcelable)creator.createFromParcel(parcel);
    }

    public static void zza(Parcel parcel, Parcelable parcelable) {
        if (parcelable == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcelable.writeToParcel(parcel, 0);
    }
}

