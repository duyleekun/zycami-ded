/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.google.android.gms.internal.flags;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.flags.zzd;

public class zzb
extends Binder
implements IInterface {
    private static zzd zzc;

    public zzb(String string2) {
        this.attachInterface(this, string2);
    }

    public IBinder asBinder() {
        return this;
    }

    public boolean dispatchTransaction(int n10, Parcel parcel, Parcel parcel2, int n11) {
        return false;
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
        return this.dispatchTransaction(n10, parcel, parcel2, n11);
    }
}

