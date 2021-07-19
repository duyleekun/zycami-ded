/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 */
package com.xiaomi.push;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public final class j$c
implements IInterface {
    private IBinder a;

    public j$c(IBinder iBinder) {
        this.a = iBinder;
    }

    public String a() {
        Parcel parcel = Parcel.obtain();
        Parcel parcel2 = Parcel.obtain();
        String string2 = "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService";
        try {
            parcel.writeInterfaceToken(string2);
            string2 = this.a;
            int n10 = 1;
            string2.transact(n10, parcel, parcel2, 0);
            parcel2.readException();
            string2 = parcel2.readString();
            return string2;
        }
        finally {
            parcel2.recycle();
            parcel.recycle();
        }
    }

    public IBinder asBinder() {
        return this.a;
    }
}

