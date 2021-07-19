/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.google.android.gms.internal.vision;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.vision.zzc;

public class zza
extends Binder
implements IInterface {
    private static zzc zza;

    public zza(String string2) {
        this.attachInterface(this, string2);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean onTransact(int n10, Parcel parcel, Parcel parcel2, int n11) {
        int n12 = 0xFFFFFF;
        if (n10 > n12) {
            n12 = (int)(super.onTransact(n10, parcel, parcel2, n11) ? 1 : 0);
        } else {
            String string2 = this.getInterfaceDescriptor();
            parcel.enforceInterface(string2);
            n12 = 0;
            string2 = null;
        }
        if (n12 != 0) {
            return true;
        }
        return this.zza(n10, parcel, parcel2, n11);
    }

    public boolean zza(int n10, Parcel parcel, Parcel parcel2, int n11) {
        return false;
    }
}

