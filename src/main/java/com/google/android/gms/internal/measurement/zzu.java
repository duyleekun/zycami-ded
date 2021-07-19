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
import com.google.android.gms.internal.measurement.zzv;

public abstract class zzu
extends zzb
implements zzv {
    public zzu() {
        super("com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                return false;
            }
            n10 = this.zze();
            parcel2.writeNoException();
            parcel2.writeInt(n10);
        } else {
            String string2 = parcel.readString();
            String string3 = parcel.readString();
            Parcelable.Creator creator = Bundle.CREATOR;
            Parcelable.Creator creator2 = creator = zzc.zzc(parcel, creator);
            creator2 = (Bundle)creator;
            long l10 = parcel.readLong();
            this.zzd(string2, string3, (Bundle)creator2, l10);
            parcel2.writeNoException();
        }
        return n11 != 0;
    }
}

