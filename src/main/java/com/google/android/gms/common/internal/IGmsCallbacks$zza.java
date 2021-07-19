/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.Parcel
 *  android.os.Parcelable$Creator
 */
package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.IGmsCallbacks;
import com.google.android.gms.common.internal.zzc;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzd;

public abstract class IGmsCallbacks$zza
extends zza
implements IGmsCallbacks {
    public IGmsCallbacks$zza() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    public final boolean zza(int n10, Parcel object, Parcel parcel, int n11) {
        n11 = 1;
        if (n10 != n11) {
            int n12 = 2;
            if (n10 != n12) {
                n12 = 3;
                if (n10 != n12) {
                    return false;
                }
                n10 = object.readInt();
                IBinder iBinder = object.readStrongBinder();
                Parcelable.Creator creator = zzc.CREATOR;
                object = (zzc)zzd.zza(object, creator);
                this.zza(n10, iBinder, (zzc)object);
            } else {
                n10 = object.readInt();
                Parcelable.Creator creator = Bundle.CREATOR;
                object = (Bundle)zzd.zza(object, creator);
                this.zza(n10, (Bundle)object);
            }
        } else {
            n10 = object.readInt();
            IBinder iBinder = object.readStrongBinder();
            Parcelable.Creator creator = Bundle.CREATOR;
            object = (Bundle)zzd.zza(object, creator);
            this.onPostInitComplete(n10, iBinder, (Bundle)object);
        }
        parcel.writeNoException();
        return n11 != 0;
    }
}

