/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.internal.measurement.zzb;
import com.google.android.gms.internal.measurement.zzc;
import com.google.android.gms.internal.measurement.zzs;

public abstract class zzr
extends zzb
implements zzs {
    public zzr() {
        super("com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    public final boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        n11 = 1;
        if (n10 == n11) {
            Parcelable.Creator creator = Bundle.CREATOR;
            creator = (Bundle)zzc.zzc(parcel, creator);
            this.zzb((Bundle)creator);
            parcel2.writeNoException();
            return n11 != 0;
        }
        return false;
    }
}

