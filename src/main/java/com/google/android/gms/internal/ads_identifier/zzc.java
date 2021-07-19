/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Parcel
 */
package com.google.android.gms.internal.ads_identifier;

import android.os.Parcel;

public class zzc {
    private static final ClassLoader zzd = zzc.class.getClassLoader();

    private zzc() {
    }

    public static void zza(Parcel parcel, boolean bl2) {
        parcel.writeInt(1);
    }

    public static boolean zza(Parcel parcel) {
        int n10 = parcel.readInt();
        return n10 != 0;
    }
}

